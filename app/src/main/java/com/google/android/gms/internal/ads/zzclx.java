package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzclx implements zzedh {
    private final zzckz zza;
    private final zzclw zzb;
    private zzebo zzc;

    public /* synthetic */ zzclx(zzckz zzckzVar, zzclw zzclwVar, byte[] bArr) {
        this.zza = zzckzVar;
        this.zzb = zzclwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzedh
    public final zzedi zza() {
        zzifp.zzc(this.zzc, zzebo.class);
        return new zzcly(this.zza, this.zzb, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzedh
    public final /* bridge */ /* synthetic */ zzedh zzb(zzebo zzeboVar) {
        this.zzc = zzeboVar;
        return this;
    }
}
