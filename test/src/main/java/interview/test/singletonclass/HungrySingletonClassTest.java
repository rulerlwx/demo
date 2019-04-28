package interview.test.singletonclass;

/**
 * Created by lwx on 2018/3/16.
 */
public class HungrySingletonClassTest {

    /**
     * 1、饿汉模式
     */

    private HungrySingletonClassTest(){}

    private static final HungrySingletonClassTest instance = new HungrySingletonClassTest();

    public static HungrySingletonClassTest getInstance(){
        return instance;
    }

}
