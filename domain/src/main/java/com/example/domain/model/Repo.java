package com.example.domain.model;

import java.util.Date;

public class Repo {

    private long mId;
    private String mName;
    private String mFullName;
    private User mOwner;
    private boolean mIsPrivate;
    private String mHtmlUrl;
    private String mDescription;
    private boolean mIsFork;
    private Date mCreatedAt;
    private Date mUpdatedAt;
    private Date mPushedAt;
    private String mGitUrl;
    private int mSize;
    private String mLanguage;
    private int mForksCount;
    private int mForks;
    private int mWatchersCount;
    private String mDefaultBranch;

    public Repo() {
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public User getOwner() {
        return mOwner;
    }

    public void setOwner(User owner) {
        mOwner = owner;
    }

    public boolean isPrivate() {
        return mIsPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        mIsPrivate = aPrivate;
    }

    public String getHtmlUrl() {
        return mHtmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        mHtmlUrl = htmlUrl;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public boolean isFork() {
        return mIsFork;
    }

    public void setFork(boolean fork) {
        mIsFork = fork;
    }

    public Date getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        mCreatedAt = createdAt;
    }

    public Date getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        mUpdatedAt = updatedAt;
    }

    public Date getPushedAt() {
        return mPushedAt;
    }

    public void setPushedAt(Date pushedAt) {
        mPushedAt = pushedAt;
    }

    public String getGitUrl() {
        return mGitUrl;
    }

    public void setGitUrl(String gitUrl) {
        mGitUrl = gitUrl;
    }

    public int getSize() {
        return mSize;
    }

    public void setSize(int size) {
        mSize = size;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public void setLanguage(String language) {
        mLanguage = language;
    }

    public int getForksCount() {
        return mForksCount;
    }

    public void setForksCount(int forksCount) {
        mForksCount = forksCount;
    }

    public int getForks() {
        return mForks;
    }

    public void setForks(int forks) {
        mForks = forks;
    }

    public int getWatchersCount() {
        return mWatchersCount;
    }

    public void setWatchersCount(int watchersCount) {
        mWatchersCount = watchersCount;
    }

    public String getDefaultBranch() {
        return mDefaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        mDefaultBranch = defaultBranch;
    }
}
