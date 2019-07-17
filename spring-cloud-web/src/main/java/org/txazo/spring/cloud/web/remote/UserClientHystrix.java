package org.txazo.spring.cloud.web.remote;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.txazo.spring.cloud.service.interfaces.response.UserInfo;

@Component
public class UserClientHystrix implements FallbackFactory<UserClient> {

    @Override
    public UserClient create(Throwable throwable) {
        return new UserClient() {

            @Override
            public UserInfo getUserInfo(int userId) {
                return null;
            }

        };
    }

}
