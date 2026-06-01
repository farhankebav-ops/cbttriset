package androidx.camera.video.internal.encoder;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_VideoEncoderDataSpace extends VideoEncoderDataSpace {
    private final int range;
    private final int standard;
    private final int transfer;

    public AutoValue_VideoEncoderDataSpace(int i2, int i8, int i9) {
        this.standard = i2;
        this.transfer = i8;
        this.range = i9;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof VideoEncoderDataSpace) {
            VideoEncoderDataSpace videoEncoderDataSpace = (VideoEncoderDataSpace) obj;
            if (this.standard == videoEncoderDataSpace.getStandard() && this.transfer == videoEncoderDataSpace.getTransfer() && this.range == videoEncoderDataSpace.getRange()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderDataSpace
    public int getRange() {
        return this.range;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderDataSpace
    public int getStandard() {
        return this.standard;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderDataSpace
    public int getTransfer() {
        return this.transfer;
    }

    public int hashCode() {
        return ((((this.standard ^ 1000003) * 1000003) ^ this.transfer) * 1000003) ^ this.range;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("VideoEncoderDataSpace{standard=");
        sb.append(this.standard);
        sb.append(", transfer=");
        sb.append(this.transfer);
        sb.append(", range=");
        return a1.a.q(sb, "}", this.range);
    }
}
