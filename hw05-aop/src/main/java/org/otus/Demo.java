package org.otus;

import java.lang.reflect.Proxy;

public class Demo {
    public static void main(String[] args) {
        TestLoggingInterface testLogging = (TestLoggingInterface) Proxy.newProxyInstance(
                TestLogging.class.getClassLoader(),
                TestLogging.class.getInterfaces(),
                new LoggingInvocationHandler(new TestLogging())
        );
        testLogging.calculation(6);
        testLogging.calculation(3, 5);
        testLogging.calculation(1, 2, "hello");
    }
}
