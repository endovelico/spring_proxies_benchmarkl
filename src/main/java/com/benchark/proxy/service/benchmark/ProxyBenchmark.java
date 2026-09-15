package com.benchark.proxy.service.benchmark;

import com.benchark.proxy.config.CglibProxyConfig;
import com.benchark.proxy.config.JdkProxyConfig;
import com.benchark.proxy.service.CalculatorService;
import com.benchark.proxy.service.impl.ConcreteCalculator;
import org.openjdk.jmh.annotations.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class ProxyBenchmark {

    private AnnotationConfigApplicationContext jdkContext;
    private AnnotationConfigApplicationContext cglibContext;

    private CalculatorService jdkService;
    private ConcreteCalculator cglibService;

    @Setup(Level.Trial)
    public void setup() {
        jdkContext =
                new AnnotationConfigApplicationContext(JdkProxyConfig.class);

        cglibContext =
                new AnnotationConfigApplicationContext(CglibProxyConfig.class);

        jdkService = jdkContext.getBean(CalculatorService.class);
        cglibService = cglibContext.getBean(ConcreteCalculator.class);
    }

    @TearDown(Level.Trial)
    public void tearDown() {
        jdkContext.close();
        cglibContext.close();
    }

    @Benchmark
    public int interfaceProxy() {
        return jdkService.increment(42);
    }

    @Benchmark
    public int classProxy() {
        return cglibService.increment(42);
    }
}