package com.ironsource;

import com.ironsource.P8;
import com.ironsource.mediationsdk.IronSource;
import com.unity3d.mediation.LevelPlay;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
class Te implements P8, P8.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f7642c = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<IronSource.a, Integer> f7643a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2288da f7644b = new C2288da();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7645a;

        static {
            int[] iArr = new int[IronSource.a.values().length];
            f7645a = iArr;
            try {
                iArr[IronSource.a.REWARDED_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7645a[IronSource.a.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7645a[IronSource.a.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7645a[IronSource.a.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public Te() {
        for (IronSource.a aVar : IronSource.a.values()) {
            a(aVar, 1);
        }
    }

    private void a(IronSource.a aVar, int i2) {
        this.f7643a.put(aVar, Integer.valueOf(i2));
        int i8 = a.f7645a[aVar.ordinal()];
        if (i8 == 1) {
            this.f7644b.d(i2);
            return;
        }
        if (i8 == 2) {
            this.f7644b.b(i2);
        } else if (i8 == 3) {
            this.f7644b.a(i2);
        } else {
            if (i8 != 4) {
                return;
            }
            this.f7644b.c(i2);
        }
    }

    @Override // com.ironsource.P8.a
    public synchronized void b(IronSource.a aVar) {
        if (aVar == null) {
            return;
        }
        a(aVar, this.f7643a.get(aVar).intValue() + 1);
    }

    @Override // com.ironsource.P8
    public synchronized int a(IronSource.a aVar) {
        int iIntValue = -1;
        if (aVar == null) {
            return -1;
        }
        Integer num = this.f7643a.get(aVar);
        if (num != null) {
            iIntValue = num.intValue();
        }
        return iIntValue;
    }

    @Override // com.ironsource.P8
    public int a(LevelPlay.AdFormat adFormat) {
        if (adFormat == null) {
            return -1;
        }
        return a(com.unity3d.mediation.a.a(adFormat)) - 1;
    }
}
