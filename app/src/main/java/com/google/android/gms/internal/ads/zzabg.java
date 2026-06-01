package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzabg {
    private final zzaba zza;
    private final zzabb zzf;
    private long zzk;
    private final zzaaa zzl;
    private final zzaay zzb = new zzaay();
    private final zzel zzc = new zzel(10);
    private final zzel zzd = new zzel(10);
    private final zzdv zze = new zzdv(16);
    private long zzg = -9223372036854775807L;
    private zzbv zzj = zzbv.zza;
    private long zzh = -9223372036854775807L;
    private long zzi = -9223372036854775807L;

    public zzabg(zzaaa zzaaaVar, zzaba zzabaVar, zzabb zzabbVar) {
        this.zzl = zzaaaVar;
        this.zza = zzabaVar;
        this.zzf = zzabbVar;
    }

    private static Object zzh(zzel zzelVar) {
        zzgmd.zza(zzelVar.zzc() > 0);
        while (zzelVar.zzc() > 1) {
            zzelVar.zzd();
        }
        Object objZzd = zzelVar.zzd();
        objZzd.getClass();
        return objZzd;
    }

    public final void zza() {
        this.zze.zze();
        this.zzg = -9223372036854775807L;
        this.zzh = -9223372036854775807L;
        this.zzi = -9223372036854775807L;
        zzel zzelVar = this.zzd;
        if (zzelVar.zzc() > 0) {
            this.zzk = ((Long) zzh(zzelVar)).longValue();
        }
        zzel zzelVar2 = this.zzc;
        if (zzelVar2.zzc() > 0) {
            zzelVar2.zza(0L, (zzbv) zzh(zzelVar2));
        }
    }

    public final void zzb(long j, long j3) throws zzib {
        while (true) {
            zzdv zzdvVar = this.zze;
            if (zzdvVar.zzd()) {
                return;
            }
            zzel zzelVar = this.zzd;
            long jZzc = zzdvVar.zzc();
            Long l = (Long) zzelVar.zze(jZzc);
            if (l != null && l.longValue() != this.zzk) {
                this.zzk = l.longValue();
                this.zza.zza(2);
            }
            zzaba zzabaVar = this.zza;
            long j8 = this.zzk;
            zzaay zzaayVar = this.zzb;
            int iZzk = zzabaVar.zzk(jZzc, j, j3, j8, false, false, zzaayVar);
            if (iZzk != 5 && iZzk != 4) {
                this.zzf.zza(jZzc, zzaayVar.zza());
            }
            if (iZzk == 0 || iZzk == 1) {
                this.zzh = jZzc;
                long jZzb = zzdvVar.zzb();
                zzbv zzbvVar = (zzbv) this.zzc.zze(jZzb);
                if (zzbvVar != null && !zzbvVar.equals(zzbv.zza) && !zzbvVar.equals(this.zzj)) {
                    this.zzj = zzbvVar;
                    this.zzl.zza(zzbvVar);
                }
                this.zzl.zzb(iZzk == 0 ? System.nanoTime() : zzaayVar.zzb(), jZzb, zzabaVar.zzf());
            } else if (iZzk == 2 || iZzk == 3) {
                this.zzh = jZzc;
                zzdvVar.zzb();
                final zzaaa zzaaaVar = this.zzl;
                Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzzy
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzaaaVar.zza.zzB().zzc();
                    }
                };
                zzaab zzaabVar = zzaaaVar.zza;
                zzaabVar.zzC().execute(runnable);
                ((zzabv) zzaabVar.zzz().remove()).zzb();
            } else if (iZzk != 4) {
                return;
            } else {
                this.zzh = jZzc;
            }
        }
    }

    public final void zzc(int i2, int i8) {
        long j = this.zzg;
        this.zzc.zza(j == -9223372036854775807L ? 0L : j + 1, new zzbv(i2, i8, 1.0f));
    }

    public final void zzd(int i2, long j) {
        if (this.zze.zzd()) {
            this.zza.zza(i2);
            this.zzk = j;
        } else {
            zzel zzelVar = this.zzd;
            long j3 = this.zzg;
            zzelVar.zza(j3 == -9223372036854775807L ? -4611686018427387904L : j3 + 1, Long.valueOf(j));
        }
    }

    public final void zze(long j) {
        this.zze.zza(j);
        this.zzg = j;
        this.zzi = -9223372036854775807L;
    }

    public final void zzf() {
        long j = this.zzg;
        if (j == -9223372036854775807L) {
            j = Long.MIN_VALUE;
            this.zzg = Long.MIN_VALUE;
            this.zzh = Long.MIN_VALUE;
        }
        this.zzi = j;
    }

    public final boolean zzg() {
        long j = this.zzi;
        return j != -9223372036854775807L && this.zzh == j;
    }
}
