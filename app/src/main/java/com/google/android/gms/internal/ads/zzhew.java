package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhew {
    private static final zzhew zza = new zzhew();
    private static final zzhev zzb = new zzhev(null);
    private final AtomicReference zzc = new AtomicReference();

    public static zzhew zza() {
        return zza;
    }

    public final zzhen zzb() {
        zzhen zzhenVar = (zzhen) this.zzc.get();
        return zzhenVar == null ? zzb : zzhenVar;
    }
}
