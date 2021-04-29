package bit.arithmetic.demo.threadtest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
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
            exec.submit(() -> {
                try {
                    Thread.sleep(5000);
                    log.info("debug");
                } catch (InterruptedException e) {

                }
            });
        }
        Thread.sleep(10000);
        exec.shutdown();

    }
}