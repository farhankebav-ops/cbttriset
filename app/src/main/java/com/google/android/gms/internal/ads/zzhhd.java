package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhhd {
    public static final zzhhd zza = new zzhhd("SHA1");
    public static final zzhhd zzb = new zzhhd("SHA224");
    public static final zzhhd zzc = new zzhhd("SHA256");
    public static final zzhhd zzd = new zzhhd("SHA384");
    public static final zzhhd zze = new zzhhd("SHA512");
    private final String zzf;

    private zzhhd(String str) {
        this.zzf = str;
    }

    public final String toString() {
        return this.zzf;
    }
}
