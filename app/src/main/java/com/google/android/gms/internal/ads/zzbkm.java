package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbkm implements zzblx {
    private final zzbkn zza;

    public zzbkm(zzbkn zzbknVar) {
        this.zza = zzbknVar;
    }

    @Override // com.google.android.gms.internal.ads.zzblx
    public final void zza(Object obj, Map map) {
        if (this.zza == null) {
            return;
        }
        String str = (String) map.get("name");
        if (str == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Ad metadata with no name parameter.");
            str = "";
        }
        Bundle bundleZzl = null;
        if (map.containsKey("info")) {
            try {
                bundleZzl = com.google.android.gms.ads.internal.util.zzbp.zzl(new JSONObject((String) map.get("info")));
            } catch (JSONException e) {
                int i8 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Failed to convert ad metadata to JSON.", e);
            }
        }
        if (bundleZzl != null) {
            this.zza.zza(str, bundleZzl);
        } else {
            int i9 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Failed to convert ad metadata to Bundle.");
        }
    }
}
