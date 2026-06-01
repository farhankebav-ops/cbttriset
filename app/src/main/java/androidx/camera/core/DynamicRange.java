package androidx.camera.core;

import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class DynamicRange {
    public static final int BIT_DEPTH_10_BIT = 10;
    public static final int BIT_DEPTH_8_BIT = 8;
    public static final int BIT_DEPTH_UNSPECIFIED = 0;
    public static final int ENCODING_DOLBY_VISION = 6;
    public static final int ENCODING_HDR10 = 4;
    public static final int ENCODING_HDR10_PLUS = 5;
    public static final int ENCODING_HDR_UNSPECIFIED = 2;
    public static final int ENCODING_HLG = 3;
    public static final int ENCODING_SDR = 1;
    public static final int ENCODING_UNSPECIFIED = 0;
    private final int mBitDepth;
    private final int mEncoding;
    public static final DynamicRange UNSPECIFIED = new DynamicRange(0, 0);
    public static final DynamicRange SDR = new DynamicRange(1, 8);
    public static final DynamicRange HDR_UNSPECIFIED_10_BIT = new DynamicRange(2, 10);
    public static final DynamicRange HLG_10_BIT = new DynamicRange(3, 10);
    public static final DynamicRange HDR10_10_BIT = new DynamicRange(4, 10);
    public static final DynamicRange HDR10_PLUS_10_BIT = new DynamicRange(5, 10);
    public static final DynamicRange DOLBY_VISION_10_BIT = new DynamicRange(6, 10);
    public static final DynamicRange DOLBY_VISION_8_BIT = new DynamicRange(6, 8);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface BitDepth {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface DynamicRangeEncoding {
    }

    public DynamicRange(int i2, int i8) {
        this.mEncoding = i2;
        this.mBitDepth = i8;
    }

    private static String getEncodingLabel(int i2) {
        switch (i2) {
            case 0:
                return "UNSPECIFIED";
            case 1:
                return "SDR";
            case 2:
                return "HDR_UNSPECIFIED";
            case 3:
                return "HLG";
            case 4:
                return "HDR10";
            case 5:
                return "HDR10_PLUS";
            case 6:
                return "DOLBY_VISION";
            default:
                return "<Unknown>";
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DynamicRange) {
            DynamicRange dynamicRange = (DynamicRange) obj;
            if (this.mEncoding == dynamicRange.getEncoding() && this.mBitDepth == dynamicRange.getBitDepth()) {
                return true;
            }
        }
        return false;
    }

    public int getBitDepth() {
        return this.mBitDepth;
    }

    public int getEncoding() {
        return this.mEncoding;
    }

    public int hashCode() {
        return ((this.mEncoding ^ 1000003) * 1000003) ^ this.mBitDepth;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean is10BitHdr() {
        return isFullySpecified() && getEncoding() != 1 && getBitDepth() == 10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isFullySpecified() {
        return (getEncoding() == 0 || getEncoding() == 2 || getBitDepth() == 0) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DynamicRange@");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("{encoding=");
        sb.append(getEncodingLabel(this.mEncoding));
        sb.append(", bitDepth=");
        return a1.a.q(sb, "}", this.mBitDepth);
    }
}
