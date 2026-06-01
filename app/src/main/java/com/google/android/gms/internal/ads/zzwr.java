package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzwr implements zzwk {
    private final zzwk zza;
    private final long zzb;

    public zzwr(zzwk zzwkVar, long j) {
        this.zza = zzwkVar;
        this.zzb = j;
    }

    public final zzwk zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final boolean zzb() {
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void zzc() throws IOException {
        this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final int zzd(zzkj zzkjVar, zzhh zzhhVar, int i2) {
        int iZzd = this.zza.zzd(zzkjVar, zzhhVar, i2);
        if (iZzd != -4) {
            return iZzd;
        }
        zzhhVar.zze += this.zzb;
        return -4;
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final int zze(long j) {
        return this.zza.zze(j - this.zzb);
    }
}
