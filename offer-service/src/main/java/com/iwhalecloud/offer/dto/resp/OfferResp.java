package com.iwhalecloud.offer.dto.resp;

import lombok.Data;

import java.io.Serializable;

@Data
public class OfferResp implements Serializable {

    private Long offerId;

    private String offerName;
}
