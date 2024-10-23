package com.study.techeer.Boot_Club.scan;

import com.study.techeer.Boot_Club.AutoAppConfig;
import com.study.techeer.Boot_Club.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

  @Test
  void basicScan() {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
    MemberService memberService = ac.getBean(MemberService.class);

    Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
  }
}
