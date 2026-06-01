package androidx.profileinstaller;

import android.app.job.JobInfo;
import android.net.Uri;
import android.os.Build;
import android.webkit.ServiceWorkerWebSettings;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bytedance.sdk.component.lEW.EO.vCE;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ JobInfo.TriggerContentUri d(Uri uri, int i2) {
        return new JobInfo.TriggerContentUri(uri, i2);
    }

    public static /* bridge */ /* synthetic */ ServiceWorkerWebSettings h(Object obj) {
        return (ServiceWorkerWebSettings) obj;
    }

    public static /* bridge */ /* synthetic */ Supplier k(Object obj) {
        return (Supplier) obj;
    }

    public static /* synthetic */ void l() {
    }

    public static /* synthetic */ void u(GlideExecutor glideExecutor) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || glideExecutor != ForkJoinPool.commonPool()) && !(zIsTerminated = glideExecutor.isTerminated())) {
            glideExecutor.shutdown();
            boolean z2 = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = glideExecutor.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z2) {
                        glideExecutor.shutdownNow();
                        z2 = true;
                    }
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static /* synthetic */ void v(vCE vce) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || vce != ForkJoinPool.commonPool()) && !(zIsTerminated = vce.isTerminated())) {
            vce.shutdown();
            boolean z2 = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = vce.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z2) {
                        vce.shutdownNow();
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
