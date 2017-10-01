package com.example.uberv.cleangithub.model;


import java.util.Date;

public class RepoModel {
    private long mId;
    private String mName;
    private boolean mIsPrivate;
    private boolean mIsFork;
    private Date mCreatedAt;
    private Date mUpdatedAt;
    private String mGitUrl;
    private int mSize;
    private String mLanguage;
    private int mForksCount;
    private int mForks;
    private int mWatchersCount;
    private String mDefaultBranch;

    private long mOwnerId;
    private String mOwnerAvatarUrl;
    private String mOwnerUsername;

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

    public boolean isPrivate() {
        return mIsPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        mIsPrivate = aPrivate;
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

    public long getOwnerId() {
        return mOwnerId;
    }

    public void setOwnerId(long ownerId) {
        mOwnerId = ownerId;
    }

    public String getOwnerAvatarUrl() {
        return mOwnerAvatarUrl;
    }

    public void setOwnerAvatarUrl(String ownerAvatarUrl) {
        mOwnerAvatarUrl = ownerAvatarUrl;
    }

    public String getOwnerUsername() {
        return mOwnerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        mOwnerUsername = ownerUsername;
    }
}
