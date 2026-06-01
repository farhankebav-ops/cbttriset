package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfqw {
    private JSONObject zza;
    private final zzfrf zzb;

    public zzfqw(zzfrf zzfrfVar) {
        this.zzb = zzfrfVar;
    }

    public final void zza(JSONObject jSONObject, HashSet hashSet, long j) {
        this.zzb.zza(new zzfri(this, hashSet, jSONObject, j));
    }

    public final void zzb(JSONObject jSONObject, HashSet hashSet, long j) {
        this.zzb.zza(new zzfrh(this, hashSet, jSONObject, j));
    }

    public final void zzc() {
        this.zzb.zza(new zzfrg(this));
    }

    @VisibleForTesting
    public final JSONObject zzd() {
        return this.zza;
    }

    @VisibleForTesting
    public final void zze(JSONObject jSONObject) {
        this.zza = jSONObject;
    }
}
