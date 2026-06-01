package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class OutputSurface {
    public static OutputSurface create(Surface surface, Size size, int i2) {
        return new AutoValue_OutputSurface(surface, size, i2);
    }

    public abstract int getImageFormat();

    public abstract Size getSize();

    public abstract Surface getSurface();
}
