package j2;

import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class r implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ThreadFactory f12091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f12092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AtomicLong f12093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Boolean f12094d;

    public r(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool) {
        this.f12091a = threadFactory;
        this.f12092b = str;
        this.f12093c = atomicLong;
        this.f12094d = bool;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f12091a.newThread(runnable);
        Objects.requireNonNull(threadNewThread);
        String str = this.f12092b;
        if (str != null) {
            AtomicLong atomicLong = this.f12093c;
            Objects.requireNonNull(atomicLong);
            threadNewThread.setName(String.format(Locale.ROOT, str, Long.valueOf(atomicLong.getAndIncrement())));
        }
        Boolean bool = this.f12094d;
        if (bool != null) {
            threadNewThread.setDaemon(bool.booleanValue());
        }
        return threadNewThread;
    }
}
