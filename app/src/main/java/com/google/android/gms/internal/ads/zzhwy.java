package com.google.android.gms.internal.ads;

import java.util.AbstractList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhwy extends AbstractList {
    private final zzhww zza;
    private final zzhwx zzb;

    public zzhwy(zzhww zzhwwVar, zzhwx zzhwxVar) {
        this.zza = zzhwwVar;
        this.zzb = zzhwxVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        return this.zzb.zzb(this.zza.zzf(i2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }
}
