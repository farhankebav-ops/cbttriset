package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgoi extends AbstractSet {
    final /* synthetic */ zzgon zza;

    public /* synthetic */ zzgoi(zzgon zzgonVar, byte[] bArr) {
        Objects.requireNonNull(zzgonVar);
        this.zza = zzgonVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        zzgon zzgonVar = this.zza;
        Map mapZzc = zzgonVar.zzc();
        if (mapZzc != null) {
            return mapZzc.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int iZzi = zzgonVar.zzi(entry.getKey());
            if (iZzi != -1 && Objects.equals(zzgonVar.zzp(iZzi), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        zzgon zzgonVar = this.zza;
        Map mapZzc = zzgonVar.zzc();
        return mapZzc != null ? mapZzc.entrySet().iterator() : new zzgog(zzgonVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int iZzh;
        int iZze;
        zzgon zzgonVar = this.zza;
        Map mapZzc = zzgonVar.zzc();
        if (mapZzc != null) {
            return mapZzc.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (zzgonVar.zzb() || (iZze = zzgoo.zze(entry.getKey(), entry.getValue(), (iZzh = zzgonVar.zzh()), zzgonVar.zzk(), zzgonVar.zzl(), zzgonVar.zzm(), zzgonVar.zzn())) == -1) {
            return false;
        }
        zzgonVar.zze(iZze, iZzh);
        zzgonVar.zzu(zzgonVar.zzt() - 1);
        zzgonVar.zzd();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }
}
