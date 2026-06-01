package com.instagram.common.viewpoint.core;

import java.util.Collection;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ab, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0610Ab extends AbstractC2118oF<Object> {
    public final /* synthetic */ int A00;

    public C0610Ab(final int val$expectedKeys) {
        this.A00 = val$expectedKeys;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2118oF
    public final <K, V> Map<K, Collection<V>> A04() {
        return AbstractC2135oY.A00(this.A00);
    }
}
