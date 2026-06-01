package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzapl {
    private final Executor zza;

    public zzapl(Handler handler) {
        this.zza = new zzapj(this, handler);
    }

    public final void zza(zzapu zzapuVar, zzaqa zzaqaVar, Runnable runnable) {
        zzapuVar.zzp();
        zzapuVar.zzc("post-response");
        ((zzapj) this.zza).zza.post(new zzapk(zzapuVar, zzaqaVar, runnable));
    }

    public final void zzb(zzapu zzapuVar, zzaqd zzaqdVar) {
        zzapuVar.zzc("post-error");
        ((zzapj) this.zza).zza.post(new zzapk(zzapuVar, zzaqa.zzb(zzaqdVar), null));
    }
}
