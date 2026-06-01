package androidx.camera.core.processing.util;

import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.processing.SurfaceEdge;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class OutConfig {
    public static OutConfig of(SurfaceEdge surfaceEdge) {
        return of(surfaceEdge.getTargets(), surfaceEdge.getFormat(), surfaceEdge.getCropRect(), TransformUtils.getRotatedSize(surfaceEdge.getCropRect(), surfaceEdge.getRotationDegrees()), surfaceEdge.getRotationDegrees(), surfaceEdge.isMirroring());
    }

    public abstract Rect getCropRect();

    public abstract int getFormat();

    public abstract int getRotationDegrees();

    public abstract Size getSize();

    public abstract int getTargets();

    public abstract UUID getUuid();

    public abstract boolean isMirroring();

    public abstract boolean shouldRespectInputCropRect();

    public static OutConfig of(int i2, int i8, Rect rect, Size size, int i9, boolean z2) {
        return of(i2, i8, rect, size, i9, z2, false);
    }

    public static OutConfig of(int i2, int i8, Rect rect, Size size, int i9, boolean z2, boolean z7) {
        return new AutoValue_OutConfig(UUID.randomUUID(), i2, i8, rect, size, i9, z2, z7);
    }
}
