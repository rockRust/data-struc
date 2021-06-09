package bit.arithmetic.demo.threadtest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
class MyThreadPoolExecutorTest {

    @Test
    public void runTest() throws InterruptedException {
        MyThreadPoolExecutor exec = new MyThreadPoolExecutor(5, 5,
                0, TimeUnit.MINUTES, new LinkedBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 5; i++) {
            exec.submit(new MyThreadPoolExecutor.MyRunnable());
        }
        Thread.sleep(10000);
        // exec.terminated();
        exec.shutdown();

    }


    @Test
    public void dealLock() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 20
                , TimeUnit.SECONDS, new SynchronousQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy());

        Future<String> submit1 = pool.submit(() -> {
            Future<String> submit2 = pool.submit(() -> {
                System.out.println("我是线程2");
                return "线程2";
            });
            String s2 = null;
            try {
                s2 = submit2.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("我是线程1");
            return s2;
        });
        System.out.println("开始执行线程");
        String s = submit1.get();
        System.out.println(s);

    }

}