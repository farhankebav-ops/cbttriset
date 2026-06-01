package androidx.constraintlayout.core.motion;

import a1.a;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import com.ironsource.C2300e4;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class MotionPaths implements Comparable<MotionPaths> {
    public static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    public static final int PERPENDICULAR = 1;
    public static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";
    static String[] sNames = {C2300e4.h.L, "x", "y", "width", "height", "pathRotate"};
    int mAnimateCircleAngleTo;
    String mAnimateRelativeTo;
    HashMap<String, CustomVariable> mCustomAttributes;
    int mDrawPath;
    float mHeight;
    public String mId;
    Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mPathRotate;
    float mPosition;
    float mProgress;
    float mRelativeAngle;
    Motion mRelativeToController;
    double[] mTempDelta;
    double[] mTempValue;
    float mTime;
    float mWidth;
    float mX;
    float mY;

    public MotionPaths() {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = -1;
        this.mAnimateRelativeTo = null;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.mCustomAttributes = new HashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    private boolean diff(float f4, float f8) {
        return (Float.isNaN(f4) || Float.isNaN(f8)) ? Float.isNaN(f4) != Float.isNaN(f8) : Math.abs(f4 - f8) > 1.0E-6f;
    }

    private static float xRotate(float f4, float f8, float f9, float f10, float f11, float f12) {
        return (((f11 - f9) * f8) - ((f12 - f10) * f4)) + f9;
    }

    private static float yRotate(float f4, float f8, float f9, float f10, float f11, float f12) {
        return ((f12 - f10) * f8) + ((f11 - f9) * f4) + f10;
    }

    public void applyParameters(MotionWidget motionWidget) {
        ConstraintWidget constraintWidget;
        this.mKeyFrameEasing = Easing.getInterpolator(motionWidget.mMotion.mTransitionEasing);
        MotionWidget.Motion motion = motionWidget.mMotion;
        this.mPathMotionArc = motion.mPathMotionArc;
        this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mAnimateCircleAngleTo = motion.mAnimateCircleAngleTo;
        this.mProgress = motionWidget.mPropertySet.mProgress;
        WidgetFrame widgetFrame = motionWidget.mWidgetFrame;
        if (widgetFrame != null && (constraintWidget = widgetFrame.widget) != null) {
            this.mRelativeAngle = constraintWidget.mCircleConstraintAngle;
        }
        for (String str : motionWidget.getCustomAttributeNames()) {
            CustomVariable customAttribute = motionWidget.getCustomAttribute(str);
            if (customAttribute != null && customAttribute.isContinuous()) {
                this.mCustomAttributes.put(str, customAttribute);
            }
        }
    }

    public void configureRelativeTo(Motion motion) {
        motion.getPos(this.mProgress);
    }

    public void different(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z2) {
        boolean zDiff = diff(this.mX, motionPaths.mX);
        boolean zDiff2 = diff(this.mY, motionPaths.mY);
        zArr[0] = zArr[0] | diff(this.mPosition, motionPaths.mPosition);
        zArr[1] = zArr[1] | (zDiff || zDiff2 || z2);
        zArr[2] = zArr[2] | (zDiff || zDiff2 || z2);
        zArr[3] = zArr[3] | diff(this.mWidth, motionPaths.mWidth);
        zArr[4] = diff(this.mHeight, motionPaths.mHeight) | zArr[4];
    }

    public void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.mPosition, this.mX, this.mY, this.mWidth, this.mHeight, this.mPathRotate};
        int i2 = 0;
        for (int i8 : iArr) {
            if (i8 < 6) {
                dArr[i2] = fArr[r1];
                i2++;
            }
        }
    }

    public void getBounds(int[] iArr, double[] dArr, float[] fArr, int i2) {
        float f4 = this.mWidth;
        float f8 = this.mHeight;
        for (int i8 = 0; i8 < iArr.length; i8++) {
            float f9 = (float) dArr[i8];
            int i9 = iArr[i8];
            if (i9 == 3) {
                f4 = f9;
            } else if (i9 == 4) {
                f8 = f9;
            }
        }
        fArr[i2] = f4;
        fArr[i2 + 1] = f8;
    }

    public void getCenter(double d8, int[] iArr, double[] dArr, float[] fArr, int i2) {
        float fSin = this.mX;
        float fCos = this.mY;
        float f4 = this.mWidth;
        float f8 = this.mHeight;
        for (int i8 = 0; i8 < iArr.length; i8++) {
            float f9 = (float) dArr[i8];
            int i9 = iArr[i8];
            if (i9 == 1) {
                fSin = f9;
            } else if (i9 == 2) {
                fCos = f9;
            } else if (i9 == 3) {
                f4 = f9;
            } else if (i9 == 4) {
                f8 = f9;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d8, fArr2, new float[2]);
            float f10 = fArr2[0];
            float f11 = fArr2[1];
            double d9 = f10;
            double d10 = fSin;
            double d11 = fCos;
            fSin = (float) (((Math.sin(d11) * d10) + d9) - ((double) (f4 / 2.0f)));
            fCos = (float) ((((double) f11) - (Math.cos(d11) * d10)) - ((double) (f8 / 2.0f)));
        }
        fArr[i2] = (f4 / 2.0f) + fSin + 0.0f;
        fArr[i2 + 1] = (f8 / 2.0f) + fCos + 0.0f;
    }

    public void getCenterVelocity(double d8, int[] iArr, double[] dArr, float[] fArr, int i2) {
        float fSin = this.mX;
        float fCos = this.mY;
        float f4 = this.mWidth;
        float f8 = this.mHeight;
        for (int i8 = 0; i8 < iArr.length; i8++) {
            float f9 = (float) dArr[i8];
            int i9 = iArr[i8];
            if (i9 == 1) {
                fSin = f9;
            } else if (i9 == 2) {
                fCos = f9;
            } else if (i9 == 3) {
                f4 = f9;
            } else if (i9 == 4) {
                f8 = f9;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d8, fArr2, new float[2]);
            float f10 = fArr2[0];
            float f11 = fArr2[1];
            double d9 = f10;
            double d10 = fSin;
            double d11 = fCos;
            fSin = (float) (((Math.sin(d11) * d10) + d9) - ((double) (f4 / 2.0f)));
            fCos = (float) ((((double) f11) - (Math.cos(d11) * d10)) - ((double) (f8 / 2.0f)));
        }
        fArr[i2] = (f4 / 2.0f) + fSin + 0.0f;
        fArr[i2 + 1] = (f8 / 2.0f) + fCos + 0.0f;
    }

    public int getCustomData(String str, double[] dArr, int i2) {
        CustomVariable customVariable = this.mCustomAttributes.get(str);
        int i8 = 0;
        if (customVariable == null) {
            return 0;
        }
        if (customVariable.numberOfInterpolatedValues() == 1) {
            dArr[i2] = customVariable.getValueToInterpolate();
            return 1;
        }
        int iNumberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
        customVariable.getValuesToInterpolate(new float[iNumberOfInterpolatedValues]);
        while (i8 < iNumberOfInterpolatedValues) {
            dArr[i2] = r2[i8];
            i8++;
            i2++;
        }
        return iNumberOfInterpolatedValues;
    }

    public int getCustomDataCount(String str) {
        CustomVariable customVariable = this.mCustomAttributes.get(str);
        if (customVariable == null) {
            return 0;
        }
        return customVariable.numberOfInterpolatedValues();
    }

    public void getRect(int[] iArr, double[] dArr, float[] fArr, int i2) {
        float f4 = this.mX;
        float fCos = this.mY;
        float f8 = this.mWidth;
        float f9 = this.mHeight;
        for (int i8 = 0; i8 < iArr.length; i8++) {
            float f10 = (float) dArr[i8];
            int i9 = iArr[i8];
            if (i9 == 1) {
                f4 = f10;
            } else if (i9 == 2) {
                fCos = f10;
            } else if (i9 == 3) {
                f8 = f10;
            } else if (i9 == 4) {
                f9 = f10;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float centerX = motion.getCenterX();
            float centerY = this.mRelativeToController.getCenterY();
            double d8 = f4;
            double d9 = fCos;
            float fSin = (float) (((Math.sin(d9) * d8) + ((double) centerX)) - ((double) (f8 / 2.0f)));
            fCos = (float) ((((double) centerY) - (Math.cos(d9) * d8)) - ((double) (f9 / 2.0f)));
            f4 = fSin;
        }
        float f11 = f8 + f4;
        float f12 = f9 + fCos;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i2] = f4 + 0.0f;
        fArr[i2 + 1] = fCos + 0.0f;
        fArr[i2 + 2] = f11 + 0.0f;
        fArr[i2 + 3] = fCos + 0.0f;
        fArr[i2 + 4] = f11 + 0.0f;
        fArr[i2 + 5] = f12 + 0.0f;
        fArr[i2 + 6] = f4 + 0.0f;
        fArr[i2 + 7] = f12 + 0.0f;
    }

    public boolean hasCustomData(String str) {
        return this.mCustomAttributes.containsKey(str);
    }

    public void initCartesian(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f4 = motionKeyPosition.mFramePosition / 100.0f;
        this.mTime = f4;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f8 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f4 : motionKeyPosition.mPercentWidth;
        float f9 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f4 : motionKeyPosition.mPercentHeight;
        float f10 = motionPaths2.mWidth;
        float f11 = motionPaths.mWidth;
        float f12 = f10 - f11;
        float f13 = motionPaths2.mHeight;
        float f14 = motionPaths.mHeight;
        float f15 = f13 - f14;
        this.mPosition = this.mTime;
        float f16 = motionPaths.mX;
        float f17 = motionPaths.mY;
        float f18 = f4;
        float f19 = ((f10 / 2.0f) + motionPaths2.mX) - ((f11 / 2.0f) + f16);
        float f20 = ((f13 / 2.0f) + motionPaths2.mY) - ((f14 / 2.0f) + f17);
        float f21 = (f12 * f8) / 2.0f;
        this.mX = (int) (((f19 * f18) + f16) - f21);
        float f22 = (f15 * f9) / 2.0f;
        this.mY = (int) (((f20 * f18) + f17) - f22);
        this.mWidth = (int) (f11 + r9);
        this.mHeight = (int) (f14 + r12);
        float f23 = Float.isNaN(motionKeyPosition.mPercentX) ? f18 : motionKeyPosition.mPercentX;
        float f24 = Float.isNaN(motionKeyPosition.mAltPercentY) ? 0.0f : motionKeyPosition.mAltPercentY;
        if (!Float.isNaN(motionKeyPosition.mPercentY)) {
            f18 = motionKeyPosition.mPercentY;
        }
        float f25 = Float.isNaN(motionKeyPosition.mAltPercentX) ? 0.0f : motionKeyPosition.mAltPercentX;
        this.mMode = 0;
        this.mX = (int) (((f25 * f20) + ((f23 * f19) + motionPaths.mX)) - f21);
        this.mY = (int) (((f20 * f18) + ((f19 * f24) + motionPaths.mY)) - f22);
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void initPath(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f4 = motionKeyPosition.mFramePosition / 100.0f;
        this.mTime = f4;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f8 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f4 : motionKeyPosition.mPercentWidth;
        float f9 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f4 : motionKeyPosition.mPercentHeight;
        float f10 = motionPaths2.mWidth - motionPaths.mWidth;
        float f11 = motionPaths2.mHeight - motionPaths.mHeight;
        this.mPosition = this.mTime;
        if (!Float.isNaN(motionKeyPosition.mPercentX)) {
            f4 = motionKeyPosition.mPercentX;
        }
        float f12 = motionPaths.mX;
        float f13 = motionPaths.mWidth;
        float f14 = motionPaths.mY;
        float f15 = motionPaths.mHeight;
        float f16 = f4;
        float f17 = ((motionPaths2.mWidth / 2.0f) + motionPaths2.mX) - ((f13 / 2.0f) + f12);
        float f18 = ((motionPaths2.mHeight / 2.0f) + motionPaths2.mY) - ((f15 / 2.0f) + f14);
        float f19 = f17 * f16;
        float f20 = (f10 * f8) / 2.0f;
        this.mX = (int) ((f12 + f19) - f20);
        float f21 = f18 * f16;
        float f22 = (f11 * f9) / 2.0f;
        this.mY = (int) ((f14 + f21) - f22);
        this.mWidth = (int) (f13 + r7);
        this.mHeight = (int) (f15 + r8);
        float f23 = Float.isNaN(motionKeyPosition.mPercentY) ? 0.0f : motionKeyPosition.mPercentY;
        this.mMode = 1;
        float f24 = (int) ((motionPaths.mX + f19) - f20);
        float f25 = (int) ((motionPaths.mY + f21) - f22);
        this.mX = f24 + ((-f18) * f23);
        this.mY = f25 + (f17 * f23);
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void initPolar(int i2, int i8, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float fMin;
        float fA;
        float f4 = motionKeyPosition.mFramePosition / 100.0f;
        this.mTime = f4;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        this.mMode = motionKeyPosition.mPositionType;
        float f8 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f4 : motionKeyPosition.mPercentWidth;
        float f9 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f4 : motionKeyPosition.mPercentHeight;
        float f10 = motionPaths2.mWidth;
        float f11 = motionPaths.mWidth;
        float f12 = motionPaths2.mHeight;
        float f13 = motionPaths.mHeight;
        this.mPosition = this.mTime;
        this.mWidth = (int) (((f10 - f11) * f8) + f11);
        this.mHeight = (int) (((f12 - f13) * f9) + f13);
        int i9 = motionKeyPosition.mPositionType;
        if (i9 == 1) {
            float f14 = Float.isNaN(motionKeyPosition.mPercentX) ? f4 : motionKeyPosition.mPercentX;
            float f15 = motionPaths2.mX;
            float f16 = motionPaths.mX;
            this.mX = a.a(f15, f16, f14, f16);
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f4 = motionKeyPosition.mPercentY;
            }
            float f17 = motionPaths2.mY;
            float f18 = motionPaths.mY;
            this.mY = a.a(f17, f18, f4, f18);
        } else if (i9 != 2) {
            float f19 = Float.isNaN(motionKeyPosition.mPercentX) ? f4 : motionKeyPosition.mPercentX;
            float f20 = motionPaths2.mX;
            float f21 = motionPaths.mX;
            this.mX = a.a(f20, f21, f19, f21);
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f4 = motionKeyPosition.mPercentY;
            }
            float f22 = motionPaths2.mY;
            float f23 = motionPaths.mY;
            this.mY = a.a(f22, f23, f4, f23);
        } else {
            if (Float.isNaN(motionKeyPosition.mPercentX)) {
                float f24 = motionPaths2.mX;
                float f25 = motionPaths.mX;
                fMin = a.a(f24, f25, f4, f25);
            } else {
                fMin = Math.min(f9, f8) * motionKeyPosition.mPercentX;
            }
            this.mX = fMin;
            if (Float.isNaN(motionKeyPosition.mPercentY)) {
                float f26 = motionPaths2.mY;
                float f27 = motionPaths.mY;
                fA = a.a(f26, f27, f4, f27);
            } else {
                fA = motionKeyPosition.mPercentY;
            }
            this.mY = fA;
        }
        this.mAnimateRelativeTo = motionPaths.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void initScreen(int i2, int i8, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f4 = motionKeyPosition.mFramePosition / 100.0f;
        this.mTime = f4;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f8 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f4 : motionKeyPosition.mPercentWidth;
        float f9 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f4 : motionKeyPosition.mPercentHeight;
        float f10 = motionPaths2.mWidth;
        float f11 = f10 - motionPaths.mWidth;
        float f12 = motionPaths2.mHeight;
        float f13 = f12 - motionPaths.mHeight;
        this.mPosition = this.mTime;
        float f14 = motionPaths.mX;
        float f15 = motionPaths.mY;
        float f16 = (f10 / 2.0f) + motionPaths2.mX;
        float f17 = (f12 / 2.0f) + motionPaths2.mY;
        float f18 = f11 * f8;
        this.mX = (int) ((((f16 - ((r8 / 2.0f) + f14)) * f4) + f14) - (f18 / 2.0f));
        float f19 = f13 * f9;
        this.mY = (int) ((((f17 - ((r11 / 2.0f) + f15)) * f4) + f15) - (f19 / 2.0f));
        this.mWidth = (int) (r8 + f18);
        this.mHeight = (int) (r11 + f19);
        this.mMode = 2;
        if (!Float.isNaN(motionKeyPosition.mPercentX)) {
            this.mX = (int) (motionKeyPosition.mPercentX * (i2 - ((int) this.mWidth)));
        }
        if (!Float.isNaN(motionKeyPosition.mPercentY)) {
            this.mY = (int) (motionKeyPosition.mPercentY * (i8 - ((int) this.mHeight)));
        }
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void setBounds(float f4, float f8, float f9, float f10) {
        this.mX = f4;
        this.mY = f8;
        this.mWidth = f9;
        this.mHeight = f10;
    }

    public void setDpDt(float f4, float f8, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f13 = (float) dArr[i2];
            int i8 = iArr[i2];
            if (i8 == 1) {
                f9 = f13;
            } else if (i8 == 2) {
                f11 = f13;
            } else if (i8 == 3) {
                f10 = f13;
            } else if (i8 == 4) {
                f12 = f13;
            }
        }
        float f14 = f9 - ((0.0f * f10) / 2.0f);
        float f15 = f11 - ((0.0f * f12) / 2.0f);
        fArr[0] = (((f10 * 1.0f) + f14) * f4) + ((1.0f - f4) * f14) + 0.0f;
        fArr[1] = (((f12 * 1.0f) + f15) * f8) + ((1.0f - f8) * f15) + 0.0f;
    }

    public void setView(float f4, MotionWidget motionWidget, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f8;
        float fSin = this.mX;
        float fCos = this.mY;
        float f9 = this.mWidth;
        float f10 = this.mHeight;
        if (iArr.length != 0 && this.mTempValue.length <= iArr[iArr.length - 1]) {
            int i2 = iArr[iArr.length - 1] + 1;
            this.mTempValue = new double[i2];
            this.mTempDelta = new double[i2];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        for (int i8 = 0; i8 < iArr.length; i8++) {
            double[] dArr4 = this.mTempValue;
            int i9 = iArr[i8];
            dArr4[i9] = dArr[i8];
            this.mTempDelta[i9] = dArr2[i8];
        }
        float f11 = Float.NaN;
        int i10 = 0;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        while (true) {
            double[] dArr5 = this.mTempValue;
            if (i10 >= dArr5.length) {
                break;
            }
            if (Double.isNaN(dArr5[i10]) && (dArr3 == null || dArr3[i10] == 0.0d)) {
                f8 = f11;
            } else {
                double d8 = dArr3 != null ? dArr3[i10] : 0.0d;
                if (!Double.isNaN(this.mTempValue[i10])) {
                    d8 = this.mTempValue[i10] + d8;
                }
                f8 = f11;
                float f16 = (float) d8;
                float f17 = (float) this.mTempDelta[i10];
                if (i10 == 1) {
                    f11 = f8;
                    f12 = f17;
                    fSin = f16;
                } else if (i10 == 2) {
                    f11 = f8;
                    f13 = f17;
                    fCos = f16;
                } else if (i10 == 3) {
                    f11 = f8;
                    f14 = f17;
                    f9 = f16;
                } else if (i10 == 4) {
                    f11 = f8;
                    f15 = f17;
                    f10 = f16;
                } else if (i10 == 5) {
                    f11 = f16;
                }
                i10++;
            }
            f11 = f8;
            i10++;
        }
        float f18 = f11;
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motion.getCenter(f4, fArr, fArr2);
            float f19 = fArr[0];
            float f20 = fArr[1];
            float f21 = fArr2[0];
            float f22 = fArr2[1];
            double d9 = f19;
            double d10 = fSin;
            double d11 = fCos;
            fSin = (float) (((Math.sin(d11) * d10) + d9) - ((double) (f9 / 2.0f)));
            fCos = (float) ((((double) f20) - (Math.cos(d11) * d10)) - ((double) (f10 / 2.0f)));
            double d12 = f21;
            double d13 = f12;
            double dSin = (Math.sin(d11) * d13) + d12;
            double dCos = Math.cos(d11) * d10;
            double d14 = f13;
            float f23 = (float) ((dCos * d14) + dSin);
            float fSin2 = (float) ((Math.sin(d11) * d10 * d14) + (((double) f22) - (Math.cos(d11) * d13)));
            if (dArr2.length >= 2) {
                dArr2[0] = f23;
                dArr2[1] = fSin2;
            }
            if (!Float.isNaN(f18)) {
                motionWidget.setRotationZ((float) (Math.toDegrees(Math.atan2(fSin2, f23)) + ((double) f18)));
            }
        } else if (!Float.isNaN(f18)) {
            motionWidget.setRotationZ(((float) (Math.toDegrees(Math.atan2((f15 / 2.0f) + f13, (f14 / 2.0f) + f12)) + ((double) f18))) + 0.0f);
        }
        float f24 = fSin + 0.5f;
        float f25 = fCos + 0.5f;
        motionWidget.layout((int) f24, (int) f25, (int) (f24 + f9), (int) (f25 + f10));
    }

    public void setupRelative(Motion motion, MotionPaths motionPaths) {
        double d8 = (((this.mWidth / 2.0f) + this.mX) - motionPaths.mX) - (motionPaths.mWidth / 2.0f);
        double d9 = (((this.mHeight / 2.0f) + this.mY) - motionPaths.mY) - (motionPaths.mHeight / 2.0f);
        this.mRelativeToController = motion;
        this.mX = (float) Math.hypot(d9, d8);
        if (Float.isNaN(this.mRelativeAngle)) {
            this.mY = (float) (Math.atan2(d9, d8) + 1.5707963267948966d);
        } else {
            this.mY = (float) Math.toRadians(this.mRelativeAngle);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.mPosition, motionPaths.mPosition);
    }

    public MotionPaths(int i2, int i8, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = -1;
        this.mAnimateRelativeTo = null;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.mCustomAttributes = new HashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        if (motionPaths.mAnimateRelativeTo != null) {
            initPolar(i2, i8, motionKeyPosition, motionPaths, motionPaths2);
            return;
        }
        int i9 = motionKeyPosition.mPositionType;
        if (i9 == 1) {
            initPath(motionKeyPosition, motionPaths, motionPaths2);
        } else if (i9 != 2) {
            initCartesian(motionKeyPosition, motionPaths, motionPaths2);
        } else {
            initScreen(i2, i8, motionKeyPosition, motionPaths, motionPaths2);
        }
    }

    public void getCenter(double d8, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f4;
        float fSin = this.mX;
        float fCos = this.mY;
        float f8 = this.mWidth;
        float f9 = this.mHeight;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f14 = (float) dArr[i2];
            float f15 = (float) dArr2[i2];
            int i8 = iArr[i2];
            if (i8 == 1) {
                fSin = f14;
                f10 = f15;
            } else if (i8 == 2) {
                fCos = f14;
                f12 = f15;
            } else if (i8 == 3) {
                f8 = f14;
                f11 = f15;
            } else if (i8 == 4) {
                f9 = f14;
                f13 = f15;
            }
        }
        float f16 = (f11 / 2.0f) + f10;
        float fSin2 = (f13 / 2.0f) + f12;
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motion.getCenter(d8, fArr3, fArr4);
            float f17 = fArr3[0];
            float f18 = fArr3[1];
            float f19 = fArr4[0];
            float f20 = fArr4[1];
            f4 = 2.0f;
            double d9 = fSin;
            double d10 = fCos;
            fSin = (float) (((Math.sin(d10) * d9) + ((double) f17)) - ((double) (f8 / 2.0f)));
            fCos = (float) ((((double) f18) - (Math.cos(d10) * d9)) - ((double) (f9 / 2.0f)));
            double d11 = f10;
            double dSin = (Math.sin(d10) * d11) + ((double) f19);
            double d12 = f12;
            float fCos2 = (float) ((Math.cos(d10) * d12) + dSin);
            fSin2 = (float) ((Math.sin(d10) * d12) + (((double) f20) - (Math.cos(d10) * d11)));
            f16 = fCos2;
        } else {
            f4 = 2.0f;
        }
        fArr[0] = (f8 / f4) + fSin + 0.0f;
        fArr[1] = (f9 / f4) + fCos + 0.0f;
        fArr2[0] = f16;
        fArr2[1] = fSin2;
    }
}
