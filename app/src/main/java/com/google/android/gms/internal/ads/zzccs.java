package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzccs implements Runnable {
    final /* synthetic */ zzccv zza;

    public zzccs(zzccv zzccvVar) {
        Objects.requireNonNull(zzccvVar);
        this.zza = zzccvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzccv zzccvVar = this.zza;
        if (zzccvVar.zzt() != null) {
            if (!zzccvVar.zzu()) {
                zzccvVar.zzt().zzk();
                zzccvVar.zzv(true);
            }
            zzccvVar.zzt().zzc();
        }
    }
}
