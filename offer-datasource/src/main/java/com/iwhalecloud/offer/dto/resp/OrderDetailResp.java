package com.iwhalecloud.offer.dto.resp;

import com.iwhalecloud.offer.entity.Order;
import com.iwhalecloud.offer.entity.User;
import lombok.Data;

import java.io.Serializable;

@Data
public class OrderDetailResp extends Order implements Serializable{

    /**
     *  订单关联的用户
     */
    private User user;

}
