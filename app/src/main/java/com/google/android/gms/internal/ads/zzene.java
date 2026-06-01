package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzene implements zzdjl {
    final /* synthetic */ zzffu zza;

    public zzene(zzenh zzenhVar, zzffu zzffuVar) {
        this.zza = zzffuVar;
        Objects.requireNonNull(zzenhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdjl
    @Nullable
    public final zzffu zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzdjl
    public final void zza(boolean z2, Context context, @Nullable zzczb zzczbVar) {
    }
}
