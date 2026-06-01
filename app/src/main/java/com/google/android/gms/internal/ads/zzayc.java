package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzayc implements Runnable {
    final /* synthetic */ zzayd zza;

    public zzayc(zzayd zzaydVar) {
        Objects.requireNonNull(zzaydVar);
        this.zza = zzaydVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbeu.zza(this.zza.zza);
    }
}
