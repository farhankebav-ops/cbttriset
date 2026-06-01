package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.PlatformVersion;
import com.ironsource.Me;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzejw implements zzejq {
    private final zzdjz zza;
    private final zzgus zzb;
    private final zzdoj zzc;
    private final zzfhm zzd;
    private final zzdqz zze;
    private final zzdvc zzf;
    private final VersionInfoParcel zzg;
    private final Context zzh;
    private final zzbzp zzi;

    public zzejw(zzdjz zzdjzVar, zzgus zzgusVar, zzdoj zzdojVar, zzfhm zzfhmVar, zzdqz zzdqzVar, zzdvc zzdvcVar, VersionInfoParcel versionInfoParcel, Context context, zzbzp zzbzpVar) {
        this.zzg = versionInfoParcel;
        this.zzh = context;
        this.zzi = zzbzpVar;
        this.zza = zzdjzVar;
        this.zzb = zzgusVar;
        this.zzc = zzdojVar;
        this.zzd = zzfhmVar;
        this.zze = zzdqzVar;
        this.zzf = zzdvcVar;
    }

    private final j2.q zzg(final zzfgf zzfgfVar, final zzffu zzffuVar, final JSONObject jSONObject) {
        com.google.android.gms.ads.internal.zzb zzbVar;
        zzbzt zzbztVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcy)).booleanValue()) {
            com.google.android.gms.ads.internal.client.a.m(this.zzf.zze(), zzduq.RENDERING_WEBVIEW_CREATION_START.zza());
        }
        final j2.q qVarZzb = this.zzd.zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzoB)).booleanValue()) {
            Context context = this.zzh;
            zzbzt zzbztVarZza = zzcyj.zza(context, this.zzg, zzffuVar, this.zzi);
            zzbVar = new com.google.android.gms.ads.internal.zzb(context, zzbztVarZza, null);
            zzbztVar = zzbztVarZza;
        } else {
            zzbVar = new com.google.android.gms.ads.internal.zzb(this.zzh, null, null);
            zzbztVar = null;
        }
        final com.google.android.gms.ads.internal.zzb zzbVar2 = zzbVar;
        final zzbzt zzbztVar2 = zzbztVar;
        final j2.q qVarZza = this.zzc.zza(zzfgfVar, zzffuVar, jSONObject, zzbVar2, zzbztVar2);
        return zzgui.zzo(qVarZzb, qVarZza).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeju
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzf(qVarZza, qVarZzb, zzfgfVar, zzffuVar, jSONObject, zzbVar2, zzbztVar2);
            }
        }, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzehk
    public final boolean zza(zzfgf zzfgfVar, zzffu zzffuVar) {
        zzffz zzffzVar = zzffuVar.zzs;
        return (zzffzVar == null || zzffzVar.zzc == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzehk
    public final j2.q zzb(final zzfgf zzfgfVar, final zzffu zzffuVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcx)).booleanValue()) {
            com.google.android.gms.ads.internal.client.a.m(this.zzf.zze(), zzduq.RENDERING_NATIVE_ADS_NATIVE_JS_WEBVIEW_START.zza());
        }
        j2.q qVarZzb = this.zzd.zzb();
        zzgtq zzgtqVar = new zzgtq() { // from class: com.google.android.gms.internal.ads.zzejv
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ j2.q zza(Object obj) {
                return this.zza.zzc(zzffuVar, (zzdqt) obj);
            }
        };
        zzgus zzgusVar = this.zzb;
        return zzgui.zzj(zzgui.zzj(qVarZzb, zzgtqVar, zzgusVar), new zzgtq() { // from class: com.google.android.gms.internal.ads.zzejr
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ j2.q zza(Object obj) {
                return this.zza.zzd(zzfgfVar, zzffuVar, (JSONArray) obj);
            }
        }, zzgusVar);
    }

    public final /* synthetic */ j2.q zzc(zzffu zzffuVar, final zzdqt zzdqtVar) throws JSONException {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcx)).booleanValue()) {
            com.google.android.gms.ads.internal.client.a.m(this.zzf.zze(), zzduq.RENDERING_NATIVE_ADS_PREPROCESS_START.zza());
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isNonagon", true);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjA)).booleanValue() && PlatformVersion.isAtLeastR()) {
            jSONObject.put("skipDeepLinkValidation", true);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(Me.f7195n, zzffuVar.zzs.zzc);
        jSONObject2.put("sdk_params", jSONObject);
        return zzgui.zzj(zzdqtVar.zzc("google.afma.nativeAds.preProcessJson", jSONObject2), new zzgtq() { // from class: com.google.android.gms.internal.ads.zzejs
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ j2.q zza(Object obj) {
                return this.zza.zze(zzdqtVar, (JSONObject) obj);
            }
        }, this.zzb);
    }

    public final /* synthetic */ j2.q zzd(zzfgf zzfgfVar, zzffu zzffuVar, JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            return zzgui.zzc(new zzdzv(3));
        }
        int i2 = zzfgfVar.zza.zza.zzl;
        if (i2 <= 1) {
            return zzgui.zzk(zzg(zzfgfVar, zzffuVar, jSONArray.getJSONObject(0)), zzejt.zza, this.zzb);
        }
        int length = jSONArray.length();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcz)).booleanValue()) {
            this.zzf.zzd("nsl", String.valueOf(length));
        }
        this.zzd.zza(Math.min(length, i2));
        ArrayList arrayList = new ArrayList(i2);
        for (int i8 = 0; i8 < i2; i8++) {
            if (i8 < length) {
                arrayList.add(zzg(zzfgfVar, zzffuVar, jSONArray.getJSONObject(i8)));
            } else {
                arrayList.add(zzgui.zzc(new zzdzv(3)));
            }
        }
        return zzgui.zza(arrayList);
    }

    public final /* synthetic */ j2.q zze(zzdqt zzdqtVar, JSONObject jSONObject) throws zzbqe {
        this.zzd.zzc(zzgui.zza(zzdqtVar));
        if (!jSONObject.optBoolean("success")) {
            throw new zzbqe("process json failed");
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcx)).booleanValue()) {
            com.google.android.gms.ads.internal.client.a.m(this.zzf.zze(), zzduq.RENDERING_NATIVE_ADS_PREPROCESS_END.zza());
        }
        return zzgui.zza(jSONObject.getJSONObject("json").getJSONArray("ads"));
    }

    public final /* synthetic */ zzdll zzf(j2.q qVar, j2.q qVar2, zzfgf zzfgfVar, zzffu zzffuVar, JSONObject jSONObject, com.google.android.gms.ads.internal.zzb zzbVar, zzbzt zzbztVar) throws Throwable {
        zzdlq zzdlqVar = (zzdlq) qVar.get();
        zzdqt zzdqtVar = (zzdqt) qVar2.get();
        zzbel zzbelVar = zzbeu.zzcy;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).booleanValue()) {
            com.google.android.gms.ads.internal.client.a.m(this.zzf.zze(), zzduq.RENDERING_WEBVIEW_CREATION_END.zza());
        }
        zzdlr zzdlrVarZzd = this.zza.zzd(new zzcue(zzfgfVar, zzffuVar, null), new zzdmb(zzdlqVar), new zzdkm(jSONObject, zzdqtVar, zzbVar, zzbztVar));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).booleanValue()) {
            long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis();
            zzdvc zzdvcVar = this.zzf;
            zzdvcVar.zze().putLong(zzduq.RENDERING_AD_COMPONENT_CREATION_END.zza(), jCurrentTimeMillis);
            zzdvcVar.zze().putLong(zzduq.RENDERING_CONFIGURE_WEBVIEW_START.zza(), jCurrentTimeMillis);
        }
        zzdlrVarZzd.zzi().zzb();
        zzdlrVarZzd.zzj().zza(zzdqtVar);
        zzdlrVarZzd.zzk().zza(zzdlqVar.zzT());
        zzdlrVarZzd.zzl().zza(this.zze, zzdlqVar.zzU());
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).booleanValue()) {
            com.google.android.gms.ads.internal.client.a.m(this.zzf.zze(), zzduq.RENDERING_CONFIGURE_WEBVIEW_END.zza());
        }
        return zzdlrVarZzd.zzh();
    }
}
