package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzbel {
    private final int zza;
    private final String zzb;
    private final Object zzc;
    private final Object zzd;

    public /* synthetic */ zzbel(int i2, String str, Object obj, Object obj2, byte[] bArr) {
        this.zza = i2;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        com.google.android.gms.ads.internal.client.zzbd.zzb().zza(this);
    }

    public static zzbel zzh(int i2, String str, int i8, int i9) {
        return new zzbeh(1, str, Integer.valueOf(i8), Integer.valueOf(i9));
    }

    public static zzbel zzi(int i2, String str, long j, long j3) {
        return new zzbei(1, str, Long.valueOf(j), Long.valueOf(j3));
    }

    public static zzbel zzj(int i2, String str, float f4, float f8) {
        return new zzbej(1, str, Float.valueOf(f4), Float.valueOf(f8));
    }

    public static zzbel zzk(int i2, String str) {
        zzbek zzbekVar = new zzbek(1, "gads:sdk_core_constants:experiment_id", null, null);
        com.google.android.gms.ads.internal.client.zzbd.zzb().zzb(zzbekVar);
        return zzbekVar;
    }

    public static zzbel zzl(int i2, String str) {
        zzbek zzbekVar = new zzbek(1, "gads:sdk_core_constants_service:experiment_id", null, null);
        com.google.android.gms.ads.internal.client.zzbd.zzb().zzc(zzbekVar);
        return zzbekVar;
    }

    public abstract Object zza(Bundle bundle);

    public abstract void zzb(SharedPreferences.Editor editor, Object obj);

    public abstract Object zzc(JSONObject jSONObject);

    public abstract Object zzd(SharedPreferences sharedPreferences);

    public final String zze() {
        return this.zzb;
    }

    public final Object zzf() {
        return com.google.android.gms.ads.internal.client.zzbd.zzc().zzb() ? this.zzd : this.zzc;
    }

    public final Object zzg() {
        return com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(this);
    }

    public final int zzm() {
        return this.zza;
    }
}
