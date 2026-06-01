package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdkm {
    private final JSONObject zza;
    private final zzdqt zzb;

    @Nullable
    private final com.google.android.gms.ads.internal.zzb zzc;

    @Nullable
    private final zzbzt zzd;

    public zzdkm(JSONObject jSONObject, zzdqt zzdqtVar, @Nullable com.google.android.gms.ads.internal.zzb zzbVar, @Nullable zzbzt zzbztVar) {
        this.zza = jSONObject;
        this.zzb = zzdqtVar;
        this.zzc = zzbVar;
        this.zzd = zzbztVar;
    }

    @Nullable
    public final com.google.android.gms.ads.internal.zzb zza() {
        return this.zzc;
    }

    @Nullable
    public final zzbzt zzb() {
        return this.zzd;
    }

    public final JSONObject zzc() {
        return this.zza;
    }

    public final zzdqt zzd() {
        return this.zzb;
    }
}
