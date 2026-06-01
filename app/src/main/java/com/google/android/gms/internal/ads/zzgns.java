package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
class zzgns implements Iterator {
    final Iterator zza;
    final Collection zzb;
    final /* synthetic */ zzgnt zzc;

    public zzgns(zzgnt zzgntVar) {
        Objects.requireNonNull(zzgntVar);
        this.zzc = zzgntVar;
        Collection collection = zzgntVar.zzb;
        this.zzb = collection;
        this.zza = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zza();
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        zza();
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zza.remove();
        zzgnt zzgntVar = this.zzc;
        zzgntVar.zze.zzq(r1.zzp() - 1);
        zzgntVar.zzb();
    }

    public final void zza() {
        zzgnt zzgntVar = this.zzc;
        zzgntVar.zza();
        if (zzgntVar.zzb != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }

    public zzgns(zzgnt zzgntVar, Iterator it) {
        Objects.requireNonNull(zzgntVar);
        this.zzc = zzgntVar;
        this.zzb = zzgntVar.zzb;
        this.zza = it;
    }
}
