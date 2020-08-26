package com.banyechan.autocreatedatabase.configuration;


import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 参考文档： https://blog.csdn.net/m0_37456570/article/details/83751401
 *
 *    用java 方式执行 sql脚本
 */

@Slf4j
@Component
public class InitDatabaseAndTables {

    @Value("${spring.datasource.driver-class-name}")
    private String driver;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.url}")
    private String url;


    // 创建数据库
    private  void createDatabase(){
        Connection connection = null;
        try {
            log.info("-------- 开始创建数据库     ----------");
            Class.forName(driver);//加载注册
            connection = DriverManager.getConnection(url,username,password);
            Statement stat = connection.createStatement();

            String  createdatabase="CREATE DATABASE IF NOT EXISTS `supermarket` ";//创建数据库
            stat.executeUpdate(createdatabase);
            log.info("-------- 创建数据库成功 结束    ----------");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }


    // 创建数据库 表结构
    public void initTables() throws SQLException {
        Connection connection = null;
        try {
            log.info("-------- 开始创建数据库表   ----------");
            Class.forName(driver);//加载注册
            connection = DriverManager.getConnection(url,username,password);
            Statement stat = connection.createStatement();
            connection.setAutoCommit(false);  // 设置不自动提交

            ScriptRunner runner = new ScriptRunner(connection);
            runner.setAutoCommit(false);  // 设置不自动提交

            //按照那种方式执行 方式一：true则获取整个脚本并执行； 方式二：false则按照自定义的分隔符每行执行
            runner.setSendFullScript(false);
            /*
             * setStopOnError参数作用：遇见错误是否停止；
             * （1）false，遇见错误不会停止，会继续执行，会打印异常信息，并不会抛出异常，当前方法无法捕捉异常无法进行回滚操作，
             * 无法保证在一个事务内执行； （2）true，遇见错误会停止执行，打印并抛出异常，捕捉异常，并进行回滚，保证在一个事务内执行；
             */
            runner.setStopOnError(true);

            //定义命令间的分隔符
            runner.setDelimiter(";");
            runner.setErrorLogWriter(null);
            //runner.setLogWriter(null); // 设置是否输出日志，null不输出日志，不设置自动将日志输出到控制台

//            runner.runScript(new InputStreamReader(new FileInputStream("D:\\work_code\\version2\\ecsb-parent\\ecsb-springboot\\src\\main\\resources\\db.sql"),"gbk"));
//            Resources.setCharset(Charset.forName("UTF-8"));
//            InputStreamReader reader = new InputStreamReader(Resources.getResourceAsStream("db.sql"), "UTF-8");
//            runner.runScript(reader);

            Resources.setCharset(Charset.forName("UTF8"));
            log.info("-------- 加载  schema-mysql.sql   ----------");
            runner.runScript(Resources.getResourceAsReader("schema-mysql.sql"));
            //runner.runScript(Resources.getResourceAsReader("schema-update.sql"));

            log.info("-------- 加载  data-mysql.sql   ----------");
            runner.runScript(Resources.getResourceAsReader("data-mysql.sql"));

            log.info("-------- 创建数据库表成功 结束    ----------");
        } catch (ClassNotFoundException | SQLException | IOException e) {
            connection.rollback();
            log.error("----- 创建数据库表数据回滚成功  ------");
            e.printStackTrace();
        }


    }


}
