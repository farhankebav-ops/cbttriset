package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfpm implements Runnable {
    final /* synthetic */ float zza;
    final /* synthetic */ zzfpn zzb;

    public zzfpm(zzfpn zzfpnVar, float f4) {
        this.zza = f4;
        Objects.requireNonNull(zzfpnVar);
        this.zzb = zzfpnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzg().zzf(this.zza);
    }
}
