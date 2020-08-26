package com.banyechan.autocreatedatabase.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Order(1)
public class CommandLineRunnerTest implements CommandLineRunner {

    @Autowired
    private InitDatabaseAndTables initDatabaseAndTables;

    @Override
    public void run(String... args) throws Exception {
        log.info("======  CommandLineRunner  执行  =======");
        initDatabaseAndTables.initTables();


    }
}
