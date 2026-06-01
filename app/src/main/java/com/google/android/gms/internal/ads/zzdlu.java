package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.ironsource.C2318f4;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdlu extends zzdlv {
    private final JSONObject zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final boolean zze;
    private final boolean zzf;
    private final String zzg;

    @Nullable
    private final JSONObject zzh;

    public zzdlu(zzffu zzffuVar, JSONObject jSONObject) {
        super(zzffuVar);
        this.zzb = com.google.android.gms.ads.internal.util.zzbp.zzi(jSONObject, "tracking_urls_and_actions", "active_view");
        this.zzc = com.google.android.gms.ads.internal.util.zzbp.zzj(false, jSONObject, "allow_pub_owned_ad_view");
        this.zzd = com.google.android.gms.ads.internal.util.zzbp.zzj(false, jSONObject, C2318f4.f8522c, "allow_pub_rendering");
        this.zze = com.google.android.gms.ads.internal.util.zzbp.zzj(false, jSONObject, "enable_omid");
        this.zzg = com.google.android.gms.ads.internal.util.zzbp.zzk("", jSONObject, "watermark_overlay_png_base64");
        this.zzf = jSONObject.optJSONObject("overlay") != null;
        this.zzh = jSONObject.optJSONObject("omid_settings");
    }

    @Override // com.google.android.gms.internal.ads.zzdlv
    @Nullable
    public final JSONObject zza() {
        JSONObject jSONObject = this.zzb;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            return new JSONObject(this.zza.zzz);
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdlv
    public final boolean zzb() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzdlv
    public final boolean zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzdlv
    public final boolean zzd() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzdlv
    public final boolean zze() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzdlv
    public final String zzf() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzdlv
    public final zzfgq zzg() {
        JSONObject jSONObject = this.zzh;
        return jSONObject != null ? new zzfgq(jSONObject) : this.zza.zzV;
    }
}
