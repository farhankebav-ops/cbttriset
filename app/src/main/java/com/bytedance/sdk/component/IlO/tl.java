package com.bytedance.sdk.component.IlO;

import a1.a;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tl extends IlO {
    static final /* synthetic */ boolean NV = true;
    protected WebView DmF;
    protected String lEW;

    public void EO() {
        if (!NV && this.DmF == null) {
            throw new AssertionError();
        }
        this.DmF.addJavascriptInterface(this, this.lEW);
    }

    @Override // com.bytedance.sdk.component.IlO.IlO
    public Context IlO(NV nv) {
        Context context = nv.Cc;
        if (context != null) {
            return context;
        }
        WebView webView = nv.IlO;
        if (webView != null) {
            return webView.getContext();
        }
        throw new IllegalStateException("WebView cannot be null!");
    }

    @Override // com.bytedance.sdk.component.IlO.IlO
    public void MY(NV nv) {
        this.DmF = nv.IlO;
        this.lEW = nv.EO;
        if (nv.bWL) {
            return;
        }
        EO();
    }

    @Override // com.bytedance.sdk.component.IlO.IlO
    @JavascriptInterface
    public void invokeMethod(String str) {
        super.invokeMethod(str);
    }

    public void tV() {
        this.DmF.removeJavascriptInterface(this.lEW);
    }

    @Override // com.bytedance.sdk.component.IlO.IlO
    public String IlO() {
        return this.DmF.getUrl();
    }

    @Override // com.bytedance.sdk.component.IlO.IlO
    public void MY() {
        super.MY();
        tV();
    }

    @Override // com.bytedance.sdk.component.IlO.IlO
    public void IlO(String str, zPa zpa) {
        if (zpa != null && !TextUtils.isEmpty(zpa.lEW)) {
            String str2 = zpa.lEW;
            IlO(str, a.r(a.z("javascript:(function(){   const iframe = document.querySelector(atob('", Base64.encodeToString(("iframe[src=\"" + str2 + "\"").getBytes(), 2), "'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(", str, ", atob('"), Base64.encodeToString(str2.getBytes(), 2), "'));   }})()"));
            return;
        }
        super.IlO(str, zpa);
    }

    @Override // com.bytedance.sdk.component.IlO.IlO
    public void IlO(String str) {
        IlO(str, androidx.camera.core.processing.util.a.n(new StringBuilder("javascript:"), this.lEW, "._handleMessageFromToutiao(", str, ")"));
    }

    private void IlO(String str, final String str2) {
        if (this.vCE || TextUtils.isEmpty(str2)) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.IlO.tl.1
            @Override // java.lang.Runnable
            public void run() {
                if (tl.this.vCE) {
                    return;
                }
                try {
                    tl.this.DmF.evaluateJavascript(str2, null);
                } catch (Throwable unused) {
                }
            }
        };
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.tV.post(runnable);
        } else {
            runnable.run();
        }
    }
}
