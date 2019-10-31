package com.raghu.view.screen.dashboardlist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.raghu.loader.callback.ContentServiceObserver;
import com.raghu.loader.models.ServiceContentTypeDownload;
import com.raghu.loader.models.ServiceImageDownload;
import com.raghu.loader.utilities.ContentTypeServiceDownload;
import com.raghu.R;
import com.raghu.model.Master_Details;
import com.raghu.view.screen.common.ItemActionListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * This adapter is used to render user pin item.
 *
 * @author SandeepD
 * @version 1.0
 */

public class DashboardListAdapter extends RecyclerView.Adapter<DashboardListAdapter.UserDetailsHolder>
{
    private LayoutInflater inflater;
    private Context context;
    private ArrayList<Master_Details> arrlstData;
    private ItemActionListener itemActionListener;

    private ContentTypeServiceDownload mProvider;

    public DashboardListAdapter(Context context, ArrayList<Master_Details> arrlstData, ItemActionListener itemActionListener)
    {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.arrlstData = arrlstData;
        this.itemActionListener = itemActionListener;
        mProvider = ContentTypeServiceDownload.getInstance();
    }

    @Override
    public UserDetailsHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new UserDetailsHolder(inflater.inflate(R.layout.item_photo_pin, parent, false));
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(final UserDetailsHolder holder, final int position)
    {
        final Master_Details currentData = arrlstData.get(position);

        holder.txtvwLikes.setText(String.format("%d", currentData.getLikes()));
        holder.txtvwTitle.setText(context.getString(R.string.clicked_by, currentData.getUser().getName()));

        if (currentData.isLikedByUser())
        {
            holder.txtvwLikes.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_liked, 0, 0, 0);
        } else
        {
            holder.txtvwLikes.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_like, 0, 0, 0);

        }


        ServiceContentTypeDownload mDataTypeImageCancel = new ServiceImageDownload(currentData.getUrlDetails().getThumb(), new ContentServiceObserver()
        {
            @Override
            public void onStart(ServiceContentTypeDownload mDownloadDataType)
            {

            }

            @Override
            public void onSuccess(ServiceContentTypeDownload mDownloadDataType)
            {
                holder.imgvwThumbnail.setImageBitmap(((ServiceImageDownload) mDownloadDataType).getImageBitmap());
            }

            @Override
            public void onFailure(ServiceContentTypeDownload mDownloadDataType, int statusCode, byte[] errorResponse, Throwable e)
            {
                holder.imgvwThumbnail.setImageResource(R.drawable.no_image);
            }

            @Override
            public void onRetry(ServiceContentTypeDownload mDownloadDataType, int retryNo)
            {

            }
        });
        mProvider.getRequest(mDataTypeImageCancel);

        holder.cardView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (itemActionListener != null)
                {
                    itemActionListener.onItemClicked(currentData, position);
                }

            }
        });
    }

    @Override
    public int getItemCount()
    {
        return arrlstData.size();
    }

    class UserDetailsHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.iv_imagethumbnail)
        ImageView imgvwThumbnail;
        @BindView(R.id.tv_title)
        TextView txtvwTitle;
        @BindView(R.id.tv_likes)
        TextView txtvwLikes;
        @BindView(R.id.card_view)
        CardView cardView;


        UserDetailsHolder(View view)
        {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void add(Master_Details newData)
    {

        arrlstData.add(arrlstData.size(), newData);
        notifyItemInserted(arrlstData.size());

    }


}
