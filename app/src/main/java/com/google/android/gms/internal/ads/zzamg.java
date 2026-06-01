package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzamg implements zzamq {
    private final zzef zza;
    private final zzeg zzb;

    @Nullable
    private final String zzc;
    private final int zzd;
    private final String zze;
    private String zzf;
    private zzaem zzg;
    private int zzh;
    private int zzi;
    private boolean zzj;
    private long zzk;
    private zzv zzl;
    private int zzm;
    private long zzn;

    public zzamg(@Nullable String str, int i2, String str2) {
        zzef zzefVar = new zzef(new byte[128], 128);
        this.zza = zzefVar;
        this.zzb = new zzeg(zzefVar.zza);
        this.zzh = 0;
        this.zzn = -9223372036854775807L;
        this.zzc = str;
        this.zzd = i2;
        this.zze = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zza() {
        this.zzh = 0;
        this.zzi = 0;
        this.zzj = false;
        this.zzn = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzb(zzadd zzaddVar, zzaoe zzaoeVar) {
        zzaoeVar.zza();
        this.zzf = zzaoeVar.zzc();
        this.zzg = zzaddVar.zzu(zzaoeVar.zzb(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzc(long j, int i2) {
        this.zzn = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzd(zzeg zzegVar) {
        this.zzg.getClass();
        while (zzegVar.zzd() > 0) {
            int i2 = this.zzh;
            if (i2 == 0) {
                while (true) {
                    if (zzegVar.zzd() <= 0) {
                        break;
                    }
                    if (this.zzj) {
                        int iZzs = zzegVar.zzs();
                        if (iZzs == 119) {
                            this.zzj = false;
                            this.zzh = 1;
                            zzeg zzegVar2 = this.zzb;
                            zzegVar2.zzi()[0] = 11;
                            zzegVar2.zzi()[1] = 119;
                            this.zzi = 2;
                            break;
                        }
                        this.zzj = iZzs == 11;
                    } else {
                        this.zzj = zzegVar.zzs() == 11;
                    }
                }
            } else if (i2 != 1) {
                int iMin = Math.min(zzegVar.zzd(), this.zzm - this.zzi);
                this.zzg.zzz(zzegVar, iMin);
                int i8 = this.zzi + iMin;
                this.zzi = i8;
                if (i8 == this.zzm) {
                    zzgmd.zzh(this.zzn != -9223372036854775807L);
                    this.zzg.zzx(this.zzn, 1, this.zzm, 0, null);
                    this.zzn += this.zzk;
                    this.zzh = 0;
                }
            } else {
                zzeg zzegVar3 = this.zzb;
                byte[] bArrZzi = zzegVar3.zzi();
                int iMin2 = Math.min(zzegVar.zzd(), 128 - this.zzi);
                zzegVar.zzm(bArrZzi, this.zzi, iMin2);
                int i9 = this.zzi + iMin2;
                this.zzi = i9;
                if (i9 == 128) {
                    zzef zzefVar = this.zza;
                    zzefVar.zzf(0);
                    zzaca zzacaVarZzc = zzacb.zzc(zzefVar);
                    zzv zzvVar = this.zzl;
                    if (zzvVar == null || zzacaVarZzc.zzc != zzvVar.zzG || zzacaVarZzc.zzb != zzvVar.zzH || !Objects.equals(zzacaVarZzc.zza, zzvVar.zzo)) {
                        zzt zztVar = new zzt();
                        zztVar.zza(this.zzf);
                        zztVar.zzl(this.zze);
                        String str = zzacaVarZzc.zza;
                        zztVar.zzm(str);
                        zztVar.zzE(zzacaVarZzc.zzc);
                        zztVar.zzF(zzacaVarZzc.zzb);
                        zztVar.zze(this.zzc);
                        zztVar.zzg(this.zzd);
                        int i10 = zzacaVarZzc.zzf;
                        zztVar.zzi(i10);
                        if ("audio/ac3".equals(str)) {
                            zztVar.zzh(i10);
                        }
                        zzv zzvVarZzM = zztVar.zzM();
                        this.zzl = zzvVarZzM;
                        this.zzg.zzu(zzvVarZzM);
                    }
                    this.zzm = zzacaVarZzc.zzd;
                    this.zzk = (((long) zzacaVarZzc.zze) * 1000000) / ((long) this.zzl.zzH);
                    zzegVar3.zzh(0);
                    this.zzg.zzz(zzegVar3, 128);
                    this.zzh = 2;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zze(boolean z2) {
    }
}
