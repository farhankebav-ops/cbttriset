package i5;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class n extends AtomicReferenceArray implements Runnable, Callable, u4.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f12021b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f12022c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f12023d = new Object();
    public static final Object e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f12024a;

    public n(Runnable runnable, u4.a aVar) {
        super(3);
        this.f12024a = runnable;
        lazySet(0, aVar);
    }

    public final void a(Future future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == e) {
                return;
            }
            if (obj == f12022c) {
                future.cancel(false);
                return;
            } else if (obj == f12023d) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        run();
        return null;
    }

    @Override // u4.b
    public final void dispose() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        while (true) {
            Object obj6 = get(1);
            obj = e;
            if (obj6 == obj || obj6 == (obj4 = f12022c) || obj6 == (obj5 = f12023d)) {
                break;
            }
            boolean z2 = get(2) != Thread.currentThread();
            if (z2) {
                obj4 = obj5;
            }
            if (compareAndSet(1, obj6, obj4)) {
                if (obj6 != null) {
                    ((Future) obj6).cancel(z2);
                }
            }
        }
        do {
            obj2 = get(0);
            if (obj2 == obj || obj2 == (obj3 = f12021b) || obj2 == null) {
                return;
            }
        } while (!compareAndSet(0, obj2, obj3));
        ((u4.a) obj2).c(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        boolean zCompareAndSet;
        Object obj2;
        Object obj3 = f12023d;
        Object obj4 = f12022c;
        Object obj5 = f12021b;
        Object obj6 = e;
        lazySet(2, Thread.currentThread());
        try {
            this.f12024a.run();
        } finally {
            try {
            } catch (Throwable th) {
                do {
                    if (obj == obj4 || obj == obj3) {
                        break;
                    }
                } while (!zCompareAndSet);
            }
        }
        lazySet(2, null);
        Object obj7 = get(0);
        if (obj7 != obj5 && compareAndSet(0, obj7, obj6) && obj7 != null) {
            ((u4.a) obj7).c(this);
        }
        do {
            obj2 = get(1);
            if (obj2 == obj4 || obj2 == obj3) {
                return;
            }
        } while (!compareAndSet(1, obj2, obj6));
    }
}
