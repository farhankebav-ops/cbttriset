package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.o7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2110o7 implements C1S {
    public final int A00;
    public final C2120oH A01;
    public final boolean A02;
    public final int[] A03;
    public final boolean[] A04;
    public static final String A07 = AbstractC04664a.A0h(0);
    public static final String A09 = AbstractC04664a.A0h(1);
    public static final String A08 = AbstractC04664a.A0h(3);
    public static final String A06 = AbstractC04664a.A0h(4);
    public static final C1R<C2110o7> A05 = new C1R() { // from class: com.facebook.ads.redexgen.X.o8
        @Override // com.instagram.common.viewpoint.core.C1R
        public final C1S A6X(Bundle bundle) {
            return C2110o7.A00(bundle);
        }
    };

    public C2110o7(C2120oH c2120oH, boolean z2, int[] iArr, boolean[] zArr) {
        this.A00 = c2120oH.A01;
        boolean z7 = false;
        C3M.A07(this.A00 == iArr.length && this.A00 == zArr.length);
        this.A01 = c2120oH;
        if (z2 && this.A00 > 1) {
            z7 = true;
        }
        this.A02 = z7;
        this.A03 = (int[]) iArr.clone();
        this.A04 = (boolean[]) zArr.clone();
    }

    public static /* synthetic */ C2110o7 A00(Bundle bundle) {
        C2120oH c2120oH = (C2120oH) C2120oH.A06.A6X((Bundle) C3M.A01(bundle.getBundle(A07)));
        int[] iArr = (int[]) AbstractC1811j1.A00(bundle.getIntArray(A09), new int[c2120oH.A01]);
        boolean[] selected = (boolean[]) AbstractC1811j1.A00(bundle.getBooleanArray(A08), new boolean[c2120oH.A01]);
        return new C2110o7(c2120oH, bundle.getBoolean(A06, false), iArr, selected);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2110o7 c2110o7 = (C2110o7) obj;
        if (this.A02 == c2110o7.A02 && this.A01.equals(c2110o7.A01) && Arrays.equals(this.A03, c2110o7.A03) && Arrays.equals(this.A04, c2110o7.A04)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.A01.hashCode() * 31) + (this.A02 ? 1 : 0)) * 31) + Arrays.hashCode(this.A03)) * 31) + Arrays.hashCode(this.A04);
    }
}
