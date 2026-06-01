package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzyo extends zzyr {
    public abstract Pair zzh(zzyn zzynVar, int[][][] iArr, int[] iArr2, zzuu zzuuVar, zzbf zzbfVar) throws zzib;

    @Override // com.google.android.gms.internal.ads.zzyr
    public final void zzp(@Nullable Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzyr
    public final zzys zzq(zzlp[] zzlpVarArr, zzwv zzwvVar, zzuu zzuuVar, zzbf zzbfVar) throws zzib {
        List[] listArr;
        boolean z2;
        int[] iArr;
        int[] iArr2 = new int[3];
        zzbg[][] zzbgVarArr = new zzbg[3][];
        int[][][] iArr3 = new int[3][][];
        for (int i2 = 0; i2 < 3; i2++) {
            int i8 = zzwvVar.zzb;
            zzbgVarArr[i2] = new zzbg[i8];
            iArr3[i2] = new int[i8][];
        }
        int i9 = 2;
        int[] iArr4 = new int[2];
        for (int i10 = 0; i10 < 2; i10++) {
            iArr4[i10] = zzlpVarArr[i10].zzu();
        }
        int i11 = 0;
        while (i11 < zzwvVar.zzb) {
            zzbg zzbgVarZza = zzwvVar.zza(i11);
            int i12 = zzbgVarZza.zzc;
            int i13 = i9;
            int i14 = 0;
            int i15 = 0;
            boolean z7 = true;
            while (i14 < i9) {
                zzlp zzlpVar = zzlpVarArr[i14];
                int iMax = 0;
                for (int i16 = 0; i16 < zzbgVarZza.zza; i16++) {
                    iMax = Math.max(iMax, zzlpVar.zzab(zzbgVarZza.zza(i16)) & 7);
                }
                boolean z8 = iArr2[i14] == 0;
                if (iMax > i15) {
                    z7 = z8;
                    i13 = i14;
                    i15 = iMax;
                } else if (iMax == i15 && i12 == 5 && !z7 && z8) {
                    i13 = i14;
                    i15 = iMax;
                    z7 = true;
                }
                i14++;
                i9 = 2;
            }
            if (i13 == i9) {
                iArr = new int[zzbgVarZza.zza];
            } else {
                zzlp zzlpVar2 = zzlpVarArr[i13];
                int i17 = zzbgVarZza.zza;
                int[] iArr5 = new int[i17];
                for (int i18 = 0; i18 < i17; i18++) {
                    iArr5[i18] = zzlpVar2.zzab(zzbgVarZza.zza(i18));
                }
                iArr = iArr5;
            }
            int i19 = iArr2[i13];
            zzbgVarArr[i13][i19] = zzbgVarZza;
            iArr3[i13][i19] = iArr;
            iArr2[i13] = i19 + 1;
            i11++;
            i9 = 2;
        }
        zzwv[] zzwvVarArr = new zzwv[i9];
        String[] strArr = new String[i9];
        int[] iArr6 = new int[i9];
        int i20 = 0;
        while (i20 < i9) {
            int i21 = iArr2[i20];
            zzwvVarArr[i20] = new zzwv((zzbg[]) zzep.zzb(zzbgVarArr[i20], i21));
            iArr3[i20] = (int[][]) zzep.zzb(iArr3[i20], i21);
            strArr[i20] = zzlpVarArr[i20].zzS();
            iArr6[i20] = zzlpVarArr[i20].zza();
            i20++;
            i9 = 2;
        }
        int i22 = i9;
        zzyn zzynVar = new zzyn(strArr, iArr6, zzwvVarArr, iArr4, iArr3, new zzwv((zzbg[]) zzep.zzb(zzbgVarArr[i22], iArr2[i22])));
        Pair pairZzh = zzh(zzynVar, iArr3, iArr4, zzuuVar, zzbfVar);
        zzyp[] zzypVarArr = (zzyp[]) pairZzh.second;
        List[] listArr2 = new List[zzypVarArr.length];
        for (int i23 = 0; i23 < zzypVarArr.length; i23++) {
            zzyp zzypVar = zzypVarArr[i23];
            listArr2[i23] = zzypVar != null ? zzgpe.zzj(zzypVar) : zzgpe.zzi();
        }
        zzgpb zzgpbVar = new zzgpb();
        for (int i24 = 0; i24 < 2; i24++) {
            zzwv zzwvVarZzb = zzynVar.zzb(i24);
            List list = listArr2[i24];
            int i25 = 0;
            while (i25 < zzwvVarZzb.zzb) {
                zzbg zzbgVarZza2 = zzwvVarZzb.zza(i25);
                boolean z9 = zzynVar.zzd(i24, i25, false) != 0;
                int i26 = zzbgVarZza2.zza;
                int[] iArr7 = new int[i26];
                boolean[] zArr = new boolean[i26];
                int i27 = 0;
                while (i27 < i26) {
                    iArr7[i27] = zzynVar.zzc(i24, i25, i27) & 7;
                    int i28 = 0;
                    while (true) {
                        if (i28 >= list.size()) {
                            listArr = listArr2;
                            z2 = false;
                            break;
                        }
                        zzyp zzypVar2 = (zzyp) list.get(i28);
                        listArr = listArr2;
                        if (zzypVar2.zza().equals(zzbgVarZza2) && zzypVar2.zzg(i27) != -1) {
                            z2 = true;
                            break;
                        }
                        i28++;
                        listArr2 = listArr;
                    }
                    zArr[i27] = z2;
                    i27++;
                    listArr2 = listArr;
                }
                zzgpbVar.zzf(new zzbm(zzbgVarZza2, z9, iArr7, zArr));
                i25++;
                listArr2 = listArr2;
            }
        }
        zzwv zzwvVarZze = zzynVar.zze();
        for (int i29 = 0; i29 < zzwvVarZze.zzb; i29++) {
            zzbg zzbgVarZza3 = zzwvVarZze.zza(i29);
            int i30 = zzbgVarZza3.zza;
            int[] iArr8 = new int[i30];
            Arrays.fill(iArr8, 0);
            zzgpbVar.zzf(new zzbm(zzbgVarZza3, false, iArr8, new boolean[i30]));
        }
        return new zzys((zzlq[]) pairZzh.first, (zzyk[]) pairZzh.second, new zzbn(zzgpbVar.zzi()), zzynVar);
    }
}
