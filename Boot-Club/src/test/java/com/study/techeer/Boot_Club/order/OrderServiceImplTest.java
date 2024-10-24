package com.study.techeer.Boot_Club.order;

import static org.junit.jupiter.api.Assertions.*;

import com.study.techeer.Boot_Club.discount.FixDiscountPolicy;
import com.study.techeer.Boot_Club.member.Grade;
import com.study.techeer.Boot_Club.member.Member;
import com.study.techeer.Boot_Club.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

class OrderServiceImplTest {

  static int itemprice = 10000;
  static int fixedDiscount = 1000;
  @Test
  void createOrder(){
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    memberRepository.save(new Member(1L, "name", Grade.VIP));

    OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
    Order order = orderService.createOrder(1L, "itemA", itemprice);

    Assertions.assertThat(order.getDiscountPrice()).isEqualTo(itemprice - fixedDiscount);

  }
}