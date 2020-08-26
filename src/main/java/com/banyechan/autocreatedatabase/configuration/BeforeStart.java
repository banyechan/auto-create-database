package com.banyechan.autocreatedatabase.configuration;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * 在项目初始化之前创建 项目所需的数据库
 * 项目启动时,要先创建数据库,否则无法执行 schema-mysql.sql
 */

//@Configuration
//public class BeforeStart {
//
//
//    @PostConstruct
//    public void test(){
//        System.out.println("=====  BeforeStart  ====== ");
//        // Todo 写具体要执行的业务方法
//        System.out.println("=====  BeforeStart  END ====== ");
//    }
//
//
//}
