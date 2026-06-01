package com.ironsource;

import android.os.Build;
import com.unity3d.services.core.request.CancelableThreadPoolExecutor;
import com.vungle.ads.internal.executor.VungleThreadPoolExecutor;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.ExtendedSSLSession;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SNIServerName;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract /* synthetic */ class hi {
    public static /* bridge */ /* synthetic */ boolean A(SSLSession sSLSession) {
        return sSLSession instanceof ExtendedSSLSession;
    }

    public static /* bridge */ /* synthetic */ Class C() {
        return Optional.class;
    }

    public static /* bridge */ /* synthetic */ Class d() {
        return CompletableFuture.class;
    }

    public static /* bridge */ /* synthetic */ ExtendedSSLSession k(SSLSession sSLSession) {
        return (ExtendedSSLSession) sSLSession;
    }

    public static /* bridge */ /* synthetic */ SNIHostName l(Object obj) {
        return (SNIHostName) obj;
    }

    public static /* bridge */ /* synthetic */ SNIServerName m(Object obj) {
        return (SNIServerName) obj;
    }

    public static /* synthetic */ void o(C2399je c2399je) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || c2399je != ForkJoinPool.commonPool()) && !(zIsTerminated = c2399je.isTerminated())) {
            c2399je.shutdown();
            boolean z2 = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = c2399je.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z2) {
                        c2399je.shutdownNow();
                        z2 = true;
                    }
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static /* synthetic */ void p(CancelableThreadPoolExecutor cancelableThreadPoolExecutor) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || cancelableThreadPoolExecutor != ForkJoinPool.commonPool()) && !(zIsTerminated = cancelableThreadPoolExecutor.isTerminated())) {
            cancelableThreadPoolExecutor.shutdown();
            boolean z2 = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = cancelableThreadPoolExecutor.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z2) {
                        cancelableThreadPoolExecutor.shutdownNow();
                        z2 = true;
                    }
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static /* synthetic */ void q(VungleThreadPoolExecutor vungleThreadPoolExecutor) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || vungleThreadPoolExecutor != ForkJoinPool.commonPool()) && !(zIsTerminated = vungleThreadPoolExecutor.isTerminated())) {
            vungleThreadPoolExecutor.shutdown();
            boolean z2 = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = vungleThreadPoolExecutor.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z2) {
                        vungleThreadPoolExecutor.shutdownNow();
                        z2 = true;
                    }
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void r(j4.o2 o2Var) {
        if ((Build.VERSION.SDK_INT <= 23 || o2Var != ForkJoinPool.commonPool()) && !o2Var.f12350a.isTerminated()) {
            o2Var.shutdown();
            throw null;
        }
    }

    public static /* bridge */ /* synthetic */ boolean y(Object obj) {
        return obj instanceof SNIHostName;
    }
}
