package com.example.domain.threading;

import com.example.domain.executors.MainThread;

public class TestMainThread implements MainThread {
    @Override
    public void post(Runnable runnable) {
        // tests can run on this thread, no need to invoke other threads
        runnable.run();
    }
}
