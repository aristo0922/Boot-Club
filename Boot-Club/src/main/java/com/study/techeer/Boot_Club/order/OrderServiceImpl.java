package com.study.techeer.Boot_Club.order;

import com.study.techeer.Boot_Club.discount.DiscountPolicy;
import com.study.techeer.Boot_Club.member.Member;
import com.study.techeer.Boot_Club.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final MemberRepository memberRepository;
  private final DiscountPolicy discount;



  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discount.discount(member, itemPrice);

    return new Order(memberId, itemName, itemPrice, discountPrice);
  }

  public MemberRepository getMemberRepository() {
    return memberRepository;
  }
}
