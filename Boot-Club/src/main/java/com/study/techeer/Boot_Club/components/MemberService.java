package com.study.techeer.Boot_Club.components;

import org.springframework.stereotype.Service;


//@Service
public class MemberService {
  private MemberRepository memberRepository;

  public MemberService(MemberRepository memberRepository){
    this.memberRepository = memberRepository;
  }
}
