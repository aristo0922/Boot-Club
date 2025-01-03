package com.study.techeer.Boot_Club.order;

import com.study.techeer.Boot_Club.AppConfig;
import com.study.techeer.Boot_Club.member.Grade;
import com.study.techeer.Boot_Club.member.Member;
import com.study.techeer.Boot_Club.member.MemberService;
import com.study.techeer.Boot_Club.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
  MemberService memberService;
  OrderService orderService ;
  @BeforeEach
  public void beforeEach(){
    AppConfig appConfig = new AppConfig();
    memberService = appConfig.memberService();
    orderService = appConfig.orderService();
  }
  @Test
  void createOrder(){
    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "itemA", 10000);
    Assertions.assertThat(order.getDiscountPrice()).isEqualTo(9000);
  }

//  @Test
//  void fieldInjectionTest(){
//    OrderService service = new OrderServiceImpl();
//    orderService.createOrder(1L, "itemA", 1000);
//  }

}
