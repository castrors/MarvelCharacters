
package com.castrodev.marvelcharacters.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class InfoDetail implements Parcelable {

    @SerializedName("available")
    private int mAvailable;
    @SerializedName("collectionURI")
    private String mCollectionURI;
    @SerializedName("items")
    private List<Item> mItems;
    @SerializedName("returned")
    private Long mReturned;

    public int getAvailable() {
        return mAvailable;
    }

    public void setAvailable(int available) {
        mAvailable = available;
    }

    public String getCollectionURI() {
        return mCollectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        mCollectionURI = collectionURI;
    }

    public List<Item> getItems() {
        return mItems;
    }

    public void setItems(List<Item> items) {
        mItems = items;
    }

    public Long getReturned() {
        return mReturned;
    }

    public void setReturned(Long returned) {
        mReturned = returned;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mAvailable);
        dest.writeString(this.mCollectionURI);
        dest.writeList(this.mItems);
        dest.writeValue(this.mReturned);
    }

    public InfoDetail() {
    }

    protected InfoDetail(Parcel in) {
        this.mAvailable = in.readInt();
        this.mCollectionURI = in.readString();
        this.mItems = new ArrayList<Item>();
        in.readList(this.mItems, Item.class.getClassLoader());
        this.mReturned = (Long) in.readValue(Long.class.getClassLoader());
    }

    public static final Parcelable.Creator<InfoDetail> CREATOR = new Parcelable.Creator<InfoDetail>() {
        @Override
        public InfoDetail createFromParcel(Parcel source) {
            return new InfoDetail(source);
        }

        @Override
        public InfoDetail[] newArray(int size) {
            return new InfoDetail[size];
        }
    };
}
