package com.iwhalecloud.offer.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRole implements Serializable {

    private String relaId;

    private String roleId;

    private String userId;

}
