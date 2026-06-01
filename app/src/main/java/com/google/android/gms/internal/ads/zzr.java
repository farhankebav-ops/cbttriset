package com.google.android.gms.internal.ads;

import android.util.SparseBooleanArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzr {
    private final SparseBooleanArray zza = new SparseBooleanArray();
    private boolean zzb;

    public final zzr zza(int i2) {
        zzgmd.zzh(!this.zzb);
        this.zza.append(i2, true);
        return this;
    }

    public final zzs zzb() {
        zzgmd.zzh(!this.zzb);
        this.zzb = true;
        return new zzs(this.zza, null);
    }
}
