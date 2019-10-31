package com.raghu.view.screen.webview;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.raghu.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Web_User_AccountFragment extends Fragment
{
    @BindView(R.id.xwbVwDisplay)
    WebView wbVwDisplay;
    @BindView(R.id.xrellayMainParent)
    RelativeLayout rellayMainParent;
    @BindView(R.id.pb_loadingss)
    ProgressBar pbLoading;

    String webURL = "";

    public static final String ARG_URL = "arg_url";

    public static Web_User_AccountFragment newInstance(String url)
    {
        Bundle args = new Bundle();
        args.putString(ARG_URL, url);
        Web_User_AccountFragment fragment = new Web_User_AccountFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null)
        {
            webURL = bundle.getString(ARG_URL);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup vg, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_unsplash, vg, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart()
    {
        super.onStart();

        initObjects();
    }



    /**
     * This function is used to initialise the objects that are going to be used in this fragment
     */
    @SuppressLint("SetJavaScriptEnabled")
    public void initObjects()
    {
        pbLoading.setVisibility(View.VISIBLE);

        wbVwDisplay.loadUrl(webURL);

        // Enable Javascript
        WebSettings webSettings = wbVwDisplay.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        wbVwDisplay.setWebViewClient(new WebViewClient());

       // pbLoading.setVisibility(View.GONE);
    }


}
