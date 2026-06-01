package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzann {
    private final zzamq zza;
    private final zzem zzb;
    private final zzef zzc = new zzef(new byte[64], 64);
    private boolean zzd;
    private boolean zze;
    private boolean zzf;

    public zzann(zzamq zzamqVar, zzem zzemVar) {
        this.zza = zzamqVar;
        this.zzb = zzemVar;
    }

    public final void zza() {
        this.zzf = false;
        this.zza.zza();
    }

    public final void zzb(zzeg zzegVar) throws zzat {
        long jZze;
        char c7;
        zzef zzefVar = this.zzc;
        zzegVar.zzm(zzefVar.zza, 0, 3);
        zzefVar.zzf(0);
        zzefVar.zzh(8);
        this.zzd = zzefVar.zzi();
        this.zze = zzefVar.zzi();
        zzefVar.zzh(6);
        zzegVar.zzm(zzefVar.zza, 0, zzefVar.zzj(8));
        zzefVar.zzf(0);
        if (this.zzd) {
            zzefVar.zzh(4);
            long jZzj = zzefVar.zzj(3);
            zzefVar.zzh(1);
            int iZzj = zzefVar.zzj(15) << 15;
            zzefVar.zzh(1);
            long jZzj2 = zzefVar.zzj(15);
            zzefVar.zzh(1);
            if (this.zzf || !this.zze) {
                c7 = 30;
            } else {
                zzefVar.zzh(4);
                long jZzj3 = ((long) zzefVar.zzj(3)) << 30;
                zzefVar.zzh(1);
                int iZzj2 = zzefVar.zzj(15) << 15;
                zzefVar.zzh(1);
                c7 = 30;
                long jZzj4 = zzefVar.zzj(15);
                zzefVar.zzh(1);
                this.zzb.zze(jZzj3 | ((long) iZzj2) | jZzj4);
                this.zzf = true;
            }
            jZze = this.zzb.zze((jZzj << c7) | ((long) iZzj) | jZzj2);
        } else {
            jZze = 0;
        }
        zzamq zzamqVar = this.zza;
        zzamqVar.zzc(jZze, 4);
        zzamqVar.zzd(zzegVar);
        zzamqVar.zze(false);
    }
}
