package com.iwhalecloud.offer.controller;

import com.iwhalecloud.offer.dto.req.QryUserReq;
import com.iwhalecloud.offer.dto.resp.OrderDetailResp;
import com.iwhalecloud.offer.dto.resp.UserDetailResp;
import com.iwhalecloud.offer.entity.User;
import com.iwhalecloud.offer.manager.UserManager;
import com.iwhalecloud.offer.mapper.OrderMapper;
import com.iwhalecloud.offer.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Method;
import org.apache.ibatis.jdbc.SQL;
import org.dom4j.tree.BaseElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

@Api(description = "用户信息接口")
@RestController
@RequestMapping("/api/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserManager userManager;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @ApiOperation(value = "查询用户" ,  notes="查询用户详情")
    @GetMapping("/select/{userId}")
    public User getUserById(@PathVariable String userId) {
        return userManager.getUserById(userId);
    }

   @GetMapping("/list")
    public List<User> getUserList(HttpServletRequest request, HttpServletResponse res) throws Exception{
        res.setHeader("Access-Control-Allow-Origin", "*");
       res.setHeader("name", "dong");
       res.setHeader("Access-Control-Expose-Headers", "name");
       return userMapper.getUserList();
    }

    @GetMapping("/detail/{userId}")
    public UserDetailResp queryUserDetail(@PathVariable("userId") String userId, HttpServletRequest request) {
        Enumeration<String> headers =  request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            System.out.println(header + " = " + request.getHeader(header));
        }
        return userMapper.queryUserDetail(userId);
    }

    @PostMapping("/user/add")
    public User addUser(@RequestBody User user) {
        return userManager.addUser(user);
    }

    @GetMapping("/order/detail/{orderId}")
    public OrderDetailResp queryOrderDetail(@PathVariable String orderId) {
        return orderMapper.queryOrderDetail(orderId);
    }

    @PostMapping("/find/user")
    public List<User> queryUserFuzzy(@RequestBody QryUserReq req) {
        return userMapper.queryUserFuzzy(req);
    }

}
