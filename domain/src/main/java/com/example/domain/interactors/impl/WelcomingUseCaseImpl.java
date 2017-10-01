package com.example.domain.interactors.impl;

import com.example.domain.executors.Executor;
import com.example.domain.executors.MainThread;
import com.example.domain.interactors.WelcomingInteractor;
import com.example.domain.interactors.base.UseCase;
import com.example.domain.repository.MessageRepository;

// Extends the UseCase since it takes care of runninag on the background thread
public class WelcomingUseCaseImpl extends UseCase implements WelcomingInteractor {

    private MessageRepository mMessageRepository;
    private Callback mCallback;


    public WelcomingUseCaseImpl(Executor threadExecutor, MainThread mainThread, Callback callback, MessageRepository repository) {
        super(threadExecutor, mainThread);
        mMessageRepository = repository;
        mCallback = callback;
    }

    private void notifyError() {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onRetrievalFailed("Nothing to welcome you with :(");
            }
        });
    }

    private void postMessage(final String msg) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onMessageRetrieved(msg);
            }
        });
    }

    @Override
    public void run() {
        // Retrieve the message
        final String message = mMessageRepository.getAllMessages().get(0).getText();
        // check if we have failed to retreive our message
        if (message == null || message.length() == 0) {
            notifyError();
            return;
        }
        postMessage(message);
    }
}
