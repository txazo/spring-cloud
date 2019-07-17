package org.txazo.spring.cloud.web.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.txazo.spring.cloud.service.interfaces.UserFacade;

@FeignClient(value = "spring-cloud-service", fallbackFactory = UserClientHystrix.class)
public interface UserClient extends UserFacade {
}
