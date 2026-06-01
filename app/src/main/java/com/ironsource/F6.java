package com.ironsource;

import android.app.Activity;
import com.ironsource.C2567t6;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class F6 implements InterfaceC2652y6, C2567t6.b, C2567t6.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f6752f = new a(null);
    public static final String g = "Fullscreen ProgressiveOnShown Strategy";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2459n0 f6753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC2584u6 f6754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InterfaceC2618w6 f6755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final InterfaceC2635x6 f6756d;
    private L6 e;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        private a() {
        }
    }

    public F6(C2459n0 adTools, InterfaceC2584u6 factory, InterfaceC2618w6 fullscreenAdUnitListener, InterfaceC2635x6 listener) {
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(factory, "factory");
        kotlin.jvm.internal.k.e(fullscreenAdUnitListener, "fullscreenAdUnitListener");
        kotlin.jvm.internal.k.e(listener, "listener");
        this.f6753a = adTools;
        this.f6754b = factory;
        this.f6755c = fullscreenAdUnitListener;
        this.f6756d = listener;
        this.e = new G6(this, null, false, 4, null);
    }

    public final C2459n0 a() {
        return this.f6753a;
    }

    public final InterfaceC2584u6 b() {
        return this.f6754b;
    }

    public final InterfaceC2618w6 c() {
        return this.f6755c;
    }

    public final InterfaceC2635x6 d() {
        return this.f6756d;
    }

    @Override // com.ironsource.InterfaceC2652y6
    public void loadAd() {
        this.e.loadAd();
    }

    @Override // com.ironsource.InterfaceC2652y6
    public void a(Activity activity) {
        kotlin.jvm.internal.k.e(activity, "activity");
        this.e.a(activity);
    }

    @Override // com.ironsource.C2567t6.b
    public void b(C2567t6 adUnit, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.e.c(adInfo);
    }

    @Override // com.ironsource.C2567t6.b
    public void c(C2567t6 adUnit, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.e.b(adInfo);
    }

    public final void a(L6 state) {
        kotlin.jvm.internal.k.e(state, "state");
        this.e = state;
    }

    @Override // com.ironsource.C2567t6.b
    public void b(C2567t6 adUnit, IronSourceError ironSourceError) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        this.e.a(ironSourceError);
    }

    public final void a(String message) {
        kotlin.jvm.internal.k.e(message, "message");
        this.f6753a.e().h().f("Fullscreen ProgressiveOnShown Strategy - ".concat(message));
    }

    @Override // com.ironsource.C2567t6.a
    public void a(C2567t6 adUnit, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.e.a(adInfo);
    }

    @Override // com.ironsource.C2567t6.a
    public void a(C2567t6 adUnit, IronSourceError ironSourceError) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        this.e.c(ironSourceError);
    }

    @Override // com.ironsource.C2567t6.b
    public void a(C2567t6 adUnit) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        this.e.a();
    }
}
