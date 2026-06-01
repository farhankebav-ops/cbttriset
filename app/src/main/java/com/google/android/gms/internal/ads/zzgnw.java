package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzgnw extends zzgnz implements Serializable {
    private final transient Map zza;
    private transient int zzb;

    public zzgnw(Map map) {
        zzgmd.zza(map.isEmpty());
        this.zza = map;
    }

    public Collection zza(Collection collection) {
        throw null;
    }

    public Collection zzb(Object obj, Collection collection) {
        throw null;
    }

    public abstract Collection zzc();

    @Override // com.google.android.gms.internal.ads.zzgqm
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgnz, com.google.android.gms.internal.ads.zzgqm
    public final boolean zze(Object obj, Object obj2) {
        Map map = this.zza;
        Collection collection = (Collection) map.get(obj);
        if (collection != null) {
            if (!collection.add(obj2)) {
                return false;
            }
            this.zzb++;
            return true;
        }
        Collection collectionZzc = zzc();
        if (!collectionZzc.add(obj2)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.zzb++;
        map.put(obj, collectionZzc);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgqm
    public final void zzf() {
        Map map = this.zza;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        map.clear();
        this.zzb = 0;
    }

    public final List zzg(Object obj, List list, zzgnt zzgntVar) {
        return list instanceof RandomAccess ? new zzgnp(this, obj, list, zzgntVar) : new zzgnv(this, obj, list, zzgntVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgnz
    public Set zzh() {
        throw null;
    }

    public final Set zzi() {
        Map map = this.zza;
        return map instanceof NavigableMap ? new zzgno(this, (NavigableMap) map) : map instanceof SortedMap ? new zzgnr(this, (SortedMap) map) : new zzgnm(this, map);
    }

    @Override // com.google.android.gms.internal.ads.zzgnz
    public final Collection zzj() {
        return new zzgny(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgnz
    public final Iterator zzk() {
        return new zzgng(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgnz
    public Map zzl() {
        throw null;
    }

    public final Map zzm() {
        Map map = this.zza;
        return map instanceof NavigableMap ? new zzgnn(this, (NavigableMap) map) : map instanceof SortedMap ? new zzgnq(this, (SortedMap) map) : new zzgnj(this, map);
    }

    public final /* synthetic */ void zzn(Object obj) {
        Object objRemove;
        try {
            objRemove = this.zza.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            objRemove = null;
        }
        Collection collection = (Collection) objRemove;
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.zzb -= size;
        }
    }

    public final /* synthetic */ Map zzo() {
        return this.zza;
    }

    public final /* synthetic */ int zzp() {
        return this.zzb;
    }

    public final /* synthetic */ void zzq(int i2) {
        this.zzb = i2;
    }
}
