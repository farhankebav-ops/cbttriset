package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgzn {
    public static final zzgzn zza = new zzgzn("ASSUME_AES_GCM");
    public static final zzgzn zzb = new zzgzn("ASSUME_XCHACHA20POLY1305");
    public static final zzgzn zzc = new zzgzn("ASSUME_CHACHA20POLY1305");
    public static final zzgzn zzd = new zzgzn("ASSUME_AES_CTR_HMAC");
    public static final zzgzn zze = new zzgzn("ASSUME_AES_EAX");
    public static final zzgzn zzf = new zzgzn("ASSUME_AES_GCM_SIV");
    private final String zzg;

    private zzgzn(String str) {
        this.zzg = str;
    }

    public final String toString() {
        return this.zzg;
    }
}
