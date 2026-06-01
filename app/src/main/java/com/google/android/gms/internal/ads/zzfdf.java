package com.google.android.gms.internal.ads;

import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfdf implements zzglu {
    final /* synthetic */ zzfdi zza;

    public zzfdf(zzfdi zzfdiVar) {
        Objects.requireNonNull(zzfdiVar);
        this.zza = zzfdiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzglu
    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        zzbxj zzbxjVar = (zzbxj) obj;
        zzfdg zzfdgVar = new zzfdg(zzbxjVar, new zzfio(zzbxjVar.zzj), null);
        zzfdi zzfdiVar = this.zza;
        zzfdiVar.zzd(zzfdgVar);
        return zzfdiVar.zzc();
    }
}
