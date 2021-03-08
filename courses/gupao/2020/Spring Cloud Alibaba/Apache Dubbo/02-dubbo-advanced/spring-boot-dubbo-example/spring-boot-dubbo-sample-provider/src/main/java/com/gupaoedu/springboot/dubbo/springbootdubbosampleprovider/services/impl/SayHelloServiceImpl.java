package com.gupaoedu.springboot.dubbo.springbootdubbosampleprovider.services.impl;


import com.gupaoedu.springboot.dubbo.ISayHelloService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/

@DubboService(registry = {"shanghai","hunan"},
        protocol = {"dubbo","rest"},
        loadbalance = "random",
        cluster = "failover",
        retries = 2)
public class SayHelloServiceImpl implements ISayHelloService {

    @Value("${dubbo.protocols.dubbo.port}")
    private Integer port;

    @Override
    public String sayHello(String msg) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Msg:"+System.currentTimeMillis());
        return "[version1.0]-"+port+"Hello,"+msg+" GuPaoEdu.cn";
    }
}
