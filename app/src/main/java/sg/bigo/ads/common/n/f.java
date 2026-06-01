package sg.bigo.ads.common.n;

import android.os.Build;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes6.dex */
public abstract /* synthetic */ class f {
    public static /* synthetic */ void b(e eVar) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || eVar != ForkJoinPool.commonPool()) && !(zIsTerminated = eVar.isTerminated())) {
            eVar.shutdown();
            boolean z2 = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = eVar.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z2) {
                        eVar.shutdownNow();
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
