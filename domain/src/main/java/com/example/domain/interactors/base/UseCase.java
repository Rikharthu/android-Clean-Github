package com.example.domain.interactors.base;

import com.example.domain.executors.Executor;
import com.example.domain.executors.PostExecutionThread;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

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
public abstract class UseCase<T, Params> {

    private final CompositeDisposable mDisposables;
    protected Executor mThreadExecutor;
    protected PostExecutionThread mPostExecutionThread;

    public UseCase(Executor threadExecutor, PostExecutionThread postExecutionThread) {
        mThreadExecutor = threadExecutor;
        mPostExecutionThread = postExecutionThread;
        mDisposables = new CompositeDisposable();
    }

    /**
     * Builds an {@link Observable} which will be used when executing the current {@link UseCase}.
     */
    public abstract Observable<T> buildUseCaseObservable(Params params);

    /**
     * Executes the current use case
     *
     * @param observer {@link DisposableObserver} which will be listening to the observable build
     *                 by {@link #buildUseCaseObservable(Object)} method.
     * @param params   Parameters (Optional) used to build/execute this use case.
     */
    public void execute(DisposableObserver<T> observer, Params params) {
        final Observable<T> observable = buildUseCaseObservable(params)
                .subscribeOn(Schedulers.from(mThreadExecutor))
                .observeOn(mPostExecutionThread.getScheduler());
        addDisposable(observable.subscribeWith(observer));
    }

    /**
     * Dispose from current {@link CompositeDisposable}.
     */
    public void dispose() {
        if (!mDisposables.isDisposed()) {
            mDisposables.dispose();
        }
    }

    /**
     * Dispose from current {@link CompositeDisposable}.
     */
    private void addDisposable(Disposable disposable) {
//        Preconditions.checkNotNull(disposable);
//        Preconditions.checkNotNull(mDisposables);
        mDisposables.add(disposable);
    }
}
