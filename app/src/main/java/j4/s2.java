package j4;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class s2 extends WeakReference {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f12443f = Boolean.parseBoolean(System.getProperty("io.grpc.ManagedChannel.enableAllocationTracking", com.ironsource.mediationsdk.metadata.a.g));
    public static final RuntimeException g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReferenceQueue f12444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentMap f12445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SoftReference f12447d;
    public final AtomicBoolean e;

    static {
        RuntimeException runtimeException = new RuntimeException("ManagedChannel allocation site not recorded.  Set -Dio.grpc.ManagedChannel.enableAllocationTracking=true to enable it");
        runtimeException.setStackTrace(new StackTraceElement[0]);
        g = runtimeException;
    }

    public s2(t2 t2Var, q2 q2Var, ReferenceQueue referenceQueue, ConcurrentMap concurrentMap) {
        super(t2Var, referenceQueue);
        this.e = new AtomicBoolean();
        this.f12447d = new SoftReference(f12443f ? new RuntimeException("ManagedChannel allocation site") : g);
        this.f12446c = q2Var.toString();
        this.f12444a = referenceQueue;
        this.f12445b = concurrentMap;
        concurrentMap.put(this, this);
        a(referenceQueue);
    }

    public static void a(ReferenceQueue referenceQueue) {
        while (true) {
            s2 s2Var = (s2) referenceQueue.poll();
            if (s2Var == null) {
                return;
            }
            SoftReference softReference = s2Var.f12447d;
            RuntimeException runtimeException = (RuntimeException) softReference.get();
            super.clear();
            s2Var.f12445b.remove(s2Var);
            softReference.clear();
            if (!s2Var.e.get()) {
                Level level = Level.SEVERE;
                Logger logger = t2.f12475d;
                if (logger.isLoggable(level)) {
                    LogRecord logRecord = new LogRecord(level, "*~*~*~ Previous channel {0} was garbage collected without being shut down! ~*~*~*" + System.getProperty("line.separator") + "    Make sure to call shutdown()/shutdownNow()");
                    logRecord.setLoggerName(logger.getName());
                    logRecord.setParameters(new Object[]{s2Var.f12446c});
                    logRecord.setThrown(runtimeException);
                    logger.log(logRecord);
                }
            }
        }
    }

    @Override // java.lang.ref.Reference
    public final void clear() {
        super.clear();
        this.f12445b.remove(this);
        this.f12447d.clear();
        a(this.f12444a);
    }
}
