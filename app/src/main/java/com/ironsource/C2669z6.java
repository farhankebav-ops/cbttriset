package com.ironsource;

import android.app.Activity;
import com.ironsource.C2567t6;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: renamed from: com.ironsource.z6, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2669z6 implements InterfaceC2652y6, C2567t6.b, C2567t6.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f10626f = new a(null);
    public static final String g = "Fullscreen ProgressiveOnLoaded Strategy";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2459n0 f10627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC2584u6 f10628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InterfaceC2618w6 f10629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final InterfaceC2635x6 f10630d;
    private E6 e;

    /* JADX INFO: renamed from: com.ironsource.z6$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        private a() {
        }
    }

    public C2669z6(C2459n0 adTools, InterfaceC2584u6 factory, InterfaceC2618w6 fullscreenAdUnitListener, InterfaceC2635x6 listener) {
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(factory, "factory");
        kotlin.jvm.internal.k.e(fullscreenAdUnitListener, "fullscreenAdUnitListener");
        kotlin.jvm.internal.k.e(listener, "listener");
        this.f10627a = adTools;
        this.f10628b = factory;
        this.f10629c = fullscreenAdUnitListener;
        this.f10630d = listener;
        this.e = new A6(this);
    }

    public final C2459n0 a() {
        return this.f10627a;
    }

    public final InterfaceC2584u6 b() {
        return this.f10628b;
    }

    public final InterfaceC2618w6 c() {
        return this.f10629c;
    }

    public final InterfaceC2635x6 d() {
        return this.f10630d;
    }

    @Override // com.ironsource.InterfaceC2652y6
    public void loadAd() {
        this.e.loadAd();
    }

    public final void a(E6 state) {
        kotlin.jvm.internal.k.e(state, "state");
        this.e = state;
    }

    @Override // com.ironsource.C2567t6.b
    public void b(C2567t6 adUnit, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.e.b(adUnit, adInfo);
    }

    @Override // com.ironsource.C2567t6.b
    public void c(C2567t6 adUnit, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.e.c(adUnit, adInfo);
    }

    @Override // com.ironsource.InterfaceC2652y6
    public void a(Activity activity) {
        kotlin.jvm.internal.k.e(activity, "activity");
        this.e.a(activity);
    }

    @Override // com.ironsource.C2567t6.b
    public void b(C2567t6 adUnit, IronSourceError ironSourceError) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        this.e.b(adUnit, ironSourceError);
    }

    @Override // com.ironsource.C2567t6.b
    public void a(C2567t6 adUnit) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        this.e.a(adUnit);
    }

    @Override // com.ironsource.C2567t6.a
    public void a(C2567t6 adUnit, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.e.a(adUnit, adInfo);
    }

    @Override // com.ironsource.C2567t6.a
    public void a(C2567t6 adUnit, IronSourceError ironSourceError) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        this.e.a(adUnit, ironSourceError);
    }

    public final void a(String message) {
        kotlin.jvm.internal.k.e(message, "message");
        this.f10627a.e().h().f("Fullscreen ProgressiveOnLoaded Strategy - ".concat(message));
    }
}
