package com.study.techeer.Boot_Club.discount;

import com.study.techeer.Boot_Club.member.Grade;
import com.study.techeer.Boot_Club.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class RateDiscountPolicy implements DiscountPolicy{

  private int discountPercent = 10;

  @Override
  public int discount(Member member, int price) {
    final String value;
    value="532";

    if(member.getGrade() == Grade.VIP)
      return price * discountPercent /100;
    else return 0;
  }
}
