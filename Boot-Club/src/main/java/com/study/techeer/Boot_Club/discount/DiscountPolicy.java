package com.study.techeer.Boot_Club.discount;

import com.study.techeer.Boot_Club.member.Member;

public interface DiscountPolicy {

  int discount(Member member, int price);

}
