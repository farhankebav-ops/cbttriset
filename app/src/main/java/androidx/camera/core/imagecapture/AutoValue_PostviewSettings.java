package androidx.camera.core.imagecapture;

import android.util.Size;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_PostviewSettings extends PostviewSettings {
    private final int inputFormat;
    private final Size resolution;

    public AutoValue_PostviewSettings(Size size, int i2) {
        if (size == null) {
            throw new NullPointerException("Null resolution");
        }
        this.resolution = size;
        this.inputFormat = i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PostviewSettings) {
            PostviewSettings postviewSettings = (PostviewSettings) obj;
            if (this.resolution.equals(postviewSettings.getResolution()) && this.inputFormat == postviewSettings.getInputFormat()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.imagecapture.PostviewSettings
    public int getInputFormat() {
        return this.inputFormat;
    }

    @Override // androidx.camera.core.imagecapture.PostviewSettings
    public Size getResolution() {
        return this.resolution;
    }

    public int hashCode() {
        return ((this.resolution.hashCode() ^ 1000003) * 1000003) ^ this.inputFormat;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PostviewSettings{resolution=");
        sb.append(this.resolution);
        sb.append(", inputFormat=");
        return a1.a.q(sb, "}", this.inputFormat);
    }
}
