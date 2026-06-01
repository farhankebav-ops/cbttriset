package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class i {
    public static void a(zzbou zzbouVar, String str, JSONObject jSONObject) {
        zzbouVar.zzc(str, jSONObject.toString());
    }

    public static void b(zzbou zzbouVar, String str, String str2) {
        zzbouVar.zza(androidx.camera.core.processing.util.a.n(new StringBuilder(androidx.camera.core.processing.util.a.D(1, String.valueOf(str2).length(), str) + 2), str, "(", str2, ");"));
    }

    public static void c(zzbou zzbouVar, String str, JSONObject jSONObject) {
        StringBuilder sbZ = a1.a.z("(window.AFMA_ReceiveMessage || function() {})('", str, "',", jSONObject.toString(), ");");
        String string = sbZ.toString();
        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzd("Dispatching AFMA event: ".concat(string));
        zzbouVar.zza(sbZ.toString());
    }

    public static void d(zzbou zzbouVar, String str, Map map) {
        try {
            zzbouVar.zzd(str, com.google.android.gms.ads.internal.client.zzbb.zza().zzk(map));
        } catch (JSONException unused) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Could not convert parameters to JSON.");
        }
    }
}
