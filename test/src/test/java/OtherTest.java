import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

/**
 * Created by lwx on 2017/9/22.
 */
public class OtherTest {

    int i;
    Integer ii;

    @Test
    public void test(){
        System.out.println(true);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        try {
            Selector selector = Selector.open();
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.register(selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test2(){
        System.out.println(i);
        System.out.println(ii);

        ii = 1;
        System.out.println(ii);

        int iii = 0b110;
    }
}
