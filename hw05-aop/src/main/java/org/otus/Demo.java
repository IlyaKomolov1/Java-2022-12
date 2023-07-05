package org.otus;

import logging.TestLogging;
import logging.TestLoggingInterface;
import IoC.IoC;
public class Demo {
    public static void main(String[] args) {
        TestLoggingInterface testLogging = IoC.createProxy(new TestLogging());
        testLogging.calculation(6);
        testLogging.calculation(3, 5);
        testLogging.calculation(1, 2, "hello");
    }
}

