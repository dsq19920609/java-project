package com.iwhalecloud.offer.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Role implements Serializable {

    private String roleId;

    private String roleName;

    private String roleType;

    private String comment;
}
