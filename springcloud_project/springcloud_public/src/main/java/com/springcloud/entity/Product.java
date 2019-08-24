package com.springcloud.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable {

    private Long pid;

    private String productName; // 产品名称

    private String dbSource; // 来自于哪个数据库

}
