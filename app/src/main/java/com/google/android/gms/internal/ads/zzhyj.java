package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhyj {
    private static final zzhyj zza = new zzhyj();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzhys zzb = new zzhxq();

    private zzhyj() {
    }

    public static zzhyj zza() {
        return zza;
    }

    public final zzhyr zzb(Class cls) {
        zzhxb.zza(cls, "messageType");
        ConcurrentMap concurrentMap = this.zzc;
        zzhyr zzhyrVarZza = (zzhyr) concurrentMap.get(cls);
        if (zzhyrVarZza == null) {
            zzhyrVarZza = this.zzb.zza(cls);
            zzhxb.zza(cls, "messageType");
            zzhyr zzhyrVar = (zzhyr) concurrentMap.putIfAbsent(cls, zzhyrVarZza);
            if (zzhyrVar != null) {
                return zzhyrVar;
            }
        }
        return zzhyrVarZza;
    }
}
