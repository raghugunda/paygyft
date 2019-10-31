package com.raghu.loader.callback;

import com.raghu.loader.models.ServiceContentTypeDownload;

public interface ContentServiceStatusObserver
{
	void setDone(ServiceContentTypeDownload serviceContentTypeDownload);
	
	void setCancelled(ServiceContentTypeDownload serviceContentTypeDownload);
	
	void onFailure(ServiceContentTypeDownload serviceContentTypeDownload);
}
