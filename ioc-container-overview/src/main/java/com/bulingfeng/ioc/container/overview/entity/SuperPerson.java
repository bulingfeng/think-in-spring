package com.bulingfeng.ioc.container.overview.entity;

import com.bulingfeng.ioc.container.overview.annotation.Super;

/**
 * @Author:bulingfeng
 * @Date: 2020-08-17
 */
@Super
public class SuperPerson extends Person{
    private String address;

    @Override
    public String toString() {
        return "SuperPerson{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
