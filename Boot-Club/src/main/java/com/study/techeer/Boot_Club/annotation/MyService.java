package com.study.techeer.Boot_Club.annotation;

public class MyService {
  @MyAnnotation
  public void method1(){
    System.out.println(" run method 1 ");
  }

  @MyAnnotation("*")
  public void method2() {
    System.out.println(" run method 2 ");
  }

  @MyAnnotation(value = "*", number = 20)
  public void method3(){
    System.out.println(" run method 3 ");
  }

}
