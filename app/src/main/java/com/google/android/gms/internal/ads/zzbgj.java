package com.google.android.gms.internal.ads;

import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbgj {
    public static final zzbge zza = zzbge.zzb("gads:app_permissions_caching_expiry_ms:expiry", RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS);
    public static final zzbge zzb = zzbge.zzb("gads:audio_caching_expiry_ms:expiry", 5000);
    public static final zzbge zzc = zzbge.zzb("gads:battery_caching_expiry_ms:expiry", WorkRequest.MIN_BACKOFF_MILLIS);
    public static final zzbge zzd = zzbge.zzb("gads:device_info_caching_expiry_ms:expiry", PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
    public static final zzbge zze = zzbge.zzb("gads:hsdp_caching_expiry_ms:expiry", TTAdConstant.AD_MAX_EVENT_TIME);
    public static final zzbge zzf = zzbge.zzb("gads:memory_caching_expiry_ms:expiry", 5000);
    public static final zzbge zzg = zzbge.zzb("gads:sdk_environment_caching_expiry_ms:expiry", TTAdConstant.AD_MAX_EVENT_TIME);
    public static final zzbge zzh = zzbge.zzb("gads:telephony_caching_expiry_ms:expiry", 5000);
}
