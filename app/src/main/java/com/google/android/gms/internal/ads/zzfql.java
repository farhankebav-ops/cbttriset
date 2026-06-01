package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfql implements Runnable {
    final /* synthetic */ zzfqm zza;
    private final WebView zzb;

    public zzfql(zzfqm zzfqmVar) {
        Objects.requireNonNull(zzfqmVar);
        this.zza = zzfqmVar;
        this.zzb = zzfqmVar.zzq();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.destroy();
    }
}
