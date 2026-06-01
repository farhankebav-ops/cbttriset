package androidx.camera.core.streamsharing;

import android.graphics.Rect;
import android.util.Size;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class PreferredChildSize {
    private final Size childSizeToScale;
    private final Rect cropRectBeforeScaling;
    private final Size originalSelectedChildSize;

    public PreferredChildSize(Rect cropRectBeforeScaling, Size childSizeToScale, Size originalSelectedChildSize) {
        k.e(cropRectBeforeScaling, "cropRectBeforeScaling");
        k.e(childSizeToScale, "childSizeToScale");
        k.e(originalSelectedChildSize, "originalSelectedChildSize");
        this.cropRectBeforeScaling = cropRectBeforeScaling;
        this.childSizeToScale = childSizeToScale;
        this.originalSelectedChildSize = originalSelectedChildSize;
    }

    public static /* synthetic */ PreferredChildSize copy$default(PreferredChildSize preferredChildSize, Rect rect, Size size, Size size2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            rect = preferredChildSize.cropRectBeforeScaling;
        }
        if ((i2 & 2) != 0) {
            size = preferredChildSize.childSizeToScale;
        }
        if ((i2 & 4) != 0) {
            size2 = preferredChildSize.originalSelectedChildSize;
        }
        return preferredChildSize.copy(rect, size, size2);
    }

    public final Rect component1() {
        return this.cropRectBeforeScaling;
    }

    public final Size component2() {
        return this.childSizeToScale;
    }

    public final Size component3() {
        return this.originalSelectedChildSize;
    }

    public final PreferredChildSize copy(Rect cropRectBeforeScaling, Size childSizeToScale, Size originalSelectedChildSize) {
        k.e(cropRectBeforeScaling, "cropRectBeforeScaling");
        k.e(childSizeToScale, "childSizeToScale");
        k.e(originalSelectedChildSize, "originalSelectedChildSize");
        return new PreferredChildSize(cropRectBeforeScaling, childSizeToScale, originalSelectedChildSize);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PreferredChildSize)) {
            return false;
        }
        PreferredChildSize preferredChildSize = (PreferredChildSize) obj;
        return k.a(this.cropRectBeforeScaling, preferredChildSize.cropRectBeforeScaling) && k.a(this.childSizeToScale, preferredChildSize.childSizeToScale) && k.a(this.originalSelectedChildSize, preferredChildSize.originalSelectedChildSize);
    }

    public final Size getChildSizeToScale() {
        return this.childSizeToScale;
    }

    public final Rect getCropRectBeforeScaling() {
        return this.cropRectBeforeScaling;
    }

    public final Size getOriginalSelectedChildSize() {
        return this.originalSelectedChildSize;
    }

    public int hashCode() {
        return this.originalSelectedChildSize.hashCode() + ((this.childSizeToScale.hashCode() + (this.cropRectBeforeScaling.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "PreferredChildSize(cropRectBeforeScaling=" + this.cropRectBeforeScaling + ", childSizeToScale=" + this.childSizeToScale + ", originalSelectedChildSize=" + this.originalSelectedChildSize + ')';
    }
}
