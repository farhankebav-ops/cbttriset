package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdob implements zzifh {
    private final zzdnu zza;

    private zzdob(zzdnu zzdnuVar) {
        this.zza = zzdnuVar;
    }

    public static zzdob zzc(zzdnu zzdnuVar) {
        return new zzdob(zzdnuVar);
    }

    @Nullable
    public final zzbry zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    @Nullable
    public final /* synthetic */ Object zzb() {
        return this.zza.zza();
    }
}
