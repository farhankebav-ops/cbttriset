package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzce implements Iterator {
    int zzb;
    int zzc;
    int zzd = -1;
    final /* synthetic */ zzci zze;

    public /* synthetic */ zzce(zzci zzciVar, zzcd zzcdVar) {
        this.zze = zzciVar;
        this.zzb = zzciVar.zzf;
        this.zzc = zzciVar.zze();
    }

    private final void zzb() {
        if (this.zze.zzf != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzc >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        zzb();
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i2 = this.zzc;
        this.zzd = i2;
        Object objZza = zza(i2);
        this.zzc = this.zze.zzf(this.zzc);
        return objZza;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzb();
        zzaz.zzf(this.zzd >= 0, "no calls to next() since the last call to remove()");
        this.zzb += 32;
        int i2 = this.zzd;
        zzci zzciVar = this.zze;
        zzciVar.remove(zzci.zzg(zzciVar, i2));
        this.zzc--;
        this.zzd = -1;
    }

    public abstract Object zza(int i2);
}
