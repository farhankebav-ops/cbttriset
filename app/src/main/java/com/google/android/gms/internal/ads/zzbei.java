package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbei extends zzbel {
    public zzbei(int i2, String str, Long l, Long l8) {
        super(1, str, l, l8, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbel
    public final /* bridge */ /* synthetic */ Object zza(Bundle bundle) {
        return bundle.containsKey("com.google.android.gms.ads.flag.".concat(zze())) ? Long.valueOf(bundle.getLong("com.google.android.gms.ads.flag.".concat(zze()))) : (Long) zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzbel
    public final /* bridge */ /* synthetic */ void zzb(SharedPreferences.Editor editor, Object obj) {
        editor.putLong(zze(), ((Long) obj).longValue());
    }

    @Override // com.google.android.gms.internal.ads.zzbel
    public final /* bridge */ /* synthetic */ Object zzc(JSONObject jSONObject) {
        return Long.valueOf(jSONObject.optLong(zze(), ((Long) zzf()).longValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzbel
    public final /* bridge */ /* synthetic */ Object zzd(SharedPreferences sharedPreferences) {
        return Long.valueOf(sharedPreferences.getLong(zze(), ((Long) zzf()).longValue()));
    }
}
