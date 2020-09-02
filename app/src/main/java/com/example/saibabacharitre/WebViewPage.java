package com.example.saibabacharitre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class WebViewPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_page);

//        WebView webView = new WebView(this);
//        setContentView(webView);
//        webView.loadUrl("https://www.zee5.com/channels/details/news-9/0-9-261");

        WebView webView = (WebView)findViewById(R.id.webView);
//you can load an html code
        webView.loadData("yourCode Html to load on the webView " , "text/html" , "utf-8");
// you can load an URL
        webView.loadUrl("https://www.zee5.com/channels/details/news-9/0-9-261");
    }
}
