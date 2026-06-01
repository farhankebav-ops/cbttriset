package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class zzgpr<K, V> extends zzgpm<K, V> implements zzgqm<K, V> {
    private final transient zzgpo<V> emptySet;
    private transient zzgpo zza;

    public zzgpr(zzgph zzgphVar, int i2, Comparator comparator) {
        super(zzgphVar, i2);
        this.emptySet = zzgrf.zza;
    }

    public final zzgpo zza() {
        zzgpo zzgpoVar = this.zza;
        if (zzgpoVar != null) {
            return zzgpoVar;
        }
        zzgpq zzgpqVar = new zzgpq(this);
        this.zza = zzgpqVar;
        return zzgpqVar;
    }
}
