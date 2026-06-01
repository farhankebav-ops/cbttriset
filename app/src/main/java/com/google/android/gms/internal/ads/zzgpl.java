package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgpl extends zzgpa {
    private final transient zzgpm zza;

    public zzgpl(zzgpm zzgpmVar) {
        this.zza = zzgpmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgpa, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.zzr(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgpa, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzgpj(this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.zza.size;
    }

    @Override // com.google.android.gms.internal.ads.zzgpa
    /* JADX INFO: renamed from: zza */
    public final zzgrs iterator() {
        return new zzgpj(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzgpa
    public final boolean zzf() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzgpa
    public final int zzg(Object[] objArr, int i2) {
        zzgrt zzgrtVarListIterator = ((zzgpe) this.zza.map.values()).listIterator(0);
        while (zzgrtVarListIterator.hasNext()) {
            i2 = ((zzgpa) zzgrtVarListIterator.next()).zzg(objArr, i2);
        }
        return i2;
    }
}
