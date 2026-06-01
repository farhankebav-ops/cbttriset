package androidx.camera.video;

import android.util.Range;
import androidx.annotation.RestrictTo;
import androidx.camera.core.Preview;
import androidx.camera.core.SessionConfig;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalHighSpeedVideo
public final class HighSpeedVideoSessionConfig extends SessionConfig {
    private static final Companion Companion = new Companion(null);
    private static final int SLOW_MOTION_ENCODE_FRAME_RATE = 30;
    private final boolean isSlowMotionEnabled;
    private final Preview preview;
    private final int sessionType;
    private final VideoCapture<?> videoCapture;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {
        private Range<Integer> frameRateRange;
        private boolean isSlowMotionEnabled;
        private Preview preview;
        private final VideoCapture<?> videoCapture;

        public Builder(VideoCapture<?> videoCapture) {
            kotlin.jvm.internal.k.e(videoCapture, "videoCapture");
            this.videoCapture = videoCapture;
            Range<Integer> FRAME_RATE_RANGE_UNSPECIFIED = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
            kotlin.jvm.internal.k.d(FRAME_RATE_RANGE_UNSPECIFIED, "FRAME_RATE_RANGE_UNSPECIFIED");
            this.frameRateRange = FRAME_RATE_RANGE_UNSPECIFIED;
        }

        public final HighSpeedVideoSessionConfig build() {
            return new HighSpeedVideoSessionConfig(this.videoCapture, this.preview, this.frameRateRange, this.isSlowMotionEnabled);
        }

        public final Builder setFrameRateRange(Range<Integer> frameRateRange) {
            kotlin.jvm.internal.k.e(frameRateRange, "frameRateRange");
            this.frameRateRange = frameRateRange;
            return this;
        }

        public final Builder setPreview(Preview preview) {
            this.preview = preview;
            return this;
        }

        public final Builder setSlowMotionEnabled(boolean z2) {
            this.isSlowMotionEnabled = z2;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HighSpeedVideoSessionConfig(VideoCapture<?> videoCapture) {
        this(videoCapture, null, null, false, 14, null);
        kotlin.jvm.internal.k.e(videoCapture, "videoCapture");
    }

    private final void validateSettingsOrThrow(VideoCapture<?> videoCapture, Preview preview) {
        if (videoCapture.getMirrorMode() != 0) {
            throw new IllegalArgumentException("VideoCapture.Builder.setMirrorMode() is not allowed for high-speed video.");
        }
        Range<Integer> targetFrameRate = videoCapture.getTargetFrameRate();
        Range<Integer> range = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
        if (!kotlin.jvm.internal.k.a(targetFrameRate, range)) {
            throw new IllegalArgumentException("VideoCapture.Builder.setTargetFrameRate() is not allowed for high-speed video.");
        }
        if (preview != null) {
            if (!kotlin.jvm.internal.k.a(preview.getTargetFrameRate(), range)) {
                throw new IllegalArgumentException("Preview.Builder.setTargetFrameRate() is not allowed for high-speed video.");
            }
            UseCaseConfig<?> currentConfig = preview.getCurrentConfig();
            kotlin.jvm.internal.k.c(currentConfig, "null cannot be cast to non-null type androidx.camera.core.impl.ImageOutputConfig");
            ImageOutputConfig imageOutputConfig = (ImageOutputConfig) currentConfig;
            if (imageOutputConfig.getResolutionSelector(null) != null) {
                throw new IllegalArgumentException("Preview.Builder.setResolutionSelector() is not allowed for high-speed video.");
            }
            if (imageOutputConfig.getTargetResolution(null) != null) {
                throw new IllegalArgumentException("Preview.Builder.setTargetResolution() is not allowed for high-speed video.");
            }
            if (imageOutputConfig.hasTargetAspectRatio()) {
                throw new IllegalArgumentException("Preview.Builder.setTargetAspectRatio() is not allowed for high-speed video.");
            }
        }
    }

    public final Preview getPreview() {
        return this.preview;
    }

    @Override // androidx.camera.core.SessionConfig
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int getSessionType() {
        return this.sessionType;
    }

    public final VideoCapture<?> getVideoCapture() {
        return this.videoCapture;
    }

    public final boolean isSlowMotionEnabled() {
        return this.isSlowMotionEnabled;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HighSpeedVideoSessionConfig(VideoCapture<?> videoCapture, Preview preview) {
        this(videoCapture, preview, null, false, 12, null);
        kotlin.jvm.internal.k.e(videoCapture, "videoCapture");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HighSpeedVideoSessionConfig(VideoCapture<?> videoCapture, Preview preview, Range<Integer> frameRateRange) {
        this(videoCapture, preview, frameRateRange, false, 8, null);
        kotlin.jvm.internal.k.e(videoCapture, "videoCapture");
        kotlin.jvm.internal.k.e(frameRateRange, "frameRateRange");
    }

    public /* synthetic */ HighSpeedVideoSessionConfig(VideoCapture videoCapture, Preview preview, Range range, boolean z2, int i2, kotlin.jvm.internal.f fVar) {
        this(videoCapture, (i2 & 2) != 0 ? null : preview, (i2 & 4) != 0 ? StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED : range, (i2 & 8) != 0 ? false : z2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HighSpeedVideoSessionConfig(VideoCapture<?> videoCapture, Preview preview, Range<Integer> frameRateRange, boolean z2) {
        super(r5.j.n0(new UseCase[]{videoCapture, preview}), null, null, frameRateRange, null, null, 54, null);
        kotlin.jvm.internal.k.e(videoCapture, "videoCapture");
        kotlin.jvm.internal.k.e(frameRateRange, "frameRateRange");
        this.videoCapture = videoCapture;
        this.preview = preview;
        this.isSlowMotionEnabled = z2;
        this.sessionType = 1;
        validateSettingsOrThrow(videoCapture, preview);
        if (z2) {
            VideoOutput output = videoCapture.getOutput();
            kotlin.jvm.internal.k.c(output, "null cannot be cast to non-null type androidx.camera.video.Recorder");
            ((Recorder) output).setVideoEncodingFrameRate(30);
        }
    }
}
