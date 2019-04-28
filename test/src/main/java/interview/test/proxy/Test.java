package interview.test.proxy;

/**
 * Created by lwx on 2019/2/16.
 */
public class Test {

    public static void main(String[] args) {
        JdkProxyFactory factory = new JdkProxyFactory();
        Service service = (Service) factory.createProxyInstance(new ServiceImpl());
        service.sayHi();
    }
}
