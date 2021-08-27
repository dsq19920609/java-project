package com.iwhalecloud.offer.ZClass.EunmClass;

public enum  SerializerDef {

    DisableCheckSpecialChar,

    BeanToArray,

    NotWriteRootClassName;

    public final int mask;

    SerializerDef() {
        mask = (1 << ordinal());
    }

    public int getMask() {
        return mask;
    }

}
