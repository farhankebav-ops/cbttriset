package com.bytedance.sdk.openadsdk.core.widget.IlO;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.bWL;
import com.bytedance.sdk.openadsdk.core.vSq;
import com.bytedance.sdk.openadsdk.tV.EV;
import com.bytedance.sdk.openadsdk.utils.xF;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV extends WebChromeClient {
    private static final String IlO = "WebChromeClient";
    private EV EO;
    private final vSq MY;
    private com.bytedance.sdk.openadsdk.common.tV tV;

    public tV(vSq vsq) {
        this.MY = vsq;
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String str, int i2, String str2) {
        if (!TextUtils.isEmpty(str)) {
            IlO(str);
        }
        super.onConsoleMessage(str, i2, str2);
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i2) {
        super.onProgressChanged(webView, i2);
        EV ev = this.EO;
        if (ev != null) {
            ev.IlO(webView, i2);
        }
        com.bytedance.sdk.openadsdk.common.tV tVVar = this.tV;
        if (tVVar != null) {
            tVVar.IlO(webView, i2);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, customViewCallback);
    }

    private boolean IlO(@NonNull final String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (str.regionMatches(true, 0, "bytedance:", 0, 10)) {
                bWL.EO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.IlO.tV.1
                    @Override // java.lang.Runnable
                    public void run() {
                        xF.IlO(Uri.parse(str), tV.this.MY);
                    }
                });
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public tV(vSq vsq, EV ev, com.bytedance.sdk.openadsdk.common.tV tVVar) {
        this(vsq, ev);
        this.tV = tVVar;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage == null || TextUtils.isEmpty(consoleMessage.message()) || !IlO(consoleMessage.message())) {
            return super.onConsoleMessage(consoleMessage);
        }
        return true;
    }

    public tV(vSq vsq, EV ev) {
        this.MY = vsq;
        this.EO = ev;
    }
}
