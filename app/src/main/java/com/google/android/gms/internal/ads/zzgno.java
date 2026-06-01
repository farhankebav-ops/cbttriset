package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgno extends zzgnr implements NavigableSet {
    final /* synthetic */ zzgnw zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgno(zzgnw zzgnwVar, NavigableMap navigableMap) {
        super(zzgnwVar, navigableMap);
        Objects.requireNonNull(zzgnwVar);
        this.zzb = zzgnwVar;
    }

    @Override // java.util.NavigableSet
    public final Object ceiling(Object obj) {
        return ((NavigableMap) ((SortedMap) this.zzd)).ceilingKey(obj);
    }

    @Override // java.util.NavigableSet
    public final Iterator descendingIterator() {
        return descendingSet().iterator();
    }

    @Override // java.util.NavigableSet
    public final NavigableSet descendingSet() {
        return new zzgno(this.zzb, ((NavigableMap) ((SortedMap) this.zzd)).descendingMap());
    }

    @Override // java.util.NavigableSet
    public final Object floor(Object obj) {
        return ((NavigableMap) ((SortedMap) this.zzd)).floorKey(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgnr, java.util.SortedSet, java.util.NavigableSet
    public final /* synthetic */ SortedSet headSet(Object obj) {
        return headSet(obj, false);
    }

    @Override // java.util.NavigableSet
    public final Object higher(Object obj) {
        return ((NavigableMap) ((SortedMap) this.zzd)).higherKey(obj);
    }

    @Override // java.util.NavigableSet
    public final Object lower(Object obj) {
        return ((NavigableMap) ((SortedMap) this.zzd)).lowerKey(obj);
    }

    @Override // java.util.NavigableSet
    public final Object pollFirst() {
        return zzgpx.zza(iterator());
    }

    @Override // java.util.NavigableSet
    public final Object pollLast() {
        return zzgpx.zza(descendingIterator());
    }

    @Override // com.google.android.gms.internal.ads.zzgnr, java.util.SortedSet, java.util.NavigableSet
    public final /* bridge */ /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzgnr, java.util.SortedSet, java.util.NavigableSet
    public final /* synthetic */ SortedSet tailSet(Object obj) {
        return tailSet(obj, true);
    }

    @Override // com.google.android.gms.internal.ads.zzgnr
    public final /* synthetic */ SortedMap zza() {
        return (NavigableMap) ((SortedMap) this.zzd);
    }

    @Override // java.util.NavigableSet
    public final NavigableSet headSet(Object obj, boolean z2) {
        return new zzgno(this.zzb, ((NavigableMap) ((SortedMap) this.zzd)).headMap(obj, z2));
    }

    @Override // java.util.NavigableSet
    public final NavigableSet subSet(Object obj, boolean z2, Object obj2, boolean z7) {
        return new zzgno(this.zzb, ((NavigableMap) ((SortedMap) this.zzd)).subMap(obj, z2, obj2, z7));
    }

    @Override // java.util.NavigableSet
    public final NavigableSet tailSet(Object obj, boolean z2) {
        return new zzgno(this.zzb, ((NavigableMap) ((SortedMap) this.zzd)).tailMap(obj, z2));
    }
}
