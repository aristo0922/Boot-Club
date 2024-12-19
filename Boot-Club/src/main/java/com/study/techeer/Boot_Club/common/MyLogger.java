package com.study.techeer.Boot_Club.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.util.UUID;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request")
public class MyLogger {

  private String uuid;
  private String requestURL;

  public void setRequestURL(String requestURL) {
    this.requestURL = requestURL;
  }

  public void log(String message){
    System.out.println("[" + uuid +"]" + " ["+requestURL+"] " +message);
  }

  @PostConstruct
  public void init(){
    String uuid = UUID.randomUUID().toString(); // 로또 맞을 확률 > 중복 생성될 확률
    System.out.println("[" + uuid +"] reqeust scope bean created: "+ this);
  }

  @PreDestroy
  public void clase(){
    System.out.println("");
    System.out.println("[" + uuid +"] reqeust scope bean closed: "+ this);
  }
}
