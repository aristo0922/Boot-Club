package com.study.techeer.Boot_Club.member;

public interface MemberService {
  void join(Member member);
  Member findMember(Long memberId);
}
