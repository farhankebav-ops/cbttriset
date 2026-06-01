package com.mimikridev.ads.appopen;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10662a;

    public /* synthetic */ a(int i2) {
        this.f10662a = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10662a) {
            case 0:
                AppOpenAd.isAppOpenAdLoaded = true;
                break;
            default:
                AppOpenAd.isAppOpenAdLoaded = true;
                break;
        }
    }
}
