package com.yuhuashi.service.impl;

import com.yuhuashi.dao.UserDao;
import com.yuhuashi.domain.User;
import com.yuhuashi.service.ShoppingCart;
import com.yuhuashi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: spring5-example
 * @description:
 * @author: Mr.Feng
 * @create: 2019-06-02 00:15
 **/
@Service
public class UserServiceImpl implements UserService {

  @Resource
  private UserDao userDao;

  private ShoppingCart shoppingCart;

  //spel
  @Value("#{T(System).currentTimeMillis()}")
  private long currtime;

  public UserServiceImpl(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public void insertUser(User user) {
    userDao.insertUser(user);
  }

  @Override
  public String pay(String name) {
    return shoppingCart.cart(name);
  }

  //将会话作用域的类注入单列Service中,不同的会话注入不同的购物车实例
  @Autowired
  public void setShoppingCart(ShoppingCart shoppingCart) {
    this.shoppingCart = shoppingCart;
  }


}
