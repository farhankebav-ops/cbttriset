package com.google.android.gms.internal.ads;

import androidx.constraintlayout.motion.widget.Key;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class zzbun {
    private final zzcgy zza;
    private final String zzb;

    public zzbun(zzcgy zzcgyVar, String str) {
        this.zza = zzcgyVar;
        this.zzb = str;
    }

    public final void zzg(String str) {
        try {
            JSONObject jSONObjectPut = new JSONObject().put("message", str).put("action", this.zzb);
            zzcgy zzcgyVar = this.zza;
            if (zzcgyVar != null) {
                zzcgyVar.zzd("onError", jSONObjectPut);
            }
        } catch (JSONException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Error occurred while dispatching error event.", e);
        }
    }

    public final void zzh(String str) {
        try {
            this.zza.zzd("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Error occurred while dispatching ready Event.", e);
        }
    }

    public final void zzi(int i2, int i8, int i9, int i10) {
        try {
            this.zza.zzd("onSizeChanged", new JSONObject().put("x", i2).put("y", i8).put("width", i9).put("height", i10));
        } catch (JSONException e) {
            int i11 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Error occurred while dispatching size change.", e);
        }
    }

    public final void zzj(int i2, int i8, int i9, int i10) {
        try {
            this.zza.zzd("onDefaultPositionReceived", new JSONObject().put("x", i2).put("y", i8).put("width", i9).put("height", i10));
        } catch (JSONException e) {
            int i11 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Error occurred while dispatching default position.", e);
        }
    }

    public final void zzk(String str) {
        try {
            this.zza.zzd("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Error occurred while dispatching state change.", e);
        }
    }

    public final void zzl(int i2, int i8, int i9, int i10, float f4, int i11) {
        try {
            this.zza.zzd("onScreenInfoChanged", new JSONObject().put("width", i2).put("height", i8).put("maxSizeWidth", i9).put("maxSizeHeight", i10).put("density", f4).put(Key.ROTATION, i11));
        } catch (JSONException e) {
            int i12 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Error occurred while obtaining screen information.", e);
        }
    }
}
