package com.study.techeer.Boot_Club.discount;

import com.study.techeer.Boot_Club.member.Grade;
import com.study.techeer.Boot_Club.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy{

  private int discountFixAmount = 1000;

  @Override
  public int discount(Member member, int price) {
    if(member.getGrade() == Grade.VIP){
      return discountFixAmount;
    }
    return 0;
  }
}
