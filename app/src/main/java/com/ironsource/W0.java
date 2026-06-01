package com.ironsource;

import com.ironsource.Q6;
import com.ironsource.mediationsdk.IronSource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class W0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final W0 f7752a = new W0();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7753a;

        static {
            int[] iArr = new int[IronSource.a.values().length];
            try {
                iArr[IronSource.a.REWARDED_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IronSource.a.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IronSource.a.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IronSource.a.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f7753a = iArr;
        }
    }

    private W0() {
    }

    public static final Q6.a a(IronSource.a adUnit) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        int i2 = a.f7753a[adUnit.ordinal()];
        if (i2 == 1) {
            return Q6.a.REWARDED_VIDEO;
        }
        if (i2 == 2) {
            return Q6.a.INTERSTITIAL;
        }
        if (i2 == 3) {
            return Q6.a.BANNER;
        }
        if (i2 == 4) {
            return Q6.a.NATIVE_AD;
        }
        throw new e2.s(3);
    }
}
