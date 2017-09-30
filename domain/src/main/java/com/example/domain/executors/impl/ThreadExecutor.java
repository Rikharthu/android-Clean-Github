package com.example.domain.executors.impl;

import com.example.domain.executors.Executor;
import com.example.domain.interactors.base.AbstractInteractor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * This singleton class will make sure that each interactor operation gets a background thread
 */
public class ThreadExecutor implements Executor {

    private static volatile ThreadExecutor sInstance;

    private static final int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    private static final int KEEP_ALIVE_TIME = 1;
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT;
    private static final BlockingQueue<Runnable> WORK_QUEUE;

    static {
        KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;
        WORK_QUEUE = new LinkedBlockingQueue<>();
    }

    private ThreadPoolExecutor mThreadPoolExecutor;

    private ThreadExecutor() {
        mThreadPoolExecutor = new ThreadPoolExecutor(
                NUMBER_OF_CORES,
                NUMBER_OF_CORES * 2,
                KEEP_ALIVE_TIME,
                KEEP_ALIVE_TIME_UNIT,
                WORK_QUEUE,
                new BackgroundThreadFactory()
        );
    }

    public static Executor getInstance() {
        if (sInstance == null) {
            synchronized (ThreadExecutor.class) {
                if (sInstance == null) {
                    sInstance = new ThreadExecutor();
                }
            }
        }
        return sInstance;
    }

    @Override
    public void execute(final AbstractInteractor interactor) {
        mThreadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                // run the main logic
                interactor.run();
                // mark it as finished
                interactor.onFinished();
            }
        });
    }

    private static class BackgroundThreadFactory implements ThreadFactory {
        @Override
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("BG-Thread[" + System.currentTimeMillis() + "]");
            thread.setPriority(Thread.NORM_PRIORITY + 1);
            // A exception handler is created to log the exception from threads
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread thread, Throwable ex) {
                    // TODO log error ?
                }
            });
            return thread;
        }
    }
}
