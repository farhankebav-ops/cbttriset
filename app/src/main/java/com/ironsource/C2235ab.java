package com.ironsource;

import com.ironsource.Ad;
import com.ironsource.C2543s;
import com.ironsource.InterfaceC2652y6;
import com.ironsource.U2;
import com.ironsource.Za;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.LevelPlayAdSize;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.ironsource.ab, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2235ab extends C2435le {

    /* JADX INFO: renamed from: com.ironsource.ab$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7983a;

        static {
            int[] iArr = new int[LevelPlay.AdFormat.values().length];
            try {
                iArr[LevelPlay.AdFormat.REWARDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LevelPlay.AdFormat.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LevelPlay.AdFormat.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LevelPlay.AdFormat.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f7983a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2235ab(C2435le sdkConfig) {
        super(sdkConfig);
        kotlin.jvm.internal.k.e(sdkConfig, "sdkConfig");
    }

    public final boolean a(String adUnitId, LevelPlay.AdFormat adFormat) {
        Map<String, Ad.b> mapA;
        kotlin.jvm.internal.k.e(adUnitId, "adUnitId");
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        Ad.a aVar = g().d().a().get(adFormat);
        return (aVar == null || (mapA = aVar.a()) == null || !mapA.containsKey(adUnitId)) ? false : true;
    }

    public final InterfaceC2652y6.a b(LevelPlay.AdFormat adFormat, String adUnitId) {
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        kotlin.jvm.internal.k.e(adUnitId, "adUnitId");
        return new InterfaceC2652y6.a(a(adFormat, adUnitId));
    }

    public final List<C2675zc> c(LevelPlay.AdFormat adFormat) {
        Map<String, Ad.b> mapA;
        Set<String> setKeySet;
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        Ad.a aVar = g().d().a().get(adFormat);
        if (aVar == null || (mapA = aVar.a()) == null || (setKeySet = mapA.keySet()) == null) {
            return r5.r.f13638a;
        }
        ArrayList arrayList = new ArrayList(r5.n.L0(setKeySet, 10));
        Iterator<T> it = setKeySet.iterator();
        while (it.hasNext()) {
            arrayList.add(d(adFormat, (String) it.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            r5.l.Q0((Iterable) obj, arrayList2);
        }
        return r5.l.U0(arrayList2);
    }

    public final List<C2675zc> d(LevelPlay.AdFormat adFormat, String adUnitId) {
        Map<String, Ad.b> mapA;
        Ad.b bVar;
        List<String> listA;
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        kotlin.jvm.internal.k.e(adUnitId, "adUnitId");
        Ad.a aVar = g().d().a().get(adFormat);
        if (aVar == null || (mapA = aVar.a()) == null || (bVar = mapA.get(adUnitId)) == null || (listA = bVar.a()) == null) {
            return r5.r.f13638a;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listA.iterator();
        while (it.hasNext()) {
            C2675zc c2675zc = g().e().a().get((String) it.next());
            if (c2675zc != null) {
                arrayList.add(c2675zc);
            }
        }
        return arrayList;
    }

    public final List<LevelPlayAdSize> h() {
        List<String> listA = g().a().c().b().a();
        ArrayList arrayList = new ArrayList(r5.n.L0(listA, 10));
        Iterator<T> it = listA.iterator();
        while (it.hasNext()) {
            arrayList.add(LevelPlayAdSize.Companion.createAdSize$mediationsdk_release((String) it.next()));
        }
        return arrayList;
    }

    public final float i() {
        return g().a().c().b().b();
    }

    public final boolean j() {
        com.ironsource.mediationsdk.adquality.a aVarA = d().c().a();
        return aVarA != null && aVarA.b();
    }

    public final boolean k() {
        return g().a().b().d();
    }

    public final C2490od b(C2623wb tools) {
        kotlin.jvm.internal.k.e(tools, "tools");
        return new C2490od(tools, g().a().a());
    }

    public final long b(LevelPlay.AdFormat adFormat) {
        C2543s.d dVarB;
        Long lD;
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        C2543s c2543s = g().a().a().get(adFormat);
        long jLongValue = (c2543s == null || (dVarB = c2543s.b()) == null || (lD = dVarB.d()) == null) ? 60L : lD.longValue();
        return jLongValue > 0 ? TimeUnit.MINUTES.toMillis(jLongValue) : jLongValue;
    }

    public final Za.a a(String adUnitId) {
        long jD;
        kotlin.jvm.internal.k.e(adUnitId, "adUnitId");
        U2 u2C = g().a().c();
        U2.b bVar = u2C.a().get(adUnitId);
        int iC = bVar != null ? bVar.c() : u2C.b().c();
        boolean zE = bVar != null ? bVar.e() : u2C.b().e();
        if (bVar != null) {
            jD = bVar.d();
        } else {
            jD = u2C.b().d();
        }
        return new Za.a(zE, iC, jD);
    }

    public final List<String> a(LevelPlay.AdFormat adFormat) {
        Map<String, Ad.b> mapA;
        Set<String> setKeySet;
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        Ad.a aVar = g().d().a().get(adFormat);
        return (aVar == null || (mapA = aVar.a()) == null || (setKeySet = mapA.keySet()) == null) ? r5.r.f13638a : r5.l.n1(setKeySet);
    }

    public final C2561t0 a(C2623wb tools) {
        kotlin.jvm.internal.k.e(tools, "tools");
        return new C2561t0(tools, g().a().a());
    }

    public final C2434ld c(LevelPlay.AdFormat adFormat, String str) {
        C2434ld c2434ldA;
        K9 k9A;
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        int i2 = a.f7983a[adFormat.ordinal()];
        if (i2 == 1) {
            Zd zdF = d().c().f();
            if (zdF == null || (c2434ldA = zdF.a(str)) == null) {
                return null;
            }
            return new C2434ld(c2434ldA.b(), c2434ldA.c(), c2434ldA.d(), c2434ldA.f(), c2434ldA.e(), c2434ldA.a());
        }
        if (i2 == 2) {
            F9 f9D = d().c().d();
            if (f9D == null || (k9A = f9D.a(str)) == null) {
                return null;
            }
            return new C2434ld(k9A);
        }
        if (i2 == 3) {
            V2 v2C = d().c().c();
            if (v2C != null) {
                C2371i3 c2371i3A = v2C.a(str);
                if (c2371i3A == null) {
                    c2371i3A = v2C.i();
                    kotlin.jvm.internal.k.d(c2371i3A, "config.defaultBannerPlacement");
                }
                return new C2434ld(c2371i3A);
            }
            throw new IllegalStateException("Error getting " + adFormat + " configurations");
        }
        if (i2 == 4) {
            Rb rbE = d().c().e();
            if (rbE != null && str != null) {
                C2272cc c2272ccA = rbE.a(str);
                if (c2272ccA == null) {
                    c2272ccA = rbE.e();
                }
                if (c2272ccA != null) {
                    return new C2434ld(c2272ccA);
                }
            }
            throw new IllegalStateException("Error getting " + adFormat + " configurations");
        }
        throw new e2.s(3);
    }

    private final InterfaceC2652y6.c a(LevelPlay.AdFormat adFormat, String str) {
        C2543s.d dVarB;
        C2642xd c2642xdG;
        Map<String, C2543s.d> mapA;
        C2543s.d dVar;
        C2642xd c2642xdG2;
        boolean z2 = adFormat == LevelPlay.AdFormat.REWARDED;
        C2543s c2543s = g().a().a().get(adFormat);
        InterfaceC2652y6.c cVarA = null;
        InterfaceC2652y6.c cVarA2 = (c2543s == null || (mapA = c2543s.a()) == null || (dVar = mapA.get(str)) == null || (c2642xdG2 = dVar.g()) == null) ? null : c2642xdG2.a();
        if (c2543s != null && (dVarB = c2543s.b()) != null && (c2642xdG = dVarB.g()) != null) {
            cVarA = c2642xdG.a();
        }
        if (cVarA2 == null) {
            cVarA2 = cVarA;
        }
        if (cVarA2 != null) {
            return cVarA2;
        }
        if (z2) {
            return InterfaceC2652y6.c.PROGRESSIVE_ON_SHOW_SUCCESS;
        }
        return InterfaceC2652y6.c.SINGLE;
    }

    public final Jd c(C2623wb tools) {
        kotlin.jvm.internal.k.e(tools, "tools");
        C2543s c2543s = g().a().a().get(LevelPlay.AdFormat.REWARDED);
        return new Jd(tools, c2543s != null ? c2543s.a() : null, c2543s != null ? c2543s.c() : null);
    }
}
