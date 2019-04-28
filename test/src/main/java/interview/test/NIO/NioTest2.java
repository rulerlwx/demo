package interview.test.NIO;

import java.nio.Buffer;

/**
 * Created by lwx on 2019/2/21.
 */
public class NioTest2 extends Buffer{
    @Override
    public boolean isReadOnly() {
        return false;
    }

    @Override
    public boolean hasArray() {
        return false;
    }

    @Override
    public Object array() {
        return null;
    }

    @Override
    public int arrayOffset() {
        return 0;
    }

    @Override
    public boolean isDirect() {
        return false;
    }
}
