package com.instagram.common.viewpoint.core;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: Add missing generic type declarations: [K0] */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class AZ<K0> extends AbstractC2118oF<K0> {
    public final /* synthetic */ Comparator A00;

    public AZ(final Comparator val$comparator) {
        this.A00 = val$comparator;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2118oF
    public final <K extends K0, V> Map<K, Collection<V>> A04() {
        return new TreeMap(this.A00);
    }
}
