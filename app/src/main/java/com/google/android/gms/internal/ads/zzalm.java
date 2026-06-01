package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzalm implements zzakd {
    private final zzalf zza;
    private final long[] zzb;
    private final Map zzc;
    private final Map zzd;
    private final Map zze;

    public zzalm(zzalf zzalfVar, Map map, Map map2, Map map3) {
        this.zza = zzalfVar;
        this.zzd = map2;
        this.zze = map3;
        this.zzc = Collections.unmodifiableMap(map);
        this.zzb = zzalfVar.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzakd
    public final int zza() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.ads.zzakd
    public final long zzb(int i2) {
        return this.zzb[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzakd
    public final List zzc(long j) {
        return this.zza.zzh(j, this.zzc, this.zzd, this.zze);
    }
}
