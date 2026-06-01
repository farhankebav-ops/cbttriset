package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgjb {
    private final zzfzn zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);
    private long zzc = -1;
    private long zzd = -1;
    private Throwable zze = null;
    private final int zzf;

    public zzgjb(int i2, zzfxa zzfxaVar, zzfzn zzfznVar) {
        this.zzf = i2;
        this.zza = zzfznVar;
    }

    public final void zza() {
        if (this.zzb.get()) {
            throw new IllegalStateException("Finished trace.");
        }
        this.zzc = SystemClock.uptimeMillis();
    }

    public final void zzb(Throwable th) {
        if (this.zzb.get()) {
            throw new IllegalStateException("Finished trace.");
        }
        this.zze = th;
    }

    public final void zzc() {
        AtomicBoolean atomicBoolean = this.zzb;
        if (atomicBoolean.getAndSet(true)) {
            throw new IllegalStateException("Finished trace.");
        }
        this.zzd = SystemClock.uptimeMillis();
        this.zza.zzb(this.zzf - 1, atomicBoolean.get() ? this.zzd - this.zzc : -1L, this.zze, null);
    }
}
