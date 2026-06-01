package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class L3 {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7087a;

        static {
            int[] iArr = new int[Q3.values().length];
            try {
                iArr[Q3.Pacing.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Q3.ShowCount.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Q3.Delivery.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f7087a = iArr;
        }
    }

    public final int a(Q3 cappingType) {
        kotlin.jvm.internal.k.e(cappingType, "cappingType");
        int i2 = a.f7087a[cappingType.ordinal()];
        if (i2 == 1 || i2 == 2) {
            return 3000;
        }
        if (i2 == 3) {
            return 3001;
        }
        throw new e2.s(3);
    }
}
