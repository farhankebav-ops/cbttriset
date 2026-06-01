package androidx.camera.camera2.internal;

import android.util.Range;
import androidx.camera.camera2.internal.SupportedSurfaceCombination;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_SupportedSurfaceCombination_FeatureSettings extends SupportedSurfaceCombination.FeatureSettings {
    private final int getCameraMode;
    private final int getRequiredMaxBitDepth;
    private final Range<Integer> getTargetFpsRange;
    private final boolean hasVideoCapture;
    private final boolean isFeatureComboInvocation;
    private final boolean isHighSpeedOn;
    private final boolean isPreviewStabilizationOn;
    private final boolean isStrictFpsRequired;
    private final boolean isUltraHdrOn;
    private final boolean requiresFeatureComboQuery;

    public AutoValue_SupportedSurfaceCombination_FeatureSettings(int i2, boolean z2, int i8, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, Range<Integer> range, boolean z12) {
        this.getCameraMode = i2;
        this.hasVideoCapture = z2;
        this.getRequiredMaxBitDepth = i8;
        this.isPreviewStabilizationOn = z7;
        this.isUltraHdrOn = z8;
        this.isHighSpeedOn = z9;
        this.isFeatureComboInvocation = z10;
        this.requiresFeatureComboQuery = z11;
        if (range == null) {
            throw new NullPointerException("Null getTargetFpsRange");
        }
        this.getTargetFpsRange = range;
        this.isStrictFpsRequired = z12;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SupportedSurfaceCombination.FeatureSettings) {
            SupportedSurfaceCombination.FeatureSettings featureSettings = (SupportedSurfaceCombination.FeatureSettings) obj;
            if (this.getCameraMode == featureSettings.getCameraMode() && this.hasVideoCapture == featureSettings.hasVideoCapture() && this.getRequiredMaxBitDepth == featureSettings.getRequiredMaxBitDepth() && this.isPreviewStabilizationOn == featureSettings.isPreviewStabilizationOn() && this.isUltraHdrOn == featureSettings.isUltraHdrOn() && this.isHighSpeedOn == featureSettings.isHighSpeedOn() && this.isFeatureComboInvocation == featureSettings.isFeatureComboInvocation() && this.requiresFeatureComboQuery == featureSettings.requiresFeatureComboQuery() && this.getTargetFpsRange.equals(featureSettings.getTargetFpsRange()) && this.isStrictFpsRequired == featureSettings.isStrictFpsRequired()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.camera2.internal.SupportedSurfaceCombination.FeatureSettings
    public int getCameraMode() {
        return this.getCameraMode;
    }

    @Override // androidx.camera.camera2.internal.SupportedSurfaceCombination.FeatureSettings
    public int getRequiredMaxBitDepth() {
        return this.getRequiredMaxBitDepth;
    }

    @Override // androidx.camera.camera2.internal.SupportedSurfaceCombination.FeatureSettings
    public Range<Integer> getTargetFpsRange() {
        return this.getTargetFpsRange;
    }

    @Override // androidx.camera.camera2.internal.SupportedSurfaceCombination.FeatureSettings
    public boolean hasVideoCapture() {
        return this.hasVideoCapture;
    }

    public int hashCode() {
        return ((((((((((((((((((this.getCameraMode ^ 1000003) * 1000003) ^ (this.hasVideoCapture ? 1231 : 1237)) * 1000003) ^ this.getRequiredMaxBitDepth) * 1000003) ^ (this.isPreviewStabilizationOn ? 1231 : 1237)) * 1000003) ^ (this.isUltraHdrOn ? 1231 : 1237)) * 1000003) ^ (this.isHighSpeedOn ? 1231 : 1237)) * 1000003) ^ (this.isFeatureComboInvocation ? 1231 : 1237)) * 1000003) ^ (this.requiresFeatureComboQuery ? 1231 : 1237)) * 1000003) ^ this.getTargetFpsRange.hashCode()) * 1000003) ^ (this.isStrictFpsRequired ? 1231 : 1237);
    }

    @Override // androidx.camera.camera2.internal.SupportedSurfaceCombination.FeatureSettings
    public boolean isFeatureComboInvocation() {
        return this.isFeatureComboInvocation;
    }

    @Override // androidx.camera.camera2.internal.SupportedSurfaceCombination.FeatureSettings
    public boolean isHighSpeedOn() {
        return this.isHighSpeedOn;
    }

    @Override // androidx.camera.camera2.internal.SupportedSurfaceCombination.FeatureSettings
    public boolean isPreviewStabilizationOn() {
        return this.isPreviewStabilizationOn;
    }

    @Override // androidx.camera.camera2.internal.SupportedSurfaceCombination.FeatureSettings
    public boolean isStrictFpsRequired() {
        return this.isStrictFpsRequired;
    }

    @Override // androidx.camera.camera2.internal.SupportedSurfaceCombination.FeatureSettings
    public boolean isUltraHdrOn() {
        return this.isUltraHdrOn;
    }

    @Override // androidx.camera.camera2.internal.SupportedSurfaceCombination.FeatureSettings
    public boolean requiresFeatureComboQuery() {
        return this.requiresFeatureComboQuery;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FeatureSettings{getCameraMode=");
        sb.append(this.getCameraMode);
        sb.append(", hasVideoCapture=");
        sb.append(this.hasVideoCapture);
        sb.append(", getRequiredMaxBitDepth=");
        sb.append(this.getRequiredMaxBitDepth);
        sb.append(", isPreviewStabilizationOn=");
        sb.append(this.isPreviewStabilizationOn);
        sb.append(", isUltraHdrOn=");
        sb.append(this.isUltraHdrOn);
        sb.append(", isHighSpeedOn=");
        sb.append(this.isHighSpeedOn);
        sb.append(", isFeatureComboInvocation=");
        sb.append(this.isFeatureComboInvocation);
        sb.append(", requiresFeatureComboQuery=");
        sb.append(this.requiresFeatureComboQuery);
        sb.append(", getTargetFpsRange=");
        sb.append(this.getTargetFpsRange);
        sb.append(", isStrictFpsRequired=");
        return a1.a.u(sb, this.isStrictFpsRequired, "}");
    }
}
