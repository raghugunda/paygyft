package com.raghu.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * profile image details model
 * @author SandeepD
 */
public class Profile_Image implements Parcelable
{
	@SerializedName("small")
	@Expose
	private String small;
	@SerializedName("medium")
	@Expose
	private String medium;
	@SerializedName("large")
	@Expose
	private String large;
	
	protected Profile_Image(Parcel in)
	{
		small = in.readString();
		medium = in.readString();
		large = in.readString();
	}
	
	public static final Creator<Profile_Image> CREATOR = new Creator<Profile_Image>()
	{
		@Override
		public Profile_Image createFromParcel(Parcel in)
		{
			return new Profile_Image(in);
		}
		
		@Override
		public Profile_Image[] newArray(int size)
		{
			return new Profile_Image[size];
		}
	};
	
	public String getSmall()
	{
		return small;
	}
	
	public void setSmall(String small)
	{
		this.small = small;
	}
	
	public String getMedium()
	{
		return medium;
	}
	
	public void setMedium(String medium)
	{
		this.medium = medium;
	}
	
	public String getLarge()
	{
		return large;
	}
	
	public void setLarge(String large)
	{
		this.large = large;
	}
	
	@Override
	public int describeContents()
	{
		return 0;
	}
	
	@Override
	public void writeToParcel(Parcel parcel, int i)
	{
		parcel.writeString(small);
		parcel.writeString(medium);
		parcel.writeString(large);
	}
}