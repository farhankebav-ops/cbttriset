package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbkt implements zzblx {
    @Override // com.google.android.gms.internal.ads.zzblx
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject jSONObjectZzd;
        zzcgy zzcgyVar = (zzcgy) obj;
        zzbhv zzbhvVarZzar = zzcgyVar.zzar();
        if (zzbhvVarZzar == null || (jSONObjectZzd = zzbhvVarZzar.zzd()) == null) {
            zzcgyVar.zzd("nativeClickMetaReady", new JSONObject());
        } else {
            zzcgyVar.zzd("nativeClickMetaReady", jSONObjectZzd);
        }
    }
}
