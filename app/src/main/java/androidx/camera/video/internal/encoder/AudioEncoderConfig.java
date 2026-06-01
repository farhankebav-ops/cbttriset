package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.encoder.AutoValue_AudioEncoderConfig;
import androidx.camera.video.internal.workaround.DefaultEncoderProfilesProvider;
import com.google.android.gms.common.Scopes;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AudioEncoderConfig implements EncoderConfig {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class Builder {
        public abstract AudioEncoderConfig autoBuild();

        public AudioEncoderConfig build() {
            AudioEncoderConfig audioEncoderConfigAutoBuild = autoBuild();
            if (Objects.equals(audioEncoderConfigAutoBuild.getMimeType(), DefaultEncoderProfilesProvider.DEFAULT_AUDIO_MIME_TYPE) && audioEncoderConfigAutoBuild.getProfile() == -1) {
                throw new IllegalArgumentException("Encoder mime set to AAC, but no AAC profile was provided.");
            }
            return audioEncoderConfigAutoBuild;
        }

        public abstract Builder setBitrate(int i2);

        public abstract Builder setCaptureSampleRate(int i2);

        public abstract Builder setChannelCount(int i2);

        public abstract Builder setEncodeSampleRate(int i2);

        public abstract Builder setInputTimebase(Timebase timebase);

        public abstract Builder setMimeType(String str);

        public abstract Builder setProfile(int i2);
    }

    public static Builder builder() {
        return new AutoValue_AudioEncoderConfig.Builder().setProfile(-1);
    }

    public abstract int getBitrate();

    public abstract int getCaptureSampleRate();

    public abstract int getChannelCount();

    public abstract int getEncodeSampleRate();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    public abstract Timebase getInputTimebase();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    public abstract String getMimeType();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    public abstract int getProfile();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    public MediaFormat toMediaFormat() {
        MediaFormat mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat(getMimeType(), getEncodeSampleRate(), getChannelCount());
        mediaFormatCreateAudioFormat.setInteger("bitrate", getBitrate());
        if (getProfile() != -1) {
            if (getMimeType().equals(DefaultEncoderProfilesProvider.DEFAULT_AUDIO_MIME_TYPE)) {
                mediaFormatCreateAudioFormat.setInteger("aac-profile", getProfile());
                return mediaFormatCreateAudioFormat;
            }
            mediaFormatCreateAudioFormat.setInteger(Scopes.PROFILE, getProfile());
        }
        return mediaFormatCreateAudioFormat;
    }
}
