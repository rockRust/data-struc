package bit.arithmetic.demo.threadtest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jiaosong
 * @desc
 * @date 2021/6/8
 */
public class RejectTest {

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1,
            1000, TimeUnit.SECONDS, new SynchronousQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("son runnable thread name: " + Thread.currentThread().getName());
                    Thread.sleep(10000);
                } catch (InterruptedException ignore) {

                }
            }
        };
        List<Future> result = new ArrayList();
        for (int i = 0; i < 1; i++) {
            Future<?> submit = executor.submit(() -> {
                long startTime = System.currentTimeMillis();
                System.out.println("f runnable thread name: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ignore) {

                }
                Future<?> submit1 = executor.submit(runnable);
                long costTime = System.currentTimeMillis() - startTime;
                System.out.println("f submit son1 thread name: " + Thread.currentThread().getName() + " costTime: " + (System.currentTimeMillis() - startTime));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ignore) {

                }
                Future<?> submit2 = executor.submit(runnable);
                System.out.println("f submit son2 " + Thread.currentThread().getName() + " costTime: " + (System.currentTimeMillis() - startTime));
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ignore) {

                }
                try {
                    submit1.get();
                    submit2.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });
            result.add(submit);
        }
        for (Future future : result) {
            future.get();
        }
        System.out.println("finish thread name: " + Thread.currentThread().getName());
    }
}
