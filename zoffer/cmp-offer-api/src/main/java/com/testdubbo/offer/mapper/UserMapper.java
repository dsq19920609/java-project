package com.testdubbo.offer.mapper;

import com.testdubbo.offer.dto.entity.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    UserDto qryUserById(@Param("userId") String userId);

}
