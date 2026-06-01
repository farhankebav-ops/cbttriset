package androidx.work;

import android.net.Uri;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.work.impl.utils.DurationApi26Impl;
import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.l;
import r5.t;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class Constraints {
    public static final Companion Companion = new Companion(null);
    public static final Constraints NONE = new Constraints(null, false, false, false, false, 0, 0, null, 255, null);

    @ColumnInfo(name = "trigger_max_content_delay")
    private final long contentTriggerMaxDelayMillis;

    @ColumnInfo(name = "trigger_content_update_delay")
    private final long contentTriggerUpdateDelayMillis;

    @ColumnInfo(name = "content_uri_triggers")
    private final Set<ContentUriTrigger> contentUriTriggers;

    @ColumnInfo(name = "required_network_type")
    private final NetworkType requiredNetworkType;

    @ColumnInfo(name = "requires_battery_not_low")
    private final boolean requiresBatteryNotLow;

    @ColumnInfo(name = "requires_charging")
    private final boolean requiresCharging;

    @ColumnInfo(name = "requires_device_idle")
    private final boolean requiresDeviceIdle;

    @ColumnInfo(name = "requires_storage_not_low")
    private final boolean requiresStorageNotLow;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {
        private Set<ContentUriTrigger> contentUriTriggers;
        private NetworkType requiredNetworkType;
        private boolean requiresBatteryNotLow;
        private boolean requiresCharging;
        private boolean requiresDeviceIdle;
        private boolean requiresStorageNotLow;
        private long triggerContentMaxDelay;
        private long triggerContentUpdateDelay;

        public Builder() {
            this.requiredNetworkType = NetworkType.NOT_REQUIRED;
            this.triggerContentUpdateDelay = -1L;
            this.triggerContentMaxDelay = -1L;
            this.contentUriTriggers = new LinkedHashSet();
        }

        @RequiresApi(24)
        public final Builder addContentUriTrigger(Uri uri, boolean z2) {
            k.e(uri, "uri");
            this.contentUriTriggers.add(new ContentUriTrigger(uri, z2));
            return this;
        }

        public final Constraints build() {
            Set setR1;
            long j;
            long j3;
            if (Build.VERSION.SDK_INT >= 24) {
                setR1 = l.r1(this.contentUriTriggers);
                j = this.triggerContentUpdateDelay;
                j3 = this.triggerContentMaxDelay;
            } else {
                setR1 = t.f13640a;
                j = -1;
                j3 = -1;
            }
            return new Constraints(this.requiredNetworkType, this.requiresCharging, this.requiresDeviceIdle, this.requiresBatteryNotLow, this.requiresStorageNotLow, j, j3, setR1);
        }

        public final Builder setRequiredNetworkType(NetworkType networkType) {
            k.e(networkType, "networkType");
            this.requiredNetworkType = networkType;
            return this;
        }

        public final Builder setRequiresBatteryNotLow(boolean z2) {
            this.requiresBatteryNotLow = z2;
            return this;
        }

        public final Builder setRequiresCharging(boolean z2) {
            this.requiresCharging = z2;
            return this;
        }

        @RequiresApi(23)
        public final Builder setRequiresDeviceIdle(boolean z2) {
            this.requiresDeviceIdle = z2;
            return this;
        }

        public final Builder setRequiresStorageNotLow(boolean z2) {
            this.requiresStorageNotLow = z2;
            return this;
        }

        @RequiresApi(24)
        public final Builder setTriggerContentMaxDelay(long j, TimeUnit timeUnit) {
            k.e(timeUnit, "timeUnit");
            this.triggerContentMaxDelay = timeUnit.toMillis(j);
            return this;
        }

        @RequiresApi(24)
        public final Builder setTriggerContentUpdateDelay(long j, TimeUnit timeUnit) {
            k.e(timeUnit, "timeUnit");
            this.triggerContentUpdateDelay = timeUnit.toMillis(j);
            return this;
        }

        @RequiresApi(26)
        public final Builder setTriggerContentMaxDelay(Duration duration) {
            k.e(duration, "duration");
            this.triggerContentMaxDelay = DurationApi26Impl.toMillisCompat(duration);
            return this;
        }

        @RequiresApi(26)
        public final Builder setTriggerContentUpdateDelay(Duration duration) {
            k.e(duration, "duration");
            this.triggerContentUpdateDelay = DurationApi26Impl.toMillisCompat(duration);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder(Constraints constraints) {
            k.e(constraints, "constraints");
            this.requiredNetworkType = NetworkType.NOT_REQUIRED;
            this.triggerContentUpdateDelay = -1L;
            this.triggerContentMaxDelay = -1L;
            this.contentUriTriggers = new LinkedHashSet();
            this.requiresCharging = constraints.requiresCharging();
            int i2 = Build.VERSION.SDK_INT;
            this.requiresDeviceIdle = constraints.requiresDeviceIdle();
            this.requiredNetworkType = constraints.getRequiredNetworkType();
            this.requiresBatteryNotLow = constraints.requiresBatteryNotLow();
            this.requiresStorageNotLow = constraints.requiresStorageNotLow();
            if (i2 >= 24) {
                this.triggerContentUpdateDelay = constraints.getContentTriggerUpdateDelayMillis();
                this.triggerContentMaxDelay = constraints.getContentTriggerMaxDelayMillis();
                this.contentUriTriggers = l.q1(constraints.getContentUriTriggers());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class ContentUriTrigger {
        private final boolean isTriggeredForDescendants;
        private final Uri uri;

        public ContentUriTrigger(Uri uri, boolean z2) {
            k.e(uri, "uri");
            this.uri = uri;
            this.isTriggeredForDescendants = z2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!ContentUriTrigger.class.equals(obj != null ? obj.getClass() : null)) {
                return false;
            }
            k.c(obj, "null cannot be cast to non-null type androidx.work.Constraints.ContentUriTrigger");
            ContentUriTrigger contentUriTrigger = (ContentUriTrigger) obj;
            return k.a(this.uri, contentUriTrigger.uri) && this.isTriggeredForDescendants == contentUriTrigger.isTriggeredForDescendants;
        }

        public final Uri getUri() {
            return this.uri;
        }

        public int hashCode() {
            return (this.uri.hashCode() * 31) + (this.isTriggeredForDescendants ? 1231 : 1237);
        }

        public final boolean isTriggeredForDescendants() {
            return this.isTriggeredForDescendants;
        }
    }

    public Constraints() {
        this(null, false, false, false, false, 0L, 0L, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Constraints.class.equals(obj.getClass())) {
            return false;
        }
        Constraints constraints = (Constraints) obj;
        if (this.requiresCharging == constraints.requiresCharging && this.requiresDeviceIdle == constraints.requiresDeviceIdle && this.requiresBatteryNotLow == constraints.requiresBatteryNotLow && this.requiresStorageNotLow == constraints.requiresStorageNotLow && this.contentTriggerUpdateDelayMillis == constraints.contentTriggerUpdateDelayMillis && this.contentTriggerMaxDelayMillis == constraints.contentTriggerMaxDelayMillis && this.requiredNetworkType == constraints.requiredNetworkType) {
            return k.a(this.contentUriTriggers, constraints.contentUriTriggers);
        }
        return false;
    }

    public final long getContentTriggerMaxDelayMillis() {
        return this.contentTriggerMaxDelayMillis;
    }

    public final long getContentTriggerUpdateDelayMillis() {
        return this.contentTriggerUpdateDelayMillis;
    }

    public final Set<ContentUriTrigger> getContentUriTriggers() {
        return this.contentUriTriggers;
    }

    public final NetworkType getRequiredNetworkType() {
        return this.requiredNetworkType;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean hasContentUriTriggers() {
        return !this.contentUriTriggers.isEmpty();
    }

    public int hashCode() {
        int iHashCode = ((((((((this.requiredNetworkType.hashCode() * 31) + (this.requiresCharging ? 1 : 0)) * 31) + (this.requiresDeviceIdle ? 1 : 0)) * 31) + (this.requiresBatteryNotLow ? 1 : 0)) * 31) + (this.requiresStorageNotLow ? 1 : 0)) * 31;
        long j = this.contentTriggerUpdateDelayMillis;
        int i2 = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j3 = this.contentTriggerMaxDelayMillis;
        return this.contentUriTriggers.hashCode() + ((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31);
    }

    public final boolean requiresBatteryNotLow() {
        return this.requiresBatteryNotLow;
    }

    public final boolean requiresCharging() {
        return this.requiresCharging;
    }

    @RequiresApi(23)
    public final boolean requiresDeviceIdle() {
        return this.requiresDeviceIdle;
    }

    public final boolean requiresStorageNotLow() {
        return this.requiresStorageNotLow;
    }

    public Constraints(NetworkType requiredNetworkType, boolean z2, boolean z7, boolean z8, boolean z9, long j, long j3, Set<ContentUriTrigger> contentUriTriggers) {
        k.e(requiredNetworkType, "requiredNetworkType");
        k.e(contentUriTriggers, "contentUriTriggers");
        this.requiredNetworkType = requiredNetworkType;
        this.requiresCharging = z2;
        this.requiresDeviceIdle = z7;
        this.requiresBatteryNotLow = z8;
        this.requiresStorageNotLow = z9;
        this.contentTriggerUpdateDelayMillis = j;
        this.contentTriggerMaxDelayMillis = j3;
        this.contentUriTriggers = contentUriTriggers;
    }

    public /* synthetic */ Constraints(NetworkType networkType, boolean z2, boolean z7, boolean z8, boolean z9, long j, long j3, Set set, int i2, f fVar) {
        this((i2 & 1) != 0 ? NetworkType.NOT_REQUIRED : networkType, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? false : z7, (i2 & 8) != 0 ? false : z8, (i2 & 16) != 0 ? false : z9, (i2 & 32) != 0 ? -1L : j, (i2 & 64) != 0 ? -1L : j3, (i2 & 128) != 0 ? t.f13640a : set);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Constraints(Constraints other) {
        k.e(other, "other");
        boolean z2 = other.requiresCharging;
        boolean z7 = other.requiresDeviceIdle;
        this(other.requiredNetworkType, z2, z7, other.requiresBatteryNotLow, other.requiresStorageNotLow, other.contentTriggerUpdateDelayMillis, other.contentTriggerMaxDelayMillis, other.contentUriTriggers);
    }
}
