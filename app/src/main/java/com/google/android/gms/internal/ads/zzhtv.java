package com.google.android.gms.internal.ads;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzhtv implements Iterator {
    zzhtw zza;
    zzhtw zzb;
    int zzc;
    final /* synthetic */ zzhtx zzd;

    public zzhtv(zzhtx zzhtxVar) {
        Objects.requireNonNull(zzhtxVar);
        this.zzd = zzhtxVar;
        this.zza = zzhtxVar.zzd.zzd;
        this.zzb = null;
        this.zzc = zzhtxVar.zzc;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza != this.zzd.zzd;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzhtw zzhtwVar = this.zzb;
        if (zzhtwVar == null) {
            throw new IllegalStateException();
        }
        zzhtx zzhtxVar = this.zzd;
        zzhtxVar.zzd(zzhtwVar, true);
        this.zzb = null;
        this.zzc = zzhtxVar.zzc;
    }

    public final zzhtw zza() {
        zzhtx zzhtxVar = this.zzd;
        zzhtw zzhtwVar = this.zza;
        if (zzhtwVar == zzhtxVar.zzd) {
            throw new NoSuchElementException();
        }
        if (zzhtxVar.zzc != this.zzc) {
            throw new ConcurrentModificationException();
        }
        this.zza = zzhtwVar.zzd;
        this.zzb = zzhtwVar;
        return zzhtwVar;
    }
}
