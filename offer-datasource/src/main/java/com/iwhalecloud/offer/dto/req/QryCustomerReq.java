package com.iwhalecloud.offer.dto.req;

import lombok.Data;

import java.io.Serializable;

@Data
public class QryCustomerReq implements Serializable {

    private Long customerNumber;

    private String customerName;
}
