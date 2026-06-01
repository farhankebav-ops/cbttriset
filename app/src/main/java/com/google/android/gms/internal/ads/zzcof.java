package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcof implements zzcnv {
    private final zzdyo zza;

    public zzcof(zzdyo zzdyoVar) {
        this.zza = zzdyoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcnv
    public final void zza(JSONObject jSONObject) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzkj)).booleanValue()) {
            this.zza.zzp(jSONObject);
        }
    }
}
