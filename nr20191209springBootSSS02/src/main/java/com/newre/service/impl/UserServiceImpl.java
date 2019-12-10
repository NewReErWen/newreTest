package com.newre.service.impl;

import com.newre.common.CommonCode;
import com.newre.common.ResponseResult;
import com.newre.dao.UserDao;
import com.newre.entity.User;
import com.newre.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public ResponseResult findAll() {
        ResponseResult responseResult = null;
        List<User> userList = userDao.findAll();
        if (userList.isEmpty()) {
           responseResult = new ResponseResult(CommonCode.FAIL);
        } else {
            responseResult = new ResponseResult(CommonCode.SUCCESS);
        }
        responseResult.setList(userList);

        return responseResult;
    }

    @Override
    public ResponseResult<User> findById(Integer id) {
        ResponseResult responseResult = null;
        Optional<User> optionalUser = userDao.findById(id);
        User user = optionalUser.get();
        if (user == null) {
            responseResult = new ResponseResult(CommonCode.FAIL);
            responseResult.setT(new User());
        }else {
            responseResult = new ResponseResult(CommonCode.SUCCESS);
            responseResult.setT(user);
        }
        return responseResult;
    }

    @Override
    public ResponseResult updateUser(User user) {
        User user1 = userDao.save(user);
        if (user1 == null) {
            return new ResponseResult(CommonCode.FAIL);
        } else {
            return new ResponseResult(CommonCode.SUCCESS);
        }
    }
}
