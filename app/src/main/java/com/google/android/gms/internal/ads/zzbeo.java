package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbeo implements zzbhk {
    final /* synthetic */ SharedPreferences zza;

    public zzbeo(zzbes zzbesVar, SharedPreferences sharedPreferences) {
        this.zza = sharedPreferences;
        Objects.requireNonNull(zzbesVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbhk
    public final Boolean zza(String str, boolean z2) {
        try {
            return Boolean.valueOf(this.zza.getBoolean(str, z2));
        } catch (ClassCastException unused) {
            return Boolean.valueOf(this.zza.getString(str, String.valueOf(z2)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhk
    public final Long zzb(String str, long j) {
        try {
            return Long.valueOf(this.zza.getLong(str, j));
        } catch (ClassCastException unused) {
            return Long.valueOf(this.zza.getInt(str, (int) j));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhk
    public final Double zzc(String str, double d8) {
        try {
            return Double.valueOf(this.zza.getFloat(str, (float) d8));
        } catch (ClassCastException unused) {
            return Double.valueOf(this.zza.getString(str, String.valueOf(d8)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhk
    public final String zzd(String str, String str2) {
        return this.zza.getString(str, str2);
    }
}
