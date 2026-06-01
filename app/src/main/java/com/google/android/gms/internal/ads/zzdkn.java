package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdkn implements zzifh {
    private final zzifq zza;

    private zzdkn(zzdkm zzdkmVar, zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzdkn zza(zzdkm zzdkmVar, zzifq zzifqVar) {
        return new zzdkn(zzdkmVar, zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    @Nullable
    public final /* bridge */ /* synthetic */ Object zzb() {
        return ((zzdkp) this.zza).zzb().zza();
    }
}
