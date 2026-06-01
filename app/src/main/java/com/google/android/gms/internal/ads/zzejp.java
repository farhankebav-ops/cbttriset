package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzejp implements zzehm {
    private final zzdsy zza;

    public zzejp(zzdsy zzdsyVar) {
        this.zza = zzdsyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzehm
    @Nullable
    public final zzehn zza(String str, JSONObject jSONObject) throws zzfgu {
        return new zzehn(this.zza.zza(str, jSONObject), new zzeiz(), str);
    }
}
