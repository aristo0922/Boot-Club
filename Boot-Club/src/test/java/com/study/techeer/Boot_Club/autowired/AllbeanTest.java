package com.study.techeer.Boot_Club.autowired;

import com.study.techeer.Boot_Club.AutoAppConfig;
import com.study.techeer.Boot_Club.discount.DiscountPolicy;
import com.study.techeer.Boot_Club.member.Grade;
import com.study.techeer.Boot_Club.member.Member;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AllbeanTest {

  @Test
  void findAllBean(){
    ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

    DiscountService discountService = ac.getBean(DiscountService.class);
    Member userA = new Member(1L, "userA", Grade.VIP);
    int discountPrice = discountService.discount(userA, 10000, "fixDiscountPolicy");

    Assertions.assertThat(discountService).isInstanceOf(DiscountService.class);
    Assertions.assertThat(discountPrice).isEqualTo(1000);

    int rateDiscountPrice = discountService.discount(userA, 20000, "rateDiscountPolicy");
    Assertions.assertThat(rateDiscountPrice).isEqualTo(2000);
  }

  static class DiscountService {
    private final Map<String, DiscountPolicy> policyMap;
    private final List<DiscountPolicy> policies;

    @Autowired
    public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
      this.policyMap = policyMap;
      this.policies = policies;

      System.out.println("policyMap = " + policyMap);
      System.out.println("policies = " + policies);
    }

    public int discount(Member member, int price, String discountCode){
      DiscountPolicy discountPolicy = policyMap.get(discountCode);
      return discountPolicy.discount(member, price);
    }
  }

}
