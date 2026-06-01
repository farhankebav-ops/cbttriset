package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbed implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final Object zza = new Object();

    @Nullable
    private SharedPreferences zzb = null;
    private JSONObject zzc = new JSONObject();

    private final void zzg(@Nullable final SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            try {
                this.zzc = new JSONObject((String) zzbew.zza(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzbec
                    @Override // com.google.android.gms.internal.ads.zzgmv
                    public final /* synthetic */ Object zza() {
                        return sharedPreferences.getString("flag_configuration", "{}");
                    }
                }));
            } catch (JSONException unused) {
            }
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, @Nullable String str) {
        if ("flag_configuration".equals(str)) {
            zzg(sharedPreferences);
        }
    }

    public final void zza(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (this.zza) {
            try {
                if (this.zzb != null) {
                    return;
                }
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                com.google.android.gms.ads.internal.client.zzbd.zza();
                SharedPreferences sharedPreferencesZza = zzben.zza(context);
                this.zzb = sharedPreferencesZza;
                zzg(sharedPreferencesZza);
                if (!((Boolean) zzbgu.zza.zze()).booleanValue() && (sharedPreferences = this.zzb) != null) {
                    sharedPreferences.registerOnSharedPreferenceChangeListener(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String zzb(String str, String str2) {
        return !str.startsWith("adapter:") ? str2 : this.zzc.optString(str, str2);
    }

    public final long zzc(String str, long j) {
        return !str.startsWith("adapter:") ? j : this.zzc.optLong(str, j);
    }

    public final int zzd(String str, int i2) {
        return !str.startsWith("adapter:") ? i2 : this.zzc.optInt(str, i2);
    }

    public final float zze(String str, float f4) {
        return !str.startsWith("adapter:") ? f4 : (float) this.zzc.optDouble(str, f4);
    }

    public final boolean zzf(String str, boolean z2) {
        return !str.startsWith("adapter:") ? z2 : this.zzc.optBoolean(str, z2);
    }
}
