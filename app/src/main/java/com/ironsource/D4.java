package com.ironsource;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class D4 implements A7 {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6437a;

        static {
            int[] iArr = new int[EnumC2667z4.values().length];
            try {
                iArr[EnumC2667z4.IADS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC2667z4.UADS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC2667z4.SHARED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC2667z4.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f6437a = iArr;
        }
    }

    @Override // com.ironsource.A7
    public F4 a(Context context, EnumC2667z4 source) {
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(source, "source");
        int i2 = a.f6437a[source.ordinal()];
        if (i2 == 1) {
            return new C4(context, "supersonic_shared_preferen");
        }
        if (i2 == 2) {
            return new C4(context, "unityads-installinfo");
        }
        if (i2 == 3) {
            return new C4(context, E4.f6657c);
        }
        if (i2 == 4) {
            return null;
        }
        throw new e2.s(3);
    }
}
