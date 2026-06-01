package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfkx implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;
    private final zzifq zzc;

    private zzfkx(zzfkw zzfkwVar, zzifq zzifqVar, zzifq zzifqVar2, zzifq zzifqVar3) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
        this.zzc = zzifqVar3;
    }

    public static zzfkx zza(zzfkw zzfkwVar, zzifq zzifqVar, zzifq zzifqVar2, zzifq zzifqVar3) {
        return new zzfkx(zzfkwVar, zzifqVar, zzifqVar2, zzifqVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbqp zzbqpVarZzb = new zzbqg().zzb(((zzcjv) this.zza).zza(), ((zzckk) this.zzb).zza(), (zzflp) this.zzc.zzb());
        zzifp.zzb(zzbqpVarZzb);
        return zzbqpVarZzb;
    }
}
