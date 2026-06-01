package androidx.vectordrawable.graphics.drawable;

import a1.a;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class PathInterpolatorCompat implements Interpolator {
    public static final double EPSILON = 1.0E-5d;
    public static final int MAX_NUM_POINTS = 3000;
    private static final float PRECISION = 0.002f;
    private float[] mX;
    private float[] mY;

    public PathInterpolatorCompat(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    private void initCubic(float f4, float f8, float f9, float f10) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f4, f8, f9, f10, 1.0f, 1.0f);
        initPath(path);
    }

    private void initPath(Path path) {
        int i2 = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int iMin = Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (iMin <= 0) {
            throw new IllegalArgumentException("The Path has a invalid length " + length);
        }
        this.mX = new float[iMin];
        this.mY = new float[iMin];
        float[] fArr = new float[2];
        for (int i8 = 0; i8 < iMin; i8++) {
            pathMeasure.getPosTan((i8 * length) / (iMin - 1), fArr, null);
            this.mX[i8] = fArr[0];
            this.mY[i8] = fArr[1];
        }
        if (Math.abs(this.mX[0]) <= 1.0E-5d && Math.abs(this.mY[0]) <= 1.0E-5d) {
            int i9 = iMin - 1;
            if (Math.abs(this.mX[i9] - 1.0f) <= 1.0E-5d && Math.abs(this.mY[i9] - 1.0f) <= 1.0E-5d) {
                float f4 = 0.0f;
                int i10 = 0;
                while (i2 < iMin) {
                    float[] fArr2 = this.mX;
                    int i11 = i10 + 1;
                    float f8 = fArr2[i10];
                    if (f8 < f4) {
                        throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f8);
                    }
                    fArr2[i2] = f8;
                    i2++;
                    f4 = f8;
                    i10 = i11;
                }
                if (pathMeasure.nextContour()) {
                    throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                }
                return;
            }
        }
        StringBuilder sb = new StringBuilder("The Path must start at (0,0) and end at (1,1) start: ");
        sb.append(this.mX[0]);
        sb.append(",");
        sb.append(this.mY[0]);
        sb.append(" end:");
        int i12 = iMin - 1;
        sb.append(this.mX[i12]);
        sb.append(",");
        sb.append(this.mY[i12]);
        throw new IllegalArgumentException(sb.toString());
    }

    private void initQuad(float f4, float f8) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f4, f8, 1.0f, 1.0f);
        initPath(path);
    }

    private void parseInterpolatorFromTypeArray(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
            String namedString = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "pathData", 4);
            Path pathCreatePathFromPathData = PathParser.createPathFromPathData(namedString);
            if (pathCreatePathFromPathData == null) {
                throw new InflateException(a.l("The path is null, which is created from ", namedString));
            }
            initPath(pathCreatePathFromPathData);
            return;
        }
        if (!TypedArrayUtils.hasAttribute(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        }
        if (!TypedArrayUtils.hasAttribute(xmlPullParser, "controlY1")) {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
        float namedFloat = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
        float namedFloat2 = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
        boolean zHasAttribute = TypedArrayUtils.hasAttribute(xmlPullParser, "controlX2");
        if (zHasAttribute != TypedArrayUtils.hasAttribute(xmlPullParser, "controlY2")) {
            throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
        }
        if (zHasAttribute) {
            initCubic(namedFloat, namedFloat2, TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlX2", 2, 0.0f), TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
        } else {
            initQuad(namedFloat, namedFloat2);
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f4) {
        if (f4 <= 0.0f) {
            return 0.0f;
        }
        if (f4 >= 1.0f) {
            return 1.0f;
        }
        int length = this.mX.length - 1;
        int i2 = 0;
        while (length - i2 > 1) {
            int i8 = (i2 + length) / 2;
            if (f4 < this.mX[i8]) {
                length = i8;
            } else {
                i2 = i8;
            }
        }
        float[] fArr = this.mX;
        float f8 = fArr[length];
        float f9 = fArr[i2];
        float f10 = f8 - f9;
        if (f10 == 0.0f) {
            return this.mY[i2];
        }
        float f11 = (f4 - f9) / f10;
        float[] fArr2 = this.mY;
        float f12 = fArr2[i2];
        return a.a(fArr2[length], f12, f11, f12);
    }

    public PathInterpolatorCompat(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_PATH_INTERPOLATOR);
        parseInterpolatorFromTypeArray(typedArrayObtainAttributes, xmlPullParser);
        typedArrayObtainAttributes.recycle();
    }
}
