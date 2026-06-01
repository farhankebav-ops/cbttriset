package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzvv implements zzwk {
    final /* synthetic */ zzvy zza;
    private final int zzb;

    public zzvv(zzvy zzvyVar, int i2) {
        Objects.requireNonNull(zzvyVar);
        this.zza = zzvyVar;
        this.zzb = i2;
    }

    public final /* synthetic */ int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final boolean zzb() {
        return this.zza.zzp(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void zzc() throws IOException {
        this.zza.zzq(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final int zzd(zzkj zzkjVar, zzhh zzhhVar, int i2) {
        return this.zza.zzs(this.zzb, zzkjVar, zzhhVar, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final int zze(long j) {
        return this.zza.zzt(this.zzb, j);
    }
}
