package com.instagram.common.viewpoint.core;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class TZ extends WebViewClient {
    public final /* synthetic */ CallableC1095Ta A00;

    public TZ(CallableC1095Ta callableC1095Ta) {
        this.A00 = callableC1095Ta;
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        AbstractC1251Ze.A0D(AbstractC1090Sv.A2j);
        return true;
    }
}
