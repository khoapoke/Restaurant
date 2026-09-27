package com.springboot.restaurant;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PractiseList {

    // Model dùng cho bài tập
    public record Order(Long id,
            String customerName,
            Double totalAmount,
            String status,
            List<String> items) {
    }

    public record Product(Long id,
            String name,
            String category,
            Double price,
            Boolean inStock) {
    }

    public static void main(String[] args) {

        // Dữ liệu mẫu (Sample Data)
        List<Product> products = List.of(
                new Product(1L, "iPhone 15", "Electronics", 999.0, true),
                new Product(2L, "MacBook Pro", "Electronics", 1999.0, false),
                new Product(3L, "Nike Pegasus", "Footwear", 120.0, true),
                new Product(4L, "Adidas Ultraboost", "Footwear", 180.0, true),
                new Product(5L, "Logitech Mouse", "Electronics", 50.0, true));

        List<Order> orders = List.of(
                new Order(101L, "Alice", 250.0, "COMPLETED", List.of("Mouse", "Keyboard")),
                new Order(102L, "Bob", 1200.0, "PENDING", List.of("iPhone")),
                new Order(103L, "Alice", 450.0, "COMPLETED", List.of("Monitor")),
                new Order(104L, "Charlie", 150.0, "CANCELLED", List.of("Headphones")));

        List<String> b1 = products.stream().filter(p -> p.inStock == true && p.category == "Electronics")
                .map(p -> p.name.toUpperCase()).toList();

        List<String> b2 = orders.stream().filter(o -> o.status == "COMPLETED").flatMap(o -> o.items.stream()).toList();

        Map<String, List<Product>> b3 = products.stream().collect(Collectors.groupingBy(p -> p.category()));

        Map<String, Double> b3_1 = orders.stream()
                .collect(Collectors.groupingBy(o -> o.status(), Collectors.summingDouble(o -> o.totalAmount)));

        Map<Long, Product> b4 = products.stream().collect(Collectors.toMap(p -> p.id, p -> p));

        Map<String, Product> b4_1 = products.stream()
                .collect(Collectors.toMap(p -> p.category, p -> p, (a, b) -> a.price > b.price ? a : b));

        System.out.println("bai 1");
        b1.forEach(System.out::println);
        System.out.println("bai 2");
        b2.forEach(System.out::println);
        System.out.println("bai 3");
        b3.forEach((cate, list) -> {
            System.out.println(cate);
            list.forEach(System.out::println);

        });
        b3_1.forEach((cate, total) -> {
            System.out.println(cate);
            System.out.println(total);

        });
        System.out.println("bai 4");
        b4.forEach((id, product) -> {
            System.out.println(id);
            System.out.println(product);
        });

        b4_1.forEach((cate, product) -> {
            System.out.println(cate);
            System.out.println(product);
        });
    }

}
