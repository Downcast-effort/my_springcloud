package com.dandelion.springcloud.service;

/**
 * @author dandelion
 * @version 1.0
 * @date 2021/7/29 19:11
 */

import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public  class ThreadPoolExecutorService {


    private ThreadLocal<BlockingQueue<Runnable>> blockingQueueThreadLocal = new ThreadLocal<>();
    private ThreadLocal<ThreadPoolExecutor> threadPoolExecutorThreadLocal = new ThreadLocal<>();


    public synchronized void addWork(Runnable runnable) {
        BlockingQueue<Runnable> workQueue = blockingQueueThreadLocal.get();
        ThreadPoolExecutor threadPoolExecutor = threadPoolExecutorThreadLocal.get();
        if (null == workQueue) {
            /**
             * 如果队列为null -> 新建一个
             */
            workQueue = new LinkedBlockingQueue<Runnable>();
            blockingQueueThreadLocal.set(workQueue);
        }

        if (threadPoolExecutor == null) {
            int corePoolSize = 5;
            int maximumPoolSize = 50;
            long keepAliveTime = 20;
            TimeUnit unit = TimeUnit.MINUTES;
            threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
            threadPoolExecutorThreadLocal.set(threadPoolExecutor);
        }
        threadPoolExecutor.submit(runnable);
    }

    /**
     * 自旋 直至完成
     *
     * @return
     * @throws Exception
     */
    public synchronized boolean waitComplete() throws Exception {
        ThreadPoolExecutor threadPoolExecutor = threadPoolExecutorThreadLocal.get();
        if (threadPoolExecutor == null) {
            throw new Exception("线程池为空，请初始化,可能未执行addWork方法");
        }
        for (; ; ) {
//            log.info("当前剩余作业:{}", blockingQueueThreadLocal.get().size());
//            log.info("当前活跃作业:{}", threadPoolExecutor.getActiveCount());

            Thread.sleep(1000);
            if (threadPoolExecutor.getActiveCount() == 0) {
                return true;
            }
        }
    }
}