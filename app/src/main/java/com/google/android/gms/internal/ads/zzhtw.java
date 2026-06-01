package com.google.android.gms.internal.ads;

import com.ironsource.C2300e4;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhtw implements Map.Entry {
    zzhtw zza;
    zzhtw zzb;
    zzhtw zzc;
    zzhtw zzd;
    zzhtw zze;
    final Object zzf;
    final boolean zzg;
    Object zzh;
    int zzi;

    public zzhtw(boolean z2) {
        this.zzf = null;
        this.zzg = z2;
        this.zze = this;
        this.zzd = this;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.zzf;
            if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                Object obj3 = this.zzh;
                if (obj3 == null) {
                    if (entry.getValue() == null) {
                        return true;
                    }
                } else if (obj3.equals(entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.zzf;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.zzh;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.zzf;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.zzh;
        return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj == null && !this.zzg) {
            throw new NullPointerException("value == null");
        }
        Object obj2 = this.zzh;
        this.zzh = obj;
        return obj2;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzf);
        String strValueOf2 = String.valueOf(this.zzh);
        return a1.a.s(new StringBuilder(strValueOf.length() + 1 + strValueOf2.length()), strValueOf, C2300e4.i.f8399b, strValueOf2);
    }

    public zzhtw(boolean z2, zzhtw zzhtwVar, Object obj, zzhtw zzhtwVar2, zzhtw zzhtwVar3) {
        this.zza = zzhtwVar;
        this.zzf = obj;
        this.zzg = z2;
        this.zzi = 1;
        this.zzd = zzhtwVar2;
        this.zze = zzhtwVar3;
        zzhtwVar3.zzd = this;
        zzhtwVar2.zze = this;
    }
}
