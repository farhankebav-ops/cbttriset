package androidx.camera.core.resolutionselector;

import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class AspectRatioStrategy {
    public static final int FALLBACK_RULE_AUTO = 1;
    public static final int FALLBACK_RULE_NONE = 0;
    private final int mFallbackRule;
    private final int mPreferredAspectRatio;
    public static final AspectRatioStrategy RATIO_4_3_FALLBACK_AUTO_STRATEGY = new AspectRatioStrategy(0, 1);
    public static final AspectRatioStrategy RATIO_16_9_FALLBACK_AUTO_STRATEGY = new AspectRatioStrategy(1, 1);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface AspectRatioFallbackRule {
    }

    public AspectRatioStrategy(int i2, int i8) {
        this.mPreferredAspectRatio = i2;
        this.mFallbackRule = i8;
    }

    public int getFallbackRule() {
        return this.mFallbackRule;
    }

    public int getPreferredAspectRatio() {
        return this.mPreferredAspectRatio;
    }
}
