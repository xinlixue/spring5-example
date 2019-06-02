package com.yuhuashi.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * @program: spring5-example
 * @description:
 * @author: Mr.Feng
 * @create: 2019-06-02 17:51
 **/
@Component
//会话级别作用域
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart {
  private int count = 0;

  public String cart(String name) {
    return name + "请求" + (count++);
  }

}
