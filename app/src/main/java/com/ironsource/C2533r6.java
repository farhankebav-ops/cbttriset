package com.ironsource;

import android.app.Activity;
import com.ironsource.C2409k6;
import com.ironsource.InterfaceC2368i0;
import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: renamed from: com.ironsource.r6, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2533r6 implements InterfaceC2550s6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2271cb f9765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LevelPlayAdInfo f9766b;

    public C2533r6(C2271cb adInternal, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInternal, "adInternal");
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f9765a = adInternal;
        this.f9766b = adInfo;
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void a(Activity activity, String str) {
        kotlin.jvm.internal.k.e(activity, "activity");
        String string = this.f9765a.e().toString();
        kotlin.jvm.internal.k.d(string, "adInternal.adId.toString()");
        this.f9765a.a(new LevelPlayAdError(string, this.f9765a.h(), LevelPlayAdError.ERROR_CODE_SHOW_WHILE_SHOW, "Ad is already shown"), this.f9766b);
    }

    @Override // com.ironsource.InterfaceC2550s6
    public LevelPlayAdInfo b() {
        return this.f9766b;
    }

    @Override // com.ironsource.InterfaceC2550s6
    public InterfaceC2368i0 c() {
        return new InterfaceC2368i0.a("ad is shown");
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void loadAd() {
        String string = this.f9765a.e().toString();
        kotlin.jvm.internal.k.d(string, "adInternal.adId.toString()");
        C2271cb.a(this.f9765a, new LevelPlayAdError(string, this.f9765a.h(), LevelPlayAdError.ERROR_CODE_LOAD_WHILE_SHOW, "Load is called while ad is shown"), 0L, 2, null);
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdClicked() {
        IronLog.INTERNAL.verbose(C2459n0.a(this.f9765a.f(), "onAdClicked adInfo: " + this.f9766b, (String) null, 2, (Object) null));
        this.f9765a.f().e(new qi(this, 2));
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdClosed() {
        IronLog.INTERNAL.verbose(C2459n0.a(this.f9765a.f(), "onAdClosed adInfo: " + this.f9766b, (String) null, 2, (Object) null));
        this.f9765a.f().d(new qi(this, 0));
        this.f9765a.f().e(new qi(this, 1));
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdDisplayed(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f9765a.a("onAdDisplayed on shown state");
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdInfoChanged(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f9765a.a("onAdInfoChanged on shown state");
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdLoadFailed(LevelPlayAdError error) {
        kotlin.jvm.internal.k.e(error, "error");
        this.f9765a.a("onAdLoadFailed on shown state with error: " + error.getErrorMessage());
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdLoaded(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f9765a.a("onAdLoaded on shown state");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C2533r6 this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.f9765a.a(C2409k6.a.Closed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(C2533r6 this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        InterfaceC2289db interfaceC2289dbK = this$0.f9765a.k();
        if (interfaceC2289dbK != null) {
            interfaceC2289dbK.onAdClosed(this$0.f9766b);
        }
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void a() {
        this.f9765a.a("onAdExpired on shown state");
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void a(LevelPlayAdError error) {
        kotlin.jvm.internal.k.e(error, "error");
        this.f9765a.a("onAdDisplayFailed on shown state with error: " + error.getErrorMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2533r6 this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        InterfaceC2289db interfaceC2289dbK = this$0.f9765a.k();
        if (interfaceC2289dbK != null) {
            interfaceC2289dbK.onAdClicked(this$0.f9766b);
        }
    }
}
