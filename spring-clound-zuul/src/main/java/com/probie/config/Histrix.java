package com.probie.config;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class Histrix implements FallbackProvider {

  @Override
  public String getRoute() {
    // 拦截所有服务
    return "*";
  }

  @Override
  public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
    return new ClientHttpResponse() {
      @Override
      @SuppressWarnings("NullableProblems")
      public HttpStatus getStatusCode() {
        return HttpStatus.OK;
      }

      @Override
      public int getRawStatusCode() {
        return 200;
      }

      @SuppressWarnings("NullableProblems")
      @Override
      public String getStatusText() {
        return "OK";
      }

      @Override
      public void close() {
        // to do close
      }

      @Override
      @SuppressWarnings("NullableProblems")
      public InputStream getBody() {
        return new ByteArrayInputStream(
            "sorry,the system goes to sleep,please try again later!".getBytes());
      }

      @Override
      @SuppressWarnings("NullableProblems")
      public HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        return headers;
      }
    };
  }
}
