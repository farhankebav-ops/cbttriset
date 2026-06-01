package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.Rect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.Utils;
import com.ironsource.C2300e4;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    static final int PERPENDICULAR = 1;
    public static final String TAG = "MotionPaths";
    static String[] sNames = {C2300e4.h.L, "x", "y", "width", "height", "pathRotate"};
    private float mHeight;
    private Easing mKeyFrameEasing;
    private float mPosition;
    int mVisibility;
    private float mWidth;
    private float mX;
    private float mY;
    private float mAlpha = 1.0f;
    int mVisibilityMode = 0;
    private boolean mApplyElevation = false;
    private float mElevation = 0.0f;
    private float mRotation = 0.0f;
    private float mRotationX = 0.0f;
    public float rotationY = 0.0f;
    private float mScaleX = 1.0f;
    private float mScaleY = 1.0f;
    private float mPivotX = Float.NaN;
    private float mPivotY = Float.NaN;
    private float mTranslationX = 0.0f;
    private float mTranslationY = 0.0f;
    private float mTranslationZ = 0.0f;
    private int mDrawPath = 0;
    private float mPathRotate = Float.NaN;
    private float mProgress = Float.NaN;
    private int mAnimateRelativeTo = -1;
    LinkedHashMap<String, CustomVariable> mCustomVariable = new LinkedHashMap<>();
    int mMode = 0;
    double[] mTempValue = new double[18];
    double[] mTempDelta = new double[18];

    private boolean diff(float f4, float f8) {
        return (Float.isNaN(f4) || Float.isNaN(f8)) ? Float.isNaN(f4) != Float.isNaN(f8) : Math.abs(f4 - f8) > 1.0E-6f;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void addValues(HashMap<String, SplineSet> map, int i2) {
        for (String str : map.keySet()) {
            SplineSet splineSet = map.get(str);
            str.getClass();
            byte b8 = -1;
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals("rotationX")) {
                        b8 = 0;
                    }
                    break;
                case -1249320805:
                    if (str.equals("rotationY")) {
                        b8 = 1;
                    }
                    break;
                case -1249320804:
                    if (str.equals("rotationZ")) {
                        b8 = 2;
                    }
                    break;
                case -1225497657:
                    if (str.equals("translationX")) {
                        b8 = 3;
                    }
                    break;
                case -1225497656:
                    if (str.equals("translationY")) {
                        b8 = 4;
                    }
                    break;
                case -1225497655:
                    if (str.equals("translationZ")) {
                        b8 = 5;
                    }
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        b8 = 6;
                    }
                    break;
                case -987906986:
                    if (str.equals("pivotX")) {
                        b8 = 7;
                    }
                    break;
                case -987906985:
                    if (str.equals("pivotY")) {
                        b8 = 8;
                    }
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        b8 = 9;
                    }
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        b8 = 10;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        b8 = 11;
                    }
                    break;
                case 803192288:
                    if (str.equals("pathRotate")) {
                        b8 = 12;
                    }
                    break;
            }
            switch (b8) {
                case 0:
                    splineSet.setPoint(i2, Float.isNaN(this.mRotationX) ? 0.0f : this.mRotationX);
                    break;
                case 1:
                    splineSet.setPoint(i2, Float.isNaN(this.rotationY) ? 0.0f : this.rotationY);
                    break;
                case 2:
                    splineSet.setPoint(i2, Float.isNaN(this.mRotation) ? 0.0f : this.mRotation);
                    break;
                case 3:
                    splineSet.setPoint(i2, Float.isNaN(this.mTranslationX) ? 0.0f : this.mTranslationX);
                    break;
                case 4:
                    splineSet.setPoint(i2, Float.isNaN(this.mTranslationY) ? 0.0f : this.mTranslationY);
                    break;
                case 5:
                    splineSet.setPoint(i2, Float.isNaN(this.mTranslationZ) ? 0.0f : this.mTranslationZ);
                    break;
                case 6:
                    splineSet.setPoint(i2, Float.isNaN(this.mProgress) ? 0.0f : this.mProgress);
                    break;
                case 7:
                    splineSet.setPoint(i2, Float.isNaN(this.mPivotX) ? 0.0f : this.mPivotX);
                    break;
                case 8:
                    splineSet.setPoint(i2, Float.isNaN(this.mPivotY) ? 0.0f : this.mPivotY);
                    break;
                case 9:
                    splineSet.setPoint(i2, Float.isNaN(this.mScaleX) ? 1.0f : this.mScaleX);
                    break;
                case 10:
                    splineSet.setPoint(i2, Float.isNaN(this.mScaleY) ? 1.0f : this.mScaleY);
                    break;
                case 11:
                    splineSet.setPoint(i2, Float.isNaN(this.mAlpha) ? 1.0f : this.mAlpha);
                    break;
                case 12:
                    splineSet.setPoint(i2, Float.isNaN(this.mPathRotate) ? 0.0f : this.mPathRotate);
                    break;
                default:
                    if (str.startsWith("CUSTOM")) {
                        String str2 = str.split(",")[1];
                        if (this.mCustomVariable.containsKey(str2)) {
                            CustomVariable customVariable = this.mCustomVariable.get(str2);
                            if (splineSet instanceof SplineSet.CustomSpline) {
                                ((SplineSet.CustomSpline) splineSet).setPoint(i2, customVariable);
                            } else {
                                Utils.loge("MotionPaths", str + " ViewSpline not a CustomSet frame = " + i2 + ", value" + customVariable.getValueToInterpolate() + splineSet);
                            }
                        }
                    } else {
                        Utils.loge("MotionPaths", "UNKNOWN spline ".concat(str));
                    }
                    break;
            }
        }
    }

    public void applyParameters(MotionWidget motionWidget) {
        this.mVisibility = motionWidget.getVisibility();
        this.mAlpha = motionWidget.getVisibility() != 4 ? 0.0f : motionWidget.getAlpha();
        this.mApplyElevation = false;
        this.mRotation = motionWidget.getRotationZ();
        this.mRotationX = motionWidget.getRotationX();
        this.rotationY = motionWidget.getRotationY();
        this.mScaleX = motionWidget.getScaleX();
        this.mScaleY = motionWidget.getScaleY();
        this.mPivotX = motionWidget.getPivotX();
        this.mPivotY = motionWidget.getPivotY();
        this.mTranslationX = motionWidget.getTranslationX();
        this.mTranslationY = motionWidget.getTranslationY();
        this.mTranslationZ = motionWidget.getTranslationZ();
        for (String str : motionWidget.getCustomAttributeNames()) {
            CustomVariable customAttribute = motionWidget.getCustomAttribute(str);
            if (customAttribute != null && customAttribute.isContinuous()) {
                this.mCustomVariable.put(str, customAttribute);
            }
        }
    }

    public void different(MotionConstrainedPoint motionConstrainedPoint, HashSet<String> hashSet) {
        if (diff(this.mAlpha, motionConstrainedPoint.mAlpha)) {
            hashSet.add("alpha");
        }
        if (diff(this.mElevation, motionConstrainedPoint.mElevation)) {
            hashSet.add("translationZ");
        }
        int i2 = this.mVisibility;
        int i8 = motionConstrainedPoint.mVisibility;
        if (i2 != i8 && this.mVisibilityMode == 0 && (i2 == 4 || i8 == 4)) {
            hashSet.add("alpha");
        }
        if (diff(this.mRotation, motionConstrainedPoint.mRotation)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.mPathRotate) || !Float.isNaN(motionConstrainedPoint.mPathRotate)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.mProgress) || !Float.isNaN(motionConstrainedPoint.mProgress)) {
            hashSet.add("progress");
        }
        if (diff(this.mRotationX, motionConstrainedPoint.mRotationX)) {
            hashSet.add("rotationX");
        }
        if (diff(this.rotationY, motionConstrainedPoint.rotationY)) {
            hashSet.add("rotationY");
        }
        if (diff(this.mPivotX, motionConstrainedPoint.mPivotX)) {
            hashSet.add("pivotX");
        }
        if (diff(this.mPivotY, motionConstrainedPoint.mPivotY)) {
            hashSet.add("pivotY");
        }
        if (diff(this.mScaleX, motionConstrainedPoint.mScaleX)) {
            hashSet.add("scaleX");
        }
        if (diff(this.mScaleY, motionConstrainedPoint.mScaleY)) {
            hashSet.add("scaleY");
        }
        if (diff(this.mTranslationX, motionConstrainedPoint.mTranslationX)) {
            hashSet.add("translationX");
        }
        if (diff(this.mTranslationY, motionConstrainedPoint.mTranslationY)) {
            hashSet.add("translationY");
        }
        if (diff(this.mTranslationZ, motionConstrainedPoint.mTranslationZ)) {
            hashSet.add("translationZ");
        }
        if (diff(this.mElevation, motionConstrainedPoint.mElevation)) {
            hashSet.add("elevation");
        }
    }

    public void fillStandard(double[] dArr, int[] iArr) {
        int i2 = 0;
        float[] fArr = {this.mPosition, this.mX, this.mY, this.mWidth, this.mHeight, this.mAlpha, this.mElevation, this.mRotation, this.mRotationX, this.rotationY, this.mScaleX, this.mScaleY, this.mPivotX, this.mPivotY, this.mTranslationX, this.mTranslationY, this.mTranslationZ, this.mPathRotate};
        for (int i8 : iArr) {
            if (i8 < 18) {
                dArr[i2] = fArr[r4];
                i2++;
            }
        }
    }

    public int getCustomData(String str, double[] dArr, int i2) {
        CustomVariable customVariable = this.mCustomVariable.get(str);
        if (customVariable.numberOfInterpolatedValues() == 1) {
            dArr[i2] = customVariable.getValueToInterpolate();
            return 1;
        }
        int iNumberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
        customVariable.getValuesToInterpolate(new float[iNumberOfInterpolatedValues]);
        int i8 = 0;
        while (i8 < iNumberOfInterpolatedValues) {
            dArr[i2] = r1[i8];
            i8++;
            i2++;
        }
        return iNumberOfInterpolatedValues;
    }

    public int getCustomDataCount(String str) {
        return this.mCustomVariable.get(str).numberOfInterpolatedValues();
    }

    public boolean hasCustomData(String str) {
        return this.mCustomVariable.containsKey(str);
    }

    public void setBounds(float f4, float f8, float f9, float f10) {
        this.mX = f4;
        this.mY = f8;
        this.mWidth = f9;
        this.mHeight = f10;
    }

    public void setState(MotionWidget motionWidget) {
        setBounds(motionWidget.getX(), motionWidget.getY(), motionWidget.getWidth(), motionWidget.getHeight());
        applyParameters(motionWidget);
    }

    @Override // java.lang.Comparable
    public int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        return Float.compare(this.mPosition, motionConstrainedPoint.mPosition);
    }

    public void setState(Rect rect, MotionWidget motionWidget, int i2, float f4) {
        setBounds(rect.left, rect.top, rect.width(), rect.height());
        applyParameters(motionWidget);
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        if (i2 == 1) {
            this.mRotation = f4 - 90.0f;
        } else {
            if (i2 != 2) {
                return;
            }
            this.mRotation = f4 + 90.0f;
        }
    }

    public void different(MotionConstrainedPoint motionConstrainedPoint, boolean[] zArr, String[] strArr) {
        zArr[0] = zArr[0] | diff(this.mPosition, motionConstrainedPoint.mPosition);
        zArr[1] = zArr[1] | diff(this.mX, motionConstrainedPoint.mX);
        zArr[2] = zArr[2] | diff(this.mY, motionConstrainedPoint.mY);
        zArr[3] = zArr[3] | diff(this.mWidth, motionConstrainedPoint.mWidth);
        zArr[4] = diff(this.mHeight, motionConstrainedPoint.mHeight) | zArr[4];
    }
}
