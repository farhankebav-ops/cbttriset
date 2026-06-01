package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.webkit.WebViewFeature;
import com.ironsource.C2300e4;
import com.ironsource.Y1;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzduo implements zzdbu, zzdac, zzcyr, zzdhh {
    private final zzdvc zza;
    private final zzdvn zzb;
    private final int zzc;

    public zzduo(zzdvc zzdvcVar, zzdvn zzdvnVar, int i2) {
        this.zza = zzdvcVar;
        this.zzb = zzdvnVar;
        this.zzc = i2;
    }

    private final void zzc(Bundle bundle, zzgpe zzgpeVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcv)).booleanValue() || bundle == null) {
            return;
        }
        com.google.android.gms.ads.internal.client.a.m(bundle, zzduq.PUBLIC_API_CALLBACK.zza());
        zzdvc zzdvcVar = this.zza;
        zzdvcVar.zzf();
        if (bundle.containsKey("ls")) {
            zzdvcVar.zzd("ls", true != bundle.getBoolean("ls") ? "0" : "1");
        }
        int size = zzgpeVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzdur zzdurVar = (zzdur) zzgpeVar.get(i2);
            long j = bundle.getLong(zzdurVar.zzb().zza(), -1L);
            long j3 = bundle.getLong(zzdurVar.zzc().zza(), -1L);
            if (j > 0 && j3 > 0) {
                zzdvcVar.zzd(zzdurVar.zza(), String.valueOf(j3 - j));
            }
        }
        zzf(bundle.getBundle("client_sig_latency_key"));
        zzf(bundle.getBundle("gms_sig_latency_key"));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzid)).booleanValue()) {
            if (bundle.containsKey("sod_h")) {
                zzdvcVar.zzd("sod_h", true != bundle.getBoolean("sod_h") ? "0" : "1");
            }
            if (bundle.containsKey("cmr")) {
                zzdvcVar.zzd("cmr", String.valueOf(bundle.getInt("cmr")));
            }
        }
    }

    private final void zzf(@Nullable Bundle bundle) {
        if (bundle == null) {
            return;
        }
        for (String str : bundle.keySet()) {
            long j = bundle.getLong(str);
            if (j >= 0) {
                this.zza.zzd(str, String.valueOf(j));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdhh
    public final void zzd(@Nullable com.google.android.gms.ads.nonagon.signalgeneration.zzbj zzbjVar) {
        String str;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzhw)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzid)).booleanValue()) {
                this.zza.zzc().put("sgw", String.valueOf(this.zzc));
            }
            if (zzbjVar == null) {
                zzdvc zzdvcVar = this.zza;
                zzdvcVar.zzc().put("action", "sgs");
                zzdvcVar.zzc().put("request_id", Y1.f7808f);
                this.zzb.zzb(zzdvcVar.zzc());
                return;
            }
            zzbxj zzbxjVar = zzbjVar.zzd;
            Bundle bundle = zzbjVar.zze;
            if (zzbxjVar != null) {
                zzc(zzbxjVar.zzm, zzdur.zza);
            } else if (bundle != null && !bundle.isEmpty()) {
                zzc(bundle, zzdur.zza);
            }
            try {
                JSONObject jSONObject = new JSONObject(TextUtils.isEmpty(zzbjVar.zzc) ? zzbjVar.zzb : zzbjVar.zzc);
                zzdvc zzdvcVar2 = this.zza;
                zzdvcVar2.zzc().put("action", "sgs");
                Map mapZzc = zzdvcVar2.zzc();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzkH)).booleanValue()) {
                    try {
                        str = jSONObject.getJSONObject("extras").getBoolean("accept_3p_cookie") ? "1" : "0";
                    } catch (JSONException e) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzg("Error retrieving JSONObject from the requestJson, ", e);
                        str = "na";
                    }
                } else {
                    str = "na";
                }
                mapZzc.put("tpc", str);
                zzbxj zzbxjVar2 = zzbjVar.zzd;
                if (zzbxjVar2 != null) {
                    this.zza.zzb(zzbxjVar2.zza);
                }
                zzdvc zzdvcVar3 = this.zza;
                zzdvcVar3.zzg();
                this.zzb.zzb(zzdvcVar3.zzc());
            } catch (JSONException unused) {
                zzdvc zzdvcVar4 = this.zza;
                zzdvcVar4.zzc().put("action", "sgf");
                zzdvcVar4.zzc().put("sgf_reason", "request_invalid");
                this.zzb.zzb(zzdvcVar4.zzc());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcyr
    public final void zzdN(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzdvc zzdvcVar = this.zza;
        zzdvcVar.zzc().put("action", "ftl");
        zzdvcVar.zzd("ftl", String.valueOf(zzeVar.zza));
        zzdvcVar.zzd("ed", zzeVar.zzc);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzhL)).booleanValue()) {
            zzdvcVar.zzd("emsg", zzeVar.zzb);
        }
        zzdvcVar.zzg();
        this.zzb.zzb(zzdvcVar.zzc());
    }

    @Override // com.google.android.gms.internal.ads.zzdbu
    public final void zzdT(zzbxj zzbxjVar) {
        this.zza.zzb(zzbxjVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzdbu
    public final void zzdU(zzfgf zzfgfVar) {
        this.zza.zza(zzfgfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdhh
    public final void zze(@Nullable String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzhw)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzid)).booleanValue()) {
                this.zza.zzc().put("sgw", String.valueOf(this.zzc));
            }
            zzdvc zzdvcVar = this.zza;
            zzdvcVar.zzc().put("action", "sgf");
            zzdvcVar.zzd("sgf_reason", str);
            zzdvcVar.zzg();
            this.zzb.zzb(zzdvcVar.zzc());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdac
    public final void zzg() {
        zzdvc zzdvcVar = this.zza;
        zzdvcVar.zzc().put("action", C2300e4.h.f8381r);
        zzc(zzdvcVar.zze(), zzdur.zzb);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zznF)).booleanValue()) {
            zzdvcVar.zzc().put("mafe", true != WebViewFeature.isFeatureSupported(WebViewFeature.MUTE_AUDIO) ? "0" : "1");
        }
        zzdvcVar.zzg();
        this.zzb.zzb(zzdvcVar.zzc());
    }
}
