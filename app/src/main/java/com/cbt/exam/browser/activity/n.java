package com.cbt.exam.browser.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AlertDialog;
import com.cbt.exam.browser.R;
import com.unity3d.ads.adplayer.AndroidWebViewClient;
import java.net.URISyntaxException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityCbtBrowser f5183a;

    public n(ActivityCbtBrowser activityCbtBrowser) {
        this.f5183a = activityCbtBrowser;
    }

    public final void a(String str) {
        ActivityCbtBrowser activityCbtBrowser = this.f5183a;
        activityCbtBrowser.h.setText(str);
        activityCbtBrowser.f5061b.stopLoading();
        activityCbtBrowser.f5061b.loadUrl(AndroidWebViewClient.BLANK_PAGE);
        activityCbtBrowser.f5061b.setVisibility(8);
        activityCbtBrowser.f5063d.setVisibility(0);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        ActivityCbtBrowser activityCbtBrowser = this.f5183a;
        if (str != null && !str.contains("error.html")) {
            activityCbtBrowser.f5074w = str;
            RelativeLayout relativeLayout = activityCbtBrowser.f5063d;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
        }
        ProgressBar progressBar = activityCbtBrowser.j;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        ProgressBar progressBar = this.f5183a.j;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (webResourceRequest.isForMainFrame()) {
            a(webResourceError.getDescription().toString());
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        ActivityCbtBrowser activityCbtBrowser = this.f5183a;
        if (activityCbtBrowser.isFinishing() || activityCbtBrowser.isDestroyed()) {
            return;
        }
        new AlertDialog.Builder(activityCbtBrowser).setTitle("SSL Error").setMessage(R.string.txt_err_ssl).setPositiveButton(R.string.btn_continue, new m(sslErrorHandler, 0)).setNegativeButton(R.string.btn_dialog_cancel, new m(sslErrorHandler, 1)).show();
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        Log.d("WebView", "Requesting: " + webResourceRequest.getUrl());
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        String str;
        String string = webResourceRequest.getUrl().toString();
        Log.d("ExitDebug", "URL saat ini: " + string);
        ActivityCbtBrowser activityCbtBrowser = this.f5183a;
        if (activityCbtBrowser.H && (str = activityCbtBrowser.D) != null && !str.isEmpty() && string.equalsIgnoreCase(activityCbtBrowser.D)) {
            activityCbtBrowser.v();
            return true;
        }
        if (!string.startsWith("http://") && !string.startsWith("https://")) {
            if (string.startsWith("intent:")) {
                try {
                    Intent uri = Intent.parseUri(string, 1);
                    String stringExtra = uri.getStringExtra("browser_fallback_url");
                    if (stringExtra != null) {
                        activityCbtBrowser.f5061b.loadUrl(stringExtra);
                        return true;
                    }
                    if (uri.resolveActivity(webView.getContext().getPackageManager()) != null) {
                        webView.getContext().startActivity(uri);
                        return true;
                    }
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
            try {
                webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(string)));
                return true;
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i2, String str, String str2) {
        a(str);
        Log.e("WebViewError", "Error code: " + i2 + ", description: " + str + ", url: " + str2);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String str2;
        if (str == null) {
            return false;
        }
        Log.d("ExitDebug", "URL saat ini: ".concat(str));
        ActivityCbtBrowser activityCbtBrowser = this.f5183a;
        if (activityCbtBrowser.H && (str2 = activityCbtBrowser.D) != null && !str2.isEmpty() && str.equalsIgnoreCase(activityCbtBrowser.D)) {
            activityCbtBrowser.v();
            return true;
        }
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            if (str.startsWith("intent:")) {
                try {
                    Intent uri = Intent.parseUri(str, 1);
                    String stringExtra = uri.getStringExtra("browser_fallback_url");
                    if (stringExtra != null) {
                        activityCbtBrowser.f5061b.loadUrl(stringExtra);
                        return true;
                    }
                    if (uri.resolveActivity(webView.getContext().getPackageManager()) != null) {
                        webView.getContext().startActivity(uri);
                        return true;
                    }
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
            try {
                webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return false;
    }
}
