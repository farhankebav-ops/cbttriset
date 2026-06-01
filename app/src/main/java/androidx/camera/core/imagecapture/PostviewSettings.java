package androidx.camera.core.imagecapture;

import android.util.Size;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PostviewSettings {
    public static PostviewSettings create(Size size, int i2) {
        return new AutoValue_PostviewSettings(size, i2);
    }

    public abstract int getInputFormat();

    public abstract Size getResolution();
}
