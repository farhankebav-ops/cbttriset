package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.common.internal.Preconditions;
import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class zzx implements Closeable {
    final /* synthetic */ TaskQueue zza;

    public /* synthetic */ zzx(TaskQueue taskQueue, zzw zzwVar) {
        this.zza = taskQueue;
        Preconditions.checkState(((Thread) taskQueue.zzd.getAndSet(Thread.currentThread())) == null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.zza.zzd.set(null);
        this.zza.zzc();
    }
}
