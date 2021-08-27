package com.testdubbo.offer.dubbo.impl;

import com.testdubbo.offer.dubbo.model.UserDto;
import com.testdubbo.offer.dubbo.service.UserService;
import com.testdubbo.offer.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Service(stub = "com.testdubbo.offer.dubbo.impl.UserServiceStub")
@Slf4j
public class UserServiceDubboImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDto qryUserById(String userId) {
        com.testdubbo.offer.dto.entity.UserDto userDto = userMapper.qryUserById(userId);
        UserDto resp = new UserDto();

        // 通过上下文获取dubbo的调用信息

        boolean isProviderSide = RpcContext.getContext().isProviderSide();

        // 获取调用方ip
        String clientIP = RpcContext.getContext().getRemoteHost();

        // 获取当前服务配置信息，所有的配置信息都将转化为url参数
        String application = RpcContext.getContext().getUrl().getParameter("application");

        // 获取消费者提供的参数
        Map<String, String> params = RpcContext.getContext().getAttachments();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            log.info("pairs : {} = {}", entry.getKey(), entry.getKey() );
        }

        BeanUtils.copyProperties(userDto, resp);
        return resp;
    }
}
