package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class ViewDragHelper {
    private static final int BASE_SETTLE_DURATION = 256;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "ViewDragHelper";
    private static final Interpolator sInterpolator = new Interpolator() { // from class: androidx.customview.widget.ViewDragHelper.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            float f8 = f4 - 1.0f;
            return (f8 * f8 * f8 * f8 * f8) + 1.0f;
        }
    };
    private final Callback mCallback;
    private View mCapturedView;
    private final int mDefaultEdgeSize;
    private int mDragState;
    private int[] mEdgeDragsInProgress;
    private int[] mEdgeDragsLocked;
    private int mEdgeSize;
    private int[] mInitialEdgesTouched;
    private float[] mInitialMotionX;
    private float[] mInitialMotionY;
    private float[] mLastMotionX;
    private float[] mLastMotionY;
    private float mMaxVelocity;
    private float mMinVelocity;
    private final ViewGroup mParentView;
    private int mPointersDown;
    private boolean mReleaseInProgress;
    private OverScroller mScroller;
    private int mTouchSlop;
    private int mTrackingEdges;
    private VelocityTracker mVelocityTracker;
    private int mActivePointerId = -1;
    private final Runnable mSetIdleRunnable = new Runnable() { // from class: androidx.customview.widget.ViewDragHelper.2
        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper.this.setDragState(0);
        }
    };

    private ViewDragHelper(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (callback == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.mParentView = viewGroup;
        this.mCallback = callback;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i2 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.mDefaultEdgeSize = i2;
        this.mEdgeSize = i2;
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMaxVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mMinVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mScroller = new OverScroller(context, sInterpolator);
    }

    private boolean checkNewEdgeDrag(float f4, float f8, int i2, int i8) {
        float fAbs = Math.abs(f4);
        float fAbs2 = Math.abs(f8);
        if ((this.mInitialEdgesTouched[i2] & i8) == i8 && (this.mTrackingEdges & i8) != 0 && (this.mEdgeDragsLocked[i2] & i8) != i8 && (this.mEdgeDragsInProgress[i2] & i8) != i8) {
            int i9 = this.mTouchSlop;
            if (fAbs > i9 || fAbs2 > i9) {
                if (fAbs < fAbs2 * 0.5f && this.mCallback.onEdgeLock(i8)) {
                    int[] iArr = this.mEdgeDragsLocked;
                    iArr[i2] = iArr[i2] | i8;
                    return false;
                }
                if ((this.mEdgeDragsInProgress[i2] & i8) == 0 && fAbs > this.mTouchSlop) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0046 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean checkTouchSlop(android.view.View r5, float r6, float r7) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L4
            goto L47
        L4:
            androidx.customview.widget.ViewDragHelper$Callback r1 = r4.mCallback
            int r1 = r1.getViewHorizontalDragRange(r5)
            r2 = 1
            if (r1 <= 0) goto Lf
            r1 = r2
            goto L10
        Lf:
            r1 = r0
        L10:
            androidx.customview.widget.ViewDragHelper$Callback r3 = r4.mCallback
            int r5 = r3.getViewVerticalDragRange(r5)
            if (r5 <= 0) goto L1a
            r5 = r2
            goto L1b
        L1a:
            r5 = r0
        L1b:
            if (r1 == 0) goto L2b
            if (r5 == 0) goto L2b
            float r6 = r6 * r6
            float r7 = r7 * r7
            float r7 = r7 + r6
            int r5 = r4.mTouchSlop
            int r5 = r5 * r5
            float r5 = (float) r5
            int r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r5 <= 0) goto L47
            goto L46
        L2b:
            if (r1 == 0) goto L39
            float r5 = java.lang.Math.abs(r6)
            int r6 = r4.mTouchSlop
            float r6 = (float) r6
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L47
            goto L46
        L39:
            if (r5 == 0) goto L47
            float r5 = java.lang.Math.abs(r7)
            int r6 = r4.mTouchSlop
            float r6 = (float) r6
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L47
        L46:
            return r2
        L47:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ViewDragHelper.checkTouchSlop(android.view.View, float, float):boolean");
    }

    private int clampMag(int i2, int i8, int i9) {
        int iAbs = Math.abs(i2);
        if (iAbs < i8) {
            return 0;
        }
        return iAbs > i9 ? i2 > 0 ? i9 : -i9 : i2;
    }

    private void clearMotionHistory() {
        float[] fArr = this.mInitialMotionX;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.mInitialMotionY, 0.0f);
        Arrays.fill(this.mLastMotionX, 0.0f);
        Arrays.fill(this.mLastMotionY, 0.0f);
        Arrays.fill(this.mInitialEdgesTouched, 0);
        Arrays.fill(this.mEdgeDragsInProgress, 0);
        Arrays.fill(this.mEdgeDragsLocked, 0);
        this.mPointersDown = 0;
    }

    private int computeAxisDuration(int i2, int i8, int i9) {
        if (i2 == 0) {
            return 0;
        }
        int width = this.mParentView.getWidth();
        float f4 = width / 2;
        float fDistanceInfluenceForSnapDuration = (distanceInfluenceForSnapDuration(Math.min(1.0f, Math.abs(i2) / width)) * f4) + f4;
        int iAbs = Math.abs(i8);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fDistanceInfluenceForSnapDuration / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i2) / i9) + 1.0f) * 256.0f), 600);
    }

    private int computeSettleDuration(View view, int i2, int i8, int i9, int i10) {
        float f4;
        float f8;
        float f9;
        float f10;
        int iClampMag = clampMag(i9, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int iClampMag2 = clampMag(i10, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int iAbs = Math.abs(i2);
        int iAbs2 = Math.abs(i8);
        int iAbs3 = Math.abs(iClampMag);
        int iAbs4 = Math.abs(iClampMag2);
        int i11 = iAbs3 + iAbs4;
        int i12 = iAbs + iAbs2;
        if (iClampMag != 0) {
            f4 = iAbs3;
            f8 = i11;
        } else {
            f4 = iAbs;
            f8 = i12;
        }
        float f11 = f4 / f8;
        if (iClampMag2 != 0) {
            f9 = iAbs4;
            f10 = i11;
        } else {
            f9 = iAbs2;
            f10 = i12;
        }
        return (int) ((computeAxisDuration(i8, iClampMag2, this.mCallback.getViewVerticalDragRange(view)) * (f9 / f10)) + (computeAxisDuration(i2, iClampMag, this.mCallback.getViewHorizontalDragRange(view)) * f11));
    }

    public static ViewDragHelper create(@NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    private void dispatchViewReleased(float f4, float f8) {
        this.mReleaseInProgress = true;
        this.mCallback.onViewReleased(this.mCapturedView, f4, f8);
        this.mReleaseInProgress = false;
        if (this.mDragState == 1) {
            setDragState(0);
        }
    }

    private float distanceInfluenceForSnapDuration(float f4) {
        return (float) Math.sin((f4 - 0.5f) * 0.47123894f);
    }

    private void dragTo(int i2, int i8, int i9, int i10) {
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        if (i9 != 0) {
            i2 = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, i2, i9);
            ViewCompat.offsetLeftAndRight(this.mCapturedView, i2 - left);
        }
        int i11 = i2;
        if (i10 != 0) {
            i8 = this.mCallback.clampViewPositionVertical(this.mCapturedView, i8, i10);
            ViewCompat.offsetTopAndBottom(this.mCapturedView, i8 - top);
        }
        int i12 = i8;
        if (i9 == 0 && i10 == 0) {
            return;
        }
        this.mCallback.onViewPositionChanged(this.mCapturedView, i11, i12, i11 - left, i12 - top);
    }

    private void ensureMotionHistorySizeForId(int i2) {
        float[] fArr = this.mInitialMotionX;
        if (fArr == null || fArr.length <= i2) {
            int i8 = i2 + 1;
            float[] fArr2 = new float[i8];
            float[] fArr3 = new float[i8];
            float[] fArr4 = new float[i8];
            float[] fArr5 = new float[i8];
            int[] iArr = new int[i8];
            int[] iArr2 = new int[i8];
            int[] iArr3 = new int[i8];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.mInitialMotionY;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.mLastMotionX;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.mLastMotionY;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.mInitialEdgesTouched;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.mEdgeDragsInProgress;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.mEdgeDragsLocked;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.mInitialMotionX = fArr2;
            this.mInitialMotionY = fArr3;
            this.mLastMotionX = fArr4;
            this.mLastMotionY = fArr5;
            this.mInitialEdgesTouched = iArr;
            this.mEdgeDragsInProgress = iArr2;
            this.mEdgeDragsLocked = iArr3;
        }
    }

    private boolean forceSettleCapturedViewAt(int i2, int i8, int i9, int i10) {
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        int i11 = i2 - left;
        int i12 = i8 - top;
        if (i11 == 0 && i12 == 0) {
            this.mScroller.abortAnimation();
            setDragState(0);
            return false;
        }
        this.mScroller.startScroll(left, top, i11, i12, computeSettleDuration(this.mCapturedView, i11, i12, i9, i10));
        setDragState(2);
        return true;
    }

    private int getEdgesTouched(int i2, int i8) {
        int i9 = i2 < this.mParentView.getLeft() + this.mEdgeSize ? 1 : 0;
        if (i8 < this.mParentView.getTop() + this.mEdgeSize) {
            i9 |= 4;
        }
        if (i2 > this.mParentView.getRight() - this.mEdgeSize) {
            i9 |= 2;
        }
        return i8 > this.mParentView.getBottom() - this.mEdgeSize ? i9 | 8 : i9;
    }

    private boolean isValidPointerForActionMove(int i2) {
        if (isPointerDown(i2)) {
            return true;
        }
        Log.e(TAG, "Ignoring pointerId=" + i2 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void releaseViewForPointerUp() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
        dispatchViewReleased(clampMag(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), clampMag(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.customview.widget.ViewDragHelper$Callback] */
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
    private void reportNewEdgeDrags(float f4, float f8, int i2) {
        boolean zCheckNewEdgeDrag = checkNewEdgeDrag(f4, f8, i2, 1);
        ?? r02 = zCheckNewEdgeDrag;
        if (checkNewEdgeDrag(f8, f4, i2, 4)) {
            r02 = (zCheckNewEdgeDrag ? 1 : 0) | 4;
        }
        ?? r03 = r02;
        if (checkNewEdgeDrag(f4, f8, i2, 2)) {
            r03 = (r02 == true ? 1 : 0) | 2;
        }
        ?? r04 = r03;
        if (checkNewEdgeDrag(f8, f4, i2, 8)) {
            r04 = (r03 == true ? 1 : 0) | 8;
        }
        if (r04 != 0) {
            int[] iArr = this.mEdgeDragsInProgress;
            iArr[i2] = iArr[i2] | r04;
            this.mCallback.onEdgeDragStarted(r04, i2);
        }
    }

    private void saveInitialMotion(float f4, float f8, int i2) {
        ensureMotionHistorySizeForId(i2);
        float[] fArr = this.mInitialMotionX;
        this.mLastMotionX[i2] = f4;
        fArr[i2] = f4;
        float[] fArr2 = this.mInitialMotionY;
        this.mLastMotionY[i2] = f8;
        fArr2[i2] = f8;
        this.mInitialEdgesTouched[i2] = getEdgesTouched((int) f4, (int) f8);
        this.mPointersDown |= 1 << i2;
    }

    private void saveLastMotion(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = motionEvent.getPointerId(i2);
            if (isValidPointerForActionMove(pointerId)) {
                float x2 = motionEvent.getX(i2);
                float y = motionEvent.getY(i2);
                this.mLastMotionX[pointerId] = x2;
                this.mLastMotionY[pointerId] = y;
            }
        }
    }

    public void abort() {
        cancel();
        if (this.mDragState == 2) {
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            this.mScroller.abortAnimation();
            int currX2 = this.mScroller.getCurrX();
            int currY2 = this.mScroller.getCurrY();
            this.mCallback.onViewPositionChanged(this.mCapturedView, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        setDragState(0);
    }

    public boolean canScroll(@NonNull View view, boolean z2, int i2, int i8, int i9, int i10) {
        int i11;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i12 = i9 + scrollX;
                if (i12 >= childAt.getLeft() && i12 < childAt.getRight() && (i11 = i10 + scrollY) >= childAt.getTop() && i11 < childAt.getBottom() && canScroll(childAt, true, i2, i8, i12 - childAt.getLeft(), i11 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (z2) {
            return view.canScrollHorizontally(-i2) || view.canScrollVertically(-i8);
        }
        return false;
    }

    public void cancel() {
        this.mActivePointerId = -1;
        clearMotionHistory();
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void captureChildView(@NonNull View view, int i2) {
        if (view.getParent() != this.mParentView) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.mParentView + ")");
        }
        this.mCapturedView = view;
        this.mActivePointerId = i2;
        this.mCallback.onViewCaptured(view, i2);
        setDragState(1);
    }

    public boolean continueSettling(boolean z2) {
        if (this.mDragState == 2) {
            boolean zComputeScrollOffset = this.mScroller.computeScrollOffset();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            int left = currX - this.mCapturedView.getLeft();
            int top = currY - this.mCapturedView.getTop();
            if (left != 0) {
                ViewCompat.offsetLeftAndRight(this.mCapturedView, left);
            }
            if (top != 0) {
                ViewCompat.offsetTopAndBottom(this.mCapturedView, top);
            }
            if (left != 0 || top != 0) {
                this.mCallback.onViewPositionChanged(this.mCapturedView, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.mScroller.getFinalX() && currY == this.mScroller.getFinalY()) {
                this.mScroller.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                if (z2) {
                    this.mParentView.post(this.mSetIdleRunnable);
                } else {
                    setDragState(0);
                }
            }
        }
        return this.mDragState == 2;
    }

    @Nullable
    public View findTopChildUnder(int i2, int i8) {
        for (int childCount = this.mParentView.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(childCount));
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i8 >= childAt.getTop() && i8 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void flingCapturedView(int i2, int i8, int i9, int i10) {
        if (!this.mReleaseInProgress) {
            throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
        }
        this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId), i2, i9, i8, i10);
        setDragState(2);
    }

    public int getActivePointerId() {
        return this.mActivePointerId;
    }

    @Nullable
    public View getCapturedView() {
        return this.mCapturedView;
    }

    @Px
    public int getDefaultEdgeSize() {
        return this.mDefaultEdgeSize;
    }

    @Px
    public int getEdgeSize() {
        return this.mEdgeSize;
    }

    public float getMinVelocity() {
        return this.mMinVelocity;
    }

    @Px
    public int getTouchSlop() {
        return this.mTouchSlop;
    }

    public int getViewDragState() {
        return this.mDragState;
    }

    public boolean isCapturedViewUnder(int i2, int i8) {
        return isViewUnder(this.mCapturedView, i2, i8);
    }

    public boolean isEdgeTouched(int i2) {
        int length = this.mInitialEdgesTouched.length;
        for (int i8 = 0; i8 < length; i8++) {
            if (isEdgeTouched(i2, i8)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPointerDown(int i2) {
        return ((1 << i2) & this.mPointersDown) != 0;
    }

    public boolean isViewUnder(@Nullable View view, int i2, int i8) {
        return view != null && i2 >= view.getLeft() && i2 < view.getRight() && i8 >= view.getTop() && i8 < view.getBottom();
    }

    public void processTouchEvent(@NonNull MotionEvent motionEvent) {
        int i2;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int i8 = 0;
        if (actionMasked == 0) {
            float x2 = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewFindTopChildUnder = findTopChildUnder((int) x2, (int) y);
            saveInitialMotion(x2, y, pointerId);
            tryCaptureViewForDrag(viewFindTopChildUnder, pointerId);
            int i9 = this.mInitialEdgesTouched[pointerId];
            int i10 = this.mTrackingEdges;
            if ((i9 & i10) != 0) {
                this.mCallback.onEdgeTouched(i9 & i10, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.mDragState == 1) {
                releaseViewForPointerUp();
            }
            cancel();
            return;
        }
        if (actionMasked == 2) {
            if (this.mDragState == 1) {
                if (isValidPointerForActionMove(this.mActivePointerId)) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    float x7 = motionEvent.getX(iFindPointerIndex);
                    float y2 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.mLastMotionX;
                    int i11 = this.mActivePointerId;
                    int i12 = (int) (x7 - fArr[i11]);
                    int i13 = (int) (y2 - this.mLastMotionY[i11]);
                    dragTo(this.mCapturedView.getLeft() + i12, this.mCapturedView.getTop() + i13, i12, i13);
                    saveLastMotion(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i8 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i8);
                if (isValidPointerForActionMove(pointerId2)) {
                    float x8 = motionEvent.getX(i8);
                    float y7 = motionEvent.getY(i8);
                    float f4 = x8 - this.mInitialMotionX[pointerId2];
                    float f8 = y7 - this.mInitialMotionY[pointerId2];
                    reportNewEdgeDrags(f4, f8, pointerId2);
                    if (this.mDragState != 1) {
                        View viewFindTopChildUnder2 = findTopChildUnder((int) x8, (int) y7);
                        if (checkTouchSlop(viewFindTopChildUnder2, f4, f8) && tryCaptureViewForDrag(viewFindTopChildUnder2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i8++;
            }
            saveLastMotion(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.mDragState == 1) {
                dispatchViewReleased(0.0f, 0.0f);
            }
            cancel();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x9 = motionEvent.getX(actionIndex);
            float y8 = motionEvent.getY(actionIndex);
            saveInitialMotion(x9, y8, pointerId3);
            if (this.mDragState != 0) {
                if (isCapturedViewUnder((int) x9, (int) y8)) {
                    tryCaptureViewForDrag(this.mCapturedView, pointerId3);
                    return;
                }
                return;
            } else {
                tryCaptureViewForDrag(findTopChildUnder((int) x9, (int) y8), pointerId3);
                int i14 = this.mInitialEdgesTouched[pointerId3];
                int i15 = this.mTrackingEdges;
                if ((i14 & i15) != 0) {
                    this.mCallback.onEdgeTouched(i14 & i15, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.mDragState == 1 && pointerId4 == this.mActivePointerId) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i8 >= pointerCount2) {
                    i2 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i8);
                if (pointerId5 != this.mActivePointerId) {
                    View viewFindTopChildUnder3 = findTopChildUnder((int) motionEvent.getX(i8), (int) motionEvent.getY(i8));
                    View view = this.mCapturedView;
                    if (viewFindTopChildUnder3 == view && tryCaptureViewForDrag(view, pointerId5)) {
                        i2 = this.mActivePointerId;
                        break;
                    }
                }
                i8++;
            }
            if (i2 == -1) {
                releaseViewForPointerUp();
            }
        }
        clearMotionHistory(pointerId4);
    }

    public void setDragState(int i2) {
        this.mParentView.removeCallbacks(this.mSetIdleRunnable);
        if (this.mDragState != i2) {
            this.mDragState = i2;
            this.mCallback.onViewDragStateChanged(i2);
            if (this.mDragState == 0) {
                this.mCapturedView = null;
            }
        }
    }

    public void setEdgeSize(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) @Px int i2) {
        this.mEdgeSize = i2;
    }

    public void setEdgeTrackingEnabled(int i2) {
        this.mTrackingEdges = i2;
    }

    public void setMinVelocity(float f4) {
        this.mMinVelocity = f4;
    }

    public boolean settleCapturedViewAt(int i2, int i8) {
        if (this.mReleaseInProgress) {
            return forceSettleCapturedViewAt(i2, i8, (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean shouldInterceptTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r18) {
        /*
            Method dump skipped, instruction units count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ViewDragHelper.shouldInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean smoothSlideViewTo(@NonNull View view, int i2, int i8) {
        this.mCapturedView = view;
        this.mActivePointerId = -1;
        boolean zForceSettleCapturedViewAt = forceSettleCapturedViewAt(i2, i8, 0, 0);
        if (!zForceSettleCapturedViewAt && this.mDragState == 0 && this.mCapturedView != null) {
            this.mCapturedView = null;
        }
        return zForceSettleCapturedViewAt;
    }

    public boolean tryCaptureViewForDrag(View view, int i2) {
        if (view == this.mCapturedView && this.mActivePointerId == i2) {
            return true;
        }
        if (view == null || !this.mCallback.tryCaptureView(view, i2)) {
            return false;
        }
        this.mActivePointerId = i2;
        captureChildView(view, i2);
        return true;
    }

    private float clampMag(float f4, float f8, float f9) {
        float fAbs = Math.abs(f4);
        if (fAbs < f8) {
            return 0.0f;
        }
        return fAbs > f9 ? f4 > 0.0f ? f9 : -f9 : f4;
    }

    public static ViewDragHelper create(@NonNull ViewGroup viewGroup, float f4, @NonNull Callback callback) {
        ViewDragHelper viewDragHelperCreate = create(viewGroup, callback);
        viewDragHelperCreate.mTouchSlop = (int) ((1.0f / f4) * viewDragHelperCreate.mTouchSlop);
        return viewDragHelperCreate;
    }

    public boolean isEdgeTouched(int i2, int i8) {
        return isPointerDown(i8) && (i2 & this.mInitialEdgesTouched[i8]) != 0;
    }

    public boolean checkTouchSlop(int i2) {
        int length = this.mInitialMotionX.length;
        for (int i8 = 0; i8 < length; i8++) {
            if (checkTouchSlop(i2, i8)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTouchSlop(int i2, int i8) {
        if (!isPointerDown(i8)) {
            return false;
        }
        boolean z2 = (i2 & 1) == 1;
        boolean z7 = (i2 & 2) == 2;
        float f4 = this.mLastMotionX[i8] - this.mInitialMotionX[i8];
        float f8 = this.mLastMotionY[i8] - this.mInitialMotionY[i8];
        if (!z2 || !z7) {
            return z2 ? Math.abs(f4) > ((float) this.mTouchSlop) : z7 && Math.abs(f8) > ((float) this.mTouchSlop);
        }
        float f9 = (f8 * f8) + (f4 * f4);
        int i9 = this.mTouchSlop;
        return f9 > ((float) (i9 * i9));
    }

    private void clearMotionHistory(int i2) {
        if (this.mInitialMotionX == null || !isPointerDown(i2)) {
            return;
        }
        this.mInitialMotionX[i2] = 0.0f;
        this.mInitialMotionY[i2] = 0.0f;
        this.mLastMotionX[i2] = 0.0f;
        this.mLastMotionY[i2] = 0.0f;
        this.mInitialEdgesTouched[i2] = 0;
        this.mEdgeDragsInProgress[i2] = 0;
        this.mEdgeDragsLocked[i2] = 0;
        this.mPointersDown = (~(1 << i2)) & this.mPointersDown;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class Callback {
        public int clampViewPositionHorizontal(@NonNull View view, int i2, int i8) {
            return 0;
        }

        public int clampViewPositionVertical(@NonNull View view, int i2, int i8) {
            return 0;
        }

        public int getViewHorizontalDragRange(@NonNull View view) {
            return 0;
        }

        public int getViewVerticalDragRange(@NonNull View view) {
            return 0;
        }

        public boolean onEdgeLock(int i2) {
            return false;
        }

        public abstract boolean tryCaptureView(@NonNull View view, int i2);

        public int getOrderedChildIndex(int i2) {
            return i2;
        }

        public void onViewDragStateChanged(int i2) {
        }

        public void onEdgeDragStarted(int i2, int i8) {
        }

        public void onEdgeTouched(int i2, int i8) {
        }

        public void onViewCaptured(@NonNull View view, int i2) {
        }

        public void onViewReleased(@NonNull View view, float f4, float f8) {
        }

        public void onViewPositionChanged(@NonNull View view, int i2, int i8, @Px int i9, @Px int i10) {
        }
    }
}
