package com.yuhuashi.service;

import com.yuhuashi.domain.User;

public interface UserService {

  void insertUser(User user);

  String pay(String name);
}
