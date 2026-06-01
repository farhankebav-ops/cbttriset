package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzkm {
    private long zza;
    private float zzb;
    private long zzc;

    public zzkm() {
        this.zza = -9223372036854775807L;
        this.zzb = -3.4028235E38f;
        this.zzc = -9223372036854775807L;
    }

    public final zzkm zza(long j) {
        this.zza = j;
        return this;
    }

    public final zzkm zzb(float f4) {
        boolean z2 = true;
        if (f4 <= 0.0f && f4 != -3.4028235E38f) {
            z2 = false;
        }
        zzgmd.zza(z2);
        this.zzb = f4;
        return this;
    }

    public final zzkm zzc(long j) {
        boolean z2 = true;
        if (j < 0) {
            if (j == -9223372036854775807L) {
                j = -9223372036854775807L;
            } else {
                z2 = false;
            }
        }
        zzgmd.zza(z2);
        this.zzc = j;
        return this;
    }

    public final zzkn zzd() {
        return new zzkn(this, null);
    }

    public final /* synthetic */ long zze() {
        return this.zza;
    }

    public final /* synthetic */ float zzf() {
        return this.zzb;
    }

    public final /* synthetic */ long zzg() {
        return this.zzc;
    }

    public /* synthetic */ zzkm(zzkn zzknVar, byte[] bArr) {
        this.zza = zzknVar.zza;
        this.zzb = zzknVar.zzb;
        this.zzc = zzknVar.zzc;
    }
}
