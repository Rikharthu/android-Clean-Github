package com.example.domain.model;

public class Message {

    private long mId;
    private String mText;
    private String mSender;

    public Message(long id, String text, String sender) {
        mId = id;
        mText = text;
        mSender = sender;
    }

    public Message() {
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public String getSender() {
        return mSender;
    }

    public void setSender(String sender) {
        mSender = sender;
    }
}
