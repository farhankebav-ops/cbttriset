package androidx.camera.video.internal.audio;

import androidx.annotation.IntRange;
import androidx.camera.video.internal.audio.AudioSettings;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_AudioSettings extends AudioSettings {
    private final int audioFormat;
    private final int audioSource;
    private final int captureSampleRate;
    private final int channelCount;
    private final int encodeSampleRate;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder extends AudioSettings.Builder {
        private Integer audioFormat;
        private Integer audioSource;
        private Integer captureSampleRate;
        private Integer channelCount;
        private Integer encodeSampleRate;

        @Override // androidx.camera.video.internal.audio.AudioSettings.Builder
        public AudioSettings autoBuild() {
            String strC = this.audioSource == null ? " audioSource" : "";
            if (this.captureSampleRate == null) {
                strC = a1.a.C(strC, " captureSampleRate");
            }
            if (this.encodeSampleRate == null) {
                strC = a1.a.C(strC, " encodeSampleRate");
            }
            if (this.channelCount == null) {
                strC = a1.a.C(strC, " channelCount");
            }
            if (this.audioFormat == null) {
                strC = a1.a.C(strC, " audioFormat");
            }
            if (strC.isEmpty()) {
                return new AutoValue_AudioSettings(this.audioSource.intValue(), this.captureSampleRate.intValue(), this.encodeSampleRate.intValue(), this.channelCount.intValue(), this.audioFormat.intValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(strC));
        }

        @Override // androidx.camera.video.internal.audio.AudioSettings.Builder
        public AudioSettings.Builder setAudioFormat(int i2) {
            this.audioFormat = Integer.valueOf(i2);
            return this;
        }

        @Override // androidx.camera.video.internal.audio.AudioSettings.Builder
        public AudioSettings.Builder setAudioSource(int i2) {
            this.audioSource = Integer.valueOf(i2);
            return this;
        }

        @Override // androidx.camera.video.internal.audio.AudioSettings.Builder
        public AudioSettings.Builder setCaptureSampleRate(int i2) {
            this.captureSampleRate = Integer.valueOf(i2);
            return this;
        }

        @Override // androidx.camera.video.internal.audio.AudioSettings.Builder
        public AudioSettings.Builder setChannelCount(int i2) {
            this.channelCount = Integer.valueOf(i2);
            return this;
        }

        @Override // androidx.camera.video.internal.audio.AudioSettings.Builder
        public AudioSettings.Builder setEncodeSampleRate(int i2) {
            this.encodeSampleRate = Integer.valueOf(i2);
            return this;
        }

        public Builder() {
        }

        private Builder(AudioSettings audioSettings) {
            this.audioSource = Integer.valueOf(audioSettings.getAudioSource());
            this.captureSampleRate = Integer.valueOf(audioSettings.getCaptureSampleRate());
            this.encodeSampleRate = Integer.valueOf(audioSettings.getEncodeSampleRate());
            this.channelCount = Integer.valueOf(audioSettings.getChannelCount());
            this.audioFormat = Integer.valueOf(audioSettings.getAudioFormat());
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AudioSettings) {
            AudioSettings audioSettings = (AudioSettings) obj;
            if (this.audioSource == audioSettings.getAudioSource() && this.captureSampleRate == audioSettings.getCaptureSampleRate() && this.encodeSampleRate == audioSettings.getEncodeSampleRate() && this.channelCount == audioSettings.getChannelCount() && this.audioFormat == audioSettings.getAudioFormat()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.video.internal.audio.AudioSettings
    public int getAudioFormat() {
        return this.audioFormat;
    }

    @Override // androidx.camera.video.internal.audio.AudioSettings
    public int getAudioSource() {
        return this.audioSource;
    }

    @Override // androidx.camera.video.internal.audio.AudioSettings
    @IntRange(from = 1)
    public int getCaptureSampleRate() {
        return this.captureSampleRate;
    }

    @Override // androidx.camera.video.internal.audio.AudioSettings
    @IntRange(from = 1)
    public int getChannelCount() {
        return this.channelCount;
    }

    @Override // androidx.camera.video.internal.audio.AudioSettings
    @IntRange(from = 1)
    public int getEncodeSampleRate() {
        return this.encodeSampleRate;
    }

    public int hashCode() {
        return ((((((((this.audioSource ^ 1000003) * 1000003) ^ this.captureSampleRate) * 1000003) ^ this.encodeSampleRate) * 1000003) ^ this.channelCount) * 1000003) ^ this.audioFormat;
    }

    @Override // androidx.camera.video.internal.audio.AudioSettings
    public AudioSettings.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioSettings{audioSource=");
        sb.append(this.audioSource);
        sb.append(", captureSampleRate=");
        sb.append(this.captureSampleRate);
        sb.append(", encodeSampleRate=");
        sb.append(this.encodeSampleRate);
        sb.append(", channelCount=");
        sb.append(this.channelCount);
        sb.append(", audioFormat=");
        return a1.a.q(sb, "}", this.audioFormat);
    }

    private AutoValue_AudioSettings(int i2, int i8, int i9, int i10, int i11) {
        this.audioSource = i2;
        this.captureSampleRate = i8;
        this.encodeSampleRate = i9;
        this.channelCount = i10;
        this.audioFormat = i11;
    }
}
