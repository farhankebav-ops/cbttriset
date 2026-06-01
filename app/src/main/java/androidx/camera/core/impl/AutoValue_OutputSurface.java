package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_OutputSurface extends OutputSurface {
    private final int imageFormat;
    private final Size size;
    private final Surface surface;

    public AutoValue_OutputSurface(Surface surface, Size size, int i2) {
        if (surface == null) {
            throw new NullPointerException("Null surface");
        }
        this.surface = surface;
        if (size == null) {
            throw new NullPointerException("Null size");
        }
        this.size = size;
        this.imageFormat = i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof OutputSurface) {
            OutputSurface outputSurface = (OutputSurface) obj;
            if (this.surface.equals(outputSurface.getSurface()) && this.size.equals(outputSurface.getSize()) && this.imageFormat == outputSurface.getImageFormat()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.impl.OutputSurface
    public int getImageFormat() {
        return this.imageFormat;
    }

    @Override // androidx.camera.core.impl.OutputSurface
    public Size getSize() {
        return this.size;
    }

    @Override // androidx.camera.core.impl.OutputSurface
    public Surface getSurface() {
        return this.surface;
    }

    public int hashCode() {
        return ((((this.surface.hashCode() ^ 1000003) * 1000003) ^ this.size.hashCode()) * 1000003) ^ this.imageFormat;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OutputSurface{surface=");
        sb.append(this.surface);
        sb.append(", size=");
        sb.append(this.size);
        sb.append(", imageFormat=");
        return a1.a.q(sb, "}", this.imageFormat);
    }
}
