package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhpd {
    public static final zzhpd zza = new zzhpd("SHA256");
    public static final zzhpd zzb = new zzhpd("SHA384");
    public static final zzhpd zzc = new zzhpd("SHA512");
    private final String zzd;

    private zzhpd(String str) {
        this.zzd = str;
    }

    public final String toString() {
        return this.zzd;
    }
}
