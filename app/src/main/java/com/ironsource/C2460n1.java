package com.ironsource;

import com.ironsource.mediationsdk.IronSource;

/* JADX INFO: renamed from: com.ironsource.n1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2460n1 implements InterfaceC2478o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IronSource.a f9463a;

    /* JADX INFO: renamed from: com.ironsource.n1$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9464a;

        static {
            int[] iArr = new int[IronSource.a.values().length];
            try {
                iArr[IronSource.a.INTERSTITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IronSource.a.REWARDED_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IronSource.a.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f9464a = iArr;
        }
    }

    public C2460n1(IronSource.a adFormat) {
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        this.f9463a = adFormat;
    }

    @Override // com.ironsource.InterfaceC2478o1
    public InterfaceC2495p1 a(InterfaceC2404k1 eventBaseData) {
        kotlin.jvm.internal.k.e(eventBaseData, "eventBaseData");
        int i2 = a.f9464a[this.f9463a.ordinal()];
        if (i2 == 1) {
            return new E9(eventBaseData);
        }
        if (i2 == 2) {
            return new Yd(eventBaseData);
        }
        if (i2 == 3) {
            return new S2(eventBaseData);
        }
        throw new IllegalArgumentException("Unsupported ad format: " + this.f9463a);
    }
}
