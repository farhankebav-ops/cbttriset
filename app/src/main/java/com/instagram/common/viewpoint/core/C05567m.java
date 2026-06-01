package com.instagram.common.viewpoint.core;

import android.media.metrics.LogSessionId;
import java.util.Objects;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7m, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C05567m {
    public static final C05567m A03;
    public final String A00;
    public final C05557l A01;
    public final Object A02;

    static {
        C05567m c05567m;
        if (AbstractC04664a.A02 < 31) {
            c05567m = new C05567m("");
        } else {
            c05567m = new C05567m(C05557l.A01, "");
        }
        A03 = c05567m;
    }

    public C05567m(C05557l c05557l, String str) {
        this.A01 = c05557l;
        this.A00 = str;
        this.A02 = new Object();
    }

    public C05567m(String str) {
        C3M.A08(AbstractC04664a.A02 < 31);
        this.A00 = str;
        this.A01 = null;
        this.A02 = new Object();
    }

    public final LogSessionId A00() {
        return ((C05557l) C3M.A01(this.A01)).A00;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C05567m)) {
            return false;
        }
        C05567m c05567m = (C05567m) obj;
        if (Objects.equals(this.A00, c05567m.A00) && Objects.equals(this.A01, c05567m.A01) && Objects.equals(this.A02, c05567m.A02)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.A00, this.A01, this.A02);
    }
}
