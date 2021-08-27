package com.iwhalecloud.offer.mapper;

import com.iwhalecloud.offer.dto.req.QryUserReq;
import com.iwhalecloud.offer.dto.resp.UserDetailResp;
import com.iwhalecloud.offer.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserMapper {

    public User getUserById(@Param("userId") String userId);

    public List<User> getUserList();

    public void insertUser(User user);

    public void updateUser(@Param("req") User user);

    public void deleteUser(String userId);

    public UserDetailResp queryUserDetail(@Param("userId") String userId);

    @Transactional
    public List<User> queryUserFuzzy(@Param("req") QryUserReq qryUserReq);

    public HashMap<String, Object> getHashMap(@Param("userId") String userId);


    // test

    public User getUserByIdTest(@Param("userId") String userId);

    public List<User> getUserListTest();

    public void insertUserTest(User user);

    public void updateUserTest(@Param("req") User user);

    public void deleteUserTest(String userId);

    public UserDetailResp queryUserDetailTest(@Param("userId") String userId);

    public List<User> queryUserFuzzyTest(@Param("req") QryUserReq qryUserReq);

    public HashMap<String, Object> getHashMapTest(@Param("userId") String userId);

}
