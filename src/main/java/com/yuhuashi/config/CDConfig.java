package com.yuhuashi.config;

import com.yuhuashi.service.CompactDisc;
import com.yuhuashi.service.impl.Bankdisc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: spring5-example
 * @description:
 * @author: Mr.Feng
 * @create: 2019-06-02 16:19
 **/
//@Configuration
public class CDConfig {

//  @Bean
  public CompactDisc compactiDsc() {
    return new Bankdisc();
  }


}
