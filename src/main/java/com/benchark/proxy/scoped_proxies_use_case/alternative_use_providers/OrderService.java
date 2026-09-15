package com.benchark.proxy.scoped_proxies_use_case.alternative_use_providers;

import com.benchark.proxy.scoped_proxies_use_case.request_scoped_beans.UserContext;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ObjectProvider<UserContext> userContextProvider;

    public OrderService(ObjectProvider<UserContext> userContextProvider) {
        this.userContextProvider = userContextProvider;
    }

    public void createOrder() {
        UserContext userContext = userContextProvider.getObject();

        userContext.getUserId();
    }
}
