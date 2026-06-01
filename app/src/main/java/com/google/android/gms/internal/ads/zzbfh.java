package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class zzbfh {
    private final Map zza = new HashMap();
    private final zzbfj zzb;

    public zzbfh(zzbfj zzbfjVar) {
        this.zzb = zzbfjVar;
    }

    public final void zza(String str, @Nullable zzbfg zzbfgVar) {
        this.zza.put(str, zzbfgVar);
    }

    public final void zzb(String str, String str2, long j) {
        Map map = this.zza;
        zzbfg zzbfgVar = (zzbfg) map.get(str2);
        String[] strArr = {str};
        if (zzbfgVar != null) {
            this.zzb.zzb(zzbfgVar, j, strArr);
        }
        map.put(str, new zzbfg(j, null, null));
    }

    public final zzbfj zzc() {
        return this.zzb;
    }
}
