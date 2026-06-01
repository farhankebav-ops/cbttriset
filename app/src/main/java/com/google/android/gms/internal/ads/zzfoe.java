package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfoe implements zzguf {
    final /* synthetic */ zzfom zza;

    public zzfoe(zzfom zzfomVar) {
        Objects.requireNonNull(zzfomVar);
        this.zza = zzfomVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        this.zza.zzu(th);
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zzb(Object obj) {
        this.zza.zzt(obj);
    }
}
