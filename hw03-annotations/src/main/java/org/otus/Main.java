package org.otus;

public class Main {
    public static void main(String... args) throws Exception {
        TestRunner testRunner = new TestRunner();
        testRunner.runTests("org.otus.TestClass");
    }
}