package com.gupaoedu.springboot.dubbo.springbootdubbosampleprovider.services.impl;

import com.gupaoedu.springboot.dubbo.springbootdubbosampleprovider.services.IDemoService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
@DubboService(protocol = {"dubbo"})
public class DemoService implements IDemoService{

    @Override
    public String getTxt() {
        return "Hello Gupaoedu.cn/8.8";
    }
}
