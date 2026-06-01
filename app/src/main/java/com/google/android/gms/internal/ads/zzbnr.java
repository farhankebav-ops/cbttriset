package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbnr implements zzgtq {
    final /* synthetic */ zzbnj zza;

    public zzbnr(zzbnv zzbnvVar, zzbnj zzbnjVar) {
        this.zza = zzbnjVar;
        Objects.requireNonNull(zzbnvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgtq
    public final /* bridge */ /* synthetic */ j2.q zza(Object obj) throws Exception {
        zzcca zzccaVar = new zzcca();
        ((zzbnp) obj).zze(this.zza, new zzbnq(this, zzccaVar));
        return zzccaVar;
    }
}
