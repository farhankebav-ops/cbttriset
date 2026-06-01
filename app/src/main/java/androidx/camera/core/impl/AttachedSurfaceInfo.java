package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.UseCaseConfigFactory;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AttachedSurfaceInfo {
    public static AttachedSurfaceInfo create(SurfaceConfig surfaceConfig, int i2, Size size, DynamicRange dynamicRange, List<UseCaseConfigFactory.CaptureType> list, Config config, int i8, Range<Integer> range, boolean z2) {
        return new AutoValue_AttachedSurfaceInfo(surfaceConfig, i2, size, dynamicRange, list, config, i8, range, z2);
    }

    public abstract List<UseCaseConfigFactory.CaptureType> getCaptureTypes();

    public abstract DynamicRange getDynamicRange();

    public abstract int getImageFormat();

    public abstract Config getImplementationOptions();

    public abstract int getSessionType();

    public abstract Size getSize();

    public abstract SurfaceConfig getSurfaceConfig();

    public abstract Range<Integer> getTargetFrameRate();

    public abstract boolean isStrictFrameRateRequired();

    public StreamSpec toStreamSpec(Config config) {
        return StreamSpec.builder(getSize()).setSessionType(getSessionType()).setExpectedFrameRateRange(getTargetFrameRate()).setDynamicRange(getDynamicRange()).setImplementationOptions(config).build();
    }
}
