package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.rewarded.LevelPlayReward;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class D6 implements E6, InterfaceC2618w6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2669z6 f6597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2567t6 f6598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private C2567t6 f6599c;

    public D6(C2669z6 strategy, C2567t6 currentAdUnit, C2567t6 c2567t6) {
        kotlin.jvm.internal.k.e(strategy, "strategy");
        kotlin.jvm.internal.k.e(currentAdUnit, "currentAdUnit");
        this.f6597a = strategy;
        this.f6598b = currentAdUnit;
        this.f6599c = c2567t6;
        currentAdUnit.a(this);
    }

    @Override // com.ironsource.E6
    public void a(Activity activity) {
        kotlin.jvm.internal.k.e(activity, "activity");
        this.f6597a.a("show called while showing");
    }

    @Override // com.ironsource.E6
    public void b(C2567t6 adUnit, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        if (adUnit == this.f6598b) {
            this.f6597a.a("load success while current ad is showing");
        }
    }

    @Override // com.ironsource.E6
    public void c(C2567t6 adUnit, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        if (adUnit == this.f6598b) {
            this.f6597a.a("ad info changed while current ad is showing");
        }
    }

    @Override // com.ironsource.J0
    public void g() {
        this.f6597a.c().g();
    }

    @Override // com.ironsource.E6
    public void loadAd() {
        this.f6597a.a("load called while showing");
    }

    @Override // com.ironsource.InterfaceC2618w6
    public void onClosed() {
        this.f6597a.a(a(this, null, 1, null));
        this.f6597a.c().onClosed();
    }

    @Override // com.ironsource.E6
    public void a(C2567t6 adUnit, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        if (adUnit.equals(this.f6598b)) {
            this.f6597a.d().a(adInfo);
        } else {
            this.f6597a.a("progressive show success while showing current ad");
        }
    }

    @Override // com.ironsource.E6
    public void b(C2567t6 adUnit, IronSourceError ironSourceError) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        if (adUnit == this.f6599c) {
            this.f6599c = null;
        } else {
            this.f6597a.a("load failed while current ad is showing");
        }
    }

    @Override // com.ironsource.E6
    public void a(C2567t6 adUnit, IronSourceError ironSourceError) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        if (!adUnit.equals(this.f6598b)) {
            this.f6597a.a("progressive show failed while showing current ad");
            return;
        }
        this.f6597a.a(a(ironSourceError));
        this.f6597a.d().c(ironSourceError);
    }

    @Override // com.ironsource.E6
    public void a(C2567t6 adUnit) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        if (adUnit == this.f6599c) {
            this.f6599c = null;
        } else {
            this.f6597a.a("ad expired while current ad is showing");
        }
    }

    @Override // com.ironsource.InterfaceC2618w6
    public void a(LevelPlayReward reward) {
        kotlin.jvm.internal.k.e(reward, "reward");
        this.f6597a.c().a(reward);
    }

    public static /* synthetic */ E6 a(D6 d62, IronSourceError ironSourceError, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            ironSourceError = null;
        }
        return d62.a(ironSourceError);
    }

    private final E6 a(IronSourceError ironSourceError) {
        if (C2319f5.f8526a.a(ironSourceError)) {
            return new B6(this.f6597a, this.f6598b, this.f6599c, true);
        }
        C2567t6 c2567t6 = this.f6599c;
        if (c2567t6 == null) {
            return new A6(this.f6597a);
        }
        if (c2567t6.e() != null) {
            return new B6(this.f6597a, c2567t6, null, false, 8, null);
        }
        return new C6(this.f6597a, c2567t6, false);
    }
}
