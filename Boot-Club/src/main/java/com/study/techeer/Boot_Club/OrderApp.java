package com.study.techeer.Boot_Club;

import com.study.techeer.Boot_Club.member.Grade;
import com.study.techeer.Boot_Club.member.Member;
import com.study.techeer.Boot_Club.member.MemberService;
import com.study.techeer.Boot_Club.order.Order;
import com.study.techeer.Boot_Club.order.OrderService;

public class OrderApp {

  public static void main(String[] args) {
    AppConfig appConfig = new AppConfig();

    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "itemA", 10000);
    System.out.println("order : "+order);
    System.out.println("order calculate price : "+order.calculatePrice());

  }

}
