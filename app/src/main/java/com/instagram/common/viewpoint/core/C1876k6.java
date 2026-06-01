package com.instagram.common.viewpoint.core;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.k6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1876k6 implements J7 {
    public final C0849Jk A00;
    public final Map<String, C0856Jr> A01;
    public final Map<String, String> A02;
    public final Map<String, C0850Jl> A03;
    public final long[] A04;

    public C1876k6(C0849Jk c0849Jk, Map<String, C0856Jr> map, Map<String, C0850Jl> map2, Map<String, String> imageMap) {
        this.A00 = c0849Jk;
        this.A03 = map2;
        this.A02 = imageMap;
        this.A01 = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.A04 = c0849Jk.A0G();
    }

    @Override // com.instagram.common.viewpoint.core.J7
    public final List<C2105o2> A7P(long j) {
        return this.A00.A0E(j, this.A01, this.A03, this.A02);
    }

    @Override // com.instagram.common.viewpoint.core.J7
    public final long A7v(int i2) {
        return this.A04[i2];
    }

    @Override // com.instagram.common.viewpoint.core.J7
    public final int A7w() {
        return this.A04.length;
    }

    @Override // com.instagram.common.viewpoint.core.J7
    public final int A8S(long j) {
        int iA0K = AbstractC04664a.A0K(this.A04, j, false, false);
        int index = this.A04.length;
        if (iA0K < index) {
            return iA0K;
        }
        return -1;
    }
}
