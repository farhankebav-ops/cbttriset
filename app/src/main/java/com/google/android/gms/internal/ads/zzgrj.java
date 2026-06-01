package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgrj extends zzgrn {
    final /* synthetic */ Set zza;
    final /* synthetic */ Set zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgrj(Set set, Set set2) {
        super(null);
        this.zza = set;
        this.zzb = set2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.zza.contains(obj) && this.zzb.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        return this.zza.containsAll(collection) && this.zzb.containsAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return Collections.disjoint(this.zzb, this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        Iterator it = this.zza.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (this.zzb.contains(it.next())) {
                i2++;
            }
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzgrn, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: zza */
    public final zzgrs iterator() {
        return new zzgri(this, this.zza, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzgrn
    public final int zzb() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgrn
    public final int zzc() {
        return Math.min(zzgrn.zzd(this.zza), zzgrn.zzd(this.zzb));
    }
}
