package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdjv implements zzifh {
    private final zzdju zza;

    private zzdjv(zzdju zzdjuVar) {
        this.zza = zzdjuVar;
    }

    public static zzdjv zzc(zzdju zzdjuVar) {
        return new zzdjv(zzdjuVar);
    }

    @Nullable
    public final com.google.android.gms.ads.internal.client.zzbk zza() {
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    @Nullable
    public final /* synthetic */ Object zzb() {
        return this.zza.zzb();
    }
}
