package androidx.appcompat.app;

import android.app.Notification;
import android.hardware.camera2.params.OutputConfiguration;
import android.location.GnssStatus;
import android.media.AudioRecordingConfiguration;
import android.os.Build;
import android.view.Surface;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class c {
    public static /* bridge */ /* synthetic */ Class B() {
        return Notification.DecoratedCustomViewStyle.class;
    }

    public static /* bridge */ /* synthetic */ Notification.MessagingStyle g(Object obj) {
        return (Notification.MessagingStyle) obj;
    }

    public static /* synthetic */ OutputConfiguration i(Surface surface) {
        return new OutputConfiguration(surface);
    }

    public static /* bridge */ /* synthetic */ OutputConfiguration j(Object obj) {
        return (OutputConfiguration) obj;
    }

    public static /* bridge */ /* synthetic */ GnssStatus k(Object obj) {
        return (GnssStatus) obj;
    }

    public static /* bridge */ /* synthetic */ AudioRecordingConfiguration l(Object obj) {
        return (AudioRecordingConfiguration) obj;
    }

    public static /* bridge */ /* synthetic */ Class o() {
        return Notification.MessagingStyle.class;
    }

    public static /* synthetic */ void q() {
    }

    public static /* synthetic */ void v(ExecutorService executorService) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || executorService != ForkJoinPool.commonPool()) && !(zIsTerminated = executorService.isTerminated())) {
            executorService.shutdown();
            boolean z2 = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z2) {
                        executorService.shutdownNow();
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
