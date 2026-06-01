package com.ironsource;

import android.app.Activity;
import com.ironsource.C2409k6;
import com.ironsource.InterfaceC2368i0;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: renamed from: com.ironsource.p6, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2500p6 implements InterfaceC2550s6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2271cb f9627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC2565t4 f9628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f9629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LevelPlayAdInfo f9630d;

    public C2500p6(C2271cb adInternal, InterfaceC2565t4 currentTimeProvider) {
        kotlin.jvm.internal.k.e(adInternal, "adInternal");
        kotlin.jvm.internal.k.e(currentTimeProvider, "currentTimeProvider");
        this.f9627a = adInternal;
        this.f9628b = currentTimeProvider;
        this.f9629c = currentTimeProvider.a();
        String string = adInternal.e().toString();
        kotlin.jvm.internal.k.d(string, "adInternal.adId.toString()");
        this.f9630d = new LevelPlayAdInfo(string, adInternal.h(), adInternal.d().toString(), null, null, null, null, null, 248, null);
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void a(Activity activity, String str) {
        kotlin.jvm.internal.k.e(activity, "activity");
        String string = this.f9627a.e().toString();
        kotlin.jvm.internal.k.d(string, "adInternal.adId.toString()");
        this.f9627a.a(new LevelPlayAdError(string, this.f9627a.h(), LevelPlayAdError.ERROR_CODE_SHOW_BEFORE_LOAD_SUCCESS_CALLBACK, "Show is called while loading ad"), this.f9630d);
    }

    @Override // com.ironsource.InterfaceC2550s6
    public LevelPlayAdInfo b() {
        return this.f9630d;
    }

    @Override // com.ironsource.InterfaceC2550s6
    public InterfaceC2368i0 c() {
        return new InterfaceC2368i0.a("Ad is loading");
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void loadAd() {
        String string = this.f9627a.e().toString();
        kotlin.jvm.internal.k.d(string, "adInternal.adId.toString()");
        this.f9627a.a(new LevelPlayAdError(string, this.f9627a.h(), LevelPlayAdError.ERROR_CODE_LOAD_FAILED_ALREADY_CALLED, "Load is already called"), this.f9628b.a() - this.f9629c);
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdClicked() {
        this.f9627a.a("onAdClicked on loading state");
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdClosed() {
        this.f9627a.a("onAdClosed on loading state");
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdDisplayed(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f9627a.a("onAdDisplayed on loading state");
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdInfoChanged(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f9627a.a("onAdInfoChanged on loading state");
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdLoadFailed(LevelPlayAdError error) {
        kotlin.jvm.internal.k.e(error, "error");
        this.f9627a.a(error, this.f9628b.a() - this.f9629c);
        this.f9627a.a(C2409k6.a.LoadFailed);
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdLoaded(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        C2271cb c2271cb = this.f9627a;
        c2271cb.a(new C2483o6(c2271cb, adInfo, this.f9628b));
        this.f9627a.a(adInfo);
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void a() {
        this.f9627a.a("onAdExpired on loading state");
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void a(LevelPlayAdError error) {
        kotlin.jvm.internal.k.e(error, "error");
        this.f9627a.a("onAdDisplayFailed on loading state with error: " + error.getErrorMessage());
    }
}
