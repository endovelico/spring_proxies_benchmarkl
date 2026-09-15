package com.benchark.proxy.service.impl;

import com.benchark.proxy.service.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public int increment(int value) {
        return value + 1;
    }
}