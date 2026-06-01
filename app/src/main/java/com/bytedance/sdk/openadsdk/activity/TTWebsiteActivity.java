package com.bytedance.sdk.openadsdk.activity;

import a1.a;
import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.component.DmF.vCE;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.component.utils.xF;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.common.cl;
import com.bytedance.sdk.openadsdk.core.Cc.Bc;
import com.bytedance.sdk.openadsdk.core.Cc.lEW;
import com.bytedance.sdk.openadsdk.core.bWL;
import com.bytedance.sdk.openadsdk.core.nvX;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.EV;
import com.bytedance.sdk.openadsdk.utils.zPa;
import java.net.URLEncoder;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class TTWebsiteActivity extends TTBaseActivity {
    private WebView EO;
    private String IlO = null;
    private cl MY;

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        com.bytedance.sdk.openadsdk.core.cl.MY(getApplicationContext());
        if (!bWL.Cc()) {
            finish();
            return;
        }
        final String stringExtra = getIntent().getStringExtra("_extra_meta");
        String stringExtra2 = getIntent().getStringExtra("_extra_glo_d");
        String stringExtra3 = getIntent().getStringExtra("_privacy_url");
        String stringExtra4 = getIntent().getStringExtra("_privacy_title");
        if (TextUtils.isEmpty(stringExtra3)) {
            finish();
            return;
        }
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(this);
        if (Build.VERSION.SDK_INT >= 35) {
            cc.setFitsSystemWindows(true);
        }
        cc.setBackgroundColor(-1);
        cc.setId(520093726);
        cc.setOrientation(1);
        cc.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        try {
            setContentView(cc);
            int iMY = BS.MY(this, 5.0f);
            int iMY2 = BS.MY(this, 8.0f);
            int iMY3 = BS.MY(this, 10.0f);
            int iMY4 = BS.MY(this, 12.0f);
            int iMY5 = BS.MY(this, 14.0f);
            int iMY6 = BS.MY(this, 20.0f);
            int iMY7 = BS.MY(this, 24.0f);
            int iMY8 = BS.MY(this, 40.0f);
            int iMY9 = BS.MY(this, 44.0f);
            int iMY10 = BS.MY(this, 191.0f);
            Bc bc = new Bc(this);
            bc.setGravity(15);
            bc.setLayoutParams(new LinearLayout.LayoutParams(-1, iMY9));
            com.bytedance.sdk.openadsdk.core.Cc.tV tVVar = new com.bytedance.sdk.openadsdk.core.Cc.tV(this);
            tVVar.setId(520093720);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iMY8, iMY9);
            layoutParams.setMarginStart(iMY2);
            tVVar.setLayoutParams(layoutParams);
            tVVar.setClickable(true);
            tVVar.setFocusable(true);
            tVVar.setPadding(iMY5, iMY4, iMY5, iMY4);
            tVVar.setImageDrawable(pP.EO(this, "tt_ad_arrow_backward"));
            final com.bytedance.sdk.openadsdk.core.Cc.tV tVVar2 = new com.bytedance.sdk.openadsdk.core.Cc.tV(this);
            tVVar2.setId(520093716);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iMY8, iMY9);
            layoutParams2.addRule(17, 520093720);
            tVVar2.setLayoutParams(layoutParams2);
            tVVar2.setClickable(true);
            tVVar2.setFocusable(true);
            tVVar2.setPadding(iMY4, iMY5, iMY4, iMY5);
            tVVar2.setImageDrawable(pP.EO(this, "tt_ad_xmark"));
            lEW lew = new lEW(this);
            lew.setId(zPa.KT);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iMY10, iMY7);
            layoutParams3.setMarginStart(iMY);
            layoutParams3.addRule(15);
            layoutParams3.addRule(16, 520093741);
            layoutParams3.addRule(17, 520093716);
            lew.setLayoutParams(layoutParams3);
            lew.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            lew.setGravity(17);
            lew.setSingleLine(true);
            lew.setTextColor(Color.parseColor("#222222"));
            lew.setTextSize(17.0f);
            com.bytedance.sdk.openadsdk.core.Cc.tV tVVar3 = new com.bytedance.sdk.openadsdk.core.Cc.tV(this);
            tVVar3.setId(520093741);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iMY8, iMY9);
            layoutParams4.addRule(16, 520093742);
            tVVar3.setLayoutParams(layoutParams4);
            tVVar3.setPadding(iMY3, iMY4, iMY3, iMY4);
            tVVar3.setImageDrawable(pP.EO(this, "tt_ad_link"));
            com.bytedance.sdk.openadsdk.core.Cc.tV tVVar4 = new com.bytedance.sdk.openadsdk.core.Cc.tV(this);
            tVVar4.setId(520093742);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(iMY8, iMY9);
            layoutParams5.addRule(21);
            layoutParams5.setMarginEnd(iMY2);
            tVVar4.setLayoutParams(layoutParams5);
            tVVar4.setPadding(iMY4, iMY6, iMY4, iMY6);
            tVVar4.setImageDrawable(pP.EO(this, "tt_ad_threedots"));
            final com.bytedance.sdk.openadsdk.core.Cc.vCE vce = new com.bytedance.sdk.openadsdk.core.Cc.vCE(this, null, R.style.Widget.ProgressBar.Horizontal);
            vce.setId(520093743);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, BS.MY(this, 2.0f));
            layoutParams6.addRule(12);
            vce.setLayoutParams(layoutParams6);
            vce.setProgress(1);
            vce.setProgressDrawable(EV.IlO(this, "tt_privacy_progress_style"));
            View view = new View(this);
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, BS.MY(this, 1.0f));
            layoutParams7.addRule(12);
            view.setLayoutParams(layoutParams7);
            bc.addView(tVVar);
            bc.addView(tVVar2);
            bc.addView(lew);
            bc.addView(tVVar3);
            bc.addView(tVVar4);
            bc.addView(vce);
            bc.addView(view);
            cc.addView(bc);
            try {
                WebView webView = new WebView(getApplicationContext());
                this.EO = webView;
                webView.setBackgroundColor(-1);
                cc.addView(this.EO, new ViewGroup.LayoutParams(-1, -1));
                tVVar.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (TTWebsiteActivity.this.EO.canGoBack()) {
                            TTWebsiteActivity.this.EO.goBack();
                        } else {
                            TTWebsiteActivity.this.finish();
                        }
                    }
                });
                tVVar2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TTWebsiteActivity.this.finish();
                    }
                });
                tVVar2.setVisibility(4);
                tVVar2.setClickable(false);
                if (!TextUtils.isEmpty(stringExtra4)) {
                    lew.setText(stringExtra4);
                }
                tVVar3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        String url = TTWebsiteActivity.this.EO.getUrl();
                        if (TextUtils.isEmpty(url)) {
                            return;
                        }
                        intent.setData(Uri.parse(url));
                        com.bytedance.sdk.component.utils.MY.IlO(TTWebsiteActivity.this, intent, null);
                    }
                });
                tVVar4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (TTWebsiteActivity.this.MY == null) {
                            TTWebsiteActivity.this.MY = new cl(TTWebsiteActivity.this);
                            TTWebsiteActivity.this.MY.IlO(stringExtra);
                            TTWebsiteActivity.this.MY.setCanceledOnTouchOutside(false);
                        }
                        TTWebsiteActivity.this.MY.show();
                    }
                });
                this.IlO = stringExtra3;
                if (!TextUtils.isEmpty(stringExtra2)) {
                    String strEncode = URLEncoder.encode(stringExtra2);
                    if (this.IlO.contains("?")) {
                        this.IlO = a.s(new StringBuilder(), this.IlO, "&gdid_encrypted=", strEncode);
                    } else {
                        this.IlO = a.s(new StringBuilder(), this.IlO, "?gdid_encrypted=", strEncode);
                    }
                }
                if (this.IlO == null) {
                    finish();
                    return;
                }
                WebSettings settings = this.EO.getSettings();
                settings.setMixedContentMode(0);
                try {
                    settings.setJavaScriptEnabled(true);
                    settings.setDomStorageEnabled(true);
                    settings.setSavePassword(false);
                    settings.setAllowFileAccess(false);
                } catch (Throwable unused) {
                }
                try {
                    this.EO.loadUrl(this.IlO, androidx.camera.core.processing.util.a.u("Referer", TTAdConstant.REQUEST_HEAD_REFERER));
                } catch (Throwable unused2) {
                    this.EO.loadUrl(this.IlO);
                }
                this.EO.setWebChromeClient(new WebChromeClient() { // from class: com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.5
                    @Override // android.webkit.WebChromeClient
                    public void onProgressChanged(WebView webView2, int i2) {
                        super.onProgressChanged(webView2, i2);
                        if (vce == null || TTWebsiteActivity.this.isFinishing()) {
                            return;
                        }
                        if (i2 != 100) {
                            vce.setVisibility(0);
                            vce.setProgress(i2);
                            return;
                        }
                        vce.setVisibility(8);
                        if (webView2.canGoBack()) {
                            tVVar2.setVisibility(0);
                            tVVar2.setClickable(true);
                        } else {
                            tVVar2.setVisibility(4);
                            tVVar2.setClickable(false);
                        }
                    }
                });
                this.EO.setWebViewClient(new vCE.IlO() { // from class: com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.6
                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView2, String str) {
                        super.onPageFinished(webView2, str);
                    }

                    @Override // android.webkit.WebViewClient
                    @RequiresApi(api = 23)
                    public void onReceivedError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                        super.onReceivedError(webView2, webResourceRequest, webResourceError);
                        webResourceError.getErrorCode();
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedHttpError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                        super.onReceivedHttpError(webView2, webResourceRequest, webResourceResponse);
                        Objects.toString(webResourceResponse);
                    }

                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                        try {
                            Uri uri = Uri.parse(str);
                            if (!xF.IlO(str)) {
                                try {
                                    Intent intent = new Intent("android.intent.action.VIEW");
                                    intent.setData(uri);
                                    intent.addFlags(268435456);
                                    com.bytedance.sdk.component.utils.MY.IlO(TTWebsiteActivity.this, intent, null);
                                    return true;
                                } catch (Throwable unused3) {
                                    return true;
                                }
                            }
                        } catch (Throwable unused4) {
                        }
                        return super.shouldOverrideUrlLoading(webView2, str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView2, int i2, String str, String str2) {
                        super.onReceivedError(webView2, i2, str, str2);
                    }
                });
                com.bytedance.sdk.openadsdk.core.widget.IlO.EO.MY(this.EO);
            } catch (Exception e) {
                oeT.IlO("TTAD.TTWebsiteActivity", "onCreate: ", e);
                finish();
            }
        } catch (Throwable unused3) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        nvX.IlO(this.EO);
        super.onDestroy();
    }

    public static void IlO(Context context, com.bytedance.sdk.openadsdk.core.model.oeT oet, String str) {
        if (context == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.tV.EO.IlO(System.currentTimeMillis(), oet, str, "open_policy");
        if (TextUtils.isEmpty(oet.Uj().EO())) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) TTWebsiteActivity.class);
        intent.putExtra("_extra_meta", oet.NST().toString());
        intent.putExtra("_extra_glo_d", oet.gYU());
        intent.putExtra("_privacy_url", oet.Uj().EO());
        intent.putExtra("_privacy_title", oet.Uj().tV());
        com.bytedance.sdk.component.utils.MY.IlO(context, intent, null);
    }
}
