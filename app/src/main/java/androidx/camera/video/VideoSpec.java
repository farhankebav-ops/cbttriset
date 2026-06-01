package androidx.camera.video;

import android.util.Range;
import androidx.annotation.RestrictTo;
import androidx.camera.video.AutoValue_VideoSpec;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public abstract class VideoSpec {
    public static final Range<Integer> BITRATE_RANGE_AUTO = new Range<>(0, Integer.MAX_VALUE);
    public static final int ENCODE_FRAME_RATE_AUTO = 0;
    public static final QualitySelector QUALITY_SELECTOR_AUTO;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static abstract class Builder {
        public abstract VideoSpec build();

        public abstract Builder setAspectRatio(int i2);

        public abstract Builder setBitrate(Range<Integer> range);

        public abstract Builder setEncodeFrameRate(int i2);

        public abstract Builder setQualitySelector(QualitySelector qualitySelector);
    }

    static {
        Quality quality = Quality.FHD;
        QUALITY_SELECTOR_AUTO = QualitySelector.fromOrderedList(Arrays.asList(quality, Quality.HD, Quality.SD), FallbackStrategy.higherQualityOrLowerThan(quality));
    }

    public static Builder builder() {
        return new AutoValue_VideoSpec.Builder().setQualitySelector(QUALITY_SELECTOR_AUTO).setEncodeFrameRate(0).setBitrate(BITRATE_RANGE_AUTO).setAspectRatio(-1);
    }

    public abstract int getAspectRatio();

    public abstract Range<Integer> getBitrate();

    public abstract int getEncodeFrameRate();

    public abstract QualitySelector getQualitySelector();

    public abstract Builder toBuilder();
}
