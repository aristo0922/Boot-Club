package com.study.techeer.Boot_Club.discount.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonTest {
  @Test
  void singletonBeanFind(){
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        SingletonBean.class);

    SingletonBean bean1 = context.getBean(SingletonBean.class);
    SingletonBean bean2 = context.getBean(SingletonBean.class);

    Assertions.assertThat(bean1).isEqualTo(bean2);
    context.close();
  }

  @Scope("singleton")
  static class SingletonBean{
    @PostConstruct
    public void init(){
      System.out.println(" SingletonBean.init ");
    }

    @PreDestroy
    public void destory(){
      System.out.println("SingletonBean.destory");
    }
  }

}
