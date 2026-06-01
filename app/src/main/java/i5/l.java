package i5;

import com.ironsource.C2300e4;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class l extends AtomicLong implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f12016c;

    public l(String str) {
        this(str, 5, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        String str = this.f12014a + '-' + incrementAndGet();
        Thread kVar = this.f12016c ? new k(runnable, str) : new Thread(runnable, str);
        kVar.setPriority(this.f12015b);
        kVar.setDaemon(true);
        return kVar;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public final String toString() {
        return a1.a.r(new StringBuilder("RxThreadFactory["), this.f12014a, C2300e4.i.e);
    }

    public l(String str, int i2, boolean z2) {
        this.f12014a = str;
        this.f12015b = i2;
        this.f12016c = z2;
    }
}
