package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzqr {
    private final zzcg[] zza;
    private final zzrn zzb;
    private final zzcj zzc;

    public zzqr(zzcg... zzcgVarArr) {
        zzrn zzrnVar = new zzrn();
        zzcj zzcjVar = new zzcj();
        zzcg[] zzcgVarArr2 = {zzrnVar, zzcjVar};
        this.zza = zzcgVarArr2;
        System.arraycopy(zzcgVarArr, 0, zzcgVarArr2, 0, 0);
        this.zzb = zzrnVar;
        this.zzc = zzcjVar;
    }

    public final zzcg[] zza() {
        return this.zza;
    }

    public final zzav zzb(zzav zzavVar) {
        zzcj zzcjVar = this.zzc;
        zzcjVar.zzk(zzavVar.zzb);
        zzcjVar.zzl(zzavVar.zzc);
        return zzavVar;
    }

    public final boolean zzc(boolean z2) {
        this.zzb.zzq(z2);
        return z2;
    }

    public final long zzd(long j) {
        zzcj zzcjVar = this.zzc;
        return zzcjVar.zzc() ? zzcjVar.zzm(j) : j;
    }

    public final long zze() {
        return this.zzb.zzr();
    }
}
