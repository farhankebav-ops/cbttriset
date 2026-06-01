package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzhff {
    private final zzhsz zza;
    private final Class zzb;

    public /* synthetic */ zzhff(zzhsz zzhszVar, Class cls, byte[] bArr) {
        this.zza = zzhszVar;
        this.zzb = cls;
    }

    public static zzhff zzd(zzhfe zzhfeVar, zzhsz zzhszVar, Class cls) {
        return new zzhfd(zzhszVar, cls, zzhfeVar);
    }

    public abstract zzgwj zza(zzhgb zzhgbVar) throws GeneralSecurityException;

    public final zzhsz zzb() {
        return this.zza;
    }

    public final Class zzc() {
        return this.zzb;
    }
}
