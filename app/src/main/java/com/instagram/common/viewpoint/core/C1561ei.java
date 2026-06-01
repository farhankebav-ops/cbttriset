package com.instagram.common.viewpoint.core;

import java.util.Set;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ei, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1561ei {
    public C1564el A00;
    public Set<String> A01;
    public Set<String> A02;
    public boolean A03;
    public boolean A04;

    public C1561ei(C1564el c1564el, boolean z2, Set<String> pinnedPublicKeys, Set<String> pinnedCertificates, boolean z7) {
        this.A00 = c1564el;
        this.A04 = z2;
        this.A02 = pinnedPublicKeys;
        this.A01 = pinnedCertificates;
        this.A03 = z7;
    }

    public final C1564el A00() {
        return this.A00;
    }

    public final Set<String> A01() {
        return this.A01;
    }

    public final Set<String> A02() {
        return this.A02;
    }

    public final boolean A03() {
        return this.A04;
    }

    public final boolean A04() {
        return this.A03;
    }
}
