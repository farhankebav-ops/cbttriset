package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbhj {
    public static final zzbge zza = zzbge.zza("gads:trustless_token_for_decagon:enabled", true);
    public static final zzbge zzb;

    static {
        zzbge.zza("gads:invalidate_token_at_refresh_start", true);
        zzbge.zza("gms:expose_token_for_gma:enabled", true);
        zzbge.zza("gads:referesh_rate_limit", false);
        zzb = zzbge.zzb("gads:timeout_for_trustless_token:millis", 2000L);
        zzbge.zza("gads:token_anonymization:enabled", true);
        zzbge.zzb("gads:cached_token:ttl_millis", 10800000L);
    }
}
