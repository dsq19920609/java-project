package com.iwhalecloud.offer.dto.req;

import lombok.Data;

import java.io.Serializable;

@Data
public class QryUserReq implements Serializable {

    private String userName;

    private String userPwd;

}
