package com.demo.jdkproxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lwx on 2018/8/15.
 */
public class JDKProxyFactory implements InvocationHandler {

    private Object targetObject;

    public Object createProxyInstance(Object targetObject) {
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(this.targetObject.getClass().getClassLoader(),
                this.targetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("代理执行了");
        return method.invoke(targetObject, args);
    }

}
