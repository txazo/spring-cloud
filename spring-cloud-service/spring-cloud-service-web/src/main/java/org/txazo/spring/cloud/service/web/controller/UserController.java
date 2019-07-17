package org.txazo.spring.cloud.service.web.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.txazo.spring.cloud.service.interfaces.UserFacade;
import org.txazo.spring.cloud.service.interfaces.response.UserInfo;

@RestController
public class UserController implements UserFacade {

    @Override
    @ResponseBody
    public UserInfo getUserInfo(@RequestParam("userId") int userId) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setUserName("root");
        return userInfo;
    }

}
