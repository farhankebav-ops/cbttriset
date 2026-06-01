package com.google.android.gms.ads.nonagon.signalgeneration;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.query.QueryInfo;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzq {

    @Nullable
    private final QueryInfo zza;
    private final String zzb;
    private final long zzc;
    private final int zzd;
    private final AtomicBoolean zze = new AtomicBoolean(false);

    public zzq(@Nullable QueryInfo queryInfo, String str, long j, int i2) {
        this.zza = queryInfo;
        this.zzb = str;
        this.zzc = j;
        this.zzd = i2;
    }

    @Nullable
    public final QueryInfo zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final boolean zzc() {
        return this.zzc <= com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis();
    }

    public final int zzd() {
        return this.zzd;
    }

    public final boolean zze() {
        return this.zze.get();
    }

    public final void zzf() {
        this.zze.set(true);
    }
}
