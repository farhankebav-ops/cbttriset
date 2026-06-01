package androidx.camera.video.internal.encoder;

import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.encoder.AudioEncoderConfig;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_AudioEncoderConfig extends AudioEncoderConfig {
    private final int bitrate;
    private final int captureSampleRate;
    private final int channelCount;
    private final int encodeSampleRate;
    private final Timebase inputTimebase;
    private final String mimeType;
    private final int profile;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder extends AudioEncoderConfig.Builder {
        private Integer bitrate;
        private Integer captureSampleRate;
        private Integer channelCount;
        private Integer encodeSampleRate;
        private Timebase inputTimebase;
        private String mimeType;
        private Integer profile;

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig autoBuild() {
            String strC = this.mimeType == null ? " mimeType" : "";
            if (this.profile == null) {
                strC = a1.a.C(strC, " profile");
            }
            if (this.inputTimebase == null) {
                strC = a1.a.C(strC, " inputTimebase");
            }
            if (this.bitrate == null) {
                strC = a1.a.C(strC, " bitrate");
            }
            if (this.captureSampleRate == null) {
                strC = a1.a.C(strC, " captureSampleRate");
            }
            if (this.encodeSampleRate == null) {
                strC = a1.a.C(strC, " encodeSampleRate");
            }
            if (this.channelCount == null) {
                strC = a1.a.C(strC, " channelCount");
            }
            if (strC.isEmpty()) {
                return new AutoValue_AudioEncoderConfig(this.mimeType, this.profile.intValue(), this.inputTimebase, this.bitrate.intValue(), this.captureSampleRate.intValue(), this.encodeSampleRate.intValue(), this.channelCount.intValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(strC));
        }

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig.Builder setBitrate(int i2) {
            this.bitrate = Integer.valueOf(i2);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig.Builder setCaptureSampleRate(int i2) {
            this.captureSampleRate = Integer.valueOf(i2);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig.Builder setChannelCount(int i2) {
            this.channelCount = Integer.valueOf(i2);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig.Builder setEncodeSampleRate(int i2) {
            this.encodeSampleRate = Integer.valueOf(i2);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig.Builder setInputTimebase(Timebase timebase) {
            if (timebase == null) {
                throw new NullPointerException("Null inputTimebase");
            }
            this.inputTimebase = timebase;
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig.Builder setMimeType(String str) {
            if (str == null) {
                throw new NullPointerException("Null mimeType");
            }
            this.mimeType = str;
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig.Builder setProfile(int i2) {
            this.profile = Integer.valueOf(i2);
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AudioEncoderConfig) {
            AudioEncoderConfig audioEncoderConfig = (AudioEncoderConfig) obj;
            if (this.mimeType.equals(audioEncoderConfig.getMimeType()) && this.profile == audioEncoderConfig.getProfile() && this.inputTimebase.equals(audioEncoderConfig.getInputTimebase()) && this.bitrate == audioEncoderConfig.getBitrate() && this.captureSampleRate == audioEncoderConfig.getCaptureSampleRate() && this.encodeSampleRate == audioEncoderConfig.getEncodeSampleRate() && this.channelCount == audioEncoderConfig.getChannelCount()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig
    public int getBitrate() {
        return this.bitrate;
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig
    public int getCaptureSampleRate() {
        return this.captureSampleRate;
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig
    public int getChannelCount() {
        return this.channelCount;
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig
    public int getEncodeSampleRate() {
        return this.encodeSampleRate;
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig, androidx.camera.video.internal.encoder.EncoderConfig
    public Timebase getInputTimebase() {
        return this.inputTimebase;
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig, androidx.camera.video.internal.encoder.EncoderConfig
    public String getMimeType() {
        return this.mimeType;
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig, androidx.camera.video.internal.encoder.EncoderConfig
    public int getProfile() {
        return this.profile;
    }

    public int hashCode() {
        return ((((((((((((this.mimeType.hashCode() ^ 1000003) * 1000003) ^ this.profile) * 1000003) ^ this.inputTimebase.hashCode()) * 1000003) ^ this.bitrate) * 1000003) ^ this.captureSampleRate) * 1000003) ^ this.encodeSampleRate) * 1000003) ^ this.channelCount;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioEncoderConfig{mimeType=");
        sb.append(this.mimeType);
        sb.append(", profile=");
        sb.append(this.profile);
        sb.append(", inputTimebase=");
        sb.append(this.inputTimebase);
        sb.append(", bitrate=");
        sb.append(this.bitrate);
        sb.append(", captureSampleRate=");
        sb.append(this.captureSampleRate);
        sb.append(", encodeSampleRate=");
        sb.append(this.encodeSampleRate);
        sb.append(", channelCount=");
        return a1.a.q(sb, "}", this.channelCount);
    }

    private AutoValue_AudioEncoderConfig(String str, int i2, Timebase timebase, int i8, int i9, int i10, int i11) {
        this.mimeType = str;
        this.profile = i2;
        this.inputTimebase = timebase;
        this.bitrate = i8;
        this.captureSampleRate = i9;
        this.encodeSampleRate = i10;
        this.channelCount = i11;
    }
}
