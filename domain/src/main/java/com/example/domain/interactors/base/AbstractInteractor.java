package com.example.domain.interactors.base;

import com.example.domain.executors.Executor;
import com.example.domain.executors.MainThread;

/**
 * This abstract class implements some common methods for all interactors.
 * Canceling an interactor, check if its running and finishing an interactor
 * has mostly the same code throughout so that is why this class was created.
 * Field methods are declared volatile as we might use these methods from
 * different threads (mainly from UI though)
 * <hr/>
 * <i>For example, when an Activity is getting destroyed then we should probably cancel
 * and interactor but the request will come from the UI thread unless the request was
 * specifically assigned to a background thread</i>
 */
public abstract class AbstractInteractor implements Interactor {

    protected Executor mThreadExecutor;
    protected MainThread mMainThread;

    protected volatile boolean mIsCanceled;
    protected volatile boolean mIsRunning;

    public AbstractInteractor(Executor threadExecutor, MainThread mainThread) {
        mThreadExecutor = threadExecutor;
        mMainThread = mainThread;
    }

    /**
     * This method contains the actual business logic of the interactor.
     * It SHOULD NOT BE USED DIRECTLY but, instead, a developer should call the execute() method
     * of an interactor to make sure the operation is done on a background thread.
     * <p/>
     * This method should only be called directly while doing unit/integration tests.
     * That is the only reason it is declared
     * public as to help with easier testing.
     */
    public abstract void run();

    public void cancel() {
        mIsCanceled = true;
        mIsRunning = false;
    }

    public void onFinished() {
        mIsRunning = false;
        mIsCanceled = false;
    }

    // Use this method to start the Interactor
    @Override
    public void execute() {
        // mark this as running
        this.mIsRunning = true;
        // start running this interactor in the background
        mThreadExecutor.execute(this);
    }
}
