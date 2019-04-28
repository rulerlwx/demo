package interview.test.singletonclass2;

/**
 * Created by lwx on 2019/2/15.
 */
public class Lazy {

    private Lazy(){}

    public static Lazy instance;

    public static Lazy getInstance(){
        if (instance != null) {
            return instance;
        }
        return new Lazy();
    }
}
