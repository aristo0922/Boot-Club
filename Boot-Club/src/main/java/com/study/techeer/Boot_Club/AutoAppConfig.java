package com.study.techeer.Boot_Club;

import com.study.techeer.Boot_Club.member.MemberRepository;
import com.study.techeer.Boot_Club.member.MemoryMemberRepository;
import com.study.techeer.Boot_Club.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//    basePackages = "com.study.techeer.Boot_Club.member",
//    basePackageClasses = AutoAppConfig.class,
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
  @Bean(name = "memoryMemberRepository")
  MemberRepository memberRepository(){
    return new MemoryMemberRepository();
  }
}
