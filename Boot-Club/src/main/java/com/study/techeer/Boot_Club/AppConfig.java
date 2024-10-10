package com.study.techeer.Boot_Club;

import com.study.techeer.Boot_Club.discount.FixDiscountPolicy;
import com.study.techeer.Boot_Club.member.MemberService;
import com.study.techeer.Boot_Club.member.MemberServiceImpl;
import com.study.techeer.Boot_Club.member.MemoryMemberRepository;
import com.study.techeer.Boot_Club.order.OrderService;
import com.study.techeer.Boot_Club.order.OrderServiceImpl;

public class AppConfig {

  public MemberService memberService(){
    return new MemberServiceImpl(new MemoryMemberRepository());
  }

  public OrderService orderService(){
    return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
  }
}
