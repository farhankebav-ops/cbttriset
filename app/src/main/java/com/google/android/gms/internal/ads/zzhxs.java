package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhxs {
    private final zzhxr zza;

    private zzhxs(zzhzp zzhzpVar, Object obj, zzhzp zzhzpVar2, Object obj2) {
        this.zza = new zzhxr(zzhzpVar, "", zzhzpVar2, obj2);
    }

    public static zzhxs zza(zzhzp zzhzpVar, Object obj, zzhzp zzhzpVar2, Object obj2) {
        return new zzhxs(zzhzpVar, "", zzhzpVar2, obj2);
    }

    public static void zzb(zzhvt zzhvtVar, zzhxr zzhxrVar, Object obj, Object obj2) throws IOException {
        zzhwd.zzf(zzhvtVar, zzhxrVar.zza, 1, obj);
        zzhwd.zzf(zzhvtVar, zzhxrVar.zzc, 2, obj2);
    }

    public static int zzc(zzhxr zzhxrVar, Object obj, Object obj2) {
        return zzhwd.zzh(zzhxrVar.zza, 1, obj) + zzhwd.zzh(zzhxrVar.zzc, 2, obj2);
    }

    public final int zzd(int i2, Object obj, Object obj2) {
        zzhxr zzhxrVar = this.zza;
        int iZzA = zzhvt.zzA(i2 << 3);
        int iZzc = zzc(zzhxrVar, obj, obj2);
        return com.google.android.gms.ads.internal.client.a.b(iZzc, iZzc, iZzA);
    }

    public final zzhxr zze() {
        return this.zza;
    }
}
