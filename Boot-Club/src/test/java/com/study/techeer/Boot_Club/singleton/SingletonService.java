package com.study.techeer.Boot_Club.singleton;

public class SingletonService {
  private static final SingletonService instance = new SingletonService();

  private SingletonService(){
  }

  public static SingletonService getInstance(){
    return instance;
  }

  public void logic(){
    System.out.println("싱글톤 객체 로직 호출");
  }

  public static void main(String[] args) {
    SingletonService singletonService1 = new SingletonService();
  }
}
