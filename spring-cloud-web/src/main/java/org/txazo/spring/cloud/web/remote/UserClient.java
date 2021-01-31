package org.txazo.spring.cloud.web.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tuxiaozhou
 * @date 2021/1/31
 */
@FeignClient(value = "SPRING-CLOUD-SERVICE", fallback = UserClientFallback.class)
public interface UserClient {

    /**
     * getUser
     *
     * @param userId 用户ID
     * @return 用户信息
     */
    @RequestMapping("/user/{userId}")
    Object getUser(@PathVariable("userId") int userId);

}
