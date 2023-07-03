package wrapper;
import logging.LoggingInvocationHandler;
import logging.TestLogging;
import logging.TestLoggingInterface;

import java.lang.reflect.Proxy;

public class TestLoggingWrapper implements TestLoggingInterface {
    private final TestLoggingInterface testLogging;

    public TestLoggingWrapper() {
        TestLogging testLoggingImpl = new TestLogging();
        LoggingInvocationHandler invocationHandler = new LoggingInvocationHandler(testLoggingImpl);
        testLogging = (TestLoggingInterface) Proxy.newProxyInstance(
                TestLogging.class.getClassLoader(),
                TestLogging.class.getInterfaces(),
                invocationHandler
        );
    }

    public void calculation(int param) {
        testLogging.calculation(param);
    }

    public void calculation(int param1, int param2) {
        testLogging.calculation(param1, param2);
    }

    public void calculation(int param1, int param2, String param3) {
        testLogging.calculation(param1, param2, param3);
    }
}
