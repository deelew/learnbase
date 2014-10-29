package base.dilu.kxq;

/**
 * Created with IntelliJ IDEA.
 * User: dilu.kxq
 * Date: 14-10-22
 * Time: 上午11:15
 * To change this template use File | Settings | File Templates.
 */
public class IdentityHashCodeTest {
    private static final int _32m = 1024 * 1024 * 32 / 4;

    /*
     * jvm args:
        -server -Xms473m -Xmx473m -Xmn64m -XX:SurvivorRatio=3 -XX:PermSize=96m -verbose:gc -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintHeapAtGC
    */
    public static void main(String[] args) throws InterruptedException {
        int[] first = new int[_32m];
        System.out.println("=====first " + System.identityHashCode(first));
        Thread.sleep(100);
        int[] second = new int[_32m];
        System.out.println("=====first after second created " + System.identityHashCode(first));
        Thread.sleep(100);
        System.out.println("====second " + System.identityHashCode(second));
        int[] third = new int[_32m];
        Thread.sleep(100);
        System.out .println("====another gc");
    }

}
