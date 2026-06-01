package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzmk {
    private final zzs zza;
    private final SparseArray zzb;

    public zzmk(zzs zzsVar, SparseArray sparseArray) {
        this.zza = zzsVar;
        SparseArray sparseArray2 = new SparseArray(zzsVar.zzb());
        for (int i2 = 0; i2 < zzsVar.zzb(); i2++) {
            int iZzc = zzsVar.zzc(i2);
            zzmj zzmjVar = (zzmj) sparseArray.get(iZzc);
            zzmjVar.getClass();
            sparseArray2.append(iZzc, zzmjVar);
        }
        this.zzb = sparseArray2;
    }

    public final zzmj zza(int i2) {
        zzmj zzmjVar = (zzmj) this.zzb.get(i2);
        zzmjVar.getClass();
        return zzmjVar;
    }

    public final boolean zzb(int i2) {
        return this.zza.zza(i2);
    }

    public final int zzc() {
        return this.zza.zzb();
    }

    public final int zzd(int i2) {
        return this.zza.zzc(i2);
    }
}
