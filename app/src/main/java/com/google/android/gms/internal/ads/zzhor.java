package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhor {
    public static final zzhor zza = new zzhor("SHA256");
    public static final zzhor zzb = new zzhor("SHA384");
    public static final zzhor zzc = new zzhor("SHA512");
    private final String zzd;

    private zzhor(String str) {
        this.zzd = str;
    }

    public final String toString() {
        return this.zzd;
    }
}
