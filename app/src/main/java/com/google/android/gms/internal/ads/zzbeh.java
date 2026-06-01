package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbeh extends zzbel {
    public zzbeh(int i2, String str, Integer num, Integer num2) {
        super(1, str, num, num2, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbel
    public final /* bridge */ /* synthetic */ Object zza(Bundle bundle) {
        return bundle.containsKey("com.google.android.gms.ads.flag.".concat(zze())) ? Integer.valueOf(bundle.getInt("com.google.android.gms.ads.flag.".concat(zze()))) : (Integer) zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzbel
    public final /* bridge */ /* synthetic */ void zzb(SharedPreferences.Editor editor, Object obj) {
        editor.putInt(zze(), ((Integer) obj).intValue());
    }

    @Override // com.google.android.gms.internal.ads.zzbel
    public final /* bridge */ /* synthetic */ Object zzc(JSONObject jSONObject) {
        return Integer.valueOf(jSONObject.optInt(zze(), ((Integer) zzf()).intValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzbel
    public final /* bridge */ /* synthetic */ Object zzd(SharedPreferences sharedPreferences) {
        return Integer.valueOf(sharedPreferences.getInt(zze(), ((Integer) zzf()).intValue()));
    }
}
