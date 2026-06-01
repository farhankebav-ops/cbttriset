package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class zzgpm<K, V> extends zzgoa<K, V> implements Serializable {
    final transient zzgph<K, ? extends zzgpa<V>> map;
    final transient int size;

    public zzgpm(zzgph zzgphVar, int i2) {
        this.map = zzgphVar;
        this.size = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzgqm
    public final int zzd() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgnz, com.google.android.gms.internal.ads.zzgqm
    @Deprecated
    public final boolean zze(Object obj, Object obj2) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgqm
    @Deprecated
    public final void zzf() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgnz
    public final Set zzh() {
        throw new AssertionError("unreachable");
    }

    @Override // com.google.android.gms.internal.ads.zzgnz
    public final /* synthetic */ Collection zzj() {
        return new zzgpl(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgnz
    public final Map zzl() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.android.gms.internal.ads.zzgnz
    public final boolean zzr(Object obj) {
        return obj != null && super.zzr(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgnz, com.google.android.gms.internal.ads.zzgqm
    public final /* bridge */ /* synthetic */ Collection zzt() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgnz, com.google.android.gms.internal.ads.zzgqm
    public /* synthetic */ Map zzu() {
        return this.map;
    }
}
