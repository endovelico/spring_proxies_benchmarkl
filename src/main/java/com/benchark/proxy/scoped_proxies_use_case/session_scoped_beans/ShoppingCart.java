package com.benchark.proxy.scoped_proxies_use_case.session_scoped_beans;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(
        value = WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.TARGET_CLASS
)
public class ShoppingCart {

    private final List<String> products = new ArrayList<>();

    public void add(String product) {
        products.add(product);
    }
}