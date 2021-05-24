package bit.arithmetic.demo.concurrent.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author jiaosong
 * @desc
 * @date 2021/5/20
 */
@Slf4j
public class BarrierTest implements Runnable {

    private LinkedBlockingQueue container;

    private Integer THREAD_NUM = 10;
    private CyclicBarrier barrier;
    ExecutorService pool = Executors.newCachedThreadPool();
    private Integer runTimes = 10;

    public BarrierTest(Integer threadNum, Integer runTimes) {
        this.THREAD_NUM = threadNum;
        this.runTimes = runTimes;
        barrier = new CyclicBarrier(THREAD_NUM * 2 + 1);
        container = new LinkedBlockingQueue(10);
    }

    @Override
    public void run() {
        for (int i = 0; i < THREAD_NUM; i++) {
            pool.submit(new Producer());
            pool.submit(new Consumer());
        }
        try {
            barrier.await();
            barrier.await();
        } catch (InterruptedException e) {
        } catch (BrokenBarrierException e) {
        }

    }


    class Producer implements Runnable {

        public void add(Integer food) {
            log.info("begin feed");
            container.add(food);
            log.info("feed finish");
        }

        @Override
        public void run() {
            try {
                barrier.await();
                for (int j = 0; j < runTimes; j++) {
                    add(j);
                }
                barrier.await();
            } catch (InterruptedException e) {
            } catch (BrokenBarrierException e) {
            }
        }
    }


    class Consumer implements Runnable {
        public void take() {

            log.info("begin consume");
            Object food = null;
            try {
                food = container.take();
            } catch (InterruptedException e) {

            }
            log.info("consume---{}", food);
        }

        @Override
        public void run() {
            try {
                barrier.await();
                for (int i = 0; i < runTimes; i++) {
                    take();
                }
                barrier.await();
            } catch (InterruptedException e) {
            } catch (BrokenBarrierException e) {
            }
        }

    }


    public static void main(String[] args) {
        BarrierTest test = new BarrierTest(3, 3);
        test.run();
    }
}
