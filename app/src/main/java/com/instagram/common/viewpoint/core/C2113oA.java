package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.oA, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2113oA implements C1S {
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final int A08;
    public final int A09;
    public final int A0A;
    public final int A0B;
    public final int A0C;
    public final int A0D;
    public final int A0E;
    public final int A0F;
    public final AbstractC2025mj<C2120oH, C2115oC> A0G;
    public final AbstractC0620Al<Integer> A0H;
    public final List<String> A0I;
    public final List<String> A0J;
    public final List<String> A0K;

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "D56211926, support language flag in video track")
    public final List<String> A0L;
    public final List<String> A0M;
    public final boolean A0N;
    public final boolean A0O;
    public final boolean A0P;
    public final boolean A0Q;
    public static String[] A0R = {"ecAn5Ikcafht4KcMZpX18dHmTeG8rnIh", "O", "Vx9C7fUBXFy", "cKO0A2evnlm", "R", "rpFdJ5zk5Ol8xjSS", "qZWz1duFRNhDMFyjKiwH3aw2o0rFUhRF", "hV3JjrOLxn9Scij6u0uxCGiRNaQ2ZOqV"};
    public static final C2113oA A0U = new AnonymousClass35().A0p();

    @Deprecated
    public static final C2113oA A0T = A0U;
    public static final String A0j = AbstractC04664a.A0h(1);
    public static final String A0l = AbstractC04664a.A0h(2);
    public static final String A0m = AbstractC04664a.A0h(3);
    public static final String A0n = AbstractC04664a.A0h(4);
    public static final String A0s = AbstractC04664a.A0h(5);
    public static final String A0e = AbstractC04664a.A0h(6);
    public static final String A0d = AbstractC04664a.A0h(7);
    public static final String A0c = AbstractC04664a.A0h(8);
    public static final String A0b = AbstractC04664a.A0h(9);
    public static final String A0i = AbstractC04664a.A0h(10);
    public static final String A0h = AbstractC04664a.A0h(11);
    public static final String A0g = AbstractC04664a.A0h(12);
    public static final String A0f = AbstractC04664a.A0h(13);
    public static final String A0v = AbstractC04664a.A0h(14);
    public static final String A0t = AbstractC04664a.A0h(15);
    public static final String A0u = AbstractC04664a.A0h(16);
    public static final String A0p = AbstractC04664a.A0h(17);
    public static final String A0a = AbstractC04664a.A0h(18);
    public static final String A0Z = AbstractC04664a.A0h(19);
    public static final String A0k = AbstractC04664a.A0h(20);
    public static final String A0X = AbstractC04664a.A0h(21);
    public static final String A0W = AbstractC04664a.A0h(22);
    public static final String A0r = AbstractC04664a.A0h(23);
    public static final String A0V = AbstractC04664a.A0h(24);
    public static final String A0q = AbstractC04664a.A0h(25);
    public static final String A0Y = AbstractC04664a.A0h(26);

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "D56211926, support language flag in video track")
    public static final String A0o = AbstractC04664a.A0h(27);

    @Deprecated
    public static final C1R<C2113oA> A0S = new C1R() { // from class: com.facebook.ads.redexgen.X.oB
        @Override // com.instagram.common.viewpoint.core.C1R
        public final C1S A6X(Bundle bundle) {
            return C2113oA.A0P(bundle);
        }
    };

    public C2113oA(AnonymousClass35 anonymousClass35) {
        this.A06 = anonymousClass35.A06;
        this.A05 = anonymousClass35.A05;
        this.A04 = anonymousClass35.A04;
        this.A03 = anonymousClass35.A03;
        this.A0A = anonymousClass35.A0A;
        this.A09 = anonymousClass35.A09;
        this.A08 = anonymousClass35.A08;
        this.A07 = anonymousClass35.A07;
        this.A0F = anonymousClass35.A0F;
        this.A0E = anonymousClass35.A0E;
        this.A0Q = anonymousClass35.A0Q;
        this.A0M = anonymousClass35.A0M;
        this.A0D = anonymousClass35.A0D;
        this.A0L = anonymousClass35.A0L;
        this.A0I = anonymousClass35.A0I;
        this.A0B = anonymousClass35.A0B;
        this.A02 = anonymousClass35.A02;
        this.A01 = anonymousClass35.A01;
        this.A0J = anonymousClass35.A0J;
        this.A0K = anonymousClass35.A0K;
        this.A0C = anonymousClass35.A0C;
        this.A00 = anonymousClass35.A00;
        this.A0P = anonymousClass35.A0P;
        this.A0O = anonymousClass35.A0O;
        this.A0N = anonymousClass35.A0N;
        this.A0G = AbstractC2025mj.A06(anonymousClass35.A0G);
        this.A0H = AbstractC0620Al.A07(anonymousClass35.A0H);
    }

    public static C2113oA A0P(Bundle bundle) {
        return new AnonymousClass35(bundle).A0p();
    }

    public static /* synthetic */ String A0e() {
        String str = A0Y;
        String[] strArr = A0R;
        if (strArr[1].length() != strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0R;
        strArr2[6] = "knLipfxz12XWfUIjxGYZpIOUAwMP4mj0";
        strArr2[7] = "eERvbEgJIjyuAQaNaNbhPf9gGFWMnkKa";
        return str;
    }

    public static /* synthetic */ String A0n() {
        String str = A0g;
        if (A0R[0].charAt(10) == 'w') {
            throw new RuntimeException();
        }
        String[] strArr = A0R;
        strArr[6] = "wTWYudsjFO0a7JfhFQ6nYLsn5LmgQ4J1";
        strArr[7] = "Faft3kMJbwhis25iNZP6UJCoypr5Nr4O";
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x014d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r8) {
        /*
            Method dump skipped, instruction units count: 389
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C2113oA.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((1 * 31) + this.A06) * 31) + this.A05) * 31) + this.A04) * 31) + this.A03) * 31) + this.A0A) * 31) + this.A09) * 31) + this.A08) * 31) + this.A07) * 31) + (this.A0Q ? 1 : 0)) * 31) + this.A0F) * 31) + this.A0E) * 31) + this.A0M.hashCode()) * 31) + this.A0D) * 31) + this.A0L.hashCode()) * 31) + this.A0I.hashCode()) * 31) + this.A0B) * 31) + this.A02) * 31) + this.A01) * 31) + this.A0J.hashCode()) * 31) + this.A0K.hashCode()) * 31) + this.A0C) * 31) + this.A00) * 31) + (this.A0P ? 1 : 0)) * 31) + (this.A0O ? 1 : 0)) * 31) + (this.A0N ? 1 : 0)) * 31) + this.A0G.hashCode()) * 31) + this.A0H.hashCode();
    }
}
