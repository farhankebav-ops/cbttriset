package com.ironsource;

import com.ironsource.C2627wf;
import com.ironsource.D0;
import com.ironsource.InterfaceC2652y6;
import com.ironsource.Za;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.LevelPlayAdSize;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.ironsource.n0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2459n0 extends C2623wb {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IronSource.a f9458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C2627wf.b f9459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final E5 f9460d;
    private final L8 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f9461f;

    /* JADX INFO: renamed from: com.ironsource.n0$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9462a = new a();

        private a() {
        }

        public static final C2459n0 a(IronSource.a adFormat, D0.b level) {
            kotlin.jvm.internal.k.e(adFormat, "adFormat");
            kotlin.jvm.internal.k.e(level, "level");
            return new C2459n0(adFormat, level);
        }
    }

    public C2459n0(IronSource.a adFormat, D0.b level) {
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        kotlin.jvm.internal.k.e(level, "level");
        this.e = Mb.f7131s.d().e();
        this.f9461f = TimeUnit.HOURS.toMillis(1L);
        this.f9458b = adFormat;
        this.f9460d = new E5(adFormat, level, null, null, 12, null);
        C2627wf.b bVarB = C2627wf.b(adFormat);
        kotlin.jvm.internal.k.d(bVarB, "createLogFactory(adFormat)");
        this.f9459c = bVarB;
    }

    public static /* synthetic */ String a(C2459n0 c2459n0, String str, String str2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createLogMessage");
        }
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        return c2459n0.a(str, str2);
    }

    public final String b(String str) {
        return a(this, str, (String) null, 2, (Object) null);
    }

    public final String c() {
        return a(this, (String) null, (String) null, 3, (Object) null);
    }

    public final IronSource.a d() {
        return this.f9458b;
    }

    public final E5 e() {
        return this.f9460d;
    }

    public final int f() {
        return Mb.f7131s.d().s().a(this.f9458b);
    }

    public final boolean g() {
        return Mb.f7131s.d().e().c();
    }

    public final String a(String str, String str2) {
        String strA = this.f9459c.a(str, str2);
        kotlin.jvm.internal.k.d(strA, "logFactory.createLogMessage(message, suffix)");
        return strA;
    }

    public final com.ironsource.lifecycle.b b() {
        com.ironsource.lifecycle.b bVarD = com.ironsource.lifecycle.b.d();
        kotlin.jvm.internal.k.d(bVarD, "getInstance()");
        return bVarD;
    }

    public final C2434ld c(String placementName) {
        kotlin.jvm.internal.k.e(placementName, "placementName");
        C2235ab c2235abA = this.e.a();
        if (c2235abA == null) {
            throw new IllegalStateException("Error getting sdk configurations");
        }
        C2434ld c2434ldC = c2235abA.c(LevelPlay.AdFormat.NATIVE_AD, placementName);
        if (c2434ldC != null) {
            return c2434ldC;
        }
        throw new IllegalStateException("Error getting sdk configurations");
    }

    public final Za.a d(String adUnitId) {
        kotlin.jvm.internal.k.e(adUnitId, "adUnitId");
        C2235ab c2235abA = this.e.a();
        if (c2235abA != null) {
            return c2235abA.a(adUnitId);
        }
        throw new IllegalStateException("Error getting sdk configurations");
    }

    public final C2434ld a(String placementName) {
        kotlin.jvm.internal.k.e(placementName, "placementName");
        C2235ab c2235abA = this.e.a();
        if (c2235abA != null) {
            C2434ld c2434ldC = c2235abA.c(LevelPlay.AdFormat.BANNER, placementName);
            if (c2434ldC != null) {
                return c2434ldC;
            }
            throw new IllegalStateException("Error getting placement");
        }
        throw new IllegalStateException("Error getting sdk configurations");
    }

    public final InterfaceC2652y6.a b(LevelPlay.AdFormat adFormat, String adUnitId) {
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        kotlin.jvm.internal.k.e(adUnitId, "adUnitId");
        C2235ab c2235abA = this.e.a();
        if (c2235abA != null) {
            return c2235abA.b(adFormat, adUnitId);
        }
        throw new IllegalStateException("Error getting sdk configurations");
    }

    public final long b(LevelPlay.AdFormat adFormat) {
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        C2235ab c2235abA = this.e.a();
        return c2235abA != null ? c2235abA.b(adFormat) : this.f9461f;
    }

    public C2459n0(C2459n0 adTools, D0.b level) {
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(level, "level");
        this.e = Mb.f7131s.d().e();
        this.f9461f = TimeUnit.HOURS.toMillis(1L);
        IronSource.a aVar = adTools.f9458b;
        this.f9458b = aVar;
        this.f9459c = adTools.f9459c;
        this.f9460d = new E5(aVar, level, adTools.f9460d.c(), null, 8, null);
    }

    public final C2434ld a(LevelPlay.AdFormat adFormat, String str) {
        C2235ab c2235abA;
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        if (str == null || (c2235abA = this.e.a()) == null) {
            return null;
        }
        return c2235abA.c(adFormat, str);
    }

    public final void a(Map<String, Object> data, ISBannerSize size) {
        kotlin.jvm.internal.k.e(data, "data");
        kotlin.jvm.internal.k.e(size, "size");
        com.ironsource.mediationsdk.l.a(data, size);
    }

    public final ISBannerSize a(LevelPlayAdSize adSize) {
        kotlin.jvm.internal.k.e(adSize, "adSize");
        return new C2403k0().b(adSize);
    }
}
