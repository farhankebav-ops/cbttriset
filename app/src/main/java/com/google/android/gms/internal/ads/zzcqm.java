package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcqm implements zzifh {
    private final zzifq zza;

    private zzcqm(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzcqm zza(zzifq zzifqVar) {
        return new zzcqm(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    @Nullable
    public final /* bridge */ /* synthetic */ Object zzb() {
        try {
            return new JSONObject(((zzcuf) this.zza).zza().zzz);
        } catch (JSONException unused) {
            return null;
        }
    }
}
