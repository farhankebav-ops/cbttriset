package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.AutoValue_StreamSpec;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class StreamSpec {
    public static final Range<Integer> FRAME_RATE_RANGE_UNSPECIFIED = new Range<>(0, 0);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class Builder {
        public abstract StreamSpec build();

        public abstract Builder setDynamicRange(DynamicRange dynamicRange);

        public abstract Builder setExpectedFrameRateRange(Range<Integer> range);

        public abstract Builder setImplementationOptions(Config config);

        public abstract Builder setOriginalConfiguredResolution(Size size);

        public abstract Builder setResolution(Size size);

        public abstract Builder setSessionType(int i2);

        public abstract Builder setZslDisabled(boolean z2);
    }

    public static Builder builder(Size size) {
        return new AutoValue_StreamSpec.Builder().setResolution(size).setOriginalConfiguredResolution(size).setSessionType(0).setExpectedFrameRateRange(FRAME_RATE_RANGE_UNSPECIFIED).setDynamicRange(DynamicRange.SDR).setZslDisabled(false);
    }

    public abstract DynamicRange getDynamicRange();

    public abstract Range<Integer> getExpectedFrameRateRange();

    public abstract Config getImplementationOptions();

    public abstract Size getOriginalConfiguredResolution();

    public abstract Size getResolution();

    public abstract int getSessionType();

    public abstract boolean getZslDisabled();

    public abstract Builder toBuilder();
}
