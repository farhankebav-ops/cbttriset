package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.UseCaseConfigFactory;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_AttachedSurfaceInfo extends AttachedSurfaceInfo {
    private final List<UseCaseConfigFactory.CaptureType> captureTypes;
    private final DynamicRange dynamicRange;
    private final int imageFormat;
    private final Config implementationOptions;
    private final int sessionType;
    private final Size size;
    private final boolean strictFrameRateRequired;
    private final SurfaceConfig surfaceConfig;
    private final Range<Integer> targetFrameRate;

    public AutoValue_AttachedSurfaceInfo(SurfaceConfig surfaceConfig, int i2, Size size, DynamicRange dynamicRange, List<UseCaseConfigFactory.CaptureType> list, Config config, int i8, Range<Integer> range, boolean z2) {
        if (surfaceConfig == null) {
            throw new NullPointerException("Null surfaceConfig");
        }
        this.surfaceConfig = surfaceConfig;
        this.imageFormat = i2;
        if (size == null) {
            throw new NullPointerException("Null size");
        }
        this.size = size;
        if (dynamicRange == null) {
            throw new NullPointerException("Null dynamicRange");
        }
        this.dynamicRange = dynamicRange;
        if (list == null) {
            throw new NullPointerException("Null captureTypes");
        }
        this.captureTypes = list;
        this.implementationOptions = config;
        this.sessionType = i8;
        if (range == null) {
            throw new NullPointerException("Null targetFrameRate");
        }
        this.targetFrameRate = range;
        this.strictFrameRateRequired = z2;
    }

    public boolean equals(Object obj) {
        Config config;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AttachedSurfaceInfo) {
            AttachedSurfaceInfo attachedSurfaceInfo = (AttachedSurfaceInfo) obj;
            if (this.surfaceConfig.equals(attachedSurfaceInfo.getSurfaceConfig()) && this.imageFormat == attachedSurfaceInfo.getImageFormat() && this.size.equals(attachedSurfaceInfo.getSize()) && this.dynamicRange.equals(attachedSurfaceInfo.getDynamicRange()) && this.captureTypes.equals(attachedSurfaceInfo.getCaptureTypes()) && ((config = this.implementationOptions) != null ? config.equals(attachedSurfaceInfo.getImplementationOptions()) : attachedSurfaceInfo.getImplementationOptions() == null) && this.sessionType == attachedSurfaceInfo.getSessionType() && this.targetFrameRate.equals(attachedSurfaceInfo.getTargetFrameRate()) && this.strictFrameRateRequired == attachedSurfaceInfo.isStrictFrameRateRequired()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    public List<UseCaseConfigFactory.CaptureType> getCaptureTypes() {
        return this.captureTypes;
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    public DynamicRange getDynamicRange() {
        return this.dynamicRange;
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    public int getImageFormat() {
        return this.imageFormat;
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    public Config getImplementationOptions() {
        return this.implementationOptions;
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    public int getSessionType() {
        return this.sessionType;
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    public Size getSize() {
        return this.size;
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    public SurfaceConfig getSurfaceConfig() {
        return this.surfaceConfig;
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    public Range<Integer> getTargetFrameRate() {
        return this.targetFrameRate;
    }

    public int hashCode() {
        int iHashCode = (((((((((this.surfaceConfig.hashCode() ^ 1000003) * 1000003) ^ this.imageFormat) * 1000003) ^ this.size.hashCode()) * 1000003) ^ this.dynamicRange.hashCode()) * 1000003) ^ this.captureTypes.hashCode()) * 1000003;
        Config config = this.implementationOptions;
        return ((((((iHashCode ^ (config == null ? 0 : config.hashCode())) * 1000003) ^ this.sessionType) * 1000003) ^ this.targetFrameRate.hashCode()) * 1000003) ^ (this.strictFrameRateRequired ? 1231 : 1237);
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    public boolean isStrictFrameRateRequired() {
        return this.strictFrameRateRequired;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AttachedSurfaceInfo{surfaceConfig=");
        sb.append(this.surfaceConfig);
        sb.append(", imageFormat=");
        sb.append(this.imageFormat);
        sb.append(", size=");
        sb.append(this.size);
        sb.append(", dynamicRange=");
        sb.append(this.dynamicRange);
        sb.append(", captureTypes=");
        sb.append(this.captureTypes);
        sb.append(", implementationOptions=");
        sb.append(this.implementationOptions);
        sb.append(", sessionType=");
        sb.append(this.sessionType);
        sb.append(", targetFrameRate=");
        sb.append(this.targetFrameRate);
        sb.append(", strictFrameRateRequired=");
        return a1.a.u(sb, this.strictFrameRateRequired, "}");
    }
}
