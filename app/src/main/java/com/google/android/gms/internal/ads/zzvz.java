package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzvz extends zzui {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzvz(zzwc zzwcVar, zzbf zzbfVar) {
        super(zzbfVar);
        Objects.requireNonNull(zzwcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzui, com.google.android.gms.internal.ads.zzbf
    public final zzbe zzb(int i2, zzbe zzbeVar, long j) {
        this.zzb.zzb(i2, zzbeVar, j);
        zzbeVar.zzk = true;
        return zzbeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzui, com.google.android.gms.internal.ads.zzbf
    public final zzbd zzd(int i2, zzbd zzbdVar, boolean z2) {
        this.zzb.zzd(i2, zzbdVar, z2);
        zzbdVar.zzf = true;
        return zzbdVar;
    }
}
