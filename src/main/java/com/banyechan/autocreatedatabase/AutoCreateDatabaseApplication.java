package com.banyechan.autocreatedatabase;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class AutoCreateDatabaseApplication {

    public static void main(String[] args) {

        System.out.println("------------------");
        System.out.println("-------项目启动之前------");
        System.out.println("------------------");
        //createDatabase();


        SpringApplication.run(AutoCreateDatabaseApplication.class, args);
    }


    private static void createDatabase() {

        Connection connection = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/mysql?characterEncoding=utf8&useSSL=false";
        String user = "root";
        String password = "123456";
        try {
            System.out.println("-------- 开始创建数据库     ----------");
            Class.forName(driver);//加载注册
            connection = DriverManager.getConnection(url, user, password);
            Statement stat = connection.createStatement();

            String createdatabase = "CREATE DATABASE IF NOT EXISTS `supermarket` ";//创建数据库
            stat.executeUpdate(createdatabase);
            System.out.println("-------- 创建数据库成功 结束    ----------");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
