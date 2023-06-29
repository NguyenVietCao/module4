package com.example.ss11.service;

public interface ICartService {
    //    Phương thức checkIntemInCart() để kiểm tra xem sản phẩm đó đã có trong giỏ hàng hay chưa
    void checkIntemInCart();

    //    Phương thức addProduct() được sử dụng để thêm sản phẩm vào trong giỏ hàng.
    void addProduct();

    //    Phương thức countProductQuantity() dùng để đếm số lượng sản phẩm đó hiện có trong giỏ hàng.
    void countProductQuantity();

    //    Phương thức countItemQuantity() để đếm số lượng sản phẩm có trong giỏ hàng.
    void countItemQuantity();

    //    Phương thức countTotalPayment() dùng để tính tổng số tiền cần phải thanh toán.
    void countTotalPayment();
}
