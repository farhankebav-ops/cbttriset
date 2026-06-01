package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfje {
    private final zzfiw zza;
    private final j2.q zzb;
    private boolean zzc = false;
    private boolean zzd = false;

    public zzfje(final zzfic zzficVar, final zzfiv zzfivVar, final zzfiw zzfiwVar) {
        this.zza = zzfiwVar;
        this.zzb = zzgui.zzh(zzgui.zzj(zzfivVar.zza(zzfiwVar), new zzgtq() { // from class: com.google.android.gms.internal.ads.zzfjd
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ j2.q zza(Object obj) {
                return this.zza.zzc(zzfivVar, zzficVar, zzfiwVar, (zzfil) obj);
            }
        }, zzfiwVar.zza()), Exception.class, new zzgtq() { // from class: com.google.android.gms.internal.ads.zzfjb
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ j2.q zza(Object obj) {
                return this.zza.zzd(zzfivVar, (Exception) obj);
            }
        }, zzfiwVar.zza());
    }

    public final synchronized void zza(zzguf zzgufVar) {
        zzfiw zzfiwVar = this.zza;
        zzgui.zzr(zzgui.zzj(this.zzb, zzfjc.zza, zzfiwVar.zza()), zzgufVar, zzfiwVar.zza());
    }

    public final synchronized j2.q zzb(zzfiw zzfiwVar) {
        if (!this.zzd && !this.zzc) {
            zzfiw zzfiwVar2 = this.zza;
            if (zzfiwVar2.zzb() != null && zzfiwVar.zzb() != null && zzfiwVar2.zzb().equals(zzfiwVar.zzb())) {
                this.zzc = true;
                return this.zzb;
            }
        }
        return null;
    }

    public final /* synthetic */ j2.q zzc(zzfiv zzfivVar, zzfic zzficVar, zzfiw zzfiwVar, zzfil zzfilVar) {
        synchronized (this) {
            try {
                this.zzd = true;
                zzfivVar.zzb(zzfilVar);
                if (this.zzc) {
                    return zzgui.zza(new zzfiu(zzfilVar, zzfiwVar));
                }
                zzficVar.zzb(zzfiwVar.zzb(), zzfilVar);
                return zzgui.zza(null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ j2.q zzd(zzfiv zzfivVar, Exception exc) {
        synchronized (this) {
            this.zzd = true;
            throw exc;
        }
    }
}
