package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbqz implements zzbmn {
    private final zzcca zza;

    public zzbqz(zzbrb zzbrbVar, zzcca zzccaVar) {
        Objects.requireNonNull(zzbrbVar);
        this.zza = zzccaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbmn
    public final void zza(JSONObject jSONObject) {
        try {
            this.zza.zzc(jSONObject);
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zza.zzd(e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbmn
    public final void zzb(@Nullable String str) {
        try {
            if (str == null) {
                this.zza.zzd(new zzbqe());
            } else {
                this.zza.zzd(new zzbqe(str));
            }
        } catch (IllegalStateException unused) {
        }
    }
}
