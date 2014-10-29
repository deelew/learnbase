package base.dilu.kxq;

/**
 * Created with IntelliJ IDEA.
 * User: dilu.kxq
 * Date: 14-7-3
 * Time: 上午11:17
 * To change this template use File | Settings | File Templates.
 */
public class LocalParamMemoryRelease {
    public static void main(String[] args) throws InterruptedException {
        int size = Integer.valueOf(args[0]);
        int [] tmp = new int [1024 * 1024 * size];
        int [] tmp2 = new int[1024* 1024  * size];
        System.gc();
        System.out.println(System.currentTimeMillis());
        Thread.sleep(1000 * 10);
        int [] tmp3 = new int[1024* 1024  * size];
        int [] tmp4 = new int[1024* 1024  * size];
        tmp = null;
        tmp2 = null ;
        System.gc();
        Thread.sleep(1000 * 10);
    }
}
