package com.example.daniel.githubreposoverview.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class SearchResult implements Parcelable {
    List<GithubRepo> items;

    public SearchResult(){
    }
    protected SearchResult(Parcel in) {
        items = in.createTypedArrayList(GithubRepo.CREATOR);
    }

    public static final Creator<SearchResult> CREATOR = new Creator<SearchResult>() {
        @Override
        public SearchResult createFromParcel(Parcel in) {
            return new SearchResult(in);
        }

        @Override
        public SearchResult[] newArray(int size) {
            return new SearchResult[size];
        }
    };

    public List<GithubRepo> getItems() {
        return items;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(items);
    }
}
