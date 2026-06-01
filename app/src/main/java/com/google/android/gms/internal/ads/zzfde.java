package com.google.android.gms.internal.ads;

import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfde implements zzglu {
    final /* synthetic */ zzfdi zza;

    public zzfde(zzfdi zzfdiVar) {
        Objects.requireNonNull(zzfdiVar);
        this.zza = zzfdiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzglu
    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzg("", (zzecj) obj);
        com.google.android.gms.ads.internal.util.zze.zza("Failed to get a cache key, reverting to legacy flow.");
        zzfdi zzfdiVar = this.zza;
        zzfdiVar.zzd(new zzfdg(null, zzfdiVar.zzb(), null));
        return zzfdiVar.zzc();
    }
}
