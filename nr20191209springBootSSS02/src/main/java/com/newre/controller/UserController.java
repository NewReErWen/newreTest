package com.newre.controller;

import com.newre.common.ResponseResult;
import com.newre.entity.User;
import com.newre.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private IUserService userService;

//    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @GetMapping("/findAll")
    public ResponseResult findAll() {
        return userService.findAll();
    }

    @GetMapping("/findById")
    public ResponseResult findById(Integer id) {
        return userService.findById(id);
    }

    @PostMapping("/updateUser")
    public ResponseResult updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
}
