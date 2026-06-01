package com.ironsource;

import android.app.Activity;
import com.ironsource.C2409k6;
import com.ironsource.C2459n0;
import com.ironsource.D0;
import com.ironsource.InterfaceC2368i0;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.rewarded.LevelPlayReward;
import java.util.UUID;

/* JADX INFO: renamed from: com.ironsource.cb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2271cb implements InterfaceC2391j6 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f8140n = new a(null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f8141o = "Fullscreen Ad Internal";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LevelPlay.AdFormat f8142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f8144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final C2459n0 f8145d;
    private final C2374i6 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final InterfaceC2612w0 f8146f;
    private final L7 g;
    private final InterfaceC2565t4 h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final q5.f f8147i;
    private InterfaceC2289db j;
    private final UUID k;
    private InterfaceC2550s6 l;
    private C2426l5 m;

    /* JADX INFO: renamed from: com.ironsource.cb$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final boolean a(String placementName, LevelPlay.AdFormat adFormat) {
            kotlin.jvm.internal.k.e(placementName, "placementName");
            kotlin.jvm.internal.k.e(adFormat, "adFormat");
            C2459n0 c2459n0A = C2459n0.a.a(com.unity3d.mediation.a.a(adFormat), D0.b.MEDIATION);
            if (!c2459n0A.g()) {
                c2459n0A.e().a().a(placementName, "SDK is not initialized", false);
                return false;
            }
            O3 o3A = Mb.f7131s.d().p().a(placementName, adFormat);
            boolean zD = o3A.d();
            c2459n0A.e().a().a(placementName, o3A.e(), zD);
            return zD;
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.ironsource.cb$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface b {
        Double getBidFloor();
    }

    /* JADX INFO: renamed from: com.ironsource.cb$c */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final C2459n0 f8148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final C2374i6 f8149b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final L7 f8150c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final InterfaceC2565t4 f8151d;
        private final C2670z7 e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final b f8152f;

        public c(C2459n0 adTools, C2374i6 adControllerFactory, L7 provider, InterfaceC2565t4 currentTimeProvider, C2670z7 idFactory, b config) {
            kotlin.jvm.internal.k.e(adTools, "adTools");
            kotlin.jvm.internal.k.e(adControllerFactory, "adControllerFactory");
            kotlin.jvm.internal.k.e(provider, "provider");
            kotlin.jvm.internal.k.e(currentTimeProvider, "currentTimeProvider");
            kotlin.jvm.internal.k.e(idFactory, "idFactory");
            kotlin.jvm.internal.k.e(config, "config");
            this.f8148a = adTools;
            this.f8149b = adControllerFactory;
            this.f8150c = provider;
            this.f8151d = currentTimeProvider;
            this.e = idFactory;
            this.f8152f = config;
        }

        public final C2374i6 a() {
            return this.f8149b;
        }

        public final C2459n0 b() {
            return this.f8148a;
        }

        public final b c() {
            return this.f8152f;
        }

        public final InterfaceC2565t4 d() {
            return this.f8151d;
        }

        public final C2670z7 e() {
            return this.e;
        }

        public final L7 f() {
            return this.f8150c;
        }
    }

    /* JADX INFO: renamed from: com.ironsource.cb$d */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class d extends kotlin.jvm.internal.l implements e6.a {
        public d() {
            super(0);
        }

        @Override // e6.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C2356h6 invoke() {
            return C2271cb.this.b();
        }
    }

    /* JADX INFO: renamed from: com.ironsource.cb$e */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class e implements InterfaceC2584u6 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ C2314f0 f8155b;

        public e(C2314f0 c2314f0) {
            this.f8155b = c2314f0;
        }

        @Override // com.ironsource.InterfaceC2584u6
        public C2567t6 a(boolean z2, InterfaceC2618w6 listener) {
            kotlin.jvm.internal.k.e(listener, "listener");
            AbstractC2595v0 abstractC2595v0A = C2271cb.this.g().a(z2, this.f8155b);
            return new C2567t6(Mb.f7131s.c(), new V0(C2271cb.this.f(), abstractC2595v0A, D0.b.MEDIATION), abstractC2595v0A, listener, null, null, null, null, 240, null);
        }
    }

    public C2271cb(LevelPlay.AdFormat adFormat, String adUnitId, b config, C2459n0 adTools, C2374i6 fullscreenAdControllerFactory, InterfaceC2612w0 adUnitDataFactory, L7 mediationServicesProvider, InterfaceC2565t4 currentTimeProvider, C2670z7 idFactory) {
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        kotlin.jvm.internal.k.e(adUnitId, "adUnitId");
        kotlin.jvm.internal.k.e(config, "config");
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(fullscreenAdControllerFactory, "fullscreenAdControllerFactory");
        kotlin.jvm.internal.k.e(adUnitDataFactory, "adUnitDataFactory");
        kotlin.jvm.internal.k.e(mediationServicesProvider, "mediationServicesProvider");
        kotlin.jvm.internal.k.e(currentTimeProvider, "currentTimeProvider");
        kotlin.jvm.internal.k.e(idFactory, "idFactory");
        this.f8142a = adFormat;
        this.f8143b = adUnitId;
        this.f8144c = config;
        this.f8145d = adTools;
        this.e = fullscreenAdControllerFactory;
        this.f8146f = adUnitDataFactory;
        this.g = mediationServicesProvider;
        this.h = currentTimeProvider;
        this.f8147i = n7.b.C(new d());
        UUID uuidA = idFactory.a();
        this.k = uuidA;
        this.l = new C2409k6(this, null, 2, 0 == true ? 1 : 0);
        adTools.e().a(new C2458n(com.unity3d.mediation.a.a(adFormat), uuidA, adUnitId));
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C2271cb this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.f8145d.e().f().a();
        this$0.l.loadAd();
    }

    public final C2356h6 c() {
        return (C2356h6) this.f8147i.getValue();
    }

    public final LevelPlay.AdFormat d() {
        return this.f8142a;
    }

    @Override // com.ironsource.InterfaceC2391j6
    public void onAdClicked() {
        this.f8145d.d(new ai(this, 1));
    }

    @Override // com.ironsource.InterfaceC2391j6
    public void onAdClosed() {
        this.f8145d.d(new ai(this, 0));
    }

    @Override // com.ironsource.InterfaceC2391j6
    public void onAdDisplayed(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f8145d.d(new ci(this, adInfo, 3));
    }

    @Override // com.ironsource.InterfaceC2391j6
    public void onAdInfoChanged(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f8145d.d(new ci(this, adInfo, 2));
    }

    @Override // com.ironsource.InterfaceC2391j6
    public void onAdLoadFailed(LevelPlayAdError error) {
        kotlin.jvm.internal.k.e(error, "error");
        this.f8145d.d(new bi(this, error, 3));
    }

    @Override // com.ironsource.InterfaceC2391j6
    public void onAdLoaded(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f8145d.d(new ci(this, adInfo, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(C2271cb this$0, LevelPlayAdError error) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(error, "$error");
        this$0.l.onAdLoadFailed(error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(C2271cb this$0, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(adInfo, "$adInfo");
        this$0.l.onAdLoaded(adInfo);
    }

    private final void p() {
        Double bidFloor = this.f8144c.getBidFloor();
        if (bidFloor != null) {
            this.f8145d.e().f().a(bidFloor.doubleValue());
        }
    }

    public final void a(InterfaceC2289db interfaceC2289db) {
        this.j = interfaceC2289db;
    }

    public final UUID e() {
        return this.k;
    }

    public final C2459n0 f() {
        return this.f8145d;
    }

    public final InterfaceC2612w0 g() {
        return this.f8146f;
    }

    public final String h() {
        return this.f8143b;
    }

    public final b i() {
        return this.f8144c;
    }

    public final InterfaceC2565t4 j() {
        return this.h;
    }

    public final InterfaceC2289db k() {
        return this.j;
    }

    public final L7 l() {
        return this.g;
    }

    public final boolean m() {
        InterfaceC2368i0 interfaceC2368i0C = this.l.c();
        this.f8145d.e().e().a(Boolean.valueOf(interfaceC2368i0C.a()), interfaceC2368i0C instanceof InterfaceC2368i0.a ? ((InterfaceC2368i0.a) interfaceC2368i0C).c() : null);
        return interfaceC2368i0C.a();
    }

    public final void n() {
        this.m = new C2426l5();
        this.f8145d.d(new ai(this, 2));
    }

    public final void o() {
        a(new C2500p6(this, this.h));
        c().p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C2271cb this$0, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(adInfo, "$adInfo");
        this$0.l.onAdDisplayed(adInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(C2271cb this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.l.onAdClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(C2271cb this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.l.onAdClosed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(C2271cb this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.l.a();
    }

    public final void a(InterfaceC2550s6 state) {
        kotlin.jvm.internal.k.e(state, "state");
        this.l = state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C2271cb this$0, LevelPlayAdError error) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(error, "$error");
        this$0.l.a(error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(C2271cb this$0, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(adInfo, "$adInfo");
        this$0.l.onAdInfoChanged(adInfo);
    }

    public final void a(Activity activity, String str) {
        kotlin.jvm.internal.k.e(activity, "activity");
        this.f8145d.d(new androidx.camera.core.processing.c(activity, this, str, 19));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Activity activity, C2271cb this$0, String str) {
        kotlin.jvm.internal.k.e(activity, "$activity");
        kotlin.jvm.internal.k.e(this$0, "this$0");
        ContextProvider.getInstance().updateActivity(activity);
        this$0.f8145d.e().h().d();
        this$0.l.a(activity, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C2356h6 b() {
        C2434ld c2434ld = null;
        C2314f0 c2314f0 = new C2314f0(com.unity3d.mediation.a.a(this.f8142a), this.k, this.f8143b, c2434ld, this.g.A().a(), this.f8144c.getBidFloor(), 8, null);
        e eVar = new e(c2314f0);
        E5 e5E = this.f8145d.e();
        C2459n0 c2459n0 = this.f8145d;
        e5E.a(new B0(c2459n0, c2314f0, c2459n0.b(this.f8142a, this.f8143b).b().b()));
        return this.e.a(this, this.f8145d, c2314f0, eVar);
    }

    public final void a(C2409k6.a status) {
        kotlin.jvm.internal.k.e(status, "status");
        this.l = new C2409k6(this, status);
    }

    @Override // com.ironsource.InterfaceC2391j6
    public void a(LevelPlayAdError error) {
        kotlin.jvm.internal.k.e(error, "error");
        this.f8145d.d(new bi(this, error, 0));
    }

    @Override // com.ironsource.InterfaceC2391j6
    public void a() {
        this.f8145d.d(new ai(this, 3));
    }

    @Override // com.ironsource.InterfaceC2391j6
    public void a(LevelPlayReward reward) {
        kotlin.jvm.internal.k.e(reward, "reward");
        IronLog.INTERNAL.verbose(C2459n0.a(this.f8145d, "onAdRewarded adInfo: " + this.l.b() + " reward: " + reward, (String) null, 2, (Object) null));
        this.f8145d.e(new ti(13, this, reward));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2271cb this$0, LevelPlayReward reward) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(reward, "$reward");
        InterfaceC2289db interfaceC2289db = this$0.j;
        if (interfaceC2289db != null) {
            interfaceC2289db.onAdRewarded(reward, this$0.l.b());
        }
    }

    public final void a(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        IronLog.INTERNAL.verbose(C2459n0.a(this.f8145d, "onAdLoaded adInfo: " + adInfo, (String) null, 2, (Object) null));
        this.f8145d.d(new androidx.camera.video.internal.encoder.c(this, C2426l5.a(this.m), 2));
        this.f8145d.e(new ci(this, adInfo, 0));
    }

    public /* synthetic */ C2271cb(LevelPlay.AdFormat adFormat, String str, b bVar, C2459n0 c2459n0, C2374i6 c2374i6, InterfaceC2612w0 interfaceC2612w0, L7 l72, InterfaceC2565t4 interfaceC2565t4, C2670z7 c2670z7, int i2, kotlin.jvm.internal.f fVar) {
        this(adFormat, str, bVar, c2459n0, c2374i6, interfaceC2612w0, (i2 & 64) != 0 ? Mb.f7131s.d() : l72, interfaceC2565t4, c2670z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2271cb this$0, long j) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.f8145d.e().f().a(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2271cb this$0, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(adInfo, "$adInfo");
        InterfaceC2289db interfaceC2289db = this$0.j;
        if (interfaceC2289db != null) {
            interfaceC2289db.onAdLoaded(adInfo);
        }
    }

    public static /* synthetic */ void a(C2271cb c2271cb, LevelPlayAdError levelPlayAdError, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        c2271cb.a(levelPlayAdError, j);
    }

    public final void a(LevelPlayAdError levelPlayAdError, long j) {
        IronLog.INTERNAL.verbose(C2459n0.a(this.f8145d, "onAdLoadFailed error: " + levelPlayAdError, (String) null, 2, (Object) null));
        this.f8145d.d(new com.google.firebase.crashlytics.internal.common.g(this, j, levelPlayAdError, 2));
        this.f8145d.e(new bi(this, levelPlayAdError));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2271cb this$0, long j, LevelPlayAdError levelPlayAdError) {
        String errorMessage;
        kotlin.jvm.internal.k.e(this$0, "this$0");
        Vc vcF = this$0.f8145d.e().f();
        int errorCode = levelPlayAdError != null ? levelPlayAdError.getErrorCode() : 0;
        if (levelPlayAdError == null || (errorMessage = levelPlayAdError.getErrorMessage()) == null) {
            errorMessage = "";
        }
        vcF.a(j, errorCode, errorMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LevelPlayAdError levelPlayAdError, C2271cb this$0) {
        InterfaceC2289db interfaceC2289db;
        kotlin.jvm.internal.k.e(this$0, "this$0");
        if (levelPlayAdError == null || (interfaceC2289db = this$0.j) == null) {
            return;
        }
        interfaceC2289db.onAdLoadFailed(levelPlayAdError);
    }

    public final void a(LevelPlayAdError error, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(error, "error");
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        IronLog.INTERNAL.verbose(C2459n0.a(this.f8145d, "onAdDisplayFailed error: " + error + ", adInfo: " + adInfo, (String) null, 2, (Object) null));
        this.f8145d.d(new bi(this, error, 2));
        this.f8145d.e(new androidx.camera.core.processing.c(this, error, adInfo, 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2271cb this$0, LevelPlayAdError error) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(error, "$error");
        this$0.f8145d.e().h().a(error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2271cb this$0, LevelPlayAdError error, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(error, "$error");
        kotlin.jvm.internal.k.e(adInfo, "$adInfo");
        InterfaceC2289db interfaceC2289db = this$0.j;
        if (interfaceC2289db != null) {
            interfaceC2289db.onAdDisplayFailed(error, adInfo);
        }
    }

    public final void a(String message) {
        kotlin.jvm.internal.k.e(message, "message");
        this.f8145d.e().h().f("Fullscreen Ad Internal - ".concat(message));
    }
}
