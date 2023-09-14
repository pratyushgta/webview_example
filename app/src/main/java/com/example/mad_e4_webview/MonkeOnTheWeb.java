/**
 * This class contains methods for the handling the activity containing webview element
 * MAD-E4
 *
 * @author Pratyush Kumar (github.com/pratyushgta)
 */

package com.example.mad_e4_webview;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class MonkeOnTheWeb extends AppCompatActivity {
    TextView web_name;
    Button back;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monke_on_the_web);

        web_name = findViewById(R.id.web_name);
        back = findViewById(R.id.backBtn);
        webView = findViewById(R.id.webView);

        web_name.setText(R.string.web_name);

        webView.loadUrl("https://monkeyworld.org/contact-us-2/");
        WebSettings webSettings = webView.getSettings();
        webSettings.getJavaScriptEnabled();
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                final String url = String.valueOf(request.getUrl());
                if (url.startsWith("tel:")) {
                    Intent telephone = new Intent(Intent.ACTION_DIAL, Uri.parse(url));
                    startActivity(telephone);
                    return true;
                } else if (url.startsWith("mailto:")) {
                    Intent mail = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(mail);
                    return true;
                } else {
                    view.loadUrl(url);
                }
                return false;
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainAct = new Intent(MonkeOnTheWeb.this, MainActivity.class);
                startActivity(mainAct);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }
    }
}

