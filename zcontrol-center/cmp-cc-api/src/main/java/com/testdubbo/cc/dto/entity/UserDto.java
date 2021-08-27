package com.testdubbo.cc.dto.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {

    private static final long serialVersionUID = 7244356148025659221L;

    private String userId;

    private String userName;

    private String userPwd;

    private String userAge;
}
