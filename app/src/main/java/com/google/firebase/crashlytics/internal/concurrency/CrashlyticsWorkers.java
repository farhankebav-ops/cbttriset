package com.google.firebase.crashlytics.internal.concurrency;

import android.os.Looper;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n6.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class CrashlyticsWorkers {
    public static final Companion Companion = new Companion(null);
    private static boolean enforcement;
    public final CrashlyticsWorker common;
    public final CrashlyticsWorker dataCollect;
    public final CrashlyticsWorker diskWrite;
    public final CrashlyticsWorker network;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String checkBackgroundThread$lambda$2() {
            return a1.a.e('.', CrashlyticsWorkers.Companion.getThreadName(), new StringBuilder("Must be called on a background thread, was called on "));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String checkBlockingThread$lambda$1() {
            return a1.a.e('.', CrashlyticsWorkers.Companion.getThreadName(), new StringBuilder("Must be called on a blocking thread, was called on "));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String checkNotMainThread$lambda$0() {
            return a1.a.e('.', CrashlyticsWorkers.Companion.getThreadName(), new StringBuilder("Must not be called on a main thread, was called on "));
        }

        private final void checkThread(e6.a aVar, e6.a aVar2) {
            if (((Boolean) aVar.invoke()).booleanValue()) {
                return;
            }
            Logger.getLogger().d((String) aVar2.invoke());
            getEnforcement();
        }

        private final String getThreadName() {
            return Thread.currentThread().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isBackgroundThread() {
            String threadName = getThreadName();
            k.d(threadName, "<get-threadName>(...)");
            return m.q0(threadName, "Firebase Background Thread #", false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isBlockingThread() {
            String threadName = getThreadName();
            k.d(threadName, "<get-threadName>(...)");
            return m.q0(threadName, "Firebase Blocking Thread #", false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isNotMainThread() {
            return !Looper.getMainLooper().isCurrentThread();
        }

        public final void checkBackgroundThread() {
            checkThread(new CrashlyticsWorkers$Companion$checkBackgroundThread$1(this), new androidx.activity.m(4));
        }

        public final void checkBlockingThread() {
            checkThread(new CrashlyticsWorkers$Companion$checkBlockingThread$1(this), new androidx.activity.m(6));
        }

        public final void checkNotMainThread() {
            checkThread(new CrashlyticsWorkers$Companion$checkNotMainThread$1(this), new androidx.activity.m(5));
        }

        public final boolean getEnforcement() {
            return CrashlyticsWorkers.enforcement;
        }

        public final void setEnforcement(boolean z2) {
            CrashlyticsWorkers.enforcement = z2;
        }

        private Companion() {
        }

        public static /* synthetic */ void getEnforcement$annotations() {
        }
    }

    public CrashlyticsWorkers(ExecutorService backgroundExecutorService, ExecutorService blockingExecutorService) {
        k.e(backgroundExecutorService, "backgroundExecutorService");
        k.e(blockingExecutorService, "blockingExecutorService");
        this.common = new CrashlyticsWorker(backgroundExecutorService);
        this.diskWrite = new CrashlyticsWorker(backgroundExecutorService);
        this.dataCollect = new CrashlyticsWorker(backgroundExecutorService);
        this.network = new CrashlyticsWorker(blockingExecutorService);
    }

    public static final void checkBackgroundThread() {
        Companion.checkBackgroundThread();
    }

    public static final void checkBlockingThread() {
        Companion.checkBlockingThread();
    }

    public static final void checkNotMainThread() {
        Companion.checkNotMainThread();
    }

    public static final boolean getEnforcement() {
        return Companion.getEnforcement();
    }

    public static final void setEnforcement(boolean z2) {
        Companion.setEnforcement(z2);
    }
}
