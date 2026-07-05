# Cấu trúc thư mục Spring Boot đề xuất — Modular Monolith (Package by Feature)

Đây là bản tổng hợp \& cải tiến từ 2 cấu trúc đã thảo luận trước, kết hợp ưu điểm của cả `package-by-layer` (SOLID rõ ràng trong từng tầng) và `package-by-feature` (dễ scale, dễ maintain theo nghiệp vụ).

## 1\. Cấu trúc tổng thể

```
src/main/java/com/company/project/
│
├── ProjectApplication.java
│
├── config/                              # Cấu hình toàn hệ thống
│   ├── SecurityConfig.java
│   ├── SwaggerConfig.java
│   ├── WebMvcConfig.java
│   ├── JacksonConfig.java
│   └── AsyncConfig.java
│
├── exception/                           # Xử lý lỗi tập trung
│   ├── GlobalExceptionHandler.java
│   ├── BusinessException.java
│   ├── ResourceNotFoundException.java
│   └── ErrorCode.java
│
├── shared/                              # Thành phần dùng chung CHO NHIỀU MODULE
│   ├── base/
│   │   ├── BaseEntity.java              # id, createdAt, updatedAt
│   │   └── BaseResponse.java            # wrapper response chung
│   ├── constant/
│   │   └── AppConstants.java
│   ├── util/
│   │   ├── DateUtils.java
│   │   └── StringUtils.java
│   ├── security/
│   │   ├── JwtTokenProvider.java
│   │   ├── JwtAuthenticationFilter.java
│   │   └── CustomUserDetailsService.java
│   └── event/                           # Cơ chế giao tiếp giữa module (giải thích ở mục 4)
│       └── DomainEvent.java
│
└── modules/                             # TRUNG TÂM NGHIỆP VỤ
    │
    ├── user/
    │   ├── controller/
    │   │   └── UserController.java
    │   ├── dto/
    │   │   ├── request/
    │   │   │   ├── CreateUserRequest.java
    │   │   │   └── UpdateUserRequest.java
    │   │   └── response/
    │   │       └── UserResponse.java
    │   ├── entity/
    │   │   └── User.java
    │   ├── enums/
    │   │   └── UserStatus.java
    │   ├── mapper/
    │   │   └── UserMapper.java
    │   ├── repository/
    │   │   └── UserRepository.java
    │   └── service/
    │       ├── UserService.java         # interface — public contract của module
    │       └── impl/
    │           └── UserServiceImpl.java
    │
    ├── order/
    │   ├── controller/
    │   ├── dto/
    │   ├── entity/
    │   ├── enums/
    │   ├── mapper/
    │   ├── repository/
    │   └── service/
    │       └── impl/
    │
    └── payment/
        ├── controller/
        ├── dto/
        ├── entity/
        ├── mapper/
        ├── repository/
        ├── service/
        │   └── impl/
        └── strategy/                    # Design pattern riêng của module này
            ├── PaymentStrategy.java
            └── impl/
                ├── CreditCardPaymentStrategy.java
                └── MomoPaymentStrategy.java
```

\---

## 2\. Vì sao đây là bản cải tiến tốt nhất (cho đa số dự án thực tế)

### So với `package-by-layer` (bản đầu tiên)

* Mở `modules/order/` ra là thấy toàn bộ nghiệp vụ Order — không phải lục tung 5 thư mục khác nhau.
* Dễ giao việc cho từng dev/team theo module, ít đụng code nhau.
* Dễ tách thành microservice sau này nếu cần (chỉ cần "bốc" cả module ra).

### So với cấu trúc `modules/` thuần (bản thứ hai)

* Thêm `shared/event/` để xử lý **circular dependency giữa module** (vấn đề thực tế hay gặp nhất khi mới áp dụng package-by-feature — giải thích chi tiết ở mục 4).
* Thêm `enums/` riêng trong từng module — enum thuộc về nghiệp vụ nào thì nằm trong module đó, không bị lẫn vào `shared/`.
* `strategy/`, `factory/` (design pattern) đặt **trong module cần nó**, không đặt ở gốc dùng chung — vì `PaymentStrategy` chỉ payment module cần, để ở gốc sẽ gây hiểu nhầm là dùng chung toàn hệ thống.
* `exception/` tách riêng khỏi `shared/` vì nó liên quan đến tầng cross-cutting (Controller Advice), không phải logic nghiệp vụ dùng lại.

\---

## 3\. Chi tiết module mẫu — `user`

```java
// entity/User.java
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {
    private String email;
    private String passwordHash;
    @Enumerated(EnumType.STRING)
    private UserStatus status;
}
```

```java
// repository/UserRepository.java
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
```

```java
// service/UserService.java — PUBLIC CONTRACT của module (chỉ method này module khác được gọi)
public interface UserService {
    UserResponse getById(Long id);
    UserResponse create(CreateUserRequest request);
}
```

```java
// service/impl/UserServiceImpl.java
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return userMapper.toResponse(user);
    }

    @Override
    public UserResponse create(CreateUserRequest request) {
        User user = userMapper.toEntity(request);
        return userMapper.toResponse(userRepository.save(user));
    }
}
```

```java
// controller/UserController.java
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;   // phụ thuộc interface, không phụ thuộc Impl

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }
}
```

\---

## 4\. Quy tắc giao tiếp giữa các module (QUAN TRỌNG NHẤT)

Đây là phần dễ làm sai nhất khi mới chuyển sang `package-by-feature`. Nếu không có quy tắc rõ, code sẽ rối hơn cả package-by-layer.

### Quy tắc bắt buộc

> \*\*Module A chỉ được gọi vào `service` (interface) của module B. Tuyệt đối không gọi trực tiếp vào `repository` hoặc `entity` của module B.\*\*

```java
// ❌ SAI — Order module gọi trực tiếp vào Repository của User module
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final UserRepository userRepository;   // ❌ phá vỡ ranh giới module

    public OrderResponse createOrder(CreateOrderRequest req) {
        User user = userRepository.findById(req.getUserId())...
    }
}
```

```java
// ✅ ĐÚNG — Order module chỉ gọi vào Service interface (public contract) của User module
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final UserService userService;   // ✅ chỉ biết "cái gì", không biết "lưu DB thế nào"

    public OrderResponse createOrder(CreateOrderRequest req) {
        UserResponse user = userService.getById(req.getUserId());
        // ...
    }
}
```

### Xử lý circular dependency giữa 2 module

Tình huống: `order` cần biết thông tin `user`, nhưng `user` cũng cần biết lịch sử đơn hàng của `order` → vòng lặp phụ thuộc.

**Cách xử lý — dùng Event (Spring `ApplicationEventPublisher`)** thay vì gọi trực tiếp qua lại:

```java
// shared/event/DomainEvent.java
public abstract class DomainEvent { }

// modules/order/event/OrderCreatedEvent.java
public class OrderCreatedEvent extends DomainEvent {
    private final Long userId;
    private final Long orderId;
}
```

```java
// OrderServiceImpl chỉ publish event, không gọi trực tiếp sang module user
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final ApplicationEventPublisher eventPublisher;

    public OrderResponse createOrder(CreateOrderRequest req) {
        Order order = ...;
        eventPublisher.publishEvent(new OrderCreatedEvent(req.getUserId(), order.getId()));
        return ...;
    }
}
```

```java
// modules/user/listener/OrderCreatedListener.java — User module tự lắng nghe, không bị Order module gọi ngược
@Component
@RequiredArgsConstructor
public class OrderCreatedListener {
    @EventListener
    public void handle(OrderCreatedEvent event) {
        // cập nhật lịch sử mua hàng của user
    }
}
```

→ Hai module không còn import lẫn nhau ở chiều ngược lại — đây chính là tinh thần của **Modular Monolith** thực sự, không chỉ là chia thư mục cho đẹp.

\---

## 5\. Checklist khi review code theo cấu trúc này

* \[ ] Controller không chứa logic nghiệp vụ, chỉ gọi `Service` interface.
* \[ ] Module A không import `repository` hoặc `entity` của module B.
* \[ ] Mọi giao tiếp giữa module đi qua `Service` interface hoặc `Event`.
* \[ ] `Entity` không bao giờ được trả thẳng ra `Controller` — luôn qua `Mapper` để thành DTO.
* \[ ] Design pattern riêng của 1 module (Strategy, Factory) đặt trong module đó, không đặt ở `shared/`.
* \[ ] `shared/` chỉ chứa thứ **thật sự** dùng bởi ≥ 2 module (BaseEntity, JWT, Util).

\---

## 6\. Kết luận

|Tiêu chí|Đánh giá|
|-|-|
|Tuân SOLID|✅ Đầy đủ — interface ở mọi tầng, dependency injection qua constructor|
|Dễ scale theo nghiệp vụ|✅ Tốt — mỗi module độc lập|
|Phù hợp dự án nhỏ/MVP|⚠️ Có thể hơi dư — với < 5 entity, package-by-layer đơn giản hơn|
|Phù hợp dự án vừa/lớn, nhiều team|✅ Rất phù hợp|
|Sẵn sàng tách microservice sau này|✅ Có, nhờ ranh giới module rõ + giao tiếp qua Event/Interface|

**Đây là cấu trúc nên dùng làm chuẩn mặc định** cho hầu hết dự án Spring Boot thực tế từ quy mô vừa trở lên. Với dự án nhỏ/học tập, có thể bỏ `shared/event/` và xử lý gọi trực tiếp qua Service interface cho đơn giản, nâng cấp dần khi project lớn lên.

