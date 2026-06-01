package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgtm extends zzgtl {
    private static final AtomicReferenceFieldUpdater zza = AtomicReferenceFieldUpdater.newUpdater(zzgto.class, Set.class, "seenExceptionsField");
    private static final AtomicIntegerFieldUpdater zzb = AtomicIntegerFieldUpdater.newUpdater(zzgto.class, "remainingField");

    private zzgtm() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgtl
    public final void zza(zzgto zzgtoVar, Set set, Set set2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = zza;
        while (!atomicReferenceFieldUpdater.compareAndSet(zzgtoVar, null, set2) && atomicReferenceFieldUpdater.get(zzgtoVar) == null) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgtl
    public final int zzb(zzgto zzgtoVar) {
        return zzb.decrementAndGet(zzgtoVar);
    }

    public /* synthetic */ zzgtm(byte[] bArr) {
        super(null);
    }
}
