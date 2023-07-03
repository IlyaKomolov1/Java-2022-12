package logging;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggingInvocationHandler implements InvocationHandler {
    private final Object original;

    public LoggingInvocationHandler(Object object) {
        this.original = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!method.isDefault() && method.isAnnotationPresent(Log.class)) {
            System.out.print("executed method: " + method.getName());
            for (Object arg : args) {
                System.out.print(", param: " + arg);
            }
            System.out.println();
        }
        return method.invoke(original, args);
    }
}
