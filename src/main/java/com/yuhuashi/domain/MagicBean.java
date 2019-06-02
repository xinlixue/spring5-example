package com.yuhuashi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: spring5-example
 * @description:
 * @author: Mr.Feng
 * @create: 2019-06-02 17:01
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MagicBean {
  private String title;
  private String msg;
}
