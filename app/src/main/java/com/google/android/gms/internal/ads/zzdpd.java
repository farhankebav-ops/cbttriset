package com.google.android.gms.internal.ads;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdpd {
    private final Executor zza;
    private final zzdoy zzb;
    private final zzdvc zzc;

    public zzdpd(Executor executor, zzdoy zzdoyVar, zzdvc zzdvcVar) {
        this.zza = executor;
        this.zzb = zzdoyVar;
        this.zzc = zzdvcVar;
    }

    public final j2.q zza(JSONObject jSONObject, String str) {
        j2.q qVarZza;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("custom_assets");
        if (jSONArrayOptJSONArray == null) {
            return zzgui.zza(Collections.EMPTY_LIST);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcC)).booleanValue()) {
            com.google.android.gms.ads.internal.client.a.m(this.zzc.zze(), zzduq.NATIVE_ASSETS_LOADING_CUSTOM_START.zza());
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArrayOptJSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject == null) {
                qVarZza = zzgui.zza(null);
            } else {
                final String strOptString = jSONObjectOptJSONObject.optString("name");
                if (strOptString == null) {
                    qVarZza = zzgui.zza(null);
                } else {
                    String strOptString2 = jSONObjectOptJSONObject.optString("type");
                    qVarZza = TypedValues.Custom.S_STRING.equals(strOptString2) ? zzgui.zza(new zzdpa(strOptString, jSONObjectOptJSONObject.optString("string_value"))) : "image".equals(strOptString2) ? zzgui.zzk(this.zzb.zza(jSONObjectOptJSONObject, "image_value", null), new zzglu() { // from class: com.google.android.gms.internal.ads.zzdpb
                        @Override // com.google.android.gms.internal.ads.zzglu
                        public final /* synthetic */ Object apply(Object obj) {
                            return new zzdpa(strOptString, (zzbht) obj);
                        }
                    }, this.zza) : zzgui.zza(null);
                }
            }
            arrayList.add(qVarZza);
        }
        return zzgui.zzk(zzgui.zzm(arrayList), zzdpc.zza, this.zza);
    }
}
