import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * Created by lwx on 2017/9/22.
 */
public class OtherTest {
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
}
