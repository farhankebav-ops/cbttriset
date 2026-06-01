package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzct {
    private static final String zzd;
    private static final String zze;
    private static final String zzf;
    public final int zza;
    public final int zzb;
    public final int zzc;

    static {
        String str = zzep.zza;
        zzd = Integer.toString(0, 36);
        zze = Integer.toString(1, 36);
        zzf = Integer.toString(2, 36);
    }

    public zzct(int i2, int i8, int i9) {
        this.zza = i2;
        this.zzb = i8;
        this.zzc = i9;
    }

    public final Bundle zza() {
        Bundle bundle = new Bundle();
        bundle.putInt(zzd, this.zza);
        bundle.putInt(zze, this.zzb);
        bundle.putInt(zzf, this.zzc);
        return bundle;
    }
}
