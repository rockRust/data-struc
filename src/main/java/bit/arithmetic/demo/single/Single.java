package bit.arithmetic.demo.single;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

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

    public static void main(String[] args) {

        List<String> test = new ArrayList<>();
        test.add("1");
        test.add("2");
        test.add("1");

    }
}
