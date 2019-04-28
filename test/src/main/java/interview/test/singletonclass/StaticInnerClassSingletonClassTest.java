package interview.test.singletonclass;

/**
 * Created by lwx on 2018/3/16.
 */
public class StaticInnerClassSingletonClassTest {

    /**
     * 4、静态内部类模式
     */

    private StaticInnerClassSingletonClassTest(){}

    private static class SingleInnerHolder{
        public static StaticInnerClassSingletonClassTest instance = new StaticInnerClassSingletonClassTest();
    }

    public static StaticInnerClassSingletonClassTest getInstance(){
        return SingleInnerHolder.instance;
    }
}
