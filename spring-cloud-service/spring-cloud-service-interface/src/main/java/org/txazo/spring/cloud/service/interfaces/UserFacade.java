package org.txazo.spring.cloud.service.interfaces;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.txazo.spring.cloud.service.interfaces.response.UserInfo;

@RequestMapping("/spring-cloud-service")
public interface UserFacade {

    @RequestMapping(value = "getUserInfo", method = RequestMethod.GET)
    UserInfo getUserInfo(@RequestParam("userId") int userId);

}
