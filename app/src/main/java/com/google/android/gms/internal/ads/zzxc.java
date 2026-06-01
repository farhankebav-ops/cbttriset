package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzxc extends zzxe {
    public zzxc(zzbg zzbgVar, int[] iArr, int i2, zzza zzzaVar, long j, long j3, long j8, int i8, int i9, float f4, float f8, List list, zzdc zzdcVar) {
        super(zzbgVar, iArr, 0);
        zzgpe.zzq(list);
    }

    public static /* synthetic */ zzgpe zzd(zzyj[] zzyjVarArr) {
        int i2;
        int i8;
        long[][] jArr;
        ArrayList arrayList = new ArrayList();
        int i9 = 0;
        int i10 = 0;
        while (true) {
            i2 = 1;
            if (i10 >= 2) {
                break;
            }
            zzyj zzyjVar = zzyjVarArr[i10];
            if (zzyjVar == null || zzyjVar.zzb.length <= 1) {
                arrayList.add(null);
            } else {
                int i11 = zzgpe.zzd;
                zzgpb zzgpbVar = new zzgpb();
                zzgpbVar.zzf(new zzxa(0L, 0L));
                arrayList.add(zzgpbVar);
            }
            i10++;
        }
        long[][] jArr2 = new long[2][];
        for (int i12 = 0; i12 < 2; i12++) {
            zzyj zzyjVar2 = zzyjVarArr[i12];
            if (zzyjVar2 == null) {
                jArr2[i12] = new long[0];
            } else {
                int[] iArr = zzyjVar2.zzb;
                jArr2[i12] = new long[iArr.length];
                for (int i13 = 0; i13 < iArr.length; i13++) {
                    long j = zzyjVar2.zza.zza(iArr[i13]).zzj;
                    long[] jArr3 = jArr2[i12];
                    if (j == -1) {
                        j = 0;
                    }
                    jArr3[i13] = j;
                }
                Arrays.sort(jArr2[i12]);
            }
        }
        int[] iArr2 = new int[2];
        long[] jArr4 = new long[2];
        for (int i14 = 0; i14 < 2; i14++) {
            long[] jArr5 = jArr2[i14];
            jArr4[i14] = jArr5.length == 0 ? 0L : jArr5[0];
        }
        zzi(arrayList, jArr4);
        zzgpz zzgpzVarZza = zzgqt.zzc(zzgqy.zzb()).zzb(2).zza();
        int i15 = 0;
        while (i15 < 2) {
            int length = jArr2[i15].length;
            if (length <= i2) {
                i8 = i9;
                jArr = jArr2;
            } else {
                double[] dArr = new double[length];
                int i16 = i9;
                while (true) {
                    long[] jArr6 = jArr2[i15];
                    double dLog = 0.0d;
                    if (i16 >= jArr6.length) {
                        break;
                    }
                    int i17 = i9;
                    long[][] jArr7 = jArr2;
                    long j3 = jArr6[i16];
                    if (j3 != -1) {
                        dLog = Math.log(j3);
                    }
                    dArr[i16] = dLog;
                    i16++;
                    i9 = i17;
                    jArr2 = jArr7;
                }
                i8 = i9;
                jArr = jArr2;
                int i18 = length - 1;
                double d8 = dArr[i18] - dArr[i8];
                int i19 = i8;
                while (i19 < i18) {
                    double d9 = dArr[i19];
                    i19++;
                    zzgpzVarZza.zze(Double.valueOf(d8 == 0.0d ? 1.0d : (((d9 + dArr[i19]) * 0.5d) - dArr[i8]) / d8), Integer.valueOf(i15));
                    i2 = i2;
                }
            }
            i15++;
            i9 = i8;
            jArr2 = jArr;
            i2 = i2;
        }
        int i20 = i9;
        long[][] jArr8 = jArr2;
        zzgpe zzgpeVarZzq = zzgpe.zzq(zzgpzVarZza.zzt());
        for (int i21 = i20; i21 < zzgpeVarZzq.size(); i21++) {
            int iIntValue = ((Integer) zzgpeVarZzq.get(i21)).intValue();
            int i22 = iArr2[iIntValue] + 1;
            iArr2[iIntValue] = i22;
            jArr4[iIntValue] = jArr8[iIntValue][i22];
            zzi(arrayList, jArr4);
        }
        for (int i23 = i20; i23 < 2; i23++) {
            if (arrayList.get(i23) != null) {
                long j8 = jArr4[i23];
                jArr4[i23] = j8 + j8;
            }
        }
        zzi(arrayList, jArr4);
        zzgpb zzgpbVar2 = new zzgpb();
        while (i20 < arrayList.size()) {
            zzgpb zzgpbVar3 = (zzgpb) arrayList.get(i20);
            zzgpbVar2.zzf(zzgpbVar3 == null ? zzgpe.zzi() : zzgpbVar3.zzi());
            i20++;
        }
        return zzgpbVar2.zzi();
    }

    private static void zzi(List list, long[] jArr) {
        long j = 0;
        for (int i2 = 0; i2 < 2; i2++) {
            j += jArr[i2];
        }
        for (int i8 = 0; i8 < list.size(); i8++) {
            zzgpb zzgpbVar = (zzgpb) list.get(i8);
            if (zzgpbVar != null) {
                zzgpbVar.zzf(new zzxa(j, jArr[i8]));
            }
        }
    }
}
