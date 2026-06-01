package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzcv extends zzcn implements Set {
    private transient zzcs zza;

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return zzds.zzb(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return zzds.zza(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zzd */
    public abstract zzdu iterator();

    public final zzcs zzf() {
        zzcs zzcsVar = this.zza;
        if (zzcsVar != null) {
            return zzcsVar;
        }
        zzcs zzcsVarZzg = zzg();
        this.zza = zzcsVarZzg;
        return zzcsVarZzg;
    }

    public zzcs zzg() {
        Object[] array = toArray();
        int i2 = zzcs.zzd;
        return zzcs.zzg(array, array.length);
    }
}
