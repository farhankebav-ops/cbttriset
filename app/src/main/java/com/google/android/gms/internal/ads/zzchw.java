package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzchw implements Runnable {
    final /* synthetic */ zzcib zza;

    public zzchw(zzcib zzcibVar) {
        Objects.requireNonNull(zzcibVar);
        this.zza = zzcibVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        super/*android.webkit.WebView*/.destroy();
    }
}
