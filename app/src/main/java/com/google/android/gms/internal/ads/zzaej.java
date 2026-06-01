package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaej extends zzadp {
    final /* synthetic */ zzaed zza;
    final /* synthetic */ zzaek zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaej(zzaek zzaekVar, zzaed zzaedVar, zzaed zzaedVar2) {
        super(zzaedVar);
        this.zza = zzaedVar2;
        Objects.requireNonNull(zzaekVar);
        this.zzb = zzaekVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadp, com.google.android.gms.internal.ads.zzaed
    public final zzaeb zzc(long j) {
        zzaeb zzaebVarZzc = this.zza.zzc(j);
        zzaee zzaeeVar = zzaebVarZzc.zza;
        long j3 = zzaeeVar.zzb;
        zzaek zzaekVar = this.zzb;
        zzaee zzaeeVar2 = new zzaee(j3, zzaekVar.zza() + zzaeeVar.zzc);
        zzaee zzaeeVar3 = zzaebVarZzc.zzb;
        return new zzaeb(zzaeeVar2, new zzaee(zzaeeVar3.zzb, zzaekVar.zza() + zzaeeVar3.zzc));
    }
}
