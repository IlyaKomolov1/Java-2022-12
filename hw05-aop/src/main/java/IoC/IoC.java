package IoC;

import logging.LoggingInvocationHandler;

import java.lang.reflect.Proxy;
public class IoC {
    public static <T> T createProxy(T target) {
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        return (T) Proxy.newProxyInstance(classLoader, interfaces, new LoggingInvocationHandler(target));
    }
}