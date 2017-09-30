package com.example.domain.interactors.base;

/**
 * This is the main interface of an interactor (UseCase). Each interactor serves a specific use case.
 */
public interface Interactor {

    /**
     * This is the main method that starts an interactor. It will make sure that the interactor is
     * done on a background thread.
     */
    void execute();
}
