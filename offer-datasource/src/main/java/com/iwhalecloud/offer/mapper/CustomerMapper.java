package com.iwhalecloud.offer.mapper;

import com.iwhalecloud.offer.dto.req.QryCustomerReq;
import com.iwhalecloud.offer.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerMapper {

    public void addCustomer(Customer customer);

    public List<Customer> qryCustomerByCondition(@Param("req") QryCustomerReq req);

}
