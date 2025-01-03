package com.study.techeer.Boot_Club.beanfind;

import com.study.techeer.Boot_Club.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class
ApplicationContextInfoTest {
  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

  @Test
  @DisplayName("모든 빈 출력하기")
  void findAllBean(){
    String[] beanDefinitionNames = ac.getBeanDefinitionNames();
    for (String  beanDefinitionName : beanDefinitionNames) {
      Object bean = ac.getBean(beanDefinitionName);
      System.out.println("beanDefinitionName = " + beanDefinitionName + " object ="+bean);
    }
  }

  @Test
  @DisplayName("애플리케이션 빈 출력하기")
  void findApplicationBean(){
    String[] beanDefinitionNames = ac.getBeanDefinitionNames();
    for (String  beanDefinitionName : beanDefinitionNames) {
      BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

      //ROL_Aplication: 직접 등록한 어플리케이션 빈
//      ROL_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
      if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
        // 개발을 위해서 등록한 빈, 외부 라이브러리
        Object bean = ac.getBean(beanDefinitionName);
        System.out.println("beanDefinitionName = " + beanDefinitionName + " object ="+bean);

      }
    }
  }

}
