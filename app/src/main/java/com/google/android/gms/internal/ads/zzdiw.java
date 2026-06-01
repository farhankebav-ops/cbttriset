package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdiw implements zzifh {
    private final zzdia zza;
    private final zzifq zzb;

    private zzdiw(zzdia zzdiaVar, zzifq zzifqVar) {
        this.zza = zzdiaVar;
        this.zzb = zzifqVar;
    }

    public static zzdiw zza(zzdia zzdiaVar, zzifq zzifqVar) {
        return new zzdiw(zzdiaVar, zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return this.zza.zzg((Executor) this.zzb.zzb());
    }
}
