package com.google.android.gms.ads.internal.util.client;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzw {
    public static zzw zzd(@Nullable JSONObject jSONObject) {
        return new zzm(jSONObject.optInt("impression_prerequisite", 0), jSONObject.optInt("click_prerequisite", 0), jSONObject.optBoolean("notification_flow_enabled", false));
    }

    public abstract int zza();

    public abstract int zzb();

    public abstract boolean zzc();
}
