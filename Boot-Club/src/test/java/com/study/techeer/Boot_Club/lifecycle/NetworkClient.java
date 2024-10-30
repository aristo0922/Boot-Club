package com.study.techeer.Boot_Club.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient {

  private String url;

  public NetworkClient() {
    System.out.println("생성자 호출, 접속한 url = " + url);
    connect();
    call("초기화 연결 메시지");
  }

  public void setUrl(String url) {
    this.url = url;
  }

  //서비스 시작 시 호출
  public void connect() {
    System.out.println("connnect = " + url);
  }

  public void call(String message) {
    System.out.println("call = " + url + ", messsage = " + message);
  }

  // 서비스 종료시 호출
  public void disconnect() {
    // end service
    System.out.println("close: " + url);
  }

  // 의존 관계 연결을 마치면
  @PostConstruct
  public void init(){
    System.out.println("NetworkClient.init");
    connect();
    call("초기화 연결 메시지");
  }

  @PreDestroy
  public void close(){
    System.out.println("networkclient.close");
    disconnect();
  }
}
