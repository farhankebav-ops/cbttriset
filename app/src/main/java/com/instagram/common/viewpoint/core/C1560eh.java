package com.instagram.common.viewpoint.core;

import java.util.Set;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1560eh {
    public C1564el A00;
    public Set<String> A01;
    public Set<String> A02;
    public boolean A03;
    public boolean A04 = true;

    public final C1560eh A00(C1564el c1564el) {
        this.A00 = c1564el;
        return this;
    }

    public final C1560eh A01(Set<String> pinnedCertificates) {
        this.A01 = pinnedCertificates;
        return this;
    }

    public final C1560eh A02(Set<String> pinnedPublicKeys) {
        this.A02 = pinnedPublicKeys;
        return this;
    }

    public final C1560eh A03(boolean z2) {
        this.A04 = z2;
        return this;
    }

    public final C1560eh A04(boolean z2) {
        this.A03 = z2;
        return this;
    }

    public final C1561ei A05() {
        return new C1561ei(this.A00, this.A04, this.A02, this.A01, this.A03);
    }
}
