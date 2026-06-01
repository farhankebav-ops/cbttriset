package androidx.camera.video.internal.audio;

import androidx.annotation.IntRange;
import androidx.camera.video.internal.audio.AutoValue_AudioSettings;
import androidx.camera.video.internal.workaround.DefaultEncoderProfilesProvider;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AudioSettings {
    public static final List<Integer> COMMON_SAMPLE_RATES = Collections.unmodifiableList(Arrays.asList(192000, 48000, Integer.valueOf(DefaultEncoderProfilesProvider.DEFAULT_AUDIO_SAMPLE_RATE), 24000, 22050, 16000, 12000, 11025, 8000, 4800));

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class Builder {
        public abstract AudioSettings autoBuild();

        public final AudioSettings build() {
            AudioSettings audioSettingsAutoBuild = autoBuild();
            String strC = audioSettingsAutoBuild.getAudioSource() == -1 ? " audioSource" : "";
            if (audioSettingsAutoBuild.getCaptureSampleRate() <= 0) {
                strC = a1.a.C(strC, " captureSampleRate");
            }
            if (audioSettingsAutoBuild.getEncodeSampleRate() <= 0) {
                strC = a1.a.C(strC, " encodeSampleRate");
            }
            if (audioSettingsAutoBuild.getChannelCount() <= 0) {
                strC = a1.a.C(strC, " channelCount");
            }
            if (audioSettingsAutoBuild.getAudioFormat() == -1) {
                strC = a1.a.C(strC, " audioFormat");
            }
            if (strC.isEmpty()) {
                return audioSettingsAutoBuild;
            }
            throw new IllegalArgumentException("Required settings missing or non-positive:".concat(strC));
        }

        public abstract Builder setAudioFormat(int i2);

        public abstract Builder setAudioSource(int i2);

        public abstract Builder setCaptureSampleRate(@IntRange(from = 1) int i2);

        public abstract Builder setChannelCount(@IntRange(from = 1) int i2);

        public abstract Builder setEncodeSampleRate(@IntRange(from = 1) int i2);
    }

    public static Builder builder() {
        return new AutoValue_AudioSettings.Builder().setAudioSource(-1).setCaptureSampleRate(-1).setEncodeSampleRate(-1).setChannelCount(-1).setAudioFormat(-1);
    }

    public abstract int getAudioFormat();

    public abstract int getAudioSource();

    public int getBytesPerFrame() {
        return AudioUtils.getBytesPerFrame(getAudioFormat(), getChannelCount());
    }

    @IntRange(from = 1)
    public abstract int getCaptureSampleRate();

    @IntRange(from = 1)
    public abstract int getChannelCount();

    @IntRange(from = 1)
    public abstract int getEncodeSampleRate();

    public abstract Builder toBuilder();
}
