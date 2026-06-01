package com.ironsource;

import android.app.Activity;
import com.ironsource.C2567t6;
import com.ironsource.InterfaceC2652y6;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class M6 implements InterfaceC2652y6, C2567t6.b, C2567t6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2459n0 f7118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC2652y6.a f7119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InterfaceC2584u6 f7120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final InterfaceC2618w6 f7121d;
    private final InterfaceC2635x6 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private C2567t6 f7122f;

    public M6(C2459n0 adTools, InterfaceC2652y6.a config, InterfaceC2584u6 fullscreenAdUnitFactory, InterfaceC2618w6 fullscreenAdUnitListener, InterfaceC2635x6 listener) {
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(config, "config");
        kotlin.jvm.internal.k.e(fullscreenAdUnitFactory, "fullscreenAdUnitFactory");
        kotlin.jvm.internal.k.e(fullscreenAdUnitListener, "fullscreenAdUnitListener");
        kotlin.jvm.internal.k.e(listener, "listener");
        this.f7118a = adTools;
        this.f7119b = config;
        this.f7120c = fullscreenAdUnitFactory;
        this.f7121d = fullscreenAdUnitListener;
        this.e = listener;
    }

    public final C2459n0 a() {
        return this.f7118a;
    }

    public final InterfaceC2652y6.a b() {
        return this.f7119b;
    }

    @Override // com.ironsource.C2567t6.b
    public void c(C2567t6 adUnit, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.e.onAdInfoChanged(adInfo);
    }

    @Override // com.ironsource.InterfaceC2652y6
    public void loadAd() {
        C2567t6 c2567t6A = this.f7120c.a(true, this.f7121d);
        c2567t6A.a(this);
        this.f7122f = c2567t6A;
    }

    @Override // com.ironsource.InterfaceC2652y6
    public void a(Activity activity) {
        kotlin.jvm.internal.k.e(activity, "activity");
        C2567t6 c2567t6 = this.f7122f;
        if (c2567t6 != null) {
            c2567t6.a(activity, this);
        }
    }

    @Override // com.ironsource.C2567t6.b
    public void b(C2567t6 adUnit, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.e.b(adInfo);
    }

    @Override // com.ironsource.C2567t6.b
    public void a(C2567t6 adUnit) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        this.f7122f = null;
        this.e.a();
    }

    @Override // com.ironsource.C2567t6.b
    public void b(C2567t6 adUnit, IronSourceError ironSourceError) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        this.e.a(ironSourceError);
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
}
