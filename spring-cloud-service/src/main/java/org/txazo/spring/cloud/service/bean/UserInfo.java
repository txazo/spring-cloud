package org.txazo.spring.cloud.service.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -8691762904696433774L;

    private int userId;

    private String userName;

}
