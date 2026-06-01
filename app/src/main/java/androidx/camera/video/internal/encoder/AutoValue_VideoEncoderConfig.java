package androidx.camera.video.internal.encoder;

import android.util.Size;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_VideoEncoderConfig extends VideoEncoderConfig {
    private final int IFrameInterval;
    private final int bitrate;
    private final int captureFrameRate;
    private final int colorFormat;
    private final VideoEncoderDataSpace dataSpace;
    private final int encodeFrameRate;
    private final Timebase inputTimebase;
    private final String mimeType;
    private final int profile;
    private final Size resolution;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder extends VideoEncoderConfig.Builder {
        private Integer IFrameInterval;
        private Integer bitrate;
        private Integer captureFrameRate;
        private Integer colorFormat;
        private VideoEncoderDataSpace dataSpace;
        private Integer encodeFrameRate;
        private Timebase inputTimebase;
        private String mimeType;
        private Integer profile;
        private Size resolution;

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig build() {
            String strC = this.mimeType == null ? " mimeType" : "";
            if (this.profile == null) {
                strC = a1.a.C(strC, " profile");
            }
            if (this.inputTimebase == null) {
                strC = a1.a.C(strC, " inputTimebase");
            }
            if (this.resolution == null) {
                strC = a1.a.C(strC, " resolution");
            }
            if (this.colorFormat == null) {
                strC = a1.a.C(strC, " colorFormat");
            }
            if (this.dataSpace == null) {
                strC = a1.a.C(strC, " dataSpace");
            }
            if (this.captureFrameRate == null) {
                strC = a1.a.C(strC, " captureFrameRate");
            }
            if (this.encodeFrameRate == null) {
                strC = a1.a.C(strC, " encodeFrameRate");
            }
            if (this.IFrameInterval == null) {
                strC = a1.a.C(strC, " IFrameInterval");
            }
            if (this.bitrate == null) {
                strC = a1.a.C(strC, " bitrate");
            }
            if (strC.isEmpty()) {
                return new AutoValue_VideoEncoderConfig(this.mimeType, this.profile.intValue(), this.inputTimebase, this.resolution, this.colorFormat.intValue(), this.dataSpace, this.captureFrameRate.intValue(), this.encodeFrameRate.intValue(), this.IFrameInterval.intValue(), this.bitrate.intValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(strC));
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setBitrate(int i2) {
            this.bitrate = Integer.valueOf(i2);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setCaptureFrameRate(int i2) {
            this.captureFrameRate = Integer.valueOf(i2);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setColorFormat(int i2) {
            this.colorFormat = Integer.valueOf(i2);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setDataSpace(VideoEncoderDataSpace videoEncoderDataSpace) {
            if (videoEncoderDataSpace == null) {
                throw new NullPointerException("Null dataSpace");
            }
            this.dataSpace = videoEncoderDataSpace;
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setEncodeFrameRate(int i2) {
            this.encodeFrameRate = Integer.valueOf(i2);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setIFrameInterval(int i2) {
            this.IFrameInterval = Integer.valueOf(i2);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setInputTimebase(Timebase timebase) {
            if (timebase == null) {
                throw new NullPointerException("Null inputTimebase");
            }
            this.inputTimebase = timebase;
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setMimeType(String str) {
            if (str == null) {
                throw new NullPointerException("Null mimeType");
            }
            this.mimeType = str;
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setProfile(int i2) {
            this.profile = Integer.valueOf(i2);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setResolution(Size size) {
            if (size == null) {
                throw new NullPointerException("Null resolution");
            }
            this.resolution = size;
            return this;
        }

        public Builder() {
        }

        private Builder(VideoEncoderConfig videoEncoderConfig) {
            this.mimeType = videoEncoderConfig.getMimeType();
            this.profile = Integer.valueOf(videoEncoderConfig.getProfile());
            this.inputTimebase = videoEncoderConfig.getInputTimebase();
            this.resolution = videoEncoderConfig.getResolution();
            this.colorFormat = Integer.valueOf(videoEncoderConfig.getColorFormat());
            this.dataSpace = videoEncoderConfig.getDataSpace();
            this.captureFrameRate = Integer.valueOf(videoEncoderConfig.getCaptureFrameRate());
            this.encodeFrameRate = Integer.valueOf(videoEncoderConfig.getEncodeFrameRate());
            this.IFrameInterval = Integer.valueOf(videoEncoderConfig.getIFrameInterval());
            this.bitrate = Integer.valueOf(videoEncoderConfig.getBitrate());
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof VideoEncoderConfig) {
            VideoEncoderConfig videoEncoderConfig = (VideoEncoderConfig) obj;
            if (this.mimeType.equals(videoEncoderConfig.getMimeType()) && this.profile == videoEncoderConfig.getProfile() && this.inputTimebase.equals(videoEncoderConfig.getInputTimebase()) && this.resolution.equals(videoEncoderConfig.getResolution()) && this.colorFormat == videoEncoderConfig.getColorFormat() && this.dataSpace.equals(videoEncoderConfig.getDataSpace()) && this.captureFrameRate == videoEncoderConfig.getCaptureFrameRate() && this.encodeFrameRate == videoEncoderConfig.getEncodeFrameRate() && this.IFrameInterval == videoEncoderConfig.getIFrameInterval() && this.bitrate == videoEncoderConfig.getBitrate()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig
    public int getBitrate() {
        return this.bitrate;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig
    public int getCaptureFrameRate() {
        return this.captureFrameRate;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig
    public int getColorFormat() {
        return this.colorFormat;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig
    public VideoEncoderDataSpace getDataSpace() {
        return this.dataSpace;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig
    public int getEncodeFrameRate() {
        return this.encodeFrameRate;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig
    public int getIFrameInterval() {
        return this.IFrameInterval;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig, androidx.camera.video.internal.encoder.EncoderConfig
    public Timebase getInputTimebase() {
        return this.inputTimebase;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig, androidx.camera.video.internal.encoder.EncoderConfig
    public String getMimeType() {
        return this.mimeType;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig, androidx.camera.video.internal.encoder.EncoderConfig
    public int getProfile() {
        return this.profile;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig
    public Size getResolution() {
        return this.resolution;
    }

    public int hashCode() {
        return ((((((((((((((((((this.mimeType.hashCode() ^ 1000003) * 1000003) ^ this.profile) * 1000003) ^ this.inputTimebase.hashCode()) * 1000003) ^ this.resolution.hashCode()) * 1000003) ^ this.colorFormat) * 1000003) ^ this.dataSpace.hashCode()) * 1000003) ^ this.captureFrameRate) * 1000003) ^ this.encodeFrameRate) * 1000003) ^ this.IFrameInterval) * 1000003) ^ this.bitrate;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig
    public VideoEncoderConfig.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("VideoEncoderConfig{mimeType=");
        sb.append(this.mimeType);
        sb.append(", profile=");
        sb.append(this.profile);
        sb.append(", inputTimebase=");
        sb.append(this.inputTimebase);
        sb.append(", resolution=");
        sb.append(this.resolution);
        sb.append(", colorFormat=");
        sb.append(this.colorFormat);
        sb.append(", dataSpace=");
        sb.append(this.dataSpace);
        sb.append(", captureFrameRate=");
        sb.append(this.captureFrameRate);
        sb.append(", encodeFrameRate=");
        sb.append(this.encodeFrameRate);
        sb.append(", IFrameInterval=");
        sb.append(this.IFrameInterval);
        sb.append(", bitrate=");
        return a1.a.q(sb, "}", this.bitrate);
    }

    private AutoValue_VideoEncoderConfig(String str, int i2, Timebase timebase, Size size, int i8, VideoEncoderDataSpace videoEncoderDataSpace, int i9, int i10, int i11, int i12) {
        this.mimeType = str;
        this.profile = i2;
        this.inputTimebase = timebase;
        this.resolution = size;
        this.colorFormat = i8;
        this.dataSpace = videoEncoderDataSpace;
        this.captureFrameRate = i9;
        this.encodeFrameRate = i10;
        this.IFrameInterval = i11;
        this.bitrate = i12;
    }
}
