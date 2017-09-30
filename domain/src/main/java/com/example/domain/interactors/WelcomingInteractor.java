package com.example.domain.interactors;

public interface WelcomingInteractor {

    /**
     * Responsible for talking to the UI on the <strong>main</strong> thread.
     */
    interface Callback {
        void onMessageRetrieved(String message);

        void onRetrievalFailed(String error);
    }
}
