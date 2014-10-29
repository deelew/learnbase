package base.dilu.kxq.mem;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dilu.kxq
 * Date: 14-9-25
 * Time: 下午8:28
 * To change this template use File | Settings | File Templates.
 */
public class PromotionFailure {

    public static void main(String[] args) throws IOException, InterruptedException {
//        justMinorGC();
//        directOldAllocation();
        directOldAllocationV2()
        ;
    }


    static int _64mInt = 1024 * 1024 * 64 / 4;
    static int _32mInt = 1024 * 1024 * 32 / 4;

    public static int justMinorGC() throws IOException {
        int[] int64m = new int[_64mInt];
        System.out.println(int64m.length);
        int[] int32m = Arrays.copyOf(int64m, _32mInt);
        System.out.println(int32m.length);
        int[] int32m_2 = Arrays.copyOf(int32m, _32mInt);
        System.out.println(int32m.length);
        int[] int64m_2 = Arrays.copyOf(int64m, _32mInt);
        System.out.println(int64m_2.length);
        System.in.read();
        return int32m.length + int32m_2.length + int64m.length + int64m_2.length;
    }

    /*
    -server -Xms238m -Xmx238m -Xmn42m -XX:PermSize=96m -verbose:gc -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:CMSInitiatingOccupancyFraction=90 -XX:+UseCMSInitiatingOccupancyOnly -XX:PrintFLSStatistics=2 -XX:SurvivorRatio=1 -XX:+UseConcMarkSweepGC
    -server -Xms295m -Xmx295m -Xmn99m -XX:PermSize=96m -XX:SurvivorRatio=1
    eden:64m / 0.8 = 80 + 2 = 82
    oldgen: 32 * 6 = 192m
    xmx: 192 + 82 = 274 + 4 = 278 m
     */
    public static void directOldAllocation() throws IOException {
        int[] a1, a2,a3;
        int[] b1, b2,b3;
        a1 = new int[_32mInt];
        System.err.println("\na1");
        b1 = new int[_32mInt];
        System.err.println("\nb1");
        a2 = new int[_32mInt];
        System.err.println("\na2");
        b2 = new int[_32mInt];
        System.err.println("\nb2");
        a3 = new int[_32mInt];
        System.err.println("\na3");
        b3 = new int[_32mInt];
        System.err.println("\nb3");
        b1 = null ;
        b2 = null ;
//        b3 = null ;
        int[] c1 = new int[_64mInt];
        b1 = new int[_32mInt/2];
        System.out.println(a1.length + a2.length + a3.length + b3.length + c1.length);
        System.in.read();
    }

    /*
   -server -Xms470m -Xmx470m -Xmn99m -XX:PermSize=96m -verbose:gc -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:CMSInitiatingOccupancyFraction=90 -XX:+UseCMSInitiatingOccupancyOnly -XX:PrintFLSStatistics=2 -XX:SurvivorRatio=1 -XX:+UseConcMarkSweepGC
   -server -Xms470m -Xmx470m -Xmn99m -XX:PermSize=96m -XX:SurvivorRatio=1
   eden:64m / 0.8 = 80 + 2 = 82
   oldgen: 32 * 12 = 384m
   xmx: 384 + 82 = 466 + 4 = 470 m
    */
    public static void directOldAllocationV2() throws IOException, InterruptedException {
        int [][][] ii = new int[2][6][] ;
//        int [] big = new int[_64mInt];
        int[] ia = new int[10000];
        System.out.println("hash==== " + System.identityHashCode(ia));
        for(int i=0;i<2;i++)
            for(int j=0;j<6;j++)
                ii[i][j] = new int[_32mInt];
        Thread.sleep(1000);
        System.out.println("hash====" + System.identityHashCode(ia));
        System.out.println("\n======after sleep=====");
        for(int j=0;j<6;j++)
            ii[1][j] = null ;
        int[] c1 = new int[_32mInt + 1024 * 1024 ];
        int[] c2 = new int[_32mInt + 1024 * 1024 ];
        System.out.println(ii[0].length);
        ii = null ;
//        int[] c3 = new int[_64mInt];
//        int[] c4 = new int[_64mInt];
    }

    public static void cmsGCPlusMinorGC() {
        //TODO ?
    }
}
