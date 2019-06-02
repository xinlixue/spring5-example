package com.yuhuashi.config;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @program: spring5-example
 * @description:
 * @author: Mr.Feng
 * @create: 2019-06-02 17:04
 **/
public class MagicExistsCondition implements Condition {


  /**
   * 条件配置Bean
   *
   * @param context
   * @param metadata
   * @return
   */
  @Override
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    //todo:例子 根据环境中是否存在magic属性决定是否生成Bean
    Environment environment = context.getEnvironment();
    return environment.containsProperty("magic");
  }
}
