package com.instagram.common.viewpoint.core;

import android.os.Bundle;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9o, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C05979o extends AbstractC2132oU {
    public final boolean A00;
    public final boolean A01;
    public static final String A04 = AbstractC04664a.A0h(1);
    public static final String A03 = AbstractC04664a.A0h(2);
    public static final C1R<C05979o> A02 = new C1R() { // from class: com.facebook.ads.redexgen.X.oS
        @Override // com.instagram.common.viewpoint.core.C1R
        public final C1S A6X(Bundle bundle) {
            return C05979o.A00(bundle);
        }
    };

    public C05979o() {
        this.A01 = false;
        this.A00 = false;
    }

    public C05979o(boolean z2) {
        this.A01 = true;
        this.A00 = z2;
    }

    public static C05979o A00(Bundle bundle) {
        boolean rated = bundle.getInt(AbstractC2132oU.A02, -1) == 3;
        C3M.A07(rated);
        boolean rated2 = bundle.getBoolean(A04, false);
        if (rated2) {
            return new C05979o(bundle.getBoolean(A03, false));
        }
        return new C05979o();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C05979o)) {
            return false;
        }
        C05979o c05979o = (C05979o) obj;
        return this.A00 == c05979o.A00 && this.A01 == c05979o.A01;
    }

    public final int hashCode() {
        return BX.A00(Boolean.valueOf(this.A01), Boolean.valueOf(this.A00));
    }
}
