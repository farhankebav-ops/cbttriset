package androidx.camera.video;

import android.util.Range;
import androidx.annotation.RestrictTo;
import androidx.camera.video.AutoValue_AudioSpec;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public abstract class AudioSpec {
    public static final int CHANNEL_COUNT_AUTO = -1;
    public static final int CHANNEL_COUNT_MONO = 1;
    public static final int CHANNEL_COUNT_NONE = 0;
    public static final int CHANNEL_COUNT_STEREO = 2;
    public static final int SOURCE_AUTO = -1;
    public static final int SOURCE_CAMCORDER = 5;
    public static final int SOURCE_FORMAT_AUTO = -1;
    public static final int SOURCE_FORMAT_PCM_16BIT = 2;
    public static final Range<Integer> BITRATE_RANGE_AUTO = new Range<>(0, Integer.MAX_VALUE);
    public static final Range<Integer> SAMPLE_RATE_RANGE_AUTO = new Range<>(0, Integer.MAX_VALUE);
    public static final AudioSpec NO_AUDIO = builder().setChannelCount(0).build();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static abstract class Builder {
        public abstract AudioSpec build();

        public abstract Builder setBitrate(Range<Integer> range);

        public abstract Builder setChannelCount(int i2);

        public abstract Builder setSampleRate(Range<Integer> range);

        public abstract Builder setSource(int i2);

        public abstract Builder setSourceFormat(int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ChannelCount {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface Source {
    }

    public static Builder builder() {
        return new AutoValue_AudioSpec.Builder().setSourceFormat(-1).setSource(-1).setChannelCount(-1).setBitrate(BITRATE_RANGE_AUTO).setSampleRate(SAMPLE_RATE_RANGE_AUTO);
    }

    public abstract Range<Integer> getBitrate();

    public abstract int getChannelCount();

    public abstract Range<Integer> getSampleRate();

    public abstract int getSource();

    public abstract int getSourceFormat();

    public abstract Builder toBuilder();
}
