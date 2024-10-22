package com.study.techeer.Boot_Club.singleton;

import com.study.techeer.Boot_Club.AppConfig;
import com.study.techeer.Boot_Club.member.MemberRepository;
import com.study.techeer.Boot_Club.member.MemberServiceImpl;
import com.study.techeer.Boot_Club.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

  @Test
  void configurationTest(){
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
    OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

    MemberRepository memberRepository1 = memberService.getMemberRepository();
    MemberRepository memberRepository2 = orderService.getMemberRepository();

    System.out.println("memberSerivce -> memberRepository1 = " + memberRepository1);
    System.out.println("orderService -> memberRepository2 = " + memberRepository2);

    Assertions.assertThat(memberRepository1).isSameAs(memberRepository2);
  }
}
