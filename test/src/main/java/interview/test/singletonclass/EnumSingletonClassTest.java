package interview.test.singletonclass;

/**
 * Created by lwx on 2018/3/16.
 */
public enum EnumSingletonClassTest {

    /**
     * 5、枚举模式
     */

    INSTANCE;

    EnumSingletonClassTest(){
        //instance = new EnumSingletonClassTest();//TODO...
    }

    private EnumSingletonClassTest instance;

    public EnumSingletonClassTest getInstance(){
        return instance;
    }
}
