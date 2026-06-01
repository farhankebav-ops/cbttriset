package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgom extends AbstractCollection {
    final /* synthetic */ zzgon zza;

    public /* synthetic */ zzgom(zzgon zzgonVar, byte[] bArr) {
        Objects.requireNonNull(zzgonVar);
        this.zza = zzgonVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        zzgon zzgonVar = this.zza;
        Map mapZzc = zzgonVar.zzc();
        return mapZzc != null ? mapZzc.values().iterator() : new zzgoh(zzgonVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.zza.size();
    }
}
