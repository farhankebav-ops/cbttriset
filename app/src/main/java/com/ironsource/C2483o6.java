package com.ironsource;

import android.app.Activity;
import com.ironsource.C2409k6;
import com.ironsource.InterfaceC2368i0;
import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: renamed from: com.ironsource.o6, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2483o6 implements InterfaceC2550s6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2271cb f9550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LevelPlayAdInfo f9551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InterfaceC2565t4 f9552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f9553d;

    public C2483o6(C2271cb adInternal, LevelPlayAdInfo adInfo, InterfaceC2565t4 currentTimeProvider) {
        kotlin.jvm.internal.k.e(adInternal, "adInternal");
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        kotlin.jvm.internal.k.e(currentTimeProvider, "currentTimeProvider");
        this.f9550a = adInternal;
        this.f9551b = adInfo;
        this.f9552c = currentTimeProvider;
        this.f9553d = currentTimeProvider.a();
    }

    private final long d() {
        return this.f9552c.a() - this.f9553d;
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void a(Activity activity, String str) {
        kotlin.jvm.internal.k.e(activity, "activity");
        C2434ld c2434ldA = this.f9550a.f().a(this.f9550a.d(), str);
        LevelPlayAdInfo levelPlayAdInfo = new LevelPlayAdInfo(this.f9551b, str);
        this.f9551b = levelPlayAdInfo;
        C2271cb c2271cb = this.f9550a;
        c2271cb.a(new C2517q6(c2271cb, levelPlayAdInfo));
        this.f9550a.c().a(activity, c2434ldA);
    }

    @Override // com.ironsource.InterfaceC2550s6
    public InterfaceC2368i0 c() {
        O3 o3A = this.f9550a.l().f().a(this.f9550a.h());
        return o3A.d() ? InterfaceC2368i0.a.f8685c.a(o3A.e()) : InterfaceC2368i0.b.f8688a;
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void loadAd() {
        this.f9550a.f().e().h().a(Long.valueOf(d()));
        this.f9550a.a(this.f9551b);
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdClicked() {
        this.f9550a.a("onAdClicked on loaded state");
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdClosed() {
        this.f9550a.a("onAdClosed on loaded state");
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdDisplayed(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f9550a.a("onAdDisplayed on loaded state");
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdInfoChanged(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        C2459n0 c2459n0F = this.f9550a.f();
        IronLog.INTERNAL.verbose(C2459n0.a(c2459n0F, "onAdInfoChanged adInfo: " + adInfo, (String) null, 2, (Object) null));
        c2459n0F.e().h().a(this.f9551b, adInfo);
        this.f9551b = adInfo;
        c2459n0F.e(new ti(21, this, adInfo));
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdLoadFailed(LevelPlayAdError error) {
        kotlin.jvm.internal.k.e(error, "error");
        this.f9550a.a("onAdLoadFailed on loaded state with error: " + error.getErrorMessage());
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void onAdLoaded(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f9550a.a("onAdLoaded on loaded state");
    }

    @Override // com.ironsource.InterfaceC2550s6
    public LevelPlayAdInfo b() {
        return this.f9551b;
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void a() {
        IronLog.INTERNAL.verbose(C2459n0.a(this.f9550a.f(), "onAdExpired", (String) null, 2, (Object) null));
        this.f9550a.a(C2409k6.a.Expired);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2483o6 this$0, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(adInfo, "$adInfo");
        InterfaceC2289db interfaceC2289dbK = this$0.f9550a.k();
        if (interfaceC2289dbK != null) {
            interfaceC2289dbK.onAdInfoChanged(adInfo);
        }
    }

    @Override // com.ironsource.InterfaceC2550s6
    public void a(LevelPlayAdError error) {
        kotlin.jvm.internal.k.e(error, "error");
        this.f9550a.a("onAdDisplayFailed on loaded state with error: " + error.getErrorMessage());
    }
}
