package com.bing.lan.spring.day2._01_annotation._02_annIoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * Created by 蓝兵 on 2018/4/20.
 */

@Component
public class SomeBean {

    @Autowired
    private OtherBean other;

    private Properties properties;

    @Override
    public String toString() {
        return "SomeBean{" +
                "otherBean=" + other +
                ", properties=" + properties +
                '}';
    }
}
