package bit.arithmetic.demo.concurrent.aqs;

import java.util.concurrent.Semaphore;

/**
 * @author jiaosong
 * @desc
 * @date 2021/5/6
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore s = new Semaphore(2);
        try {
            s.acquire();
        } catch (InterruptedException ignore) {
        }

    }
}
