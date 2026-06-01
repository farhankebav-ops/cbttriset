package androidx.graphics.shapes;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ProgressableFeature {
    private final Feature feature;
    private final float progress;

    public ProgressableFeature(float f4, Feature feature) {
        k.e(feature, "feature");
        this.progress = f4;
        this.feature = feature;
    }

    public static /* synthetic */ ProgressableFeature copy$default(ProgressableFeature progressableFeature, float f4, Feature feature, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f4 = progressableFeature.progress;
        }
        if ((i2 & 2) != 0) {
            feature = progressableFeature.feature;
        }
        return progressableFeature.copy(f4, feature);
    }

    public final float component1() {
        return this.progress;
    }

    public final Feature component2() {
        return this.feature;
    }

    public final ProgressableFeature copy(float f4, Feature feature) {
        k.e(feature, "feature");
        return new ProgressableFeature(f4, feature);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProgressableFeature)) {
            return false;
        }
        ProgressableFeature progressableFeature = (ProgressableFeature) obj;
        return Float.compare(this.progress, progressableFeature.progress) == 0 && k.a(this.feature, progressableFeature.feature);
    }

    public final Feature getFeature() {
        return this.feature;
    }

    public final float getProgress() {
        return this.progress;
    }

    public int hashCode() {
        return this.feature.hashCode() + (Float.floatToIntBits(this.progress) * 31);
    }

    public String toString() {
        return "ProgressableFeature(progress=" + this.progress + ", feature=" + this.feature + ')';
    }
}
