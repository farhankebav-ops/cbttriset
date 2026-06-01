package com.instagram.common.viewpoint.core;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.gc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1675gc<K, V> extends OY<K, V> {
    public final /* synthetic */ C1674gb A00;

    public C1675gc(C1674gb c1674gb) {
        this.A00 = c1674gb;
    }

    @Override // com.instagram.common.viewpoint.core.OY
    public final int A04() {
        return ((C0968Ob) this.A00).A00;
    }

    @Override // com.instagram.common.viewpoint.core.OY
    public final int A05(Object obj) {
        return this.A00.A08(obj);
    }

    @Override // com.instagram.common.viewpoint.core.OY
    public final int A06(Object obj) {
        return this.A00.A07(obj);
    }

    @Override // com.instagram.common.viewpoint.core.OY
    public final Map<K, V> A07() {
        return this.A00;
    }

    @Override // com.instagram.common.viewpoint.core.OY
    public final Object A0B(int i2, int i8) {
        return this.A00.A02[(i2 << 1) + i8];
    }

    @Override // com.instagram.common.viewpoint.core.OY
    public final V A0C(int i2, V value) {
        return this.A00.A0C(i2, value);
    }

    @Override // com.instagram.common.viewpoint.core.OY
    public final void A0D() {
        this.A00.clear();
    }

    @Override // com.instagram.common.viewpoint.core.OY
    public final void A0E(int i2) {
        this.A00.A0A(i2);
    }

    @Override // com.instagram.common.viewpoint.core.OY
    public final void A0F(K key, V value) {
        this.A00.put(key, value);
    }
}
