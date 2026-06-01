package com.vungle.ads.internal.task;

import android.os.Bundle;
import com.vungle.ads.internal.util.Logger;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class JobInfo implements Cloneable {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "JobInfo";
    private long delay;
    private Bundle extras;
    private final String jobTag;
    private long nextRescheduleTimeout;
    private int priority;
    private int requiredNetworkType;
    private int reschedulePolicy;
    private long rescheduleTimeout;
    private boolean updateCurrent;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.RUNTIME)
    public @interface NetworkType {
        public static final int ANY = 0;
        public static final int CONNECTED = 1;
        public static final Companion Companion = Companion.$$INSTANCE;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int ANY = 0;
            public static final int CONNECTED = 1;

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Priority {
        public static final int CRITICAL = 5;
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int HIGH = 3;
        public static final int HIGHEST = 4;
        public static final int LOW = 1;
        public static final int LOWEST = 0;
        public static final int NORMAL = 2;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int CRITICAL = 5;
            public static final int HIGH = 3;
            public static final int HIGHEST = 4;
            public static final int LOW = 1;
            public static final int LOWEST = 0;
            public static final int NORMAL = 2;

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ReschedulePolicy {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int EXPONENTIAL = 1;
        public static final int LINEAR = 0;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int EXPONENTIAL = 1;
            public static final int LINEAR = 0;

            private Companion() {
            }
        }
    }

    public JobInfo(String jobTag) {
        k.e(jobTag, "jobTag");
        this.jobTag = jobTag;
        this.extras = new Bundle();
        this.reschedulePolicy = 1;
        this.priority = 2;
    }

    public Object clone() {
        return super.clone();
    }

    public final JobInfo copy() {
        try {
            Object objClone = super.clone();
            k.c(objClone, "null cannot be cast to non-null type com.vungle.ads.internal.task.JobInfo");
            return (JobInfo) objClone;
        } catch (CloneNotSupportedException e) {
            Logger.Companion.e(TAG, "Cannot copy JobInfo " + this, e);
            return null;
        }
    }

    public final long getDelay() {
        return this.delay;
    }

    public final Bundle getExtras() {
        return this.extras;
    }

    public final String getJobTag() {
        return this.jobTag;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final int getRequiredNetworkType() {
        return this.requiredNetworkType;
    }

    public final boolean getUpdateCurrent() {
        return this.updateCurrent;
    }

    public final long makeNextRescedule() {
        long j = this.rescheduleTimeout;
        if (j == 0) {
            return 0L;
        }
        long j3 = this.nextRescheduleTimeout;
        if (j3 == 0) {
            this.nextRescheduleTimeout = j;
        } else if (this.reschedulePolicy == 1) {
            this.nextRescheduleTimeout = j3 * ((long) 2);
        }
        return this.nextRescheduleTimeout;
    }

    public final JobInfo setDelay(long j) {
        this.delay = j;
        return this;
    }

    public final JobInfo setExtras(Bundle extras) {
        k.e(extras, "extras");
        this.extras = extras;
        return this;
    }

    public final JobInfo setPriority(int i2) {
        this.priority = i2;
        return this;
    }

    public final JobInfo setRequiredNetworkType(@NetworkType int i2) {
        this.requiredNetworkType = i2;
        return this;
    }

    public final JobInfo setReschedulePolicy(long j, int i2) {
        this.rescheduleTimeout = j;
        this.reschedulePolicy = i2;
        return this;
    }

    public final JobInfo setUpdateCurrent(boolean z2) {
        this.updateCurrent = z2;
        return this;
    }

    public static /* synthetic */ void getPriority$annotations() {
    }

    @NetworkType
    public static /* synthetic */ void getRequiredNetworkType$annotations() {
    }

    private static /* synthetic */ void getReschedulePolicy$annotations() {
    }
}
