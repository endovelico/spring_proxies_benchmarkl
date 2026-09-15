package com.benchark.proxy.custom_implementation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LoggingInvocationHandler implements InvocationHandler {

    private final Object target;

    public LoggingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(
            Object proxy,
            Method method,
            Object[] args) throws Throwable {

        System.out.println("Before: " + method.getName());

        Object result = method.invoke(target, args);

        System.out.println("After: " + method.getName());

        return result;
    }
}
