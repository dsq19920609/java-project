package com.iwhalecloud.offer.ZClass.all;


import lombok.Getter;
import lombok.Setter;

import java.io.Externalizable;


@Getter
@Setter
public abstract class Person implements Externalizable {

    private static final long serialVersionUID = 3490514245609630620L;

    /** 静态字段不会序列化，因此将对象反序列化后，仍是当前类的静态值*/
    private static String age = "12";

    private String name;

    private String color;

    private String car;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", car='" + car + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
