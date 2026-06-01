package androidx.constraintlayout.core.state;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.camera.camera2.internal.compat.workaround.c;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.Motion;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.key.MotionKeyAttributes;
import androidx.constraintlayout.core.motion.key.MotionKeyCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.SpringStopEngine;
import androidx.constraintlayout.core.motion.utils.StopEngine;
import androidx.constraintlayout.core.motion.utils.StopLogicEngine;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class Transition implements TypedValues {
    static final int ANTICIPATE = 6;
    static final int BOUNCE = 4;
    private static final boolean DEBUG = false;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    public static final int END = 1;
    public static final int INTERPOLATED = 2;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    static final int LINEAR = 3;
    static final int OVERSHOOT = 5;
    private static final int SPLINE_STRING = -1;
    public static final int START = 0;
    int mParentEndHeight;
    int mParentEndWidth;
    int mParentInterpolateHeight;
    int mParentInterpolatedWidth;
    int mParentStartHeight;
    int mParentStartWidth;
    final CorePixelDp mToPixel;
    boolean mWrap;
    private HashMap<Integer, HashMap<String, KeyPosition>> mKeyPositions = new HashMap<>();
    private HashMap<String, WidgetState> mState = new HashMap<>();
    private TypedBundle mBundle = new TypedBundle();
    private int mDefaultInterpolator = 0;
    private String mDefaultInterpolatorString = null;
    private Easing mEasing = null;
    private int mAutoTransition = 0;
    private int mDuration = 400;
    private float mStagger = 0.0f;
    private OnSwipe mOnSwipe = null;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class KeyPosition {
        int mFrame;
        String mTarget;
        int mType;
        float mX;
        float mY;

        public KeyPosition(String str, int i2, int i8, float f4, float f8) {
            this.mTarget = str;
            this.mFrame = i2;
            this.mType = i8;
            this.mX = f4;
            this.mY = f8;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class OnSwipe {
        public static final int ANCHOR_SIDE_BOTTOM = 3;
        public static final int ANCHOR_SIDE_END = 6;
        public static final int ANCHOR_SIDE_LEFT = 1;
        public static final int ANCHOR_SIDE_MIDDLE = 4;
        public static final int ANCHOR_SIDE_RIGHT = 2;
        public static final int ANCHOR_SIDE_START = 5;
        public static final int ANCHOR_SIDE_TOP = 0;
        public static final int BOUNDARY_BOUNCE_BOTH = 3;
        public static final int BOUNDARY_BOUNCE_END = 2;
        public static final int BOUNDARY_BOUNCE_START = 1;
        public static final int BOUNDARY_OVERSHOOT = 0;
        public static final int DRAG_ANTICLOCKWISE = 7;
        public static final int DRAG_CLOCKWISE = 6;
        public static final int DRAG_DOWN = 1;
        public static final int DRAG_END = 5;
        public static final int DRAG_LEFT = 2;
        public static final int DRAG_RIGHT = 3;
        public static final int DRAG_START = 4;
        public static final int DRAG_UP = 0;
        public static final int MODE_CONTINUOUS_VELOCITY = 0;
        public static final int MODE_SPRING = 1;
        public static final int ON_UP_AUTOCOMPLETE = 0;
        public static final int ON_UP_AUTOCOMPLETE_TO_END = 2;
        public static final int ON_UP_AUTOCOMPLETE_TO_START = 1;
        public static final int ON_UP_DECELERATE = 4;
        public static final int ON_UP_DECELERATE_AND_COMPLETE = 5;
        public static final int ON_UP_NEVER_COMPLETE_TO_END = 7;
        public static final int ON_UP_NEVER_COMPLETE_TO_START = 6;
        public static final int ON_UP_STOP = 3;
        String mAnchorId;
        private int mAnchorSide;
        private StopEngine mEngine;
        String mLimitBoundsTo;
        private String mRotationCenterId;
        private long mStart;
        public static final String[] SIDES = {"top", "left", "right", "bottom", "middle", "start", "end"};
        private static final float[][] TOUCH_SIDES = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
        public static final String[] DIRECTIONS = {"up", "down", "left", "right", "start", "end", "clockwise", "anticlockwise"};
        public static final String[] MODE = {"velocity", "spring"};
        public static final String[] TOUCH_UP = {"autocomplete", "toStart", "toEnd", "stop", "decelerate", "decelerateComplete", "neverCompleteStart", "neverCompleteEnd"};
        public static final String[] BOUNDARY = {"overshoot", "bounceStart", "bounceEnd", "bounceBoth"};
        private static final float[][] TOUCH_DIRECTION = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
        private boolean mDragVertical = true;
        private int mDragDirection = 0;
        private float mDragScale = 1.0f;
        private float mDragThreshold = 10.0f;
        private int mAutoCompleteMode = 0;
        private float mMaxVelocity = 4.0f;
        private float mMaxAcceleration = 1.2f;
        private int mOnTouchUp = 0;
        private float mSpringMass = 1.0f;
        private float mSpringStiffness = 400.0f;
        private float mSpringDamping = 10.0f;
        private float mSpringStopThreshold = 0.01f;
        private float mDestination = 0.0f;
        private int mSpringBoundary = 0;

        public void config(float f4, float f8, long j, float f9) {
            SpringStopEngine springStopEngine;
            StopLogicEngine stopLogicEngine;
            StopLogicEngine.Decelerate decelerate;
            this.mStart = j;
            float fAbs = Math.abs(f8);
            float f10 = this.mMaxVelocity;
            if (fAbs > f10) {
                f8 = Math.signum(f8) * f10;
            }
            float f11 = f8;
            float destinationPosition = getDestinationPosition(f4, f11, f9);
            this.mDestination = destinationPosition;
            if (destinationPosition == f4) {
                this.mEngine = null;
                return;
            }
            if (this.mOnTouchUp == 4 && this.mAutoCompleteMode == 0) {
                StopEngine stopEngine = this.mEngine;
                if (stopEngine instanceof StopLogicEngine.Decelerate) {
                    decelerate = (StopLogicEngine.Decelerate) stopEngine;
                } else {
                    decelerate = new StopLogicEngine.Decelerate();
                    this.mEngine = decelerate;
                }
                decelerate.config(f4, this.mDestination, f11);
                return;
            }
            if (this.mAutoCompleteMode == 0) {
                StopEngine stopEngine2 = this.mEngine;
                if (stopEngine2 instanceof StopLogicEngine) {
                    stopLogicEngine = (StopLogicEngine) stopEngine2;
                } else {
                    stopLogicEngine = new StopLogicEngine();
                    this.mEngine = stopLogicEngine;
                }
                stopLogicEngine.config(f4, this.mDestination, f11, f9, this.mMaxAcceleration, this.mMaxVelocity);
                return;
            }
            StopEngine stopEngine3 = this.mEngine;
            if (stopEngine3 instanceof SpringStopEngine) {
                springStopEngine = (SpringStopEngine) stopEngine3;
            } else {
                springStopEngine = new SpringStopEngine();
                this.mEngine = springStopEngine;
            }
            springStopEngine.springConfig(f4, this.mDestination, f11, this.mSpringMass, this.mSpringStiffness, this.mSpringDamping, this.mSpringStopThreshold, this.mSpringBoundary);
        }

        public float getDestinationPosition(float f4, float f8, float f9) {
            float fAbs = (((Math.abs(f8) * 0.5f) * f8) / this.mMaxAcceleration) + f4;
            switch (this.mOnTouchUp) {
                case 1:
                    return f4 >= 1.0f ? 1.0f : 0.0f;
                case 2:
                    return f4 <= 0.0f ? 0.0f : 1.0f;
                case 3:
                    return Float.NaN;
                case 4:
                    return Math.max(0.0f, Math.min(1.0f, fAbs));
                case 5:
                    return (fAbs <= 0.2f || fAbs >= 0.8f) ? fAbs > 0.5f ? 1.0f : 0.0f : fAbs;
                case 6:
                    return 1.0f;
                default:
                    if (fAbs > 0.5d) {
                        return 1.0f;
                    }
                case 7:
                    return 0.0f;
            }
        }

        public float[] getDirection() {
            return TOUCH_DIRECTION[this.mDragDirection];
        }

        public float getScale() {
            return this.mDragScale;
        }

        public float[] getSide() {
            return TOUCH_SIDES[this.mAnchorSide];
        }

        public float getTouchUpProgress(long j) {
            return this.mEngine.isStopped() ? this.mDestination : this.mEngine.getInterpolation((j - this.mStart) * 1.0E-9f);
        }

        public boolean isNotDone(float f4) {
            StopEngine stopEngine;
            return (this.mOnTouchUp == 3 || (stopEngine = this.mEngine) == null || stopEngine.isStopped()) ? false : true;
        }

        public void printInfo() {
            if (this.mAutoCompleteMode == 0) {
                System.out.println("velocity = " + this.mEngine.getVelocity());
                System.out.println("mMaxAcceleration = " + this.mMaxAcceleration);
                System.out.println("mMaxVelocity = " + this.mMaxVelocity);
                return;
            }
            System.out.println("mSpringMass          = " + this.mSpringMass);
            System.out.println("mSpringStiffness     = " + this.mSpringStiffness);
            System.out.println("mSpringDamping       = " + this.mSpringDamping);
            System.out.println("mSpringStopThreshold = " + this.mSpringStopThreshold);
            System.out.println("mSpringBoundary      = " + this.mSpringBoundary);
        }

        public void setAnchorId(String str) {
            this.mAnchorId = str;
        }

        public void setAnchorSide(int i2) {
            this.mAnchorSide = i2;
        }

        public void setAutoCompleteMode(int i2) {
            this.mAutoCompleteMode = i2;
        }

        public void setDragDirection(int i2) {
            this.mDragDirection = i2;
            this.mDragVertical = i2 < 2;
        }

        public void setDragScale(float f4) {
            if (Float.isNaN(f4)) {
                return;
            }
            this.mDragScale = f4;
        }

        public void setDragThreshold(float f4) {
            if (Float.isNaN(f4)) {
                return;
            }
            this.mDragThreshold = f4;
        }

        public void setLimitBoundsTo(String str) {
            this.mLimitBoundsTo = str;
        }

        public void setMaxAcceleration(float f4) {
            if (Float.isNaN(f4)) {
                return;
            }
            this.mMaxAcceleration = f4;
        }

        public void setMaxVelocity(float f4) {
            if (Float.isNaN(f4)) {
                return;
            }
            this.mMaxVelocity = f4;
        }

        public void setOnTouchUp(int i2) {
            this.mOnTouchUp = i2;
        }

        public void setRotationCenterId(String str) {
            this.mRotationCenterId = str;
        }

        public void setSpringBoundary(int i2) {
            this.mSpringBoundary = i2;
        }

        public void setSpringDamping(float f4) {
            if (Float.isNaN(f4)) {
                return;
            }
            this.mSpringDamping = f4;
        }

        public void setSpringMass(float f4) {
            if (Float.isNaN(f4)) {
                return;
            }
            this.mSpringMass = f4;
        }

        public void setSpringStiffness(float f4) {
            if (Float.isNaN(f4)) {
                return;
            }
            this.mSpringStiffness = f4;
        }

        public void setSpringStopThreshold(float f4) {
            if (Float.isNaN(f4)) {
                return;
            }
            this.mSpringStopThreshold = f4;
        }
    }

    public Transition(@NonNull CorePixelDp corePixelDp) {
        this.mToPixel = corePixelDp;
    }

    private void calculateParentDimensions(float f4) {
        this.mParentInterpolatedWidth = (int) (((this.mParentEndWidth - r0) * f4) + this.mParentStartWidth + 0.5f);
        this.mParentInterpolateHeight = (int) (((this.mParentEndHeight - r0) * f4) + this.mParentStartHeight + 0.5f);
    }

    public static Interpolator getInterpolator(int i2, String str) {
        switch (i2) {
            case -1:
                return new a(str, 0);
            case 0:
                return new c(4);
            case 1:
                return new c(5);
            case 2:
                return new c(6);
            case 3:
                return new c(7);
            case 4:
                return new c(10);
            case 5:
                return new c(9);
            case 6:
                return new c(8);
            default:
                return null;
        }
    }

    private WidgetState getWidgetState(String str) {
        return this.mState.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float lambda$getInterpolator$0(String str, float f4) {
        return (float) Easing.getInterpolator(str).get(f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float lambda$getInterpolator$1(float f4) {
        return (float) Easing.getInterpolator("standard").get(f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float lambda$getInterpolator$2(float f4) {
        return (float) Easing.getInterpolator("accelerate").get(f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float lambda$getInterpolator$3(float f4) {
        return (float) Easing.getInterpolator("decelerate").get(f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float lambda$getInterpolator$4(float f4) {
        return (float) Easing.getInterpolator("linear").get(f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float lambda$getInterpolator$5(float f4) {
        return (float) Easing.getInterpolator("anticipate").get(f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float lambda$getInterpolator$6(float f4) {
        return (float) Easing.getInterpolator("overshoot").get(f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float lambda$getInterpolator$7(float f4) {
        return (float) Easing.getInterpolator("spline(0.0, 0.2, 0.4, 0.6, 0.8 ,1.0, 0.8, 1.0, 0.9, 1.0)").get(f4);
    }

    public void addCustomColor(int i2, String str, String str2, int i8) {
        getWidgetState(str, null, i2).getFrame(i2).addCustomColor(str2, i8);
    }

    public void addCustomFloat(int i2, String str, String str2, float f4) {
        getWidgetState(str, null, i2).getFrame(i2).addCustomFloat(str2, f4);
    }

    public void addKeyAttribute(String str, TypedBundle typedBundle) {
        getWidgetState(str, null, 0).setKeyAttribute(typedBundle);
    }

    public void addKeyCycle(String str, TypedBundle typedBundle) {
        getWidgetState(str, null, 0).setKeyCycle(typedBundle);
    }

    public void addKeyPosition(String str, TypedBundle typedBundle) {
        getWidgetState(str, null, 0).setKeyPosition(typedBundle);
    }

    public void calcStagger() {
        float fMin;
        float fMax;
        float f4 = this.mStagger;
        if (f4 == 0.0f) {
            return;
        }
        boolean z2 = ((double) f4) < 0.0d;
        float fAbs = Math.abs(f4);
        Iterator<String> it = this.mState.keySet().iterator();
        do {
            fMin = Float.MAX_VALUE;
            fMax = -3.4028235E38f;
            if (!it.hasNext()) {
                Iterator<String> it2 = this.mState.keySet().iterator();
                while (it2.hasNext()) {
                    Motion motion = this.mState.get(it2.next()).mMotionControl;
                    float finalY = motion.getFinalY() + motion.getFinalX();
                    fMin = Math.min(fMin, finalY);
                    fMax = Math.max(fMax, finalY);
                }
                Iterator<String> it3 = this.mState.keySet().iterator();
                while (it3.hasNext()) {
                    Motion motion2 = this.mState.get(it3.next()).mMotionControl;
                    float finalY2 = motion2.getFinalY() + motion2.getFinalX();
                    float f8 = fMax - fMin;
                    float f9 = fAbs - (((finalY2 - fMin) * fAbs) / f8);
                    if (z2) {
                        f9 = fAbs - (((fMax - finalY2) / f8) * fAbs);
                    }
                    motion2.setStaggerScale(1.0f / (1.0f - fAbs));
                    motion2.setStaggerOffset(f9);
                }
                return;
            }
        } while (Float.isNaN(this.mState.get(it.next()).mMotionControl.getMotionStagger()));
        Iterator<String> it4 = this.mState.keySet().iterator();
        while (it4.hasNext()) {
            float motionStagger = this.mState.get(it4.next()).mMotionControl.getMotionStagger();
            if (!Float.isNaN(motionStagger)) {
                fMin = Math.min(fMin, motionStagger);
                fMax = Math.max(fMax, motionStagger);
            }
        }
        Iterator<String> it5 = this.mState.keySet().iterator();
        while (it5.hasNext()) {
            Motion motion3 = this.mState.get(it5.next()).mMotionControl;
            float motionStagger2 = motion3.getMotionStagger();
            if (!Float.isNaN(motionStagger2)) {
                float f10 = 1.0f / (1.0f - fAbs);
                float f11 = fMax - fMin;
                float f12 = fAbs - (((motionStagger2 - fMin) * fAbs) / f11);
                if (z2) {
                    f12 = fAbs - (((fMax - motionStagger2) / f11) * fAbs);
                }
                motion3.setStaggerScale(f10);
                motion3.setStaggerOffset(f12);
            }
        }
    }

    public void clear() {
        this.mState.clear();
    }

    public boolean contains(String str) {
        return this.mState.containsKey(str);
    }

    public OnSwipe createOnSwipe() {
        OnSwipe onSwipe = new OnSwipe();
        this.mOnSwipe = onSwipe;
        return onSwipe;
    }

    public float dragToProgress(float f4, int i2, int i8, float f8, float f9) {
        float fAbs;
        float f10;
        Iterator<WidgetState> it = this.mState.values().iterator();
        WidgetState next = it.hasNext() ? it.next() : null;
        OnSwipe onSwipe = this.mOnSwipe;
        if (onSwipe == null || next == null) {
            if (next != null) {
                return (-f9) / next.mParentHeight;
            }
            return 1.0f;
        }
        String str = onSwipe.mAnchorId;
        if (str == null) {
            float[] direction = onSwipe.getDirection();
            int i9 = next.mParentHeight;
            float f11 = i9;
            float f12 = i9;
            float f13 = direction[0];
            return (f13 != 0.0f ? (Math.abs(f13) * f8) / f11 : (Math.abs(direction[1]) * f9) / f12) * this.mOnSwipe.getScale();
        }
        WidgetState widgetState = this.mState.get(str);
        float[] direction2 = this.mOnSwipe.getDirection();
        float[] side = this.mOnSwipe.getSide();
        float[] fArr = new float[2];
        widgetState.interpolate(i2, i8, f4, this);
        widgetState.mMotionControl.getDpDt(f4, side[0], side[1], fArr);
        float f14 = direction2[0];
        if (f14 != 0.0f) {
            fAbs = Math.abs(f14) * f8;
            f10 = fArr[0];
        } else {
            fAbs = Math.abs(direction2[1]) * f9;
            f10 = fArr[1];
        }
        return (fAbs / f10) * this.mOnSwipe.getScale();
    }

    public void fillKeyPositions(WidgetFrame widgetFrame, float[] fArr, float[] fArr2, float[] fArr3) {
        KeyPosition keyPosition;
        int i2 = 0;
        for (int i8 = 0; i8 <= 100; i8++) {
            HashMap<String, KeyPosition> map = this.mKeyPositions.get(Integer.valueOf(i8));
            if (map != null && (keyPosition = map.get(widgetFrame.widget.stringId)) != null) {
                fArr[i2] = keyPosition.mX;
                fArr2[i2] = keyPosition.mY;
                fArr3[i2] = keyPosition.mFrame;
                i2++;
            }
        }
    }

    public KeyPosition findNextPosition(String str, int i2) {
        KeyPosition keyPosition;
        while (i2 <= 100) {
            HashMap<String, KeyPosition> map = this.mKeyPositions.get(Integer.valueOf(i2));
            if (map != null && (keyPosition = map.get(str)) != null) {
                return keyPosition;
            }
            i2++;
        }
        return null;
    }

    public KeyPosition findPreviousPosition(String str, int i2) {
        KeyPosition keyPosition;
        while (i2 >= 0) {
            HashMap<String, KeyPosition> map = this.mKeyPositions.get(Integer.valueOf(i2));
            if (map != null && (keyPosition = map.get(str)) != null) {
                return keyPosition;
            }
            i2--;
        }
        return null;
    }

    public int getAutoTransition() {
        return this.mAutoTransition;
    }

    public WidgetFrame getEnd(String str) {
        WidgetState widgetState = this.mState.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.mEnd;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        return 0;
    }

    public WidgetFrame getInterpolated(String str) {
        WidgetState widgetState = this.mState.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.mInterpolated;
    }

    public int getInterpolatedHeight() {
        return this.mParentInterpolateHeight;
    }

    public int getInterpolatedWidth() {
        return this.mParentInterpolatedWidth;
    }

    public int getKeyFrames(String str, float[] fArr, int[] iArr, int[] iArr2) {
        return this.mState.get(str).mMotionControl.buildKeyFrames(fArr, iArr, iArr2);
    }

    public Motion getMotion(String str) {
        return getWidgetState(str, null, 0).mMotionControl;
    }

    public int getNumberKeyPositions(WidgetFrame widgetFrame) {
        int i2 = 0;
        for (int i8 = 0; i8 <= 100; i8++) {
            HashMap<String, KeyPosition> map = this.mKeyPositions.get(Integer.valueOf(i8));
            if (map != null && map.get(widgetFrame.widget.stringId) != null) {
                i2++;
            }
        }
        return i2;
    }

    public float[] getPath(String str) {
        WidgetState widgetState = this.mState.get(str);
        float[] fArr = new float[Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE];
        widgetState.mMotionControl.buildPath(fArr, 62);
        return fArr;
    }

    public WidgetFrame getStart(String str) {
        WidgetState widgetState = this.mState.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.mStart;
    }

    public float getTouchUpProgress(long j) {
        OnSwipe onSwipe = this.mOnSwipe;
        if (onSwipe != null) {
            return onSwipe.getTouchUpProgress(j);
        }
        return 0.0f;
    }

    public boolean hasOnSwipe() {
        return this.mOnSwipe != null;
    }

    public boolean hasPositionKeyframes() {
        return this.mKeyPositions.size() > 0;
    }

    public void interpolate(int i2, int i8, float f4) {
        if (this.mWrap) {
            calculateParentDimensions(f4);
        }
        Easing easing = this.mEasing;
        if (easing != null) {
            f4 = (float) easing.get(f4);
        }
        Iterator<String> it = this.mState.keySet().iterator();
        while (it.hasNext()) {
            this.mState.get(it.next()).interpolate(i2, i8, f4, this);
        }
    }

    public boolean isEmpty() {
        return this.mState.isEmpty();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isFirstDownAccepted(float f4, float f8) {
        OnSwipe onSwipe = this.mOnSwipe;
        if (onSwipe == null) {
            return false;
        }
        String str = onSwipe.mLimitBoundsTo;
        if (str == null) {
            return true;
        }
        WidgetState widgetState = this.mState.get(str);
        if (widgetState == null) {
            System.err.println("mLimitBoundsTo target is null");
            return false;
        }
        WidgetFrame frame = widgetState.getFrame(2);
        return f4 >= ((float) frame.left) && f4 < ((float) frame.right) && f8 >= ((float) frame.top) && f8 < ((float) frame.bottom);
    }

    public boolean isTouchNotDone(float f4) {
        return this.mOnSwipe.isNotDone(f4);
    }

    public void resetProperties() {
        this.mOnSwipe = null;
        this.mBundle.clear();
    }

    public void setTouchUp(float f4, long j, float f8, float f9) {
        OnSwipe onSwipe = this.mOnSwipe;
        if (onSwipe != null) {
            WidgetState widgetState = this.mState.get(onSwipe.mAnchorId);
            float[] fArr = new float[2];
            float[] direction = this.mOnSwipe.getDirection();
            float[] side = this.mOnSwipe.getSide();
            widgetState.mMotionControl.getDpDt(f4, side[0], side[1], fArr);
            if (Math.abs((direction[1] * fArr[1]) + (direction[0] * fArr[0])) < 0.01d) {
                fArr[0] = 0.01f;
                fArr[1] = 0.01f;
            }
            this.mOnSwipe.config(f4, (direction[0] != 0.0f ? f8 / fArr[0] : f9 / fArr[1]) * this.mOnSwipe.getScale(), j, this.mDuration * 0.001f);
        }
    }

    public void setTransitionProperties(TypedBundle typedBundle) {
        typedBundle.applyDelta(this.mBundle);
        typedBundle.applyDelta(this);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, int i8) {
        return false;
    }

    public void updateFrom(ConstraintWidgetContainer constraintWidgetContainer, int i2) {
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidgetContainer.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z2 = dimensionBehaviour == dimensionBehaviour2;
        this.mWrap = z2;
        this.mWrap = z2 | (dimensionBehaviourArr[1] == dimensionBehaviour2);
        if (i2 == 0) {
            int width = constraintWidgetContainer.getWidth();
            this.mParentStartWidth = width;
            this.mParentInterpolatedWidth = width;
            int height = constraintWidgetContainer.getHeight();
            this.mParentStartHeight = height;
            this.mParentInterpolateHeight = height;
        } else {
            this.mParentEndWidth = constraintWidgetContainer.getWidth();
            this.mParentEndHeight = constraintWidgetContainer.getHeight();
        }
        ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
        int size = children.size();
        WidgetState[] widgetStateArr = new WidgetState[size];
        for (int i8 = 0; i8 < size; i8++) {
            ConstraintWidget constraintWidget = children.get(i8);
            WidgetState widgetState = getWidgetState(constraintWidget.stringId, null, i2);
            widgetStateArr[i8] = widgetState;
            widgetState.update(constraintWidget, i2);
            String pathRelativeId = widgetState.getPathRelativeId();
            if (pathRelativeId != null) {
                widgetState.setPathRelative(getWidgetState(pathRelativeId, null, i2));
            }
        }
        calcStagger();
    }

    public void addKeyAttribute(String str, TypedBundle typedBundle, CustomVariable[] customVariableArr) {
        getWidgetState(str, null, 0).setKeyAttribute(typedBundle, customVariableArr);
    }

    public void addKeyPosition(String str, int i2, int i8, float f4, float f8) {
        TypedBundle typedBundle = new TypedBundle();
        typedBundle.add(510, 2);
        typedBundle.add(100, i2);
        typedBundle.add(506, f4);
        typedBundle.add(507, f8);
        getWidgetState(str, null, 0).setKeyPosition(typedBundle);
        KeyPosition keyPosition = new KeyPosition(str, i2, i8, f4, f8);
        HashMap<String, KeyPosition> map = this.mKeyPositions.get(Integer.valueOf(i2));
        if (map == null) {
            map = new HashMap<>();
            this.mKeyPositions.put(Integer.valueOf(i2), map);
        }
        map.put(str, keyPosition);
    }

    public WidgetState getWidgetState(String str, ConstraintWidget constraintWidget, int i2) {
        WidgetState widgetState = this.mState.get(str);
        if (widgetState == null) {
            widgetState = new WidgetState();
            this.mBundle.applyDelta(widgetState.mMotionControl);
            widgetState.mMotionWidgetStart.updateMotion(widgetState.mMotionControl);
            this.mState.put(str, widgetState);
            if (constraintWidget != null) {
                widgetState.update(constraintWidget, i2);
            }
        }
        return widgetState;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, boolean z2) {
        return false;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class WidgetState {
        Motion mMotionControl;
        boolean mNeedSetup = true;
        KeyCache mKeyCache = new KeyCache();
        int mParentHeight = -1;
        int mParentWidth = -1;
        WidgetFrame mStart = new WidgetFrame();
        WidgetFrame mEnd = new WidgetFrame();
        WidgetFrame mInterpolated = new WidgetFrame();
        MotionWidget mMotionWidgetStart = new MotionWidget(this.mStart);
        MotionWidget mMotionWidgetEnd = new MotionWidget(this.mEnd);
        MotionWidget mMotionWidgetInterpolated = new MotionWidget(this.mInterpolated);

        public WidgetState() {
            Motion motion = new Motion(this.mMotionWidgetStart);
            this.mMotionControl = motion;
            motion.setStart(this.mMotionWidgetStart);
            this.mMotionControl.setEnd(this.mMotionWidgetEnd);
        }

        public WidgetFrame getFrame(int i2) {
            return i2 == 0 ? this.mStart : i2 == 1 ? this.mEnd : this.mInterpolated;
        }

        public String getPathRelativeId() {
            return this.mMotionControl.getAnimateRelativeTo();
        }

        public void interpolate(int i2, int i8, float f4, Transition transition) {
            this.mParentHeight = i8;
            this.mParentWidth = i2;
            if (this.mNeedSetup) {
                this.mMotionControl.setup(i2, i8, 1.0f, System.nanoTime());
                this.mNeedSetup = false;
            }
            WidgetFrame.interpolate(i2, i8, this.mInterpolated, this.mStart, this.mEnd, transition, f4);
            this.mInterpolated.interpolatedPos = f4;
            this.mMotionControl.interpolate(this.mMotionWidgetInterpolated, f4, System.nanoTime(), this.mKeyCache);
        }

        public void setKeyAttribute(TypedBundle typedBundle) {
            MotionKeyAttributes motionKeyAttributes = new MotionKeyAttributes();
            typedBundle.applyDelta(motionKeyAttributes);
            this.mMotionControl.addKey(motionKeyAttributes);
        }

        public void setKeyCycle(TypedBundle typedBundle) {
            MotionKeyCycle motionKeyCycle = new MotionKeyCycle();
            typedBundle.applyDelta(motionKeyCycle);
            this.mMotionControl.addKey(motionKeyCycle);
        }

        public void setKeyPosition(TypedBundle typedBundle) {
            MotionKeyPosition motionKeyPosition = new MotionKeyPosition();
            typedBundle.applyDelta(motionKeyPosition);
            this.mMotionControl.addKey(motionKeyPosition);
        }

        public void setPathRelative(WidgetState widgetState) {
            this.mMotionControl.setupRelative(widgetState.mMotionControl);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void update(ConstraintWidget constraintWidget, int i2) {
            if (i2 == 0) {
                this.mStart.update(constraintWidget);
                MotionWidget motionWidget = this.mMotionWidgetStart;
                motionWidget.updateMotion(motionWidget);
                this.mMotionControl.setStart(this.mMotionWidgetStart);
                this.mNeedSetup = true;
            } else if (i2 == 1) {
                this.mEnd.update(constraintWidget);
                this.mMotionControl.setEnd(this.mMotionWidgetEnd);
                this.mNeedSetup = true;
            }
            this.mParentWidth = -1;
        }

        public void setKeyAttribute(TypedBundle typedBundle, CustomVariable[] customVariableArr) {
            MotionKeyAttributes motionKeyAttributes = new MotionKeyAttributes();
            typedBundle.applyDelta(motionKeyAttributes);
            if (customVariableArr != null) {
                for (int i2 = 0; i2 < customVariableArr.length; i2++) {
                    motionKeyAttributes.mCustom.put(customVariableArr[i2].getName(), customVariableArr[i2]);
                }
            }
            this.mMotionControl.addKey(motionKeyAttributes);
        }
    }

    public WidgetFrame getEnd(ConstraintWidget constraintWidget) {
        return getWidgetState(constraintWidget.stringId, null, 1).mEnd;
    }

    public WidgetFrame getInterpolated(ConstraintWidget constraintWidget) {
        return getWidgetState(constraintWidget.stringId, null, 2).mInterpolated;
    }

    public WidgetFrame getStart(ConstraintWidget constraintWidget) {
        return getWidgetState(constraintWidget.stringId, null, 0).mStart;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, float f4) {
        if (i2 != 706) {
            return false;
        }
        this.mStagger = f4;
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, String str) {
        if (i2 != 705) {
            return false;
        }
        this.mDefaultInterpolatorString = str;
        this.mEasing = Easing.getInterpolator(str);
        return false;
    }

    public Interpolator getInterpolator() {
        return getInterpolator(this.mDefaultInterpolator, this.mDefaultInterpolatorString);
    }
}
