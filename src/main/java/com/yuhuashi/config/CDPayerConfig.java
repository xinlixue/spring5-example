package com.yuhuashi.config;

import com.yuhuashi.domain.MagicBean;
import com.yuhuashi.service.CompactDisc;
import org.springframework.context.annotation.*;

/**
 * @program: spring5-example
 * @description:
 * @author: Mr.Feng
 * @create: 2019-06-02 16:23
 **/
//@Import(CDConfig.class)
@Configuration
@ImportResource("classpath:spring/cd-config.xml")
public class CDPayerConfig {


  @Bean
  public Object cdPayer(CompactDisc compactDisc) {
    return new Object();
  }

  @Profile("dev")
  public MagicBean pmagicBean() {
    return new MagicBean("测试", "环境配置Bean");
  }

  //条件化配置Bean
  @Bean
  @Conditional(MagicExistsCondition.class)
  public MagicBean magicBean() {
    return new MagicBean("测试", "条件化配置Bean");
  }

}

