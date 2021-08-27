package com.testdubbo.cc.mapper;

import com.testdubbo.cc.dto.entity.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    UserDto qryUserById(@Param("userId") String userId);
}
