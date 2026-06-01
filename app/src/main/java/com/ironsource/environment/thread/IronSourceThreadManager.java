package com.ironsource.environment.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.camera.core.impl.utils.c;
import androidx.core.location.LocationRequestCompat;
import com.ironsource.C2399je;
import com.ironsource.C2531r4;
import com.ironsource.T9;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class IronSourceThreadManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f8490a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Handler f8492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final T9 f8493d;
    private static final T9 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final T9 f8494f;
    private static final f g;
    private static final f h;
    public static final IronSourceThreadManager INSTANCE = new IronSourceThreadManager();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Handler f8491b = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a extends l implements e6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8495a = new a();

        public a() {
            super(0);
        }

        @Override // e6.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C2399je invoke() {
            return new C2399je(0, null, null, 7, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b extends l implements e6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f8496a = new b();

        public b() {
            super(0);
        }

        @Override // e6.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final T9 invoke() {
            T9 t9 = new T9("managersThread");
            t9.start();
            t9.a();
            return t9;
        }
    }

    static {
        HandlerThread handlerThread = new HandlerThread("IronSourceInitiatorHandler");
        handlerThread.start();
        f8492c = new Handler(handlerThread.getLooper());
        T9 t9 = new T9("mediationBackground");
        t9.start();
        t9.a();
        f8493d = t9;
        T9 t92 = new T9("adapterBackground");
        t92.start();
        t92.a();
        e = t92;
        T9 t93 = new T9("publisher-callbacks");
        t93.start();
        t93.a();
        f8494f = t93;
        g = n7.b.C(a.f8495a);
        h = n7.b.C(b.f8496a);
    }

    private IronSourceThreadManager() {
    }

    private final C2399je a() {
        return (C2399je) g.getValue();
    }

    public static /* synthetic */ void postAdapterBackgroundTask$default(IronSourceThreadManager ironSourceThreadManager, Runnable runnable, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        ironSourceThreadManager.postAdapterBackgroundTask(runnable, j);
    }

    public static /* synthetic */ void postMediationBackgroundTask$default(IronSourceThreadManager ironSourceThreadManager, Runnable runnable, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        ironSourceThreadManager.postMediationBackgroundTask(runnable, j);
    }

    public static /* synthetic */ void postOnUiThreadTask$default(IronSourceThreadManager ironSourceThreadManager, Runnable runnable, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        ironSourceThreadManager.postOnUiThreadTask(runnable, j);
    }

    public static /* synthetic */ void postPublisherCallback$default(IronSourceThreadManager ironSourceThreadManager, Runnable runnable, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        ironSourceThreadManager.postPublisherCallback(runnable, j);
    }

    public final void executeTasks(boolean z2, boolean z7, List<? extends Runnable> tasks) {
        k.e(tasks, "tasks");
        if (!z2) {
            Iterator<? extends Runnable> it = tasks.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            return;
        }
        if (!z7) {
            Iterator<? extends Runnable> it2 = tasks.iterator();
            while (it2.hasNext()) {
                postMediationBackgroundTask$default(INSTANCE, it2.next(), 0L, 2, null);
            }
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(tasks.size());
        Iterator<? extends Runnable> it3 = tasks.iterator();
        while (it3.hasNext()) {
            postMediationBackgroundTask$default(INSTANCE, new c(it3.next(), countDownLatch, 1), 0L, 2, null);
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e4) {
            C2531r4.d().a(e4);
        }
    }

    public final Handler getInitHandler() {
        return f8492c;
    }

    public final T9 getSharedManagersThread() {
        return (T9) h.getValue();
    }

    public final ThreadPoolExecutor getThreadPoolExecutor() {
        return new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors(), LocationRequestCompat.PASSIVE_INTERVAL, TimeUnit.NANOSECONDS, new LinkedBlockingQueue());
    }

    public final boolean getUseSharedExecutorService() {
        return f8490a;
    }

    public final void postAdapterBackgroundTask(Runnable action) {
        k.e(action, "action");
        postAdapterBackgroundTask$default(this, action, 0L, 2, null);
    }

    public final void postMediationBackgroundTask(Runnable action) {
        k.e(action, "action");
        postMediationBackgroundTask$default(this, action, 0L, 2, null);
    }

    public final void postOnUiThreadTask(Runnable action) {
        k.e(action, "action");
        postOnUiThreadTask$default(this, action, 0L, 2, null);
    }

    public final void postPublisherCallback(Runnable action) {
        k.e(action, "action");
        postPublisherCallback$default(this, action, 0L, 2, null);
    }

    public final void removeAdapterBackgroundTask(Runnable action) {
        k.e(action, "action");
        if (a(action)) {
            a().remove(action);
        } else {
            e.b(action);
        }
    }

    public final void removeMediationBackgroundTask(Runnable action) {
        k.e(action, "action");
        if (a(action)) {
            a().remove(action);
        } else {
            f8493d.b(action);
        }
    }

    public final void removeUiThreadTask(Runnable action) {
        k.e(action, "action");
        f8491b.removeCallbacks(action);
    }

    public final void setUseSharedExecutorService(boolean z2) {
        f8490a = z2;
    }

    private final boolean a(Runnable runnable) {
        return f8490a && a().getQueue().contains(runnable);
    }

    public final void postAdapterBackgroundTask(Runnable action, long j) {
        k.e(action, "action");
        if (f8490a) {
            a().schedule(action, j, TimeUnit.MILLISECONDS);
        } else {
            e.a(action, j);
        }
    }

    public final void postMediationBackgroundTask(Runnable action, long j) {
        k.e(action, "action");
        if (f8490a) {
            a().schedule(action, j, TimeUnit.MILLISECONDS);
        } else {
            f8493d.a(action, j);
        }
    }

    public final void postOnUiThreadTask(Runnable action, long j) {
        k.e(action, "action");
        f8491b.postDelayed(action, j);
    }

    public final void postPublisherCallback(Runnable action, long j) {
        k.e(action, "action");
        f8494f.a(action, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Runnable it, CountDownLatch latch) {
        k.e(it, "$it");
        k.e(latch, "$latch");
        it.run();
        a(latch);
    }

    private static final void a(CountDownLatch latch) {
        k.e(latch, "$latch");
        latch.countDown();
    }
}
