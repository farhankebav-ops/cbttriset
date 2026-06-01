package androidx.camera.extensions.internal.sessionprocessor;

import android.view.Surface;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SurfaceOutputConfig implements Camera2OutputConfig {
    public static SurfaceOutputConfig create(int i2, int i8, String str, List<Camera2OutputConfig> list, Surface surface) {
        return new AutoValue_SurfaceOutputConfig(i2, i8, str, list, surface);
    }

    public abstract Surface getSurface();

    public static SurfaceOutputConfig create(int i2, Surface surface) {
        return create(i2, -1, null, Collections.EMPTY_LIST, surface);
    }
}
