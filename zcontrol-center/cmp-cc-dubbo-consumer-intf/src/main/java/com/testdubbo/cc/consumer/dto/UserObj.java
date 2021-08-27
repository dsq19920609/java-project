package com.testdubbo.cc.consumer.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserObj implements Serializable {

    private static final long serialVersionUID = -2267827181287706125L;

    private String userId;

    private String userName;

    private String userPwd;

    private String userAge;
}
