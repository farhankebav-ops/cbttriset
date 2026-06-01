package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.StreamSpec;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_StreamSpec extends StreamSpec {
    private final DynamicRange dynamicRange;
    private final Range<Integer> expectedFrameRateRange;
    private final Config implementationOptions;
    private final Size originalConfiguredResolution;
    private final Size resolution;
    private final int sessionType;
    private final boolean zslDisabled;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder extends StreamSpec.Builder {
        private DynamicRange dynamicRange;
        private Range<Integer> expectedFrameRateRange;
        private Config implementationOptions;
        private Size originalConfiguredResolution;
        private Size resolution;
        private Integer sessionType;
        private Boolean zslDisabled;

        @Override // androidx.camera.core.impl.StreamSpec.Builder
        public StreamSpec build() {
            String strC = this.resolution == null ? " resolution" : "";
            if (this.originalConfiguredResolution == null) {
                strC = a1.a.C(strC, " originalConfiguredResolution");
            }
            if (this.dynamicRange == null) {
                strC = a1.a.C(strC, " dynamicRange");
            }
            if (this.sessionType == null) {
                strC = a1.a.C(strC, " sessionType");
            }
            if (this.expectedFrameRateRange == null) {
                strC = a1.a.C(strC, " expectedFrameRateRange");
            }
            if (this.zslDisabled == null) {
                strC = a1.a.C(strC, " zslDisabled");
            }
            if (strC.isEmpty()) {
                return new AutoValue_StreamSpec(this.resolution, this.originalConfiguredResolution, this.dynamicRange, this.sessionType.intValue(), this.expectedFrameRateRange, this.implementationOptions, this.zslDisabled.booleanValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(strC));
        }

        @Override // androidx.camera.core.impl.StreamSpec.Builder
        public StreamSpec.Builder setDynamicRange(DynamicRange dynamicRange) {
            if (dynamicRange == null) {
                throw new NullPointerException("Null dynamicRange");
            }
            this.dynamicRange = dynamicRange;
            return this;
        }

        @Override // androidx.camera.core.impl.StreamSpec.Builder
        public StreamSpec.Builder setExpectedFrameRateRange(Range<Integer> range) {
            if (range == null) {
                throw new NullPointerException("Null expectedFrameRateRange");
            }
            this.expectedFrameRateRange = range;
            return this;
        }

        @Override // androidx.camera.core.impl.StreamSpec.Builder
        public StreamSpec.Builder setImplementationOptions(Config config) {
            this.implementationOptions = config;
            return this;
        }

        @Override // androidx.camera.core.impl.StreamSpec.Builder
        public StreamSpec.Builder setOriginalConfiguredResolution(Size size) {
            if (size == null) {
                throw new NullPointerException("Null originalConfiguredResolution");
            }
            this.originalConfiguredResolution = size;
            return this;
        }

        @Override // androidx.camera.core.impl.StreamSpec.Builder
        public StreamSpec.Builder setResolution(Size size) {
            if (size == null) {
                throw new NullPointerException("Null resolution");
            }
            this.resolution = size;
            return this;
        }

        @Override // androidx.camera.core.impl.StreamSpec.Builder
        public StreamSpec.Builder setSessionType(int i2) {
            this.sessionType = Integer.valueOf(i2);
            return this;
        }

        @Override // androidx.camera.core.impl.StreamSpec.Builder
        public StreamSpec.Builder setZslDisabled(boolean z2) {
            this.zslDisabled = Boolean.valueOf(z2);
            return this;
        }

        public Builder() {
        }

        private Builder(StreamSpec streamSpec) {
            this.resolution = streamSpec.getResolution();
            this.originalConfiguredResolution = streamSpec.getOriginalConfiguredResolution();
            this.dynamicRange = streamSpec.getDynamicRange();
            this.sessionType = Integer.valueOf(streamSpec.getSessionType());
            this.expectedFrameRateRange = streamSpec.getExpectedFrameRateRange();
            this.implementationOptions = streamSpec.getImplementationOptions();
            this.zslDisabled = Boolean.valueOf(streamSpec.getZslDisabled());
        }
    }

    public boolean equals(Object obj) {
        Config config;
        if (obj == this) {
            return true;
        }
        if (obj instanceof StreamSpec) {
            StreamSpec streamSpec = (StreamSpec) obj;
            if (this.resolution.equals(streamSpec.getResolution()) && this.originalConfiguredResolution.equals(streamSpec.getOriginalConfiguredResolution()) && this.dynamicRange.equals(streamSpec.getDynamicRange()) && this.sessionType == streamSpec.getSessionType() && this.expectedFrameRateRange.equals(streamSpec.getExpectedFrameRateRange()) && ((config = this.implementationOptions) != null ? config.equals(streamSpec.getImplementationOptions()) : streamSpec.getImplementationOptions() == null) && this.zslDisabled == streamSpec.getZslDisabled()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.impl.StreamSpec
    public DynamicRange getDynamicRange() {
        return this.dynamicRange;
    }

    @Override // androidx.camera.core.impl.StreamSpec
    public Range<Integer> getExpectedFrameRateRange() {
        return this.expectedFrameRateRange;
    }

    @Override // androidx.camera.core.impl.StreamSpec
    public Config getImplementationOptions() {
        return this.implementationOptions;
    }

    @Override // androidx.camera.core.impl.StreamSpec
    public Size getOriginalConfiguredResolution() {
        return this.originalConfiguredResolution;
    }

    @Override // androidx.camera.core.impl.StreamSpec
    public Size getResolution() {
        return this.resolution;
    }

    @Override // androidx.camera.core.impl.StreamSpec
    public int getSessionType() {
        return this.sessionType;
    }

    @Override // androidx.camera.core.impl.StreamSpec
    public boolean getZslDisabled() {
        return this.zslDisabled;
    }

    public int hashCode() {
        int iHashCode = (((((((((this.resolution.hashCode() ^ 1000003) * 1000003) ^ this.originalConfiguredResolution.hashCode()) * 1000003) ^ this.dynamicRange.hashCode()) * 1000003) ^ this.sessionType) * 1000003) ^ this.expectedFrameRateRange.hashCode()) * 1000003;
        Config config = this.implementationOptions;
        return ((iHashCode ^ (config == null ? 0 : config.hashCode())) * 1000003) ^ (this.zslDisabled ? 1231 : 1237);
    }

    @Override // androidx.camera.core.impl.StreamSpec
    public StreamSpec.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StreamSpec{resolution=");
        sb.append(this.resolution);
        sb.append(", originalConfiguredResolution=");
        sb.append(this.originalConfiguredResolution);
        sb.append(", dynamicRange=");
        sb.append(this.dynamicRange);
        sb.append(", sessionType=");
        sb.append(this.sessionType);
        sb.append(", expectedFrameRateRange=");
        sb.append(this.expectedFrameRateRange);
        sb.append(", implementationOptions=");
        sb.append(this.implementationOptions);
        sb.append(", zslDisabled=");
        return a1.a.u(sb, this.zslDisabled, "}");
    }

    private AutoValue_StreamSpec(Size size, Size size2, DynamicRange dynamicRange, int i2, Range<Integer> range, Config config, boolean z2) {
        this.resolution = size;
        this.originalConfiguredResolution = size2;
        this.dynamicRange = dynamicRange;
        this.sessionType = i2;
        this.expectedFrameRateRange = range;
        this.implementationOptions = config;
        this.zslDisabled = z2;
    }
}
