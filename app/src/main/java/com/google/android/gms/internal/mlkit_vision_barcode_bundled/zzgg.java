package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.google.android.gms.ads.internal.client.a;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgg {
    public static final /* synthetic */ int zza = 0;
    private static final zzgs zzb;

    static {
        int i2 = zzfu.zza;
        zzb = new zzgu();
    }

    public static void zzA(int i2, List list, zzhh zzhhVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzC(i2, list, z2);
    }

    public static void zzB(int i2, List list, zzhh zzhhVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzE(i2, list, z2);
    }

    public static void zzC(int i2, List list, zzhh zzhhVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzJ(i2, list, z2);
    }

    public static void zzD(int i2, List list, zzhh zzhhVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzL(i2, list, z2);
    }

    public static boolean zzE(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int zza(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzei)) {
            int iZzB = 0;
            while (i2 < size) {
                iZzB += zzdn.zzB(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iZzB;
        }
        zzei zzeiVar = (zzei) list;
        int iZzB2 = 0;
        while (i2 < size) {
            iZzB2 += zzdn.zzB(zzeiVar.zze(i2));
            i2++;
        }
        return iZzB2;
    }

    public static int zzb(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzdn.zzA(i2 << 3) + 4) * size;
    }

    public static int zzc(List list) {
        return list.size() * 4;
    }

    public static int zzd(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzdn.zzA(i2 << 3) + 8) * size;
    }

    public static int zze(List list) {
        return list.size() * 8;
    }

    public static int zzf(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzei)) {
            int iZzB = 0;
            while (i2 < size) {
                iZzB += zzdn.zzB(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iZzB;
        }
        zzei zzeiVar = (zzei) list;
        int iZzB2 = 0;
        while (i2 < size) {
            iZzB2 += zzdn.zzB(zzeiVar.zze(i2));
            i2++;
        }
        return iZzB2;
    }

    public static int zzg(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfb)) {
            int iZzB = 0;
            while (i2 < size) {
                iZzB += zzdn.zzB(((Long) list.get(i2)).longValue());
                i2++;
            }
            return iZzB;
        }
        zzfb zzfbVar = (zzfb) list;
        int iZzB2 = 0;
        while (i2 < size) {
            iZzB2 += zzdn.zzB(zzfbVar.zze(i2));
            i2++;
        }
        return iZzB2;
    }

    public static int zzh(int i2, Object obj, zzge zzgeVar) {
        int i8 = i2 << 3;
        if (!(obj instanceof zzex)) {
            return zzdn.zzy((zzfm) obj, zzgeVar) + zzdn.zzA(i8);
        }
        int iZzA = zzdn.zzA(i8);
        int iZza = ((zzex) obj).zza();
        return a.C(iZza, iZza, iZzA);
    }

    public static int zzi(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzei)) {
            int iZzA = 0;
            while (i2 < size) {
                int iIntValue = ((Integer) list.get(i2)).intValue();
                iZzA += zzdn.zzA((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i2++;
            }
            return iZzA;
        }
        zzei zzeiVar = (zzei) list;
        int iZzA2 = 0;
        while (i2 < size) {
            int iZze = zzeiVar.zze(i2);
            iZzA2 += zzdn.zzA((iZze >> 31) ^ (iZze + iZze));
            i2++;
        }
        return iZzA2;
    }

    public static int zzj(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfb)) {
            int iZzB = 0;
            while (i2 < size) {
                long jLongValue = ((Long) list.get(i2)).longValue();
                iZzB += zzdn.zzB((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i2++;
            }
            return iZzB;
        }
        zzfb zzfbVar = (zzfb) list;
        int iZzB2 = 0;
        while (i2 < size) {
            long jZze = zzfbVar.zze(i2);
            iZzB2 += zzdn.zzB((jZze >> 63) ^ (jZze + jZze));
            i2++;
        }
        return iZzB2;
    }

    public static int zzk(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzei)) {
            int iZzA = 0;
            while (i2 < size) {
                iZzA += zzdn.zzA(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iZzA;
        }
        zzei zzeiVar = (zzei) list;
        int iZzA2 = 0;
        while (i2 < size) {
            iZzA2 += zzdn.zzA(zzeiVar.zze(i2));
            i2++;
        }
        return iZzA2;
    }

    public static int zzl(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfb)) {
            int iZzB = 0;
            while (i2 < size) {
                iZzB += zzdn.zzB(((Long) list.get(i2)).longValue());
                i2++;
            }
            return iZzB;
        }
        zzfb zzfbVar = (zzfb) list;
        int iZzB2 = 0;
        while (i2 < size) {
            iZzB2 += zzdn.zzB(zzfbVar.zze(i2));
            i2++;
        }
        return iZzB2;
    }

    public static zzgs zzm() {
        return zzb;
    }

    public static Object zzn(Object obj, int i2, int i8, Object obj2, zzgs zzgsVar) {
        Object obj3 = obj2;
        if (obj2 == null) {
            zzeh zzehVar = (zzeh) obj;
            zzgt zzgtVar = zzehVar.zzc;
            obj3 = zzgtVar;
            if (zzgtVar == zzgt.zzc()) {
                zzgt zzgtVarZzf = zzgt.zzf();
                zzehVar.zzc = zzgtVarZzf;
                obj3 = zzgtVarZzf;
            }
        }
        ((zzgt) obj3).zzj(i2 << 3, Long.valueOf(i8));
        return obj3;
    }

    public static void zzo(zzdt zzdtVar, Object obj, Object obj2) {
        zzdx zzdxVar = ((zzed) obj2).zzb;
        if (zzdxVar.zza.isEmpty()) {
            return;
        }
        ((zzed) obj).zzc().zzh(zzdxVar);
    }

    public static void zzp(zzgs zzgsVar, Object obj, Object obj2) {
        zzeh zzehVar = (zzeh) obj;
        zzgt zzgtVarZze = zzehVar.zzc;
        zzgt zzgtVar = ((zzeh) obj2).zzc;
        if (!zzgt.zzc().equals(zzgtVar)) {
            if (zzgt.zzc().equals(zzgtVarZze)) {
                zzgtVarZze = zzgt.zze(zzgtVarZze, zzgtVar);
            } else {
                zzgtVarZze.zzd(zzgtVar);
            }
        }
        zzehVar.zzc = zzgtVarZze;
    }

    public static void zzq(int i2, List list, zzhh zzhhVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzc(i2, list, z2);
    }

    public static void zzr(int i2, List list, zzhh zzhhVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzg(i2, list, z2);
    }

    public static void zzs(int i2, List list, zzhh zzhhVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzj(i2, list, z2);
    }

    public static void zzt(int i2, List list, zzhh zzhhVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzl(i2, list, z2);
    }

    public static void zzu(int i2, List list, zzhh zzhhVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzn(i2, list, z2);
    }

    public static void zzv(int i2, List list, zzhh zzhhVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzp(i2, list, z2);
    }

    public static void zzw(int i2, List list, zzhh zzhhVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzs(i2, list, z2);
    }

    public static void zzx(int i2, List list, zzhh zzhhVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzu(i2, list, z2);
    }

    public static void zzy(int i2, List list, zzhh zzhhVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzy(i2, list, z2);
    }

    public static void zzz(int i2, List list, zzhh zzhhVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzA(i2, list, z2);
    }
}
