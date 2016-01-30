package com.tw.magixception;

import javax.ws.rs.core.Response;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class ExceptionProcessor {

    private GlobalExceptionHandler handler = new GlobalExceptionHandler();
    private HashMap<Class, Method> handlerMethods = new HashMap<>();

    public ExceptionProcessor() {
        scanExceptionHandlers();
    }

    private void scanExceptionHandlers() {
        Class<GlobalExceptionHandler> c = GlobalExceptionHandler.class;
        Method[] methods = c.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(ExceptionHandle.class) && m.getParameterCount() == 1) {
                Class<?> fp = m.getParameterTypes()[0];
                handlerMethods.put(fp, m);
            }
        }
    }

    public Response handleException(Throwable e) {
        Method m = handlerMethods.get(e.getClass());
        if (m == null) {
            m = handlerMethods.get(Exception.class);
        }
        try {
            return (Response) m.invoke(handler, e);
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (InvocationTargetException e1) {
            e1.printStackTrace();
        }
        return null;
    }
}
