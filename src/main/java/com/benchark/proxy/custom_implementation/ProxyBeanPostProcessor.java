package com.benchark.proxy.custom_implementation;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

@Component
public class ProxyBeanPostProcessor
        implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(
            Object bean,
            String beanName) {

        if (!(bean instanceof PaymentService)) {
            return bean;
        }

        return Proxy.newProxyInstance(
                bean.getClass().getClassLoader(),
                new Class<?>[]{PaymentService.class},
                new LoggingInvocationHandler(bean)
        );
    }
}
