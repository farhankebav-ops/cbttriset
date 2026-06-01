package com.instagram.common.viewpoint.core;

import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class YI implements ST {
    public final SQ A00;

    public YI(SQ sq) {
        this.A00 = sq;
    }

    @Override // com.instagram.common.viewpoint.core.ST
    public final Map<String, String> A5S() {
        return TQ.A01(this.A00);
    }

    @Override // com.instagram.common.viewpoint.core.ST
    public final Map<String, String> A6o() {
        return T5.A02();
    }

    @Override // com.instagram.common.viewpoint.core.ST
    public final String A8D() {
        return T5.A00();
    }

    @Override // com.instagram.common.viewpoint.core.ST
    public final String A8F() {
        return AbstractC1061Rr.A00().A03();
    }

    @Override // com.instagram.common.viewpoint.core.ST
    public final boolean AAL() {
        return WH.A00().A03();
    }
}
