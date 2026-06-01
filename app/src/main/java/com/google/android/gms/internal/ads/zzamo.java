package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzamo implements zzamq {
    private final zzeg zza;

    @Nullable
    private final String zzc;
    private final int zzd;
    private String zzf;
    private zzaem zzg;
    private int zzi;
    private int zzj;
    private long zzk;
    private zzv zzl;
    private int zzm;
    private int zzn;
    private int zzh = 0;
    private long zzq = -9223372036854775807L;
    private final AtomicInteger zzb = new AtomicInteger();
    private int zzo = -1;
    private int zzp = -1;
    private final String zze = "video/mp2t";

    public zzamo(@Nullable String str, int i2, int i8, String str2) {
        this.zza = new zzeg(new byte[i8]);
        this.zzc = str;
        this.zzd = i2;
    }

    private final boolean zzf(zzeg zzegVar, byte[] bArr, int i2) {
        int iMin = Math.min(zzegVar.zzd(), i2 - this.zzi);
        zzegVar.zzm(bArr, this.zzi, iMin);
        int i8 = this.zzi + iMin;
        this.zzi = i8;
        return i8 == i2;
    }

    @RequiresNonNull({"output"})
    private final void zzg(zzacy zzacyVar) {
        int i2;
        int i8 = zzacyVar.zzb;
        if (i8 == -2147483647 || (i2 = zzacyVar.zzc) == -1) {
            return;
        }
        zzv zzvVar = this.zzl;
        if (zzvVar != null && i2 == zzvVar.zzG && i8 == zzvVar.zzH && Objects.equals(zzacyVar.zza, zzvVar.zzo)) {
            return;
        }
        zzv zzvVar2 = this.zzl;
        zzt zztVar = zzvVar2 == null ? new zzt() : zzvVar2.zza();
        zztVar.zza(this.zzf);
        zztVar.zzl(this.zze);
        zztVar.zzm(zzacyVar.zza);
        zztVar.zzE(i2);
        zztVar.zzF(i8);
        zztVar.zze(this.zzc);
        zztVar.zzg(this.zzd);
        zzv zzvVarZzM = zztVar.zzM();
        this.zzl = zzvVarZzM;
        this.zzg.zzu(zzvVarZzM);
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zza() {
        this.zzh = 0;
        this.zzi = 0;
        this.zzj = 0;
        this.zzq = -9223372036854775807L;
        this.zzb.set(0);
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzb(zzadd zzaddVar, zzaoe zzaoeVar) {
        zzaoeVar.zza();
        this.zzf = zzaoeVar.zzc();
        this.zzg = zzaddVar.zzu(zzaoeVar.zzb(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzc(long j, int i2) {
        this.zzq = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzd(zzeg zzegVar) throws zzat {
        int i2;
        byte b8;
        int i8;
        byte b9;
        this.zzg.getClass();
        while (zzegVar.zzd() > 0) {
            int i9 = this.zzh;
            if (i9 == 0) {
                while (true) {
                    if (zzegVar.zzd() > 0) {
                        int i10 = this.zzj << 8;
                        this.zzj = i10;
                        int iZzs = i10 | zzegVar.zzs();
                        this.zzj = iZzs;
                        int iZza = zzacz.zza(iZzs);
                        this.zzn = iZza;
                        if (iZza != 0) {
                            byte[] bArrZzi = this.zza.zzi();
                            int i11 = this.zzj;
                            bArrZzi[0] = (byte) ((i11 >> 24) & 255);
                            bArrZzi[1] = (byte) ((i11 >> 16) & 255);
                            bArrZzi[2] = (byte) ((i11 >> 8) & 255);
                            bArrZzi[3] = (byte) (i11 & 255);
                            this.zzi = 4;
                            this.zzj = 0;
                            if (iZza == 3 || iZza == 4) {
                                this.zzh = 4;
                            } else if (iZza == 1) {
                                this.zzh = 1;
                            } else {
                                this.zzh = 2;
                            }
                        }
                    }
                }
            } else if (i9 == 1) {
                zzeg zzegVar2 = this.zza;
                if (zzf(zzegVar, zzegVar2.zzi(), 18)) {
                    byte[] bArrZzi2 = zzegVar2.zzi();
                    if (this.zzl == null) {
                        zzv zzvVarZzb = zzacz.zzb(bArrZzi2, this.zzf, this.zzc, this.zzd, this.zze, null);
                        this.zzl = zzvVarZzb;
                        this.zzg.zzu(zzvVarZzb);
                    }
                    this.zzm = zzacz.zzc(bArrZzi2);
                    byte b10 = bArrZzi2[0];
                    if (b10 != -2) {
                        if (b10 == -1) {
                            i2 = (bArrZzi2[4] & 7) << 4;
                            b9 = bArrZzi2[7];
                        } else if (b10 != 31) {
                            i2 = (bArrZzi2[4] & 1) << 6;
                            b8 = bArrZzi2[5];
                        } else {
                            i2 = (bArrZzi2[5] & 7) << 4;
                            b9 = bArrZzi2[6];
                        }
                        i8 = b9 & 60;
                        this.zzk = zzgst.zza(zzep.zzr(((i2 | (i8 >> 2)) + 1) * 32, this.zzl.zzH));
                        zzegVar2.zzh(0);
                        this.zzg.zzz(zzegVar2, 18);
                        this.zzh = 6;
                    } else {
                        i2 = (bArrZzi2[5] & 1) << 6;
                        b8 = bArrZzi2[4];
                    }
                    i8 = b8 & 252;
                    this.zzk = zzgst.zza(zzep.zzr(((i2 | (i8 >> 2)) + 1) * 32, this.zzl.zzH));
                    zzegVar2.zzh(0);
                    this.zzg.zzz(zzegVar2, 18);
                    this.zzh = 6;
                }
            } else if (i9 != 2) {
                if (i9 == 3) {
                    zzeg zzegVar3 = this.zza;
                    if (zzf(zzegVar, zzegVar3.zzi(), this.zzo)) {
                        zzacy zzacyVarZzd = zzacz.zzd(zzegVar3.zzi());
                        zzg(zzacyVarZzd);
                        this.zzm = zzacyVarZzd.zzd;
                        long j = zzacyVarZzd.zze;
                        this.zzk = j != -9223372036854775807L ? j : 0L;
                        zzegVar3.zzh(0);
                        this.zzg.zzz(zzegVar3, this.zzo);
                        this.zzh = 6;
                    }
                } else if (i9 == 4) {
                    zzeg zzegVar4 = this.zza;
                    if (zzf(zzegVar, zzegVar4.zzi(), 6)) {
                        int iZzg = zzacz.zzg(zzegVar4.zzi());
                        this.zzp = iZzg;
                        int i12 = this.zzi;
                        if (i12 > iZzg) {
                            int i13 = i12 - iZzg;
                            this.zzi = i12 - i13;
                            zzegVar.zzh(zzegVar.zzg() - i13);
                        }
                        this.zzh = 5;
                    }
                } else if (i9 != 5) {
                    int iMin = Math.min(zzegVar.zzd(), this.zzm - this.zzi);
                    this.zzg.zzz(zzegVar, iMin);
                    int i14 = this.zzi + iMin;
                    this.zzi = i14;
                    if (i14 == this.zzm) {
                        zzgmd.zzh(this.zzq != -9223372036854775807L);
                        this.zzg.zzx(this.zzq, this.zzn == 4 ? 0 : 1, this.zzm, 0, null);
                        this.zzq += this.zzk;
                        this.zzh = 0;
                    }
                } else {
                    zzeg zzegVar5 = this.zza;
                    if (zzf(zzegVar, zzegVar5.zzi(), this.zzp)) {
                        zzacy zzacyVarZzf = zzacz.zzf(zzegVar5.zzi(), this.zzb);
                        if (this.zzn == 3) {
                            zzg(zzacyVarZzf);
                        }
                        this.zzm = zzacyVarZzf.zzd;
                        long j3 = zzacyVarZzf.zze;
                        this.zzk = j3 != -9223372036854775807L ? j3 : 0L;
                        zzegVar5.zzh(0);
                        this.zzg.zzz(zzegVar5, this.zzp);
                        this.zzh = 6;
                    }
                }
            } else {
                zzeg zzegVar6 = this.zza;
                if (zzf(zzegVar, zzegVar6.zzi(), 7)) {
                    this.zzo = zzacz.zze(zzegVar6.zzi());
                    this.zzh = 3;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zze(boolean z2) {
    }
}
