package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzccq implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzccv zzc;

    public zzccq(zzccv zzccvVar, int i2, int i8) {
        this.zza = i2;
        this.zzb = i8;
        Objects.requireNonNull(zzccvVar);
        this.zzc = zzccvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzccv zzccvVar = this.zzc;
        if (zzccvVar.zzt() != null) {
            zzccvVar.zzt().zzj(this.zza, this.zzb);
        }
    }
}
