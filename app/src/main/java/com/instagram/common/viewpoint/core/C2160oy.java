package com.instagram.common.viewpoint.core;

import android.os.Bundle;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.oy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2160oy implements C1S {
    public C1N A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public static String[] A06 = {"SFReXFLlI4UOpNrTR2oqZFPGLDG", "ddXxuwKTXrUgQKU5ch6dGlXzKHCNOB4g", "Ka5UQw68nW6F3F15EfeRiHjBxEcftjYi", "TyFhGc", "kpbiwOTtMuCD4LdTginQH36Spnec", "0F8UT5ylucYBCPc3EM7PRaW9", "xfENz4MNKGXPVezlH9FH4FhAxccJ4akv", "0RZwBffOFnQLfCTDTyZnu0"};
    public static final C2160oy A07 = new C1O().A05();
    public static final String A0A = AbstractC04664a.A0h(0);
    public static final String A0B = AbstractC04664a.A0h(1);
    public static final String A0D = AbstractC04664a.A0h(2);
    public static final String A09 = AbstractC04664a.A0h(3);
    public static final String A0C = AbstractC04664a.A0h(4);
    public static final C1R<C2160oy> A08 = new C1R() { // from class: com.facebook.ads.redexgen.X.oz
        @Override // com.instagram.common.viewpoint.core.C1R
        public final C1S A6X(Bundle bundle) {
            return C2160oy.A00(bundle);
        }
    };

    public C2160oy(int i2, int i8, int i9, int i10, int i11) {
        this.A02 = i2;
        this.A03 = i8;
        this.A05 = i9;
        this.A01 = i10;
        this.A04 = i11;
    }

    public static /* synthetic */ C2160oy A00(Bundle bundle) {
        C1O c1o = new C1O();
        if (bundle.containsKey(A0A)) {
            c1o.A01(bundle.getInt(A0A));
        }
        if (bundle.containsKey(A0B)) {
            c1o.A02(bundle.getInt(A0B));
        }
        String str = A0D;
        if (A06[0].length() == 22) {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[5] = "GWwDRzmwjjhTaGez4rqlH73J";
        strArr[4] = "f0ceflDKapN9i1ydncZgjkps1oFM";
        if (bundle.containsKey(str)) {
            c1o.A04(bundle.getInt(A0D));
        }
        if (bundle.containsKey(A09)) {
            c1o.A00(bundle.getInt(A09));
        }
        if (bundle.containsKey(A0C)) {
            c1o.A03(bundle.getInt(A0C));
        }
        return c1o.A05();
    }

    public final C1N A01() {
        if (this.A00 == null) {
            this.A00 = new C1N(this);
        }
        return this.A00;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2160oy c2160oy = (C2160oy) obj;
        return this.A02 == c2160oy.A02 && this.A03 == c2160oy.A03 && this.A05 == c2160oy.A05 && this.A01 == c2160oy.A01 && this.A04 == c2160oy.A04;
    }

    public final int hashCode() {
        int result = this.A02;
        int result2 = ((((17 * 31) + result) * 31) + this.A03) * 31;
        int result3 = this.A05;
        int result4 = (((result2 + result3) * 31) + this.A01) * 31;
        int result5 = this.A04;
        return result4 + result5;
    }
}
