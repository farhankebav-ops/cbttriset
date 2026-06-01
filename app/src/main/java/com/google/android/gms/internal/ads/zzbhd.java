package com.google.android.gms.internal.ads;

import androidx.work.WorkRequest;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbhd {
    public static final zzbge zza = zzbge.zzb("gads:dynamite_load:fail:sample_rate", WorkRequest.MIN_BACKOFF_MILLIS);
    public static final zzbge zzb = zzbge.zza("gads:report_dynamite_crash_in_background_thread", false);
    public static final zzbge zzc = new zzbge("gads:public_beta:traffic_multiplier", "1.0", 4);
    public static final zzbge zzd = new zzbge("gads:sdk_crash_report_class_prefix", "com.google.", 4);
    public static final zzbge zze;
    public static final zzbge zzf;

    static {
        zzbge.zza("gads:sdk_crash_report_enabled", false);
        zze = zzbge.zza("gads:sdk_crash_report_full_stacktrace", false);
        zzf = zzbge.zzc("gads:trapped_exception_sample_rate", 0.01d);
    }
}
