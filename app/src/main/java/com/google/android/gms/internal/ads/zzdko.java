package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdko implements zzifh {
    private final zzdkm zza;

    private zzdko(zzdkm zzdkmVar) {
        this.zza = zzdkmVar;
    }

    public static zzdko zzc(zzdkm zzdkmVar) {
        return new zzdko(zzdkmVar);
    }

    public static JSONObject zzd(zzdkm zzdkmVar) {
        JSONObject jSONObjectZzc = zzdkmVar.zzc();
        zzifp.zzb(jSONObjectZzc);
        return jSONObjectZzc;
    }

    public final JSONObject zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
