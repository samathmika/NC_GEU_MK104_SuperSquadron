package com.example.dehradun;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class Feedback extends AppCompatActivity {
    private WebView feedbackformlink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);

        setTitle("Your Feedback");

        feedbackformlink = (WebView)findViewById(R.id.link_webview);
        WebSettings webSettings = feedbackformlink.getSettings();

        feedbackformlink.setInitialScale(200);
        feedbackformlink.getSettings().setSupportZoom(true);
        feedbackformlink.getSettings().setLoadWithOverviewMode(true);
        feedbackformlink.getSettings().setBuiltInZoomControls(true);
        webSettings.setJavaScriptEnabled(true);
        feedbackformlink.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSdvLcjhVJ9cnocQx5VnivuyIEGfdQ3e20V-Mlynd7R579lrLQ/viewform?usp=sf_link");
        feedbackformlink.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if (feedbackformlink.canGoBack()){
            feedbackformlink.goBack();
        } else
            super.onBackPressed();
    }
}
