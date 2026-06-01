package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbvo {
    public final boolean zza;
    public final String zzb;
    public final boolean zzc;

    public zzbvo(boolean z2, String str, boolean z7) {
        this.zza = z2;
        this.zzb = str;
        this.zzc = z7;
    }

    @Nullable
    public static zzbvo zza(JSONObject jSONObject) {
        return new zzbvo(jSONObject.optBoolean("enable_prewarming", false), jSONObject.optString("prefetch_url", ""), jSONObject.optBoolean("skip_offline_notification_flow", false));
    }
}
