package com.raghu.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * User Details model
 * @author SandeepD
 */
public class All_User_Details implements Parcelable
{
	@SerializedName("id")
	@Expose
	private String       id;
	@SerializedName("username")
	@Expose
	private String       username;
	@SerializedName("name")
	@Expose
	private String       name;
	@SerializedName("profile_image")
	@Expose
	private Profile_Image profileImage;
	@SerializedName("links")
	@Expose
	private Details_Link linkDetails;
	
	protected All_User_Details(Parcel in)
	{
		id = in.readString();
		username = in.readString();
		name = in.readString();
		profileImage = in.readParcelable(Profile_Image.class.getClassLoader());
		linkDetails = in.readParcelable(Details_Link.class.getClassLoader());
	}
	
	public static final Creator<All_User_Details> CREATOR = new Creator<All_User_Details>()
	{
		@Override
		public All_User_Details createFromParcel(Parcel in)
		{
			return new All_User_Details(in);
		}
		
		@Override
		public All_User_Details[] newArray(int size)
		{
			return new All_User_Details[size];
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
	
	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Profile_Image getProfileImage()
	{
		return profileImage;
	}
	
	public void setProfileImage(Profile_Image profileImage)
	{
		this.profileImage = profileImage;
	}
	
	public Details_Link getLinkDetails()
	{
		return linkDetails;
	}
	
	public void setLinkDetails(Details_Link linkDetails)
	{
		this.linkDetails = linkDetails;
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
		parcel.writeString(username);
		parcel.writeString(name);
		parcel.writeParcelable(profileImage, i);
		parcel.writeParcelable(linkDetails, i);
	}
}