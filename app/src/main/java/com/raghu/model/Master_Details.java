package com.raghu.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
/**
 * pinboard response model
 * @author SandeepD
 */
public class Master_Details implements Parcelable
{
	@SerializedName("id")
	@Expose
	private String  id;
	@SerializedName("created_at")
	@Expose
	private String  createdAt;
	@SerializedName("width")
	@Expose
	private int width;
	@SerializedName("height")
	@Expose
	private int height;
	@SerializedName("color")
	@Expose
	private String  color;
	@SerializedName("likes")
	@Expose
	private int likes;
	@SerializedName("liked_by_user")
	@Expose
	private boolean likedByUser;
	@SerializedName("user")
	@Expose
	private All_User_Details user;
	@SerializedName("current_user_collections")
	@Expose
	private List<Object> currentUserCollections = null;
	@SerializedName("urls")
	@Expose
	private Url_info urlDetails;
	@SerializedName("categories")
	@Expose
	private List<Details_Category> categories = null;
	@SerializedName("links")
	@Expose
	private Details_Link links;
	
	protected Master_Details(Parcel in)
	{
		id = in.readString();
		createdAt = in.readString();
		width = in.readInt();
		height = in.readInt();
		color = in.readString();
		likes = in.readInt();
		likedByUser = in.readByte() != 0;
		user = in.readParcelable(All_User_Details.class.getClassLoader());
		urlDetails = in.readParcelable(Url_info.class.getClassLoader());
		categories = in.createTypedArrayList(Details_Category.CREATOR);
		links = in.readParcelable(Details_Link.class.getClassLoader());
	}
	
	public static final Creator<Master_Details> CREATOR = new Creator<Master_Details>()
	{
		@Override
		public Master_Details createFromParcel(Parcel in)
		{
			return new Master_Details(in);
		}
		
		@Override
		public Master_Details[] newArray(int size)
		{
			return new Master_Details[size];
		}
	};
	
	public String getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getCreatedAt()
	{
		return createdAt;
	}
	
	public void setCreatedAt(String createdAt)
	{
		this.createdAt = createdAt;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public void setHeight(int height)
	{
		this.height = height;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public void setColor(String color)
	{
		this.color = color;
	}
	
	public int getLikes()
	{
		return likes;
	}
	
	public void setLikes(int likes)
	{
		this.likes = likes;
	}
	
	public boolean isLikedByUser()
	{
		return likedByUser;
	}
	
	public void setLikedByUser(boolean likedByUser)
	{
		this.likedByUser = likedByUser;
	}
	
	public All_User_Details getUser()
	{
		return user;
	}
	
	public void setUser(All_User_Details user)
	{
		this.user = user;
	}
	
	public List<Object> getCurrentUserCollections()
	{
		return currentUserCollections;
	}
	
	public void setCurrentUserCollections(List<Object> currentUserCollections)
	{
		this.currentUserCollections = currentUserCollections;
	}
	
	public Url_info getUrlDetails()
	{
		return urlDetails;
	}
	
	public void setUrlDetails(Url_info urlDetails)
	{
		this.urlDetails = urlDetails;
	}
	
	public List<Details_Category> getCategories()
	{
		return categories;
	}
	
	public void setCategories(List<Details_Category> categories)
	{
		this.categories = categories;
	}
	
	public Details_Link getLinks()
	{
		return links;
	}
	
	public void setLinks(Details_Link links)
	{
		this.links = links;
	}
	
	@Override
	public int describeContents()
	{
		return 0;
	}
	
	@Override
	public void writeToParcel(Parcel parcel, int i)
	{
		parcel.writeString(id);
		parcel.writeString(createdAt);
		parcel.writeInt(width);
		parcel.writeInt(height);
		parcel.writeString(color);
		parcel.writeInt(likes);
		parcel.writeByte((byte) (likedByUser ? 1 : 0));
		parcel.writeParcelable(user, i);
		parcel.writeParcelable(urlDetails, i);
		parcel.writeTypedList(categories);
		parcel.writeParcelable(links, i);
	}
}