package com.study.techeer.Boot_Club.lifecycle;

public class NetworkClient {
  private String url;
  public NetworkClient(){
    System.out.println("ㅅㅐㅇ성자 호출 url = " + url);
    connect();
    call("초기화 연결 메시지");
  }

  public void setUrl(String url){
    this.url = url;
  }

  public void connect(){
    System.out.println("connnect = " + url);
  }

  public void call(String message) {
    System.out.println("call = " + url + " messsage = "+ message);
  }

  public void disconnect(){
    // end service
    System.out.println("close = " + url);
  }

}
