package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzhfi {
    private final Class zza;
    private final Class zzb;

    public /* synthetic */ zzhfi(Class cls, Class cls2, byte[] bArr) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzhfi zzd(zzhfh zzhfhVar, Class cls, Class cls2) {
        return new zzhfg(cls, cls2, zzhfhVar);
    }

    public abstract zzhgb zza(zzgwj zzgwjVar) throws GeneralSecurityException;

    public final Class zzb() {
        return this.zza;
    }

    public final Class zzc() {
        return this.zzb;
    }
}
