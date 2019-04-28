package interview.test.singletonclass2;

/**
 * Created by lwx on 2019/2/15.
 */
public class DoubleLock {

    private DoubleLock(){}

    public static DoubleLock instance;

    public static DoubleLock getInstance() {
        if(instance == null){
            synchronized (DoubleLock.class) {
                if (instance == null) {
                    return new DoubleLock();
                }
            }
        }
        return instance;
    }
}
