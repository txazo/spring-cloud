package org.txazo.spring.cloud.web.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "SPRING-CLOUD-SERVICE", fallback = UserClientFallback.class)
public interface UserClient {

    @RequestMapping("/user/{userId}")
    Object getUser(@PathVariable("userId") int userId);

}
