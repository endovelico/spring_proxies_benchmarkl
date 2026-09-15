package com.benchark.proxy.scoped_proxies_use_case.session_scoped_beans;

import org.springframework.stereotype.Service;

@Service
public class CheckoutService {

    private final ShoppingCart cart;

    public CheckoutService(ShoppingCart cart) {
        this.cart = cart;
    }
}
