package androidx.camera.video;

import android.util.Size;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class Quality {
    public static final Quality FHD;
    public static final Quality HD;
    public static final Quality HIGHEST;
    public static final Quality LOWEST;
    static final Quality NONE;
    private static final Set<Quality> QUALITIES;
    private static final List<Quality> QUALITIES_ORDER_BY_SIZE;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int QUALITY_SOURCE_HIGH_SPEED = 2;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int QUALITY_SOURCE_REGULAR = 1;
    public static final Quality SD;
    public static final Quality UHD;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static abstract class ConstantQuality extends Quality {
        public ConstantQuality() {
            super();
        }

        public static ConstantQuality of(int i2, int i8, String str, List<Size> list) {
            return new AutoValue_Quality_ConstantQuality(i2, i8, str, list);
        }

        public abstract int getHighSpeedValue();

        public abstract String getName();

        public int getQualityValue(int i2) {
            if (i2 == 1) {
                return getValue();
            }
            if (i2 == 2) {
                return getHighSpeedValue();
            }
            throw new AssertionError(a1.a.g(i2, "Unknown quality source: "));
        }

        public abstract List<Size> getTypicalSizes();

        public abstract int getValue();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface QualitySource {
    }

    static {
        ConstantQuality constantQualityOf = ConstantQuality.of(4, 2002, "SD", Collections.unmodifiableList(Arrays.asList(new Size(720, 480), new Size(640, 480))));
        SD = constantQualityOf;
        ConstantQuality constantQualityOf2 = ConstantQuality.of(5, 2003, "HD", Collections.singletonList(new Size(1280, 720)));
        HD = constantQualityOf2;
        ConstantQuality constantQualityOf3 = ConstantQuality.of(6, 2004, "FHD", Collections.singletonList(new Size(1920, 1080)));
        FHD = constantQualityOf3;
        ConstantQuality constantQualityOf4 = ConstantQuality.of(8, 2005, "UHD", Collections.singletonList(new Size(3840, 2160)));
        UHD = constantQualityOf4;
        List list = Collections.EMPTY_LIST;
        ConstantQuality constantQualityOf5 = ConstantQuality.of(0, 2000, "LOWEST", list);
        LOWEST = constantQualityOf5;
        ConstantQuality constantQualityOf6 = ConstantQuality.of(1, 2001, "HIGHEST", list);
        HIGHEST = constantQualityOf6;
        NONE = ConstantQuality.of(-1, -1, "NONE", list);
        QUALITIES = new HashSet(Arrays.asList(constantQualityOf5, constantQualityOf6, constantQualityOf, constantQualityOf2, constantQualityOf3, constantQualityOf4));
        QUALITIES_ORDER_BY_SIZE = Arrays.asList(constantQualityOf4, constantQualityOf3, constantQualityOf2, constantQualityOf);
    }

    public static boolean containsQuality(Quality quality) {
        return QUALITIES.contains(quality);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static List<Quality> getSortedQualities() {
        return new ArrayList(QUALITIES_ORDER_BY_SIZE);
    }

    private Quality() {
    }
}
