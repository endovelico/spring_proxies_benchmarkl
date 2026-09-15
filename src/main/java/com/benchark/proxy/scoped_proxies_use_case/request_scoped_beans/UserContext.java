package com.benchark.proxy.scoped_proxies_use_case.request_scoped_beans;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(
        value = WebApplicationContext.SCOPE_REQUEST,
        proxyMode = ScopedProxyMode.TARGET_CLASS
)
public class UserContext {

    private String userId;

    public String getUserId() {
        return userId;
    }
}
