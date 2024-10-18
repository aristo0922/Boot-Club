package com.study.techeer.Boot_Club.beanfind;

import com.study.techeer.Boot_Club.AppConfig;
import com.study.techeer.Boot_Club.member.MemberService;
import com.study.techeer.Boot_Club.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextBasicFindTest {
  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

  @Test
  @DisplayName("빈 이름으로 조회")
  void findBeanByName() {
    MemberService memberService = ac.getBean("memberService", MemberService.class);
//    System.out.println("memberService = " + memberService);
//    System.out.println("memberService.getClass() = " + memberService.getClass());
    Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }
  @Test
  @DisplayName("이름 없이 타입으로만 조회")
  void findBeanByType() {
    MemberService memberService = ac.getBean(MemberService.class);
    Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }
  @Test
  @DisplayName("구체 타입으로 조회")
  void findBeanByTypeName() {
    MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
    Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }

  @Test
  @DisplayName("빈 이름으로 조회x")
  void findBeanByNameX(){
    assertThrows(NoSuchBeanDefinitionException.class,
        () -> ac.getBean("xxxxx", MemberService.class));
  }
}
