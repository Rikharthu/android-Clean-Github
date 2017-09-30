package com.example.domain.interactors;

import com.example.domain.executors.Executor;
import com.example.domain.executors.MainThread;
import com.example.domain.interactors.impl.WelcomingInteractorImpl;
import com.example.domain.model.Message;
import com.example.domain.repository.MessageRepository;
import com.example.domain.threading.TestMainThread;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.mockito.Mockito.when;

public class WelcomingTest {

    private MainThread mMainThread;
    @Mock
    private Executor mExecutor;
    @Mock
    private MessageRepository mMessageRepository;
    @Mock
    private WelcomingInteractor.Callback mMockedCallback;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        mMainThread = new TestMainThread();
    }

    @Test
    public void testWelcomeMessageFound() throws Exception {
        Message message = new Message(1, "Hello, World!", "Java");

        when(mMessageRepository.getAllMessages()).thenReturn(Arrays.asList(message));

        WelcomingInteractorImpl interactor = new WelcomingInteractorImpl(
                mExecutor,
                mMainThread,
                mMockedCallback,
                mMessageRepository
        );
        // During tests use .run() method instead of .execute()
        interactor.run();

        interactor.execute();

        Mockito.verify(mMessageRepository).getAllMessages();
        Mockito.verifyNoMoreInteractions(mMessageRepository);
        Mockito.verify(mMockedCallback).onMessageRetrieved(message.getText());
    }

    @Test
    public void testWelcomeMessageNotFound() throws Exception {
        Message message = new Message();

        when(mMessageRepository.getAllMessages()).thenReturn(Arrays.asList(message));

        WelcomingInteractorImpl interactor = new WelcomingInteractorImpl(
                mExecutor,
                mMainThread,
                mMockedCallback,
                mMessageRepository
        );
        interactor.run();

        Mockito.verify(mMessageRepository).getAllMessages();
        Mockito.verifyNoMoreInteractions(mMessageRepository);
        Mockito.verify(mMockedCallback).onRetrievalFailed("Nothing to welcome you with :(");
    }
}
