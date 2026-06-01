package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaaa {
    final /* synthetic */ zzaab zza;
    private zzv zzb;

    public /* synthetic */ zzaaa(zzaab zzaabVar, byte[] bArr) {
        Objects.requireNonNull(zzaabVar);
        this.zza = zzaabVar;
    }

    public final void zza(final zzbv zzbvVar) {
        zzt zztVar = new zzt();
        zztVar.zzt(zzbvVar.zzb);
        zztVar.zzu(zzbvVar.zzc);
        zztVar.zzm("video/raw");
        this.zzb = zztVar.zzM();
        this.zza.zzC().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzz
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zza.zzB().zzd(zzbvVar);
            }
        });
    }

    public final void zzb(long j, long j3, boolean z2) {
        if (z2) {
            zzaab zzaabVar = this.zza;
            if (zzaabVar.zzA() != null) {
                zzaabVar.zzC().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzx
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zza.zzB().zzb();
                    }
                });
            }
        }
        zzv zzvVarZzM = this.zzb;
        if (zzvVarZzM == null) {
            zzvVarZzM = new zzt().zzM();
        }
        zzv zzvVar = zzvVarZzM;
        zzaab zzaabVar2 = this.zza;
        zzaabVar2.zzD().zzcS(j3, j, zzvVar, null);
        ((zzabv) zzaabVar2.zzz().remove()).zza(j);
    }
}
