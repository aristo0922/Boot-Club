package com.study.techeer.Boot_Club.autowired;

import com.study.techeer.Boot_Club.member.Member;
import jakarta.annotation.Nullable;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredTest {

  @Test
  void AutowiredOption() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
  }

  static class TestBean {
    @Autowired(required = false) // 의존관계가 없기에 호출 자체가 안됨
    public void setNoBean1(Member member1){
      System.out.println("member1 = " + member1);
    }

    @Autowired
    public void setNoBean2(@Nullable Member noBean2){
      System.out.println("noBean2 = " + noBean2);
    }

    @Autowired
    public void setNoBean3(Optional<Member> noBean3){
      System.out.println("noBean3 = " + noBean3);
    }
  }
}
