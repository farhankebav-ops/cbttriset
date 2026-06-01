package com.google.android.gms.internal.measurement;

import e2.n;
import e2.q;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzrk implements n {
    private static final zzrk zza = new zzrk();
    private final n zzb = new q(new zzrm());

    @SideEffectFree
    public static boolean zza() {
        return zza.get().zza();
    }

    @Override // e2.n
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzrl get() {
        return (zzrl) this.zzb.get();
    }
}
