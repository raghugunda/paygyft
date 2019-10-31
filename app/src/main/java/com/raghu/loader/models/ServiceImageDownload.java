package com.raghu.loader.models;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.raghu.loader.callback.ContentServiceObserver;

public class ServiceImageDownload extends ServiceContentTypeDownload
{
	public ServiceImageDownload(String url, ContentServiceObserver contentServiceObserver)
	{
		super(url, ContentDataType.IMAGE, contentServiceObserver);
	}
	
	@Override
	public ServiceContentTypeDownload getCopyOfMe(ContentServiceObserver contentServiceObserver)
	{
		return new ServiceImageDownload(this.getUrl(), contentServiceObserver);
	}
	
	public Bitmap getImageBitmap()
	{
		return BitmapFactory.decodeByteArray(getData(), 0, getData().length);
	}
}
