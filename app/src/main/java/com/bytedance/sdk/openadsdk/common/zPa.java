package com.bytedance.sdk.openadsdk.common;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.widget.IlO.vCE;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class zPa {
    private ImageView Bc;
    private final Context Cc;
    private final oeT EO;
    private final LinearLayout IlO;
    private final com.bytedance.sdk.component.DmF.vCE MY;
    private vCE.IlO lEW;
    private final String tV;
    private ImageView vCE;

    public zPa(Context context, LinearLayout linearLayout, com.bytedance.sdk.component.DmF.vCE vce, oeT oet, String str) {
        this.Cc = context;
        this.IlO = linearLayout;
        this.MY = vce;
        this.EO = oet;
        this.tV = str;
        EO();
    }

    private void EO() {
        this.vCE = (ImageView) this.IlO.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.gm);
        this.Bc = (ImageView) this.IlO.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.aa);
        ImageView imageView = (ImageView) this.IlO.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.ED);
        ImageView imageView2 = (ImageView) this.IlO.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.PTq);
        this.vCE.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.zPa.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (zPa.this.MY == null || !zPa.this.MY.DmF()) {
                    return;
                }
                if (zPa.this.lEW != null) {
                    zPa.this.lEW.IlO();
                }
                zPa.this.IlO("backward");
                zPa.this.MY.NV();
            }
        });
        this.Bc.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.zPa.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (zPa.this.MY == null || !zPa.this.MY.EV()) {
                    return;
                }
                zPa.this.IlO("forward");
                zPa.this.MY.rp();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.zPa.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (zPa.this.MY != null) {
                    zPa.this.MY("refresh");
                    zPa.this.MY.lEW();
                }
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.zPa.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (zPa.this.MY != null) {
                    zPa.this.MY("external_btn_click");
                    Intent intent = new Intent("android.intent.action.VIEW");
                    String url = zPa.this.MY.getUrl();
                    if (TextUtils.isEmpty(url)) {
                        return;
                    }
                    intent.setData(Uri.parse(url));
                    com.bytedance.sdk.component.utils.MY.IlO(zPa.this.Cc, intent, null);
                }
            }
        });
        this.IlO.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.zPa.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.vCE.setClickable(false);
        this.Bc.setClickable(false);
        ImageView imageView3 = this.vCE;
        int color = Color.parseColor("#A8FFFFFF");
        PorterDuff.Mode mode = PorterDuff.Mode.ADD;
        imageView3.setColorFilter(color, mode);
        this.Bc.setColorFilter(Color.parseColor("#A8FFFFFF"), mode);
    }

    public void IlO(WebView webView, vCE.IlO ilO) {
        this.lEW = ilO;
        try {
            if (this.vCE != null) {
                if (webView.canGoBack()) {
                    this.vCE.setClickable(true);
                    this.vCE.clearColorFilter();
                } else {
                    this.vCE.setClickable(false);
                    this.vCE.setColorFilter(Color.parseColor("#A8FFFFFF"), PorterDuff.Mode.ADD);
                }
            }
            if (this.Bc != null) {
                if (webView.canGoForward()) {
                    this.Bc.setClickable(true);
                    this.Bc.clearColorFilter();
                } else {
                    this.Bc.setClickable(false);
                    this.Bc.setColorFilter(Color.parseColor("#A8FFFFFF"), PorterDuff.Mode.ADD);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void MY() {
        if (this.IlO.getAlpha() == 1.0f) {
            ObjectAnimator.ofFloat(this.IlO, "alpha", 1.0f, 0.0f).setDuration(300L).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(String str) {
        WebBackForwardList webBackForwardListCopyBackForwardList;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.MY.getWebView() != null && (webBackForwardListCopyBackForwardList = this.MY.getWebView().copyBackForwardList()) != null) {
                String url = webBackForwardListCopyBackForwardList.getItemAtIndex(webBackForwardListCopyBackForwardList.getCurrentIndex()).getUrl();
                if (TextUtils.isEmpty(url)) {
                    url = this.MY.getUrl();
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("url", url);
                jSONObject2.putOpt("first_page", Integer.valueOf(webBackForwardListCopyBackForwardList.getCurrentIndex() == 0 ? 1 : 0));
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.tV.EO.IlO(System.currentTimeMillis(), this.EO, this.tV, str, jSONObject, (com.bytedance.sdk.openadsdk.tV.Bc) null, (com.bytedance.sdk.openadsdk.tV.MY.IlO) null);
    }

    public void IlO() {
        if (this.IlO.getAlpha() == 0.0f) {
            ObjectAnimator.ofFloat(this.IlO, "alpha", 0.0f, 1.0f).setDuration(300L).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(String str) {
        WebBackForwardList webBackForwardListCopyBackForwardList;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.MY.getWebView() != null && (webBackForwardListCopyBackForwardList = this.MY.getWebView().copyBackForwardList()) != null) {
                int currentIndex = webBackForwardListCopyBackForwardList.getCurrentIndex();
                String url = webBackForwardListCopyBackForwardList.getItemAtIndex(currentIndex).getUrl();
                if (TextUtils.isEmpty(url)) {
                    url = this.MY.getUrl();
                }
                String url2 = "";
                if (str.equals("backward")) {
                    url2 = webBackForwardListCopyBackForwardList.getItemAtIndex(currentIndex - 1).getUrl();
                }
                int i2 = 1;
                if (str.equals("forward")) {
                    url2 = webBackForwardListCopyBackForwardList.getItemAtIndex(currentIndex + 1).getUrl();
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("url", url);
                jSONObject2.putOpt("next_url", url2);
                if (webBackForwardListCopyBackForwardList.getCurrentIndex() != 0) {
                    i2 = 0;
                }
                jSONObject2.putOpt("first_page", Integer.valueOf(i2));
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.tV.EO.IlO(System.currentTimeMillis(), this.EO, this.tV, str, jSONObject, (com.bytedance.sdk.openadsdk.tV.Bc) null, (com.bytedance.sdk.openadsdk.tV.MY.IlO) null);
    }
}
