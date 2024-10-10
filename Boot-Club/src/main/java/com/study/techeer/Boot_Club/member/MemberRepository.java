package com.study.techeer.Boot_Club.member;

public interface MemberRepository {

  void save(Member member);

  Member findById(Long memberId);
}
