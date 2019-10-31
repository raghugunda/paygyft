package com.raghu.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Category model
 * @author SandeepD
 */
public class Details_Category implements Parcelable
{
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("photo_count")
    @Expose
    private int photoCount;
    @SerializedName("links")
    @Expose
    private Details_Link links;
    @SerializedName("download")
    @Expose
    private String download;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getPhotoCount()
    {
        return photoCount;
    }

    public void setPhotoCount(int photoCount)
    {
        this.photoCount = photoCount;
    }

    public Details_Link getLinks()
    {
        return links;
    }

    public void setLinks(Details_Link links)
    {
        this.links = links;
    }

    public String getDownload()
    {
        return download;
    }

    public void setDownload(String download)
    {
        this.download = download;
    }

    protected Details_Category(Parcel in)
    {
        id = in.readInt();
        title = in.readString();
        photoCount = in.readInt();
        links = in.readParcelable(Details_Link.class.getClassLoader());
        download = in.readString();
    }

    public static final Creator<Details_Category> CREATOR = new Creator<Details_Category>()
    {
        @Override
        public Details_Category createFromParcel(Parcel in)
        {
            return new Details_Category(in);
        }

        @Override
        public Details_Category[] newArray(int size)
        {
            return new Details_Category[size];
        }
    };

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeInt(photoCount);
        parcel.writeParcelable(links, i);
        parcel.writeString(download);
    }
}