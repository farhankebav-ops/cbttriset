package androidx.camera.core.impl;

import android.util.Size;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface EncoderProfilesProxy {
    public static final int CODEC_PROFILE_NONE = -1;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class AudioProfileProxy {
        public static final String MEDIA_TYPE_NONE = "audio/none";

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @Retention(RetentionPolicy.SOURCE)
        public @interface AudioEncoder {
        }

        public static AudioProfileProxy create(int i2, String str, int i8, int i9, int i10, int i11) {
            return new AutoValue_EncoderProfilesProxy_AudioProfileProxy(i2, str, i8, i9, i10, i11);
        }

        public abstract int getBitrate();

        public abstract int getChannels();

        public abstract int getCodec();

        public abstract String getMediaType();

        public abstract int getProfile();

        public abstract int getSampleRate();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class ImmutableEncoderProfilesProxy implements EncoderProfilesProxy {
        public static ImmutableEncoderProfilesProxy create(int i2, int i8, List<AudioProfileProxy> list, List<VideoProfileProxy> list2) {
            return new AutoValue_EncoderProfilesProxy_ImmutableEncoderProfilesProxy(i2, i8, Collections.unmodifiableList(new ArrayList(list)), Collections.unmodifiableList(new ArrayList(list2)));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class VideoProfileProxy {
        public static final int BIT_DEPTH_10 = 10;
        public static final int BIT_DEPTH_8 = 8;
        public static final String MEDIA_TYPE_NONE = "video/none";

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @Retention(RetentionPolicy.SOURCE)
        public @interface VideoEncoder {
        }

        public static VideoProfileProxy create(int i2, String str, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
            return new AutoValue_EncoderProfilesProxy_VideoProfileProxy(i2, str, i8, i9, i10, i11, i12, i13, i14, i15);
        }

        public abstract int getBitDepth();

        public abstract int getBitrate();

        public abstract int getChromaSubsampling();

        public abstract int getCodec();

        public abstract int getFrameRate();

        public abstract int getHdrFormat();

        public abstract int getHeight();

        public abstract String getMediaType();

        public abstract int getProfile();

        public Size getResolution() {
            return new Size(getWidth(), getHeight());
        }

        public abstract int getWidth();
    }

    List<AudioProfileProxy> getAudioProfiles();

    int getDefaultDurationSeconds();

    int getRecommendedFileFormat();

    List<VideoProfileProxy> getVideoProfiles();
}
