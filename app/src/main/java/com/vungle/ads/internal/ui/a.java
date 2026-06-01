package com.vungle.ads.internal.ui;

import android.webkit.WebView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VungleWebClient f11016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WebView f11017c;

    public /* synthetic */ a(VungleWebClient vungleWebClient, WebView webView, int i2) {
        this.f11015a = i2;
        this.f11016b = vungleWebClient;
        this.f11017c = webView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f11015a) {
            case 0:
                VungleWebClient.m3367shouldOverrideUrlLoading$lambda16$lambda11(this.f11016b, this.f11017c);
                break;
            case 1:
                VungleWebClient.m3373shouldOverrideUrlLoading$lambda16$lambda8$lambda7(this.f11016b, this.f11017c);
                break;
            case 2:
                VungleWebClient.m3366shouldOverrideUrlLoading$lambda16$lambda10$lambda9(this.f11016b, this.f11017c);
                break;
            case 3:
                VungleWebClient.m3369shouldOverrideUrlLoading$lambda16$lambda15$lambda14$lambda13(this.f11016b, this.f11017c);
                break;
            case 4:
                VungleWebClient.m3370shouldOverrideUrlLoading$lambda16$lambda6(this.f11016b, this.f11017c);
                break;
            case 5:
                VungleWebClient.m3372shouldOverrideUrlLoading$lambda16$lambda8(this.f11016b, this.f11017c);
                break;
            default:
                VungleWebClient.m3365shouldOverrideUrlLoading$lambda16$lambda10(this.f11016b, this.f11017c);
                break;
        }
    }
}
