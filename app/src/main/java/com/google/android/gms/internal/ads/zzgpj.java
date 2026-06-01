package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgpj extends zzgrs {
    final Iterator zza;
    Iterator zzb;
    final /* synthetic */ zzgpm zzc;

    public zzgpj(zzgpm zzgpmVar) {
        Objects.requireNonNull(zzgpmVar);
        this.zzc = zzgpmVar;
        this.zza = ((zzgpe) zzgpmVar.map.values()).listIterator(0);
        this.zzb = zzgpu.zza;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb.hasNext() || this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.zzb.hasNext()) {
            this.zzb = ((zzgpa) this.zza.next()).iterator();
        }
        return this.zzb.next();
    }
}
