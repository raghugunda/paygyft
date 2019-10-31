package com.raghu.view.screen.dashboardlist;

import android.content.Context;
import android.os.Handler;

import com.google.gson.Gson;
import com.raghu.R;
import com.raghu.loader.callback.ContentServiceObserver;
import com.raghu.loader.models.ServiceContentTypeDownload;
import com.raghu.loader.models.ServiceJsonDownload;
import com.raghu.loader.utilities.ContentTypeServiceDownload;
import com.raghu.model.Master_Details;
import com.raghu.utility.AlertUtil_dialog;
import com.raghu.utility.Constants;
import com.raghu.utility.NetworkUtil;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class is used for pinboard list operations.
 *
 * @author SandeepD
 * @version 1.0
 */
class DashboardListPresenterImplementor implements PinboardListPresenter
{
    private PinboardListView listingView;
    private Context context;
    private ContentTypeServiceDownload mProvider;
    private ArrayList<Master_Details> users;

    DashboardListPresenterImplementor(Context context, PinboardListView listingView)
    {
        this.context = context;
        this.listingView = listingView;
        mProvider = ContentTypeServiceDownload.getInstance();
        users = new ArrayList<>();
    }

    @Override
    public void fetchUsers()
    {
        if (NetworkUtil.isAirplaneModeWithNoWIFI(context))
        {
            listingView.displayErrorMessage(context.getString(R.string.network_error));
            return;
        } else if (!NetworkUtil.isNetworkAvailable(context))
        {
            listingView.displayErrorMessage(context.getString(R.string.network_error));
            return;
        }

        fetchUsersFromServer();
    }

    @Override
    public void clearCache()
    {
        mProvider.clearTheCash();
        AlertUtil_dialog.showToast(context,context.getString(R.string.str_cache_cleared));
    }

    private void fetchUsersFromServer()
    {

        ServiceContentTypeDownload mDataTypeJson = new ServiceJsonDownload(Constants.API_URL, new ContentServiceObserver()
        {
            @Override
            public void onStart(ServiceContentTypeDownload mDownloadDataType)
            {

            }

            @Override
            public void onSuccess(final ServiceContentTypeDownload mDownloadDataType)
            {
                String response = new String(mDownloadDataType.getData(), StandardCharsets.UTF_8);
                Master_Details[] detailsResponses = new Gson().fromJson(response, Master_Details[].class);

                if (detailsResponses.length != 0)
                {
                    users.clear();
                    Collections.addAll(users, detailsResponses);
                }
                Handler handler = new Handler();
                handler.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        if (listingView != null)
                        {
                            listingView.renderUserList(users);
                        }
                    }
                }, context.getResources().getInteger(android.R.integer.config_mediumAnimTime));

            }

            @Override
            public void onFailure(ServiceContentTypeDownload mDownloadDataType, int statusCode, byte[] errorResponse, Throwable e)
            {
            }

            @Override
            public void onRetry(ServiceContentTypeDownload mDownloadDataType, int retryNo)
            {

            }
        });
        mProvider.getRequest(mDataTypeJson);
    }
}
