package interview.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lwx on 2019/2/15.
 */
public class JdkProxyFactory implements InvocationHandler {

    private Object targetObject;

    public Object createProxyInstance(Object targetObject) {
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(
                this.targetObject.getClass().getClassLoader(),
                this.targetObject.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行了");
        return method.invoke(targetObject,args);
    }
}
