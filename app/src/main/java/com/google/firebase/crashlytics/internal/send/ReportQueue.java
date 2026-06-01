package com.google.firebase.crashlytics.internal.send;

import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.common.OnDemandCounter;
import com.google.firebase.crashlytics.internal.common.Utils;
import com.google.firebase.crashlytics.internal.settings.Settings;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import m0.e;
import m0.g;
import m0.i;
import p0.u;
import p0.v;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class ReportQueue {
    private static final int MAX_DELAY_MS = 3600000;
    private static final int MS_PER_MINUTE = 60000;
    private static final int MS_PER_SECOND = 1000;
    private static final int STARTUP_DURATION_MS = 2000;
    private final double base;
    private long lastUpdatedMs;
    private final OnDemandCounter onDemandCounter;
    private final BlockingQueue<Runnable> queue;
    private final int queueCapacity;
    private final double ratePerMinute;
    private final ThreadPoolExecutor singleThreadExecutor;
    private final long startTimeMs;
    private int step;
    private final long stepDurationMs;
    private final g transport;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class ReportRunnable implements Runnable {
        private final CrashlyticsReportWithSessionId reportWithSessionId;
        private final TaskCompletionSource<CrashlyticsReportWithSessionId> tcs;

        @Override // java.lang.Runnable
        public void run() {
            ReportQueue.this.sendReport(this.reportWithSessionId, this.tcs);
            ReportQueue.this.onDemandCounter.resetDroppedOnDemandExceptions();
            double dCalcDelay = ReportQueue.this.calcDelay();
            Logger.getLogger().d("Delay for: " + String.format(Locale.US, "%.2f", Double.valueOf(dCalcDelay / 1000.0d)) + " s for report: " + this.reportWithSessionId.getSessionId());
            ReportQueue.sleep(dCalcDelay);
        }

        private ReportRunnable(CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, TaskCompletionSource<CrashlyticsReportWithSessionId> taskCompletionSource) {
            this.reportWithSessionId = crashlyticsReportWithSessionId;
            this.tcs = taskCompletionSource;
        }
    }

    public ReportQueue(g gVar, Settings settings, OnDemandCounter onDemandCounter) {
        this(settings.onDemandUploadRatePerMinute, settings.onDemandBackoffBase, ((long) settings.onDemandBackoffStepDurationSeconds) * 1000, gVar, onDemandCounter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double calcDelay() {
        return Math.min(3600000.0d, Math.pow(this.base, calcStep()) * (60000.0d / this.ratePerMinute));
    }

    private int calcStep() {
        if (this.lastUpdatedMs == 0) {
            this.lastUpdatedMs = now();
        }
        int iNow = (int) ((now() - this.lastUpdatedMs) / this.stepDurationMs);
        int iMin = isQueueFull() ? Math.min(100, this.step + iNow) : Math.max(0, this.step - iNow);
        if (this.step != iMin) {
            this.step = iMin;
            this.lastUpdatedMs = now();
        }
        return iMin;
    }

    private boolean isQueueAvailable() {
        return this.queue.size() < this.queueCapacity;
    }

    private boolean isQueueFull() {
        return this.queue.size() == this.queueCapacity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$flushScheduledReportsIfAble$0(CountDownLatch countDownLatch) {
        try {
            g gVar = this.transport;
            e eVar = e.f12923c;
            if (gVar instanceof u) {
                v.a().f13315d.a(((u) gVar).f13308a.a(eVar), 1);
            } else {
                String strH = a.a.H("ForcedSender");
                if (Log.isLoggable(strH, 5)) {
                    Log.w(strH, String.format("Expected instance of `TransportImpl`, got `%s`.", gVar));
                }
            }
        } catch (Exception unused) {
        }
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendReport$1(TaskCompletionSource taskCompletionSource, boolean z2, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, Exception exc) {
        if (exc != null) {
            taskCompletionSource.trySetException(exc);
            return;
        }
        if (z2) {
            flushScheduledReportsIfAble();
        }
        taskCompletionSource.trySetResult(crashlyticsReportWithSessionId);
    }

    private long now() {
        return System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendReport(final CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, final TaskCompletionSource<CrashlyticsReportWithSessionId> taskCompletionSource) {
        Logger.getLogger().d("Sending report through Google DataTransport: " + crashlyticsReportWithSessionId.getSessionId());
        final boolean z2 = SystemClock.elapsedRealtime() - this.startTimeMs < 2000;
        ((u) this.transport).a(new m0.a(crashlyticsReportWithSessionId.getReport(), e.f12923c, null), new i() { // from class: com.google.firebase.crashlytics.internal.send.b
            @Override // m0.i
            public final void a(Exception exc) {
                this.f5594a.lambda$sendReport$1(taskCompletionSource, z2, crashlyticsReportWithSessionId, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sleep(double d8) {
        try {
            Thread.sleep((long) d8);
        } catch (InterruptedException unused) {
        }
    }

    public TaskCompletionSource<CrashlyticsReportWithSessionId> enqueueReport(CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, boolean z2) {
        synchronized (this.queue) {
            try {
                TaskCompletionSource<CrashlyticsReportWithSessionId> taskCompletionSource = new TaskCompletionSource<>();
                if (!z2) {
                    sendReport(crashlyticsReportWithSessionId, taskCompletionSource);
                    return taskCompletionSource;
                }
                this.onDemandCounter.incrementRecordedOnDemandExceptions();
                if (!isQueueAvailable()) {
                    calcStep();
                    Logger.getLogger().d("Dropping report due to queue being full: " + crashlyticsReportWithSessionId.getSessionId());
                    this.onDemandCounter.incrementDroppedOnDemandExceptions();
                    taskCompletionSource.trySetResult(crashlyticsReportWithSessionId);
                    return taskCompletionSource;
                }
                Logger.getLogger().d("Enqueueing report: " + crashlyticsReportWithSessionId.getSessionId());
                Logger.getLogger().d("Queue size: " + this.queue.size());
                this.singleThreadExecutor.execute(new ReportRunnable(crashlyticsReportWithSessionId, taskCompletionSource));
                Logger.getLogger().d("Closing task for report: " + crashlyticsReportWithSessionId.getSessionId());
                taskCompletionSource.trySetResult(crashlyticsReportWithSessionId);
                return taskCompletionSource;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void flushScheduledReportsIfAble() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable() { // from class: com.google.firebase.crashlytics.internal.send.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f5592a.lambda$flushScheduledReportsIfAble$0(countDownLatch);
            }
        }).start();
        Utils.awaitUninterruptibly(countDownLatch, 2L, TimeUnit.SECONDS);
    }

    public ReportQueue(double d8, double d9, long j, g gVar, OnDemandCounter onDemandCounter) {
        this.ratePerMinute = d8;
        this.base = d9;
        this.stepDurationMs = j;
        this.transport = gVar;
        this.onDemandCounter = onDemandCounter;
        this.startTimeMs = SystemClock.elapsedRealtime();
        int i2 = (int) d8;
        this.queueCapacity = i2;
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(i2);
        this.queue = arrayBlockingQueue;
        this.singleThreadExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, arrayBlockingQueue);
        this.step = 0;
        this.lastUpdatedMs = 0L;
    }
}
