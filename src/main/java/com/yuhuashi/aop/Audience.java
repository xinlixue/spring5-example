package com.yuhuashi.aop;

import com.yuhuashi.domain.MagicBean;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: spring5-example
 * @description: 定义切面
 * @author: Mr.Feng
 * @create: 2019-06-02 20:42
 **/
@Aspect
@Component
public class Audience {
  ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();


  //execution (访问修饰符 返回类型 包名.类名.方法名(参数类型...))
  @Pointcut("execution(public * com.yuhuashi.service..*.*(..))")

  public void pointcut() {
  }


  //@args限定符 表示传递给pay()的参数也会传递给通知
  @Pointcut("execution(* com.yuhuashi.service.UserService.pay(String)) && args(name)")
  public void count(String name) {

  }

  @Before("count(name)")
  public void before(JoinPoint joinPoint, String name) {
    System.out.println("前置通知: " + joinPoint.getSignature().getName());
    concurrentHashMap.put(name, concurrentHashMap.get(name) != null ? concurrentHashMap.get(name) + 1 : 1);
  }

  @After("pointcut()")
  public void afterMethod(JoinPoint joinPoint) {
    System.out.println("后置通知: " + joinPoint.getSignature().getName());
  }

  //返回通知
  @AfterReturning(value = "pointcut()", returning = "result")
  public void afterReturnMethod(JoinPoint joinPoint, Object result) {
    System.out.println("返回通知: " + joinPoint.getSignature().getName() + ",执行结果为:" + result);
  }

  //异常通知
  @AfterThrowing(value = "pointcut()", throwing = "ex")
  public void afterThrowingMethod(JoinPoint joinPoint, Exception ex) {
    System.out.println("异常通知: " + joinPoint.getSignature().getName() + ",出现异常:" + ex.getMessage());
  }

  //环绕通知
  @Around("pointcut()")
  public Object aroundMethod(ProceedingJoinPoint point) {
    System.out.println("环绕通知开始......");
    //执行方法
    Object result = null;
    try {
      result = point.proceed();
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }
    System.out.println("环绕通知结束: " + point.getSignature().getName());

    return result;
  }

}
