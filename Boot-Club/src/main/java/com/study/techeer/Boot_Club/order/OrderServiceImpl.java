package com.study.techeer.Boot_Club.order;

import com.study.techeer.Boot_Club.discount.DiscountPolicy;
import com.study.techeer.Boot_Club.member.Member;
import com.study.techeer.Boot_Club.member.MemberRepository;
import com.study.techeer.Boot_Club.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

  @Autowired private MemberRepository memberRepository ;

  @Autowired private DiscountPolicy discountPolicy;

//  public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//    System.out.println("memberRepo = "+memberRepository);
//    System.out.println("discountPolicy = "+discountPolicy);
//    this.memberRepository = memberRepository;
//    this.discountPolicy = discountPolicy;
//  }

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return new Order(memberId, itemName, itemPrice, discountPrice);
  }

  // 테스트 용도
  public MemberRepository getMemberRepository() {
    return memberRepository;
  }
}
