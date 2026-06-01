package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfpi {
    private final String zza;
    private final String zzb;

    private zzfpi(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public static zzfpi zza(String str, String str2) {
        zzfqs.zzc(str, "Name is null or empty");
        zzfqs.zzc(str2, "Version is null or empty");
        return new zzfpi(str, str2);
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }
}
