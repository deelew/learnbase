package base.dilu.kxq;

/**
 * Created with IntelliJ IDEA.
 * User: dilu.kxq
 * Date: 14-9-11
 * Time: 下午2:30
 * To change this template use File | Settings | File Templates.
 */
public class EmptyStringCompare {
    String str = "";
    String strNonEmpty = " ok ";
    public void test(){
        String empty = "";
        String nullStr = null ;
        System.out.println(empty);
        System.out.println(nullStr);
        System.out.println(new Inner().anotherStr == str);
        System.out.println(str == new AnotherEmptyString().getStr());
    }
    public static void main(String[] args ){
        new EmptyStringCompare().test();
    }
    static class Inner {
        String anotherStr = "";
    }
}
