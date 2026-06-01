package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdqw extends zzdqh implements zzdgv {
    private zzdgv zza;

    @Override // com.google.android.gms.internal.ads.zzdgv
    public final synchronized void zzdV() {
        zzdgv zzdgvVar = this.zza;
        if (zzdgvVar != null) {
            zzdgvVar.zzdV();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdgv
    public final synchronized void zzdz() {
        zzdgv zzdgvVar = this.zza;
        if (zzdgvVar != null) {
            zzdgvVar.zzdz();
        }
    }

    public final synchronized void zzn(com.google.android.gms.ads.internal.client.zza zzaVar, zzbkn zzbknVar, com.google.android.gms.ads.internal.overlay.zzr zzrVar, zzbkp zzbkpVar, com.google.android.gms.ads.internal.overlay.zzad zzadVar, zzdgv zzdgvVar) throws Throwable {
        try {
            try {
                zzm(zzaVar, zzbknVar, zzrVar, zzbkpVar, zzadVar);
                this.zza = zzdgvVar;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }
}
