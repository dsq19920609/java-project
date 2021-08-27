package com.iwhalecloud.offer.ZClass.EunmClass;

public enum  SuccessCodeDef {

    SUCCESS("0001", "success to you"),
    ERROR("0002", "fail to resule");

    private String code;

    private String desc;

    SuccessCodeDef(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
