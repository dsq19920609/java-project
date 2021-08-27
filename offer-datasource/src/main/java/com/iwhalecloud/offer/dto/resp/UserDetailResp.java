package com.iwhalecloud.offer.dto.resp;

import com.iwhalecloud.offer.entity.Order;
import com.iwhalecloud.offer.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class UserDetailResp extends User {

    List<Order> orders;
}
