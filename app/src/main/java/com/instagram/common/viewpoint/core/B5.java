package com.instagram.common.viewpoint.core;

import com.google.common.collect.ParametricNullness;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class B5<K, V> extends AbstractC1889kJ<K, V> {
    public int A00;

    @ParametricNullness
    public final K A01;
    public final /* synthetic */ C1976lv A02;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.instagram.common.viewpoint.core.AbstractC1889kJ, java.util.Map.Entry
    @ParametricNullness
    public final V getValue() {
        Map<K, V> mapA0h = this.A02.A0h();
        if (mapA0h != null) {
            return (V) AbstractC2128oQ.A01(mapA0h.get(this.A01));
        }
        A00();
        return this.A00 == -1 ? (V) AbstractC2128oQ.A00() : (V) this.A02.A0F(this.A00);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.instagram.common.viewpoint.core.AbstractC1889kJ, java.util.Map.Entry
    @ParametricNullness
    public final V setValue(@ParametricNullness V v2) {
        Map<K, V> mapA0h = this.A02.A0h();
        if (mapA0h != null) {
            return (V) AbstractC2128oQ.A01(mapA0h.put(this.A01, v2));
        }
        A00();
        if (this.A00 == -1) {
            this.A02.put(this.A01, v2);
            return (V) AbstractC2128oQ.A00();
        }
        V v7 = (V) this.A02.A0F(this.A00);
        this.A02.A0R(this.A00, v2);
        return v7;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.B5 != com.google.common.collect.CompactHashMap<K, V>$MapEntry */
    public B5(C1976lv c1976lv, int i2) {
        this.A02 = c1976lv;
        this.A01 = (K) c1976lv.A0E(i2);
        this.A00 = i2;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.B5 != com.google.common.collect.CompactHashMap<K, V>$MapEntry */
    private void A00() {
        if (this.A00 != -1 && this.A00 < this.A02.size() && BX.A01(this.A01, this.A02.A0E(this.A00))) {
            return;
        }
        this.A00 = this.A02.A07(this.A01);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.B5 != com.google.common.collect.CompactHashMap<K, V>$MapEntry */
    @Override // com.instagram.common.viewpoint.core.AbstractC1889kJ, java.util.Map.Entry
    @ParametricNullness
    public final K getKey() {
        return this.A01;
    }
}
