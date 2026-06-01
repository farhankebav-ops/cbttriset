package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbqy {
    private final zzbqb zza;
    private j2.q zzb;

    public zzbqy(zzbqb zzbqbVar) {
        this.zza = zzbqbVar;
    }

    private final void zzd() {
        if (this.zzb == null) {
            final zzcca zzccaVar = new zzcca();
            this.zzb = zzccaVar;
            this.zza.zzb(null).zze(new zzcce() { // from class: com.google.android.gms.internal.ads.zzbqx
                @Override // com.google.android.gms.internal.ads.zzcce
                public final /* synthetic */ void zza(Object obj) {
                    zzccaVar.zzc((zzbqc) obj);
                }
            }, new zzccc() { // from class: com.google.android.gms.internal.ads.zzbqu
                @Override // com.google.android.gms.internal.ads.zzccc
                public final /* synthetic */ void zza() {
                    zzccaVar.zzd(new zzbqe("Cannot get Javascript Engine"));
                }
            });
        }
    }

    public final zzbrb zza(String str, zzbqi zzbqiVar, zzbqh zzbqhVar) {
        zzd();
        return new zzbrb(this.zzb, "google.afma.activeView.handleUpdate", zzbqiVar, zzbqhVar);
    }

    public final void zzb(final String str, final zzblx zzblxVar) {
        zzd();
        this.zzb = zzgui.zzj(this.zzb, new zzgtq() { // from class: com.google.android.gms.internal.ads.zzbqv
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ j2.q zza(Object obj) {
                zzbqc zzbqcVar = (zzbqc) obj;
                zzbqcVar.zzm(str, zzblxVar);
                return zzgui.zza(zzbqcVar);
            }
        }, zzcbv.zzg);
    }

    public final void zzc(final String str, final zzblx zzblxVar) {
        this.zzb = zzgui.zzk(this.zzb, new zzglu() { // from class: com.google.android.gms.internal.ads.zzbqw
            @Override // com.google.android.gms.internal.ads.zzglu
            public final /* synthetic */ Object apply(Object obj) {
                zzbqc zzbqcVar = (zzbqc) obj;
                zzbqcVar.zzn(str, zzblxVar);
                return zzbqcVar;
            }
        }, zzcbv.zzg);
    }
}
