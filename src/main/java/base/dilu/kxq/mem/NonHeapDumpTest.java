package base.dilu.kxq.mem;

import java.io.IOException;
import java.nio.ByteBuffer;
/**
 * Created with IntelliJ IDEA.
 * User: dilu.kxq
 * Date: 14-11-5
 * Time: 上午11:24
 * To change this template use File | Settings | File Templates.
 */
public class NonHeapDumpTest {
    public static void main(String[] args) throws IOException {
        ByteBuffer bytes = ByteBuffer.allocateDirect(1024 * 1024 * 32);
        for(int i=0;i<1024*1024*32;i++)
            bytes.put((byte)i);
        System.in.read();
    }
}
