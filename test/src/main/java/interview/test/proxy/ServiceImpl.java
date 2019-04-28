package interview.test.proxy;

/**
 * Created by lwx on 2019/2/16.
 */
public class ServiceImpl implements Service {
    @Override
    public void sayHi() {
        System.out.println("您好");
    }
}
