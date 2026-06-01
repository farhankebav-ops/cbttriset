package com.google.android.gms.internal.ads;

import com.unity3d.services.UnityAdsConstants;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzapi {
    private int zza = UnityAdsConstants.RequestPolicy.RETRY_MAX_INTERVAL;
    private int zzb;

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final void zzc(zzaqd zzaqdVar) throws zzaqd {
        int i2 = this.zzb + 1;
        this.zzb = i2;
        int i8 = this.zza;
        this.zza = i8 + i8;
        if (i2 > 1) {
            throw zzaqdVar;
        }
    }
}
