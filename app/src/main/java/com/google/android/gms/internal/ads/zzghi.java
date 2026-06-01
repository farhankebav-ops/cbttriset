package com.google.android.gms.internal.ads;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzghi implements zzggu {
    private final zzfyz zza;
    private final zzfyz zzb;
    private final zzifb zzc;
    private final zzgjd zzd;

    public zzghi(zzfyz zzfyzVar, zzfyz zzfyzVar2, zzifb zzifbVar, zzgjd zzgjdVar) {
        this.zza = zzfyzVar;
        this.zzb = zzfyzVar2;
        this.zzc = zzifbVar;
        this.zzd = zzgjdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzggu
    public final j2.q zza() {
        j2.q qVarZzb = this.zza.zzb();
        this.zzd.zze(20302, qVarZzb);
        return qVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzggu
    public final j2.q zzb(zzgaa zzgaaVar) {
        j2.q qVarZzc = this.zza.zzc(zzgaaVar);
        this.zzd.zze(20303, qVarZzc);
        return qVarZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzggu
    public final j2.q zzc() {
        j2.q qVarZzb = this.zzb.zzb();
        this.zzd.zze(20304, qVarZzb);
        return qVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzggu
    public final j2.q zzd(byte[] bArr) {
        j2.q qVarZzc = this.zzb.zzc(bArr);
        this.zzd.zze(20305, qVarZzc);
        return qVarZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzggu
    public final File zze() {
        return this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzggu
    public final j2.q zzf(byte[] bArr) {
        j2.q qVarZzc = ((zzfyz) this.zzc.zzb()).zzc(bArr);
        this.zzd.zze(20307, qVarZzc);
        return qVarZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzggu
    public final File zzg() {
        return ((zzfyz) this.zzc.zzb()).zza();
    }
}
