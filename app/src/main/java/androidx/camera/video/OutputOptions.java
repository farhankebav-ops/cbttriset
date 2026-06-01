package androidx.camera.video;

import android.location.Location;
import androidx.annotation.IntRange;
import androidx.core.util.Preconditions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class OutputOptions {
    public static final int DURATION_UNLIMITED = 0;
    public static final int FILE_SIZE_UNLIMITED = 0;
    private final OutputOptionsInternal mOutputOptionsInternal;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class Builder<T extends OutputOptions, B> {
        final OutputOptionsInternal.Builder<?> mRootInternalBuilder;

        public Builder(OutputOptionsInternal.Builder<?> builder) {
            this.mRootInternalBuilder = builder;
            builder.setFileSizeLimit(0L);
            builder.setDurationLimitMillis(0L);
        }

        public abstract T build();

        /* JADX WARN: Multi-variable type inference failed */
        public B setDurationLimitMillis(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) long j) {
            Preconditions.checkArgument(j >= 0, "The specified duration limit can't be negative.");
            this.mRootInternalBuilder.setDurationLimitMillis(j);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public B setFileSizeLimit(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) long j) {
            Preconditions.checkArgument(j >= 0, "The specified file size limit can't be negative.");
            this.mRootInternalBuilder.setFileSizeLimit(j);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public B setLocation(Location location) {
            if (location != null) {
                boolean z2 = false;
                Preconditions.checkArgument(location.getLatitude() >= -90.0d && location.getLatitude() <= 90.0d, "Latitude must be in the range [-90, 90]");
                if (location.getLongitude() >= -180.0d && location.getLongitude() <= 180.0d) {
                    z2 = true;
                }
                Preconditions.checkArgument(z2, "Longitude must be in the range [-180, 180]");
            }
            this.mRootInternalBuilder.setLocation(location);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class OutputOptionsInternal {

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static abstract class Builder<B> {
            public abstract OutputOptionsInternal build();

            public abstract B setDurationLimitMillis(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) long j);

            public abstract B setFileSizeLimit(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) long j);

            public abstract B setLocation(Location location);
        }

        @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG)
        public abstract long getDurationLimitMillis();

        @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG)
        public abstract long getFileSizeLimit();

        public abstract Location getLocation();
    }

    public OutputOptions(OutputOptionsInternal outputOptionsInternal) {
        this.mOutputOptionsInternal = outputOptionsInternal;
    }

    @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG)
    public long getDurationLimitMillis() {
        return this.mOutputOptionsInternal.getDurationLimitMillis();
    }

    @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG)
    public long getFileSizeLimit() {
        return this.mOutputOptionsInternal.getFileSizeLimit();
    }

    public Location getLocation() {
        return this.mOutputOptionsInternal.getLocation();
    }
}
