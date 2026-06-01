package androidx.camera.video;

import androidx.annotation.RestrictTo;
import androidx.camera.video.AudioSpec;
import androidx.camera.video.AutoValue_MediaSpec;
import androidx.camera.video.VideoSpec;
import androidx.core.util.Consumer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public abstract class MediaSpec {
    private static final int AAC_DEFAULT_PROFILE = 2;
    private static final String AUDIO_ENCODER_MIME_MPEG4_DEFAULT = "audio/mp4a-latm";
    private static final String AUDIO_ENCODER_MIME_WEBM_DEFAULT = "audio/vorbis";
    public static final int OUTPUT_FORMAT_AUTO = -1;
    public static final int OUTPUT_FORMAT_MPEG_4 = 0;
    public static final int OUTPUT_FORMAT_WEBM = 1;
    private static final String VIDEO_ENCODER_MIME_MPEG4_DEFAULT = "video/avc";
    private static final String VIDEO_ENCODER_MIME_WEBM_DEFAULT = "video/x-vnd.on2.vp8";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static abstract class Builder {
        public abstract MediaSpec build();

        public Builder configureAudio(Consumer<AudioSpec.Builder> consumer) {
            AudioSpec.Builder builder = getAudioSpec().toBuilder();
            consumer.accept(builder);
            setAudioSpec(builder.build());
            return this;
        }

        public Builder configureVideo(Consumer<VideoSpec.Builder> consumer) {
            VideoSpec.Builder builder = getVideoSpec().toBuilder();
            consumer.accept(builder);
            setVideoSpec(builder.build());
            return this;
        }

        public abstract AudioSpec getAudioSpec();

        public abstract VideoSpec getVideoSpec();

        public abstract Builder setAudioSpec(AudioSpec audioSpec);

        public abstract Builder setOutputFormat(int i2);

        public abstract Builder setVideoSpec(VideoSpec videoSpec);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface OutputFormat {
    }

    public static Builder builder() {
        return new AutoValue_MediaSpec.Builder().setOutputFormat(-1).setAudioSpec(AudioSpec.builder().build()).setVideoSpec(VideoSpec.builder().build());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static String outputFormatToAudioMime(int i2) {
        return i2 != 1 ? "audio/mp4a-latm" : AUDIO_ENCODER_MIME_WEBM_DEFAULT;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static int outputFormatToAudioProfile(int i2) {
        return Objects.equals(outputFormatToAudioMime(i2), "audio/mp4a-latm") ? 2 : -1;
    }

    public static int outputFormatToMuxerFormat(int i2) {
        return i2 != 1 ? 0 : 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static String outputFormatToVideoMime(int i2) {
        return i2 != 1 ? "video/avc" : VIDEO_ENCODER_MIME_WEBM_DEFAULT;
    }

    public abstract AudioSpec getAudioSpec();

    public abstract int getOutputFormat();

    public abstract VideoSpec getVideoSpec();

    public abstract Builder toBuilder();
}
