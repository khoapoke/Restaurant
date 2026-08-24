package com.springboot.restaurant.modules.cart.mapper;

import java.util.List;

import com.springboot.restaurant.modules.cart.dto.request.CartItemCreateRequest;
import com.springboot.restaurant.modules.cart.dto.response.CartItemResponse;
import com.springboot.restaurant.modules.cart.dto.response.CartResponse;
import com.springboot.restaurant.modules.cart.dto.response.CartDetailResponse;
import com.springboot.restaurant.modules.cart.entity.Cart;
import com.springboot.restaurant.modules.cart.entity.CartDetail;
import com.springboot.restaurant.modules.cart.entity.CartDetailId;

public class CartMapper {

    public Cart toEntityCart(CartItemCreateRequest request) {

        return null;

    }

    public CartDetail toEntityCartDetail(CartItemCreateRequest request) {
        
        CartDetail cartDetail = new CartDetail();
        CartDetailId cartDetailId = new CartDetailId();
        cartDetailId.setMaMonAn(request.getMaMonAn());
        cartDetail.setCartDetailId(cartDetailId);
        cartDetail.setSoLuong(request.getSoLuong());
        
        return cartDetail;
    }
 

    public CartResponse toCartResponse(Cart cart) {

        CartResponse response = new CartResponse();

        response.setMaGioHang(cart.getMaGioHang());
        response.setEmail(cart.getTaiKhoan().getEmail());
        response.setTenKhachHang(cart.getTaiKhoan().getHoTen());
        response.setNgayTao(cart.getNgayTao());

        return response;

    }

    public CartItemResponse toCartItemResponse(CartDetail cartDetail) {

        CartItemResponse response = new CartItemResponse();

        response.setMaMonAn(cartDetail.getMonAn().getMaMonAn());
        response.setTenMonAn(cartDetail.getMonAn().getTenMonAn());
        response.setDonGia(cartDetail.getDonGia());
        response.setSoLuong(cartDetail.getSoLuong());

        return response;
    }

    public CartDetailResponse toCartDetailResponse(Cart cart) {

        CartDetailResponse response = new CartDetailResponse();

        response.setMaGioHang(cart.getMaGioHang());
        response.setMaTaiKhoan(cart.getTaiKhoan().getMaTaiKhoan());
        response.setTenKhachHang(cart.getTaiKhoan().getHoTen());

        if (cart.getDanhSachChiTietGioHang() != null) {

            List<CartItemResponse> listCartItemResponse = cart.getDanhSachChiTietGioHang()
                    .stream()
                    .map(x -> toCartItemResponse(x))
                    .toList();
            response.setDanhSachMonAn(listCartItemResponse);
        }

        return response;

    }

}
