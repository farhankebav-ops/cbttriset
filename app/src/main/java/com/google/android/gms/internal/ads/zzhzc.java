package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzhzc {
    private static volatile int zza = 100;

    public abstract void zza(Object obj, int i2, long j);

    public abstract void zzb(Object obj, int i2, int i8);

    public abstract void zzc(Object obj, int i2, long j);

    public abstract void zzd(Object obj, int i2, zzhvi zzhviVar);

    public abstract void zze(Object obj, int i2, Object obj2);

    public abstract Object zzf();

    public abstract Object zzg(Object obj);

    public abstract Object zzh(Object obj);

    public abstract void zzi(Object obj, Object obj2);

    public abstract void zzj(Object obj);

    public final boolean zzk(Object obj, zzhym zzhymVar, int i2) throws IOException {
        int iZzc = zzhymVar.zzc();
        int i8 = iZzc >>> 3;
        int i9 = iZzc & 7;
        if (i9 == 0) {
            zza(obj, i8, zzhymVar.zzh());
            return true;
        }
        if (i9 == 1) {
            zzc(obj, i8, zzhymVar.zzj());
            return true;
        }
        if (i9 == 2) {
            zzd(obj, i8, zzhymVar.zzq());
            return true;
        }
        if (i9 != 3) {
            if (i9 == 4) {
                if (i2 != 0) {
                    return false;
                }
                throw new zzhxd("Protocol message end-group tag did not match expected tag.");
            }
            if (i9 != 5) {
                throw new zzhxc("Protocol message tag had invalid wire type.");
            }
            zzb(obj, i8, zzhymVar.zzk());
            return true;
        }
        Object objZzf = zzf();
        int i10 = i8 << 3;
        int i11 = i2 + 1;
        if (i11 >= zza) {
            throw new zzhxd("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        while (zzhymVar.zzb() != Integer.MAX_VALUE && zzk(objZzf, zzhymVar, i11)) {
        }
        if ((i10 | 4) != zzhymVar.zzc()) {
            throw new zzhxd("Protocol message end-group tag did not match expected tag.");
        }
        zze(obj, i8, zzg(objZzf));
        return true;
    }
}
