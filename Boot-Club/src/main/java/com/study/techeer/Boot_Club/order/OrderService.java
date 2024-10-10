package com.study.techeer.Boot_Club.order;

public interface OrderService {
  Order createOrder(Long memberId, String itemName, int itemPrice);
}
