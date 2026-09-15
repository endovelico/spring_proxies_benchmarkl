package com.benchark.proxy.scoped_proxies_use_case.request_scoped_beans;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final UserContext userContext;

    public OrderService(UserContext userContext) {
        this.userContext = userContext;
    }

    public void createOrder() {
        System.out.println(userContext.getUserId());
    }
}
