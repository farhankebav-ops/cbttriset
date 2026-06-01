package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzccg implements zzguf {
    final /* synthetic */ zzcce zza;
    final /* synthetic */ zzccc zzb;

    public zzccg(zzcch zzcchVar, zzcce zzcceVar, zzccc zzcccVar) {
        this.zza = zzcceVar;
        this.zzb = zzcccVar;
        Objects.requireNonNull(zzcchVar);
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zzb(@Nullable Object obj) {
        this.zza.zza(obj);
    }
}
