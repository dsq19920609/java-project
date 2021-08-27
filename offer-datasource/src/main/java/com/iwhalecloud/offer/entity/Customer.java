package com.iwhalecloud.offer.entity;

import lombok.Data;

import java.io.Serializable;

/**
 *  customer表 存放很多数据 用于性能测试
 */
@Data
public class Customer implements Serializable {

    private Long customerNumber;

    private String customerName;

    private String contactLastName;

    private String contactFirstName;

    private String phone;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String state;

    private String postalCode;

    private String country;

    private Long salesRepEmployeeNumber;

    private String creditLimit;
}
