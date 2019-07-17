package org.txazo.spring.cloud.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.txazo.spring.cloud.service.interfaces.response.UserInfo;
import org.txazo.spring.cloud.web.remote.UserClient;

@RestController
@RequestMapping(value = "/spring-cloud-web")
public class WebController {

    @Autowired
    private UserClient userClient;

    // http://127.0.0.1:8080/api-web/spring-cloud-web/getUserInfo?userId=1
    @ResponseBody
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public UserInfo getUserInfo(@RequestParam("userId") int userId) {
        return userClient.getUserInfo(userId);
    }

}
