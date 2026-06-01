package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhyn extends zzhvb {
    final zzhyp zza;
    zzhvd zzb;
    final /* synthetic */ zzhyq zzc;

    public zzhyn(zzhyq zzhyqVar) {
        Objects.requireNonNull(zzhyqVar);
        this.zzc = zzhyqVar;
        this.zza = new zzhyp(zzhyqVar, null);
        this.zzb = zzb();
    }

    private final zzhvd zzb() {
        zzhyp zzhypVar = this.zza;
        if (zzhypVar.hasNext()) {
            return zzhypVar.next().iterator();
        }
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb != null;
    }

    @Override // com.google.android.gms.internal.ads.zzhvd
    public final byte zza() {
        zzhvd zzhvdVar = this.zzb;
        if (zzhvdVar == null) {
            throw new NoSuchElementException();
        }
        byte bZza = zzhvdVar.zza();
        if (!this.zzb.hasNext()) {
            this.zzb = zzb();
        }
        return bZza;
    }
}
