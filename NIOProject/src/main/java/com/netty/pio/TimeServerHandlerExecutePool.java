package com.netty.pio;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 伪异步式I/O的服务器端线程池
 * created by liyurong
 **/
public class TimeServerHandlerExecutePool {

    private ExecutorService executor;

    public TimeServerHandlerExecutePool(int maxPoolSize, int queueSize) {
        /**
         * 创建线程池，指定线程池的
         * corePoolSize--最小数量
         * maximumPoolSize--最大数量
         * keepAliveTime--生命周期
         * unit--生命周期的单位
         * workQueue--待处理的线程队列
         */
        executor = new ThreadPoolExecutor(Runtime.getRuntime()
                .availableProcessors(), maxPoolSize, 120L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize));
    }

    public void execute(java.lang.Runnable task) {//执行传入的线程task
        executor.execute(task);
    }
}