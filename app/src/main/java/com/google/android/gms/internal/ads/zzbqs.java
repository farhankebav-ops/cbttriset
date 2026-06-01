package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbqs implements zzbmn {
    final /* synthetic */ zzbqt zza;
    private final zzbpv zzb;
    private final zzcca zzc;

    public zzbqs(zzbqt zzbqtVar, zzbpv zzbpvVar, zzcca zzccaVar) {
        Objects.requireNonNull(zzbqtVar);
        this.zza = zzbqtVar;
        this.zzb = zzbpvVar;
        this.zzc = zzccaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbmn
    public final void zza(JSONObject jSONObject) {
        try {
            try {
                this.zzc.zzc(this.zza.zzd().zza(jSONObject));
            } catch (IllegalStateException unused) {
            } catch (JSONException e) {
                this.zzc.zzd(e);
            }
        } finally {
            this.zzb.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbmn
    public final void zzb(@Nullable String str) {
        try {
            if (str == null) {
                this.zzc.zzd(new zzbqe());
            } else {
                this.zzc.zzd(new zzbqe(str));
            }
        } catch (IllegalStateException unused) {
        } catch (Throwable th) {
            this.zzb.zza();
            throw th;
        }
        this.zzb.zza();
    }
}
