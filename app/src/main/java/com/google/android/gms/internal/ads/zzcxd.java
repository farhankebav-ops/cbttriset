package com.google.android.gms.internal.ads;

import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcxd implements zzguf {
    final /* synthetic */ zzcxf zza;

    public zzcxd(zzcxf zzcxfVar) {
        Objects.requireNonNull(zzcxfVar);
        this.zza = zzcxfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(@NullableDecl Object obj) {
        this.zza.zzk().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
    }
}
