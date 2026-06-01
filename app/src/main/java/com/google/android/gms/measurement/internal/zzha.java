package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzha implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzhb zzb;

    public zzha(zzhb zzhbVar, boolean z2) {
        this.zza = z2;
        Objects.requireNonNull(zzhbVar);
        this.zzb = zzhbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc().zzas(this.zza);
    }
}
