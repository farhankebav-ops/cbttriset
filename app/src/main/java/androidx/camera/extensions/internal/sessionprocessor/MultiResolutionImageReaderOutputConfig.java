package androidx.camera.extensions.internal.sessionprocessor;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MultiResolutionImageReaderOutputConfig implements Camera2OutputConfig {
    public static MultiResolutionImageReaderOutputConfig create(int i2, int i8, String str, List<Camera2OutputConfig> list, int i9, int i10) {
        return new AutoValue_MultiResolutionImageReaderOutputConfig(i2, i8, str, list, i9, i10);
    }

    public abstract int getImageFormat();

    public abstract int getMaxImages();
}
