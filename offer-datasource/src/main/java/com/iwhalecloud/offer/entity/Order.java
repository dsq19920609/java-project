package com.iwhalecloud.offer.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {

    private String offerId;

    private String offerName;

    private Long offerPrice;

    private String userId;

}
