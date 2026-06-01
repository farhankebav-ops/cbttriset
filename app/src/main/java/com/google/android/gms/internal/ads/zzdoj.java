package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.ironsource.C2300e4;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdoj {
    private final zzgus zza;
    private final zzdoy zzb;
    private final zzdpd zzc;
    private final zzdvc zzd;

    public zzdoj(zzgus zzgusVar, zzdoy zzdoyVar, zzdpd zzdpdVar, zzdvc zzdvcVar) {
        this.zza = zzgusVar;
        this.zzb = zzdoyVar;
        this.zzc = zzdpdVar;
        this.zzd = zzdvcVar;
    }

    private final j2.q zze(j2.q qVar, zzduq zzduqVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcC)).booleanValue()) {
            zzgui.zzr(qVar, new zzdog(this, zzduqVar), this.zza);
        }
        return qVar;
    }

    private static final boolean zzf(JSONObject jSONObject) {
        return jSONObject.optInt("template_id") == 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final j2.q zza(final com.google.android.gms.internal.ads.zzfgf r15, final com.google.android.gms.internal.ads.zzffu r16, final org.json.JSONObject r17, @androidx.annotation.Nullable com.google.android.gms.ads.internal.zzb r18, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzbzt r19) {
        /*
            Method dump skipped, instruction units count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdoj.zza(com.google.android.gms.internal.ads.zzfgf, com.google.android.gms.internal.ads.zzffu, org.json.JSONObject, com.google.android.gms.ads.internal.zzb, com.google.android.gms.internal.ads.zzbzt):j2.q");
    }

    public final /* synthetic */ zzdlq zzb(zzfgf zzfgfVar, zzffu zzffuVar, JSONObject jSONObject) throws zzekz {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcC)).booleanValue()) {
            com.google.android.gms.ads.internal.client.a.m(this.zzd.zze(), zzduq.NATIVE_ASSETS_LOADING_BASIC_START.zza());
        }
        zzdlq zzdlqVar = new zzdlq();
        zzdlqVar.zza(jSONObject.optInt("template_id", -1));
        zzdlqVar.zzl(jSONObject.optString("custom_template_id"));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("omid_settings");
        zzdlqVar.zzv(jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("omid_partner_name") : null);
        zzfgn zzfgnVar = zzfgfVar.zza.zza;
        if (!zzfgnVar.zzh.contains(Integer.toString(zzdlqVar.zzx()))) {
            int iZzx = zzdlqVar.zzx();
            throw new zzekz(1, androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(iZzx).length() + 21), "Invalid template ID: ", iZzx));
        }
        if (zzdlqVar.zzx() == 3) {
            if (zzdlqVar.zzS() == null) {
                throw new zzekz(1, "No custom template id for custom template ad response.");
            }
            if (!zzfgnVar.zzi.contains(zzdlqVar.zzS())) {
                throw new zzekz(1, "Unexpected custom template id in the response.");
            }
        }
        zzdlqVar.zzi(jSONObject.optDouble("rating", -1.0d));
        String strOptString = jSONObject.optString("headline", null);
        if (zzffuVar.zzM) {
            com.google.android.gms.ads.internal.zzt.zzc();
            String strZzC = com.google.android.gms.ads.internal.util.zzs.zzC();
            strOptString = a1.a.s(new StringBuilder(String.valueOf(strZzC).length() + 3 + String.valueOf(strOptString).length()), strZzC, " : ", strOptString);
        }
        zzdlqVar.zzs("headline", strOptString);
        zzdlqVar.zzs(C2300e4.h.E0, jSONObject.optString(C2300e4.h.E0, null));
        zzdlqVar.zzs("call_to_action", jSONObject.optString("call_to_action", null));
        zzdlqVar.zzs(C2300e4.h.U, jSONObject.optString(C2300e4.h.U, null));
        zzdlqVar.zzs("price", jSONObject.optString("price", null));
        zzdlqVar.zzs(C2300e4.h.F0, jSONObject.optString(C2300e4.h.F0, null));
        return zzdlqVar;
    }

    public final /* synthetic */ zzdlq zzc(j2.q qVar, j2.q qVar2, j2.q qVar3, j2.q qVar4, j2.q qVar5, JSONObject jSONObject, j2.q qVar6, j2.q qVar7, j2.q qVar8, j2.q qVar9, j2.q qVar10) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcx)).booleanValue()) {
            com.google.android.gms.ads.internal.client.a.m(this.zzd.zze(), zzduq.RENDERING_NATIVE_ASSETS_LOADING_END.zza());
        }
        zzdlq zzdlqVar = (zzdlq) qVar.get();
        zzdlqVar.zzd((List) qVar2.get());
        zzdlqVar.zzj((zzbii) qVar3.get());
        zzdlqVar.zzk((zzbii) qVar4.get());
        zzdlqVar.zzc((zzbib) qVar5.get());
        zzdlqVar.zze(zzdoy.zzl(jSONObject));
        zzdlqVar.zzf(zzdoy.zzk(jSONObject));
        zzcgy zzcgyVar = (zzcgy) qVar6.get();
        if (zzcgyVar != null) {
            zzdlqVar.zzm(zzcgyVar);
            zzdlqVar.zzg(zzcgyVar.zzE());
            zzdlqVar.zzb(zzcgyVar.zzh());
        }
        zzdlqVar.zzH().putAll((Bundle) qVar7.get());
        zzcgy zzcgyVar2 = (zzcgy) qVar8.get();
        if (zzcgyVar2 != null) {
            zzdlqVar.zzn(zzcgyVar2);
            zzdlqVar.zzh(zzcgyVar2.zzE());
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfW)).booleanValue() || zzf(jSONObject)) {
            zzcgy zzcgyVar3 = (zzcgy) qVar9.get();
            if (zzcgyVar3 != null) {
                zzdlqVar.zzo(zzcgyVar3);
            }
        } else {
            zzdlqVar.zzp(qVar9);
            zzdlqVar.zzr(new zzcca());
        }
        for (zzdpa zzdpaVar : (List) qVar10.get()) {
            if (zzdpaVar.zza != 1) {
                zzdlqVar.zzt(zzdpaVar.zzb, zzdpaVar.zzd);
            } else {
                zzdlqVar.zzs(zzdpaVar.zzb, zzdpaVar.zzc);
            }
        }
        return zzdlqVar;
    }

    public final /* synthetic */ zzdvc zzd() {
        return this.zzd;
    }
}
