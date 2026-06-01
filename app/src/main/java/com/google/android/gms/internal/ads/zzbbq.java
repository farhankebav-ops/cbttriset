package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbbq implements Runnable {
    final /* synthetic */ View zza;
    final /* synthetic */ zzbbu zzb;

    public zzbbq(zzbbu zzbbuVar, View view) {
        this.zza = view;
        Objects.requireNonNull(zzbbuVar);
        this.zzb = zzbbuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb(this.zza);
    }
}
