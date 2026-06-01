package com.google.android.gms.internal.ads;

import java.util.ListIterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgqc extends zzgrr {
    final /* synthetic */ zzgqd zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgqc(zzgqd zzgqdVar, ListIterator listIterator) {
        super(listIterator);
        Objects.requireNonNull(zzgqdVar);
        this.zza = zzgqdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgrq
    public final Object zza(Object obj) {
        return this.zza.zzb.apply(obj);
    }
}
