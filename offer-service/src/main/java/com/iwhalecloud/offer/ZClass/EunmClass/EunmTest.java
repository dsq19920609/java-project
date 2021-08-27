package com.iwhalecloud.offer.ZClass.EunmClass;

public class EunmTest {

    public static void main(String[] args) {
        for (SuccessCodeDef successCodeDef : SuccessCodeDef.values()) {
            System.out.println(successCodeDef.getCode() + " -- " + successCodeDef.ordinal() + " --- " + successCodeDef.getDesc());
        }

        System.out.println(SerializerDef.NotWriteRootClassName.getMask());
    }
}
