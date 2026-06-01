package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class ArcMotion extends PathMotion {
    private static final float DEFAULT_MAX_ANGLE_DEGREES = 70.0f;
    private static final float DEFAULT_MAX_TANGENT = (float) Math.tan(Math.toRadians(35.0d));
    private static final float DEFAULT_MIN_ANGLE_DEGREES = 0.0f;
    private float mMaximumAngle;
    private float mMaximumTangent;
    private float mMinimumHorizontalAngle;
    private float mMinimumHorizontalTangent;
    private float mMinimumVerticalAngle;
    private float mMinimumVerticalTangent;

    public ArcMotion() {
        this.mMinimumHorizontalAngle = 0.0f;
        this.mMinimumVerticalAngle = 0.0f;
        this.mMaximumAngle = DEFAULT_MAX_ANGLE_DEGREES;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = DEFAULT_MAX_TANGENT;
    }

    private static float toTangent(float f4) {
        if (f4 < 0.0f || f4 > 90.0f) {
            throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
        }
        return (float) Math.tan(Math.toRadians(f4 / 2.0f));
    }

    public float getMaximumAngle() {
        return this.mMaximumAngle;
    }

    public float getMinimumHorizontalAngle() {
        return this.mMinimumHorizontalAngle;
    }

    public float getMinimumVerticalAngle() {
        return this.mMinimumVerticalAngle;
    }

    @Override // androidx.transition.PathMotion
    @NonNull
    public Path getPath(float f4, float f8, float f9, float f10) {
        float fA;
        float fA2;
        float f11;
        Path path = new Path();
        path.moveTo(f4, f8);
        float f12 = f9 - f4;
        float f13 = f10 - f8;
        float f14 = (f13 * f13) + (f12 * f12);
        float f15 = (f4 + f9) / 2.0f;
        float f16 = (f8 + f10) / 2.0f;
        float f17 = 0.25f * f14;
        boolean z2 = f8 > f10;
        if (Math.abs(f12) < Math.abs(f13)) {
            float fAbs = Math.abs(f14 / (f13 * 2.0f));
            if (z2) {
                fA2 = fAbs + f10;
                fA = f9;
            } else {
                fA2 = fAbs + f8;
                fA = f4;
            }
            f11 = this.mMinimumVerticalTangent;
        } else {
            float f18 = f14 / (f12 * 2.0f);
            if (z2) {
                fA2 = f8;
                fA = f18 + f4;
            } else {
                fA = f9 - f18;
                fA2 = f10;
            }
            f11 = this.mMinimumHorizontalTangent;
        }
        float f19 = f17 * f11 * f11;
        float f20 = f15 - fA;
        float f21 = f16 - fA2;
        float f22 = (f21 * f21) + (f20 * f20);
        float f23 = this.mMaximumTangent;
        float f24 = f17 * f23 * f23;
        if (f22 >= f19) {
            f19 = f22 > f24 ? f24 : 0.0f;
        }
        if (f19 != 0.0f) {
            float fSqrt = (float) Math.sqrt(f19 / f22);
            fA = a1.a.a(fA, f15, fSqrt, f15);
            fA2 = a1.a.a(fA2, f16, fSqrt, f16);
        }
        path.cubicTo((f4 + fA) / 2.0f, (f8 + fA2) / 2.0f, (fA + f9) / 2.0f, (fA2 + f10) / 2.0f, f9, f10);
        return path;
    }

    public void setMaximumAngle(float f4) {
        this.mMaximumAngle = f4;
        this.mMaximumTangent = toTangent(f4);
    }

    public void setMinimumHorizontalAngle(float f4) {
        this.mMinimumHorizontalAngle = f4;
        this.mMinimumHorizontalTangent = toTangent(f4);
    }

    public void setMinimumVerticalAngle(float f4) {
        this.mMinimumVerticalAngle = f4;
        this.mMinimumVerticalTangent = toTangent(f4);
    }

    public ArcMotion(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMinimumHorizontalAngle = 0.0f;
        this.mMinimumVerticalAngle = 0.0f;
        this.mMaximumAngle = DEFAULT_MAX_ANGLE_DEGREES;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = DEFAULT_MAX_TANGENT;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.ARC_MOTION);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        setMinimumVerticalAngle(TypedArrayUtils.getNamedFloat(typedArrayObtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        setMinimumHorizontalAngle(TypedArrayUtils.getNamedFloat(typedArrayObtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        setMaximumAngle(TypedArrayUtils.getNamedFloat(typedArrayObtainStyledAttributes, xmlPullParser, "maximumAngle", 2, DEFAULT_MAX_ANGLE_DEGREES));
        typedArrayObtainStyledAttributes.recycle();
    }
}
