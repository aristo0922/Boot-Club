package com.study.techeer.Boot_Club.order;

import com.study.techeer.Boot_Club.discount.DiscountPolicy;
import com.study.techeer.Boot_Club.member.Member;
import com.study.techeer.Boot_Club.member.MemberRepository;
import com.study.techeer.Boot_Club.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

  private final MemberRepository memberRepository ;

  private final DiscountPolicy discountPolicy;

  public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
  }

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return new Order(memberId, itemName, itemPrice, discountPrice);
  }
}
