package com.study.techeer.Boot_Club.order;

import com.study.techeer.Boot_Club.discount.DiscountPolicy;
import com.study.techeer.Boot_Club.discount.FixDiscountPolicy;
import com.study.techeer.Boot_Club.member.Member;
import com.study.techeer.Boot_Club.member.MemberRepository;
import com.study.techeer.Boot_Club.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

  private final MemberRepository memberRepository = new MemoryMemberRepository();

  private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return new Order(memberId, itemName, itemPrice, discountPrice);
  }
}
