package com.benchark.proxy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.benchark.proxy.service")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class CglibProxyConfig {
}