package bit.arithmetic.demo.threadtest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jiaosong
 * @desc
 * @date 2020/4/25
 */
public class ThreadPoolTest {
    ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 5,
            1000, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    AtomicInteger count = new AtomicInteger(0);

    public void doSomething() {

    }

    private void add() throws ExecutionException, InterruptedException {
        List<Future> futures = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Future<?> future = threadPool.submit(() -> doSomething());
            futures.add(future);
        }
        for (Future future : futures) {
            future.get();
        }

    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolTest test = new ThreadPoolTest();
        test.add();
        System.out.println("result:" + test.count.get());


    }
}
