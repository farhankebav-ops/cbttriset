package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdfm implements zzifh {
    private final zzdeo zza;

    private zzdfm(zzdeo zzdeoVar) {
        this.zza = zzdeoVar;
    }

    public static zzdfm zzc(zzdeo zzdeoVar) {
        return new zzdfm(zzdeoVar);
    }

    @Nullable
    public final zzfdj zza() {
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    @Nullable
    public final /* synthetic */ Object zzb() {
        return this.zza.zzo();
    }
}
