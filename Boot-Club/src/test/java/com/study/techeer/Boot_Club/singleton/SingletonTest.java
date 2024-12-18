package com.study.techeer.Boot_Club.singleton;

import com.study.techeer.Boot_Club.AppConfig;
import com.study.techeer.Boot_Club.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

  @Test
  @DisplayName("스프링 없는 순수한 DI 컨테이너")
  void pureContainer() {
    AppConfig appConfig = new AppConfig();
    ////1. 조회: 호출마다 객체 생성하는지
    MemberService memberService1 = appConfig.memberService();
    MemberService memberService2 = appConfig.memberService();

    // 참조값이 다른 것을 확인
    System.out.println("memberService1 = " + memberService1);
    System.out.println("memberService2 = " + memberService2);

    // memberService1 != memberService2
    Assertions.assertThat(memberService1).isNotSameAs(memberService2);
  }


  @Test
  @DisplayName("singleton 패턴을 적용한 객체 사용")
  void singletonServiceTest() {
    SingletonService instance1 = SingletonService.getInstance();
    SingletonService instance2 = SingletonService.getInstance();

    System.out.println("singleton service1 = " + instance1);
    System.out.println("singleton service2 = " + instance2);

    Assertions.assertThat(instance1).isSameAs(instance2);
  }

  @Test
  @DisplayName("스프링 컨테이너와 싱글톤")
  void springContainer() {

//    AppConfig appConfig = new AppConfig();
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    ////1. 조회: 호출마다 객체 생성하는지
    MemberService memberService1 = ac.getBean("memberService", MemberService.class);
    MemberService memberService2 = ac.getBean("memberService", MemberService.class);

    // 참조값이 같은 것 확인
    System.out.println("memberService1 = " + memberService1);
    System.out.println("memberService2 = " + memberService2);

    // memberService1 == memberService2
    Assertions.assertThat(memberService1).isSameAs(memberService2);
  }
}
