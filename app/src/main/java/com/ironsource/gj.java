package com.ironsource;

import com.ironsource.mediationsdk.testSuite.TestSuiteActivity;
import com.unity3d.mediation.banner.LevelPlayBannerAdView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class gj implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TestSuiteActivity f8630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LevelPlayBannerAdView f8631c;

    public /* synthetic */ gj(TestSuiteActivity testSuiteActivity, LevelPlayBannerAdView levelPlayBannerAdView, int i2) {
        this.f8629a = i2;
        this.f8630b = testSuiteActivity;
        this.f8631c = levelPlayBannerAdView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8629a) {
            case 0:
                C2678zf.a(this.f8630b, this.f8631c);
                break;
            default:
                C2678zf.b(this.f8630b, this.f8631c);
                break;
        }
    }
}
