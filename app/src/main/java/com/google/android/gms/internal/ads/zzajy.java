package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzajy extends zzajw {

    @Nullable
    private zzajx zza;
    private int zzb;
    private boolean zzc;

    @Nullable
    private zzaer zzd;

    @Nullable
    private zzaep zze;

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void zza(boolean z2) {
        super.zza(z2);
        if (z2) {
            this.zza = null;
            this.zzd = null;
            this.zze = null;
        }
        this.zzb = 0;
        this.zzc = false;
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final long zzb(zzeg zzegVar) {
        if ((zzegVar.zzi()[0] & 1) == 1) {
            return -1L;
        }
        byte b8 = zzegVar.zzi()[0];
        zzajx zzajxVar = this.zza;
        zzajxVar.getClass();
        int i2 = !zzajxVar.zzd[(b8 >> 1) & (255 >>> (8 - zzajxVar.zze))].zza ? zzajxVar.zza.zze : zzajxVar.zza.zzf;
        int i8 = this.zzc ? (this.zzb + i2) / 4 : 0;
        if (zzegVar.zzj() < zzegVar.zze() + 4) {
            byte[] bArrCopyOf = Arrays.copyOf(zzegVar.zzi(), zzegVar.zze() + 4);
            zzegVar.zzb(bArrCopyOf, bArrCopyOf.length);
        } else {
            zzegVar.zzf(zzegVar.zze() + 4);
        }
        long j = i8;
        byte[] bArrZzi = zzegVar.zzi();
        bArrZzi[zzegVar.zze() - 4] = (byte) (j & 255);
        bArrZzi[zzegVar.zze() - 3] = (byte) ((j >>> 8) & 255);
        bArrZzi[zzegVar.zze() - 2] = (byte) ((j >>> 16) & 255);
        bArrZzi[zzegVar.zze() - 1] = (byte) ((j >>> 24) & 255);
        this.zzc = true;
        this.zzb = i2;
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public final boolean zzc(zzeg zzegVar, long j, zzaju zzajuVar) throws IOException {
        zzajx zzajxVar;
        int i2;
        int iZzb;
        int i8;
        int i9;
        long jFloor;
        if (this.zza != null) {
            zzajuVar.zza.getClass();
            return false;
        }
        zzaer zzaerVar = this.zzd;
        int i10 = 1;
        if (zzaerVar == null) {
            zzaes.zzd(1, zzegVar, false);
            int iZzI = zzegVar.zzI();
            int iZzs = zzegVar.zzs();
            int iZzI2 = zzegVar.zzI();
            int iZzC = zzegVar.zzC();
            int i11 = iZzC <= 0 ? -1 : iZzC;
            int iZzC2 = zzegVar.zzC();
            int i12 = iZzC2 <= 0 ? -1 : iZzC2;
            int iZzC3 = zzegVar.zzC();
            int i13 = iZzC3 <= 0 ? -1 : iZzC3;
            int iZzs2 = zzegVar.zzs();
            this.zzd = new zzaer(iZzI, iZzs, iZzI2, i11, i12, i13, (int) Math.pow(2.0d, iZzs2 & 15), (int) Math.pow(2.0d, (iZzs2 & 240) >> 4), 1 == (zzegVar.zzs() & 1), Arrays.copyOf(zzegVar.zzi(), zzegVar.zze()));
        } else {
            int i14 = 4;
            zzaep zzaepVar = this.zze;
            if (zzaepVar == null) {
                this.zze = zzaes.zzb(zzegVar, true, true);
            } else {
                byte[] bArr = new byte[zzegVar.zze()];
                System.arraycopy(zzegVar.zzi(), 0, bArr, 0, zzegVar.zze());
                int i15 = zzaerVar.zza;
                int i16 = 5;
                zzaes.zzd(5, zzegVar, false);
                int iZzs3 = zzegVar.zzs() + 1;
                zzaeo zzaeoVar = new zzaeo(zzegVar.zzi());
                zzaeoVar.zzc(zzegVar.zzg() * 8);
                int i17 = 0;
                while (true) {
                    int i18 = 2;
                    int i19 = 16;
                    if (i17 >= iZzs3) {
                        int i20 = i10;
                        int i21 = 6;
                        int iZzb2 = zzaeoVar.zzb(6) + i20;
                        for (int i22 = 0; i22 < iZzb2; i22++) {
                            if (zzaeoVar.zzb(16) != 0) {
                                throw zzat.zzb("placeholder of time domain transforms not zeroed out", null);
                            }
                        }
                        int iZzb3 = zzaeoVar.zzb(6) + i20;
                        int i23 = 0;
                        while (true) {
                            int i24 = 3;
                            if (i23 < iZzb3) {
                                int iZzb4 = zzaeoVar.zzb(i19);
                                if (iZzb4 == 0) {
                                    int i25 = 8;
                                    zzaeoVar.zzc(8);
                                    zzaeoVar.zzc(16);
                                    zzaeoVar.zzc(16);
                                    zzaeoVar.zzc(6);
                                    zzaeoVar.zzc(8);
                                    int iZzb5 = zzaeoVar.zzb(4) + 1;
                                    int i26 = 0;
                                    while (i26 < iZzb5) {
                                        zzaeoVar.zzc(i25);
                                        i26++;
                                        i25 = 8;
                                    }
                                } else {
                                    if (iZzb4 != 1) {
                                        StringBuilder sb = new StringBuilder(com.google.android.gms.ads.internal.client.a.a(iZzb4, 41));
                                        sb.append("floor type greater than 1 not decodable: ");
                                        sb.append(iZzb4);
                                        throw zzat.zzb(sb.toString(), null);
                                    }
                                    int iZzb6 = zzaeoVar.zzb(5);
                                    int[] iArr = new int[iZzb6];
                                    int i27 = -1;
                                    for (int i28 = 0; i28 < iZzb6; i28++) {
                                        int iZzb7 = zzaeoVar.zzb(4);
                                        iArr[i28] = iZzb7;
                                        if (iZzb7 > i27) {
                                            i27 = iZzb7;
                                        }
                                    }
                                    int i29 = i27 + 1;
                                    int[] iArr2 = new int[i29];
                                    int i30 = 0;
                                    while (i30 < i29) {
                                        iArr2[i30] = zzaeoVar.zzb(i24) + 1;
                                        int iZzb8 = zzaeoVar.zzb(2);
                                        if (iZzb8 > 0) {
                                            i8 = 8;
                                            zzaeoVar.zzc(8);
                                        } else {
                                            i8 = 8;
                                        }
                                        int i31 = i29;
                                        int i32 = 0;
                                        for (int i33 = 1; i32 < (i33 << iZzb8); i33 = 1) {
                                            zzaeoVar.zzc(i8);
                                            i32++;
                                            i8 = 8;
                                        }
                                        i30++;
                                        i29 = i31;
                                        i24 = 3;
                                    }
                                    zzaeoVar.zzc(2);
                                    int iZzb9 = zzaeoVar.zzb(4);
                                    int i34 = 0;
                                    int i35 = 0;
                                    for (int i36 = 0; i36 < iZzb6; i36++) {
                                        i34 += iArr2[iArr[i36]];
                                        while (i35 < i34) {
                                            zzaeoVar.zzc(iZzb9);
                                            i35++;
                                        }
                                    }
                                }
                                i23++;
                                i21 = 6;
                                i19 = 16;
                            } else {
                                int i37 = 1;
                                int iZzb10 = zzaeoVar.zzb(i21) + 1;
                                int i38 = 0;
                                while (i38 < iZzb10) {
                                    if (zzaeoVar.zzb(16) > 2) {
                                        throw zzat.zzb("residueType greater than 2 is not decodable", null);
                                    }
                                    zzaeoVar.zzc(24);
                                    zzaeoVar.zzc(24);
                                    zzaeoVar.zzc(24);
                                    int iZzb11 = zzaeoVar.zzb(i21) + i37;
                                    int i39 = 8;
                                    zzaeoVar.zzc(8);
                                    int[] iArr3 = new int[iZzb11];
                                    for (int i40 = 0; i40 < iZzb11; i40++) {
                                        iArr3[i40] = ((zzaeoVar.zza() ? zzaeoVar.zzb(5) : 0) * 8) + zzaeoVar.zzb(3);
                                    }
                                    int i41 = 0;
                                    while (i41 < iZzb11) {
                                        int i42 = 0;
                                        while (i42 < i39) {
                                            if ((iArr3[i41] & (1 << i42)) != 0) {
                                                zzaeoVar.zzc(i39);
                                            }
                                            i42++;
                                            i39 = 8;
                                        }
                                        i41++;
                                        i39 = 8;
                                    }
                                    i38++;
                                    i21 = 6;
                                    i37 = 1;
                                }
                                int iZzb12 = zzaeoVar.zzb(i21) + 1;
                                for (int i43 = 0; i43 < iZzb12; i43++) {
                                    int iZzb13 = zzaeoVar.zzb(16);
                                    if (iZzb13 != 0) {
                                        StringBuilder sb2 = new StringBuilder(com.google.android.gms.ads.internal.client.a.a(iZzb13, 41));
                                        sb2.append("mapping type other than 0 not supported: ");
                                        sb2.append(iZzb13);
                                        zzdt.zze("VorbisUtil", sb2.toString());
                                    } else {
                                        if (zzaeoVar.zza()) {
                                            i2 = 1;
                                            iZzb = zzaeoVar.zzb(4) + 1;
                                        } else {
                                            i2 = 1;
                                            iZzb = 1;
                                        }
                                        if (zzaeoVar.zza()) {
                                            int iZzb14 = zzaeoVar.zzb(8) + i2;
                                            for (int i44 = 0; i44 < iZzb14; i44++) {
                                                int i45 = i15 - 1;
                                                zzaeoVar.zzc(zzaes.zza(i45));
                                                zzaeoVar.zzc(zzaes.zza(i45));
                                            }
                                        }
                                        if (zzaeoVar.zzb(2) != 0) {
                                            throw zzat.zzb("to reserved bits must be zero after mapping coupling steps", null);
                                        }
                                        if (iZzb > 1) {
                                            for (int i46 = 0; i46 < i15; i46++) {
                                                zzaeoVar.zzc(4);
                                            }
                                        }
                                        for (int i47 = 0; i47 < iZzb; i47++) {
                                            zzaeoVar.zzc(8);
                                            zzaeoVar.zzc(8);
                                            zzaeoVar.zzc(8);
                                        }
                                    }
                                }
                                int iZzb15 = zzaeoVar.zzb(6);
                                int i48 = iZzb15 + 1;
                                zzaeq[] zzaeqVarArr = new zzaeq[i48];
                                for (int i49 = 0; i49 < i48; i49++) {
                                    zzaeqVarArr[i49] = new zzaeq(zzaeoVar.zza(), zzaeoVar.zzb(16), zzaeoVar.zzb(16), zzaeoVar.zzb(8));
                                }
                                if (!zzaeoVar.zza()) {
                                    throw zzat.zzb("framing bit after modes not set as expected", null);
                                }
                                zzajxVar = new zzajx(zzaerVar, zzaepVar, bArr, zzaeqVarArr, zzaes.zza(iZzb15));
                            }
                        }
                    } else {
                        if (zzaeoVar.zzb(24) != 5653314) {
                            int iZzd = zzaeoVar.zzd();
                            StringBuilder sb3 = new StringBuilder(String.valueOf(iZzd).length() + 55);
                            sb3.append("expected code book to start with [0x56, 0x43, 0x42] at ");
                            sb3.append(iZzd);
                            throw zzat.zzb(sb3.toString(), null);
                        }
                        int iZzb16 = zzaeoVar.zzb(16);
                        int iZzb17 = zzaeoVar.zzb(24);
                        if (zzaeoVar.zza()) {
                            zzaeoVar.zzc(i16);
                            for (int iZzb18 = 0; iZzb18 < iZzb17; iZzb18 += zzaeoVar.zzb(zzaes.zza(iZzb17 - iZzb18))) {
                            }
                        } else {
                            boolean zZza = zzaeoVar.zza();
                            for (int i50 = 0; i50 < iZzb17; i50++) {
                                if (!zZza) {
                                    zzaeoVar.zzc(i16);
                                } else if (zzaeoVar.zza()) {
                                    zzaeoVar.zzc(i16);
                                }
                            }
                        }
                        int i51 = i14;
                        int iZzb19 = zzaeoVar.zzb(i51);
                        if (iZzb19 > 2) {
                            StringBuilder sb4 = new StringBuilder(String.valueOf(iZzb19).length() + 42);
                            sb4.append("lookup type greater than 2 not decodable: ");
                            sb4.append(iZzb19);
                            throw zzat.zzb(sb4.toString(), null);
                        }
                        if (iZzb19 != i10) {
                            if (iZzb19 != 2) {
                                i9 = i10;
                            }
                            i17++;
                            i10 = i9;
                            i14 = 4;
                            i16 = 5;
                        } else {
                            i18 = iZzb19;
                        }
                        zzaeoVar.zzc(32);
                        zzaeoVar.zzc(32);
                        int iZzb20 = zzaeoVar.zzb(i51) + i10;
                        zzaeoVar.zzc(i10);
                        if (i18 != i10) {
                            i9 = i10;
                            jFloor = ((long) iZzb16) * ((long) iZzb17);
                        } else if (iZzb16 != 0) {
                            i9 = i10;
                            jFloor = (long) Math.floor(Math.pow(iZzb17, 1.0d / ((double) iZzb16)));
                        } else {
                            i9 = i10;
                            jFloor = 0;
                        }
                        zzaeoVar.zzc((int) (jFloor * ((long) iZzb20)));
                        i17++;
                        i10 = i9;
                        i14 = 4;
                        i16 = 5;
                    }
                }
            }
        }
        zzajxVar = null;
        this.zza = zzajxVar;
        if (zzajxVar == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        zzaer zzaerVar2 = zzajxVar.zza;
        arrayList.add(zzaerVar2.zzg);
        arrayList.add(zzajxVar.zzc);
        zzap zzapVarZzc = zzaes.zzc(zzgpe.zzr(zzajxVar.zzb.zza));
        zzt zztVar = new zzt();
        zztVar.zzl("audio/ogg");
        zztVar.zzm("audio/vorbis");
        zztVar.zzh(zzaerVar2.zzd);
        zztVar.zzi(zzaerVar2.zzc);
        zztVar.zzE(zzaerVar2.zza);
        zztVar.zzF(zzaerVar2.zzb);
        zztVar.zzp(arrayList);
        zztVar.zzk(zzapVarZzc);
        zzajuVar.zza = zztVar.zzM();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void zzj(long j) {
        super.zzj(j);
        this.zzc = j != 0;
        zzaer zzaerVar = this.zzd;
        this.zzb = zzaerVar != null ? zzaerVar.zze : 0;
    }
}
