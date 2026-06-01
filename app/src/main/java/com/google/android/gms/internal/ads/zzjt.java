package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzjt implements zzkt {
    private final Object zza;
    private zzbf zzb;

    public zzjt(Object obj, zzup zzupVar) {
        this.zza = obj;
        this.zzb = zzupVar.zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzkt
    public final Object zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzkt
    public final zzbf zzb() {
        return this.zzb;
    }

    public final void zzc(zzbf zzbfVar) {
        this.zzb = zzbfVar;
    }
}
