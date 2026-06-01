package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbqt implements zzbqf {
    private final zzbqh zza;
    private final zzbqi zzb;
    private final zzbqb zzc;
    private final String zzd;

    public zzbqt(zzbqb zzbqbVar, String str, zzbqi zzbqiVar, zzbqh zzbqhVar) {
        this.zzc = zzbqbVar;
        this.zzd = str;
        this.zzb = zzbqiVar;
        this.zza = zzbqhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgtq
    public final j2.q zza(@Nullable Object obj) throws Exception {
        return zzb(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final j2.q zzb(Object obj) {
        zzcca zzccaVar = new zzcca();
        zzbpv zzbpvVarZzb = this.zzc.zzb(null);
        com.google.android.gms.ads.internal.util.zze.zza("callJs > getEngine: Promise created");
        zzbpvVarZzb.zze(new zzbqq(this, zzbpvVarZzb, obj, zzccaVar), new zzbqr(this, zzccaVar, zzbpvVarZzb));
        return zzccaVar;
    }

    public final /* synthetic */ void zzc(zzbpv zzbpvVar, zzbqc zzbqcVar, Object obj, zzcca zzccaVar) {
        try {
            com.google.android.gms.ads.internal.zzt.zzc();
            String string = UUID.randomUUID().toString();
            zzblw.zzo.zzb(string, new zzbqs(this, zzbpvVar, zzccaVar));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", string);
            jSONObject.put("args", this.zzb.zzb(obj));
            zzbqcVar.zzb(this.zzd, jSONObject);
        } catch (Exception e) {
            try {
                zzccaVar.zzd(e);
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to invokeJavascript", e);
            } finally {
                zzbpvVar.zza();
            }
        }
    }

    public final /* synthetic */ zzbqh zzd() {
        return this.zza;
    }
}
