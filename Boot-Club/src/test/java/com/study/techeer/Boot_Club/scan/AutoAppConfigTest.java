package com.study.techeer.Boot_Club.scan;

import com.study.techeer.Boot_Club.AutoAppConfig;
import com.study.techeer.Boot_Club.member.MemberRepository;
import com.study.techeer.Boot_Club.member.MemberService;
import com.study.techeer.Boot_Club.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

  @Test
  void basicScan() {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
    MemberService memberService = ac.getBean(MemberService.class);
    Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

    OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);
    MemberRepository memberRepository = bean.getMemberRepository();
    System.out.println("memberRepository = " + memberRepository);
  }
}
