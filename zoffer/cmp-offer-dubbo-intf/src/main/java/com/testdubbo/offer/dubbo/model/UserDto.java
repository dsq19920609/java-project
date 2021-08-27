package com.testdubbo.offer.dubbo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private static final long serialVersionUID = -6591993592980539411L;

    private String userId;

    private String userName;

    private String userPwd;

    private String userAge;
}
