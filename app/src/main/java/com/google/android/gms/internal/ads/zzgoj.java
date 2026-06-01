package com.google.android.gms.internal.ads;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzgoj implements Iterator {
    int zzb;
    int zzc;
    int zzd;
    final /* synthetic */ zzgon zze;

    public /* synthetic */ zzgoj(zzgon zzgonVar, byte[] bArr) {
        Objects.requireNonNull(zzgonVar);
        this.zze = zzgonVar;
        this.zzb = zzgonVar.zzs();
        this.zzc = zzgonVar.zzf();
        this.zzd = -1;
    }

    private final void zzb() {
        if (this.zze.zzs() != this.zzb) {
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
        this.zzc = this.zze.zzg(this.zzc);
        return objZza;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzb();
        zzgmd.zzi(this.zzd >= 0, "no calls to next() since the last call to remove()");
        this.zzb += 32;
        int i2 = this.zzd;
        zzgon zzgonVar = this.zze;
        zzgonVar.remove(zzgonVar.zzo(i2));
        this.zzc--;
        this.zzd = -1;
    }

    public abstract Object zza(int i2);
}
