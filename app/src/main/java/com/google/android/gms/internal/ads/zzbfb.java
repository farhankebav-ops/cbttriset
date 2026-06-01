package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class zzbfb {
    public static boolean zza(@Nullable zzbfj zzbfjVar, @Nullable zzbfg zzbfgVar, String... strArr) {
        if (zzbfgVar == null) {
            return false;
        }
        zzbfjVar.zzb(zzbfgVar, com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime(), strArr);
        return true;
    }
}
