package com.vungle.ads.internal.task;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import androidx.core.location.LocationRequestCompat;
import com.vungle.ads.internal.util.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class VungleJobRunner implements JobRunner {
    private final JobCreator creator;
    private final Executor executor;
    private long nextCheck;
    private final List<PendingJob> pendingJobs;
    private final Runnable pendingRunnable;
    private final ThreadPriorityHelper threadPriorityHelper;
    public static final Companion Companion = new Companion(null);
    private static final Handler handler = new Handler(Looper.getMainLooper());
    private static final String TAG = "VungleJobRunner";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class PendingJob {
        private JobInfo info;
        private final long uptimeMillis;

        public PendingJob(long j, JobInfo jobInfo) {
            this.uptimeMillis = j;
            this.info = jobInfo;
        }

        public final JobInfo getInfo() {
            return this.info;
        }

        public final long getUptimeMillis() {
            return this.uptimeMillis;
        }

        public final void setInfo(JobInfo jobInfo) {
            this.info = jobInfo;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class PendingRunnable implements Runnable {
        private WeakReference<VungleJobRunner> runner;

        public PendingRunnable(WeakReference<VungleJobRunner> runner) {
            k.e(runner, "runner");
            this.runner = runner;
        }

        public final WeakReference<VungleJobRunner> getRunner() {
            return this.runner;
        }

        @Override // java.lang.Runnable
        public void run() {
            VungleJobRunner vungleJobRunner = this.runner.get();
            if (vungleJobRunner != null) {
                vungleJobRunner.executePendingJobs();
            }
        }

        public final void setRunner(WeakReference<VungleJobRunner> weakReference) {
            k.e(weakReference, "<set-?>");
            this.runner = weakReference;
        }
    }

    public VungleJobRunner(JobCreator creator, Executor executor, ThreadPriorityHelper threadPriorityHelper) {
        k.e(creator, "creator");
        k.e(executor, "executor");
        this.creator = creator;
        this.executor = executor;
        this.threadPriorityHelper = threadPriorityHelper;
        this.nextCheck = LocationRequestCompat.PASSIVE_INTERVAL;
        this.pendingJobs = new CopyOnWriteArrayList();
        this.pendingRunnable = new PendingRunnable(new WeakReference(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void executePendingJobs() {
        try {
            long jUptimeMillis = SystemClock.uptimeMillis();
            long jMin = Long.MAX_VALUE;
            for (PendingJob pendingJob : this.pendingJobs) {
                if (jUptimeMillis >= pendingJob.getUptimeMillis()) {
                    this.pendingJobs.remove(pendingJob);
                    JobInfo info = pendingJob.getInfo();
                    if (info != null) {
                        this.executor.execute(new JobRunnable(info, this.creator, this, this.threadPriorityHelper));
                    }
                } else {
                    jMin = Math.min(jMin, pendingJob.getUptimeMillis());
                }
            }
            if (jMin != LocationRequestCompat.PASSIVE_INTERVAL && jMin != this.nextCheck) {
                Handler handler2 = handler;
                handler2.removeCallbacks(this.pendingRunnable);
                handler2.postAtTime(this.pendingRunnable, TAG, jMin);
            }
            this.nextCheck = jMin;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.vungle.ads.internal.task.JobRunner
    public synchronized void cancelPendingJob(String tag) {
        try {
            k.e(tag, "tag");
            ArrayList arrayList = new ArrayList();
            for (PendingJob pendingJob : this.pendingJobs) {
                JobInfo info = pendingJob.getInfo();
                if (k.a(info != null ? info.getJobTag() : null, tag)) {
                    arrayList.add(pendingJob);
                }
            }
            this.pendingJobs.removeAll(arrayList);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.vungle.ads.internal.task.JobRunner
    public synchronized void execute(JobInfo jobInfo) {
        try {
            k.e(jobInfo, "jobInfo");
            JobInfo jobInfoCopy = jobInfo.copy();
            if (jobInfoCopy != null) {
                String jobTag = jobInfoCopy.getJobTag();
                long delay = jobInfoCopy.getDelay();
                jobInfoCopy.setDelay(0L);
                if (jobInfoCopy.getUpdateCurrent()) {
                    for (PendingJob pendingJob : this.pendingJobs) {
                        JobInfo info = pendingJob.getInfo();
                        if (k.a(info != null ? info.getJobTag() : null, jobTag)) {
                            Logger.Companion companion = Logger.Companion;
                            String TAG2 = TAG;
                            k.d(TAG2, "TAG");
                            companion.d(TAG2, "replacing pending job with new " + jobTag);
                            this.pendingJobs.remove(pendingJob);
                        }
                    }
                }
                this.pendingJobs.add(new PendingJob(SystemClock.uptimeMillis() + delay, jobInfoCopy));
                executePendingJobs();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @VisibleForTesting
    public final int getPendingJobSize$vungle_ads_release() {
        return this.pendingJobs.size();
    }
}
