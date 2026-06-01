package com.google.android.gms.internal.ads;

import java.security.spec.ECParameterSpec;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhmx {
    public static final zzhmx zza = new zzhmx("NIST_P256", zzhdn.zza);
    public static final zzhmx zzb = new zzhmx("NIST_P384", zzhdn.zzb);
    public static final zzhmx zzc = new zzhmx("NIST_P521", zzhdn.zzc);
    private final String zzd;
    private final ECParameterSpec zze;

    private zzhmx(String str, ECParameterSpec eCParameterSpec) {
        this.zzd = str;
        this.zze = eCParameterSpec;
    }

    public final String toString() {
        return this.zzd;
    }

    public final ECParameterSpec zza() {
        return this.zze;
    }
}
