package com.iwhalecloud.offer.consts;

public abstract class CommonCacheDef {

    private CommonCacheDef() {}

    /**
     *  common模块
     */
    public static final String CACHE_MODULE_COMMON = "common";

    public static final String CACHE_MODULE_OFFER = "offer";

    public static final String CACHE_MODULE_ORDER = "order";

    /**
     * 分隔符
     */
    public static final String CACHE_DELIMITER = ":";


    public static final String CACHE_USER = CACHE_MODULE_COMMON + CACHE_DELIMITER + "user";

    public static final String CACHE_OFFER = CACHE_MODULE_COMMON + CACHE_DELIMITER + "offer";

    public static final String CACHE_ORDER = CACHE_MODULE_COMMON + CACHE_DELIMITER + "order";
}
