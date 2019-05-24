package com.xt.gmall;

import com.xt.gmall.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author xt
 * @create 2019/5/23 11:00
 * @Desc
 */
public class MainApplication {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("consumer.xml");
        OrderService orderService = ioc.getBean(OrderService.class);

        orderService.initOrder("1");
        System.out.println("调用完成...");
        System.in.read();

    }
}
