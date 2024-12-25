package com.study.techeer.Boot_Club.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.util.UUID;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
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
    uuid = UUID.randomUUID().toString(); // 로또 맞을 확률 > 중복 생성될 확률
    System.out.println();
    System.out.println("[" + uuid +"] reqeust scope bean created: "+ this);
  }

  @PreDestroy
  public void close(){
    System.out.println("[" + uuid +"] reqeust scope bean closed: "+ this);
    System.out.println("");
  }
}
