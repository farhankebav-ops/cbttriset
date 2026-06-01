package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgqd extends AbstractSequentialList implements Serializable {
    final List zza;
    final zzglu zzb;

    public zzgqd(List list, zzglu zzgluVar) {
        list.getClass();
        this.zza = list;
        this.zzb = zzgluVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.zza.isEmpty();
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i2) {
        return new zzgqc(this, this.zza.listIterator(i2));
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
