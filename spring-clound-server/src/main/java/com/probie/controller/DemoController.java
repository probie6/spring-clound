package com.probie.controller;

import com.probie.model.BaseResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {
  @Value("${server.port}")
  private String port;

  @GetMapping(value = "/hello")
  public String hello() {
    return "hello, 我是 8763 spring-clound-server";
  }

  @GetMapping(value = "/remote")
  public BaseResponse<String> remote() {
    BaseResponse<String> response = new BaseResponse<>();
    response.setCode("200");
    response.setMessage("hello i am " + port);
    response.setData("result");
    return response;
  }

}
