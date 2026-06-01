package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzwq {
    private int zza;
    private final SparseArray zzb;
    private final zzdg zzc;

    public zzwq() {
        this(zzwp.zza);
    }

    public final Object zza(int i2) {
        SparseArray sparseArray;
        if (this.zza == -1) {
            this.zza = 0;
        }
        while (true) {
            int i8 = this.zza;
            if (i8 <= 0 || i2 >= this.zzb.keyAt(i8)) {
                break;
            }
            this.zza--;
        }
        while (true) {
            int i9 = this.zza;
            sparseArray = this.zzb;
            if (i9 >= sparseArray.size() - 1 || i2 < sparseArray.keyAt(this.zza + 1)) {
                break;
            }
            this.zza++;
        }
        return sparseArray.valueAt(this.zza);
    }

    public final void zzb(int i2, Object obj) {
        if (this.zza == -1) {
            zzgmd.zzh(this.zzb.size() == 0);
            this.zza = 0;
        }
        SparseArray sparseArray = this.zzb;
        if (sparseArray.size() > 0) {
            int iKeyAt = sparseArray.keyAt(sparseArray.size() - 1);
            zzgmd.zza(i2 >= iKeyAt);
            if (iKeyAt == i2) {
                this.zzc.zza(sparseArray.valueAt(sparseArray.size() - 1));
            }
        }
        sparseArray.append(i2, obj);
    }

    public final Object zzc() {
        return this.zzb.valueAt(r0.size() - 1);
    }

    public final void zzd(int i2) {
        int i8 = 0;
        while (true) {
            SparseArray sparseArray = this.zzb;
            if (i8 >= sparseArray.size() - 1) {
                return;
            }
            int i9 = i8 + 1;
            if (i2 < sparseArray.keyAt(i9)) {
                return;
            }
            this.zzc.zza(sparseArray.valueAt(i8));
            sparseArray.removeAt(i8);
            int i10 = this.zza;
            if (i10 > 0) {
                this.zza = i10 - 1;
            }
            i8 = i9;
        }
    }

    public final void zze() {
        int i2 = 0;
        while (true) {
            SparseArray sparseArray = this.zzb;
            if (i2 >= sparseArray.size()) {
                this.zza = -1;
                sparseArray.clear();
                return;
            } else {
                this.zzc.zza(sparseArray.valueAt(i2));
                i2++;
            }
        }
    }

    public final boolean zzf() {
        return this.zzb.size() == 0;
    }

    public zzwq(zzdg zzdgVar) {
        this.zzb = new SparseArray();
        this.zzc = zzdgVar;
        this.zza = -1;
    }
}
