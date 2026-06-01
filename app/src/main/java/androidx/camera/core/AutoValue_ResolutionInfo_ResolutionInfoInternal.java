package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.ResolutionInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_ResolutionInfo_ResolutionInfoInternal extends ResolutionInfo.ResolutionInfoInternal {
    private final Rect cropRect;
    private final Size resolution;
    private final int rotationDegrees;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder extends ResolutionInfo.ResolutionInfoInternal.Builder {
        private Rect cropRect;
        private Size resolution;
        private Integer rotationDegrees;

        @Override // androidx.camera.core.ResolutionInfo.ResolutionInfoInternal.Builder
        public ResolutionInfo.ResolutionInfoInternal build() {
            String strC = this.resolution == null ? " resolution" : "";
            if (this.cropRect == null) {
                strC = a1.a.C(strC, " cropRect");
            }
            if (this.rotationDegrees == null) {
                strC = a1.a.C(strC, " rotationDegrees");
            }
            if (strC.isEmpty()) {
                return new AutoValue_ResolutionInfo_ResolutionInfoInternal(this.resolution, this.cropRect, this.rotationDegrees.intValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(strC));
        }

        @Override // androidx.camera.core.ResolutionInfo.ResolutionInfoInternal.Builder
        public ResolutionInfo.ResolutionInfoInternal.Builder setCropRect(Rect rect) {
            if (rect == null) {
                throw new NullPointerException("Null cropRect");
            }
            this.cropRect = rect;
            return this;
        }

        @Override // androidx.camera.core.ResolutionInfo.ResolutionInfoInternal.Builder
        public ResolutionInfo.ResolutionInfoInternal.Builder setResolution(Size size) {
            if (size == null) {
                throw new NullPointerException("Null resolution");
            }
            this.resolution = size;
            return this;
        }

        @Override // androidx.camera.core.ResolutionInfo.ResolutionInfoInternal.Builder
        public ResolutionInfo.ResolutionInfoInternal.Builder setRotationDegrees(int i2) {
            this.rotationDegrees = Integer.valueOf(i2);
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ResolutionInfo.ResolutionInfoInternal) {
            ResolutionInfo.ResolutionInfoInternal resolutionInfoInternal = (ResolutionInfo.ResolutionInfoInternal) obj;
            if (this.resolution.equals(resolutionInfoInternal.getResolution()) && this.cropRect.equals(resolutionInfoInternal.getCropRect()) && this.rotationDegrees == resolutionInfoInternal.getRotationDegrees()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.ResolutionInfo.ResolutionInfoInternal
    public Rect getCropRect() {
        return this.cropRect;
    }

    @Override // androidx.camera.core.ResolutionInfo.ResolutionInfoInternal
    public Size getResolution() {
        return this.resolution;
    }

    @Override // androidx.camera.core.ResolutionInfo.ResolutionInfoInternal
    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    public int hashCode() {
        return ((((this.resolution.hashCode() ^ 1000003) * 1000003) ^ this.cropRect.hashCode()) * 1000003) ^ this.rotationDegrees;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ResolutionInfoInternal{resolution=");
        sb.append(this.resolution);
        sb.append(", cropRect=");
        sb.append(this.cropRect);
        sb.append(", rotationDegrees=");
        return a1.a.q(sb, "}", this.rotationDegrees);
    }

    private AutoValue_ResolutionInfo_ResolutionInfoInternal(Size size, Rect rect, int i2) {
        this.resolution = size;
        this.cropRect = rect;
        this.rotationDegrees = i2;
    }
}
