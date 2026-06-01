package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcvq implements zzdej, zzdac {
    private final Clock zza;
    private final zzcvs zzb;
    private final zzfgn zzc;
    private final String zzd;

    public zzcvq(Clock clock, zzcvs zzcvsVar, zzfgn zzfgnVar, String str) {
        this.zza = clock;
        this.zzb = zzcvsVar;
        this.zzc = zzfgnVar;
        this.zzd = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdej
    public final void zza() {
        this.zzb.zzd(this.zzd, this.zza.elapsedRealtime());
    }

    @Override // com.google.android.gms.internal.ads.zzdac
    public final void zzg() {
        Clock clock = this.zza;
        this.zzb.zze(this.zzc.zzg, this.zzd, clock.elapsedRealtime());
    }
}
