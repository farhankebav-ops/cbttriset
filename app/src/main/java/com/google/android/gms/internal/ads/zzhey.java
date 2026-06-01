package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhey {
    private static final zzhey zza = new zzhey();
    private final AtomicReference zzb = new AtomicReference(new zzhft(new zzhfq(null), null));

    public static zzhey zza() {
        return zza;
    }

    public final synchronized void zzb(zzhfp zzhfpVar) throws GeneralSecurityException {
        AtomicReference atomicReference = this.zzb;
        zzhfq zzhfqVar = new zzhfq((zzhft) atomicReference.get(), null);
        zzhfqVar.zza(zzhfpVar);
        atomicReference.set(new zzhft(zzhfqVar, null));
    }

    public final synchronized void zzc(zzhfv zzhfvVar) throws GeneralSecurityException {
        AtomicReference atomicReference = this.zzb;
        zzhfq zzhfqVar = new zzhfq((zzhft) atomicReference.get(), null);
        zzhfqVar.zzb(zzhfvVar);
        atomicReference.set(new zzhft(zzhfqVar, null));
    }

    public final Object zzd(zzgvt zzgvtVar, Class cls) throws GeneralSecurityException {
        return ((zzhft) this.zzb.get()).zzb(zzgvtVar, cls);
    }

    public final Object zze(zzhed zzhedVar, zzhel zzhelVar, Class cls) throws GeneralSecurityException {
        return ((zzhft) this.zzb.get()).zzc(zzhedVar, zzhelVar, cls);
    }
}
