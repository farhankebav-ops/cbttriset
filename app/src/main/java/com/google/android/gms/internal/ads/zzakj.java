package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzakj implements zzadd {
    private final zzadd zzb;
    private final zzakg zzc;
    private final SparseArray zzd = new SparseArray();
    private boolean zze;

    public zzakj(zzadd zzaddVar, zzakg zzakgVar) {
        this.zzb = zzaddVar;
        this.zzc = zzakgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadd
    public final zzaem zzu(int i2, int i8) {
        if (i8 != 3) {
            this.zze = true;
            return this.zzb.zzu(i2, i8);
        }
        SparseArray sparseArray = this.zzd;
        zzakl zzaklVar = (zzakl) sparseArray.get(i2);
        if (zzaklVar != null) {
            return zzaklVar;
        }
        zzakl zzaklVar2 = new zzakl(this.zzb.zzu(i2, 3), this.zzc);
        sparseArray.put(i2, zzaklVar2);
        return zzaklVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzadd
    public final void zzv() {
        this.zzb.zzv();
        if (!this.zze) {
            return;
        }
        int i2 = 0;
        while (true) {
            SparseArray sparseArray = this.zzd;
            if (i2 >= sparseArray.size()) {
                return;
            }
            ((zzakl) sparseArray.valueAt(i2)).zza(true);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadd
    public final void zzw(zzaed zzaedVar) {
        this.zzb.zzw(zzaedVar);
    }
}
