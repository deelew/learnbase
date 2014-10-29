package base.dilu.kxq.ref;

/**
 * Created with IntelliJ IDEA.
 * User: dilu.kxq
 * Date: 14-10-28
 * Time: 下午3:59
 * To change this template use File | Settings | File Templates.
 */
public class RefTestObj {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString() + "[id=" + this.id + "]";
    }

    @Override
    protected void finalize() {
        System.out.println("Object [" + this.hashCode() + "][id=" + this.id + "] come into finalize");
        try {
            super.finalize();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
