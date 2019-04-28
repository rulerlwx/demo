package interview.test.singletonclass;

/**
 * Created by lwx on 2018/3/16.
 */
public class LazySingletonClassTest {

    /**
     * 2、懒汉模式
     */

    private LazySingletonClassTest(){}

    private static LazySingletonClassTest instance= null;

    public static LazySingletonClassTest getInstance(){
        if(instance == null){
            instance = new LazySingletonClassTest();
        }
        return instance;
    }
}
