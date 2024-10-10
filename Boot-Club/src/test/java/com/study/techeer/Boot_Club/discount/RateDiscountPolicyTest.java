package com.study.techeer.Boot_Club.discount;

import static org.junit.jupiter.api.Assertions.*;

import com.study.techeer.Boot_Club.member.Grade;
import com.study.techeer.Boot_Club.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {
  RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

  @Test
  @DisplayName("VIP 는 10프로 할인이 적용되어야 한다.")
  void vip_o(){
    //given
    Member member = new Member(1L, "memberVIP", Grade.VIP);
    //when
    int discount = discountPolicy.discount(member, 10000);

    //then
    Assertions.assertThat(discount).isEqualTo(1000);
  }

  @Test
  @DisplayName("VIP 가 아니면 할인이 적용되지 않아야 한다.")
  void vip_X(){
    //given
    Member member = new Member(2L, "memberVIP", Grade.BASIC);
    //when
    int discount = discountPolicy.discount(member, 10000);

    //then
    Assertions.assertThat(discount).isEqualTo(0);
  }
}