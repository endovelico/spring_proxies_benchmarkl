package com.benchark.proxy.service.impl;


import org.springframework.stereotype.Service;

@Service
public class ConcreteCalculator {

    public int increment(int value) {
        return value + 1;
    }
}