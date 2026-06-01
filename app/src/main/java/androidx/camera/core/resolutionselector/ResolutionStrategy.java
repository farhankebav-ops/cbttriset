package androidx.camera.core.resolutionselector;

import android.util.Size;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ResolutionStrategy {
    public static final int FALLBACK_RULE_CLOSEST_HIGHER = 2;
    public static final int FALLBACK_RULE_CLOSEST_HIGHER_THEN_LOWER = 1;
    public static final int FALLBACK_RULE_CLOSEST_LOWER = 4;
    public static final int FALLBACK_RULE_CLOSEST_LOWER_THEN_HIGHER = 3;
    public static final int FALLBACK_RULE_NONE = 0;
    public static final ResolutionStrategy HIGHEST_AVAILABLE_STRATEGY = new ResolutionStrategy();
    private Size mBoundSize;
    private int mFallbackRule;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ResolutionFallbackRule {
    }

    private ResolutionStrategy() {
        this.mBoundSize = null;
        this.mFallbackRule = 0;
    }

    public Size getBoundSize() {
        return this.mBoundSize;
    }

    public int getFallbackRule() {
        return this.mFallbackRule;
    }

    public ResolutionStrategy(Size size, int i2) {
        this.mBoundSize = size;
        this.mFallbackRule = i2;
    }
}
