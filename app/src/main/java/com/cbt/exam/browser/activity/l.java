package com.cbt.exam.browser.activity;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.mimikridev.utilmanager.animation.ViewAnimation;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5180a;

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        switch (this.f5180a) {
        }
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i2) {
        switch (this.f5180a) {
            case 0:
                ActivityCbtBrowser.P.setProgress(i2);
                if (i2 == 100) {
                    ViewAnimation.fadeOut(ActivityCbtBrowser.P);
                }
                super.onProgressChanged(webView, i2);
                break;
            default:
                ExamQR.B.setProgress(i2);
                if (i2 == 100) {
                    ViewAnimation.fadeOut(ExamQR.B);
                }
                super.onProgressChanged(webView, i2);
                break;
        }
    }
}
