package com.probie.controller;

import com.probie.model.BaseResponse;
import com.probie.resetful.DemoFeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class ClientController {

  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private DemoFeignApi demoFeignApi;

  @GetMapping("/hello")
  public String hello() {
    return restTemplate.getForObject("http://SERVICE-SERVER/api/hello", String.class);
  }

  @GetMapping("feign")
  public BaseResponse<String> remote() {
    return demoFeignApi.remote();
  }

}
