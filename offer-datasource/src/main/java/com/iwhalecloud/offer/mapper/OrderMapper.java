package com.iwhalecloud.offer.mapper;

import com.iwhalecloud.offer.dto.resp.OrderDetailResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {

    public OrderDetailResp queryOrderDetail(@Param("offerId") String offerId);

}
