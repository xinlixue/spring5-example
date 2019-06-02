package com.yuhuashi.service.impl;

import com.yuhuashi.service.CompactDisc;
import lombok.Data;

import java.util.List;

/**
 * @program: spring5-example
 * @description:
 * @author: Mr.Feng
 * @create: 2019-06-02 16:17
 **/
@Data
public class Bankdisc implements CompactDisc {

  private String titile;


  @Override
  public void pay() {
    System.out.println(this.getClass());
  }
}
