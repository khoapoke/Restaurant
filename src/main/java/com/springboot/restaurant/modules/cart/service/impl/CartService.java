package com.springboot.restaurant.modules.cart.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.restaurant.exception.AppException;
import com.springboot.restaurant.exception.ErrorCode;
import com.springboot.restaurant.modules.cart.dto.request.CartCreateRequest;
import com.springboot.restaurant.modules.cart.dto.request.CartItemCreateRequest;
import com.springboot.restaurant.modules.cart.dto.request.CartItemUpdateRequest;
import com.springboot.restaurant.modules.cart.dto.response.CartDetailResponse;
import com.springboot.restaurant.modules.cart.dto.response.CartItemResponse;
import com.springboot.restaurant.modules.cart.dto.response.CartResponse;
import com.springboot.restaurant.modules.cart.entity.Cart;
import com.springboot.restaurant.modules.cart.entity.CartDetail;
import com.springboot.restaurant.modules.cart.entity.CartDetailId;
import com.springboot.restaurant.modules.cart.mapper.CartItemMapper;
import com.springboot.restaurant.modules.cart.mapper.CartMapper;
import com.springboot.restaurant.modules.cart.repository.CartItemRepository;
import com.springboot.restaurant.modules.cart.repository.CartRepository;
import com.springboot.restaurant.modules.cart.service.interfaces.CartServiceInterface;
import com.springboot.restaurant.modules.menu.entity.Food;
import com.springboot.restaurant.modules.menu.repository.FoodRepository;
import com.springboot.restaurant.modules.user.entity.Account;
import com.springboot.restaurant.modules.user.service.interfaces.AccountFacadeServiceInterface;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Service
@AllArgsConstructor
@Getter
public class CartService implements CartServiceInterface {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final FoodRepository foodRepository;
    private final CartItemMapper cartItemMapper;
    private final CartMapper cartMapper;
    private final AccountFacadeServiceInterface accountFacadeService;

@Override 
    public Cart findCartById(Long maGioHang){
        return cartRepository.findById(maGioHang).orElseThrow(() -> new AppException(ErrorCode.CART_NOT_FOUND));
    }

    @Override
    public CartDetailResponse getCart(Long maGioHang) {

        Cart cart = findCartById(maGioHang);

        CartDetailResponse response = cartMapper.toCartDetailResponse(cart);

        return response;

    }

    @Override
    public List<CartResponse> getCarts() {

        return cartRepository.findAll()
                .stream()
                .map(cartMapper::toCartResponse)
                .toList();

    }

    @Override
    @Transactional 
    public CartItemResponse addCartItem(CartItemCreateRequest request, Long maGioHang) {

        Cart cart = findCartById(maGioHang);
        Food food = foodRepository.findById(request.getMaMonAn())
                .orElseThrow(() -> new AppException(ErrorCode.FOOD_NOT_FOUND));
        CartDetailId cartDetailId = new CartDetailId(maGioHang, request.getMaMonAn());

        CartDetail cartDetail = cartItemRepository.findById(cartDetailId).orElse(null);
        if (cartDetail != null) {
            cartDetail.setSoLuong(cartDetail.getSoLuong() + request.getSoLuong());
        } else {
            cartDetail = cartMapper.toEntityCartDetail(request);
            cartDetail.setCartDetailId(cartDetailId);
            cartDetail.setMonAn(food);
            cart.addCartitem(cartDetail);
        }

        return cartItemMapper.toCartItemResponse(cartDetail);

    }

    @Override
    @Transactional
    public CartItemResponse updateCartItem(
            CartItemUpdateRequest request, Long maGioHang, Long maMonAn) {
        CartDetailId cartDetailId = new CartDetailId(maGioHang, maMonAn);
        CartDetail cartDetail = cartItemRepository.findById(cartDetailId)
                .orElseThrow(() -> new AppException(ErrorCode.ITEM_CART_NOT_EXISTED));

        cartDetail.setSoLuong(request.getSoLuong());
        return cartItemMapper.toCartItemResponse(cartDetail);
    }

    @Override
    @Transactional
    public void removeCartItem(Long maGiohang, Long maMonAn) {
        CartDetailId cartDetailId= new CartDetailId(maGiohang,maMonAn);
      
        CartDetail cartDetail=cartItemRepository.findById(cartDetailId).orElseThrow(()->new AppException(ErrorCode.ITEM_CART_NOT_EXISTED));
        Cart cart=cartDetail.getGioHang();
        cart.removeCartItem(cartDetail);
    }

    @Override
    @Transactional 
    public CartResponse createCart(CartCreateRequest request) {

        // 1. Nhờ Mapper tạo Entity cơ bản
        Cart cart = cartMapper.toEntityCart(request);
        // 2. dùng service account facade để lấy mã tài khoản mức referance 
        Account taiKhoan = accountFacadeService.getAccountReference(request.getMaTaiKhoan());
        // 3. Service tiến hành lắp ghép
        cart.setTaiKhoan(taiKhoan);
        cart = cartRepository.save(cart);

        return cartMapper.toCartResponse(cart);
    }

    @Override
    @Transactional
    public void removeCart(Long maGiohang) {
        Cart cart = findCartById(maGiohang); 
        cartRepository.delete(cart);
    }

}
