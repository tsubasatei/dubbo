package com.xt.gmall;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author xt
 * @create 2019/5/23 10:43
 * @Desc
 */
public class UserApplication {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("provider.xml");
        ioc.start();
        System.in.read(); // 按任意键退出
    }
}
