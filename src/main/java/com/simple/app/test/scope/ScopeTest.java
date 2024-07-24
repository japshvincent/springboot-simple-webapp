package com.simple.app.test.scope;

import org.thymeleaf.util.StringUtils;

public abstract class ScopeTest {
    private String value;

    public ScopeTest() {
        this.value = StringUtils.randomAlphanumeric(10);
    }

    public String getValue() {
        return value;
    }
}
