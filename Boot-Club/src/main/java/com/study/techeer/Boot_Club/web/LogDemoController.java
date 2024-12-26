package com.study.techeer.Boot_Club.web;

import com.study.techeer.Boot_Club.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

  private final LogDemoService logDemoService;
  private final MyLogger myLogger;

  @RequestMapping("log-demo")
  @ResponseBody
  public String logDemo(HttpServletRequest request) throws InterruptedException {
    String requestURL = request.getRequestURL().toString();

    System.out.println();
    System.out.println("myLogger = " + myLogger.getClass());
    System.out.println();
    myLogger.setRequestURL(requestURL);

    myLogger.log("controller test");
    Thread.sleep(1000);
    logDemoService.logic("testId");

    return "OK";
  }
}
