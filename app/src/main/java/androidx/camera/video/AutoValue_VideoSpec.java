package androidx.camera.video;

import android.util.Range;
import androidx.camera.video.VideoSpec;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_VideoSpec extends VideoSpec {
    private final int aspectRatio;
    private final Range<Integer> bitrate;
    private final int encodeFrameRate;
    private final QualitySelector qualitySelector;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder extends VideoSpec.Builder {
        private Integer aspectRatio;
        private Range<Integer> bitrate;
        private Integer encodeFrameRate;
        private QualitySelector qualitySelector;

        @Override // androidx.camera.video.VideoSpec.Builder
        public VideoSpec build() {
            String strC = this.qualitySelector == null ? " qualitySelector" : "";
            if (this.encodeFrameRate == null) {
                strC = a1.a.C(strC, " encodeFrameRate");
            }
            if (this.bitrate == null) {
                strC = a1.a.C(strC, " bitrate");
            }
            if (this.aspectRatio == null) {
                strC = a1.a.C(strC, " aspectRatio");
            }
            if (strC.isEmpty()) {
                return new AutoValue_VideoSpec(this.qualitySelector, this.encodeFrameRate.intValue(), this.bitrate, this.aspectRatio.intValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(strC));
        }

        @Override // androidx.camera.video.VideoSpec.Builder
        public VideoSpec.Builder setAspectRatio(int i2) {
            this.aspectRatio = Integer.valueOf(i2);
            return this;
        }

        @Override // androidx.camera.video.VideoSpec.Builder
        public VideoSpec.Builder setBitrate(Range<Integer> range) {
            if (range == null) {
                throw new NullPointerException("Null bitrate");
            }
            this.bitrate = range;
            return this;
        }

        @Override // androidx.camera.video.VideoSpec.Builder
        public VideoSpec.Builder setEncodeFrameRate(int i2) {
            this.encodeFrameRate = Integer.valueOf(i2);
            return this;
        }

        @Override // androidx.camera.video.VideoSpec.Builder
        public VideoSpec.Builder setQualitySelector(QualitySelector qualitySelector) {
            if (qualitySelector == null) {
                throw new NullPointerException("Null qualitySelector");
            }
            this.qualitySelector = qualitySelector;
            return this;
        }

        public Builder() {
        }

        private Builder(VideoSpec videoSpec) {
            this.qualitySelector = videoSpec.getQualitySelector();
            this.encodeFrameRate = Integer.valueOf(videoSpec.getEncodeFrameRate());
            this.bitrate = videoSpec.getBitrate();
            this.aspectRatio = Integer.valueOf(videoSpec.getAspectRatio());
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof VideoSpec) {
            VideoSpec videoSpec = (VideoSpec) obj;
            if (this.qualitySelector.equals(videoSpec.getQualitySelector()) && this.encodeFrameRate == videoSpec.getEncodeFrameRate() && this.bitrate.equals(videoSpec.getBitrate()) && this.aspectRatio == videoSpec.getAspectRatio()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.video.VideoSpec
    public int getAspectRatio() {
        return this.aspectRatio;
    }

    @Override // androidx.camera.video.VideoSpec
    public Range<Integer> getBitrate() {
        return this.bitrate;
    }

    @Override // androidx.camera.video.VideoSpec
    public int getEncodeFrameRate() {
        return this.encodeFrameRate;
    }

    @Override // androidx.camera.video.VideoSpec
    public QualitySelector getQualitySelector() {
        return this.qualitySelector;
    }

    public int hashCode() {
        return ((((((this.qualitySelector.hashCode() ^ 1000003) * 1000003) ^ this.encodeFrameRate) * 1000003) ^ this.bitrate.hashCode()) * 1000003) ^ this.aspectRatio;
    }

    @Override // androidx.camera.video.VideoSpec
    public VideoSpec.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("VideoSpec{qualitySelector=");
        sb.append(this.qualitySelector);
        sb.append(", encodeFrameRate=");
        sb.append(this.encodeFrameRate);
        sb.append(", bitrate=");
        sb.append(this.bitrate);
        sb.append(", aspectRatio=");
        return a1.a.q(sb, "}", this.aspectRatio);
    }

    private AutoValue_VideoSpec(QualitySelector qualitySelector, int i2, Range<Integer> range, int i8) {
        this.qualitySelector = qualitySelector;
        this.encodeFrameRate = i2;
        this.bitrate = range;
        this.aspectRatio = i8;
    }
}
