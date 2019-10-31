package com.raghu.loader.callback;

import com.raghu.loader.models.ServiceContentTypeDownload;

public interface ContentServiceObserver
{
	void onStart(ServiceContentTypeDownload serviceContentTypeDownload);
	
	void onSuccess(ServiceContentTypeDownload serviceContentTypeDownload);
	
	void onFailure(ServiceContentTypeDownload serviceContentTypeDownload, int statusCode, byte[] errorResponse, Throwable e);
	
	void onRetry(ServiceContentTypeDownload serviceContentTypeDownload, int retryNo);
}
