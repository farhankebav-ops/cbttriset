package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import androidx.annotation.Nullable;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzffz {

    @Nullable
    public final String zza;

    @Nullable
    public final String zzb;
    public final JSONObject zzc;
    public final JSONObject zzd;

    public zzffz(JsonReader jsonReader) throws IllegalStateException, JSONException, IOException, NumberFormatException {
        JSONObject jSONObjectZzd = com.google.android.gms.ads.internal.util.zzbp.zzd(jsonReader);
        this.zzd = jSONObjectZzd;
        this.zza = jSONObjectZzd.optString("ad_html", null);
        this.zzb = jSONObjectZzd.optString("ad_base_url", null);
        this.zzc = jSONObjectZzd.optJSONObject("ad_json");
    }
}
