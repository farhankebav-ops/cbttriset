package androidx.constraintlayout.motion.widget;

import a1.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Flow;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.Placeholder;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.AdError;
import com.ironsource.C2300e4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3 {
    private static final boolean DEBUG = false;
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    private static final float EPSILON = 1.0E-5f;
    public static boolean IS_IN_EDIT_MODE = false;
    static final int MAX_KEY_FRAMES = 50;
    static final String TAG = "MotionLayout";
    public static final int TOUCH_UP_COMPLETE = 0;
    public static final int TOUCH_UP_COMPLETE_TO_END = 2;
    public static final int TOUCH_UP_COMPLETE_TO_START = 1;
    public static final int TOUCH_UP_DECELERATE = 4;
    public static final int TOUCH_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int TOUCH_UP_NEVER_TO_END = 7;
    public static final int TOUCH_UP_NEVER_TO_START = 6;
    public static final int TOUCH_UP_STOP = 3;
    public static final int VELOCITY_LAYOUT = 1;
    public static final int VELOCITY_POST_LAYOUT = 0;
    public static final int VELOCITY_STATIC_LAYOUT = 3;
    public static final int VELOCITY_STATIC_POST_LAYOUT = 2;
    private long mAnimationStartTime;
    private int mBeginState;
    private RectF mBoundsCheck;
    int mCurrentState;
    int mDebugPath;
    private DecelerateInterpolator mDecelerateLogic;
    private ArrayList<MotionHelper> mDecoratorsHelpers;
    private boolean mDelayedApply;
    private DesignTool mDesignTool;
    DevModeDraw mDevModeDraw;
    private int mEndState;
    int mEndWrapHeight;
    int mEndWrapWidth;
    boolean mFirstDown;
    HashMap<View, MotionController> mFrameArrayList;
    private int mFrames;
    int mHeightMeasureMode;
    private boolean mInLayout;
    private boolean mInRotation;
    boolean mInTransition;
    boolean mIndirectTransition;
    private boolean mInteractionEnabled;
    Interpolator mInterpolator;
    private Matrix mInverseMatrix;
    boolean mIsAnimating;
    private boolean mKeepAnimating;
    private KeyCache mKeyCache;
    private long mLastDrawTime;
    private float mLastFps;
    private int mLastHeightMeasureSpec;
    int mLastLayoutHeight;
    int mLastLayoutWidth;
    private float mLastPos;
    float mLastVelocity;
    private int mLastWidthMeasureSpec;
    private float mLastY;
    private float mListenerPosition;
    private int mListenerState;
    protected boolean mMeasureDuringTransition;
    Model mModel;
    private boolean mNeedsFireTransitionCompleted;
    int mOldHeight;
    int mOldWidth;
    private Runnable mOnComplete;
    private ArrayList<MotionHelper> mOnHideHelpers;
    private ArrayList<MotionHelper> mOnShowHelpers;
    float mPostInterpolationPosition;
    HashMap<View, ViewState> mPreRotate;
    private int mPreRotateHeight;
    private int mPreRotateWidth;
    private int mPreviouseRotation;
    Interpolator mProgressInterpolator;
    private View mRegionView;
    int mRotatMode;
    MotionScene mScene;
    private int[] mScheduledTransitionTo;
    int mScheduledTransitions;
    float mScrollTargetDT;
    float mScrollTargetDX;
    float mScrollTargetDY;
    long mScrollTargetTime;
    int mStartWrapHeight;
    int mStartWrapWidth;
    private StateCache mStateCache;
    private StopLogic mStopLogic;
    Rect mTempRect;
    private boolean mTemporalInterpolator;
    ArrayList<Integer> mTransitionCompleted;
    private float mTransitionDuration;
    float mTransitionGoalPosition;
    private boolean mTransitionInstantly;
    float mTransitionLastPosition;
    private long mTransitionLastTime;
    private TransitionListener mTransitionListener;
    private CopyOnWriteArrayList<TransitionListener> mTransitionListeners;
    float mTransitionPosition;
    TransitionState mTransitionState;
    boolean mUndergoingMotion;
    int mWidthMeasureMode;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class DecelerateInterpolator extends MotionInterpolator {
        float mMaxA;
        float mInitialV = 0.0f;
        float mCurrentP = 0.0f;

        public DecelerateInterpolator() {
        }

        public void config(float f4, float f8, float f9) {
            this.mInitialV = f4;
            this.mCurrentP = f8;
            this.mMaxA = f9;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            float f8 = this.mInitialV;
            if (f8 > 0.0f) {
                float f9 = this.mMaxA;
                if (f8 / f9 < f4) {
                    f4 = f8 / f9;
                }
                MotionLayout.this.mLastVelocity = f8 - (f9 * f4);
                return ((f8 * f4) - (((f9 * f4) * f4) / 2.0f)) + this.mCurrentP;
            }
            float f10 = this.mMaxA;
            if ((-f8) / f10 < f4) {
                f4 = (-f8) / f10;
            }
            MotionLayout.this.mLastVelocity = (f10 * f4) + f8;
            return (((f10 * f4) * f4) / 2.0f) + (f8 * f4) + this.mCurrentP;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
        public float getVelocity() {
            return MotionLayout.this.mLastVelocity;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class DevModeDraw {
        private static final int DEBUG_PATH_TICKS_PER_MS = 16;
        DashPathEffect mDashPathEffect;
        Paint mFillPaint;
        int mKeyFrameCount;
        float[] mKeyFramePoints;
        Paint mPaint;
        Paint mPaintGraph;
        Paint mPaintKeyframes;
        Path mPath;
        int[] mPathMode;
        float[] mPoints;
        private float[] mRectangle;
        int mShadowTranslate;
        Paint mTextPaint;
        final int mRedColor = -21965;
        final int mKeyframeColor = -2067046;
        final int mGraphColor = -13391360;
        final int mShadowColor = 1996488704;
        final int mDiamondSize = 10;
        Rect mBounds = new Rect();
        boolean mPresentationMode = false;

        public DevModeDraw() {
            this.mShadowTranslate = 1;
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            this.mPaint.setColor(-21965);
            this.mPaint.setStrokeWidth(2.0f);
            Paint paint2 = this.mPaint;
            Paint.Style style = Paint.Style.STROKE;
            paint2.setStyle(style);
            Paint paint3 = new Paint();
            this.mPaintKeyframes = paint3;
            paint3.setAntiAlias(true);
            this.mPaintKeyframes.setColor(-2067046);
            this.mPaintKeyframes.setStrokeWidth(2.0f);
            this.mPaintKeyframes.setStyle(style);
            Paint paint4 = new Paint();
            this.mPaintGraph = paint4;
            paint4.setAntiAlias(true);
            this.mPaintGraph.setColor(-13391360);
            this.mPaintGraph.setStrokeWidth(2.0f);
            this.mPaintGraph.setStyle(style);
            Paint paint5 = new Paint();
            this.mTextPaint = paint5;
            paint5.setAntiAlias(true);
            this.mTextPaint.setColor(-13391360);
            this.mTextPaint.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.mRectangle = new float[8];
            Paint paint6 = new Paint();
            this.mFillPaint = paint6;
            paint6.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.mDashPathEffect = dashPathEffect;
            this.mPaintGraph.setPathEffect(dashPathEffect);
            this.mKeyFramePoints = new float[100];
            this.mPathMode = new int[50];
            if (this.mPresentationMode) {
                this.mPaint.setStrokeWidth(8.0f);
                this.mFillPaint.setStrokeWidth(8.0f);
                this.mPaintKeyframes.setStrokeWidth(8.0f);
                this.mShadowTranslate = 4;
            }
        }

        private void drawBasicPath(Canvas canvas) {
            canvas.drawLines(this.mPoints, this.mPaint);
        }

        private void drawPathAsConfigured(Canvas canvas) {
            boolean z2 = false;
            boolean z7 = false;
            for (int i2 = 0; i2 < this.mKeyFrameCount; i2++) {
                int i8 = this.mPathMode[i2];
                if (i8 == 1) {
                    z2 = true;
                }
                if (i8 == 0) {
                    z7 = true;
                }
            }
            if (z2) {
                drawPathRelative(canvas);
            }
            if (z7) {
                drawPathCartesian(canvas);
            }
        }

        private void drawPathCartesian(Canvas canvas) {
            float[] fArr = this.mPoints;
            float f4 = fArr[0];
            float f8 = fArr[1];
            float f9 = fArr[fArr.length - 2];
            float f10 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f4, f9), Math.max(f8, f10), Math.max(f4, f9), Math.max(f8, f10), this.mPaintGraph);
            canvas.drawLine(Math.min(f4, f9), Math.min(f8, f10), Math.min(f4, f9), Math.max(f8, f10), this.mPaintGraph);
        }

        private void drawPathCartesianTicks(Canvas canvas, float f4, float f8) {
            float[] fArr = this.mPoints;
            float f9 = fArr[0];
            float f10 = fArr[1];
            float f11 = fArr[fArr.length - 2];
            float f12 = fArr[fArr.length - 1];
            float fMin = Math.min(f9, f11);
            float fMax = Math.max(f10, f12);
            float fMin2 = f4 - Math.min(f9, f11);
            float fMax2 = Math.max(f10, f12) - f8;
            String str = "" + (((int) (((double) ((fMin2 * 100.0f) / Math.abs(f11 - f9))) + 0.5d)) / 100.0f);
            getTextBounds(str, this.mTextPaint);
            canvas.drawText(str, ((fMin2 / 2.0f) - (this.mBounds.width() / 2)) + fMin, f8 - 20.0f, this.mTextPaint);
            canvas.drawLine(f4, f8, Math.min(f9, f11), f8, this.mPaintGraph);
            String str2 = "" + (((int) (((double) ((fMax2 * 100.0f) / Math.abs(f12 - f10))) + 0.5d)) / 100.0f);
            getTextBounds(str2, this.mTextPaint);
            canvas.drawText(str2, f4 + 5.0f, fMax - ((fMax2 / 2.0f) - (this.mBounds.height() / 2)), this.mTextPaint);
            canvas.drawLine(f4, f8, f4, Math.max(f10, f12), this.mPaintGraph);
        }

        private void drawPathRelative(Canvas canvas) {
            float[] fArr = this.mPoints;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.mPaintGraph);
        }

        private void drawPathRelativeTicks(Canvas canvas, float f4, float f8) {
            float[] fArr = this.mPoints;
            float f9 = fArr[0];
            float f10 = fArr[1];
            float f11 = fArr[fArr.length - 2];
            float f12 = fArr[fArr.length - 1];
            float fHypot = (float) Math.hypot(f9 - f11, f10 - f12);
            float f13 = f11 - f9;
            float f14 = f12 - f10;
            float f15 = (((f8 - f10) * f14) + ((f4 - f9) * f13)) / (fHypot * fHypot);
            float f16 = f9 + (f13 * f15);
            float f17 = (f15 * f14) + f10;
            Path path = new Path();
            path.moveTo(f4, f8);
            path.lineTo(f16, f17);
            float fHypot2 = (float) Math.hypot(f16 - f4, f17 - f8);
            String str = "" + (((int) ((fHypot2 * 100.0f) / fHypot)) / 100.0f);
            getTextBounds(str, this.mTextPaint);
            canvas.drawTextOnPath(str, path, (fHypot2 / 2.0f) - (this.mBounds.width() / 2), -20.0f, this.mTextPaint);
            canvas.drawLine(f4, f8, f16, f17, this.mPaintGraph);
        }

        private void drawPathScreenTicks(Canvas canvas, float f4, float f8, int i2, int i8) {
            String str = "" + (((int) (((double) (((f4 - (i2 / 2)) * 100.0f) / (MotionLayout.this.getWidth() - i2))) + 0.5d)) / 100.0f);
            getTextBounds(str, this.mTextPaint);
            canvas.drawText(str, ((f4 / 2.0f) - (this.mBounds.width() / 2)) + 0.0f, f8 - 20.0f, this.mTextPaint);
            canvas.drawLine(f4, f8, Math.min(0.0f, 1.0f), f8, this.mPaintGraph);
            String str2 = "" + (((int) (((double) (((f8 - (i8 / 2)) * 100.0f) / (MotionLayout.this.getHeight() - i8))) + 0.5d)) / 100.0f);
            getTextBounds(str2, this.mTextPaint);
            canvas.drawText(str2, 5.0f + f4, 0.0f - ((f8 / 2.0f) - (this.mBounds.height() / 2)), this.mTextPaint);
            canvas.drawLine(f4, f8, f4, Math.max(0.0f, 1.0f), this.mPaintGraph);
        }

        private void drawRectangle(Canvas canvas, MotionController motionController) {
            this.mPath.reset();
            for (int i2 = 0; i2 <= 50; i2++) {
                motionController.buildRect(i2 / 50, this.mRectangle, 0);
                Path path = this.mPath;
                float[] fArr = this.mRectangle;
                path.moveTo(fArr[0], fArr[1]);
                Path path2 = this.mPath;
                float[] fArr2 = this.mRectangle;
                path2.lineTo(fArr2[2], fArr2[3]);
                Path path3 = this.mPath;
                float[] fArr3 = this.mRectangle;
                path3.lineTo(fArr3[4], fArr3[5]);
                Path path4 = this.mPath;
                float[] fArr4 = this.mRectangle;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.mPath.close();
            }
            this.mPaint.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.mPath, this.mPaint);
            canvas.translate(-2.0f, -2.0f);
            this.mPaint.setColor(SupportMenu.CATEGORY_MASK);
            canvas.drawPath(this.mPath, this.mPaint);
        }

        private void drawTicks(Canvas canvas, int i2, int i8, MotionController motionController) {
            int width;
            int height;
            View view = motionController.mView;
            if (view != null) {
                width = view.getWidth();
                height = motionController.mView.getHeight();
            } else {
                width = 0;
                height = 0;
            }
            for (int i9 = 1; i9 < i8 - 1; i9++) {
                if (i2 != 4 || this.mPathMode[i9 - 1] != 0) {
                    float[] fArr = this.mKeyFramePoints;
                    int i10 = i9 * 2;
                    float f4 = fArr[i10];
                    float f8 = fArr[i10 + 1];
                    this.mPath.reset();
                    this.mPath.moveTo(f4, f8 + 10.0f);
                    this.mPath.lineTo(f4 + 10.0f, f8);
                    this.mPath.lineTo(f4, f8 - 10.0f);
                    this.mPath.lineTo(f4 - 10.0f, f8);
                    this.mPath.close();
                    int i11 = i9 - 1;
                    motionController.getKeyFrame(i11);
                    if (i2 == 4) {
                        int i12 = this.mPathMode[i11];
                        if (i12 == 1) {
                            drawPathRelativeTicks(canvas, f4 - 0.0f, f8 - 0.0f);
                        } else if (i12 == 0) {
                            drawPathCartesianTicks(canvas, f4 - 0.0f, f8 - 0.0f);
                        } else if (i12 == 2) {
                            drawPathScreenTicks(canvas, f4 - 0.0f, f8 - 0.0f, width, height);
                        }
                        canvas.drawPath(this.mPath, this.mFillPaint);
                    }
                    if (i2 == 2) {
                        drawPathRelativeTicks(canvas, f4 - 0.0f, f8 - 0.0f);
                    }
                    if (i2 == 3) {
                        drawPathCartesianTicks(canvas, f4 - 0.0f, f8 - 0.0f);
                    }
                    if (i2 == 6) {
                        drawPathScreenTicks(canvas, f4 - 0.0f, f8 - 0.0f, width, height);
                    }
                    canvas.drawPath(this.mPath, this.mFillPaint);
                }
            }
            float[] fArr2 = this.mPoints;
            if (fArr2.length > 1) {
                canvas.drawCircle(fArr2[0], fArr2[1], 8.0f, this.mPaintKeyframes);
                float[] fArr3 = this.mPoints;
                canvas.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.mPaintKeyframes);
            }
        }

        private void drawTranslation(Canvas canvas, float f4, float f8, float f9, float f10) {
            canvas.drawRect(f4, f8, f9, f10, this.mPaintGraph);
            canvas.drawLine(f4, f8, f9, f10, this.mPaintGraph);
        }

        public void draw(Canvas canvas, HashMap<View, MotionController> map, int i2, int i8) {
            if (map == null || map.size() == 0) {
                return;
            }
            canvas.save();
            if (!MotionLayout.this.isInEditMode() && (i8 & 1) == 2) {
                String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.mEndState) + ":" + MotionLayout.this.getProgress();
                canvas.drawText(str, 10.0f, MotionLayout.this.getHeight() - 30, this.mTextPaint);
                canvas.drawText(str, 11.0f, MotionLayout.this.getHeight() - 29, this.mPaint);
            }
            for (MotionController motionController : map.values()) {
                int drawPath = motionController.getDrawPath();
                if (i8 > 0 && drawPath == 0) {
                    drawPath = 1;
                }
                if (drawPath != 0) {
                    this.mKeyFrameCount = motionController.buildKeyFrames(this.mKeyFramePoints, this.mPathMode);
                    if (drawPath >= 1) {
                        int i9 = i2 / 16;
                        float[] fArr = this.mPoints;
                        if (fArr == null || fArr.length != i9 * 2) {
                            this.mPoints = new float[i9 * 2];
                            this.mPath = new Path();
                        }
                        int i10 = this.mShadowTranslate;
                        canvas.translate(i10, i10);
                        this.mPaint.setColor(1996488704);
                        this.mFillPaint.setColor(1996488704);
                        this.mPaintKeyframes.setColor(1996488704);
                        this.mPaintGraph.setColor(1996488704);
                        motionController.buildPath(this.mPoints, i9);
                        drawAll(canvas, drawPath, this.mKeyFrameCount, motionController);
                        this.mPaint.setColor(-21965);
                        this.mPaintKeyframes.setColor(-2067046);
                        this.mFillPaint.setColor(-2067046);
                        this.mPaintGraph.setColor(-13391360);
                        int i11 = this.mShadowTranslate;
                        canvas.translate(-i11, -i11);
                        drawAll(canvas, drawPath, this.mKeyFrameCount, motionController);
                        if (drawPath == 5) {
                            drawRectangle(canvas, motionController);
                        }
                    }
                }
            }
            canvas.restore();
        }

        public void drawAll(Canvas canvas, int i2, int i8, MotionController motionController) {
            if (i2 == 4) {
                drawPathAsConfigured(canvas);
            }
            if (i2 == 2) {
                drawPathRelative(canvas);
            }
            if (i2 == 3) {
                drawPathCartesian(canvas);
            }
            drawBasicPath(canvas);
            drawTicks(canvas, i2, i8, motionController);
        }

        public void getTextBounds(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.mBounds);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class Model {
        int mEndId;
        int mStartId;
        ConstraintWidgetContainer mLayoutStart = new ConstraintWidgetContainer();
        ConstraintWidgetContainer mLayoutEnd = new ConstraintWidgetContainer();
        ConstraintSet mStart = null;
        ConstraintSet mEnd = null;

        public Model() {
        }

        private void computeStartEndSize(int i2, int i8) {
            int optimizationLevel = MotionLayout.this.getOptimizationLevel();
            MotionLayout motionLayout = MotionLayout.this;
            if (motionLayout.mCurrentState == motionLayout.getStartState()) {
                MotionLayout motionLayout2 = MotionLayout.this;
                ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutEnd;
                ConstraintSet constraintSet = this.mEnd;
                motionLayout2.resolveSystem(constraintWidgetContainer, optimizationLevel, (constraintSet == null || constraintSet.mRotate == 0) ? i2 : i8, (constraintSet == null || constraintSet.mRotate == 0) ? i8 : i2);
                ConstraintSet constraintSet2 = this.mStart;
                if (constraintSet2 != null) {
                    MotionLayout motionLayout3 = MotionLayout.this;
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.mLayoutStart;
                    int i9 = constraintSet2.mRotate;
                    int i10 = i9 == 0 ? i2 : i8;
                    if (i9 == 0) {
                        i2 = i8;
                    }
                    motionLayout3.resolveSystem(constraintWidgetContainer2, optimizationLevel, i10, i2);
                    return;
                }
                return;
            }
            ConstraintSet constraintSet3 = this.mStart;
            if (constraintSet3 != null) {
                MotionLayout motionLayout4 = MotionLayout.this;
                ConstraintWidgetContainer constraintWidgetContainer3 = this.mLayoutStart;
                int i11 = constraintSet3.mRotate;
                motionLayout4.resolveSystem(constraintWidgetContainer3, optimizationLevel, i11 == 0 ? i2 : i8, i11 == 0 ? i8 : i2);
            }
            MotionLayout motionLayout5 = MotionLayout.this;
            ConstraintWidgetContainer constraintWidgetContainer4 = this.mLayoutEnd;
            ConstraintSet constraintSet4 = this.mEnd;
            int i12 = (constraintSet4 == null || constraintSet4.mRotate == 0) ? i2 : i8;
            if (constraintSet4 == null || constraintSet4.mRotate == 0) {
                i2 = i8;
            }
            motionLayout5.resolveSystem(constraintWidgetContainer4, optimizationLevel, i12, i2);
        }

        private void debugLayout(String str, ConstraintWidgetContainer constraintWidgetContainer) {
            View view = (View) constraintWidgetContainer.getCompanionWidget();
            StringBuilder sbX = a.x(str, " ");
            sbX.append(Debug.getName(view));
            String string = sbX.toString();
            Log.v(MotionLayout.TAG, string + "  ========= " + constraintWidgetContainer);
            int size = constraintWidgetContainer.getChildren().size();
            for (int i2 = 0; i2 < size; i2++) {
                String str2 = string + C2300e4.i.f8403d + i2 + "] ";
                ConstraintWidget constraintWidget = constraintWidgetContainer.getChildren().get(i2);
                StringBuilder sbR = androidx.camera.core.processing.util.a.r(constraintWidget.mTop.mTarget != null ? "T" : "_");
                sbR.append(constraintWidget.mBottom.mTarget != null ? "B" : "_");
                StringBuilder sbR2 = androidx.camera.core.processing.util.a.r(sbR.toString());
                sbR2.append(constraintWidget.mLeft.mTarget != null ? "L" : "_");
                StringBuilder sbR3 = androidx.camera.core.processing.util.a.r(sbR2.toString());
                sbR3.append(constraintWidget.mRight.mTarget != null ? "R" : "_");
                String string2 = sbR3.toString();
                View view2 = (View) constraintWidget.getCompanionWidget();
                String name = Debug.getName(view2);
                if (view2 instanceof TextView) {
                    StringBuilder sbX2 = a.x(name, "(");
                    sbX2.append((Object) ((TextView) view2).getText());
                    sbX2.append(")");
                    name = sbX2.toString();
                }
                Log.v(MotionLayout.TAG, str2 + "  " + name + " " + constraintWidget + " " + string2);
            }
            Log.v(MotionLayout.TAG, string + " done. ");
        }

        private void debugLayoutParam(String str, ConstraintLayout.LayoutParams layoutParams) {
            StringBuilder sbR = androidx.camera.core.processing.util.a.r(" ".concat(layoutParams.startToStart != -1 ? "SS" : "__"));
            sbR.append(layoutParams.startToEnd != -1 ? "|SE" : "|__");
            StringBuilder sbR2 = androidx.camera.core.processing.util.a.r(sbR.toString());
            sbR2.append(layoutParams.endToStart != -1 ? "|ES" : "|__");
            StringBuilder sbR3 = androidx.camera.core.processing.util.a.r(sbR2.toString());
            sbR3.append(layoutParams.endToEnd != -1 ? "|EE" : "|__");
            StringBuilder sbR4 = androidx.camera.core.processing.util.a.r(sbR3.toString());
            sbR4.append(layoutParams.leftToLeft != -1 ? "|LL" : "|__");
            StringBuilder sbR5 = androidx.camera.core.processing.util.a.r(sbR4.toString());
            sbR5.append(layoutParams.leftToRight != -1 ? "|LR" : "|__");
            StringBuilder sbR6 = androidx.camera.core.processing.util.a.r(sbR5.toString());
            sbR6.append(layoutParams.rightToLeft != -1 ? "|RL" : "|__");
            StringBuilder sbR7 = androidx.camera.core.processing.util.a.r(sbR6.toString());
            sbR7.append(layoutParams.rightToRight != -1 ? "|RR" : "|__");
            StringBuilder sbR8 = androidx.camera.core.processing.util.a.r(sbR7.toString());
            sbR8.append(layoutParams.topToTop != -1 ? "|TT" : "|__");
            StringBuilder sbR9 = androidx.camera.core.processing.util.a.r(sbR8.toString());
            sbR9.append(layoutParams.topToBottom != -1 ? "|TB" : "|__");
            StringBuilder sbR10 = androidx.camera.core.processing.util.a.r(sbR9.toString());
            sbR10.append(layoutParams.bottomToTop != -1 ? "|BT" : "|__");
            StringBuilder sbR11 = androidx.camera.core.processing.util.a.r(sbR10.toString());
            sbR11.append(layoutParams.bottomToBottom != -1 ? "|BB" : "|__");
            Log.v(MotionLayout.TAG, str + sbR11.toString());
        }

        private void debugWidget(String str, ConstraintWidget constraintWidget) {
            String strConcat;
            String strConcat2;
            String strConcat3;
            StringBuilder sb = new StringBuilder(" ");
            ConstraintAnchor constraintAnchor = constraintWidget.mTop.mTarget;
            String strConcat4 = "__";
            if (constraintAnchor != null) {
                strConcat = "T".concat(constraintAnchor.mType == ConstraintAnchor.Type.TOP ? "T" : "B");
            } else {
                strConcat = "__";
            }
            sb.append(strConcat);
            StringBuilder sbR = androidx.camera.core.processing.util.a.r(sb.toString());
            ConstraintAnchor constraintAnchor2 = constraintWidget.mBottom.mTarget;
            if (constraintAnchor2 != null) {
                strConcat2 = "B".concat(constraintAnchor2.mType != ConstraintAnchor.Type.TOP ? "B" : "T");
            } else {
                strConcat2 = "__";
            }
            sbR.append(strConcat2);
            StringBuilder sbR2 = androidx.camera.core.processing.util.a.r(sbR.toString());
            ConstraintAnchor constraintAnchor3 = constraintWidget.mLeft.mTarget;
            if (constraintAnchor3 != null) {
                strConcat3 = "L".concat(constraintAnchor3.mType == ConstraintAnchor.Type.LEFT ? "L" : "R");
            } else {
                strConcat3 = "__";
            }
            sbR2.append(strConcat3);
            StringBuilder sbR3 = androidx.camera.core.processing.util.a.r(sbR2.toString());
            ConstraintAnchor constraintAnchor4 = constraintWidget.mRight.mTarget;
            if (constraintAnchor4 != null) {
                strConcat4 = "R".concat(constraintAnchor4.mType != ConstraintAnchor.Type.LEFT ? "R" : "L");
            }
            sbR3.append(strConcat4);
            Log.v(MotionLayout.TAG, str + sbR3.toString() + " ---  " + constraintWidget);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void setupConstraintWidget(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet) {
            SparseArray<ConstraintWidget> sparseArray = new SparseArray<>();
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-2, -2);
            sparseArray.clear();
            int i2 = 0;
            sparseArray.put(0, constraintWidgetContainer);
            sparseArray.put(MotionLayout.this.getId(), constraintWidgetContainer);
            if (constraintSet != null && constraintSet.mRotate != 0) {
                MotionLayout motionLayout = MotionLayout.this;
                motionLayout.resolveSystem(this.mLayoutEnd, motionLayout.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getHeight(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getWidth(), BasicMeasure.EXACTLY));
            }
            ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
            int size = children.size();
            int i8 = 0;
            while (i8 < size) {
                ConstraintWidget constraintWidget = children.get(i8);
                i8++;
                ConstraintWidget constraintWidget2 = constraintWidget;
                constraintWidget2.setAnimated(true);
                sparseArray.put(((View) constraintWidget2.getCompanionWidget()).getId(), constraintWidget2);
            }
            ArrayList<ConstraintWidget> children2 = constraintWidgetContainer.getChildren();
            int size2 = children2.size();
            int i9 = 0;
            while (i9 < size2) {
                int i10 = i9 + 1;
                ConstraintWidget constraintWidget3 = children2.get(i9);
                View view = (View) constraintWidget3.getCompanionWidget();
                constraintSet.applyToLayoutParams(view.getId(), layoutParams);
                constraintWidget3.setWidth(constraintSet.getWidth(view.getId()));
                constraintWidget3.setHeight(constraintSet.getHeight(view.getId()));
                if (view instanceof ConstraintHelper) {
                    constraintSet.applyToHelper((ConstraintHelper) view, constraintWidget3, layoutParams, sparseArray);
                    if (view instanceof Barrier) {
                        ((Barrier) view).validateParams();
                    }
                }
                layoutParams.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                MotionLayout.this.applyConstraintsFromLayoutParams(false, view, constraintWidget3, layoutParams, sparseArray);
                if (constraintSet.getVisibilityMode(view.getId()) == 1) {
                    constraintWidget3.setVisibility(view.getVisibility());
                } else {
                    constraintWidget3.setVisibility(constraintSet.getVisibility(view.getId()));
                }
                i9 = i10;
            }
            ArrayList<ConstraintWidget> children3 = constraintWidgetContainer.getChildren();
            int size3 = children3.size();
            while (i2 < size3) {
                ConstraintWidget constraintWidget4 = children3.get(i2);
                i2++;
                ConstraintWidget constraintWidget5 = constraintWidget4;
                if (constraintWidget5 instanceof VirtualLayout) {
                    ConstraintHelper constraintHelper = (ConstraintHelper) constraintWidget5.getCompanionWidget();
                    Helper helper = (Helper) constraintWidget5;
                    constraintHelper.updatePreLayout(constraintWidgetContainer, helper, sparseArray);
                    ((VirtualLayout) helper).captureWidgets();
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x00df  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0133 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void build() {
            /*
                Method dump skipped, instruction units count: 341
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.Model.build():void");
        }

        public void copy(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidgetContainer constraintWidgetContainer2) {
            ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
            HashMap<ConstraintWidget, ConstraintWidget> map = new HashMap<>();
            map.put(constraintWidgetContainer, constraintWidgetContainer2);
            constraintWidgetContainer2.getChildren().clear();
            constraintWidgetContainer2.copy(constraintWidgetContainer, map);
            int size = children.size();
            int i2 = 0;
            int i8 = 0;
            while (i8 < size) {
                ConstraintWidget constraintWidget = children.get(i8);
                i8++;
                ConstraintWidget constraintWidget2 = constraintWidget;
                ConstraintWidget barrier = constraintWidget2 instanceof androidx.constraintlayout.core.widgets.Barrier ? new androidx.constraintlayout.core.widgets.Barrier() : constraintWidget2 instanceof Guideline ? new Guideline() : constraintWidget2 instanceof Flow ? new Flow() : constraintWidget2 instanceof Placeholder ? new Placeholder() : constraintWidget2 instanceof Helper ? new HelperWidget() : new ConstraintWidget();
                constraintWidgetContainer2.add(barrier);
                map.put(constraintWidget2, barrier);
            }
            int size2 = children.size();
            while (i2 < size2) {
                ConstraintWidget constraintWidget3 = children.get(i2);
                i2++;
                ConstraintWidget constraintWidget4 = constraintWidget3;
                map.get(constraintWidget4).copy(constraintWidget4, map);
            }
        }

        public ConstraintWidget getWidget(ConstraintWidgetContainer constraintWidgetContainer, View view) {
            if (constraintWidgetContainer.getCompanionWidget() == view) {
                return constraintWidgetContainer;
            }
            ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
            int size = children.size();
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintWidget constraintWidget = children.get(i2);
                if (constraintWidget.getCompanionWidget() == view) {
                    return constraintWidget;
                }
            }
            return null;
        }

        public void initFrom(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet, ConstraintSet constraintSet2) {
            this.mStart = constraintSet;
            this.mEnd = constraintSet2;
            this.mLayoutStart = new ConstraintWidgetContainer();
            this.mLayoutEnd = new ConstraintWidgetContainer();
            this.mLayoutStart.setMeasurer(((ConstraintLayout) MotionLayout.this).mLayoutWidget.getMeasurer());
            this.mLayoutEnd.setMeasurer(((ConstraintLayout) MotionLayout.this).mLayoutWidget.getMeasurer());
            this.mLayoutStart.removeAllChildren();
            this.mLayoutEnd.removeAllChildren();
            copy(((ConstraintLayout) MotionLayout.this).mLayoutWidget, this.mLayoutStart);
            copy(((ConstraintLayout) MotionLayout.this).mLayoutWidget, this.mLayoutEnd);
            if (MotionLayout.this.mTransitionLastPosition > 0.5d) {
                if (constraintSet != null) {
                    setupConstraintWidget(this.mLayoutStart, constraintSet);
                }
                setupConstraintWidget(this.mLayoutEnd, constraintSet2);
            } else {
                setupConstraintWidget(this.mLayoutEnd, constraintSet2);
                if (constraintSet != null) {
                    setupConstraintWidget(this.mLayoutStart, constraintSet);
                }
            }
            this.mLayoutStart.setRtl(MotionLayout.this.isRtl());
            this.mLayoutStart.updateHierarchy();
            this.mLayoutEnd.setRtl(MotionLayout.this.isRtl());
            this.mLayoutEnd.updateHierarchy();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.mLayoutStart;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    constraintWidgetContainer2.setHorizontalDimensionBehaviour(dimensionBehaviour);
                    this.mLayoutEnd.setHorizontalDimensionBehaviour(dimensionBehaviour);
                }
                if (layoutParams.height == -2) {
                    ConstraintWidgetContainer constraintWidgetContainer3 = this.mLayoutStart;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    constraintWidgetContainer3.setVerticalDimensionBehaviour(dimensionBehaviour2);
                    this.mLayoutEnd.setVerticalDimensionBehaviour(dimensionBehaviour2);
                }
            }
        }

        public boolean isNotConfiguredWith(int i2, int i8) {
            return (i2 == this.mStartId && i8 == this.mEndId) ? false : true;
        }

        public void measure(int i2, int i8) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i8);
            MotionLayout motionLayout = MotionLayout.this;
            motionLayout.mWidthMeasureMode = mode;
            motionLayout.mHeightMeasureMode = mode2;
            computeStartEndSize(i2, i8);
            if (!(MotionLayout.this.getParent() instanceof MotionLayout) || mode != 1073741824 || mode2 != 1073741824) {
                computeStartEndSize(i2, i8);
                MotionLayout.this.mStartWrapWidth = this.mLayoutStart.getWidth();
                MotionLayout.this.mStartWrapHeight = this.mLayoutStart.getHeight();
                MotionLayout.this.mEndWrapWidth = this.mLayoutEnd.getWidth();
                MotionLayout.this.mEndWrapHeight = this.mLayoutEnd.getHeight();
                MotionLayout motionLayout2 = MotionLayout.this;
                motionLayout2.mMeasureDuringTransition = (motionLayout2.mStartWrapWidth == motionLayout2.mEndWrapWidth && motionLayout2.mStartWrapHeight == motionLayout2.mEndWrapHeight) ? false : true;
            }
            MotionLayout motionLayout3 = MotionLayout.this;
            int i9 = motionLayout3.mStartWrapWidth;
            int i10 = motionLayout3.mStartWrapHeight;
            int i11 = motionLayout3.mWidthMeasureMode;
            if (i11 == Integer.MIN_VALUE || i11 == 0) {
                i9 = (int) ((motionLayout3.mPostInterpolationPosition * (motionLayout3.mEndWrapWidth - i9)) + i9);
            }
            int i12 = i9;
            int i13 = motionLayout3.mHeightMeasureMode;
            if (i13 == Integer.MIN_VALUE || i13 == 0) {
                i10 = (int) ((motionLayout3.mPostInterpolationPosition * (motionLayout3.mEndWrapHeight - i10)) + i10);
            }
            MotionLayout.this.resolveMeasuredDimension(i2, i8, i12, i10, this.mLayoutStart.isWidthMeasuredTooSmall() || this.mLayoutEnd.isWidthMeasuredTooSmall(), this.mLayoutStart.isHeightMeasuredTooSmall() || this.mLayoutEnd.isHeightMeasuredTooSmall());
        }

        public void reEvaluateState() {
            measure(MotionLayout.this.mLastWidthMeasureSpec, MotionLayout.this.mLastHeightMeasureSpec);
            MotionLayout.this.setupMotionViews();
        }

        public void setMeasuredId(int i2, int i8) {
            this.mStartId = i2;
            this.mEndId = i8;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface MotionTracker {
        void addMovement(MotionEvent motionEvent);

        void clear();

        void computeCurrentVelocity(int i2);

        void computeCurrentVelocity(int i2, float f4);

        float getXVelocity();

        float getXVelocity(int i2);

        float getYVelocity();

        float getYVelocity(int i2);

        void recycle();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class StateCache {
        float mProgress = Float.NaN;
        float mVelocity = Float.NaN;
        int mStartState = -1;
        int mEndState = -1;
        final String mKeyProgress = "motion.progress";
        final String mKeyVelocity = "motion.velocity";
        final String mKeyStartState = "motion.StartState";
        final String mKeyEndState = "motion.EndState";

        public StateCache() {
        }

        public void apply() {
            int i2 = this.mStartState;
            if (i2 != -1 || this.mEndState != -1) {
                if (i2 == -1) {
                    MotionLayout.this.transitionToState(this.mEndState);
                } else {
                    int i8 = this.mEndState;
                    if (i8 == -1) {
                        MotionLayout.this.setState(i2, -1, -1);
                    } else {
                        MotionLayout.this.setTransition(i2, i8);
                    }
                }
                MotionLayout.this.setState(TransitionState.SETUP);
            }
            if (Float.isNaN(this.mVelocity)) {
                if (Float.isNaN(this.mProgress)) {
                    return;
                }
                MotionLayout.this.setProgress(this.mProgress);
            } else {
                MotionLayout.this.setProgress(this.mProgress, this.mVelocity);
                this.mProgress = Float.NaN;
                this.mVelocity = Float.NaN;
                this.mStartState = -1;
                this.mEndState = -1;
            }
        }

        public Bundle getTransitionState() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.mProgress);
            bundle.putFloat("motion.velocity", this.mVelocity);
            bundle.putInt("motion.StartState", this.mStartState);
            bundle.putInt("motion.EndState", this.mEndState);
            return bundle;
        }

        public void recordState() {
            this.mEndState = MotionLayout.this.mEndState;
            this.mStartState = MotionLayout.this.mBeginState;
            this.mVelocity = MotionLayout.this.getVelocity();
            this.mProgress = MotionLayout.this.getProgress();
        }

        public void setEndState(int i2) {
            this.mEndState = i2;
        }

        public void setProgress(float f4) {
            this.mProgress = f4;
        }

        public void setStartState(int i2) {
            this.mStartState = i2;
        }

        public void setTransitionState(Bundle bundle) {
            this.mProgress = bundle.getFloat("motion.progress");
            this.mVelocity = bundle.getFloat("motion.velocity");
            this.mStartState = bundle.getInt("motion.StartState");
            this.mEndState = bundle.getInt("motion.EndState");
        }

        public void setVelocity(float f4) {
            this.mVelocity = f4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface TransitionListener {
        void onTransitionChange(MotionLayout motionLayout, int i2, int i8, float f4);

        void onTransitionCompleted(MotionLayout motionLayout, int i2);

        void onTransitionStarted(MotionLayout motionLayout, int i2, int i8);

        void onTransitionTrigger(MotionLayout motionLayout, int i2, boolean z2, float f4);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum TransitionState {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public MotionLayout(@NonNull Context context) {
        super(context);
        this.mProgressInterpolator = null;
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap<>();
        this.mAnimationStartTime = 0L;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new StopLogic();
        this.mDecelerateLogic = new DecelerateInterpolator();
        this.mFirstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mDecoratorsHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1L;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new KeyCache();
        this.mInLayout = false;
        this.mOnComplete = null;
        this.mScheduledTransitionTo = null;
        this.mScheduledTransitions = 0;
        this.mInRotation = false;
        this.mRotatMode = 0;
        this.mPreRotate = new HashMap<>();
        this.mTempRect = new Rect();
        this.mDelayedApply = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model();
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mInverseMatrix = null;
        this.mTransitionCompleted = new ArrayList<>();
        init(null);
    }

    private boolean callTransformedTouchEvent(View view, MotionEvent motionEvent, float f4, float f8) {
        Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            motionEvent.offsetLocation(f4, f8);
            boolean zOnTouchEvent = view.onTouchEvent(motionEvent);
            motionEvent.offsetLocation(-f4, -f8);
            return zOnTouchEvent;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(f4, f8);
        if (this.mInverseMatrix == null) {
            this.mInverseMatrix = new Matrix();
        }
        matrix.invert(this.mInverseMatrix);
        motionEventObtain.transform(this.mInverseMatrix);
        boolean zOnTouchEvent2 = view.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
        return zOnTouchEvent2;
    }

    private void checkStructure() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            Log.e(TAG, "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            return;
        }
        int startId = motionScene.getStartId();
        MotionScene motionScene2 = this.mScene;
        checkStructure(startId, motionScene2.getConstraintSet(motionScene2.getStartId()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        ArrayList<MotionScene.Transition> definedTransitions = this.mScene.getDefinedTransitions();
        int size = definedTransitions.size();
        int i2 = 0;
        while (i2 < size) {
            MotionScene.Transition transition = definedTransitions.get(i2);
            i2++;
            MotionScene.Transition transition2 = transition;
            if (transition2 == this.mScene.mCurrentTransition) {
                Log.v(TAG, "CHECK: CURRENT");
            }
            checkStructure(transition2);
            int startConstraintSetId = transition2.getStartConstraintSetId();
            int endConstraintSetId = transition2.getEndConstraintSetId();
            String name = Debug.getName(getContext(), startConstraintSetId);
            String name2 = Debug.getName(getContext(), endConstraintSetId);
            if (sparseIntArray.get(startConstraintSetId) == endConstraintSetId) {
                Log.e(TAG, "CHECK: two transitions with the same start and end " + name + "->" + name2);
            }
            if (sparseIntArray2.get(endConstraintSetId) == startConstraintSetId) {
                Log.e(TAG, "CHECK: you can't have reverse transitions" + name + "->" + name2);
            }
            sparseIntArray.put(startConstraintSetId, endConstraintSetId);
            sparseIntArray2.put(endConstraintSetId, startConstraintSetId);
            if (this.mScene.getConstraintSet(startConstraintSetId) == null) {
                Log.e(TAG, " no such constraintSetStart " + name);
            }
            if (this.mScene.getConstraintSet(endConstraintSetId) == null) {
                Log.e(TAG, " no such constraintSetEnd " + name);
            }
        }
    }

    private void computeCurrentPositions() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            MotionController motionController = this.mFrameArrayList.get(childAt);
            if (motionController != null) {
                motionController.setStartCurrentState(childAt);
            }
        }
    }

    private void debugPos() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            Log.v(TAG, " " + Debug.getLocation() + " " + Debug.getName(this) + " " + Debug.getName(getContext(), this.mCurrentState) + " " + Debug.getName(childAt) + childAt.getLeft() + " " + childAt.getTop());
        }
    }

    private void evaluateLayout() {
        boolean z2;
        float fSignum = Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
        long nanoTime = getNanoTime();
        Interpolator interpolator = this.mInterpolator;
        float interpolation = this.mTransitionLastPosition + (!(interpolator instanceof StopLogic) ? (((nanoTime - this.mTransitionLastTime) * fSignum) * 1.0E-9f) / this.mTransitionDuration : 0.0f);
        if (this.mTransitionInstantly) {
            interpolation = this.mTransitionGoalPosition;
        }
        if ((fSignum <= 0.0f || interpolation < this.mTransitionGoalPosition) && (fSignum > 0.0f || interpolation > this.mTransitionGoalPosition)) {
            z2 = false;
        } else {
            interpolation = this.mTransitionGoalPosition;
            z2 = true;
        }
        if (interpolator != null && !z2) {
            interpolation = this.mTemporalInterpolator ? interpolator.getInterpolation((nanoTime - this.mAnimationStartTime) * 1.0E-9f) : interpolator.getInterpolation(interpolation);
        }
        if ((fSignum > 0.0f && interpolation >= this.mTransitionGoalPosition) || (fSignum <= 0.0f && interpolation <= this.mTransitionGoalPosition)) {
            interpolation = this.mTransitionGoalPosition;
        }
        this.mPostInterpolationPosition = interpolation;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        Interpolator interpolator2 = this.mProgressInterpolator;
        if (interpolator2 != null) {
            interpolation = interpolator2.getInterpolation(interpolation);
        }
        float f4 = interpolation;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            MotionController motionController = this.mFrameArrayList.get(childAt);
            if (motionController != null) {
                motionController.interpolate(childAt, f4, nanoTime2, this.mKeyCache);
            }
        }
        if (this.mMeasureDuringTransition) {
            requestLayout();
        }
    }

    private void fireTransitionChange() {
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList;
        if ((this.mTransitionListener == null && ((copyOnWriteArrayList = this.mTransitionListeners) == null || copyOnWriteArrayList.isEmpty())) || this.mListenerPosition == this.mTransitionPosition) {
            return;
        }
        if (this.mListenerState != -1) {
            fireTransitionStarted();
            this.mIsAnimating = true;
        }
        this.mListenerState = -1;
        float f4 = this.mTransitionPosition;
        this.mListenerPosition = f4;
        TransitionListener transitionListener = this.mTransitionListener;
        if (transitionListener != null) {
            transitionListener.onTransitionChange(this, this.mBeginState, this.mEndState, f4);
        }
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList2 = this.mTransitionListeners;
        if (copyOnWriteArrayList2 != null) {
            Iterator<TransitionListener> it = copyOnWriteArrayList2.iterator();
            while (it.hasNext()) {
                it.next().onTransitionChange(this, this.mBeginState, this.mEndState, this.mTransitionPosition);
            }
        }
        this.mIsAnimating = true;
    }

    private void fireTransitionStarted() {
        TransitionListener transitionListener = this.mTransitionListener;
        if (transitionListener != null) {
            transitionListener.onTransitionStarted(this, this.mBeginState, this.mEndState);
        }
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList = this.mTransitionListeners;
        if (copyOnWriteArrayList != null) {
            Iterator<TransitionListener> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().onTransitionStarted(this, this.mBeginState, this.mEndState);
            }
        }
    }

    private boolean handlesTouchEvent(float f4, float f8, View view, MotionEvent motionEvent) {
        boolean z2;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                if (handlesTouchEvent((r3.getLeft() + f4) - view.getScrollX(), (r3.getTop() + f8) - view.getScrollY(), viewGroup.getChildAt(childCount), motionEvent)) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        } else {
            z2 = false;
        }
        if (!z2) {
            this.mBoundsCheck.set(f4, f8, (view.getRight() + f4) - view.getLeft(), (view.getBottom() + f8) - view.getTop());
            if ((motionEvent.getAction() != 0 || this.mBoundsCheck.contains(motionEvent.getX(), motionEvent.getY())) && callTransformedTouchEvent(view, motionEvent, -f4, -f8)) {
                return true;
            }
        }
        return z2;
    }

    private void init(AttributeSet attributeSet) {
        MotionScene motionScene;
        IS_IN_EDIT_MODE = isInEditMode();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionLayout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            boolean z2 = true;
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.MotionLayout_layoutDescription) {
                    this.mScene = new MotionScene(getContext(), this, typedArrayObtainStyledAttributes.getResourceId(index, -1));
                } else if (index == R.styleable.MotionLayout_currentState) {
                    this.mCurrentState = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                } else if (index == R.styleable.MotionLayout_motionProgress) {
                    this.mTransitionGoalPosition = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                    this.mInTransition = true;
                } else if (index == R.styleable.MotionLayout_applyMotionScene) {
                    z2 = typedArrayObtainStyledAttributes.getBoolean(index, z2);
                } else if (index == R.styleable.MotionLayout_showPaths) {
                    if (this.mDebugPath == 0) {
                        this.mDebugPath = typedArrayObtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                    }
                } else if (index == R.styleable.MotionLayout_motionDebug) {
                    this.mDebugPath = typedArrayObtainStyledAttributes.getInt(index, 0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            if (this.mScene == null) {
                Log.e(TAG, "WARNING NO app:layoutDescription tag");
            }
            if (!z2) {
                this.mScene = null;
            }
        }
        if (this.mDebugPath != 0) {
            checkStructure();
        }
        if (this.mCurrentState != -1 || (motionScene = this.mScene) == null) {
            return;
        }
        this.mCurrentState = motionScene.getStartId();
        this.mBeginState = this.mScene.getStartId();
        this.mEndState = this.mScene.getEndId();
    }

    private void processTransitionCompleted() {
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList;
        if (this.mTransitionListener == null && ((copyOnWriteArrayList = this.mTransitionListeners) == null || copyOnWriteArrayList.isEmpty())) {
            return;
        }
        int i2 = 0;
        this.mIsAnimating = false;
        ArrayList<Integer> arrayList = this.mTransitionCompleted;
        int size = arrayList.size();
        while (i2 < size) {
            Integer num = arrayList.get(i2);
            i2++;
            Integer num2 = num;
            TransitionListener transitionListener = this.mTransitionListener;
            if (transitionListener != null) {
                transitionListener.onTransitionCompleted(this, num2.intValue());
            }
            CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList2 = this.mTransitionListeners;
            if (copyOnWriteArrayList2 != null) {
                Iterator<TransitionListener> it = copyOnWriteArrayList2.iterator();
                while (it.hasNext()) {
                    it.next().onTransitionCompleted(this, num2.intValue());
                }
            }
        }
        this.mTransitionCompleted.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupMotionViews() {
        int childCount = getChildCount();
        this.mModel.build();
        this.mInTransition = true;
        SparseArray sparseArray = new SparseArray();
        int i2 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            sparseArray.put(childAt.getId(), this.mFrameArrayList.get(childAt));
        }
        int width = getWidth();
        int height = getHeight();
        int iGatPathMotionArc = this.mScene.gatPathMotionArc();
        if (iGatPathMotionArc != -1) {
            for (int i9 = 0; i9 < childCount; i9++) {
                MotionController motionController = this.mFrameArrayList.get(getChildAt(i9));
                if (motionController != null) {
                    motionController.setPathMotionArc(iGatPathMotionArc);
                }
            }
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = new int[this.mFrameArrayList.size()];
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            MotionController motionController2 = this.mFrameArrayList.get(getChildAt(i11));
            if (motionController2.getAnimateRelativeTo() != -1) {
                sparseBooleanArray.put(motionController2.getAnimateRelativeTo(), true);
                iArr[i10] = motionController2.getAnimateRelativeTo();
                i10++;
            }
        }
        if (this.mDecoratorsHelpers != null) {
            for (int i12 = 0; i12 < i10; i12++) {
                MotionController motionController3 = this.mFrameArrayList.get(findViewById(iArr[i12]));
                if (motionController3 != null) {
                    this.mScene.getKeyFrames(motionController3);
                }
            }
            ArrayList<MotionHelper> arrayList = this.mDecoratorsHelpers;
            int size = arrayList.size();
            int i13 = 0;
            while (i13 < size) {
                MotionHelper motionHelper = arrayList.get(i13);
                i13++;
                motionHelper.onPreSetup(this, this.mFrameArrayList);
            }
            for (int i14 = 0; i14 < i10; i14++) {
                MotionController motionController4 = this.mFrameArrayList.get(findViewById(iArr[i14]));
                if (motionController4 != null) {
                    motionController4.setup(width, height, this.mTransitionDuration, getNanoTime());
                }
            }
        } else {
            for (int i15 = 0; i15 < i10; i15++) {
                MotionController motionController5 = this.mFrameArrayList.get(findViewById(iArr[i15]));
                if (motionController5 != null) {
                    this.mScene.getKeyFrames(motionController5);
                    motionController5.setup(width, height, this.mTransitionDuration, getNanoTime());
                }
            }
        }
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt2 = getChildAt(i16);
            MotionController motionController6 = this.mFrameArrayList.get(childAt2);
            if (!sparseBooleanArray.get(childAt2.getId()) && motionController6 != null) {
                this.mScene.getKeyFrames(motionController6);
                motionController6.setup(width, height, this.mTransitionDuration, getNanoTime());
            }
        }
        float staggered = this.mScene.getStaggered();
        if (staggered != 0.0f) {
            boolean z2 = ((double) staggered) < 0.0d;
            float fAbs = Math.abs(staggered);
            float fMax = -3.4028235E38f;
            float fMin = Float.MAX_VALUE;
            float fMax2 = -3.4028235E38f;
            float fMin2 = Float.MAX_VALUE;
            for (int i17 = 0; i17 < childCount; i17++) {
                MotionController motionController7 = this.mFrameArrayList.get(getChildAt(i17));
                if (!Float.isNaN(motionController7.mMotionStagger)) {
                    for (int i18 = 0; i18 < childCount; i18++) {
                        MotionController motionController8 = this.mFrameArrayList.get(getChildAt(i18));
                        if (!Float.isNaN(motionController8.mMotionStagger)) {
                            fMin = Math.min(fMin, motionController8.mMotionStagger);
                            fMax = Math.max(fMax, motionController8.mMotionStagger);
                        }
                    }
                    while (i2 < childCount) {
                        MotionController motionController9 = this.mFrameArrayList.get(getChildAt(i2));
                        if (!Float.isNaN(motionController9.mMotionStagger)) {
                            motionController9.mStaggerScale = 1.0f / (1.0f - fAbs);
                            if (z2) {
                                motionController9.mStaggerOffset = fAbs - (((fMax - motionController9.mMotionStagger) / (fMax - fMin)) * fAbs);
                            } else {
                                motionController9.mStaggerOffset = fAbs - (((motionController9.mMotionStagger - fMin) * fAbs) / (fMax - fMin));
                            }
                        }
                        i2++;
                    }
                    return;
                }
                float finalX = motionController7.getFinalX();
                float finalY = motionController7.getFinalY();
                float f4 = z2 ? finalY - finalX : finalY + finalX;
                fMin2 = Math.min(fMin2, f4);
                fMax2 = Math.max(fMax2, f4);
            }
            while (i2 < childCount) {
                MotionController motionController10 = this.mFrameArrayList.get(getChildAt(i2));
                float finalX2 = motionController10.getFinalX();
                float finalY2 = motionController10.getFinalY();
                float f8 = z2 ? finalY2 - finalX2 : finalY2 + finalX2;
                motionController10.mStaggerScale = 1.0f / (1.0f - fAbs);
                motionController10.mStaggerOffset = fAbs - (((f8 - fMin2) * fAbs) / (fMax2 - fMin2));
                i2++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect toRect(ConstraintWidget constraintWidget) {
        this.mTempRect.top = constraintWidget.getY();
        this.mTempRect.left = constraintWidget.getX();
        Rect rect = this.mTempRect;
        int width = constraintWidget.getWidth();
        Rect rect2 = this.mTempRect;
        rect.right = width + rect2.left;
        int height = constraintWidget.getHeight();
        Rect rect3 = this.mTempRect;
        rect2.bottom = height + rect3.top;
        return rect3;
    }

    private static boolean willJump(float f4, float f8, float f9) {
        if (f4 > 0.0f) {
            float f10 = f4 / f9;
            return ((f4 * f10) - (((f9 * f10) * f10) / 2.0f)) + f8 > 1.0f;
        }
        float f11 = (-f4) / f9;
        return ((((f9 * f11) * f11) / 2.0f) + (f4 * f11)) + f8 < 0.0f;
    }

    public void addTransitionListener(TransitionListener transitionListener) {
        if (this.mTransitionListeners == null) {
            this.mTransitionListeners = new CopyOnWriteArrayList<>();
        }
        this.mTransitionListeners.add(transitionListener);
    }

    public void animateTo(float f4) {
        if (this.mScene == null) {
            return;
        }
        float f8 = this.mTransitionLastPosition;
        float f9 = this.mTransitionPosition;
        if (f8 != f9 && this.mTransitionInstantly) {
            this.mTransitionLastPosition = f9;
        }
        float f10 = this.mTransitionLastPosition;
        if (f10 == f4) {
            return;
        }
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = f4;
        this.mTransitionDuration = r0.getDuration() / 1000.0f;
        setProgress(this.mTransitionGoalPosition);
        this.mInterpolator = null;
        this.mProgressInterpolator = this.mScene.getInterpolator();
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        this.mInTransition = true;
        this.mTransitionPosition = f10;
        this.mTransitionLastPosition = f10;
        invalidate();
    }

    public boolean applyViewTransition(int i2, MotionController motionController) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            return motionScene.applyViewTransition(i2, motionController);
        }
        return false;
    }

    public ConstraintSet cloneConstraintSet(int i2) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        ConstraintSet constraintSet = motionScene.getConstraintSet(i2);
        ConstraintSet constraintSet2 = new ConstraintSet();
        constraintSet2.clone(constraintSet);
        return constraintSet2;
    }

    public void disableAutoTransition(boolean z2) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        motionScene.disableAutoTransition(z2);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        ViewTransitionController viewTransitionController;
        ArrayList<MotionHelper> arrayList = this.mDecoratorsHelpers;
        int i2 = 0;
        if (arrayList != null) {
            int size = arrayList.size();
            int i8 = 0;
            while (i8 < size) {
                MotionHelper motionHelper = arrayList.get(i8);
                i8++;
                motionHelper.onPreDraw(canvas);
            }
        }
        evaluate(false);
        MotionScene motionScene = this.mScene;
        if (motionScene != null && (viewTransitionController = motionScene.mViewTransitionController) != null) {
            viewTransitionController.animate();
        }
        super.dispatchDraw(canvas);
        if (this.mScene == null) {
            return;
        }
        if ((this.mDebugPath & 1) == 1 && !isInEditMode()) {
            this.mFrames++;
            long nanoTime = getNanoTime();
            long j = this.mLastDrawTime;
            if (j != -1) {
                if (nanoTime - j > 200000000) {
                    this.mLastFps = ((int) ((this.mFrames / (r5 * 1.0E-9f)) * 100.0f)) / 100.0f;
                    this.mFrames = 0;
                    this.mLastDrawTime = nanoTime;
                }
            } else {
                this.mLastDrawTime = nanoTime;
            }
            Paint paint = new Paint();
            paint.setTextSize(42.0f);
            StringBuilder sbR = androidx.camera.core.processing.util.a.r(this.mLastFps + " fps " + Debug.getState(this, this.mBeginState) + " -> ");
            sbR.append(Debug.getState(this, this.mEndState));
            sbR.append(" (progress: ");
            sbR.append(((int) (getProgress() * 1000.0f)) / 10.0f);
            sbR.append(" ) state=");
            int i9 = this.mCurrentState;
            sbR.append(i9 == -1 ? AdError.UNDEFINED_DOMAIN : Debug.getState(this, i9));
            String string = sbR.toString();
            paint.setColor(ViewCompat.MEASURED_STATE_MASK);
            canvas.drawText(string, 11.0f, getHeight() - 29, paint);
            paint.setColor(-7864184);
            canvas.drawText(string, 10.0f, getHeight() - 30, paint);
        }
        if (this.mDebugPath > 1) {
            if (this.mDevModeDraw == null) {
                this.mDevModeDraw = new DevModeDraw();
            }
            this.mDevModeDraw.draw(canvas, this.mFrameArrayList, this.mScene.getDuration(), this.mDebugPath);
        }
        ArrayList<MotionHelper> arrayList2 = this.mDecoratorsHelpers;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            while (i2 < size2) {
                MotionHelper motionHelper2 = arrayList2.get(i2);
                i2++;
                motionHelper2.onPostDraw(canvas);
            }
        }
    }

    public void enableTransition(int i2, boolean z2) {
        MotionScene.Transition transition = getTransition(i2);
        if (z2) {
            transition.setEnabled(true);
            return;
        }
        MotionScene motionScene = this.mScene;
        if (transition == motionScene.mCurrentTransition) {
            Iterator<MotionScene.Transition> it = motionScene.getTransitionsWithState(this.mCurrentState).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MotionScene.Transition next = it.next();
                if (next.isEnabled()) {
                    this.mScene.mCurrentTransition = next;
                    break;
                }
            }
        }
        transition.setEnabled(false);
    }

    public void enableViewTransition(int i2, boolean z2) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.enableViewTransition(i2, z2);
        }
    }

    public void endTrigger(boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            MotionController motionController = this.mFrameArrayList.get(getChildAt(i2));
            if (motionController != null) {
                motionController.endTrigger(z2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e2 A[PHI: r3
  0x00e2: PHI (r3v50 float) = (r3v49 float), (r3v51 float), (r3v51 float) binds: [B:47:0x00ae, B:58:0x00d6, B:60:0x00da] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void evaluate(boolean r21) {
        /*
            Method dump skipped, instruction units count: 617
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.evaluate(boolean):void");
    }

    public void fireTransitionCompleted() {
        int iIntValue;
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList;
        if ((this.mTransitionListener != null || ((copyOnWriteArrayList = this.mTransitionListeners) != null && !copyOnWriteArrayList.isEmpty())) && this.mListenerState == -1) {
            this.mListenerState = this.mCurrentState;
            if (this.mTransitionCompleted.isEmpty()) {
                iIntValue = -1;
            } else {
                ArrayList<Integer> arrayList = this.mTransitionCompleted;
                iIntValue = arrayList.get(arrayList.size() - 1).intValue();
            }
            int i2 = this.mCurrentState;
            if (iIntValue != i2 && i2 != -1) {
                this.mTransitionCompleted.add(Integer.valueOf(i2));
            }
        }
        processTransitionCompleted();
        Runnable runnable = this.mOnComplete;
        if (runnable != null) {
            runnable.run();
            this.mOnComplete = null;
        }
        int[] iArr = this.mScheduledTransitionTo;
        if (iArr == null || this.mScheduledTransitions <= 0) {
            return;
        }
        transitionToState(iArr[0]);
        int[] iArr2 = this.mScheduledTransitionTo;
        System.arraycopy(iArr2, 1, iArr2, 0, iArr2.length - 1);
        this.mScheduledTransitions--;
    }

    public void fireTrigger(int i2, boolean z2, float f4) {
        TransitionListener transitionListener = this.mTransitionListener;
        if (transitionListener != null) {
            transitionListener.onTransitionTrigger(this, i2, z2, f4);
        }
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList = this.mTransitionListeners;
        if (copyOnWriteArrayList != null) {
            Iterator<TransitionListener> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().onTransitionTrigger(this, i2, z2, f4);
            }
        }
    }

    public void getAnchorDpDt(int i2, float f4, float f8, float f9, float[] fArr) {
        HashMap<View, MotionController> map = this.mFrameArrayList;
        View viewById = getViewById(i2);
        MotionController motionController = map.get(viewById);
        if (motionController != null) {
            motionController.getDpDt(f4, f8, f9, fArr);
            float y = viewById.getY();
            this.mLastPos = f4;
            this.mLastY = y;
            return;
        }
        Log.w(TAG, "WARNING could not find view id " + (viewById == null ? a.g(i2, "") : viewById.getContext().getResources().getResourceName(i2)));
    }

    public ConstraintSet getConstraintSet(int i2) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getConstraintSet(i2);
    }

    @IdRes
    public int[] getConstraintSetIds() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getConstraintSetIds();
    }

    public String getConstraintSetNames(int i2) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.lookUpConstraintName(i2);
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    public ArrayList<MotionScene.Transition> getDefinedTransitions() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getDefinedTransitions();
    }

    public DesignTool getDesignTool() {
        if (this.mDesignTool == null) {
            this.mDesignTool = new DesignTool(this);
        }
        return this.mDesignTool;
    }

    public int getEndState() {
        return this.mEndState;
    }

    public int[] getMatchingConstraintSetIds(String... strArr) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getMatchingStateLabels(strArr);
    }

    public MotionController getMotionController(int i2) {
        return this.mFrameArrayList.get(findViewById(i2));
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.mTransitionLastPosition;
    }

    public MotionScene getScene() {
        return this.mScene;
    }

    public int getStartState() {
        return this.mBeginState;
    }

    public float getTargetPosition() {
        return this.mTransitionGoalPosition;
    }

    public MotionScene.Transition getTransition(int i2) {
        return this.mScene.getTransitionById(i2);
    }

    public Bundle getTransitionState() {
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache();
        }
        this.mStateCache.recordState();
        return this.mStateCache.getTransitionState();
    }

    public long getTransitionTimeMs() {
        if (this.mScene != null) {
            this.mTransitionDuration = r0.getDuration() / 1000.0f;
        }
        return (long) (this.mTransitionDuration * 1000.0f);
    }

    public float getVelocity() {
        return this.mLastVelocity;
    }

    public void getViewVelocity(View view, float f4, float f8, float[] fArr, int i2) {
        float interpolation;
        float[] fArr2;
        float velocity = this.mLastVelocity;
        float f9 = this.mTransitionLastPosition;
        if (this.mInterpolator != null) {
            float fSignum = Math.signum(this.mTransitionGoalPosition - f9);
            float interpolation2 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition + EPSILON);
            interpolation = this.mInterpolator.getInterpolation(this.mTransitionLastPosition);
            velocity = (((interpolation2 - interpolation) / EPSILON) * fSignum) / this.mTransitionDuration;
        } else {
            interpolation = f9;
        }
        Interpolator interpolator = this.mInterpolator;
        if (interpolator instanceof MotionInterpolator) {
            velocity = ((MotionInterpolator) interpolator).getVelocity();
        }
        MotionController motionController = this.mFrameArrayList.get(view);
        if ((i2 & 1) == 0) {
            fArr2 = fArr;
            motionController.getPostLayoutDvDp(interpolation, view.getWidth(), view.getHeight(), f4, f8, fArr2);
        } else {
            fArr2 = fArr;
            motionController.getDpDt(interpolation, f4, f8, fArr2);
        }
        if (i2 < 2) {
            fArr2[0] = fArr2[0] * velocity;
            fArr2[1] = fArr2[1] * velocity;
        }
    }

    public boolean isDelayedApplicationOfInitialState() {
        return this.mDelayedApply;
    }

    public boolean isInRotation() {
        return this.mInRotation;
    }

    public boolean isInteractionEnabled() {
        return this.mInteractionEnabled;
    }

    public boolean isViewTransitionEnabled(int i2) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            return motionScene.isViewTransitionEnabled(i2);
        }
        return false;
    }

    public void jumpToState(int i2) {
        if (!isAttachedToWindow()) {
            this.mCurrentState = i2;
        }
        if (this.mBeginState == i2) {
            setProgress(0.0f);
        } else if (this.mEndState == i2) {
            setProgress(1.0f);
        } else {
            setTransition(i2, i2);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int i2) {
        MotionScene.Transition transition;
        if (i2 == 0) {
            this.mScene = null;
            return;
        }
        try {
            MotionScene motionScene = new MotionScene(getContext(), this, i2);
            this.mScene = motionScene;
            if (this.mCurrentState == -1) {
                this.mCurrentState = motionScene.getStartId();
                this.mBeginState = this.mScene.getStartId();
                this.mEndState = this.mScene.getEndId();
            }
            if (!isAttachedToWindow()) {
                this.mScene = null;
                return;
            }
            try {
                Display display = getDisplay();
                int i8 = 0;
                this.mPreviouseRotation = display == null ? 0 : display.getRotation();
                MotionScene motionScene2 = this.mScene;
                if (motionScene2 != null) {
                    ConstraintSet constraintSet = motionScene2.getConstraintSet(this.mCurrentState);
                    this.mScene.readFallback(this);
                    ArrayList<MotionHelper> arrayList = this.mDecoratorsHelpers;
                    if (arrayList != null) {
                        int size = arrayList.size();
                        while (i8 < size) {
                            MotionHelper motionHelper = arrayList.get(i8);
                            i8++;
                            motionHelper.onFinishedMotionScene(this);
                        }
                    }
                    if (constraintSet != null) {
                        constraintSet.applyTo(this);
                    }
                    this.mBeginState = this.mCurrentState;
                }
                onNewStateAttachHandlers();
                StateCache stateCache = this.mStateCache;
                if (stateCache != null) {
                    if (this.mDelayedApply) {
                        post(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MotionLayout.this.mStateCache.apply();
                            }
                        });
                        return;
                    } else {
                        stateCache.apply();
                        return;
                    }
                }
                MotionScene motionScene3 = this.mScene;
                if (motionScene3 == null || (transition = motionScene3.mCurrentTransition) == null || transition.getAutoTransition() != 4) {
                    return;
                }
                transitionToEnd();
                setState(TransitionState.SETUP);
                setState(TransitionState.MOVING);
            } catch (Exception e) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e);
            }
        } catch (Exception e4) {
            throw new IllegalArgumentException("unable to parse MotionScene file", e4);
        }
    }

    public int lookUpConstraintId(String str) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return 0;
        }
        return motionScene.lookUpConstraintId(str);
    }

    public MotionTracker obtainVelocityTracker() {
        return MyTracker.obtain();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        MotionScene.Transition transition;
        int i2;
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            this.mPreviouseRotation = display.getRotation();
        }
        MotionScene motionScene = this.mScene;
        if (motionScene != null && (i2 = this.mCurrentState) != -1) {
            ConstraintSet constraintSet = motionScene.getConstraintSet(i2);
            this.mScene.readFallback(this);
            ArrayList<MotionHelper> arrayList = this.mDecoratorsHelpers;
            if (arrayList != null) {
                int size = arrayList.size();
                int i8 = 0;
                while (i8 < size) {
                    MotionHelper motionHelper = arrayList.get(i8);
                    i8++;
                    motionHelper.onFinishedMotionScene(this);
                }
            }
            if (constraintSet != null) {
                constraintSet.applyTo(this);
            }
            this.mBeginState = this.mCurrentState;
        }
        onNewStateAttachHandlers();
        StateCache stateCache = this.mStateCache;
        if (stateCache != null) {
            if (this.mDelayedApply) {
                post(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.4
                    @Override // java.lang.Runnable
                    public void run() {
                        MotionLayout.this.mStateCache.apply();
                    }
                });
                return;
            } else {
                stateCache.apply();
                return;
            }
        }
        MotionScene motionScene2 = this.mScene;
        if (motionScene2 == null || (transition = motionScene2.mCurrentTransition) == null || transition.getAutoTransition() != 4) {
            return;
        }
        transitionToEnd();
        setState(TransitionState.SETUP);
        setState(TransitionState.MOVING);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        TouchResponse touchResponse;
        int touchRegionId;
        RectF touchRegion;
        MotionScene motionScene = this.mScene;
        if (motionScene != null && this.mInteractionEnabled) {
            ViewTransitionController viewTransitionController = motionScene.mViewTransitionController;
            if (viewTransitionController != null) {
                viewTransitionController.touchEvent(motionEvent);
            }
            MotionScene.Transition transition = this.mScene.mCurrentTransition;
            if (transition != null && transition.isEnabled() && (touchResponse = transition.getTouchResponse()) != null && ((motionEvent.getAction() != 0 || (touchRegion = touchResponse.getTouchRegion(this, new RectF())) == null || touchRegion.contains(motionEvent.getX(), motionEvent.getY())) && (touchRegionId = touchResponse.getTouchRegionId()) != -1)) {
                View view = this.mRegionView;
                if (view == null || view.getId() != touchRegionId) {
                    this.mRegionView = findViewById(touchRegionId);
                }
                if (this.mRegionView != null) {
                    this.mBoundsCheck.set(r0.getLeft(), this.mRegionView.getTop(), this.mRegionView.getRight(), this.mRegionView.getBottom());
                    if (this.mBoundsCheck.contains(motionEvent.getX(), motionEvent.getY()) && !handlesTouchEvent(this.mRegionView.getLeft(), this.mRegionView.getTop(), this.mRegionView, motionEvent)) {
                        return onTouchEvent(motionEvent);
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i8, int i9, int i10) throws Throwable {
        MotionLayout motionLayout;
        this.mInLayout = true;
        try {
            if (this.mScene == null) {
                super.onLayout(z2, i2, i8, i9, i10);
                this.mInLayout = false;
                return;
            }
            motionLayout = this;
            int i11 = i9 - i2;
            int i12 = i10 - i8;
            try {
                if (motionLayout.mLastLayoutWidth != i11 || motionLayout.mLastLayoutHeight != i12) {
                    rebuildScene();
                    evaluate(true);
                }
                motionLayout.mLastLayoutWidth = i11;
                motionLayout.mLastLayoutHeight = i12;
                motionLayout.mOldWidth = i11;
                motionLayout.mOldHeight = i12;
                motionLayout.mInLayout = false;
                return;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            motionLayout = this;
        }
        Throwable th3 = th;
        motionLayout.mInLayout = false;
        throw th3;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i2, int i8) {
        if (this.mScene == null) {
            super.onMeasure(i2, i8);
            return;
        }
        boolean z2 = false;
        boolean z7 = (this.mLastWidthMeasureSpec == i2 && this.mLastHeightMeasureSpec == i8) ? false : true;
        if (this.mNeedsFireTransitionCompleted) {
            this.mNeedsFireTransitionCompleted = false;
            onNewStateAttachHandlers();
            processTransitionCompleted();
            z7 = true;
        }
        if (this.mDirtyHierarchy) {
            z7 = true;
        }
        this.mLastWidthMeasureSpec = i2;
        this.mLastHeightMeasureSpec = i8;
        int startId = this.mScene.getStartId();
        int endId = this.mScene.getEndId();
        if ((z7 || this.mModel.isNotConfiguredWith(startId, endId)) && this.mBeginState != -1) {
            super.onMeasure(i2, i8);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(startId), this.mScene.getConstraintSet(endId));
            this.mModel.reEvaluateState();
            this.mModel.setMeasuredId(startId, endId);
        } else {
            if (z7) {
                super.onMeasure(i2, i8);
            }
            z2 = true;
        }
        if (this.mMeasureDuringTransition || z2) {
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int width = this.mLayoutWidget.getWidth() + getPaddingRight() + getPaddingLeft();
            int height = this.mLayoutWidget.getHeight() + paddingBottom;
            int i9 = this.mWidthMeasureMode;
            if (i9 == Integer.MIN_VALUE || i9 == 0) {
                width = (int) ((this.mPostInterpolationPosition * (this.mEndWrapWidth - r8)) + this.mStartWrapWidth);
                requestLayout();
            }
            int i10 = this.mHeightMeasureMode;
            if (i10 == Integer.MIN_VALUE || i10 == 0) {
                height = (int) ((this.mPostInterpolationPosition * (this.mEndWrapHeight - r9)) + this.mStartWrapHeight);
                requestLayout();
            }
            setMeasuredDimension(width, height);
        }
        evaluateLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f4, float f8, boolean z2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f4, float f8) {
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NonNull final View view, int i2, int i8, @NonNull int[] iArr, int i9) {
        MotionScene.Transition transition;
        TouchResponse touchResponse;
        int touchRegionId;
        MotionScene motionScene = this.mScene;
        if (motionScene == null || (transition = motionScene.mCurrentTransition) == null || !transition.isEnabled()) {
            return;
        }
        int i10 = -1;
        if (!transition.isEnabled() || (touchResponse = transition.getTouchResponse()) == null || (touchRegionId = touchResponse.getTouchRegionId()) == -1 || view.getId() == touchRegionId) {
            if (motionScene.getMoveWhenScrollAtTop()) {
                TouchResponse touchResponse2 = transition.getTouchResponse();
                if (touchResponse2 != null && (touchResponse2.getFlags() & 4) != 0) {
                    i10 = i8;
                }
                float f4 = this.mTransitionPosition;
                if ((f4 == 1.0f || f4 == 0.0f) && view.canScrollVertically(i10)) {
                    return;
                }
            }
            if (transition.getTouchResponse() != null && (transition.getTouchResponse().getFlags() & 1) != 0) {
                float progressDirection = motionScene.getProgressDirection(i2, i8);
                float f8 = this.mTransitionLastPosition;
                if ((f8 <= 0.0f && progressDirection < 0.0f) || (f8 >= 1.0f && progressDirection > 0.0f)) {
                    view.setNestedScrollingEnabled(false);
                    view.post(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            view.setNestedScrollingEnabled(true);
                        }
                    });
                    return;
                }
            }
            float f9 = this.mTransitionPosition;
            long nanoTime = getNanoTime();
            float f10 = i2;
            this.mScrollTargetDX = f10;
            float f11 = i8;
            this.mScrollTargetDY = f11;
            this.mScrollTargetDT = (float) ((nanoTime - this.mScrollTargetTime) * 1.0E-9d);
            this.mScrollTargetTime = nanoTime;
            motionScene.processScrollMove(f10, f11);
            if (f9 != this.mTransitionPosition) {
                iArr[0] = i2;
                iArr[1] = i8;
            }
            evaluate(false);
            if (iArr[0] == 0 && iArr[1] == 0) {
                return;
            }
            this.mUndergoingMotion = true;
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NonNull View view, int i2, int i8, int i9, int i10, int i11) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i2, int i8) {
        this.mScrollTargetTime = getNanoTime();
        this.mScrollTargetDT = 0.0f;
        this.mScrollTargetDX = 0.0f;
        this.mScrollTargetDY = 0.0f;
    }

    public void onNewStateAttachHandlers() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        if (motionScene.autoTransition(this, this.mCurrentState)) {
            requestLayout();
            return;
        }
        int i2 = this.mCurrentState;
        if (i2 != -1) {
            this.mScene.addOnClickListeners(this, i2);
        }
        if (this.mScene.supportTouch()) {
            this.mScene.setupTouch();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i2) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.setRtl(isRtl());
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i2, int i8) {
        MotionScene.Transition transition;
        MotionScene motionScene = this.mScene;
        return (motionScene == null || (transition = motionScene.mCurrentTransition) == null || transition.getTouchResponse() == null || (this.mScene.mCurrentTransition.getTouchResponse().getFlags() & 2) != 0) ? false : true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NonNull View view, int i2) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            float f4 = this.mScrollTargetDT;
            if (f4 == 0.0f) {
                return;
            }
            motionScene.processScrollUp(this.mScrollTargetDX / f4, this.mScrollTargetDY / f4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null || !this.mInteractionEnabled || !motionScene.supportTouch()) {
            return super.onTouchEvent(motionEvent);
        }
        MotionScene.Transition transition = this.mScene.mCurrentTransition;
        if (transition != null && !transition.isEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        this.mScene.processTouchEvent(motionEvent, getCurrentState(), this);
        if (this.mScene.mCurrentTransition.isTransitionFlag(4)) {
            return this.mScene.mCurrentTransition.getTouchResponse().isDragStarted();
        }
        return true;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.mTransitionListeners == null) {
                this.mTransitionListeners = new CopyOnWriteArrayList<>();
            }
            this.mTransitionListeners.add(motionHelper);
            if (motionHelper.isUsedOnShow()) {
                if (this.mOnShowHelpers == null) {
                    this.mOnShowHelpers = new ArrayList<>();
                }
                this.mOnShowHelpers.add(motionHelper);
            }
            if (motionHelper.isUseOnHide()) {
                if (this.mOnHideHelpers == null) {
                    this.mOnHideHelpers = new ArrayList<>();
                }
                this.mOnHideHelpers.add(motionHelper);
            }
            if (motionHelper.isDecorator()) {
                if (this.mDecoratorsHelpers == null) {
                    this.mDecoratorsHelpers = new ArrayList<>();
                }
                this.mDecoratorsHelpers.add(motionHelper);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<MotionHelper> arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<MotionHelper> arrayList2 = this.mOnHideHelpers;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void parseLayoutDescription(int i2) {
        this.mConstraintLayoutSpec = null;
    }

    @Deprecated
    public void rebuildMotion() {
        Log.e(TAG, "This method is deprecated. Please call rebuildScene() instead.");
        rebuildScene();
    }

    public void rebuildScene() {
        this.mModel.reEvaluateState();
        invalidate();
    }

    public boolean removeTransitionListener(TransitionListener transitionListener) {
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList = this.mTransitionListeners;
        if (copyOnWriteArrayList == null) {
            return false;
        }
        return copyOnWriteArrayList.remove(transitionListener);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        MotionScene motionScene;
        MotionScene.Transition transition;
        if (!this.mMeasureDuringTransition && this.mCurrentState == -1 && (motionScene = this.mScene) != null && (transition = motionScene.mCurrentTransition) != null) {
            int layoutDuringTransition = transition.getLayoutDuringTransition();
            if (layoutDuringTransition == 0) {
                return;
            }
            if (layoutDuringTransition == 2) {
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    this.mFrameArrayList.get(getChildAt(i2)).remeasure();
                }
                return;
            }
        }
        super.requestLayout();
    }

    public void rotateTo(int i2, int i8) {
        this.mInRotation = true;
        this.mPreRotateWidth = getWidth();
        this.mPreRotateHeight = getHeight();
        int rotation = getDisplay().getRotation();
        this.mRotatMode = (rotation + 1) % 4 <= (this.mPreviouseRotation + 1) % 4 ? 2 : 1;
        this.mPreviouseRotation = rotation;
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            ViewState viewState = this.mPreRotate.get(childAt);
            if (viewState == null) {
                viewState = new ViewState();
                this.mPreRotate.put(childAt, viewState);
            }
            viewState.getState(childAt);
        }
        this.mBeginState = -1;
        this.mEndState = i2;
        this.mScene.setTransition(-1, i2);
        this.mModel.initFrom(this.mLayoutWidget, null, this.mScene.getConstraintSet(this.mEndState));
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        invalidate();
        transitionToEnd(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.2
            @Override // java.lang.Runnable
            public void run() {
                MotionLayout.this.mInRotation = false;
            }
        });
        if (i8 > 0) {
            this.mTransitionDuration = i8 / 1000.0f;
        }
    }

    public void scheduleTransitionTo(int i2) {
        if (getCurrentState() == -1) {
            transitionToState(i2);
            return;
        }
        int[] iArr = this.mScheduledTransitionTo;
        if (iArr == null) {
            this.mScheduledTransitionTo = new int[4];
        } else if (iArr.length <= this.mScheduledTransitions) {
            this.mScheduledTransitionTo = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.mScheduledTransitionTo;
        int i8 = this.mScheduledTransitions;
        this.mScheduledTransitions = i8 + 1;
        iArr2[i8] = i2;
    }

    public void setDebugMode(int i2) {
        this.mDebugPath = i2;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z2) {
        this.mDelayedApply = z2;
    }

    public void setInteractionEnabled(boolean z2) {
        this.mInteractionEnabled = z2;
    }

    public void setInterpolatedProgress(float f4) {
        if (this.mScene != null) {
            setState(TransitionState.MOVING);
            Interpolator interpolator = this.mScene.getInterpolator();
            if (interpolator != null) {
                setProgress(interpolator.getInterpolation(f4));
                return;
            }
        }
        setProgress(f4);
    }

    public void setOnHide(float f4) {
        ArrayList<MotionHelper> arrayList = this.mOnHideHelpers;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mOnHideHelpers.get(i2).setProgress(f4);
            }
        }
    }

    public void setOnShow(float f4) {
        ArrayList<MotionHelper> arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mOnShowHelpers.get(i2).setProgress(f4);
            }
        }
    }

    public void setProgress(float f4, float f8) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setProgress(f4);
            this.mStateCache.setVelocity(f8);
            return;
        }
        setProgress(f4);
        setState(TransitionState.MOVING);
        this.mLastVelocity = f8;
        if (f8 != 0.0f) {
            animateTo(f8 > 0.0f ? 1.0f : 0.0f);
        } else {
            if (f4 == 0.0f || f4 == 1.0f) {
                return;
            }
            animateTo(f4 > 0.5f ? 1.0f : 0.0f);
        }
    }

    public void setScene(MotionScene motionScene) {
        this.mScene = motionScene;
        motionScene.setRtl(isRtl());
        rebuildScene();
    }

    public void setStartState(int i2) {
        if (isAttachedToWindow()) {
            this.mCurrentState = i2;
            return;
        }
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache();
        }
        this.mStateCache.setStartState(i2);
        this.mStateCache.setEndState(i2);
    }

    public void setState(TransitionState transitionState) {
        TransitionState transitionState2 = TransitionState.FINISHED;
        if (transitionState == transitionState2 && this.mCurrentState == -1) {
            return;
        }
        TransitionState transitionState3 = this.mTransitionState;
        this.mTransitionState = transitionState;
        TransitionState transitionState4 = TransitionState.MOVING;
        if (transitionState3 == transitionState4 && transitionState == transitionState4) {
            fireTransitionChange();
        }
        int iOrdinal = transitionState3.ordinal();
        if (iOrdinal != 0 && iOrdinal != 1) {
            if (iOrdinal == 2 && transitionState == transitionState2) {
                fireTransitionCompleted();
                return;
            }
            return;
        }
        if (transitionState == transitionState4) {
            fireTransitionChange();
        }
        if (transitionState == transitionState2) {
            fireTransitionCompleted();
        }
    }

    public void setTransition(int i2, int i8) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setStartState(i2);
            this.mStateCache.setEndState(i8);
            return;
        }
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            this.mBeginState = i2;
            this.mEndState = i8;
            motionScene.setTransition(i2, i8);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(i2), this.mScene.getConstraintSet(i8));
            rebuildScene();
            this.mTransitionLastPosition = 0.0f;
            transitionToStart();
        }
    }

    public void setTransitionDuration(int i2) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            Log.e(TAG, "MotionScene not defined");
        } else {
            motionScene.setDuration(i2);
        }
    }

    public void setTransitionListener(TransitionListener transitionListener) {
        this.mTransitionListener = transitionListener;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache();
        }
        this.mStateCache.setTransitionState(bundle);
        if (isAttachedToWindow()) {
            this.mStateCache.apply();
        }
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        return Debug.getName(context, this.mBeginState) + "->" + Debug.getName(context, this.mEndState) + " (pos:" + this.mTransitionLastPosition + " Dpos/Dt:" + this.mLastVelocity;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void touchAnimateTo(int r10, float r11, float r12) {
        /*
            Method dump skipped, instruction units count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.touchAnimateTo(int, float, float):void");
    }

    public void touchSpringTo(float f4, float f8) {
        if (this.mScene == null || this.mTransitionLastPosition == f4) {
            return;
        }
        this.mTemporalInterpolator = true;
        this.mAnimationStartTime = getNanoTime();
        this.mTransitionDuration = this.mScene.getDuration() / 1000.0f;
        this.mTransitionGoalPosition = f4;
        this.mInTransition = true;
        this.mStopLogic.springConfig(this.mTransitionLastPosition, f4, f8, this.mScene.getSpringMass(), this.mScene.getSpringStiffiness(), this.mScene.getSpringDamping(), this.mScene.getSpringStopThreshold(), this.mScene.getSpringBoundary());
        int i2 = this.mCurrentState;
        this.mTransitionGoalPosition = f4;
        this.mCurrentState = i2;
        this.mInterpolator = this.mStopLogic;
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        invalidate();
    }

    public void transitionToEnd() {
        animateTo(1.0f);
        this.mOnComplete = null;
    }

    public void transitionToStart() {
        animateTo(0.0f);
    }

    public void transitionToState(int i2) {
        if (isAttachedToWindow()) {
            transitionToState(i2, -1, -1);
            return;
        }
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache();
        }
        this.mStateCache.setEndState(i2);
    }

    public void updateState(int i2, ConstraintSet constraintSet) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.setConstraintSet(i2, constraintSet);
        }
        updateState();
        if (this.mCurrentState == i2) {
            constraintSet.applyTo(this);
        }
    }

    public void updateStateAnimate(int i2, ConstraintSet constraintSet, int i8) {
        if (this.mScene != null && this.mCurrentState == i2) {
            updateState(R.id.view_transition, getConstraintSet(i2));
            setState(R.id.view_transition, -1, -1);
            updateState(i2, constraintSet);
            MotionScene.Transition transition = new MotionScene.Transition(-1, this.mScene, R.id.view_transition, i2);
            transition.setDuration(i8);
            setTransition(transition);
            transitionToEnd();
        }
    }

    public void viewTransition(int i2, View... viewArr) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.viewTransition(i2, viewArr);
        } else {
            Log.e(TAG, " no motionScene");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MyTracker implements MotionTracker {
        private static MyTracker sMe = new MyTracker();
        VelocityTracker mTracker;

        private MyTracker() {
        }

        public static MyTracker obtain() {
            sMe.mTracker = VelocityTracker.obtain();
            return sMe;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void addMovement(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void clear() {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int i2) {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i2);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity() {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity() {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void recycle() {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.mTracker = null;
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int i2, float f4) {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i2, f4);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity(int i2) {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity(i2);
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity(int i2) {
            if (this.mTracker != null) {
                return getYVelocity(i2);
            }
            return 0.0f;
        }
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View view, int i2, int i8, int i9, int i10, int i11, int[] iArr) {
        if (this.mUndergoingMotion || i2 != 0 || i8 != 0) {
            iArr[0] = iArr[0] + i9;
            iArr[1] = iArr[1] + i10;
        }
        this.mUndergoingMotion = false;
    }

    public void transitionToStart(Runnable runnable) {
        animateTo(0.0f);
        this.mOnComplete = runnable;
    }

    public void transitionToEnd(Runnable runnable) {
        animateTo(1.0f);
        this.mOnComplete = runnable;
    }

    public void transitionToState(int i2, int i8) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setEndState(i2);
            return;
        }
        transitionToState(i2, -1, -1, i8);
    }

    public void updateState() {
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        rebuildScene();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int i2, int i8, int i9) {
        setState(TransitionState.SETUP);
        this.mCurrentState = i2;
        this.mBeginState = -1;
        this.mEndState = -1;
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.updateConstraints(i2, i8, i9);
            return;
        }
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.getConstraintSet(i2).applyTo(this);
        }
    }

    public void setProgress(float f4) {
        if (f4 < 0.0f || f4 > 1.0f) {
            Log.w(TAG, "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setProgress(f4);
            return;
        }
        if (f4 <= 0.0f) {
            if (this.mTransitionLastPosition == 1.0f && this.mCurrentState == this.mEndState) {
                setState(TransitionState.MOVING);
            }
            this.mCurrentState = this.mBeginState;
            if (this.mTransitionLastPosition == 0.0f) {
                setState(TransitionState.FINISHED);
            }
        } else if (f4 >= 1.0f) {
            if (this.mTransitionLastPosition == 0.0f && this.mCurrentState == this.mBeginState) {
                setState(TransitionState.MOVING);
            }
            this.mCurrentState = this.mEndState;
            if (this.mTransitionLastPosition == 1.0f) {
                setState(TransitionState.FINISHED);
            }
        } else {
            this.mCurrentState = -1;
            setState(TransitionState.MOVING);
        }
        if (this.mScene == null) {
            return;
        }
        this.mTransitionInstantly = true;
        this.mTransitionGoalPosition = f4;
        this.mTransitionPosition = f4;
        this.mTransitionLastTime = -1L;
        this.mAnimationStartTime = -1L;
        this.mInterpolator = null;
        this.mInTransition = true;
        invalidate();
    }

    public void transitionToState(int i2, int i8, int i9) {
        transitionToState(i2, i8, i9, -1);
    }

    public void transitionToState(int i2, int i8, int i9, int i10) {
        StateSet stateSet;
        int iConvertToConstraintSet;
        MotionScene motionScene = this.mScene;
        if (motionScene != null && (stateSet = motionScene.mStateSet) != null && (iConvertToConstraintSet = stateSet.convertToConstraintSet(this.mCurrentState, i2, i8, i9)) != -1) {
            i2 = iConvertToConstraintSet;
        }
        int i11 = this.mCurrentState;
        if (i11 == i2) {
            return;
        }
        if (this.mBeginState == i2) {
            animateTo(0.0f);
            if (i10 > 0) {
                this.mTransitionDuration = i10 / 1000.0f;
                return;
            }
            return;
        }
        if (this.mEndState == i2) {
            animateTo(1.0f);
            if (i10 > 0) {
                this.mTransitionDuration = i10 / 1000.0f;
                return;
            }
            return;
        }
        this.mEndState = i2;
        if (i11 != -1) {
            setTransition(i11, i2);
            animateTo(1.0f);
            this.mTransitionLastPosition = 0.0f;
            transitionToEnd();
            if (i10 > 0) {
                this.mTransitionDuration = i10 / 1000.0f;
                return;
            }
            return;
        }
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionLastTime = getNanoTime();
        this.mAnimationStartTime = getNanoTime();
        this.mTransitionInstantly = false;
        this.mInterpolator = null;
        if (i10 == -1) {
            this.mTransitionDuration = this.mScene.getDuration() / 1000.0f;
        }
        this.mBeginState = -1;
        this.mScene.setTransition(-1, this.mEndState);
        SparseArray sparseArray = new SparseArray();
        if (i10 == 0) {
            this.mTransitionDuration = this.mScene.getDuration() / 1000.0f;
        } else if (i10 > 0) {
            this.mTransitionDuration = i10 / 1000.0f;
        }
        int childCount = getChildCount();
        this.mFrameArrayList.clear();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            this.mFrameArrayList.put(childAt, new MotionController(childAt));
            sparseArray.put(childAt.getId(), this.mFrameArrayList.get(childAt));
        }
        this.mInTransition = true;
        this.mModel.initFrom(this.mLayoutWidget, null, this.mScene.getConstraintSet(i2));
        rebuildScene();
        this.mModel.build();
        computeCurrentPositions();
        int width = getWidth();
        int height = getHeight();
        if (this.mDecoratorsHelpers != null) {
            for (int i13 = 0; i13 < childCount; i13++) {
                MotionController motionController = this.mFrameArrayList.get(getChildAt(i13));
                if (motionController != null) {
                    this.mScene.getKeyFrames(motionController);
                }
            }
            ArrayList<MotionHelper> arrayList = this.mDecoratorsHelpers;
            int size = arrayList.size();
            int i14 = 0;
            while (i14 < size) {
                MotionHelper motionHelper = arrayList.get(i14);
                i14++;
                motionHelper.onPreSetup(this, this.mFrameArrayList);
            }
            for (int i15 = 0; i15 < childCount; i15++) {
                MotionController motionController2 = this.mFrameArrayList.get(getChildAt(i15));
                if (motionController2 != null) {
                    motionController2.setup(width, height, this.mTransitionDuration, getNanoTime());
                }
            }
        } else {
            for (int i16 = 0; i16 < childCount; i16++) {
                MotionController motionController3 = this.mFrameArrayList.get(getChildAt(i16));
                if (motionController3 != null) {
                    this.mScene.getKeyFrames(motionController3);
                    motionController3.setup(width, height, this.mTransitionDuration, getNanoTime());
                }
            }
        }
        float staggered = this.mScene.getStaggered();
        if (staggered != 0.0f) {
            float fMin = Float.MAX_VALUE;
            float fMax = -3.4028235E38f;
            for (int i17 = 0; i17 < childCount; i17++) {
                MotionController motionController4 = this.mFrameArrayList.get(getChildAt(i17));
                float finalY = motionController4.getFinalY() + motionController4.getFinalX();
                fMin = Math.min(fMin, finalY);
                fMax = Math.max(fMax, finalY);
            }
            for (int i18 = 0; i18 < childCount; i18++) {
                MotionController motionController5 = this.mFrameArrayList.get(getChildAt(i18));
                float finalX = motionController5.getFinalX();
                float finalY2 = motionController5.getFinalY();
                motionController5.mStaggerScale = 1.0f / (1.0f - staggered);
                motionController5.mStaggerOffset = staggered - ((((finalX + finalY2) - fMin) * staggered) / (fMax - fMin));
            }
        }
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mInTransition = true;
        invalidate();
    }

    public void setTransition(int i2) {
        float f4;
        if (this.mScene != null) {
            MotionScene.Transition transition = getTransition(i2);
            this.mBeginState = transition.getStartConstraintSetId();
            this.mEndState = transition.getEndConstraintSetId();
            if (!isAttachedToWindow()) {
                if (this.mStateCache == null) {
                    this.mStateCache = new StateCache();
                }
                this.mStateCache.setStartState(this.mBeginState);
                this.mStateCache.setEndState(this.mEndState);
                return;
            }
            int i8 = this.mCurrentState;
            if (i8 == this.mBeginState) {
                f4 = 0.0f;
            } else {
                f4 = i8 == this.mEndState ? 1.0f : Float.NaN;
            }
            this.mScene.setTransition(transition);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
            rebuildScene();
            if (this.mTransitionLastPosition != f4) {
                if (f4 == 0.0f) {
                    endTrigger(true);
                    this.mScene.getConstraintSet(this.mBeginState).applyTo(this);
                } else if (f4 == 1.0f) {
                    endTrigger(false);
                    this.mScene.getConstraintSet(this.mEndState).applyTo(this);
                }
            }
            this.mTransitionLastPosition = Float.isNaN(f4) ? 0.0f : f4;
            if (Float.isNaN(f4)) {
                Log.v(TAG, Debug.getLocation() + " transitionToStart ");
                transitionToStart();
                return;
            }
            setProgress(f4);
        }
    }

    private void checkStructure(int i2, ConstraintSet constraintSet) {
        String name = Debug.getName(getContext(), i2);
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            int id = childAt.getId();
            if (id == -1) {
                StringBuilder sbY = a.y("CHECK: ", name, " ALL VIEWS SHOULD HAVE ID's ");
                sbY.append(childAt.getClass().getName());
                sbY.append(" does not!");
                Log.w(TAG, sbY.toString());
            }
            if (constraintSet.getConstraint(id) == null) {
                StringBuilder sbY2 = a.y("CHECK: ", name, " NO CONSTRAINTS for ");
                sbY2.append(Debug.getName(childAt));
                Log.w(TAG, sbY2.toString());
            }
        }
        int[] knownIds = constraintSet.getKnownIds();
        for (int i9 = 0; i9 < knownIds.length; i9++) {
            int i10 = knownIds[i9];
            String name2 = Debug.getName(getContext(), i10);
            if (findViewById(knownIds[i9]) == null) {
                Log.w(TAG, "CHECK: " + name + " NO View matches id " + name2);
            }
            if (constraintSet.getHeight(i10) == -1) {
                Log.w(TAG, a.o("CHECK: ", name, "(", name2, ") no LAYOUT_HEIGHT"));
            }
            if (constraintSet.getWidth(i10) == -1) {
                Log.w(TAG, a.o("CHECK: ", name, "(", name2, ") no LAYOUT_HEIGHT"));
            }
        }
    }

    public void setTransition(MotionScene.Transition transition) {
        this.mScene.setTransition(transition);
        setState(TransitionState.SETUP);
        if (this.mCurrentState == this.mScene.getEndId()) {
            this.mTransitionLastPosition = 1.0f;
            this.mTransitionPosition = 1.0f;
            this.mTransitionGoalPosition = 1.0f;
        } else {
            this.mTransitionLastPosition = 0.0f;
            this.mTransitionPosition = 0.0f;
            this.mTransitionGoalPosition = 0.0f;
        }
        this.mTransitionLastTime = transition.isTransitionFlag(1) ? -1L : getNanoTime();
        int startId = this.mScene.getStartId();
        int endId = this.mScene.getEndId();
        if (startId == this.mBeginState && endId == this.mEndState) {
            return;
        }
        this.mBeginState = startId;
        this.mEndState = endId;
        this.mScene.setTransition(startId, endId);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        this.mModel.setMeasuredId(this.mBeginState, this.mEndState);
        this.mModel.reEvaluateState();
        rebuildScene();
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgressInterpolator = null;
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap<>();
        this.mAnimationStartTime = 0L;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new StopLogic();
        this.mDecelerateLogic = new DecelerateInterpolator();
        this.mFirstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mDecoratorsHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1L;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new KeyCache();
        this.mInLayout = false;
        this.mOnComplete = null;
        this.mScheduledTransitionTo = null;
        this.mScheduledTransitions = 0;
        this.mInRotation = false;
        this.mRotatMode = 0;
        this.mPreRotate = new HashMap<>();
        this.mTempRect = new Rect();
        this.mDelayedApply = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model();
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mInverseMatrix = null;
        this.mTransitionCompleted = new ArrayList<>();
        init(attributeSet);
    }

    private void checkStructure(MotionScene.Transition transition) {
        if (transition.getStartConstraintSetId() == transition.getEndConstraintSetId()) {
            Log.e(TAG, "CHECK: start and end constraint set should not be the same!");
        }
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mProgressInterpolator = null;
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap<>();
        this.mAnimationStartTime = 0L;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new StopLogic();
        this.mDecelerateLogic = new DecelerateInterpolator();
        this.mFirstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mDecoratorsHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1L;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new KeyCache();
        this.mInLayout = false;
        this.mOnComplete = null;
        this.mScheduledTransitionTo = null;
        this.mScheduledTransitions = 0;
        this.mInRotation = false;
        this.mRotatMode = 0;
        this.mPreRotate = new HashMap<>();
        this.mTempRect = new Rect();
        this.mDelayedApply = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model();
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mInverseMatrix = null;
        this.mTransitionCompleted = new ArrayList<>();
        init(attributeSet);
    }
}
