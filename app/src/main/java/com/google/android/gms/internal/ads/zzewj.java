package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzewj implements zzexy {
    private final Map zza;

    public zzewj(Map map) {
        this.zza = map;
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Map map = this.zza;
        zzcxq zzcxqVar = (zzcxq) obj;
        if (map.isEmpty()) {
            return;
        }
        Bundle bundle = zzcxqVar.zza;
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry entry : map.entrySet()) {
            ArrayDeque arrayDeque = (ArrayDeque) entry.getValue();
            if (!arrayDeque.isEmpty()) {
                zzdwo zzdwoVar = (zzdwo) entry.getKey();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", zzdwoVar.zza());
                    jSONObject.put("event_type", zzdwoVar.zzb());
                    JSONArray jSONArray2 = new JSONArray();
                    Iterator it = arrayDeque.iterator();
                    while (it.hasNext()) {
                        jSONArray2.put((Long) it.next());
                    }
                    jSONObject.put("timestamps", jSONArray2);
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    com.google.android.gms.ads.internal.util.zze.zzb("Failed putting the on-device storage record.", e);
                }
            }
        }
        if (jSONArray.length() > 0) {
            bundle.putString("on_device_storage_records", jSONArray.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* synthetic */ void zzb(Object obj) {
        p.a(this, obj);
    }
}
