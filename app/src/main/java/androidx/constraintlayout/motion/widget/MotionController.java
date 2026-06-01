package androidx.constraintlayout.motion.widget;

import a1.a;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.motion.utils.CustomSupport;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class MotionController {
    static final int BOUNCE = 4;
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    private static final int INTERPOLATOR_UNDEFINED = -3;
    static final int LINEAR = 3;
    static final int OVERSHOOT = 5;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    public static final int ROTATION_LEFT = 2;
    public static final int ROTATION_RIGHT = 1;
    private static final int SPLINE_STRING = -1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpolatorCount;
    private String[] mAttributeNames;
    String[] mAttributeTable;
    private HashMap<String, ViewSpline> mAttributesMap;
    String mConstraintTag;
    float mCurrentCenterX;
    float mCurrentCenterY;
    private HashMap<String, ViewOscillator> mCycleMap;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private KeyTrigger[] mKeyTriggers;
    private boolean mNoMovement;
    private int mPathMotionArc;
    private Interpolator mQuantizeMotionInterpolator;
    private float mQuantizeMotionPhase;
    private int mQuantizeMotionSteps;
    private CurveFit[] mSpline;
    private HashMap<String, ViewTimeCycle> mTimeCycleAttributesMap;
    private int mTransformPivotTarget;
    private View mTransformPivotView;
    View mView;
    Rect mTempRect = new Rect();
    boolean mForceMeasure = false;
    private int mCurveFitType = -1;
    private MotionPaths mStartMotionPath = new MotionPaths();
    private MotionPaths mEndMotionPath = new MotionPaths();
    private MotionConstrainedPoint mStartPoint = new MotionConstrainedPoint();
    private MotionConstrainedPoint mEndPoint = new MotionConstrainedPoint();
    float mMotionStagger = Float.NaN;
    float mStaggerOffset = 0.0f;
    float mStaggerScale = 1.0f;
    private int mMaxDimension = 4;
    private float[] mValuesBuff = new float[4];
    private ArrayList<MotionPaths> mMotionPaths = new ArrayList<>();
    private float[] mVelocity = new float[1];
    private ArrayList<Key> mKeyList = new ArrayList<>();

    public MotionController(View view) {
        int i2 = Key.UNSET;
        this.mPathMotionArc = i2;
        this.mTransformPivotTarget = i2;
        this.mTransformPivotView = null;
        this.mQuantizeMotionSteps = i2;
        this.mQuantizeMotionPhase = Float.NaN;
        this.mQuantizeMotionInterpolator = null;
        this.mNoMovement = false;
        setView(view);
    }

    private float getAdjustedPosition(float f4, float[] fArr) {
        float f8 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f9 = this.mStaggerScale;
            if (f9 != 1.0d) {
                float f10 = this.mStaggerOffset;
                if (f4 < f10) {
                    f4 = 0.0f;
                }
                if (f4 > f10 && f4 < 1.0d) {
                    f4 = Math.min((f4 - f10) * f9, 1.0f);
                }
            }
        }
        Easing easing = this.mStartMotionPath.mKeyFrameEasing;
        ArrayList<MotionPaths> arrayList = this.mMotionPaths;
        int size = arrayList.size();
        float f11 = Float.NaN;
        int i2 = 0;
        while (i2 < size) {
            MotionPaths motionPaths = arrayList.get(i2);
            i2++;
            MotionPaths motionPaths2 = motionPaths;
            Easing easing2 = motionPaths2.mKeyFrameEasing;
            if (easing2 != null) {
                float f12 = motionPaths2.mTime;
                if (f12 < f4) {
                    easing = easing2;
                    f8 = f12;
                } else if (Float.isNaN(f11)) {
                    f11 = motionPaths2.mTime;
                }
            }
        }
        if (easing != null) {
            float f13 = (Float.isNaN(f11) ? 1.0f : f11) - f8;
            double d8 = (f4 - f8) / f13;
            f4 = (((float) easing.get(d8)) * f13) + f8;
            if (fArr != null) {
                fArr[0] = (float) easing.getDiff(d8);
            }
        }
        return f4;
    }

    private static Interpolator getInterpolator(Context context, int i2, String str, int i8) {
        if (i2 == -2) {
            return AnimationUtils.loadInterpolator(context, i8);
        }
        if (i2 == -1) {
            final Easing interpolator = Easing.getInterpolator(str);
            return new Interpolator() { // from class: androidx.constraintlayout.motion.widget.MotionController.1
                @Override // android.animation.TimeInterpolator
                public float getInterpolation(float f4) {
                    return (float) interpolator.get(f4);
                }
            };
        }
        if (i2 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i2 == 1) {
            return new AccelerateInterpolator();
        }
        if (i2 == 2) {
            return new DecelerateInterpolator();
        }
        if (i2 == 4) {
            return new BounceInterpolator();
        }
        if (i2 != 5) {
            return null;
        }
        return new OvershootInterpolator();
    }

    private float getPreCycleDistance() {
        float[] fArr = new float[2];
        float f4 = 1.0f / 99;
        double d8 = 0.0d;
        double d9 = 0.0d;
        int i2 = 0;
        float fHypot = 0.0f;
        while (i2 < 100) {
            float f8 = i2 * f4;
            double d10 = f8;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            float f9 = Float.NaN;
            int i8 = 0;
            float f10 = 0.0f;
            while (i8 < size) {
                MotionPaths motionPaths = arrayList.get(i8);
                i8++;
                MotionPaths motionPaths2 = motionPaths;
                float f11 = f4;
                Easing easing2 = motionPaths2.mKeyFrameEasing;
                if (easing2 != null) {
                    float f12 = motionPaths2.mTime;
                    if (f12 < f8) {
                        f10 = f12;
                        easing = easing2;
                    } else if (Float.isNaN(f9)) {
                        f9 = motionPaths2.mTime;
                    }
                }
                f4 = f11;
            }
            float f13 = f4;
            if (easing != null) {
                if (Float.isNaN(f9)) {
                    f9 = 1.0f;
                }
                d10 = (((float) easing.get((f8 - f10) / r17)) * (f9 - f10)) + f10;
            }
            double d11 = d10;
            this.mSpline[0].getPos(d11, this.mInterpolateData);
            int i9 = i2;
            this.mStartMotionPath.getCenter(d11, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
            if (i9 > 0) {
                fHypot += (float) Math.hypot(d9 - ((double) fArr[1]), d8 - ((double) fArr[0]));
            }
            d8 = fArr[0];
            d9 = fArr[1];
            i2 = i9 + 1;
            f4 = f13;
        }
        return fHypot;
    }

    private void insertKey(MotionPaths motionPaths) {
        if (Collections.binarySearch(this.mMotionPaths, motionPaths) == 0) {
            Log.e(TAG, " KeyPath position \"" + motionPaths.mPosition + "\" outside of range");
        }
        this.mMotionPaths.add((-r0) - 1, motionPaths);
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds((int) this.mView.getX(), (int) this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    public void addKey(Key key) {
        this.mKeyList.add(key);
    }

    public void addKeys(ArrayList<Key> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    public void buildBounds(float[] fArr, int i2) {
        float f4 = 1.0f;
        float f8 = 1.0f / (i2 - 1);
        HashMap<String, ViewSpline> map = this.mAttributesMap;
        if (map != null) {
            map.get("translationX");
        }
        HashMap<String, ViewSpline> map2 = this.mAttributesMap;
        if (map2 != null) {
            map2.get("translationY");
        }
        HashMap<String, ViewOscillator> map3 = this.mCycleMap;
        if (map3 != null) {
            map3.get("translationX");
        }
        HashMap<String, ViewOscillator> map4 = this.mCycleMap;
        if (map4 != null) {
            map4.get("translationY");
        }
        int i8 = 0;
        while (i8 < i2) {
            float fMin = i8 * f8;
            float f9 = this.mStaggerScale;
            float f10 = 0.0f;
            if (f9 != f4) {
                float f11 = this.mStaggerOffset;
                if (fMin < f11) {
                    fMin = 0.0f;
                }
                if (fMin > f11 && fMin < 1.0d) {
                    fMin = Math.min((fMin - f11) * f9, f4);
                }
            }
            double d8 = fMin;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            float f12 = Float.NaN;
            int i9 = 0;
            while (i9 < size) {
                MotionPaths motionPaths = arrayList.get(i9);
                i9++;
                MotionPaths motionPaths2 = motionPaths;
                Easing easing2 = motionPaths2.mKeyFrameEasing;
                if (easing2 != null) {
                    float f13 = motionPaths2.mTime;
                    if (f13 < fMin) {
                        easing = easing2;
                        f10 = f13;
                    } else if (Float.isNaN(f12)) {
                        f12 = motionPaths2.mTime;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f12)) {
                    f12 = 1.0f;
                }
                d8 = (((float) easing.get((fMin - f10) / r13)) * (f12 - f10)) + f10;
            }
            this.mSpline[0].getPos(d8, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d8, dArr);
                }
            }
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i8 * 2);
            i8++;
            f4 = 1.0f;
        }
    }

    public int buildKeyBounds(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            int i2 = 0;
            int i8 = 0;
            while (i8 < size) {
                MotionPaths motionPaths = arrayList.get(i8);
                i8++;
                iArr[i2] = motionPaths.mMode;
                i2++;
            }
        }
        int i9 = 0;
        for (double d8 : timePoints) {
            this.mSpline[0].getPos(d8, this.mInterpolateData);
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i9);
            i9 += 2;
        }
        return i9 / 2;
    }

    public int buildKeyFrames(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            int i2 = 0;
            int i8 = 0;
            while (i8 < size) {
                MotionPaths motionPaths = arrayList.get(i8);
                i8++;
                iArr[i2] = motionPaths.mMode;
                i2++;
            }
        }
        int i9 = 0;
        for (int i10 = 0; i10 < timePoints.length; i10++) {
            this.mSpline[0].getPos(timePoints[i10], this.mInterpolateData);
            this.mStartMotionPath.getCenter(timePoints[i10], this.mInterpolateVariables, this.mInterpolateData, fArr, i9);
            i9 += 2;
        }
        return i9 / 2;
    }

    public void buildPath(float[] fArr, int i2) {
        int i8 = i2;
        float f4 = 1.0f;
        float f8 = 1.0f / (i8 - 1);
        HashMap<String, ViewSpline> map = this.mAttributesMap;
        ViewSpline viewSpline = map == null ? null : map.get("translationX");
        HashMap<String, ViewSpline> map2 = this.mAttributesMap;
        ViewSpline viewSpline2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, ViewOscillator> map3 = this.mCycleMap;
        ViewOscillator viewOscillator = map3 == null ? null : map3.get("translationX");
        HashMap<String, ViewOscillator> map4 = this.mCycleMap;
        ViewOscillator viewOscillator2 = map4 != null ? map4.get("translationY") : null;
        int i9 = 0;
        while (i9 < i8) {
            float fMin = i9 * f8;
            float f9 = this.mStaggerScale;
            float f10 = 0.0f;
            if (f9 != f4) {
                float f11 = this.mStaggerOffset;
                if (fMin < f11) {
                    fMin = 0.0f;
                }
                if (fMin > f11 && fMin < 1.0d) {
                    fMin = Math.min((fMin - f11) * f9, f4);
                }
            }
            double d8 = fMin;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            float f12 = Float.NaN;
            int i10 = 0;
            while (i10 < size) {
                MotionPaths motionPaths = arrayList.get(i10);
                i10++;
                MotionPaths motionPaths2 = motionPaths;
                float f13 = f8;
                Easing easing2 = motionPaths2.mKeyFrameEasing;
                if (easing2 != null) {
                    float f14 = motionPaths2.mTime;
                    if (f14 < fMin) {
                        f10 = f14;
                        easing = easing2;
                    } else if (Float.isNaN(f12)) {
                        f12 = motionPaths2.mTime;
                    }
                }
                f8 = f13;
            }
            float f15 = f8;
            if (easing != null) {
                if (Float.isNaN(f12)) {
                    f12 = 1.0f;
                }
                d8 = (((float) easing.get((fMin - f10) / r17)) * (f12 - f10)) + f10;
            }
            this.mSpline[0].getPos(d8, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d8, dArr);
                }
            }
            int i11 = i9 * 2;
            this.mStartMotionPath.getCenter(d8, this.mInterpolateVariables, this.mInterpolateData, fArr, i11);
            if (viewOscillator != null) {
                fArr[i11] = viewOscillator.get(fMin) + fArr[i11];
            } else if (viewSpline != null) {
                fArr[i11] = viewSpline.get(fMin) + fArr[i11];
            }
            if (viewOscillator2 != null) {
                int i12 = i11 + 1;
                fArr[i12] = viewOscillator2.get(fMin) + fArr[i12];
            } else if (viewSpline2 != null) {
                int i13 = i11 + 1;
                fArr[i13] = viewSpline2.get(fMin) + fArr[i13];
            }
            i9++;
            i8 = i2;
            f8 = f15;
            f4 = 1.0f;
        }
    }

    public void buildRect(float f4, float[] fArr, int i2) {
        this.mSpline[0].getPos(getAdjustedPosition(f4, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i2);
    }

    public void buildRectangles(float[] fArr, int i2) {
        float f4 = 1.0f / (i2 - 1);
        for (int i8 = 0; i8 < i2; i8++) {
            this.mSpline[0].getPos(getAdjustedPosition(i8 * f4, null), this.mInterpolateData);
            this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i8 * 8);
        }
    }

    public void endTrigger(boolean z2) {
        if (!"button".equals(Debug.getName(this.mView)) || this.mKeyTriggers == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            KeyTrigger[] keyTriggerArr = this.mKeyTriggers;
            if (i2 >= keyTriggerArr.length) {
                return;
            }
            keyTriggerArr[i2].conditionallyFire(z2 ? -100.0f : 100.0f, this.mView);
            i2++;
        }
    }

    public int getAnimateRelativeTo() {
        return this.mStartMotionPath.mAnimateRelativeTo;
    }

    public int getAttributeValues(String str, float[] fArr, int i2) {
        ViewSpline viewSpline = this.mAttributesMap.get(str);
        if (viewSpline == null) {
            return -1;
        }
        for (int i8 = 0; i8 < fArr.length; i8++) {
            fArr[i8] = viewSpline.get(i8 / (fArr.length - 1));
        }
        return fArr.length;
    }

    public void getCenter(double d8, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.mSpline[0].getPos(d8, dArr);
        this.mSpline[0].getSlope(d8, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.mStartMotionPath.getCenter(d8, this.mInterpolateVariables, dArr, fArr, dArr2, fArr2);
    }

    public float getCenterX() {
        return this.mCurrentCenterX;
    }

    public float getCenterY() {
        return this.mCurrentCenterY;
    }

    public void getDpDt(float f4, float f8, float f9, float[] fArr) {
        double[] dArr;
        float adjustedPosition = getAdjustedPosition(f4, this.mVelocity);
        CurveFit[] curveFitArr = this.mSpline;
        int i2 = 0;
        if (curveFitArr == null) {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f10 = motionPaths.mX;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f11 = f10 - motionPaths2.mX;
            float f12 = motionPaths.mY - motionPaths2.mY;
            float f13 = motionPaths.mWidth - motionPaths2.mWidth;
            float f14 = (motionPaths.mHeight - motionPaths2.mHeight) + f12;
            fArr[0] = ((f13 + f11) * f8) + ((1.0f - f8) * f11);
            fArr[1] = (f14 * f9) + ((1.0f - f9) * f12);
            return;
        }
        double d8 = adjustedPosition;
        curveFitArr[0].getSlope(d8, this.mInterpolateVelocity);
        this.mSpline[0].getPos(d8, this.mInterpolateData);
        float f15 = this.mVelocity[0];
        while (true) {
            dArr = this.mInterpolateVelocity;
            if (i2 >= dArr.length) {
                break;
            }
            dArr[i2] = dArr[i2] * ((double) f15);
            i2++;
        }
        CurveFit curveFit = this.mArcSpline;
        if (curveFit == null) {
            this.mStartMotionPath.setDpDt(f8, f9, fArr, this.mInterpolateVariables, dArr, this.mInterpolateData);
            return;
        }
        double[] dArr2 = this.mInterpolateData;
        if (dArr2.length > 0) {
            curveFit.getPos(d8, dArr2);
            this.mArcSpline.getSlope(d8, this.mInterpolateVelocity);
            this.mStartMotionPath.setDpDt(f8, f9, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
        }
    }

    public int getDrawPath() {
        int iMax = this.mStartMotionPath.mDrawPath;
        ArrayList<MotionPaths> arrayList = this.mMotionPaths;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            MotionPaths motionPaths = arrayList.get(i2);
            i2++;
            iMax = Math.max(iMax, motionPaths.mDrawPath);
        }
        return Math.max(iMax, this.mEndMotionPath.mDrawPath);
    }

    public float getFinalHeight() {
        return this.mEndMotionPath.mHeight;
    }

    public float getFinalWidth() {
        return this.mEndMotionPath.mWidth;
    }

    public float getFinalX() {
        return this.mEndMotionPath.mX;
    }

    public float getFinalY() {
        return this.mEndMotionPath.mY;
    }

    public MotionPaths getKeyFrame(int i2) {
        return this.mMotionPaths.get(i2);
    }

    public int getKeyFrameInfo(int i2, int[] iArr) {
        float[] fArr = new float[2];
        ArrayList<Key> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i8 < size) {
            int i11 = i8 + 1;
            Key key = arrayList.get(i8);
            int i12 = key.mType;
            if (i12 == i2 || i2 != -1) {
                iArr[i10] = 0;
                iArr[i10 + 1] = i12;
                int i13 = key.mFramePosition;
                iArr[i10 + 2] = i13;
                double d8 = i13 / 100.0f;
                this.mSpline[0].getPos(d8, this.mInterpolateData);
                this.mStartMotionPath.getCenter(d8, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                iArr[i10 + 3] = Float.floatToIntBits(fArr[0]);
                int i14 = i10 + 4;
                iArr[i14] = Float.floatToIntBits(fArr[1]);
                if (key instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) key;
                    iArr[i10 + 5] = keyPosition.mPositionType;
                    iArr[i10 + 6] = Float.floatToIntBits(keyPosition.mPercentX);
                    i14 = i10 + 7;
                    iArr[i14] = Float.floatToIntBits(keyPosition.mPercentY);
                }
                int i15 = i14 + 1;
                iArr[i10] = i15 - i10;
                i9++;
                i10 = i15;
            }
            i8 = i11;
        }
        return i9;
    }

    public float getKeyFrameParameter(int i2, float f4, float f8) {
        MotionPaths motionPaths = this.mEndMotionPath;
        float f9 = motionPaths.mX;
        MotionPaths motionPaths2 = this.mStartMotionPath;
        float f10 = motionPaths2.mX;
        float f11 = f9 - f10;
        float f12 = motionPaths.mY;
        float f13 = motionPaths2.mY;
        float f14 = f12 - f13;
        float f15 = (motionPaths2.mWidth / 2.0f) + f10;
        float f16 = (motionPaths2.mHeight / 2.0f) + f13;
        float fHypot = (float) Math.hypot(f11, f14);
        if (fHypot < 1.0E-7d) {
            return Float.NaN;
        }
        float f17 = f4 - f15;
        float f18 = f8 - f16;
        if (((float) Math.hypot(f17, f18)) == 0.0f) {
            return 0.0f;
        }
        float f19 = (f18 * f14) + (f17 * f11);
        if (i2 == 0) {
            return f19 / fHypot;
        }
        if (i2 == 1) {
            return (float) Math.sqrt((fHypot * fHypot) - (f19 * f19));
        }
        if (i2 == 2) {
            return f17 / f11;
        }
        if (i2 == 3) {
            return f18 / f11;
        }
        if (i2 == 4) {
            return f17 / f14;
        }
        if (i2 != 5) {
            return 0.0f;
        }
        return f18 / f14;
    }

    public int getKeyFramePositions(int[] iArr, float[] fArr) {
        ArrayList<Key> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i2 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i8 < size) {
            int i10 = i8 + 1;
            Key key = arrayList.get(i8);
            int i11 = key.mFramePosition;
            iArr[i2] = (key.mType * 1000) + i11;
            double d8 = i11 / 100.0f;
            this.mSpline[0].getPos(d8, this.mInterpolateData);
            this.mStartMotionPath.getCenter(d8, this.mInterpolateVariables, this.mInterpolateData, fArr, i9);
            i9 += 2;
            i8 = i10;
            i2++;
        }
        return i2;
    }

    public double[] getPos(double d8) {
        this.mSpline[0].getPos(d8, this.mInterpolateData);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                curveFit.getPos(d8, dArr);
            }
        }
        return this.mInterpolateData;
    }

    public KeyPositionBase getPositionKeyframe(int i2, int i8, float f4, float f8) {
        int i9;
        int i10;
        float f9;
        float f10;
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f11 = motionPaths.mX;
        rectF.left = f11;
        float f12 = motionPaths.mY;
        rectF.top = f12;
        rectF.right = f11 + motionPaths.mWidth;
        rectF.bottom = f12 + motionPaths.mHeight;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f13 = motionPaths2.mX;
        rectF2.left = f13;
        float f14 = motionPaths2.mY;
        rectF2.top = f14;
        rectF2.right = f13 + motionPaths2.mWidth;
        rectF2.bottom = f14 + motionPaths2.mHeight;
        ArrayList<Key> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            int i12 = i11 + 1;
            Key key = arrayList.get(i11);
            if (key instanceof KeyPositionBase) {
                KeyPositionBase keyPositionBase = (KeyPositionBase) key;
                i9 = i2;
                i10 = i8;
                f9 = f4;
                f10 = f8;
                if (keyPositionBase.intersects(i9, i10, rectF, rectF2, f9, f10)) {
                    return keyPositionBase;
                }
            } else {
                i9 = i2;
                i10 = i8;
                f9 = f4;
                f10 = f8;
            }
            i2 = i9;
            i8 = i10;
            f4 = f9;
            f8 = f10;
            i11 = i12;
        }
        return null;
    }

    public void getPostLayoutDvDp(float f4, int i2, int i8, float f8, float f9, float[] fArr) {
        float adjustedPosition = getAdjustedPosition(f4, this.mVelocity);
        HashMap<String, ViewSpline> map = this.mAttributesMap;
        ViewSpline viewSpline = map == null ? null : map.get("translationX");
        HashMap<String, ViewSpline> map2 = this.mAttributesMap;
        ViewSpline viewSpline2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, ViewSpline> map3 = this.mAttributesMap;
        ViewSpline viewSpline3 = map3 == null ? null : map3.get(Key.ROTATION);
        HashMap<String, ViewSpline> map4 = this.mAttributesMap;
        ViewSpline viewSpline4 = map4 == null ? null : map4.get("scaleX");
        HashMap<String, ViewSpline> map5 = this.mAttributesMap;
        ViewSpline viewSpline5 = map5 == null ? null : map5.get("scaleY");
        HashMap<String, ViewOscillator> map6 = this.mCycleMap;
        ViewOscillator viewOscillator = map6 == null ? null : map6.get("translationX");
        HashMap<String, ViewOscillator> map7 = this.mCycleMap;
        ViewOscillator viewOscillator2 = map7 == null ? null : map7.get("translationY");
        HashMap<String, ViewOscillator> map8 = this.mCycleMap;
        ViewOscillator viewOscillator3 = map8 == null ? null : map8.get(Key.ROTATION);
        HashMap<String, ViewOscillator> map9 = this.mCycleMap;
        ViewOscillator viewOscillator4 = map9 == null ? null : map9.get("scaleX");
        HashMap<String, ViewOscillator> map10 = this.mCycleMap;
        ViewOscillator viewOscillator5 = map10 != null ? map10.get("scaleY") : null;
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(viewSpline3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(viewSpline, viewSpline2, adjustedPosition);
        velocityMatrix.setScaleVelocity(viewSpline4, viewSpline5, adjustedPosition);
        velocityMatrix.setRotationVelocity(viewOscillator3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(viewOscillator, viewOscillator2, adjustedPosition);
        velocityMatrix.setScaleVelocity(viewOscillator4, viewOscillator5, adjustedPosition);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                double d8 = adjustedPosition;
                curveFit.getPos(d8, dArr);
                this.mArcSpline.getSlope(d8, this.mInterpolateVelocity);
                this.mStartMotionPath.setDpDt(f8, f9, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            }
            velocityMatrix.applyTransform(f8, f9, i2, i8, fArr);
            return;
        }
        int i9 = 0;
        if (this.mSpline == null) {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f10 = motionPaths.mX;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f11 = f10 - motionPaths2.mX;
            float f12 = motionPaths.mY - motionPaths2.mY;
            float f13 = motionPaths.mWidth - motionPaths2.mWidth;
            float f14 = f12 + (motionPaths.mHeight - motionPaths2.mHeight);
            fArr[0] = ((f13 + f11) * f8) + ((1.0f - f8) * f11);
            fArr[1] = (f14 * f9) + ((1.0f - f9) * f12);
            velocityMatrix.clear();
            velocityMatrix.setRotationVelocity(viewSpline3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(viewSpline, viewSpline2, adjustedPosition);
            velocityMatrix.setScaleVelocity(viewSpline4, viewSpline5, adjustedPosition);
            velocityMatrix.setRotationVelocity(viewOscillator3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(viewOscillator, viewOscillator2, adjustedPosition);
            velocityMatrix.setScaleVelocity(viewOscillator4, viewOscillator5, adjustedPosition);
            velocityMatrix.applyTransform(f8, f9, i2, i8, fArr);
            return;
        }
        double adjustedPosition2 = getAdjustedPosition(adjustedPosition, this.mVelocity);
        this.mSpline[0].getSlope(adjustedPosition2, this.mInterpolateVelocity);
        this.mSpline[0].getPos(adjustedPosition2, this.mInterpolateData);
        float f15 = this.mVelocity[0];
        while (true) {
            double[] dArr2 = this.mInterpolateVelocity;
            if (i9 >= dArr2.length) {
                this.mStartMotionPath.setDpDt(f8, f9, fArr, this.mInterpolateVariables, dArr2, this.mInterpolateData);
                velocityMatrix.applyTransform(f8, f9, i2, i8, fArr);
                return;
            } else {
                dArr2[i9] = dArr2[i9] * ((double) f15);
                i9++;
            }
        }
    }

    public float getStartHeight() {
        return this.mStartMotionPath.mHeight;
    }

    public float getStartWidth() {
        return this.mStartMotionPath.mWidth;
    }

    public float getStartX() {
        return this.mStartMotionPath.mX;
    }

    public float getStartY() {
        return this.mStartMotionPath.mY;
    }

    public int getTransformPivotTarget() {
        return this.mTransformPivotTarget;
    }

    public View getView() {
        return this.mView;
    }

    public boolean interpolate(View view, float f4, long j, KeyCache keyCache) {
        ViewTimeCycle.PathRotate pathRotate;
        boolean pathRotate2;
        View view2;
        View view3;
        float f8;
        float f9;
        double d8;
        View view4 = view;
        float adjustedPosition = getAdjustedPosition(f4, null);
        int i2 = this.mQuantizeMotionSteps;
        if (i2 != Key.UNSET) {
            float f10 = 1.0f / i2;
            float fFloor = ((float) Math.floor(adjustedPosition / f10)) * f10;
            float f11 = (adjustedPosition % f10) / f10;
            if (!Float.isNaN(this.mQuantizeMotionPhase)) {
                f11 = (f11 + this.mQuantizeMotionPhase) % 1.0f;
            }
            Interpolator interpolator = this.mQuantizeMotionInterpolator;
            adjustedPosition = ((interpolator != null ? interpolator.getInterpolation(f11) : ((double) f11) > 0.5d ? 1.0f : 0.0f) * f10) + fFloor;
        }
        HashMap<String, ViewSpline> map = this.mAttributesMap;
        if (map != null) {
            Iterator<ViewSpline> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().setProperty(view4, adjustedPosition);
            }
        }
        HashMap<String, ViewTimeCycle> map2 = this.mTimeCycleAttributesMap;
        if (map2 != null) {
            ViewTimeCycle.PathRotate pathRotate3 = null;
            boolean property = false;
            for (ViewTimeCycle viewTimeCycle : map2.values()) {
                if (viewTimeCycle instanceof ViewTimeCycle.PathRotate) {
                    pathRotate3 = (ViewTimeCycle.PathRotate) viewTimeCycle;
                } else {
                    property |= viewTimeCycle.setProperty(view4, adjustedPosition, j, keyCache);
                    view4 = view;
                }
            }
            pathRotate2 = property;
            pathRotate = pathRotate3;
        } else {
            pathRotate = null;
            pathRotate2 = false;
        }
        CurveFit[] curveFitArr = this.mSpline;
        if (curveFitArr != null) {
            double d9 = adjustedPosition;
            curveFitArr[0].getPos(d9, this.mInterpolateData);
            this.mSpline[0].getSlope(d9, this.mInterpolateVelocity);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d9, dArr);
                    this.mArcSpline.getSlope(d9, this.mInterpolateVelocity);
                }
            }
            if (this.mNoMovement) {
                view3 = view;
                f8 = 1.0f;
                f9 = 0.0f;
                d8 = d9;
            } else {
                float f12 = adjustedPosition;
                f8 = 1.0f;
                d8 = d9;
                f9 = 0.0f;
                this.mStartMotionPath.setView(f12, view, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null, this.mForceMeasure);
                adjustedPosition = f12;
                view3 = view;
                this.mForceMeasure = false;
            }
            if (this.mTransformPivotTarget != Key.UNSET) {
                if (this.mTransformPivotView == null) {
                    this.mTransformPivotView = ((View) view3.getParent()).findViewById(this.mTransformPivotTarget);
                }
                if (this.mTransformPivotView != null) {
                    float bottom = (this.mTransformPivotView.getBottom() + r1.getTop()) / 2.0f;
                    float right = (this.mTransformPivotView.getRight() + this.mTransformPivotView.getLeft()) / 2.0f;
                    if (view3.getRight() - view3.getLeft() > 0 && view3.getBottom() - view3.getTop() > 0) {
                        view3.setPivotX(right - view3.getLeft());
                        view3.setPivotY(bottom - view3.getTop());
                    }
                }
            }
            HashMap<String, ViewSpline> map3 = this.mAttributesMap;
            if (map3 != null) {
                for (ViewSpline viewSpline : map3.values()) {
                    if (viewSpline instanceof ViewSpline.PathRotate) {
                        double[] dArr2 = this.mInterpolateVelocity;
                        if (dArr2.length > 1) {
                            ((ViewSpline.PathRotate) viewSpline).setPathRotate(view3, adjustedPosition, dArr2[0], dArr2[1]);
                        }
                    }
                    view3 = view;
                }
            }
            if (pathRotate != null) {
                double[] dArr3 = this.mInterpolateVelocity;
                view2 = view;
                float f13 = adjustedPosition;
                adjustedPosition = f13;
                pathRotate2 |= pathRotate.setPathRotate(view2, keyCache, f13, j, dArr3[0], dArr3[1]);
            } else {
                view2 = view;
            }
            int i8 = 1;
            while (true) {
                CurveFit[] curveFitArr2 = this.mSpline;
                if (i8 >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i8].getPos(d8, this.mValuesBuff);
                CustomSupport.setInterpolatedValue(this.mStartMotionPath.mAttributes.get(this.mAttributeNames[i8 - 1]), view2, this.mValuesBuff);
                i8++;
            }
            MotionConstrainedPoint motionConstrainedPoint = this.mStartPoint;
            if (motionConstrainedPoint.mVisibilityMode == 0) {
                if (adjustedPosition <= f9) {
                    view2.setVisibility(motionConstrainedPoint.mVisibility);
                } else if (adjustedPosition >= f8) {
                    view2.setVisibility(this.mEndPoint.mVisibility);
                } else if (this.mEndPoint.mVisibility != motionConstrainedPoint.mVisibility) {
                    view2.setVisibility(0);
                }
            }
            if (this.mKeyTriggers != null) {
                int i9 = 0;
                while (true) {
                    KeyTrigger[] keyTriggerArr = this.mKeyTriggers;
                    if (i9 >= keyTriggerArr.length) {
                        break;
                    }
                    keyTriggerArr[i9].conditionallyFire(adjustedPosition, view2);
                    i9++;
                }
            }
        } else {
            view2 = view;
            MotionPaths motionPaths = this.mStartMotionPath;
            float f14 = motionPaths.mX;
            MotionPaths motionPaths2 = this.mEndMotionPath;
            float fA = a.a(motionPaths2.mX, f14, adjustedPosition, f14);
            float f15 = motionPaths.mY;
            float fA2 = a.a(motionPaths2.mY, f15, adjustedPosition, f15);
            float f16 = motionPaths.mWidth;
            float f17 = motionPaths2.mWidth;
            float fA3 = a.a(f17, f16, adjustedPosition, f16);
            float f18 = motionPaths.mHeight;
            float f19 = motionPaths2.mHeight;
            float f20 = fA + 0.5f;
            int i10 = (int) f20;
            float f21 = fA2 + 0.5f;
            int i11 = (int) f21;
            int i12 = (int) (f20 + fA3);
            int iA = (int) (f21 + a.a(f19, f18, adjustedPosition, f18));
            int i13 = i12 - i10;
            int i14 = iA - i11;
            if (f17 != f16 || f19 != f18 || this.mForceMeasure) {
                view2.measure(View.MeasureSpec.makeMeasureSpec(i13, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(i14, BasicMeasure.EXACTLY));
                this.mForceMeasure = false;
            }
            view2.layout(i10, i11, i12, iA);
        }
        HashMap<String, ViewOscillator> map4 = this.mCycleMap;
        if (map4 != null) {
            for (ViewOscillator viewOscillator : map4.values()) {
                if (viewOscillator instanceof ViewOscillator.PathRotateSet) {
                    double[] dArr4 = this.mInterpolateVelocity;
                    ((ViewOscillator.PathRotateSet) viewOscillator).setPathRotate(view2, adjustedPosition, dArr4[0], dArr4[1]);
                } else {
                    viewOscillator.setProperty(view2, adjustedPosition);
                }
            }
        }
        return pathRotate2;
    }

    public String name() {
        return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
    }

    public void positionKeyframe(View view, KeyPositionBase keyPositionBase, float f4, float f8, String[] strArr, float[] fArr) {
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f9 = motionPaths.mX;
        rectF.left = f9;
        float f10 = motionPaths.mY;
        rectF.top = f10;
        rectF.right = f9 + motionPaths.mWidth;
        rectF.bottom = f10 + motionPaths.mHeight;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f11 = motionPaths2.mX;
        rectF2.left = f11;
        float f12 = motionPaths2.mY;
        rectF2.top = f12;
        rectF2.right = f11 + motionPaths2.mWidth;
        rectF2.bottom = f12 + motionPaths2.mHeight;
        keyPositionBase.positionAttributes(view, rectF, rectF2, f4, f8, strArr, fArr);
    }

    public void remeasure() {
        this.mForceMeasure = true;
    }

    public void rotate(Rect rect, Rect rect2, int i2, int i8, int i9) {
        if (i2 == 1) {
            int i10 = rect.left + rect.right;
            rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.top = i9 - ((rect.height() + i10) / 2);
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
            return;
        }
        if (i2 == 2) {
            int i11 = rect.left + rect.right;
            rect2.left = i8 - ((rect.width() + (rect.top + rect.bottom)) / 2);
            rect2.top = (i11 - rect.height()) / 2;
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
            return;
        }
        if (i2 == 3) {
            int i12 = rect.left + rect.right;
            rect2.left = ((rect.height() / 2) + rect.top) - (i12 / 2);
            rect2.top = i9 - ((rect.height() + i12) / 2);
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
            return;
        }
        if (i2 != 4) {
            return;
        }
        int i13 = rect.left + rect.right;
        rect2.left = i8 - ((rect.width() + (rect.bottom + rect.top)) / 2);
        rect2.top = (i13 - rect.height()) / 2;
        rect2.right = rect.width() + rect2.left;
        rect2.bottom = rect.height() + rect2.top;
    }

    public void setBothStates(View view) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        this.mNoMovement = true;
        motionPaths.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mEndMotionPath.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mStartPoint.setState(view);
        this.mEndPoint.setState(view);
    }

    public void setDrawPath(int i2) {
        this.mStartMotionPath.mDrawPath = i2;
    }

    public void setEndState(Rect rect, ConstraintSet constraintSet, int i2, int i8) {
        MotionController motionController;
        int i9 = constraintSet.mRotate;
        if (i9 != 0) {
            motionController = this;
            motionController.rotate(rect, this.mTempRect, i9, i2, i8);
            rect = motionController.mTempRect;
        } else {
            motionController = this;
        }
        MotionPaths motionPaths = motionController.mEndMotionPath;
        motionPaths.mTime = 1.0f;
        motionPaths.mPosition = 1.0f;
        readView(motionPaths);
        motionController.mEndMotionPath.setBounds(rect.left, rect.top, rect.width(), rect.height());
        motionController.mEndMotionPath.applyParameters(constraintSet.getParameters(motionController.mId));
        motionController.mEndPoint.setState(rect, constraintSet, i9, motionController.mId);
    }

    public void setPathMotionArc(int i2) {
        this.mPathMotionArc = i2;
    }

    public void setStartCurrentState(View view) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        motionPaths.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mStartPoint.setState(view);
    }

    public void setStartState(ViewState viewState, View view, int i2, int i8, int i9) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        Rect rect = new Rect();
        if (i2 == 1) {
            int i10 = viewState.left + viewState.right;
            rect.left = ((viewState.top + viewState.bottom) - viewState.width()) / 2;
            rect.top = i8 - ((viewState.height() + i10) / 2);
            rect.right = viewState.width() + rect.left;
            rect.bottom = viewState.height() + rect.top;
        } else if (i2 == 2) {
            int i11 = viewState.left + viewState.right;
            rect.left = i9 - ((viewState.width() + (viewState.top + viewState.bottom)) / 2);
            rect.top = (i11 - viewState.height()) / 2;
            rect.right = viewState.width() + rect.left;
            rect.bottom = viewState.height() + rect.top;
        }
        this.mStartMotionPath.setBounds(rect.left, rect.top, rect.width(), rect.height());
        this.mStartPoint.setState(rect, view, i2, viewState.rotation);
    }

    public void setTransformPivotTarget(int i2) {
        this.mTransformPivotTarget = i2;
        this.mTransformPivotView = null;
    }

    public void setView(View view) {
        this.mView = view;
        this.mId = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.mConstraintTag = ((ConstraintLayout.LayoutParams) layoutParams).getConstraintTag();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setup(int i2, int i8, float f4, long j) {
        ArrayList arrayList;
        int i9;
        String[] strArr;
        int i10;
        int i11;
        ConstraintAttribute constraintAttribute;
        ViewTimeCycle viewTimeCycleMakeSpline;
        ConstraintAttribute constraintAttribute2;
        Integer num;
        int i12;
        ViewSpline viewSplineMakeSpline;
        ConstraintAttribute constraintAttribute3;
        new HashSet();
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        int i13 = this.mPathMotionArc;
        if (i13 != Key.UNSET) {
            this.mStartMotionPath.mPathMotionArc = i13;
        }
        this.mStartPoint.different(this.mEndPoint, hashSet2);
        ArrayList<Key> arrayList2 = this.mKeyList;
        int i14 = 0;
        if (arrayList2 != null) {
            int size = arrayList2.size();
            int i15 = 0;
            arrayList = null;
            while (i15 < size) {
                Key key = arrayList2.get(i15);
                i15++;
                Key key2 = key;
                if (key2 instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) key2;
                    insertKey(new MotionPaths(i2, i8, keyPosition, this.mStartMotionPath, this.mEndMotionPath));
                    int i16 = keyPosition.mCurveFit;
                    if (i16 != Key.UNSET) {
                        this.mCurveFitType = i16;
                    }
                } else if (key2 instanceof KeyCycle) {
                    key2.getAttributeNames(hashSet3);
                } else if (key2 instanceof KeyTimeCycle) {
                    key2.getAttributeNames(hashSet);
                } else if (key2 instanceof KeyTrigger) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((KeyTrigger) key2);
                } else {
                    key2.setInterpolation(map);
                    key2.getAttributeNames(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.mKeyTriggers = (KeyTrigger[]) arrayList.toArray(new KeyTrigger[0]);
        }
        int i17 = 1;
        if (hashSet2.isEmpty()) {
            i9 = 1;
        } else {
            this.mAttributesMap = new HashMap<>();
            for (String str : hashSet2) {
                if (str.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str2 = str.split(",")[i17];
                    ArrayList<Key> arrayList3 = this.mKeyList;
                    int size2 = arrayList3.size();
                    int i18 = i14;
                    while (i18 < size2) {
                        Key key3 = arrayList3.get(i18);
                        i18++;
                        int i19 = i17;
                        Key key4 = key3;
                        HashMap<String, ConstraintAttribute> map2 = key4.mCustomConstraints;
                        if (map2 != null && (constraintAttribute3 = map2.get(str2)) != null) {
                            sparseArray.append(key4.mFramePosition, constraintAttribute3);
                        }
                        i17 = i19;
                    }
                    i12 = i17;
                    viewSplineMakeSpline = ViewSpline.makeCustomSpline(str, (SparseArray<ConstraintAttribute>) sparseArray);
                } else {
                    i12 = i17;
                    viewSplineMakeSpline = ViewSpline.makeSpline(str);
                }
                if (viewSplineMakeSpline != null) {
                    viewSplineMakeSpline.setType(str);
                    this.mAttributesMap.put(str, viewSplineMakeSpline);
                }
                i17 = i12;
                i14 = 0;
            }
            i9 = i17;
            ArrayList<Key> arrayList4 = this.mKeyList;
            if (arrayList4 != null) {
                int size3 = arrayList4.size();
                int i20 = 0;
                while (i20 < size3) {
                    Key key5 = arrayList4.get(i20);
                    i20++;
                    Key key6 = key5;
                    if (key6 instanceof KeyAttributes) {
                        key6.addValues(this.mAttributesMap);
                    }
                }
            }
            this.mStartPoint.addValues(this.mAttributesMap, 0);
            this.mEndPoint.addValues(this.mAttributesMap, 100);
            for (String str3 : this.mAttributesMap.keySet()) {
                int iIntValue = (!map.containsKey(str3) || (num = map.get(str3)) == null) ? 0 : num.intValue();
                ViewSpline viewSpline = this.mAttributesMap.get(str3);
                if (viewSpline != null) {
                    viewSpline.setup(iIntValue);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.mTimeCycleAttributesMap == null) {
                this.mTimeCycleAttributesMap = new HashMap<>();
            }
            for (String str4 : hashSet) {
                if (!this.mTimeCycleAttributesMap.containsKey(str4)) {
                    if (str4.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str5 = str4.split(",")[i9];
                        ArrayList<Key> arrayList5 = this.mKeyList;
                        int size4 = arrayList5.size();
                        int i21 = 0;
                        while (i21 < size4) {
                            Key key7 = arrayList5.get(i21);
                            i21++;
                            Key key8 = key7;
                            HashMap<String, ConstraintAttribute> map3 = key8.mCustomConstraints;
                            if (map3 != null && (constraintAttribute2 = map3.get(str5)) != null) {
                                sparseArray2.append(key8.mFramePosition, constraintAttribute2);
                            }
                        }
                        viewTimeCycleMakeSpline = ViewTimeCycle.makeCustomSpline(str4, sparseArray2);
                    } else {
                        viewTimeCycleMakeSpline = ViewTimeCycle.makeSpline(str4, j);
                    }
                    if (viewTimeCycleMakeSpline != null) {
                        viewTimeCycleMakeSpline.setType(str4);
                        this.mTimeCycleAttributesMap.put(str4, viewTimeCycleMakeSpline);
                    }
                }
            }
            ArrayList<Key> arrayList6 = this.mKeyList;
            if (arrayList6 != null) {
                int size5 = arrayList6.size();
                int i22 = 0;
                while (i22 < size5) {
                    Key key9 = arrayList6.get(i22);
                    i22++;
                    Key key10 = key9;
                    if (key10 instanceof KeyTimeCycle) {
                        ((KeyTimeCycle) key10).addTimeValues(this.mTimeCycleAttributesMap);
                    }
                }
            }
            for (String str6 : this.mTimeCycleAttributesMap.keySet()) {
                this.mTimeCycleAttributesMap.get(str6).setup(map.containsKey(str6) ? map.get(str6).intValue() : 0);
            }
        }
        int size6 = this.mMotionPaths.size();
        int i23 = size6 + 2;
        MotionPaths[] motionPathsArr = new MotionPaths[i23];
        motionPathsArr[0] = this.mStartMotionPath;
        motionPathsArr[size6 + 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0 && this.mCurveFitType == -1) {
            this.mCurveFitType = 0;
        }
        ArrayList<MotionPaths> arrayList7 = this.mMotionPaths;
        int size7 = arrayList7.size();
        int i24 = i9;
        int i25 = 0;
        while (i25 < size7) {
            MotionPaths motionPaths = arrayList7.get(i25);
            i25++;
            motionPathsArr[i24] = motionPaths;
            i24++;
        }
        HashSet hashSet4 = new HashSet();
        for (String str7 : this.mEndMotionPath.mAttributes.keySet()) {
            if (this.mStartMotionPath.mAttributes.containsKey(str7)) {
                if (!hashSet2.contains("CUSTOM," + str7)) {
                    hashSet4.add(str7);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet4.toArray(new String[0]);
        this.mAttributeNames = strArr2;
        this.mAttributeInterpolatorCount = new int[strArr2.length];
        int i26 = 0;
        while (true) {
            strArr = this.mAttributeNames;
            if (i26 >= strArr.length) {
                break;
            }
            String str8 = strArr[i26];
            this.mAttributeInterpolatorCount[i26] = 0;
            int i27 = 0;
            while (true) {
                if (i27 >= i23) {
                    break;
                }
                if (motionPathsArr[i27].mAttributes.containsKey(str8) && (constraintAttribute = motionPathsArr[i27].mAttributes.get(str8)) != null) {
                    int[] iArr = this.mAttributeInterpolatorCount;
                    iArr[i26] = constraintAttribute.numberOfInterpolatedValues() + iArr[i26];
                    break;
                }
                i27++;
            }
            i26++;
        }
        boolean z2 = motionPathsArr[0].mPathMotionArc != Key.UNSET ? i9 : 0;
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i28 = i9; i28 < i23; i28++) {
            motionPathsArr[i28].different(motionPathsArr[i28 - 1], zArr, this.mAttributeNames, z2);
        }
        int i29 = 0;
        for (int i30 = i9; i30 < length; i30++) {
            if (zArr[i30]) {
                i29++;
            }
        }
        this.mInterpolateVariables = new int[i29];
        int i31 = 2;
        int iMax = Math.max(2, i29);
        this.mInterpolateData = new double[iMax];
        this.mInterpolateVelocity = new double[iMax];
        int i32 = 0;
        for (int i33 = i9; i33 < length; i33++) {
            if (zArr[i33]) {
                this.mInterpolateVariables[i32] = i33;
                i32++;
            }
        }
        int[] iArr2 = new int[2];
        iArr2[i9] = this.mInterpolateVariables.length;
        iArr2[0] = i23;
        Class cls = Double.TYPE;
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) cls, iArr2);
        double[] dArr2 = new double[i23];
        for (int i34 = 0; i34 < i23; i34++) {
            motionPathsArr[i34].fillStandard(dArr[i34], this.mInterpolateVariables);
            dArr2[i34] = motionPathsArr[i34].mTime;
        }
        int i35 = 0;
        while (true) {
            int[] iArr3 = this.mInterpolateVariables;
            if (i35 >= iArr3.length) {
                break;
            }
            if (iArr3[i35] < MotionPaths.sNames.length) {
                String strR = a.r(new StringBuilder(), MotionPaths.sNames[this.mInterpolateVariables[i35]], " [");
                for (int i36 = 0; i36 < i23; i36++) {
                    StringBuilder sbR = androidx.camera.core.processing.util.a.r(strR);
                    sbR.append(dArr[i36][i35]);
                    strR = sbR.toString();
                }
            }
            i35++;
        }
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int i37 = 0;
        while (true) {
            String[] strArr3 = this.mAttributeNames;
            if (i37 >= strArr3.length) {
                break;
            }
            String str9 = strArr3[i37];
            int i38 = 0;
            int i39 = 0;
            double[] dArr3 = null;
            double[][] dArr4 = null;
            while (i38 < i23) {
                if (motionPathsArr[i38].hasCustomData(str9)) {
                    if (dArr4 == null) {
                        dArr3 = new double[i23];
                        int[] iArr4 = new int[i31];
                        iArr4[i9] = motionPathsArr[i38].getCustomDataCount(str9);
                        i11 = 0;
                        iArr4[0] = i23;
                        dArr4 = (double[][]) Array.newInstance((Class<?>) cls, iArr4);
                    } else {
                        i11 = 0;
                    }
                    MotionPaths motionPaths2 = motionPathsArr[i38];
                    i10 = i37;
                    dArr3[i39] = motionPaths2.mTime;
                    motionPaths2.getCustomData(str9, dArr4[i39], i11);
                    i39++;
                } else {
                    i10 = i37;
                }
                i38++;
                i37 = i10;
                i31 = 2;
            }
            int i40 = i37 + 1;
            this.mSpline[i40] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(dArr3, i39), (double[][]) Arrays.copyOf(dArr4, i39));
            i37 = i40;
            i31 = 2;
        }
        int i41 = 0;
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, dArr2, dArr);
        if (motionPathsArr[0].mPathMotionArc != Key.UNSET) {
            int[] iArr5 = new int[i23];
            double[] dArr5 = new double[i23];
            int[] iArr6 = new int[2];
            iArr6[i9] = 2;
            iArr6[0] = i23;
            double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) cls, iArr6);
            for (int i42 = 0; i42 < i23; i42++) {
                iArr5[i42] = motionPathsArr[i42].mPathMotionArc;
                dArr5[i42] = r8.mTime;
                double[] dArr7 = dArr6[i42];
                dArr7[0] = r8.mX;
                dArr7[i9] = r8.mY;
            }
            i41 = 0;
            this.mArcSpline = CurveFit.getArc(iArr5, dArr5, dArr6);
        }
        this.mCycleMap = new HashMap<>();
        if (this.mKeyList != null) {
            float preCycleDistance = Float.NaN;
            for (String str10 : hashSet3) {
                ViewOscillator viewOscillatorMakeSpline = ViewOscillator.makeSpline(str10);
                if (viewOscillatorMakeSpline != null) {
                    if (viewOscillatorMakeSpline.variesByPath() && Float.isNaN(preCycleDistance)) {
                        preCycleDistance = getPreCycleDistance();
                    }
                    viewOscillatorMakeSpline.setType(str10);
                    this.mCycleMap.put(str10, viewOscillatorMakeSpline);
                }
            }
            ArrayList<Key> arrayList8 = this.mKeyList;
            int size8 = arrayList8.size();
            int i43 = i41;
            while (i43 < size8) {
                Key key11 = arrayList8.get(i43);
                i43++;
                Key key12 = key11;
                if (key12 instanceof KeyCycle) {
                    ((KeyCycle) key12).addCycleValues(this.mCycleMap);
                }
            }
            Iterator<ViewOscillator> it = this.mCycleMap.values().iterator();
            while (it.hasNext()) {
                it.next().setup(preCycleDistance);
            }
        }
    }

    public void setupRelative(MotionController motionController) {
        this.mStartMotionPath.setupRelative(motionController, motionController.mStartMotionPath);
        this.mEndMotionPath.setupRelative(motionController, motionController.mEndMotionPath);
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.mX + " y: " + this.mStartMotionPath.mY + " end: x: " + this.mEndMotionPath.mX + " y: " + this.mEndMotionPath.mY;
    }

    public void setStartState(Rect rect, ConstraintSet constraintSet, int i2, int i8) {
        MotionController motionController;
        Rect rect2;
        int i9 = constraintSet.mRotate;
        if (i9 != 0) {
            motionController = this;
            rect2 = rect;
            motionController.rotate(rect2, this.mTempRect, i9, i2, i8);
        } else {
            motionController = this;
            rect2 = rect;
        }
        MotionPaths motionPaths = motionController.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        readView(motionPaths);
        motionController.mStartMotionPath.setBounds(rect2.left, rect2.top, rect2.width(), rect2.height());
        ConstraintSet.Constraint parameters = constraintSet.getParameters(motionController.mId);
        motionController.mStartMotionPath.applyParameters(parameters);
        motionController.mMotionStagger = parameters.motion.mMotionStagger;
        motionController.mStartPoint.setState(rect2, constraintSet, i9, motionController.mId);
        motionController.mTransformPivotTarget = parameters.transform.transformPivotTarget;
        ConstraintSet.Motion motion = parameters.motion;
        motionController.mQuantizeMotionSteps = motion.mQuantizeMotionSteps;
        motionController.mQuantizeMotionPhase = motion.mQuantizeMotionPhase;
        Context context = motionController.mView.getContext();
        ConstraintSet.Motion motion2 = parameters.motion;
        motionController.mQuantizeMotionInterpolator = getInterpolator(context, motion2.mQuantizeInterpolatorType, motion2.mQuantizeInterpolatorString, motion2.mQuantizeInterpolatorID);
    }
}
