package com.study.techeer.Boot_Club.discount.scope;

import com.study.techeer.Boot_Club.discount.scope.SingletonTest.SingletonBean;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {
  @Test
  void prototypeBeanFind(){
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        PrototypeBean.class);

    System.out.println("find prototype bean1");
    PrototypeBean bean1 = context.getBean(PrototypeBean.class);
    System.out.println("find prototype bean2");
    PrototypeBean bean2 = context.getBean(PrototypeBean.class);
    System.out.println("bean1 >>> "+ bean1);
    System.out.println("bean2 >>> "+ bean2);
    Assertions.assertThat(bean1).isNotEqualTo(bean2);

    bean1.destory();
    bean2.destory();
    System.out.println("context close");
    context.close();
  }

  @Scope("prototype")
  static class PrototypeBean{
    @PostConstruct
    public void init(){
      System.out.println(" PrototypeBean.init ");
    }

    @PreDestroy
    public void destory(){
      System.out.println("PrototypeBean.destory");
    }
  }

}
