package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgqb extends AbstractList implements RandomAccess, Serializable {
    final List zza;
    final zzglu zzb;

    public zzgqb(List list, zzglu zzgluVar) {
        list.getClass();
        this.zza = list;
        this.zzb = zzgluVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        return this.zzb.apply(this.zza.get(i2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.zza.isEmpty();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i2) {
        return new zzgqa(this, this.zza.listIterator(i2));
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        return this.zzb.apply(this.zza.remove(i2));
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i8) {
        this.zza.subList(i2, i8).clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }
}
