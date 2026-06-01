package com.bytedance.sdk.openadsdk.common;

import android.os.Build;
import com.google.android.gms.internal.ads.zzgte;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class a {
    public static /* bridge */ /* synthetic */ Optional k(Object obj) {
        return (Optional) obj;
    }

    public static /* synthetic */ void s(zzgte zzgteVar) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || zzgteVar != ForkJoinPool.commonPool()) && !(zIsTerminated = zzgteVar.isTerminated())) {
            zzgteVar.shutdown();
            boolean z2 = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = zzgteVar.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z2) {
                        zzgteVar.shutdownNow();
                        z2 = true;
                    }
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static /* synthetic */ void v(ExecutorService executorService) {
        ThreadPoolExecutor threadPoolExecutor;
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || executorService != ForkJoinPool.commonPool()) && !(zIsTerminated = (threadPoolExecutor = (ThreadPoolExecutor) executorService).isTerminated())) {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) executorService;
            scheduledThreadPoolExecutor.shutdown();
            boolean z2 = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = threadPoolExecutor.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z2) {
                        scheduledThreadPoolExecutor.shutdownNow();
                        z2 = true;
                    }
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
