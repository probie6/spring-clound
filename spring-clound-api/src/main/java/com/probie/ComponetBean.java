package com.probie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ComponetBean {
  public void doit() {
    log.info("do it");
  }
}
