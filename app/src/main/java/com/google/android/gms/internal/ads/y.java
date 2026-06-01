package com.google.android.gms.internal.ads;

import android.media.AudioRouting$OnRoutingChangedListener;
import android.media.MediaCodec;
import android.os.Build;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class y {
    public static /* synthetic */ void B(com.google.android.gms.internal.mlkit_common.zzav zzavVar) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || zzavVar != ForkJoinPool.commonPool()) && !(zIsTerminated = zzavVar.isTerminated())) {
            zzavVar.shutdown();
            boolean z2 = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = zzavVar.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z2) {
                        zzavVar.shutdownNow();
                        z2 = true;
                    }
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static /* synthetic */ void C(ExecutorService executorService) {
        ThreadPoolExecutor threadPoolExecutor;
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || executorService != ForkJoinPool.commonPool()) && !(zIsTerminated = (threadPoolExecutor = (ThreadPoolExecutor) executorService).isTerminated())) {
            threadPoolExecutor.shutdown();
            boolean z2 = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = threadPoolExecutor.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z2) {
                        threadPoolExecutor.shutdownNow();
                        z2 = true;
                    }
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static /* bridge */ /* synthetic */ AudioRouting$OnRoutingChangedListener h(Object obj) {
        return (AudioRouting$OnRoutingChangedListener) obj;
    }

    public static /* synthetic */ MediaCodec.CryptoInfo.Pattern i() {
        return new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    public static /* synthetic */ MediaCodec.CryptoInfo.Pattern j(int i2, int i8) {
        return new MediaCodec.CryptoInfo.Pattern(i2, i8);
    }

    public static /* synthetic */ PriorityQueue n(Comparator comparator) {
        return new PriorityQueue(comparator);
    }

    public static /* synthetic */ void s() {
    }
}
