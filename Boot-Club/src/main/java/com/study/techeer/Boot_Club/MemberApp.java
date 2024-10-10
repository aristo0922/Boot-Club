package com.study.techeer.Boot_Club;

import com.study.techeer.Boot_Club.member.Grade;
import com.study.techeer.Boot_Club.member.Member;
import com.study.techeer.Boot_Club.member.MemberService;
import com.study.techeer.Boot_Club.member.MemberServiceImpl;

public class MemberApp {

  public static void main(String[] args) {
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();

    Member member = new Member(1L, "memberA", Grade.VIP);
    memberService.join(member);

    Member findMember = memberService.findMember(1L);
    System.out.println("new member + "+member.getName());
    System.out.println("findMember + "+findMember.getName());
  }
}
