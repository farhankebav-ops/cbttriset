package com.instagram.common.viewpoint.core;

import android.os.Bundle;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9s, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C06019s extends AbstractC2132oU {
    public final boolean A00;
    public final boolean A01;
    public static final String A04 = AbstractC04664a.A0h(1);
    public static final String A03 = AbstractC04664a.A0h(2);
    public static final C1R<C06019s> A02 = new C1R() { // from class: com.facebook.ads.redexgen.X.op
        @Override // com.instagram.common.viewpoint.core.C1R
        public final C1S A6X(Bundle bundle) {
            return C06019s.A00(bundle);
        }
    };

    public C06019s() {
        this.A01 = false;
        this.A00 = false;
    }

    public C06019s(boolean z2) {
        this.A01 = true;
        this.A00 = z2;
    }

    public static C06019s A00(Bundle bundle) {
        boolean isRated = bundle.getInt(AbstractC2132oU.A02, -1) == 0;
        C3M.A07(isRated);
        boolean isRated2 = bundle.getBoolean(A04, false);
        if (isRated2) {
            return new C06019s(bundle.getBoolean(A03, false));
        }
        return new C06019s();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C06019s)) {
            return false;
        }
        C06019s c06019s = (C06019s) obj;
        return this.A00 == c06019s.A00 && this.A01 == c06019s.A01;
    }

    public final int hashCode() {
        return BX.A00(Boolean.valueOf(this.A01), Boolean.valueOf(this.A00));
    }
}
