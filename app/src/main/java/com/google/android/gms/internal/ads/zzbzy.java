package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbzy {
    private final Clock zza;
    private final zzbzw zzb;

    public zzbzy(Clock clock, zzbzw zzbzwVar) {
        this.zza = clock;
        this.zzb = zzbzwVar;
    }

    public static zzbzy zza(Context context) {
        return zzcag.zzb(context).zza();
    }

    public final void zzb() {
        this.zzb.zza(-1, this.zza.currentTimeMillis());
    }

    public final void zzc(com.google.android.gms.ads.internal.client.zzfv zzfvVar) {
        this.zzb.zza(-1, this.zza.currentTimeMillis());
    }

    public final void zzd(int i2, long j) {
        this.zzb.zza(i2, j);
    }
}
