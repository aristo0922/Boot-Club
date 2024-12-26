package com.study.techeer.Boot_Club.components;


public class MemberService {
  private MemberRepository memberRepository;

  public MemberService(MemberRepository memberRepository){
    this.memberRepository = memberRepository;
  }
}
