package org.txazo.spring.cloud.web.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.txazo.spring.cloud.web.remote.UserClient;

import javax.annotation.Resource;

/**
 * @author tuxiaozhou
 * @date 2021/1/31
 */
@RestController
@RequestMapping(value = "/spring-cloud-web")
public class WebController {

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private UserClient userClient;

    /**
     * http://127.0.0.1:8081/spring-cloud-web/user/1
     * http://127.0.0.1:8080/user-web/spring-cloud-web/user/1
     */
    @ResponseBody
    @HystrixCommand(fallbackMethod = "fallbackMethod",
            threadPoolKey = "user",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "1"),
                    @HystrixProperty(name = "maxQueueSize", value = "0")
            })
    // @SentinelResource(value = "sayHello")
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public Object getUserInfo(@PathVariable("userId") int userId) {
        return restTemplate.getForObject("http://SPRING-CLOUD-SERVICE/user/" + userId,
                Object.class);
    }

    @ResponseBody
    @RequestMapping(value = "/feign/user/{userId}", method = RequestMethod.GET)
    public Object getUserInfoByFeign(@PathVariable("userId") int userId) {
        return userClient.getUser(userId);
    }

    public Object fallbackMethod(int userId) {
        return "{\"msg\": \"服务降级\"}";
    }

}
