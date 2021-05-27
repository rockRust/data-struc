package bit.arithmetic.demo.concurrent.aqs;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

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

    class SemaphoreOnLock {
        private final ReentrantLock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();
        private int permitNum;

        public void SemaphoreOnLock(int permit) {
            lock.lock();
            try {
                this.permitNum = permit;
            } finally {
                lock.unlock();
            }
        }

        public void acquire() {
            lock.lock();
            try {
                while (permitNum < 1) {
                    condition.await();
                }
                permitNum--;
            } catch (InterruptedException e) {
            } finally {
                lock.unlock();
            }
        }

        public void release() {
            lock.lock();
            try {
                permitNum++;
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
