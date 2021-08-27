package com.iwhalecloud.offer.manager;

import com.iwhalecloud.offer.dto.req.QryCustomerReq;
import com.iwhalecloud.offer.entity.Customer;
import com.iwhalecloud.offer.mapper.CustomerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerManager {

    @Autowired
    private CustomerMapper customerMapper;

    public void addCustomer() {

    }

    public List<Customer> qryCustomerByCondition(QryCustomerReq req) {
        return customerMapper.qryCustomerByCondition(req);
    }



}
