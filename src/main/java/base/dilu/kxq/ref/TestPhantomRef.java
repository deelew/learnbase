package base.dilu.kxq.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dilu.kxq
 * Date: 14-10-29
 * Time: 下午4:35
 * To change this template use File | Settings | File Templates.
 */
public class TestPhantomRef {
    public static void main(String[] args) {
        testPhantom();
//        testWeak();
//        testSoft();
    }

    private static final int _16m = 1024 * 1024 * 16 / 4;

    static void testPhantom() {
        System.out.println("phantom ref release");
        ReferenceQueue<int[]> queue = new ReferenceQueue<int[]>();
        List<PhantomReference<int[]>> pList = new ArrayList<PhantomReference<int[]>>(10);
        for (int i = 0; i < 10; i++) {
            pList.add(new PhantomReference<int[]>(new int[_16m], queue));
            PhantomReference<int[]> r = (PhantomReference) queue.poll();
//            if (r != null)
//                r.clear();
        }
    }

    static void testWeak() {
        System.out.println("weak ref release");
        ReferenceQueue<int[]> queue = new ReferenceQueue<int[]>();
        List<WeakReference<int[]>> wLst = new ArrayList<WeakReference<int[]>>(10);
        for (int i = 0; i < 10; i++) {
            wLst.add(new WeakReference<int[]>(new int[_16m], queue));
        }
    }

    static void testSoft() {
        System.out.println("soft ref release");
        ReferenceQueue<int[]> queue = new ReferenceQueue<int[]>();
        List<SoftReference<int[]>> sLst = new ArrayList<SoftReference<int[]>>(10);
        for (int i = 0; i < 10; i++) {
            sLst.add(new SoftReference(new int[_16m], queue));
        }
    }
}
