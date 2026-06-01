package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhyw implements Iterator {
    final /* synthetic */ zzhyy zza;
    private int zzb;
    private boolean zzc;
    private Iterator zzd;

    public /* synthetic */ zzhyw(zzhyy zzhyyVar, byte[] bArr) {
        Objects.requireNonNull(zzhyyVar);
        this.zza = zzhyyVar;
        this.zzb = -1;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzk().entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i2 = this.zzb + 1;
        zzhyy zzhyyVar = this.zza;
        if (i2 >= zzhyyVar.zzj()) {
            return !zzhyyVar.zzk().isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i2 = this.zzb + 1;
        this.zzb = i2;
        zzhyy zzhyyVar = this.zza;
        return i2 < zzhyyVar.zzj() ? (zzhyv) zzhyyVar.zzi()[i2] : (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        zzhyy zzhyyVar = this.zza;
        zzhyyVar.zzh();
        int i2 = this.zzb;
        if (i2 >= zzhyyVar.zzj()) {
            zza().remove();
        } else {
            this.zzb = i2 - 1;
            zzhyyVar.zzg(i2);
        }
    }
}
