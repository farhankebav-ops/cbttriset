package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class B6 implements E6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2669z6 f6375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2567t6 f6376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private C2567t6 f6377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f6378d;

    public B6(C2669z6 strategy, C2567t6 currentAdUnit, C2567t6 c2567t6, boolean z2) {
        kotlin.jvm.internal.k.e(strategy, "strategy");
        kotlin.jvm.internal.k.e(currentAdUnit, "currentAdUnit");
        this.f6375a = strategy;
        this.f6376b = currentAdUnit;
        this.f6377c = c2567t6;
        this.f6378d = z2;
    }

    @Override // com.ironsource.E6
    public void a(Activity activity) {
        kotlin.jvm.internal.k.e(activity, "activity");
        this.f6375a.a(new D6(this.f6375a, this.f6376b, this.f6377c));
        this.f6376b.a(activity, this.f6375a);
    }

    @Override // com.ironsource.E6
    public void b(C2567t6 adUnit, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        if (kotlin.jvm.internal.k.a(this.f6376b, adUnit)) {
            this.f6375a.a("load success after current ad is loaded");
        }
    }

    @Override // com.ironsource.E6
    public void c(C2567t6 adUnit, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        if (adUnit.equals(this.f6376b)) {
            this.f6375a.d().onAdInfoChanged(adInfo);
        }
    }

    @Override // com.ironsource.E6
    public void loadAd() {
        q5.x xVar;
        if (this.f6378d) {
            this.f6375a.a("load called while current ad is loaded");
            return;
        }
        this.f6378d = true;
        LevelPlayAdInfo levelPlayAdInfoE = this.f6376b.e();
        if (levelPlayAdInfoE != null) {
            this.f6375a.d().b(levelPlayAdInfoE);
            xVar = q5.x.f13520a;
        } else {
            xVar = null;
        }
        if (xVar == null) {
            this.f6375a.a("current ad is loaded without ad info");
        } else if (this.f6377c == null) {
            C2567t6 c2567t6A = this.f6375a.b().a(false, this.f6375a.c());
            this.f6377c = c2567t6A;
            c2567t6A.a(this.f6375a);
        }
    }

    @Override // com.ironsource.E6
    public void b(C2567t6 adUnit, IronSourceError ironSourceError) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        if (adUnit.equals(this.f6377c)) {
            this.f6377c = null;
        } else {
            this.f6375a.a("load failed after current ad is loaded");
        }
    }

    @Override // com.ironsource.E6
    public void a(C2567t6 adUnit, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        if (adUnit.equals(this.f6376b)) {
            this.f6375a.a("show success when loaded");
        } else {
            this.f6375a.a("progressive show success while current ad is loaded");
        }
    }

    public /* synthetic */ B6(C2669z6 c2669z6, C2567t6 c2567t6, C2567t6 c2567t62, boolean z2, int i2, kotlin.jvm.internal.f fVar) {
        this(c2669z6, c2567t6, c2567t62, (i2 & 8) != 0 ? false : z2);
    }

    @Override // com.ironsource.E6
    public void a(C2567t6 adUnit, IronSourceError ironSourceError) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        if (adUnit.equals(this.f6376b)) {
            this.f6375a.a("show failed when loaded");
        } else {
            this.f6375a.a("progressive show failed while current ad is loaded");
        }
    }

    @Override // com.ironsource.E6
    public void a(C2567t6 adUnit) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        if (adUnit.equals(this.f6377c)) {
            this.f6377c = null;
        } else if (adUnit.equals(this.f6376b)) {
            a();
        }
    }

    private final void a() {
        E6 c62;
        C2567t6 c2567t6 = this.f6377c;
        if (c2567t6 == null) {
            C2669z6 c2669z6 = this.f6375a;
            c2669z6.a(new A6(c2669z6));
        } else {
            if (c2567t6.e() != null) {
                C2669z6 c2669z62 = this.f6375a;
                C2567t6 c2567t62 = this.f6377c;
                kotlin.jvm.internal.k.b(c2567t62);
                c62 = new B6(c2669z62, c2567t62, null, false, 8, null);
            } else {
                C2669z6 c2669z63 = this.f6375a;
                C2567t6 c2567t63 = this.f6377c;
                kotlin.jvm.internal.k.b(c2567t63);
                c62 = new C6(c2669z63, c2567t63, false);
            }
            this.f6375a.a(c62);
        }
        this.f6375a.d().a();
    }
}
