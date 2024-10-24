package com.study.techeer.Boot_Club;


import com.study.techeer.Boot_Club.discount.DiscountPolicy;
import com.study.techeer.Boot_Club.discount.FixDiscountPolicy;
import com.study.techeer.Boot_Club.member.MemberRepository;
import com.study.techeer.Boot_Club.member.MemberService;
import com.study.techeer.Boot_Club.member.MemberServiceImpl;
import com.study.techeer.Boot_Club.member.MemoryMemberRepository;
import com.study.techeer.Boot_Club.order.OrderService;
import com.study.techeer.Boot_Club.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public MemberService memberService() {
    System.out.println("call AppConfig.memberService");
    return new MemberServiceImpl(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
    System.out.println("call AppConfig.memberRepository");
    return new MemoryMemberRepository();
  }

  @Bean
  public OrderService orderService() {
    System.out.println("call AppConfig.orderService");
//    return new OrderServiceImpl(memberRepository(), discountPolicy());
    return null;
  }

  @Bean
  public DiscountPolicy discountPolicy() {
    return new FixDiscountPolicy();
  }
}
