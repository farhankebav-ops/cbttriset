package com.ironsource;

import android.app.Activity;
import com.ironsource.C2409k6;
import com.ironsource.InterfaceC2368i0;
import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: renamed from: com.ironsource.q6, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2517q6 implements InterfaceC2550s6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2271cb f9695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LevelPlayAdInfo f9696b;

    public C2517q6(C2271cb adInternal, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInternal, "adInternal");
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f9695a = adInternal;
        this.f9696b = adInfo;
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void a(Activity activity, String str) {
        kotlin.jvm.internal.k.e(activity, "activity");
        String string = this.f9695a.e().toString();
        kotlin.jvm.internal.k.d(string, "adInternal.adId.toString()");
        this.f9695a.a(new LevelPlayAdError(string, this.f9695a.h(), LevelPlayAdError.ERROR_CODE_SHOW_WHILE_SHOW, "Ad is already showing"), this.f9696b);
    }

    @Override // com.ironsource.InterfaceC2550s6
    public InterfaceC2368i0 c() {
        return new InterfaceC2368i0.a("ad is showing");
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void loadAd() {
        String string = this.f9695a.e().toString();
        kotlin.jvm.internal.k.d(string, "adInternal.adId.toString()");
        C2271cb.a(this.f9695a, new LevelPlayAdError(string, this.f9695a.h(), LevelPlayAdError.ERROR_CODE_LOAD_WHILE_SHOW, "Load is called while ad is showing"), 0L, 2, null);
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdClicked() {
        this.f9695a.a("onAdClicked on showing state");
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdClosed() {
        this.f9695a.a("onAdClosed on showing state");
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdDisplayed(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        C2459n0 c2459n0F = this.f9695a.f();
        LevelPlayAdInfo levelPlayAdInfo = new LevelPlayAdInfo(adInfo, this.f9696b.getPlacementName());
        IronLog.INTERNAL.verbose(C2459n0.a(c2459n0F, "onAdDisplayed adInfo: " + levelPlayAdInfo, (String) null, 2, (Object) null));
        c2459n0F.e().h().e();
        C2271cb c2271cb = this.f9695a;
        c2271cb.a(new C2533r6(c2271cb, levelPlayAdInfo));
        c2459n0F.e(new ti(22, this, levelPlayAdInfo));
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdInfoChanged(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f9695a.a("onAdInfoChanged on showing state");
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdLoadFailed(LevelPlayAdError error) {
        kotlin.jvm.internal.k.e(error, "error");
        this.f9695a.a("onAdLoadFailed on showing state with error: " + error.getErrorMessage());
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdLoaded(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f9695a.a("onAdLoaded on showing state");
    }

    @Override // com.ironsource.InterfaceC2550s6
    public LevelPlayAdInfo b() {
        return this.f9696b;
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void a(LevelPlayAdError error) {
        kotlin.jvm.internal.k.e(error, "error");
        this.f9695a.a(a(error, this.f9696b));
        this.f9695a.a(error, this.f9696b);
    }

    private final InterfaceC2550s6 a(LevelPlayAdError levelPlayAdError, LevelPlayAdInfo levelPlayAdInfo) {
        if (C2319f5.f8526a.a(Pf.f7396a.a(levelPlayAdError))) {
            C2271cb c2271cb = this.f9695a;
            return new C2483o6(c2271cb, levelPlayAdInfo, c2271cb.j());
        }
        return new C2409k6(this.f9695a, C2409k6.a.ShowFailed);
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void a() {
        this.f9695a.a("onAdExpired on showing state");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2517q6 this$0, LevelPlayAdInfo adInfoWithPlacement) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(adInfoWithPlacement, "$adInfoWithPlacement");
        InterfaceC2289db interfaceC2289dbK = this$0.f9695a.k();
        if (interfaceC2289dbK != null) {
            interfaceC2289dbK.onAdDisplayed(adInfoWithPlacement);
        }
    }
}
