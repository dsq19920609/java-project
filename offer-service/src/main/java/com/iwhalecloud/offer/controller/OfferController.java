package com.iwhalecloud.offer.controller;

import com.iwhalecloud.offer.dto.req.OfferReq;
import com.iwhalecloud.offer.dto.resp.OfferResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/offer")
public class OfferController {

    @Autowired
    private Environment env;

    @PostMapping("/name")
    public OfferResp getOfferName(@RequestBody OfferReq reqquest) {
        OfferResp result = new OfferResp();
        result.setOfferId(1L);
        result.setOfferName("商品");
        return result;
    }
}
