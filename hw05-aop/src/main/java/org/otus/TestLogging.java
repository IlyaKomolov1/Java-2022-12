package org.otus;

public class TestLogging implements TestLoggingInterface {
    @Log
    public void calculation(int param) {
        System.out.println("executed method: calculation, param: " + param);
    }

    @Log
    public void calculation(int param1, int param2) {
        System.out.println("executed method: calculation, param1: " + param1 + ", param2: " + param2);
    }

    @Log
    public void calculation(int param1, int param2, String param3) {
        System.out.println("executed method: calculation, param1: " + param1 + ", param2: " + param2 + ", param3: " + param3);
    }
}