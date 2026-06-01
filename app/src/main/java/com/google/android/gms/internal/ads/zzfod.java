package com.google.android.gms.internal.ads;

import androidx.work.WorkRequest;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfod {
    private final Object zza;
    private final long zzb;
    private final Clock zzc;
    private final long zzd = ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzI)).longValue() * 1000;

    public zzfod(Object obj, Clock clock) {
        this.zza = obj;
        this.zzc = clock;
        this.zzb = clock.currentTimeMillis();
    }

    public final Object zza() {
        return this.zza;
    }

    public final boolean zzb() {
        return this.zzc.currentTimeMillis() >= this.zzb + this.zzd;
    }

    public final long zzc() {
        return (this.zzd + Math.min(Math.max(((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzC)).longValue(), -900000L), WorkRequest.MIN_BACKOFF_MILLIS)) - (this.zzc.currentTimeMillis() - this.zzb);
    }

    public final long zzd() {
        return this.zzb;
    }
}
