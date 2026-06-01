package com.google.android.gms.internal.ads;

import com.ironsource.G5;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzgph<K, V> implements Map<K, V>, Serializable {
    private transient zzgpo zza;
    private transient zzgpo zzb;
    private transient zzgpa zzc;

    public static zzgph zza() {
        return zzgre.zza;
    }

    public static zzgph zzb(Object obj, Object obj2) {
        zzgoc.zza("dialog_not_shown_reason", obj2);
        return zzgre.zzk(1, new Object[]{"dialog_not_shown_reason", obj2}, null);
    }

    public static zzgph zzc(Map map) {
        if ((map instanceof zzgph) && !(map instanceof SortedMap)) {
            zzgph zzgphVar = (zzgph) map;
            zzgphVar.zzj();
            return zzgphVar;
        }
        Set<Map.Entry<K, V>> setEntrySet = map.entrySet();
        zzgpg zzgpgVar = new zzgpg(setEntrySet != null ? setEntrySet.size() : 4);
        zzgpgVar.zzb(setEntrySet);
        return zzgpgVar.zzc();
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return zzgql.zzb(this, obj);
    }

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return zzgro.zzc(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        zzgoc.zzb(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824L));
        sb.append('{');
        boolean z2 = true;
        for (Map.Entry<K, V> entry : entrySet()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append(G5.T);
            sb.append(entry.getValue());
            z2 = false;
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzgpo entrySet() {
        zzgpo zzgpoVar = this.zza;
        if (zzgpoVar != null) {
            return zzgpoVar;
        }
        zzgpo zzgpoVarZze = zze();
        this.zza = zzgpoVarZze;
        return zzgpoVarZze;
    }

    public abstract zzgpo zze();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zzgpo keySet() {
        zzgpo zzgpoVar = this.zzb;
        if (zzgpoVar != null) {
            return zzgpoVar;
        }
        zzgpo zzgpoVarZzg = zzg();
        this.zzb = zzgpoVarZzg;
        return zzgpoVarZzg;
    }

    public abstract zzgpo zzg();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public final zzgpa values() {
        zzgpa zzgpaVar = this.zzc;
        if (zzgpaVar != null) {
            return zzgpaVar;
        }
        zzgpa zzgpaVarZzi = zzi();
        this.zzc = zzgpaVarZzi;
        return zzgpaVarZzi;
    }

    public abstract zzgpa zzi();

    public abstract boolean zzj();
}
