package com.google.android.gms.internal.ads;

import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbgz {
    public static final zzbge zza = zzbge.zza("gads:delegating_web_view_client_recursion_detection:enabled", false);
    public static final zzbge zzb = zzbge.zza("gads:paw_app_signals:document_start_js:enabled", false);
    public static final zzbge zzc = zzbge.zza("gads:paw_app_signals:enabled", false);
    public static final zzbge zzd = zzbge.zza("gads:paw_delegate_web_view_client:enabled", false);
    public static final zzbge zze = zzbge.zza("gads:paw_cache:enabled", false);
    public static final zzbge zzf = zzbge.zzb("gads:paw_cache:refresh_interval_seconds", 30);
    public static final zzbge zzg = zzbge.zzb("gads:paw_cache:retry_delay_seconds", 10);
    public static final zzbge zzh = zzbge.zzb("gads:paw_cache:ttl_ms", RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS);
}
