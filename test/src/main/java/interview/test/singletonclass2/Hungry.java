package interview.test.singletonclass2;

/**
 * Created by lwx on 2019/2/15.
 */
public class Hungry {

    private Hungry(){
        super();
    }

    public static Hungry instance = new Hungry();

    public static Hungry getInstance(){
        return instance;
    }
}
