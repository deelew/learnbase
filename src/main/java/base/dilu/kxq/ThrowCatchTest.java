package base.dilu.kxq;

/**
 * Created with IntelliJ IDEA.
 * User: dilu.kxq
 * Date: 14-8-22
 * Time: 下午1:56
 * To change this template use File | Settings | File Templates.
 */
public class ThrowCatchTest {
    public static void main(String[] args) throws InterruptedException {

                for(int i =0;i<4;i++)
                    new Thread( new Runnable() {
                        @Override
                        public void run() {
                            loop();
                        }
                    }).start() ;
        Thread.sleep(1000 * 1000);
    }
    static void loop(){

        while (true) {
            try {
                System.out.println("hello test");
                func(0);
            } catch (Exception e) {

            }
        }
    }

    static void func(int i) {
        if (i > 200)
            throw new RuntimeException("");
        func(++i);
    }
}
