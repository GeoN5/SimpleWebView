package com.example.geonho.codeandroidwebview

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView.webViewClient = MyWebViewClient()

        btnGo.setOnClickListener {
            webView.loadUrl("https://${edtUrl.text}")
        }

        btnGoBack.setOnClickListener {
            if(webView.canGoBack())
                webView.goBack()
            else
                Toast.makeText(this,"No History Available",Toast.LENGTH_SHORT).show()
        }

        btnGoForward.setOnClickListener {
            if(webView.canGoForward())
                webView.goForward()
            else
                Toast.makeText(this,"No History Available",Toast.LENGTH_SHORT).show()
        }
    }
}

@Suppress("OverridingDeprecatedMember")
class MyWebViewClient : WebViewClient(){

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        view?.loadUrl(request?.url.toString())
        return true
    }

    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        view?.loadUrl(url)
        return true
    }
}
