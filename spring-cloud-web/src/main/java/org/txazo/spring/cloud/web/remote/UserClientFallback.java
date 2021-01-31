package org.txazo.spring.cloud.web.remote;

import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {

    @Override
    public Object getUser(int userId) {
        return "{\"msg\": \"feign服务降级\"}";
    }

}
