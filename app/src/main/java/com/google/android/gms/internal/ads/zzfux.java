package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfux implements zzfuw {
    private zzfux() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzfuw
    public final ExecutorService zza(int i2, ThreadFactory threadFactory, int i8) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    @Override // com.google.android.gms.internal.ads.zzfuw
    public final ExecutorService zzb(int i2) {
        return zza(1, Executors.defaultThreadFactory(), 2);
    }

    @Override // com.google.android.gms.internal.ads.zzfuw
    public final ExecutorService zzc(ThreadFactory threadFactory, int i2) {
        return zza(1, threadFactory, 1);
    }

    public /* synthetic */ zzfux(byte[] bArr) {
    }
}
