package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzacn {
    public static void zza(long j, zzeg zzegVar, zzaem[] zzaemVarArr) {
        int iZzB;
        while (true) {
            if (zzegVar.zzd() <= 1) {
                return;
            }
            int iZzc = zzc(zzegVar);
            int iZzc2 = zzc(zzegVar);
            int iZzg = zzegVar.zzg() + iZzc2;
            if (iZzc2 == -1 || iZzc2 > zzegVar.zzd()) {
                zzdt.zzc("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                iZzg = zzegVar.zze();
            } else if (iZzc == 4 && iZzc2 >= 8) {
                int iZzs = zzegVar.zzs();
                int iZzt = zzegVar.zzt();
                if (iZzt == 49) {
                    iZzB = zzegVar.zzB();
                    iZzt = 49;
                } else {
                    iZzB = 0;
                }
                int iZzs2 = zzegVar.zzs();
                if (iZzt == 47) {
                    zzegVar.zzk(1);
                    iZzt = 47;
                }
                boolean z2 = iZzs == 181 && (iZzt == 49 || iZzt == 47) && iZzs2 == 3;
                if (iZzt == 49) {
                    z2 &= iZzB == 1195456820;
                }
                if (z2) {
                    zzb(j, zzegVar, zzaemVarArr);
                }
            }
            zzegVar.zzh(iZzg);
        }
    }

    public static void zzb(long j, zzeg zzegVar, zzaem[] zzaemVarArr) {
        int iZzs = zzegVar.zzs();
        if ((iZzs & 64) != 0) {
            int i2 = iZzs & 31;
            zzegVar.zzk(1);
            int iZzg = zzegVar.zzg();
            for (zzaem zzaemVar : zzaemVarArr) {
                int i8 = i2 * 3;
                zzegVar.zzh(iZzg);
                zzaemVar.zzz(zzegVar, i8);
                zzgmd.zzh(j != -9223372036854775807L);
                zzaemVar.zzx(j, 1, i8, 0, null);
            }
        }
    }

    private static int zzc(zzeg zzegVar) {
        int i2 = 0;
        while (zzegVar.zzd() != 0) {
            int iZzs = zzegVar.zzs();
            i2 += iZzs;
            if (iZzs != 255) {
                return i2;
            }
        }
        return -1;
    }
}
