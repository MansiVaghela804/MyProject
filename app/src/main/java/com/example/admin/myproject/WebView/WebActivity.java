package com.example.admin.myproject.WebView;

import android.graphics.Bitmap;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.admin.myproject.R;

public class WebActivity extends AppCompatActivity {
    Button B1;
    WebView webView;
    ProgressBar progressBar;
    LinearLayout linearLayout;
    boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        linearLayout = (LinearLayout) findViewById(R.id.rootlayout);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);


        B1 = (Button) findViewById(R.id.webbutton);
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView = (WebView) findViewById(R.id.web_display);
                webView.loadUrl("https://www.tutorialspoint.com");
                progressBar.setVisibility(View.VISIBLE);

                webView.setWebViewClient(new MyWebBrowser());

            }
        });

    }

    private class MyWebBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
        }
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
//        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
        Snackbar snackbar = Snackbar
                .make(linearLayout, "Please click BACK again to exit", Snackbar.LENGTH_LONG);

        snackbar.show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

}
