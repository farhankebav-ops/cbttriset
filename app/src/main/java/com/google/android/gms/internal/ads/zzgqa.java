package com.google.android.gms.internal.ads;

import java.util.ListIterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgqa extends zzgrr {
    final /* synthetic */ zzgqb zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgqa(zzgqb zzgqbVar, ListIterator listIterator) {
        super(listIterator);
        Objects.requireNonNull(zzgqbVar);
        this.zza = zzgqbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgrq
    public final Object zza(Object obj) {
        return this.zza.zzb.apply(obj);
    }
}
