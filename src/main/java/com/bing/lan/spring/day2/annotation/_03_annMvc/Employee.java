package com.bing.lan.spring.day2.annotation._03_annMvc;

import org.springframework.stereotype.Component;

/**
 * Created by 蓝兵 on 2018/4/20.
 */

@Component
public class Employee {

    private String name;
    private String id;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
