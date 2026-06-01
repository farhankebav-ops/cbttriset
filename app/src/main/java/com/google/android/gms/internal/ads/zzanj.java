package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzanj implements zzaof {
    private final zzamq zza;
    private final zzef zzb = new zzef(new byte[10], 10);
    private int zzc = 0;
    private int zzd;
    private zzem zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    public zzanj(zzamq zzamqVar) {
        this.zza = zzamqVar;
    }

    private final void zze(int i2) {
        this.zzc = i2;
        this.zzd = 0;
    }

    private final boolean zzf(zzeg zzegVar, @Nullable byte[] bArr, int i2) {
        int iMin = Math.min(zzegVar.zzd(), i2 - this.zzd);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            zzegVar.zzk(iMin);
        } else {
            zzegVar.zzm(bArr, this.zzd, iMin);
        }
        int i8 = this.zzd + iMin;
        this.zzd = i8;
        return i8 == i2;
    }

    @Override // com.google.android.gms.internal.ads.zzaof
    public final void zza(zzem zzemVar, zzadd zzaddVar, zzaoe zzaoeVar) {
        this.zze = zzemVar;
        this.zza.zzb(zzaddVar, zzaoeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaof
    public final void zzb() {
        this.zzc = 0;
        this.zzd = 0;
        this.zzh = false;
        this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzaof
    public final void zzc(zzeg zzegVar, int i2) throws zzat {
        int i8;
        int i9;
        long jZze;
        long j;
        this.zze.getClass();
        int i10 = -1;
        int i11 = 2;
        if ((i2 & 1) != 0) {
            int i12 = this.zzc;
            if (i12 != 0 && i12 != 1) {
                if (i12 != 2) {
                    int i13 = this.zzj;
                    if (i13 != -1) {
                        StringBuilder sb = new StringBuilder(String.valueOf(i13).length() + 48);
                        sb.append("Unexpected start indicator: expected ");
                        sb.append(i13);
                        sb.append(" more bytes");
                        zzdt.zzc("PesReader", sb.toString());
                    }
                    this.zza.zze(zzegVar.zze() == 0);
                } else {
                    zzdt.zzc("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            zze(1);
        }
        int i14 = i2;
        while (zzegVar.zzd() > 0) {
            int i15 = this.zzc;
            if (i15 == 0) {
                i8 = i11;
                zzegVar.zzk(zzegVar.zzd());
            } else if (i15 != 1) {
                if (i15 != i11) {
                    int iZzd = zzegVar.zzd();
                    int i16 = this.zzj;
                    int i17 = i16 == i10 ? 0 : iZzd - i16;
                    if (i17 > 0) {
                        iZzd -= i17;
                        zzegVar.zzf(zzegVar.zzg() + iZzd);
                    }
                    zzamq zzamqVar = this.zza;
                    zzamqVar.zzd(zzegVar);
                    int i18 = this.zzj;
                    if (i18 != i10) {
                        int i19 = i18 - iZzd;
                        this.zzj = i19;
                        if (i19 == 0) {
                            zzamqVar.zze(false);
                            zze(1);
                        }
                    }
                } else {
                    int iMin = Math.min(10, this.zzi);
                    zzef zzefVar = this.zzb;
                    if (zzf(zzegVar, zzefVar.zza, iMin) && zzf(zzegVar, null, this.zzi)) {
                        zzefVar.zzf(0);
                        if (this.zzf) {
                            zzefVar.zzh(4);
                            long jZzj = zzefVar.zzj(3);
                            zzefVar.zzh(1);
                            int iZzj = zzefVar.zzj(15) << 15;
                            zzefVar.zzh(1);
                            long jZzj2 = zzefVar.zzj(15);
                            zzefVar.zzh(1);
                            if (this.zzh || !this.zzg) {
                                j = jZzj;
                            } else {
                                zzefVar.zzh(4);
                                j = jZzj;
                                long jZzj3 = ((long) zzefVar.zzj(3)) << 30;
                                zzefVar.zzh(1);
                                int iZzj2 = zzefVar.zzj(15) << 15;
                                zzefVar.zzh(1);
                                long jZzj4 = zzefVar.zzj(15);
                                zzefVar.zzh(1);
                                this.zze.zze(jZzj3 | ((long) iZzj2) | jZzj4);
                                this.zzh = true;
                            }
                            jZze = this.zze.zze(jZzj2 | (j << 30) | ((long) iZzj));
                        } else {
                            jZze = -9223372036854775807L;
                        }
                        i14 |= true != this.zzk ? 0 : 4;
                        this.zza.zzc(jZze, i14);
                        zze(3);
                        i10 = -1;
                        i11 = 2;
                    }
                }
                i8 = i11;
            } else {
                zzef zzefVar2 = this.zzb;
                if (zzf(zzegVar, zzefVar2.zza, 9)) {
                    zzefVar2.zzf(0);
                    int iZzj3 = zzefVar2.zzj(24);
                    if (iZzj3 != 1) {
                        com.google.android.gms.ads.internal.client.a.s(new StringBuilder(String.valueOf(iZzj3).length() + 30), "Unexpected start code prefix: ", iZzj3, "PesReader");
                        i10 = -1;
                        this.zzj = -1;
                        i9 = 0;
                        i8 = 2;
                    } else {
                        zzefVar2.zzh(8);
                        int iZzj4 = zzefVar2.zzj(16);
                        zzefVar2.zzh(5);
                        this.zzk = zzefVar2.zzi();
                        i8 = 2;
                        zzefVar2.zzh(2);
                        this.zzf = zzefVar2.zzi();
                        this.zzg = zzefVar2.zzi();
                        zzefVar2.zzh(6);
                        int iZzj5 = zzefVar2.zzj(8);
                        this.zzi = iZzj5;
                        if (iZzj4 == 0) {
                            this.zzj = -1;
                            i10 = -1;
                        } else {
                            int i20 = (iZzj4 - 3) - iZzj5;
                            this.zzj = i20;
                            if (i20 < 0) {
                                com.google.android.gms.ads.internal.client.a.s(new StringBuilder(String.valueOf(i20).length() + 36), "Found negative packet payload size: ", i20, "PesReader");
                                i10 = -1;
                                this.zzj = -1;
                            } else {
                                i10 = -1;
                            }
                        }
                        i9 = 2;
                    }
                    zze(i9);
                } else {
                    i10 = -1;
                    i8 = 2;
                }
            }
            i11 = i8;
        }
    }

    public final boolean zzd(boolean z2) {
        return this.zzc == 3 && this.zzj == -1;
    }
}
