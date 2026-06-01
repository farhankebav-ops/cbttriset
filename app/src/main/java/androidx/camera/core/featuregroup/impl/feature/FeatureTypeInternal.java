package androidx.camera.core.featuregroup.impl.feature;

import androidx.annotation.RestrictTo;
import n7.b;
import y5.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class FeatureTypeInternal {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ FeatureTypeInternal[] $VALUES;
    public static final FeatureTypeInternal DYNAMIC_RANGE = new FeatureTypeInternal("DYNAMIC_RANGE", 0);
    public static final FeatureTypeInternal FPS_RANGE = new FeatureTypeInternal("FPS_RANGE", 1);
    public static final FeatureTypeInternal VIDEO_STABILIZATION = new FeatureTypeInternal("VIDEO_STABILIZATION", 2);
    public static final FeatureTypeInternal IMAGE_FORMAT = new FeatureTypeInternal("IMAGE_FORMAT", 3);

    private static final /* synthetic */ FeatureTypeInternal[] $values() {
        return new FeatureTypeInternal[]{DYNAMIC_RANGE, FPS_RANGE, VIDEO_STABILIZATION, IMAGE_FORMAT};
    }

    static {
        FeatureTypeInternal[] featureTypeInternalArr$values = $values();
        $VALUES = featureTypeInternalArr$values;
        $ENTRIES = b.n(featureTypeInternalArr$values);
    }

    private FeatureTypeInternal(String str, int i2) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static FeatureTypeInternal valueOf(String str) {
        return (FeatureTypeInternal) Enum.valueOf(FeatureTypeInternal.class, str);
    }

    public static FeatureTypeInternal[] values() {
        return (FeatureTypeInternal[]) $VALUES.clone();
    }
}
