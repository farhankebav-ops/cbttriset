package androidx.camera.core.processing.util;

import android.opengl.EGLSurface;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class OutputSurface {
    public static OutputSurface of(EGLSurface eGLSurface, int i2, int i8) {
        return new AutoValue_OutputSurface(eGLSurface, i2, i8);
    }

    public abstract EGLSurface getEglSurface();

    public abstract int getHeight();

    public abstract int getWidth();
}
