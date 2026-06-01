package com.instagram.common.viewpoint.core;

import android.os.Bundle;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.o4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2107o4 implements C1S {
    public final float A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public static String[] A04 = {"W5WZRfo3traFBsuJqUeacov", "AOz8vYfc0kUMyRrWtsrS4pOQsYE8BP6P", "ocEUeDJ9UZl7Q6o8h21wMsDJowBHj84j", "pkgO1YjXdbsvKDgws3J49uWJB6yyqkG7", "vCvp8tg1JPxrxhdMnot9YI84PFBkssaD", "Dazl9IXOnyCH5QLsvPseWpscLh5D5M0t", "ZYJ1zYUUdaXBOvkE2t6KLICz8MhT9p2M", "ySOVjFSAiUWhoASiDo2jZct"};
    public static final C2107o4 A06 = new C2107o4(0, 0);
    public static final String A0A = AbstractC04664a.A0h(0);
    public static final String A07 = AbstractC04664a.A0h(1);
    public static final String A09 = AbstractC04664a.A0h(2);
    public static final String A08 = AbstractC04664a.A0h(3);
    public static final C1R<C2107o4> A05 = new C1R() { // from class: com.facebook.ads.redexgen.X.o5
        @Override // com.instagram.common.viewpoint.core.C1R
        public final C1S A6X(Bundle bundle) {
            return C2107o4.A00(bundle);
        }
    };

    public C2107o4(int i2, int i8) {
        this(i2, i8, 0, 1.0f);
    }

    public C2107o4(int i2, int i8, int i9, float f4) {
        this.A03 = i2;
        this.A01 = i8;
        this.A02 = i9;
        this.A00 = f4;
    }

    public static /* synthetic */ C2107o4 A00(Bundle bundle) {
        int i2 = bundle.getInt(A0A, 0);
        int i8 = bundle.getInt(A07, 0);
        int height = bundle.getInt(A09, 0);
        return new C2107o4(i2, i8, height, bundle.getFloat(A08, 1.0f));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        boolean z2 = obj instanceof C2107o4;
        String[] strArr = A04;
        if (strArr[4].charAt(6) == strArr[2].charAt(6)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[4] = "xwJKUsQcskzDCgeEWIG9ozPdTsTzWcW9";
        strArr2[2] = "cRblKPLDWf1oyG1RJoVr7n5QNKGN7idl";
        if (!z2) {
            return false;
        }
        C2107o4 c2107o4 = (C2107o4) obj;
        return this.A03 == c2107o4.A03 && this.A01 == c2107o4.A01 && this.A02 == c2107o4.A02 && this.A00 == c2107o4.A00;
    }

    public final int hashCode() {
        int result = this.A03;
        int result2 = ((((7 * 31) + result) * 31) + this.A01) * 31;
        int result3 = this.A02;
        return ((result2 + result3) * 31) + Float.floatToRawIntBits(this.A00);
    }
}
