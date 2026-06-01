package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbla implements zzblx {
    @Override // com.google.android.gms.internal.ads.zzblx
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcgy zzcgyVar = (zzcgy) obj;
        try {
            String str = (String) map.get("enabled");
            zzblx zzblxVar = zzblw.zza;
            if (!zzglm.zze(com.ironsource.mediationsdk.metadata.a.g, str) && !zzglm.zze("false", str)) {
                return;
            }
            zzfwu.zza(zzcgyVar.getContext()).zzd(Boolean.parseBoolean(str));
        } catch (IOException e) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "DefaultGmsgHandlers.SetPaidv2PersonalizationEnabled");
        }
    }
}
