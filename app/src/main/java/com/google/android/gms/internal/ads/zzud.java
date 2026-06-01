package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzud implements zzwm {
    private final zzwm zza;
    private final zzgpe zzb;

    public zzud(zzwm zzwmVar, List list) {
        this.zza = zzwmVar;
        this.zzb = zzgpe.zzq(list);
    }

    public final zzgpe zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final void zzg(long j) {
        this.zza.zzg(j);
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final long zzi() {
        return this.zza.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final long zzl() {
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final boolean zzm(zzkn zzknVar) {
        return this.zza.zzm(zzknVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final boolean zzn() {
        return this.zza.zzn();
    }
}
