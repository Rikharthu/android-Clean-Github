package com.example.domain.model;

import java.util.Date;

public class User {
    private long mId;
    private boolean mIsSiteAdmin;
    private String mAvatarUrl;
    private String mLogin;
    private String mType;
    private int mPublicReposCount;
    private int mFollowersCount;
    private int mFollowingCount;
    private Date mCreatedAt;
    private Date mUpdatedAt;

    public User() {
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public boolean isSiteAdmin() {
        return mIsSiteAdmin;
    }

    public void setSiteAdmin(boolean siteAdmin) {
        mIsSiteAdmin = siteAdmin;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        mAvatarUrl = avatarUrl;
    }

    public String getLogin() {
        return mLogin;
    }

    public void setLogin(String login) {
        mLogin = login;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public int getPublicReposCount() {
        return mPublicReposCount;
    }

    public void setPublicReposCount(int publicReposCount) {
        mPublicReposCount = publicReposCount;
    }

    public int getFollowersCount() {
        return mFollowersCount;
    }

    public void setFollowersCount(int followersCount) {
        mFollowersCount = followersCount;
    }

    public int getFollowingCount() {
        return mFollowingCount;
    }

    public void setFollowingCount(int followingCount) {
        mFollowingCount = followingCount;
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
}
