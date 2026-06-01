package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzanc implements zzamq {
    private final zzeg zza;
    private final zzadw zzb;

    @Nullable
    private final String zzc;
    private final int zzd;
    private final String zze;
    private zzaem zzf;
    private String zzg;
    private int zzh = 0;
    private int zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private int zzm;
    private long zzn;

    public zzanc(@Nullable String str, int i2, String str2) {
        zzeg zzegVar = new zzeg(4);
        this.zza = zzegVar;
        zzegVar.zzi()[0] = -1;
        this.zzb = new zzadw();
        this.zzn = -9223372036854775807L;
        this.zzc = str;
        this.zzd = i2;
        this.zze = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zza() {
        this.zzh = 0;
        this.zzi = 0;
        this.zzk = false;
        this.zzn = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzb(zzadd zzaddVar, zzaoe zzaoeVar) {
        zzaoeVar.zza();
        this.zzg = zzaoeVar.zzc();
        this.zzf = zzaddVar.zzu(zzaoeVar.zzb(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzc(long j, int i2) {
        this.zzn = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzd(zzeg zzegVar) {
        this.zzf.getClass();
        while (zzegVar.zzd() > 0) {
            int i2 = this.zzh;
            if (i2 == 0) {
                byte[] bArrZzi = zzegVar.zzi();
                int iZzg = zzegVar.zzg();
                int iZze = zzegVar.zze();
                while (true) {
                    if (iZzg >= iZze) {
                        zzegVar.zzh(iZze);
                        break;
                    }
                    int i8 = iZzg + 1;
                    byte b8 = bArrZzi[iZzg];
                    boolean z2 = (b8 & 255) == 255;
                    boolean z7 = this.zzk && (b8 & 224) == 224;
                    this.zzk = z2;
                    if (z7) {
                        zzegVar.zzh(i8);
                        this.zzk = false;
                        this.zza.zzi()[1] = bArrZzi[iZzg];
                        this.zzi = 2;
                        this.zzh = 1;
                        break;
                    }
                    iZzg = i8;
                }
            } else if (i2 != 1) {
                int iMin = Math.min(zzegVar.zzd(), this.zzm - this.zzi);
                this.zzf.zzz(zzegVar, iMin);
                int i9 = this.zzi + iMin;
                this.zzi = i9;
                if (i9 >= this.zzm) {
                    zzgmd.zzh(this.zzn != -9223372036854775807L);
                    this.zzf.zzx(this.zzn, 1, this.zzm, 0, null);
                    this.zzn += this.zzl;
                    this.zzi = 0;
                    this.zzh = 0;
                }
            } else {
                int iMin2 = Math.min(zzegVar.zzd(), 4 - this.zzi);
                zzeg zzegVar2 = this.zza;
                zzegVar.zzm(zzegVar2.zzi(), this.zzi, iMin2);
                int i10 = this.zzi + iMin2;
                this.zzi = i10;
                if (i10 >= 4) {
                    zzegVar2.zzh(0);
                    zzadw zzadwVar = this.zzb;
                    if (zzadwVar.zza(zzegVar2.zzB())) {
                        this.zzm = zzadwVar.zzc;
                        if (!this.zzj) {
                            this.zzl = (((long) zzadwVar.zzg) * 1000000) / ((long) zzadwVar.zzd);
                            zzt zztVar = new zzt();
                            zztVar.zza(this.zzg);
                            zztVar.zzl(this.zze);
                            zztVar.zzm(zzadwVar.zzb);
                            zztVar.zzn(4096);
                            zztVar.zzE(zzadwVar.zze);
                            zztVar.zzF(zzadwVar.zzd);
                            zztVar.zze(this.zzc);
                            zztVar.zzg(this.zzd);
                            this.zzf.zzu(zztVar.zzM());
                            this.zzj = true;
                        }
                        zzegVar2.zzh(0);
                        this.zzf.zzz(zzegVar2, 4);
                        this.zzh = 2;
                    } else {
                        this.zzi = 0;
                        this.zzh = 1;
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zze(boolean z2) {
    }
}
