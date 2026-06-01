package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzawp implements zzfsq {
    final /* synthetic */ zzfrs zza;

    public zzawp(zzfrs zzfrsVar) {
        this.zza = zzfrsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfsq
    public final void zza(int i2, long j) {
        this.zza.zzb(i2, System.currentTimeMillis() - j);
    }

    @Override // com.google.android.gms.internal.ads.zzfsq
    public final void zzb(int i2, long j, String str) {
        this.zza.zzf(i2, System.currentTimeMillis() - j, str);
    }
}
