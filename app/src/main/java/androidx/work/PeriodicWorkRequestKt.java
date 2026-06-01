package androidx.work;

import androidx.annotation.RequiresApi;
import androidx.work.PeriodicWorkRequest;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class PeriodicWorkRequestKt {
    public static final <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(long j, TimeUnit repeatIntervalTimeUnit) {
        k.e(repeatIntervalTimeUnit, "repeatIntervalTimeUnit");
        k.k();
        throw null;
    }

    public static final <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(long j, TimeUnit repeatIntervalTimeUnit, long j3, TimeUnit flexTimeIntervalUnit) {
        k.e(repeatIntervalTimeUnit, "repeatIntervalTimeUnit");
        k.e(flexTimeIntervalUnit, "flexTimeIntervalUnit");
        k.k();
        throw null;
    }

    @RequiresApi(26)
    public static final <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(Duration repeatInterval) {
        k.e(repeatInterval, "repeatInterval");
        k.k();
        throw null;
    }

    @RequiresApi(26)
    public static final <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(Duration repeatInterval, Duration flexTimeInterval) {
        k.e(repeatInterval, "repeatInterval");
        k.e(flexTimeInterval, "flexTimeInterval");
        k.k();
        throw null;
    }
}
