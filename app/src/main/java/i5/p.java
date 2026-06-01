package i5;

import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f12026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f12027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference f12028c = new AtomicReference();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap f12029d = new ConcurrentHashMap();

    static {
        int i2;
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool;
        Properties properties = System.getProperties();
        boolean z2 = properties.containsKey("rx2.purge-enabled") ? Boolean.parseBoolean(properties.getProperty("rx2.purge-enabled")) : true;
        if (z2 && properties.containsKey("rx2.purge-period-seconds")) {
            try {
                i2 = Integer.parseInt(properties.getProperty("rx2.purge-period-seconds"));
            } catch (NumberFormatException unused) {
                i2 = 1;
            }
        } else {
            i2 = 1;
        }
        f12026a = z2;
        f12027b = i2;
        if (!z2) {
            return;
        }
        while (true) {
            AtomicReference atomicReference = f12028c;
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) atomicReference.get();
            if (scheduledExecutorService != null) {
                return;
            }
            scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new l("RxSchedulerPurge"));
            while (!atomicReference.compareAndSet(scheduledExecutorService, scheduledExecutorServiceNewScheduledThreadPool)) {
                if (atomicReference.get() != scheduledExecutorService) {
                    break;
                }
            }
            o oVar = new o(0);
            long j = f12027b;
            scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(oVar, j, j, TimeUnit.SECONDS);
            return;
            scheduledExecutorServiceNewScheduledThreadPool.shutdownNow();
        }
    }
}
