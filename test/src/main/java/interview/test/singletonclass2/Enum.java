package interview.test.singletonclass2;

/**
 * Created by lwx on 2019/2/15.
 */
public enum Enum {

    instance;

    private MyTest test;

    private Enum(){
        test = new MyTest();
    }
    
    public MyTest getTest(){
        return test;
    }

}