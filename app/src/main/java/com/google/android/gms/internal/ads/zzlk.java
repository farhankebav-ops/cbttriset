package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzlk extends zzui {
    private final zzbe zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzlk(zzll zzllVar, zzbf zzbfVar) {
        super(zzbfVar);
        Objects.requireNonNull(zzllVar);
        this.zzc = new zzbe();
    }

    @Override // com.google.android.gms.internal.ads.zzui, com.google.android.gms.internal.ads.zzbf
    public final zzbd zzd(int i2, zzbd zzbdVar, boolean z2) {
        zzbf zzbfVar = this.zzb;
        zzbd zzbdVarZzd = zzbfVar.zzd(i2, zzbdVar, z2);
        if (zzbfVar.zzb(zzbdVarZzd.zzc, this.zzc, 0L).zzb()) {
            zzbdVarZzd.zza(zzbdVar.zza, zzbdVar.zzb, zzbdVar.zzc, zzbdVar.zzd, 0L, zzc.zza, true);
            return zzbdVarZzd;
        }
        zzbdVarZzd.zzf = true;
        return zzbdVarZzd;
    }
}
