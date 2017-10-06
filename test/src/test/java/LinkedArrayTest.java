import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by lwx on 2017/10/2.
 */
public class LinkedArrayTest {
    @Test
    public void testList(){
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        for (String str : list) {
            if ("b".equals(str)) {
                list.remove(str);
            }
        }

//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String str = iterator.next();
//            if ("a".equals(str)) {
//                //iterator.remove();
//                list.add("c");
//            }
//        }
    }
}
