package com.bytedance.sdk.openadsdk.core.widget.IlO;

import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.vSq;
import com.bytedance.sdk.openadsdk.utils.xF;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY implements IlO {
    private final boolean Cc;
    private final AtomicInteger EO;
    vSq IlO;
    private com.bytedance.sdk.component.DmF.vCE MY;
    private final MessageQueue tV;

    public MY(int i2, boolean z2, MessageQueue messageQueue) {
        this.EO = new AtomicInteger(i2);
        this.Cc = z2;
        this.tV = messageQueue;
    }

    private void IlO(com.bytedance.sdk.component.DmF.vCE vce) {
        if (vce == null || vce.getWebView() == null) {
            return;
        }
        try {
            EO.IlO(cl.IlO()).IlO(false).IlO(vce.getWebView());
            vce.setVerticalScrollBarEnabled(false);
            vce.setHorizontalScrollBarEnabled(false);
            EO.IlO(vce);
            vce.bWL();
            vce.setUserAgentString(xF.IlO(vce.getWebView(), BuildConfig.VERSION_CODE));
            vce.setMixedContentMode(0);
            vce.setJavaScriptEnabled(true);
            vce.setJavaScriptCanOpenWindowsAutomatically(true);
            vce.setDomStorageEnabled(true);
            vce.setDatabaseEnabled(true);
            vce.setCacheMode(-1);
            vce.setAllowFileAccess(false);
            vce.setSupportZoom(true);
            vce.setBuiltInZoomControls(true);
            vce.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            vce.setUseWideViewPort(true);
        } catch (Throwable th) {
            oeT.EO("WebViewPool", th.toString());
        }
    }

    public void MY() {
        if (this.EO.get() <= 0) {
            return;
        }
        Objects.toString(this.EO);
        String strTV = com.bytedance.sdk.component.adexpress.IlO.MY.MY.tV(null);
        if (this.Cc) {
            String strTV2 = com.bytedance.sdk.component.adexpress.IlO.MY.MY.tV("v3");
            if (strTV != null && strTV.equals(strTV2)) {
                return;
            } else {
                strTV = strTV2;
            }
        }
        if (TextUtils.isEmpty(strTV)) {
            return;
        }
        try {
            com.bytedance.sdk.component.DmF.vCE vce = new com.bytedance.sdk.component.DmF.vCE(new MutableContextWrapper(cl.IlO()));
            this.MY = vce;
            if (vce.getWebView() == null) {
                return;
            }
            this.MY.setWebViewClient(new WebViewClient() { // from class: com.bytedance.sdk.openadsdk.core.widget.IlO.MY.1
                @Override // android.webkit.WebViewClient
                public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                    return true;
                }
            });
            IlO(this.MY);
            Uri uriBuild = Uri.parse(strTV).buildUpon().appendQueryParameter("isPreLoad", "1").build();
            vSq vsq = new vSq(this.MY.getContext());
            this.IlO = vsq;
            vsq.MY(this.MY).IlO(this).IlO(this.MY);
            com.bytedance.sdk.component.adexpress.Cc.Cc.IlO().IlO(this.MY, this.IlO);
            this.MY.a_(uriBuild.toString());
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.IlO
    public void IlO() {
        MessageQueue messageQueue;
        if (this.Cc) {
            com.bytedance.sdk.component.adexpress.Cc.Cc.IlO().MY(this.MY);
        } else {
            com.bytedance.sdk.component.adexpress.Cc.Cc.IlO().EO(this.MY);
        }
        try {
            this.EO.get();
            this.EO.decrementAndGet();
            if (this.EO.get() <= 0 || (messageQueue = this.tV) == null) {
                return;
            }
            messageQueue.addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.bytedance.sdk.openadsdk.core.widget.IlO.MY.2
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    new MY(MY.this.EO.get(), MY.this.Cc, MY.this.tV).MY();
                    return false;
                }
            });
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
