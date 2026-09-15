package com.benchark.proxy.custom_implementation;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {

        PaymentService target = new PaymentServiceImpl();

        PaymentService proxy =
                (PaymentService) Proxy.newProxyInstance(
                        PaymentService.class.getClassLoader(),
                        new Class<?>[]{PaymentService.class},
                        new LoggingInvocationHandler(target)
                );

        proxy.pay("alice", 100);
    }
}
