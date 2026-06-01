package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Objects;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
class zzgnq extends zzgnj implements SortedMap {
    SortedSet zzd;
    final /* synthetic */ zzgnw zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgnq(zzgnw zzgnwVar, SortedMap sortedMap) {
        super(zzgnwVar, sortedMap);
        Objects.requireNonNull(zzgnwVar);
        this.zze = zzgnwVar;
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return zzg().comparator();
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        return zzg().firstKey();
    }

    public SortedMap headMap(Object obj) {
        return new zzgnq(this.zze, zzg().headMap(obj));
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        return zzg().lastKey();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return new zzgnq(this.zze, zzg().subMap(obj, obj2));
    }

    public SortedMap tailMap(Object obj) {
        return new zzgnq(this.zze, zzg().tailMap(obj));
    }

    @Override // com.google.android.gms.internal.ads.zzgqk
    /* JADX INFO: renamed from: zze */
    public SortedSet zzh() {
        return new zzgnr(this.zze, zzg());
    }

    @Override // com.google.android.gms.internal.ads.zzgnj, com.google.android.gms.internal.ads.zzgqk, java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public SortedSet keySet() {
        SortedSet sortedSet = this.zzd;
        if (sortedSet != null) {
            return sortedSet;
        }
        SortedSet sortedSetZzh = zzh();
        this.zzd = sortedSetZzh;
        return sortedSetZzh;
    }

    public SortedMap zzg() {
        return (SortedMap) ((zzgnj) this).zza;
    }
}
