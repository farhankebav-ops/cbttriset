package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhyt {
    public static final /* synthetic */ int zza = 0;
    private static final zzhzc zzb;

    static {
        int i2 = zzhuv.zza;
        zzb = new zzhze();
    }

    public static int zzA(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzhvt.zzA(i2 << 3) + 4) * size;
    }

    public static int zzB(List list) {
        return list.size() * 8;
    }

    public static int zzC(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzhvt.zzA(i2 << 3) + 8) * size;
    }

    public static int zzD(int i2, Object obj, zzhyr zzhyrVar) {
        int i8 = i2 << 3;
        if (obj instanceof zzhxj) {
            int iZzA = zzhvt.zzA(i8);
            int iZzb = ((zzhxj) obj).zzb();
            return com.google.android.gms.ads.internal.client.a.b(iZzb, iZzb, iZzA);
        }
        int iZzA2 = zzhvt.zzA(i8);
        int iZzaT = ((zzhur) obj).zzaT(zzhyrVar);
        return com.google.android.gms.ads.internal.client.a.b(iZzaT, iZzaT, iZzA2);
    }

    @Deprecated
    public static int zzE(int i2, zzhxz zzhxzVar, zzhyr zzhyrVar) {
        int iZzA = zzhvt.zzA(i2 << 3);
        return ((zzhur) zzhxzVar).zzaT(zzhyrVar) + iZzA + iZzA;
    }

    public static zzhzc zzF() {
        return zzb;
    }

    public static boolean zzG(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void zzH(zzhvz zzhvzVar, Object obj, Object obj2) {
        if (((zzhwk) obj2).zza.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    public static void zzI(zzhzc zzhzcVar, Object obj, Object obj2) {
        zzhwo zzhwoVar = (zzhwo) obj;
        zzhzd zzhzdVarZzc = zzhwoVar.zzt;
        zzhzd zzhzdVar = ((zzhwo) obj2).zzt;
        if (!zzhzd.zza().equals(zzhzdVar)) {
            if (zzhzd.zza().equals(zzhzdVarZzc)) {
                zzhzdVarZzc = zzhzd.zzc(zzhzdVarZzc, zzhzdVar);
            } else {
                zzhzdVarZzc.zzm(zzhzdVar);
            }
        }
        zzhwoVar.zzt = zzhzdVarZzc;
    }

    public static Object zzJ(Object obj, int i2, List list, zzhwu zzhwuVar, Object obj2, zzhzc zzhzcVar) {
        if (zzhwuVar == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!zzhwuVar.zza(iIntValue)) {
                    obj2 = zzK(obj, i2, iIntValue, obj2, zzhzcVar);
                    it.remove();
                }
            }
            return obj2;
        }
        int size = list.size();
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            Integer num = (Integer) list.get(i9);
            int iIntValue2 = num.intValue();
            if (zzhwuVar.zza(iIntValue2)) {
                if (i9 != i8) {
                    list.set(i8, num);
                }
                i8++;
            } else {
                obj2 = zzK(obj, i2, iIntValue2, obj2, zzhzcVar);
            }
        }
        if (i8 != size) {
            list.subList(i8, size).clear();
        }
        return obj2;
    }

    public static Object zzK(Object obj, int i2, int i8, Object obj2, zzhzc zzhzcVar) {
        if (obj2 == null) {
            obj2 = zzhzcVar.zzh(obj);
        }
        zzhzcVar.zza(obj2, i2, i8);
        return obj2;
    }

    public static void zza(int i2, List list, zzhzr zzhzrVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzC(i2, list, z2);
    }

    public static void zzb(int i2, List list, zzhzr zzhzrVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzB(i2, list, z2);
    }

    public static void zzc(int i2, List list, zzhzr zzhzrVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzy(i2, list, z2);
    }

    public static void zzd(int i2, List list, zzhzr zzhzrVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzz(i2, list, z2);
    }

    public static void zze(int i2, List list, zzhzr zzhzrVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzL(i2, list, z2);
    }

    public static void zzf(int i2, List list, zzhzr zzhzrVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzA(i2, list, z2);
    }

    public static void zzg(int i2, List list, zzhzr zzhzrVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzJ(i2, list, z2);
    }

    public static void zzh(int i2, List list, zzhzr zzhzrVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzw(i2, list, z2);
    }

    public static void zzi(int i2, List list, zzhzr zzhzrVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzH(i2, list, z2);
    }

    public static void zzj(int i2, List list, zzhzr zzhzrVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzK(i2, list, z2);
    }

    public static void zzk(int i2, List list, zzhzr zzhzrVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzx(i2, list, z2);
    }

    public static void zzl(int i2, List list, zzhzr zzhzrVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzI(i2, list, z2);
    }

    public static void zzm(int i2, List list, zzhzr zzhzrVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzD(i2, list, z2);
    }

    public static void zzn(int i2, List list, zzhzr zzhzrVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzE(i2, list, z2);
    }

    public static void zzo(int i2, List list, zzhzr zzhzrVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzF(i2, list);
    }

    public static void zzp(int i2, List list, zzhzr zzhzrVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzG(i2, list);
    }

    public static void zzq(int i2, List list, zzhzr zzhzrVar, zzhyr zzhyrVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i8 = 0; i8 < list.size(); i8++) {
            ((zzhvu) zzhzrVar).zzr(i2, list.get(i8), zzhyrVar);
        }
    }

    public static void zzr(int i2, List list, zzhzr zzhzrVar, zzhyr zzhyrVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i8 = 0; i8 < list.size(); i8++) {
            ((zzhvu) zzhzrVar).zzs(i2, list.get(i8), zzhyrVar);
        }
    }

    public static int zzs(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhxn)) {
            int iZzB = 0;
            while (i2 < size) {
                iZzB += zzhvt.zzB(((Long) list.get(i2)).longValue());
                i2++;
            }
            return iZzB;
        }
        zzhxn zzhxnVar = (zzhxn) list;
        int iZzB2 = 0;
        while (i2 < size) {
            iZzB2 += zzhvt.zzB(zzhxnVar.zzc(i2));
            i2++;
        }
        return iZzB2;
    }

    public static int zzt(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhxn)) {
            int iZzB = 0;
            while (i2 < size) {
                iZzB += zzhvt.zzB(((Long) list.get(i2)).longValue());
                i2++;
            }
            return iZzB;
        }
        zzhxn zzhxnVar = (zzhxn) list;
        int iZzB2 = 0;
        while (i2 < size) {
            iZzB2 += zzhvt.zzB(zzhxnVar.zzc(i2));
            i2++;
        }
        return iZzB2;
    }

    public static int zzu(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhxn)) {
            int iZzB = 0;
            while (i2 < size) {
                long jLongValue = ((Long) list.get(i2)).longValue();
                iZzB += zzhvt.zzB((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i2++;
            }
            return iZzB;
        }
        zzhxn zzhxnVar = (zzhxn) list;
        int iZzB2 = 0;
        while (i2 < size) {
            long jZzc = zzhxnVar.zzc(i2);
            iZzB2 += zzhvt.zzB((jZzc >> 63) ^ (jZzc + jZzc));
            i2++;
        }
        return iZzB2;
    }

    public static int zzv(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhwp)) {
            int iZzB = 0;
            while (i2 < size) {
                iZzB += zzhvt.zzB(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iZzB;
        }
        zzhwp zzhwpVar = (zzhwp) list;
        int iZzB2 = 0;
        while (i2 < size) {
            iZzB2 += zzhvt.zzB(zzhwpVar.zzf(i2));
            i2++;
        }
        return iZzB2;
    }

    public static int zzw(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhwp)) {
            int iZzB = 0;
            while (i2 < size) {
                iZzB += zzhvt.zzB(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iZzB;
        }
        zzhwp zzhwpVar = (zzhwp) list;
        int iZzB2 = 0;
        while (i2 < size) {
            iZzB2 += zzhvt.zzB(zzhwpVar.zzf(i2));
            i2++;
        }
        return iZzB2;
    }

    public static int zzx(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhwp)) {
            int iZzA = 0;
            while (i2 < size) {
                iZzA += zzhvt.zzA(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iZzA;
        }
        zzhwp zzhwpVar = (zzhwp) list;
        int iZzA2 = 0;
        while (i2 < size) {
            iZzA2 += zzhvt.zzA(zzhwpVar.zzf(i2));
            i2++;
        }
        return iZzA2;
    }

    public static int zzy(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhwp)) {
            int iZzA = 0;
            while (i2 < size) {
                int iIntValue = ((Integer) list.get(i2)).intValue();
                iZzA += zzhvt.zzA((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i2++;
            }
            return iZzA;
        }
        zzhwp zzhwpVar = (zzhwp) list;
        int iZzA2 = 0;
        while (i2 < size) {
            int iZzf = zzhwpVar.zzf(i2);
            iZzA2 += zzhvt.zzA((iZzf >> 31) ^ (iZzf + iZzf));
            i2++;
        }
        return iZzA2;
    }

    public static int zzz(List list) {
        return list.size() * 4;
    }
}
