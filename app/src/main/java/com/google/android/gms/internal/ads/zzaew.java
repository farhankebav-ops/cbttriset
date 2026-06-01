package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaew implements zzaed {
    final /* synthetic */ zzaey zza;
    private final long zzb;

    public zzaew(zzaey zzaeyVar, long j) {
        Objects.requireNonNull(zzaeyVar);
        this.zza = zzaeyVar;
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final long zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final zzaeb zzc(long j) {
        zzaey zzaeyVar = this.zza;
        zzaeb zzaebVarZzg = zzaeyVar.zzg()[0].zzg(j);
        for (int i2 = 1; i2 < zzaeyVar.zzg().length; i2++) {
            zzaeb zzaebVarZzg2 = zzaeyVar.zzg()[i2].zzg(j);
            if (zzaebVarZzg2.zza.zzc < zzaebVarZzg.zza.zzc) {
                zzaebVarZzg = zzaebVarZzg2;
            }
        }
        return zzaebVarZzg;
    }
}
