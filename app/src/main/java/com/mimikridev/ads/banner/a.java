package com.mimikridev.ads.banner;

import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BannerAd f10665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f10666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f10667d;
    public final /* synthetic */ RelativeLayout e;

    public /* synthetic */ a(BannerAd bannerAd, FrameLayout frameLayout, FrameLayout frameLayout2, RelativeLayout relativeLayout, int i2) {
        this.f10664a = i2;
        this.f10665b = bannerAd;
        this.f10666c = frameLayout;
        this.f10667d = frameLayout2;
        this.e = relativeLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10664a) {
            case 0:
                this.f10665b.lambda$loadBannerAd$0(this.f10666c, this.f10667d, this.e);
                break;
            default:
                this.f10665b.lambda$loadBackupBannerAd$1(this.f10666c, this.f10667d, this.e);
                break;
        }
    }
}
