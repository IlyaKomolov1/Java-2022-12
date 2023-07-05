package logging;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class LoggingInvocationHandler implements InvocationHandler {
    private final Object original;
    private final List<Method> annotatedMethods;

    public LoggingInvocationHandler(Object object) {
        this.original = object;
        this.annotatedMethods = getAnnotatedMethods(object.getClass());
    }

    private List<Method> getAnnotatedMethods(Class<?> clazz) {
        List<Method> annotatedMethods = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Log.class)) {
                annotatedMethods.add(method);
            }
        }
        return annotatedMethods;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!method.isDefault() && annotatedMethods.contains(method)) {
            System.out.print("executed method: " + method.getName());
            for (Object arg : args) {
                System.out.print(", param: " + arg);
            }
            System.out.println();
        }
        return method.invoke(original, args);
    }
}







