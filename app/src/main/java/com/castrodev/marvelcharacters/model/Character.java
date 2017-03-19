
package com.castrodev.marvelcharacters.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Character implements Parcelable {

    @SerializedName("comics")
    private InfoDetail mComics;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("events")
    private InfoDetail mEvents;
    @SerializedName("id")
    private Long mId;
    @SerializedName("modified")
    private Date mModified;
    @SerializedName("name")
    private String mName;
    @SerializedName("resourceURI")
    private String mResourceURI;
    @SerializedName("series")
    private InfoDetail mSeries;
    @SerializedName("stories")
    private InfoDetail mStories;
    @SerializedName("thumbnail")
    private Thumbnail mThumbnail;
    @SerializedName("urls")
    private List<Url> mUrls;

    public Character(String name) {
        mName = name;
    }

    public InfoDetail getComics() {
        return mComics;
    }

    public void setComics(InfoDetail comics) {
        mComics = comics;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public InfoDetail getEvents() {
        return mEvents;
    }

    public void setEvents(InfoDetail events) {
        mEvents = events;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Date getModified() {
        return mModified;
    }

    public void setModified(Date modified) {
        mModified = modified;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getResourceURI() {
        return mResourceURI;
    }

    public void setResourceURI(String resourceURI) {
        mResourceURI = resourceURI;
    }

    public InfoDetail getSeries() {
        return mSeries;
    }

    public void setSeries(InfoDetail series) {
        mSeries = series;
    }

    public InfoDetail getStories() {
        return mStories;
    }

    public void setStories(InfoDetail stories) {
        mStories = stories;
    }

    public Thumbnail getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        mThumbnail = thumbnail;
    }

    public List<Url> getUrls() {
        return mUrls;
    }

    public void setUrls(List<Url> urls) {
        mUrls = urls;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.mComics, flags);
        dest.writeString(this.mDescription);
        dest.writeParcelable(this.mEvents, flags);
        dest.writeValue(this.mId);
        dest.writeLong(this.mModified != null ? this.mModified.getTime() : -1);
        dest.writeString(this.mName);
        dest.writeString(this.mResourceURI);
        dest.writeParcelable(this.mSeries, flags);
        dest.writeParcelable(this.mStories, flags);
        dest.writeParcelable(this.mThumbnail, flags);
        dest.writeList(this.mUrls);
    }

    protected Character(Parcel in) {
        this.mComics = in.readParcelable(InfoDetail.class.getClassLoader());
        this.mDescription = in.readString();
        this.mEvents = in.readParcelable(InfoDetail.class.getClassLoader());
        this.mId = (Long) in.readValue(Long.class.getClassLoader());
        long tmpMModified = in.readLong();
        this.mModified = tmpMModified == -1 ? null : new Date(tmpMModified);
        this.mName = in.readString();
        this.mResourceURI = in.readString();
        this.mSeries = in.readParcelable(InfoDetail.class.getClassLoader());
        this.mStories = in.readParcelable(InfoDetail.class.getClassLoader());
        this.mThumbnail = in.readParcelable(Thumbnail.class.getClassLoader());
        this.mUrls = new ArrayList<Url>();
        in.readList(this.mUrls, Url.class.getClassLoader());
    }

    public static final Parcelable.Creator<Character> CREATOR = new Parcelable.Creator<Character>() {
        @Override
        public Character createFromParcel(Parcel source) {
            return new Character(source);
        }

        @Override
        public Character[] newArray(int size) {
            return new Character[size];
        }
    };
}
