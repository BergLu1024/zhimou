package com.aqoo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName zhimouApplication
 * @Description
 * @Date
 * @Version 1.0
 */
@Slf4j
@SpringBootApplication
public class zhimouApplication {
    public static void main(String[] args) {
        SpringApplication.run(zhimouApplication.class, args);
        log.info("项目启动成功...");
    }
}
