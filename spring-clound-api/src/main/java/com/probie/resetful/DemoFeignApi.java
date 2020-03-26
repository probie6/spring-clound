package com.probie.resetful;

import com.probie.model.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("SERVICE-SERVER")
public interface DemoFeignApi {

  @GetMapping("/api/remote")
  BaseResponse<String> remote();
}
