package com.testdubbo.cc.consumer;

import com.testdubbo.cc.consumer.dto.UserObj;
import com.testdubbo.cc.consumer.service.UserService;
import com.testdubbo.offer.dubbo.model.UserDto;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Reference
    com.testdubbo.offer.dubbo.service.UserService userOfferService;

    @Override
    public UserObj qryUserById(String userId) {
        UserObj resp = new UserObj();

        // dubbo信息

        // 是否为消费者
        boolean isConsumerSide = RpcContext.getContext().isConsumerSide();

        // 获取最后一次调用的提供方的ip
        String serverIP = RpcContext.getContext().getRemoteHost();

        // 获取当前服务配置信息，所有的配置信息都将转化为url参数
        String application = RpcContext.getContext().getUrl().getParameter("application");

        // 设置参数
        Map<String, String> params = new HashMap<>();
        params.put("index", "1");
        params.put("name", "cc-consumer");
        RpcContext.getContext().setAttachments(params);

        UserDto userDto = userOfferService.qryUserById(userId);

        BeanUtils.copyProperties(userDto, resp);
        return resp;
    }
}
