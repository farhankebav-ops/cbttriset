package com.ironsource;

import android.app.Activity;
import com.ironsource.InterfaceC2368i0;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: renamed from: com.ironsource.k6, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2409k6 implements InterfaceC2550s6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2271cb f8839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f8840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LevelPlayAdInfo f8841c;

    /* JADX INFO: renamed from: com.ironsource.k6$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum a {
        Created,
        Closed,
        Expired,
        ShowFailed,
        LoadFailed
    }

    public C2409k6(C2271cb adInternal, a status) {
        kotlin.jvm.internal.k.e(adInternal, "adInternal");
        kotlin.jvm.internal.k.e(status, "status");
        this.f8839a = adInternal;
        this.f8840b = status;
        String string = adInternal.e().toString();
        kotlin.jvm.internal.k.d(string, "adInternal.adId.toString()");
        this.f8841c = new LevelPlayAdInfo(string, adInternal.h(), adInternal.d().toString(), null, null, null, null, null, 248, null);
    }

    private final boolean d() {
        if (this.f8839a.h().length() == 0) {
            C2271cb c2271cb = this.f8839a;
            String string = this.f8839a.e().toString();
            kotlin.jvm.internal.k.d(string, "adInternal.adId.toString()");
            C2271cb.a(c2271cb, new LevelPlayAdError(string, this.f8839a.h(), LevelPlayAdError.ERROR_CODE_NO_AD_UNIT_ID_SPECIFIED, "Ad unit ID should be specified"), 0L, 2, null);
            return false;
        }
        if (!this.f8839a.f().g()) {
            C2271cb c2271cb2 = this.f8839a;
            String string2 = this.f8839a.e().toString();
            kotlin.jvm.internal.k.d(string2, "adInternal.adId.toString()");
            C2271cb.a(c2271cb2, new LevelPlayAdError(string2, this.f8839a.h(), LevelPlayAdError.ERROR_CODE_LOAD_BEFORE_INIT_SUCCESS_CALLBACK, "Load must be called after init success callback"), 0L, 2, null);
            return false;
        }
        C2235ab c2235abA = this.f8839a.l().e().a();
        if (c2235abA != null && c2235abA.a(this.f8839a.h(), this.f8839a.d())) {
            return true;
        }
        C2271cb c2271cb3 = this.f8839a;
        String string3 = this.f8839a.e().toString();
        kotlin.jvm.internal.k.d(string3, "adInternal.adId.toString()");
        C2271cb.a(c2271cb3, new LevelPlayAdError(string3, this.f8839a.h(), LevelPlayAdError.ERROR_CODE_INVALID_AD_UNIT_ID, "Invalid ad unit id"), 0L, 2, null);
        return false;
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void a(Activity activity, String str) {
        kotlin.jvm.internal.k.e(activity, "activity");
        String str2 = this.f8840b == a.Expired ? "Show called on expired ad" : "Show called before load success";
        String string = this.f8839a.e().toString();
        kotlin.jvm.internal.k.d(string, "adInternal.adId.toString()");
        this.f8839a.a(new LevelPlayAdError(string, this.f8839a.h(), LevelPlayAdError.ERROR_CODE_SHOW_BEFORE_LOAD_SUCCESS_CALLBACK, str2), this.f8841c);
    }

    @Override // com.ironsource.InterfaceC2550s6
    public LevelPlayAdInfo b() {
        return this.f8841c;
    }

    @Override // com.ironsource.InterfaceC2550s6
    public InterfaceC2368i0 c() {
        return new InterfaceC2368i0.a(this.f8840b == a.Expired ? "ad is invalid due to loading time" : "load ad was not called");
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void loadAd() {
        if (d()) {
            this.f8839a.o();
        }
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdClicked() {
        this.f8839a.a("onAdClicked on " + this.f8840b + " state");
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdClosed() {
        this.f8839a.a("onAdClosed on " + this.f8840b + " state");
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdDisplayed(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f8839a.a("onAdDisplayed on " + this.f8840b + " state");
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdInfoChanged(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f8839a.a("onAdInfoChanged on " + this.f8840b + " state");
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdLoadFailed(LevelPlayAdError error) {
        kotlin.jvm.internal.k.e(error, "error");
        this.f8839a.a("onAdLoadFailed on " + this.f8840b + " state with error: " + error.getErrorMessage());
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdLoaded(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f8839a.a("onAdLoaded on " + this.f8840b + " state");
    }

    public /* synthetic */ C2409k6(C2271cb c2271cb, a aVar, int i2, kotlin.jvm.internal.f fVar) {
        this(c2271cb, (i2 & 2) != 0 ? a.Created : aVar);
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void a(LevelPlayAdError error) {
        kotlin.jvm.internal.k.e(error, "error");
        this.f8839a.a("onAdDisplayFailed on " + this.f8840b + " state with error: " + error.getErrorMessage());
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void a() {
        this.f8839a.a("onAdExpired on " + this.f8840b + " state");
    }
}
