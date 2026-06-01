package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbox implements zzblx {
    final /* synthetic */ zzbpe zza;
    private final zzblx zzb;

    public zzbox(zzbpe zzbpeVar, zzblx zzblxVar) {
        Objects.requireNonNull(zzbpeVar);
        this.zza = zzbpeVar;
        this.zzb = zzblxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzblx
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        this.zzb.zza(this.zza, map);
    }

    public final /* synthetic */ zzblx zzb() {
        return this.zzb;
    }
}
