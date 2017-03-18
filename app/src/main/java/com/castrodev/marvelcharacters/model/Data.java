
package com.castrodev.marvelcharacters.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Data {

    @SerializedName("count")
    private Long mCount;
    @SerializedName("limit")
    private Long mLimit;
    @SerializedName("offset")
    private Long mOffset;
    @SerializedName("results")
    private List<Character> mCharacters;
    @SerializedName("total")
    private Long mTotal;

    public Long getCount() {
        return mCount;
    }

    public void setCount(Long count) {
        mCount = count;
    }

    public Long getLimit() {
        return mLimit;
    }

    public void setLimit(Long limit) {
        mLimit = limit;
    }

    public Long getOffset() {
        return mOffset;
    }

    public void setOffset(Long offset) {
        mOffset = offset;
    }

    public List<Character> getCharacters() {
        return mCharacters;
    }

    public void setCharacters(List<Character> characters) {
        mCharacters = characters;
    }

    public Long getTotal() {
        return mTotal;
    }

    public void setTotal(Long total) {
        mTotal = total;
    }

}
