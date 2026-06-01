package com.ironsource;

import android.content.Context;
import com.ironsource.C2627wf;
import com.ironsource.D0;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.unity3d.mediation.LevelPlayAdSize;
import java.util.List;

/* JADX INFO: renamed from: com.ironsource.k0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2403k0 extends C2623wb {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final E5 f8810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C2627wf.b f8811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final L8 f8812d;

    public C2403k0() {
        IronSource.a aVar = IronSource.a.BANNER;
        this.f8810b = new E5(aVar, D0.b.MEDIATION, null, null, 12, null);
        C2627wf.b bVarB = C2627wf.b(aVar);
        kotlin.jvm.internal.k.d(bVarB, "createLogFactory(IronSource.AD_UNIT.BANNER)");
        this.f8811c = bVarB;
        this.f8812d = Mb.f7131s.d().e();
    }

    public static /* synthetic */ String a(C2403k0 c2403k0, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        return c2403k0.a(str, str2);
    }

    private final ISBannerSize c(LevelPlayAdSize levelPlayAdSize) {
        return kotlin.jvm.internal.k.a(levelPlayAdSize, LevelPlayAdSize.LARGE) ? new ISBannerSize(com.ironsource.mediationsdk.l.f9205b, levelPlayAdSize.getWidth(), levelPlayAdSize.getHeight()) : kotlin.jvm.internal.k.a(levelPlayAdSize, LevelPlayAdSize.MEDIUM_RECTANGLE) ? new ISBannerSize(com.ironsource.mediationsdk.l.f9206c, levelPlayAdSize.getWidth(), levelPlayAdSize.getHeight()) : kotlin.jvm.internal.k.a(levelPlayAdSize, LevelPlayAdSize.LEADERBOARD) ? new ISBannerSize(com.ironsource.mediationsdk.l.e, 0, 0) : levelPlayAdSize.equals(LevelPlayAdSize.Companion.createCustomSize(levelPlayAdSize.getWidth(), levelPlayAdSize.getHeight())) ? new ISBannerSize(levelPlayAdSize.getWidth(), levelPlayAdSize.getHeight()) : new ISBannerSize(com.ironsource.mediationsdk.l.f9204a, levelPlayAdSize.getWidth(), levelPlayAdSize.getHeight());
    }

    public final List<LevelPlayAdSize> b() {
        C2235ab c2235abA = this.f8812d.a();
        if (c2235abA != null) {
            return c2235abA.h();
        }
        throw new IllegalStateException("Error getting sdk configurations");
    }

    public final boolean d() {
        return Mb.f7131s.d().e().c();
    }

    public final String a(String str, String str2) {
        String strA = this.f8811c.a(str, str2);
        kotlin.jvm.internal.k.d(strA, "logFactory.createLogMessage(message, suffix)");
        return strA;
    }

    public final int a(int i2) {
        return com.ironsource.mediationsdk.l.a(i2);
    }

    private final ISBannerSize a(LevelPlayAdSize levelPlayAdSize) {
        LevelPlayAdSize fallbackAdSize$mediationsdk_release = levelPlayAdSize.getFallbackAdSize$mediationsdk_release();
        if (fallbackAdSize$mediationsdk_release == null) {
            fallbackAdSize$mediationsdk_release = LevelPlayAdSize.BANNER;
        }
        ISBannerSize iSBannerSizeB = b(fallbackAdSize$mediationsdk_release);
        iSBannerSizeB.setAdaptive(true);
        com.ironsource.mediationsdk.o.f9265a.a(iSBannerSizeB, new Y7(levelPlayAdSize.getWidth(), levelPlayAdSize.getHeight()));
        return iSBannerSizeB;
    }

    public final Integer b(Context context) {
        kotlin.jvm.internal.k.e(context, "context");
        Float fC = c();
        if (fC != null) {
            return Integer.valueOf(a.a.U(fC.floatValue() * C2301e5.f8427a.a(context)));
        }
        return null;
    }

    public final ISBannerSize b(LevelPlayAdSize size) {
        kotlin.jvm.internal.k.e(size, "size");
        boolean zIsAdaptive = size.isAdaptive();
        if (zIsAdaptive) {
            return a(size);
        }
        if (!zIsAdaptive) {
            return c(size);
        }
        throw new e2.s(3);
    }

    private final Float c() {
        C2235ab c2235abA = this.f8812d.a();
        Float fValueOf = c2235abA != null ? Float.valueOf(c2235abA.i()) : null;
        if (fValueOf != null) {
            return fValueOf;
        }
        this.f8810b.h().f("MaxScreenSizePercentageForBannerHeight is null: Error getting sdk configurations");
        return null;
    }
}
