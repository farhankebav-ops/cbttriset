package com.google.android.gms.internal.ads;

import com.ironsource.C2393j8;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcdb implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzcdf zzb;

    public zzcdb(zzcdf zzcdfVar, boolean z2) {
        this.zza = z2;
        Objects.requireNonNull(zzcdfVar);
        this.zzb = zzcdfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzI("windowVisibilityChanged", new String[]{C2393j8.k, String.valueOf(this.zza)});
    }
}
