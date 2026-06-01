package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaps implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzapu zzc;

    public zzaps(zzapu zzapuVar, String str, long j) {
        this.zza = str;
        this.zzb = j;
        Objects.requireNonNull(zzapuVar);
        this.zzc = zzapuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzapu zzapuVar = this.zzc;
        zzapuVar.zzx().zza(this.zza, this.zzb);
        zzapuVar.zzx().zzb(zzapuVar.toString());
    }
}
