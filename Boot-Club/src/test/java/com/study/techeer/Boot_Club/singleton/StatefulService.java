package com.study.techeer.Boot_Club.singleton;

public class StatefulService {

  private int price; // 상태를 유지하는 필드

  public int order(String name, int price){
    System.out.println("name = " + name+ " price = " + price);
    return price;
//    this.price =price; // 문제되는 부분
  }

//  public int getPrice(){
//    return price;
//  }

}
