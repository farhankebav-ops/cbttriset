package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzhdz {
    private final zzhsz zza;
    private final Class zzb;

    public /* synthetic */ zzhdz(zzhsz zzhszVar, Class cls, byte[] bArr) {
        this.zza = zzhszVar;
        this.zzb = cls;
    }

    public static zzhdz zzd(zzhdy zzhdyVar, zzhsz zzhszVar, Class cls) {
        return new zzhdx(zzhszVar, cls, zzhdyVar);
    }

    public abstract zzgvt zza(zzhgb zzhgbVar, zzgwn zzgwnVar) throws GeneralSecurityException;

    public final zzhsz zzb() {
        return this.zza;
    }

    public final Class zzc() {
        return this.zzb;
    }
}
