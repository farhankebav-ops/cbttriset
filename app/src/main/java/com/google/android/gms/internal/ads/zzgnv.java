package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
class zzgnv extends zzgnt implements List {
    final /* synthetic */ zzgnw zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgnv(zzgnw zzgnwVar, Object obj, List list, zzgnt zzgntVar) {
        super(zzgnwVar, obj, list, zzgntVar);
        Objects.requireNonNull(zzgnwVar);
        this.zzf = zzgnwVar;
    }

    @Override // java.util.List
    public final void add(int i2, Object obj) {
        zza();
        boolean zIsEmpty = this.zzb.isEmpty();
        ((List) this.zzb).add(i2, obj);
        zzgnw zzgnwVar = this.zzf;
        zzgnwVar.zzq(zzgnwVar.zzp() + 1);
        if (zIsEmpty) {
            zzc();
        }
    }

    @Override // java.util.List
    public final boolean addAll(int i2, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = ((List) this.zzb).addAll(i2, collection);
        if (!zAddAll) {
            return zAddAll;
        }
        int size2 = this.zzb.size();
        zzgnw zzgnwVar = this.zzf;
        zzgnwVar.zzq(zzgnwVar.zzp() + (size2 - size));
        if (size != 0) {
            return zAddAll;
        }
        zzc();
        return true;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zza();
        return ((List) this.zzb).get(i2);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        zza();
        return ((List) this.zzb).indexOf(obj);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        zza();
        return ((List) this.zzb).lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        zza();
        return new zzgnu(this);
    }

    @Override // java.util.List
    public final Object remove(int i2) {
        zza();
        Object objRemove = ((List) this.zzb).remove(i2);
        this.zzf.zzq(r0.zzp() - 1);
        zzb();
        return objRemove;
    }

    @Override // java.util.List
    public final Object set(int i2, Object obj) {
        zza();
        return ((List) this.zzb).set(i2, obj);
    }

    @Override // java.util.List
    public final List subList(int i2, int i8) {
        zza();
        List listSubList = ((List) this.zzb).subList(i2, i8);
        zzgnt zzgntVar = this.zzc;
        if (zzgntVar == null) {
            zzgntVar = this;
        }
        return this.zzf.zzg(this.zza, listSubList, zzgntVar);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i2) {
        zza();
        return new zzgnu(this, i2);
    }
}
