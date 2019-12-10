package com.newre.service;

import com.newre.common.ResponseResult;
import com.newre.entity.User;

public interface IUserService {
    ResponseResult<User> findAll();

    ResponseResult<User> findById(Integer id);

    ResponseResult updateUser(User user);
}
