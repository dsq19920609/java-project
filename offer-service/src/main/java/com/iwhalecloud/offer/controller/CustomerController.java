package com.iwhalecloud.offer.controller;


import com.iwhalecloud.offer.dto.req.QryCustomerReq;
import com.iwhalecloud.offer.entity.Customer;
import com.iwhalecloud.offer.manager.CustomerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private  CustomerManager customerManager;

    @PostMapping("/add")
    public void  addCustomer() {
        customerManager.addCustomer();
    }

    @PostMapping("/query")
    public List<Customer> qryCustomerByCondition(@RequestBody QryCustomerReq req) {
        return customerManager.qryCustomerByCondition(req);
    }
}
