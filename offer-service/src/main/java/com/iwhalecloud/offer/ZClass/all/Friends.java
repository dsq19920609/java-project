package com.iwhalecloud.offer.ZClass.all;

import java.io.Serializable;

public class Friends implements Serializable {

    private String name;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Friends{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
