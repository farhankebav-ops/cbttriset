package com.google.android.gms.internal.ads;

import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbrb implements zzgtq {
    private final String zza = "google.afma.activeView.handleUpdate";
    private final j2.q zzb;

    public zzbrb(j2.q qVar, String str, zzbqi zzbqiVar, zzbqh zzbqhVar) {
        this.zzb = qVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgtq
    public final j2.q zza(Object obj) throws Exception {
        return zzb(obj);
    }

    public final j2.q zzb(final Object obj) {
        return zzgui.zzj(this.zzb, new zzgtq() { // from class: com.google.android.gms.internal.ads.zzbra
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ j2.q zza(Object obj2) {
                return this.zza.zzc(obj, (zzbqc) obj2);
            }
        }, zzcbv.zzg);
    }

    public final /* synthetic */ j2.q zzc(Object obj, zzbqc zzbqcVar) throws JSONException {
        zzcca zzccaVar = new zzcca();
        com.google.android.gms.ads.internal.zzt.zzc();
        String string = UUID.randomUUID().toString();
        zzblw.zzo.zzb(string, new zzbqz(this, zzccaVar));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", string);
        jSONObject.put("args", (JSONObject) obj);
        zzbqcVar.zzb(this.zza, jSONObject);
        return zzccaVar;
    }
}
