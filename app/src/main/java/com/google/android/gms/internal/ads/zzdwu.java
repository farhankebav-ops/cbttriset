package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdwu {

    @Nullable
    private Long zza;
    private final String zzb;

    @Nullable
    private String zzc;

    @Nullable
    private Integer zzd;

    @Nullable
    private String zze;

    @Nullable
    private Integer zzf;

    public /* synthetic */ zzdwu(String str, byte[] bArr) {
        this.zzb = str;
    }

    public final /* synthetic */ String zza() {
        String str = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzkY);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("objectId", this.zza);
            jSONObject.put("eventCategory", this.zzb);
            jSONObject.putOpt(NotificationCompat.CATEGORY_EVENT, this.zzc);
            jSONObject.putOpt(IronSourceConstants.EVENTS_ERROR_CODE, this.zzd);
            jSONObject.putOpt("rewardType", this.zze);
            jSONObject.putOpt(IronSourceConstants.EVENTS_REWARD_AMOUNT, this.zzf);
        } catch (JSONException unused) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Could not convert parameters to JSON.");
        }
        String string = jSONObject.toString();
        int length = String.valueOf(str).length();
        return androidx.camera.core.processing.util.a.n(new StringBuilder(String.valueOf(string).length() + length + 14 + 2), str, "(\"h5adsEvent\",", string, ");");
    }

    public final /* synthetic */ void zzb(Long l) {
        this.zza = l;
    }

    public final /* synthetic */ void zzc(String str) {
        this.zzc = str;
    }

    public final /* synthetic */ void zzd(Integer num) {
        this.zzd = num;
    }

    public final /* synthetic */ void zze(String str) {
        this.zze = str;
    }

    public final /* synthetic */ void zzf(Integer num) {
        this.zzf = num;
    }
}
