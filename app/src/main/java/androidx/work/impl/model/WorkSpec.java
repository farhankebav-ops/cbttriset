package androidx.work.impl.model;

import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.camera.camera2.internal.compat.workaround.c;
import androidx.camera.core.processing.util.a;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.Relation;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r2.q;
import r5.n;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Entity(indices = {@Index({"schedule_requested_at"}), @Index({"last_enqueue_time"})})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class WorkSpec {
    public static final Companion Companion = new Companion(null);
    public static final long SCHEDULE_NOT_REQUESTED_YET = -1;
    private static final String TAG;
    public static final Function<List<WorkInfoPojo>, List<WorkInfo>> WORK_INFO_MAPPER;

    @ColumnInfo(name = "backoff_delay_duration")
    public long backoffDelayDuration;

    @ColumnInfo(name = "backoff_policy")
    public BackoffPolicy backoffPolicy;

    @Embedded
    public Constraints constraints;

    @ColumnInfo(name = "run_in_foreground")
    public boolean expedited;

    @ColumnInfo(name = "flex_duration")
    public long flexDuration;

    @ColumnInfo(defaultValue = "0")
    private final int generation;

    @PrimaryKey
    @ColumnInfo(name = "id")
    public final String id;

    @ColumnInfo(name = "initial_delay")
    public long initialDelay;

    @ColumnInfo(name = "input")
    public Data input;

    @ColumnInfo(name = "input_merger_class_name")
    public String inputMergerClassName;

    @ColumnInfo(name = "interval_duration")
    public long intervalDuration;

    @ColumnInfo(name = "last_enqueue_time")
    public long lastEnqueueTime;

    @ColumnInfo(name = "minimum_retention_duration")
    public long minimumRetentionDuration;

    @ColumnInfo(name = "out_of_quota_policy")
    public OutOfQuotaPolicy outOfQuotaPolicy;

    @ColumnInfo(name = "output")
    public Data output;

    @ColumnInfo(defaultValue = "0", name = "period_count")
    private int periodCount;

    @ColumnInfo(name = "run_attempt_count")
    public int runAttemptCount;

    @ColumnInfo(name = "schedule_requested_at")
    public long scheduleRequestedAt;

    @ColumnInfo(name = "state")
    public WorkInfo.State state;

    @ColumnInfo(name = "worker_class_name")
    public String workerClassName;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class IdAndState {

        @ColumnInfo(name = "id")
        public String id;

        @ColumnInfo(name = "state")
        public WorkInfo.State state;

        public IdAndState(String id, WorkInfo.State state) {
            k.e(id, "id");
            k.e(state, "state");
            this.id = id;
            this.state = state;
        }

        public static /* synthetic */ IdAndState copy$default(IdAndState idAndState, String str, WorkInfo.State state, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = idAndState.id;
            }
            if ((i2 & 2) != 0) {
                state = idAndState.state;
            }
            return idAndState.copy(str, state);
        }

        public final String component1() {
            return this.id;
        }

        public final WorkInfo.State component2() {
            return this.state;
        }

        public final IdAndState copy(String id, WorkInfo.State state) {
            k.e(id, "id");
            k.e(state, "state");
            return new IdAndState(id, state);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IdAndState)) {
                return false;
            }
            IdAndState idAndState = (IdAndState) obj;
            return k.a(this.id, idAndState.id) && this.state == idAndState.state;
        }

        public int hashCode() {
            return this.state.hashCode() + (this.id.hashCode() * 31);
        }

        public String toString() {
            return "IdAndState(id=" + this.id + ", state=" + this.state + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class WorkInfoPojo {

        @ColumnInfo(name = "generation")
        private final int generation;

        @ColumnInfo(name = "id")
        private String id;

        @ColumnInfo(name = "output")
        private Data output;

        @Relation(entity = WorkProgress.class, entityColumn = "work_spec_id", parentColumn = "id", projection = {"progress"})
        private List<Data> progress;

        @ColumnInfo(name = "run_attempt_count")
        private int runAttemptCount;

        @ColumnInfo(name = "state")
        private WorkInfo.State state;

        @Relation(entity = WorkTag.class, entityColumn = "work_spec_id", parentColumn = "id", projection = {"tag"})
        private List<String> tags;

        public WorkInfoPojo(String id, WorkInfo.State state, Data output, int i2, int i8, List<String> tags, List<Data> progress) {
            k.e(id, "id");
            k.e(state, "state");
            k.e(output, "output");
            k.e(tags, "tags");
            k.e(progress, "progress");
            this.id = id;
            this.state = state;
            this.output = output;
            this.runAttemptCount = i2;
            this.generation = i8;
            this.tags = tags;
            this.progress = progress;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WorkInfoPojo copy$default(WorkInfoPojo workInfoPojo, String str, WorkInfo.State state, Data data, int i2, int i8, List list, List list2, int i9, Object obj) {
            if ((i9 & 1) != 0) {
                str = workInfoPojo.id;
            }
            if ((i9 & 2) != 0) {
                state = workInfoPojo.state;
            }
            if ((i9 & 4) != 0) {
                data = workInfoPojo.output;
            }
            if ((i9 & 8) != 0) {
                i2 = workInfoPojo.runAttemptCount;
            }
            if ((i9 & 16) != 0) {
                i8 = workInfoPojo.generation;
            }
            if ((i9 & 32) != 0) {
                list = workInfoPojo.tags;
            }
            if ((i9 & 64) != 0) {
                list2 = workInfoPojo.progress;
            }
            List list3 = list;
            List list4 = list2;
            int i10 = i8;
            Data data2 = data;
            return workInfoPojo.copy(str, state, data2, i2, i10, list3, list4);
        }

        public final String component1() {
            return this.id;
        }

        public final WorkInfo.State component2() {
            return this.state;
        }

        public final Data component3() {
            return this.output;
        }

        public final int component4() {
            return this.runAttemptCount;
        }

        public final int component5() {
            return this.generation;
        }

        public final List<String> component6() {
            return this.tags;
        }

        public final List<Data> component7() {
            return this.progress;
        }

        public final WorkInfoPojo copy(String id, WorkInfo.State state, Data output, int i2, int i8, List<String> tags, List<Data> progress) {
            k.e(id, "id");
            k.e(state, "state");
            k.e(output, "output");
            k.e(tags, "tags");
            k.e(progress, "progress");
            return new WorkInfoPojo(id, state, output, i2, i8, tags, progress);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WorkInfoPojo)) {
                return false;
            }
            WorkInfoPojo workInfoPojo = (WorkInfoPojo) obj;
            return k.a(this.id, workInfoPojo.id) && this.state == workInfoPojo.state && k.a(this.output, workInfoPojo.output) && this.runAttemptCount == workInfoPojo.runAttemptCount && this.generation == workInfoPojo.generation && k.a(this.tags, workInfoPojo.tags) && k.a(this.progress, workInfoPojo.progress);
        }

        public final int getGeneration() {
            return this.generation;
        }

        public final String getId() {
            return this.id;
        }

        public final Data getOutput() {
            return this.output;
        }

        public final List<Data> getProgress() {
            return this.progress;
        }

        public final int getRunAttemptCount() {
            return this.runAttemptCount;
        }

        public final WorkInfo.State getState() {
            return this.state;
        }

        public final List<String> getTags() {
            return this.tags;
        }

        public int hashCode() {
            return this.progress.hashCode() + ((this.tags.hashCode() + ((((((this.output.hashCode() + ((this.state.hashCode() + (this.id.hashCode() * 31)) * 31)) * 31) + this.runAttemptCount) * 31) + this.generation) * 31)) * 31);
        }

        public final void setId(String str) {
            k.e(str, "<set-?>");
            this.id = str;
        }

        public final void setOutput(Data data) {
            k.e(data, "<set-?>");
            this.output = data;
        }

        public final void setProgress(List<Data> list) {
            k.e(list, "<set-?>");
            this.progress = list;
        }

        public final void setRunAttemptCount(int i2) {
            this.runAttemptCount = i2;
        }

        public final void setState(WorkInfo.State state) {
            k.e(state, "<set-?>");
            this.state = state;
        }

        public final void setTags(List<String> list) {
            k.e(list, "<set-?>");
            this.tags = list;
        }

        public String toString() {
            return "WorkInfoPojo(id=" + this.id + ", state=" + this.state + ", output=" + this.output + ", runAttemptCount=" + this.runAttemptCount + ", generation=" + this.generation + ", tags=" + this.tags + ", progress=" + this.progress + ')';
        }

        public final WorkInfo toWorkInfo() {
            return new WorkInfo(UUID.fromString(this.id), this.state, this.output, this.tags, !this.progress.isEmpty() ? this.progress.get(0) : Data.EMPTY, this.runAttemptCount, this.generation);
        }
    }

    static {
        String strTagWithPrefix = Logger.tagWithPrefix("WorkSpec");
        k.d(strTagWithPrefix, "tagWithPrefix(\"WorkSpec\")");
        TAG = strTagWithPrefix;
        WORK_INFO_MAPPER = new c(11);
    }

    public WorkSpec(String id, WorkInfo.State state, String workerClassName, String str, Data input, Data output, long j, long j3, long j8, Constraints constraints, @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2, BackoffPolicy backoffPolicy, long j9, long j10, long j11, long j12, boolean z2, OutOfQuotaPolicy outOfQuotaPolicy, int i8, int i9) {
        k.e(id, "id");
        k.e(state, "state");
        k.e(workerClassName, "workerClassName");
        k.e(input, "input");
        k.e(output, "output");
        k.e(constraints, "constraints");
        k.e(backoffPolicy, "backoffPolicy");
        k.e(outOfQuotaPolicy, "outOfQuotaPolicy");
        this.id = id;
        this.state = state;
        this.workerClassName = workerClassName;
        this.inputMergerClassName = str;
        this.input = input;
        this.output = output;
        this.initialDelay = j;
        this.intervalDuration = j3;
        this.flexDuration = j8;
        this.constraints = constraints;
        this.runAttemptCount = i2;
        this.backoffPolicy = backoffPolicy;
        this.backoffDelayDuration = j9;
        this.lastEnqueueTime = j10;
        this.minimumRetentionDuration = j11;
        this.scheduleRequestedAt = j12;
        this.expedited = z2;
        this.outOfQuotaPolicy = outOfQuotaPolicy;
        this.periodCount = i8;
        this.generation = i9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List WORK_INFO_MAPPER$lambda$1(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(n.L0(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((WorkInfoPojo) it.next()).toWorkInfo());
        }
        return arrayList;
    }

    public static /* synthetic */ WorkSpec copy$default(WorkSpec workSpec, String str, WorkInfo.State state, String str2, String str3, Data data, Data data2, long j, long j3, long j8, Constraints constraints, int i2, BackoffPolicy backoffPolicy, long j9, long j10, long j11, long j12, boolean z2, OutOfQuotaPolicy outOfQuotaPolicy, int i8, int i9, int i10, Object obj) {
        int i11;
        OutOfQuotaPolicy outOfQuotaPolicy2;
        String str4 = (i10 & 1) != 0 ? workSpec.id : str;
        WorkInfo.State state2 = (i10 & 2) != 0 ? workSpec.state : state;
        String str5 = (i10 & 4) != 0 ? workSpec.workerClassName : str2;
        String str6 = (i10 & 8) != 0 ? workSpec.inputMergerClassName : str3;
        Data data3 = (i10 & 16) != 0 ? workSpec.input : data;
        Data data4 = (i10 & 32) != 0 ? workSpec.output : data2;
        long j13 = (i10 & 64) != 0 ? workSpec.initialDelay : j;
        long j14 = (i10 & 128) != 0 ? workSpec.intervalDuration : j3;
        long j15 = (i10 & 256) != 0 ? workSpec.flexDuration : j8;
        Constraints constraints2 = (i10 & 512) != 0 ? workSpec.constraints : constraints;
        int i12 = (i10 & 1024) != 0 ? workSpec.runAttemptCount : i2;
        String str7 = str4;
        BackoffPolicy backoffPolicy2 = (i10 & 2048) != 0 ? workSpec.backoffPolicy : backoffPolicy;
        WorkInfo.State state3 = state2;
        long j16 = (i10 & 4096) != 0 ? workSpec.backoffDelayDuration : j9;
        long j17 = (i10 & 8192) != 0 ? workSpec.lastEnqueueTime : j10;
        long j18 = (i10 & 16384) != 0 ? workSpec.minimumRetentionDuration : j11;
        long j19 = (i10 & 32768) != 0 ? workSpec.scheduleRequestedAt : j12;
        boolean z7 = (i10 & 65536) != 0 ? workSpec.expedited : z2;
        long j20 = j19;
        OutOfQuotaPolicy outOfQuotaPolicy3 = (i10 & 131072) != 0 ? workSpec.outOfQuotaPolicy : outOfQuotaPolicy;
        int i13 = (i10 & 262144) != 0 ? workSpec.periodCount : i8;
        if ((i10 & 524288) != 0) {
            outOfQuotaPolicy2 = outOfQuotaPolicy3;
            i11 = workSpec.generation;
        } else {
            i11 = i9;
            outOfQuotaPolicy2 = outOfQuotaPolicy3;
        }
        return workSpec.copy(str7, state3, str5, str6, data3, data4, j13, j14, j15, constraints2, i12, backoffPolicy2, j16, j17, j18, j20, z7, outOfQuotaPolicy2, i13, i11);
    }

    public final long calculateNextRunTime() {
        if (isBackedOff()) {
            long jScalb = this.backoffPolicy == BackoffPolicy.LINEAR ? this.backoffDelayDuration * ((long) this.runAttemptCount) : (long) Math.scalb(this.backoffDelayDuration, this.runAttemptCount - 1);
            long j = this.lastEnqueueTime;
            if (jScalb > WorkRequest.MAX_BACKOFF_MILLIS) {
                jScalb = 18000000;
            }
            return j + jScalb;
        }
        if (!isPeriodic()) {
            long jCurrentTimeMillis = this.lastEnqueueTime;
            if (jCurrentTimeMillis == 0) {
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            return jCurrentTimeMillis + this.initialDelay;
        }
        int i2 = this.periodCount;
        long j3 = this.lastEnqueueTime;
        if (i2 == 0) {
            j3 += this.initialDelay;
        }
        long j8 = this.flexDuration;
        long j9 = this.intervalDuration;
        if (j8 != j9) {
            return j3 + j9 + (i2 == 0 ? ((long) (-1)) * j8 : 0L);
        }
        return j3 + (i2 != 0 ? j9 : 0L);
    }

    public final String component1() {
        return this.id;
    }

    public final Constraints component10() {
        return this.constraints;
    }

    public final int component11() {
        return this.runAttemptCount;
    }

    public final BackoffPolicy component12() {
        return this.backoffPolicy;
    }

    public final long component13() {
        return this.backoffDelayDuration;
    }

    public final long component14() {
        return this.lastEnqueueTime;
    }

    public final long component15() {
        return this.minimumRetentionDuration;
    }

    public final long component16() {
        return this.scheduleRequestedAt;
    }

    public final boolean component17() {
        return this.expedited;
    }

    public final OutOfQuotaPolicy component18() {
        return this.outOfQuotaPolicy;
    }

    public final int component19() {
        return this.periodCount;
    }

    public final WorkInfo.State component2() {
        return this.state;
    }

    public final int component20() {
        return this.generation;
    }

    public final String component3() {
        return this.workerClassName;
    }

    public final String component4() {
        return this.inputMergerClassName;
    }

    public final Data component5() {
        return this.input;
    }

    public final Data component6() {
        return this.output;
    }

    public final long component7() {
        return this.initialDelay;
    }

    public final long component8() {
        return this.intervalDuration;
    }

    public final long component9() {
        return this.flexDuration;
    }

    public final WorkSpec copy(String id, WorkInfo.State state, String workerClassName, String str, Data input, Data output, long j, long j3, long j8, Constraints constraints, @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2, BackoffPolicy backoffPolicy, long j9, long j10, long j11, long j12, boolean z2, OutOfQuotaPolicy outOfQuotaPolicy, int i8, int i9) {
        k.e(id, "id");
        k.e(state, "state");
        k.e(workerClassName, "workerClassName");
        k.e(input, "input");
        k.e(output, "output");
        k.e(constraints, "constraints");
        k.e(backoffPolicy, "backoffPolicy");
        k.e(outOfQuotaPolicy, "outOfQuotaPolicy");
        return new WorkSpec(id, state, workerClassName, str, input, output, j, j3, j8, constraints, i2, backoffPolicy, j9, j10, j11, j12, z2, outOfQuotaPolicy, i8, i9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkSpec)) {
            return false;
        }
        WorkSpec workSpec = (WorkSpec) obj;
        return k.a(this.id, workSpec.id) && this.state == workSpec.state && k.a(this.workerClassName, workSpec.workerClassName) && k.a(this.inputMergerClassName, workSpec.inputMergerClassName) && k.a(this.input, workSpec.input) && k.a(this.output, workSpec.output) && this.initialDelay == workSpec.initialDelay && this.intervalDuration == workSpec.intervalDuration && this.flexDuration == workSpec.flexDuration && k.a(this.constraints, workSpec.constraints) && this.runAttemptCount == workSpec.runAttemptCount && this.backoffPolicy == workSpec.backoffPolicy && this.backoffDelayDuration == workSpec.backoffDelayDuration && this.lastEnqueueTime == workSpec.lastEnqueueTime && this.minimumRetentionDuration == workSpec.minimumRetentionDuration && this.scheduleRequestedAt == workSpec.scheduleRequestedAt && this.expedited == workSpec.expedited && this.outOfQuotaPolicy == workSpec.outOfQuotaPolicy && this.periodCount == workSpec.periodCount && this.generation == workSpec.generation;
    }

    public final int getGeneration() {
        return this.generation;
    }

    public final int getPeriodCount() {
        return this.periodCount;
    }

    public final boolean hasConstraints() {
        return !k.a(Constraints.NONE, this.constraints);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v39, types: [int] */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v49 */
    public int hashCode() {
        int iB = a.b((this.state.hashCode() + (this.id.hashCode() * 31)) * 31, 31, this.workerClassName);
        String str = this.inputMergerClassName;
        int iHashCode = (this.output.hashCode() + ((this.input.hashCode() + ((iB + (str == null ? 0 : str.hashCode())) * 31)) * 31)) * 31;
        long j = this.initialDelay;
        int i2 = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j3 = this.intervalDuration;
        int i8 = (i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j8 = this.flexDuration;
        int iHashCode2 = (this.backoffPolicy.hashCode() + ((((this.constraints.hashCode() + ((i8 + ((int) (j8 ^ (j8 >>> 32)))) * 31)) * 31) + this.runAttemptCount) * 31)) * 31;
        long j9 = this.backoffDelayDuration;
        int i9 = (iHashCode2 + ((int) (j9 ^ (j9 >>> 32)))) * 31;
        long j10 = this.lastEnqueueTime;
        int i10 = (i9 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.minimumRetentionDuration;
        int i11 = (i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
        long j12 = this.scheduleRequestedAt;
        int i12 = (i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31;
        boolean z2 = this.expedited;
        ?? r22 = z2;
        if (z2) {
            r22 = 1;
        }
        return ((((this.outOfQuotaPolicy.hashCode() + ((i12 + r22) * 31)) * 31) + this.periodCount) * 31) + this.generation;
    }

    public final boolean isBackedOff() {
        return this.state == WorkInfo.State.ENQUEUED && this.runAttemptCount > 0;
    }

    public final boolean isPeriodic() {
        return this.intervalDuration != 0;
    }

    public final void setBackoffDelayDuration(long j) {
        if (j > WorkRequest.MAX_BACKOFF_MILLIS) {
            Logger.get().warning(TAG, "Backoff delay duration exceeds maximum value");
        }
        if (j < WorkRequest.MIN_BACKOFF_MILLIS) {
            Logger.get().warning(TAG, "Backoff delay duration less than minimum value");
        }
        this.backoffDelayDuration = q.J(j, WorkRequest.MIN_BACKOFF_MILLIS, WorkRequest.MAX_BACKOFF_MILLIS);
    }

    public final void setPeriodCount(int i2) {
        this.periodCount = i2;
    }

    public final void setPeriodic(long j) {
        if (j < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            Logger.get().warning(TAG, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        long j3 = j < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS ? 900000L : j;
        if (j < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            j = 900000;
        }
        setPeriodic(j3, j);
    }

    public String toString() {
        return a1.a.e('}', this.id, new StringBuilder("{WorkSpec: "));
    }

    public final void setPeriodic(long j, long j3) {
        long j8 = PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS;
        if (j < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            Logger.get().warning(TAG, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        if (j >= PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            j8 = j;
        }
        this.intervalDuration = j8;
        if (j3 < PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
            Logger.get().warning(TAG, "Flex duration lesser than minimum allowed value; Changed to 300000");
        }
        if (j3 > this.intervalDuration) {
            Logger.get().warning(TAG, "Flex duration greater than interval duration; Changed to " + j);
        }
        this.flexDuration = q.J(j3, PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS, this.intervalDuration);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WorkSpec(String str, WorkInfo.State state, String str2, String str3, Data data, Data data2, long j, long j3, long j8, Constraints constraints, int i2, BackoffPolicy backoffPolicy, long j9, long j10, long j11, long j12, boolean z2, OutOfQuotaPolicy outOfQuotaPolicy, int i8, int i9, int i10, f fVar) {
        Data data3;
        Data data4;
        WorkInfo.State state2 = (i10 & 2) != 0 ? WorkInfo.State.ENQUEUED : state;
        String str4 = (i10 & 8) != 0 ? null : str3;
        if ((i10 & 16) != 0) {
            Data EMPTY = Data.EMPTY;
            k.d(EMPTY, "EMPTY");
            data3 = EMPTY;
        } else {
            data3 = data;
        }
        if ((i10 & 32) != 0) {
            Data EMPTY2 = Data.EMPTY;
            k.d(EMPTY2, "EMPTY");
            data4 = EMPTY2;
        } else {
            data4 = data2;
        }
        this(str, state2, str2, str4, data3, data4, (i10 & 64) != 0 ? 0L : j, (i10 & 128) != 0 ? 0L : j3, (i10 & 256) != 0 ? 0L : j8, (i10 & 512) != 0 ? Constraints.NONE : constraints, (i10 & 1024) != 0 ? 0 : i2, (i10 & 2048) != 0 ? BackoffPolicy.EXPONENTIAL : backoffPolicy, (i10 & 4096) != 0 ? WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS : j9, (i10 & 8192) != 0 ? 0L : j10, (i10 & 16384) != 0 ? 0L : j11, (32768 & i10) != 0 ? -1L : j12, (65536 & i10) != 0 ? false : z2, (131072 & i10) != 0 ? OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST : outOfQuotaPolicy, (262144 & i10) != 0 ? 0 : i8, (i10 & 524288) != 0 ? 0 : i9);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkSpec(String id, String workerClassName_) {
        this(id, null, workerClassName_, null, null, null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 1048570, null);
        k.e(id, "id");
        k.e(workerClassName_, "workerClassName_");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkSpec(String newId, WorkSpec other) {
        this(newId, other.state, other.workerClassName, other.inputMergerClassName, new Data(other.input), new Data(other.output), other.initialDelay, other.intervalDuration, other.flexDuration, new Constraints(other.constraints), other.runAttemptCount, other.backoffPolicy, other.backoffDelayDuration, other.lastEnqueueTime, other.minimumRetentionDuration, other.scheduleRequestedAt, other.expedited, other.outOfQuotaPolicy, other.periodCount, 0, 524288, null);
        k.e(newId, "newId");
        k.e(other, "other");
    }
}
