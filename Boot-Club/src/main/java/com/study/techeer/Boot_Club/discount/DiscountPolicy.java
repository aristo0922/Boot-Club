package com.study.techeer.Boot_Club.discount;

import com.study.techeer.Boot_Club.member.Member;

public interface DiscountPolicy {
  /*
  @return 할인 대상 금액
   */
  int discount(Member member, int price);

}
