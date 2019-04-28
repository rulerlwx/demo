package interview.test.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by lwx on 2019/2/16.
 */
public class Test {
    int i = 1 ;
    public static void main(String[] args) {
        try {
            Class<?> test = Class.forName("interview.test.reflect.Test");
            System.out.println(test);

            Method[] methods = test.getDeclaredMethods();
            for(Method m : methods){
                System.out.println(m.getName());
            }

            Field[] fields = test.getDeclaredFields();
            for (Field f : fields) {
                System.out.println(f.getName());
                System.out.println(f.get(test.newInstance()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
