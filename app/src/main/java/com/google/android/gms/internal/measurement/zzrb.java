package com.google.android.gms.internal.measurement;

import e2.n;
import e2.q;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzrb implements n {
    private static final zzrb zza = new zzrb();
    private final n zzb = new q(new zzrd());

    @SideEffectFree
    public static boolean zza() {
        zza.get().zza();
        return true;
    }

    @SideEffectFree
    public static boolean zzb() {
        return zza.get().zzb();
    }

    @Override // e2.n
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzrc get() {
        return (zzrc) this.zzb.get();
    }
}
