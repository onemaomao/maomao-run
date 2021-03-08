package com.gupaoedu.springboot.dubbo.springbootdubbosampleprovider;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@DubboComponentScan(basePackages = "com.gupaoedu.springboot.dubbo.springbootdubbosampleprovider.services")
@SpringBootApplication
public class SpringBootDubboSampleProviderApplication {

    public static void main(String[] args) {
//        Main.main(new String[]{"spring","log4j"});
        SpringApplication.run(SpringBootDubboSampleProviderApplication.class, args);
    }

}
