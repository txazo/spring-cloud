package org.txazo.spring.cloud.service.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class UserController {

    // http://127.0.0.1:8082/user/1
    @ResponseBody
    @RequestMapping("/user/{userId}")
    public Object getUser(@PathVariable("userId") int userId) {
        Map<String, Object> user = new HashMap<>();
        user.put("userId", userId);
        user.put("userName", "root");
        return user;
    }

}
