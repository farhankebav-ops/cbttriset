package androidx.camera.extensions.internal.sessionprocessor;

import android.util.Size;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ImageReaderOutputConfig implements Camera2OutputConfig {
    public static ImageReaderOutputConfig create(int i2, int i8, String str, List<Camera2OutputConfig> list, Size size, int i9, int i10) {
        return new AutoValue_ImageReaderOutputConfig(i2, i8, str, list, size, i9, i10);
    }

    public abstract int getImageFormat();

    public abstract int getMaxImages();

    public abstract Size getSize();

    public static ImageReaderOutputConfig create(int i2, Size size, int i8, int i9) {
        return new AutoValue_ImageReaderOutputConfig(i2, -1, null, Collections.EMPTY_LIST, size, i8, i9);
    }
}
