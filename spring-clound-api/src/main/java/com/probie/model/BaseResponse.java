package com.probie.model;

import lombok.Builder;
import lombok.Data;

@Data
public class BaseResponse<T> {
  private String code;
  private T data;
  private String message;

}
