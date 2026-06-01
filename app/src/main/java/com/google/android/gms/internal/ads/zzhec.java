package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzhec {
    private final Class zza;
    private final Class zzb;

    public /* synthetic */ zzhec(Class cls, Class cls2, byte[] bArr) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzhec zzd(zzheb zzhebVar, Class cls, Class cls2) {
        return new zzhea(cls, cls2, zzhebVar);
    }

    public abstract zzhgb zza(zzgvt zzgvtVar, zzgwn zzgwnVar) throws GeneralSecurityException;

    public final Class zzb() {
        return this.zza;
    }

    public final Class zzc() {
        return this.zzb;
    }
}
