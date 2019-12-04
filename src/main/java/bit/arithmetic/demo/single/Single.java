package bit.arithmetic.demo.single;

/**
 * create at:  2019-12-04  15:08
 *
 * @author : js
 * @description: 单例 double-check
 */
public class Single {


    private volatile Single single;

    private Single() {
    }

    public Single getInstance() {
        if (single == null) {
            synchronized (Single.class) {
                if (single == null) {
                    single = new Single();
                }
            }
        }
        return single;
    }

}
