package bit.arithmetic.demo.threadtest;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author jiaosong
 * @desc
 * @date 2021/4/29
 */
@Slf4j
public class MyThreadPoolExecutor extends ThreadPoolExecutor {

    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    private AtomicLong allTaskCount = new AtomicLong(1);

    private AtomicLong allTaskCostTime = new AtomicLong(0);


    public MyThreadPoolExecutor(int corePoolSize,
                                int maximumPoolSize,
                                long keepAliveTime,
                                TimeUnit unit,
                                BlockingQueue<Runnable> workQueue,
                                ThreadFactory threadFactory,
                                RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        long currTime = System.nanoTime();
        startTime.set(currTime);
        log.info("execute before method");
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        try {
            log.info("execute after method");
            long endTime = System.nanoTime();
            long costTime = endTime - startTime.get();
            allTaskCostTime.addAndGet(costTime);
            allTaskCount.incrementAndGet();
            log.info("task:{} run cast time:{}", r, costTime);
        } finally {
            super.afterExecute(r, t);
        }
    }

    @Override
    protected void terminated() {
        try {
            log.info("terminate method, task run avgTime:{}", allTaskCostTime.get() / allTaskCount.get());
        } finally {
            super.terminated();
        }
    }

}
