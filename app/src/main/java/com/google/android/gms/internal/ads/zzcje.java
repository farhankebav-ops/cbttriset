package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcje extends Thread {
    final /* synthetic */ Runnable zza;
    final /* synthetic */ zzcjf zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcje(zzcjf zzcjfVar, Runnable runnable, String str, Runnable runnable2) {
        super(runnable, str);
        this.zza = runnable2;
        Objects.requireNonNull(zzcjfVar);
        this.zzb = zzcjfVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.zzb.zza());
        this.zza.run();
    }
}
