package org.txazo.spring.cloud.service.controller;

import org.springframework.web.bind.annotation.*;
import org.txazo.spring.cloud.service.bean.UserInfo;

@RestController
@RequestMapping("/")
public class UserController {

    // // http://127.0.0.1:8082/user/1
    @ResponseBody
    @RequestMapping("/user/{userId}")
    public UserInfo getUserInfo(@PathVariable("userId") int userId) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setUserName("root");
        return userInfo;
    }

}
