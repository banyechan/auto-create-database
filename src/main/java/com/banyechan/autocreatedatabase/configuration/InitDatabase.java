package com.banyechan.autocreatedatabase.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;


/**
 * 在项目初始化之前创建 项目所需的数据库
 * 项目启动时,要先创建数据库,否则无法执行 schema-mysql.sql
 */
//@Configuration
//public class InitDatabase {
//    private Logger logger = Logger.getLogger("initDatabase");
//
//    @Value("${spring.datasource.driver-class-name}")
//    private String driver;
//    @Value("${spring.datasource.username}")
//    private String username;
//    @Value("${spring.datasource.password}")
//    private String password;
//    @Value("${spring.datasource.mysql-url}")
//    private String url;
//
//    @PostConstruct
//    public void test(){
//        logger.info("=====  初始化数据库 start  ====== ");
//        createDatabase();
//        logger.info("=====  初始化数据库  END ====== ");
//    }
//
//    private  void createDatabase(){
//        Connection connection = null;
//        try {
//            logger.info("-------- 开始创建数据库     ----------");
//            Class.forName(driver);//加载注册
//            connection = DriverManager.getConnection(url,username,password);
//            Statement stat = connection.createStatement();
//
//            String  createdatabase="CREATE DATABASE IF NOT EXISTS `supermarket` ";//创建数据库
//            stat.executeUpdate(createdatabase);
//            logger.info("-------- 创建数据库成功 结束    ----------");
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}
