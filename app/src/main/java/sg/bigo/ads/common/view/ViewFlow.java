package sg.bigo.ads.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.common.p;

/* JADX INFO: loaded from: classes6.dex */
public class ViewFlow extends sg.bigo.ads.common.view.a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final Interpolator f16123s = new Interpolator() { // from class: sg.bigo.ads.common.view.ViewFlow.1
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f4) {
            float f8 = f4 - 1.0f;
            return (f8 * f8 * f8 * f8 * f8) + 1.0f;
        }
    };
    private float A;
    private float B;
    private int C;
    private VelocityTracker D;
    private int E;
    private int F;
    private int G;
    private int H;
    private boolean I;
    private final Runnable J;
    private int K;
    private boolean L;
    private boolean M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f16124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f16125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f16126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f16127d;
    protected View e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected View f16128f;
    public boolean g;
    public boolean h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f16129i;
    protected int j;
    private final a k;
    private int l;
    private int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f16130n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private d f16131o;
    private d p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private p f16132q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f16133r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Scroller f16134t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f16135u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f16136v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f16137w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f16138x;
    private float y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f16139z;

    public static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        c f16143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f16144b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ViewFlow f16145c;

        private a(ViewFlow viewFlow) {
            this.f16144b = 0;
            this.f16145c = viewFlow;
        }

        @Override // sg.bigo.ads.common.view.ViewFlow.c
        public final void a(final int i2) {
            this.f16145c.post(new Runnable() { // from class: sg.bigo.ads.common.view.ViewFlow.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    a aVar = a.this;
                    int i8 = aVar.f16144b;
                    int i9 = i2;
                    if (i8 == i9) {
                        return;
                    }
                    aVar.f16144b = i9;
                    c cVar = aVar.f16143a;
                    if (cVar != null) {
                        cVar.a(i9);
                    }
                }
            });
        }

        public /* synthetic */ a(ViewFlow viewFlow, byte b8) {
            this(viewFlow);
        }

        @Override // sg.bigo.ads.common.view.ViewFlow.c
        public final void a(final int i2, final int i8) {
            this.f16145c.post(new Runnable() { // from class: sg.bigo.ads.common.view.ViewFlow.a.4
                @Override // java.lang.Runnable
                public final void run() {
                    c cVar = a.this.f16143a;
                    if (cVar != null) {
                        cVar.a(i2, i8);
                    }
                }
            });
        }

        @Override // sg.bigo.ads.common.view.ViewFlow.c
        public final void a(@NonNull final View view, final int i2) {
            this.f16145c.post(new Runnable() { // from class: sg.bigo.ads.common.view.ViewFlow.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    c cVar = a.this.f16143a;
                    if (cVar != null) {
                        cVar.a(view, i2);
                    }
                }
            });
        }

        @Override // sg.bigo.ads.common.view.ViewFlow.c
        public final void a(@NonNull final View view, final int i2, final float f4) {
            this.f16145c.post(new Runnable() { // from class: sg.bigo.ads.common.view.ViewFlow.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    c cVar = a.this.f16143a;
                    if (cVar != null) {
                        cVar.a(view, i2, f4);
                    }
                }
            });
        }
    }

    public static class b extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16158a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f16159b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f16160c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f16161d;
        public int e;

        public b() {
            this((byte) 0);
        }

        private b(byte b8) {
            super(-1, -1);
            this.e = 17;
        }
    }

    public interface c {
        void a(int i2);

        void a(int i2, int i8);

        void a(@NonNull View view, int i2);

        void a(@NonNull View view, int i2, float f4);
    }

    public interface d {
        void a();
    }

    public ViewFlow(Context context) {
        this(context, null);
    }

    private static float b(float f4) {
        return (float) Math.sin((f4 - 0.5f) * 0.47123894f);
    }

    private void c(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2) {
        a(i2, true, -20);
    }

    private boolean f() {
        int i2 = this.f16126c;
        return i2 == 2 || i2 == 3;
    }

    private boolean g() {
        this.C = -1;
        i();
        return true;
    }

    private int getScrollRange() {
        return Math.max(0, this.f16130n - getMeasuredWidth());
    }

    private void h() {
        this.h = false;
        this.f16136v = true;
    }

    private void i() {
        this.f16136v = false;
        this.f16137w = false;
        this.h = false;
        VelocityTracker velocityTracker = this.D;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.D = null;
        }
    }

    private void j() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public final int a(View view) {
        if (view == null) {
            return -1;
        }
        List<View> items = getItems();
        for (int i2 = 0; i2 < items.size(); i2++) {
            if (items.get(i2) == view) {
                return i2;
            }
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (i2 < 0) {
            View childAt = getChildAt(getChildCount() - 1);
            if (childAt != null && childAt == this.f16128f) {
                i2 = getChildCount() - 1;
            }
        } else {
            View childAt2 = getChildAt(0);
            if (childAt2 != null && childAt2 == this.e) {
                i2++;
            }
        }
        super.addView(view, i2, layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof b) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f16135u = true;
        if (this.f16134t.isFinished() || !this.f16134t.computeScrollOffset()) {
            a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f16134t.getCurrX();
        int currY = this.f16134t.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
        }
        sg.bigo.ads.common.e.a.a(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        this.g = true;
        if (!this.M) {
            onTouchEvent(motionEvent);
        }
        return zDispatchTouchEvent;
    }

    public final boolean e() {
        int measuredWidth = this.f16130n;
        View view = this.e;
        if (view != null) {
            measuredWidth -= view.getRight();
        }
        View view2 = this.f16128f;
        if (view2 != null) {
            measuredWidth -= view2.getMeasuredWidth();
        }
        return getWidth() >= measuredWidth;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new b();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getContentMaxWidthSpace() {
        return this.f16127d;
    }

    @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG)
    public int getCurrentItem() {
        return this.f16124a;
    }

    @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG)
    public int getItemCount() {
        return this.f16125b;
    }

    @NonNull
    public List<View> getItems() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != this.e && childAt != this.f16128f) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }

    public c getOnItemChangeListener() {
        return this.k.f16143a;
    }

    public int getViewStyle() {
        return this.f16126c;
    }

    @Override // sg.bigo.ads.common.view.a, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.I = true;
    }

    @Override // sg.bigo.ads.common.view.a, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.J);
        Scroller scroller = this.f16134t;
        if (scroller != null && !scroller.isFinished()) {
            this.f16134t.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.M = false;
        if (this.f16133r) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            g();
            return false;
        }
        if (action != 0) {
            if (this.f16136v) {
                return true;
            }
            if (this.f16137w) {
                return false;
            }
        }
        if (action == 0) {
            float x2 = motionEvent.getX();
            this.A = x2;
            this.y = x2;
            float y = motionEvent.getY();
            this.B = y;
            this.f16139z = y;
            this.C = motionEvent.getPointerId(0);
            this.f16137w = false;
            this.f16135u = true;
            this.f16134t.computeScrollOffset();
            if (this.K != 2 || Math.abs(this.f16134t.getFinalX() - this.f16134t.getCurrX()) <= this.H) {
                a(false);
                this.f16136v = false;
            } else {
                this.f16134t.abortAnimation();
                h();
                j();
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.C;
            if (i2 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i2);
                float x7 = motionEvent.getX(iFindPointerIndex);
                float f4 = x7 - this.y;
                float fAbs = Math.abs(f4);
                float y2 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y2 - this.B);
                if (f4 != 0.0f) {
                    float f8 = this.y;
                    if ((f8 >= this.j || f4 <= 0.0f) && ((f8 <= getWidth() - this.j || f4 >= 0.0f) && getWidth() < this.f16130n)) {
                        this.y = x7;
                        this.f16139z = y2;
                        this.f16137w = true;
                        return false;
                    }
                }
                int i8 = this.f16138x;
                if (fAbs > i8 && fAbs * 0.5f > fAbs2) {
                    h();
                    j();
                    setScrollState(1);
                    float f9 = this.A;
                    float f10 = this.f16138x;
                    this.y = f4 > 0.0f ? f9 + f10 : f9 - f10;
                    this.f16139z = y2;
                } else if (fAbs2 > i8) {
                    this.f16137w = true;
                }
                if (this.f16136v) {
                    a(x7);
                }
            }
        } else if (action == 6) {
            a(motionEvent);
        }
        if (this.D == null) {
            this.D = VelocityTracker.obtain();
        }
        this.D.addMovement(motionEvent);
        return this.f16136v;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cc  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r8, int r9, int r10, int r11, int r12) {
        /*
            Method dump skipped, instruction units count: 366
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.common.view.ViewFlow.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00b8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instruction units count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.common.view.ViewFlow.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i8, int i9, int i10) {
        int i11;
        int iMin;
        super.onScrollChanged(i2, i8, i9, i10);
        View childAt = getChildAt(0);
        if (childAt == null || childAt != this.e) {
            i11 = 0;
            iMin = i2;
        } else {
            iMin = Math.max(childAt.getRight(), i2);
            i11 = 1;
        }
        int childCount = getChildCount();
        View childAt2 = getChildAt(childCount - 1);
        if (childAt2 != null && childAt2 == this.f16128f) {
            iMin = Math.min(childAt2.getLeft() - getMeasuredWidth(), iMin);
            childCount--;
        }
        float measuredWidth = f() ? ((getMeasuredWidth() * 1.0f) / 2.0f) + iMin : iMin + this.f16127d;
        View childAt3 = getChildAt(this.f16124a + i11);
        int measuredWidth2 = (childAt3 == null || childAt3.getMeasuredWidth() <= 0) ? getMeasuredWidth() - (this.f16127d * 2) : childAt3.getMeasuredWidth();
        sg.bigo.ads.common.t.a.a("ViewFlow", "computeScrollOffset, ----- begin -----");
        for (int i12 = i11; i12 < childCount; i12++) {
            View childAt4 = getChildAt(i12);
            if (childAt4 != null) {
                float fMax = Math.max(-1.0f, Math.min(1.0f, (f() ? (int) (((childAt4.getLeft() + ((childAt4.getMeasuredWidth() * 1.0f) / 2.0f)) - measuredWidth) + 0.5f) : childAt4.getLeft() - measuredWidth) / measuredWidth2));
                int i13 = i12 - i11;
                if (childAt4.getLeft() < measuredWidth && childAt4.getRight() > measuredWidth) {
                    this.l = i13;
                }
                this.k.a(childAt4, i13, fMax);
                if (fMax == 0.0f && this.f16124a != i13) {
                    this.f16124a = i13;
                    this.l = i13;
                    this.k.a(childAt4, i13);
                }
            }
        }
        sg.bigo.ads.common.t.a.a("ViewFlow", "computeScrollOffset, ----- end -----");
        a aVar = this.k;
        if (aVar != null) {
            aVar.a(i2, getScrollRange());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0217 A[PHI: r1
  0x0217: PHI (r1v12 sg.bigo.ads.common.view.ViewFlow$d) = (r1v11 sg.bigo.ads.common.view.ViewFlow$d), (r1v13 sg.bigo.ads.common.view.ViewFlow$d) binds: [B:127:0x023c, B:117:0x0215] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0158  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instruction units count: 629
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.common.view.ViewFlow.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view == this.f16128f || view == this.e || view == null) {
            return;
        }
        this.f16125b++;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view == this.f16128f || view == this.e || view == null) {
            return;
        }
        this.f16125b--;
    }

    public void setContentMaxWidthSpace(int i2) {
        int iMax = Math.max(0, i2);
        if (this.f16127d != iMax) {
            this.f16127d = iMax;
            requestLayout();
        }
    }

    public void setDividerWidth(int i2) {
        int iMax = Math.max(0, i2);
        if (this.m != iMax) {
            this.m = iMax;
            if (this.f16126c != 3) {
                requestLayout();
            }
        }
    }

    public void setEndView(View view) {
        View view2 = this.f16128f;
        if (view != view2) {
            if (view2 != null) {
                removeView(view2);
            }
            this.f16128f = view;
            if (view != null) {
                addView(view);
            }
            requestLayout();
        }
    }

    public void setMainChildSize(p pVar) {
        this.f16132q = pVar;
    }

    public void setOnEndViewShowListener(d dVar) {
        this.p = dVar;
    }

    public void setOnItemChangeListener(c cVar) {
        this.k.f16143a = cVar;
    }

    public void setOnStartViewShowListener(d dVar) {
        this.f16131o = dVar;
    }

    public void setScrollEnabled(boolean z2) {
        this.f16133r = z2;
    }

    public void setScrollState(int i2) {
        if (this.K == i2) {
            return;
        }
        this.K = i2;
    }

    public void setStartView(View view) {
        View view2 = this.e;
        if (view != view2) {
            if (view2 != null) {
                removeView(view2);
            }
            this.e = view;
            if (view != null) {
                addView(view, 0);
            }
            requestLayout();
        }
    }

    public void setViewStyle(int i2) {
        if (this.f16126c != i2) {
            this.f16126c = i2;
            requestLayout();
        }
    }

    public ViewFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = new a(this, (byte) 0);
        this.f16124a = 0;
        this.f16125b = 0;
        this.l = 0;
        this.f16126c = 3;
        this.f16133r = true;
        this.g = false;
        this.h = false;
        this.C = -1;
        this.I = true;
        this.J = new Runnable() { // from class: sg.bigo.ads.common.view.ViewFlow.2
            @Override // java.lang.Runnable
            public final void run() {
                ViewFlow.this.setScrollState(0);
            }
        };
        this.K = 0;
        this.M = false;
        removeAllViews();
        setFocusable(true);
        setOverScrollMode(2);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        Context context2 = getContext();
        this.f16134t = new Scroller(context2, f16123s);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
        float f4 = context2.getResources().getDisplayMetrics().density;
        this.f16138x = viewConfiguration.getScaledPagingTouchSlop();
        this.E = (int) (400.0f * f4);
        this.F = viewConfiguration.getScaledMaximumFlingVelocity();
        this.G = (int) (25.0f * f4);
        this.H = (int) (2.0f * f4);
        this.f16129i = (int) (f4 * 16.0f);
    }

    @Nullable
    public final View a(int i2) {
        List<View> items = getItems();
        if (i2 < 0 || i2 >= items.size()) {
            return null;
        }
        return items.get(i2);
    }

    public final void b(int i2) {
        this.f16124a = i2;
        if (this.I) {
            requestLayout();
        } else {
            c(i2);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    @Override // sg.bigo.ads.common.view.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            r5 = this;
            int r0 = r5.getItemCount()
            r1 = 1
            if (r0 > r1) goto L8
            return
        L8:
            int r2 = r5.getCurrentItem()
            boolean r3 = r5.L
            if (r3 == 0) goto L1a
            if (r2 != 0) goto L17
            int r2 = r2 + r1
            r0 = 0
            r5.L = r0
            goto L3a
        L17:
            int r2 = r2 + (-1)
            goto L3a
        L1a:
            int r0 = r0 - r1
            if (r2 == r0) goto L36
            android.view.View r0 = r5.f16128f
            int r3 = r5.f16130n
            if (r0 == 0) goto L28
            int r0 = r0.getMeasuredWidth()
            int r3 = r3 - r0
        L28:
            int r0 = r5.getScrollX()
            int r4 = r5.getMeasuredWidth()
            int r4 = r4 + r0
            if (r4 < r3) goto L34
            goto L36
        L34:
            int r2 = r2 + r1
            goto L3a
        L36:
            int r2 = r2 + (-1)
            r5.L = r1
        L3a:
            r5.c(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.common.view.ViewFlow.a():void");
    }

    @Override // sg.bigo.ads.common.view.a
    public final boolean b() {
        return !this.f16136v;
    }

    private void a(int i2, int i8) {
        int scrollX;
        if (this.f16125b == 0) {
            return;
        }
        Scroller scroller = this.f16134t;
        if (scroller == null || scroller.isFinished()) {
            scrollX = getScrollX();
        } else {
            scrollX = this.f16135u ? this.f16134t.getCurrX() : this.f16134t.getStartX();
            this.f16134t.abortAnimation();
        }
        int i9 = scrollX;
        int scrollY = getScrollY();
        int i10 = i2 - i9;
        int i11 = 0 - scrollY;
        if (i10 == 0 && i11 == 0) {
            a(false);
            setScrollState(0);
            return;
        }
        setScrollState(2);
        int measuredWidth = getMeasuredWidth();
        float f4 = measuredWidth / 2;
        float fB = (b(Math.min(1.0f, (Math.abs(i10) * 1.0f) / measuredWidth)) * f4) + f4;
        int iAbs = Math.abs(i8);
        int iMin = Math.min(iAbs > 0 ? Math.round(Math.abs(fB / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i10) / getChildAt(this.f16124a).getWidth()) + 1.0f) * 100.0f), 600);
        this.f16135u = false;
        this.f16134t.startScroll(i9, scrollY, i10, i11, iMin);
        sg.bigo.ads.common.e.a.a(this);
    }

    private void a(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2, boolean z2, int i8) {
        int measuredWidth;
        int measuredWidth2;
        if (this.f16125b <= 0) {
            return;
        }
        int iMin = Math.min(Math.max(0, i2), this.f16125b - 1);
        View childAt = getChildAt(0);
        if (childAt != null && childAt == this.e) {
            iMin++;
        }
        View childAt2 = getChildAt(iMin);
        int left = childAt2 != null ? f() ? childAt2.getLeft() - ((getMeasuredWidth() - childAt2.getMeasuredWidth()) / 2) : childAt2.getLeft() - Math.max(this.f16127d, this.m) : 0;
        if (getChildAt(getChildCount() - 1) != null) {
            if (this.f16128f != null) {
                measuredWidth = this.f16130n - getMeasuredWidth();
                measuredWidth2 = this.f16128f.getMeasuredWidth();
            } else {
                measuredWidth = this.f16130n;
                measuredWidth2 = getMeasuredWidth();
            }
            left = (int) Math.max(0.0f, Math.min(left, measuredWidth - measuredWidth2));
        }
        if (left == getScrollX()) {
            return;
        }
        if (z2) {
            a(left, i8);
        } else {
            a(false);
            scrollTo(left, 0);
        }
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.C) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.y = motionEvent.getX(i2);
            this.C = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.D;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public static /* synthetic */ void a(ViewFlow viewFlow) {
        int scrollX = viewFlow.getScrollX();
        if (viewFlow.e != null) {
            View childAt = viewFlow.getChildAt(0);
            View view = viewFlow.e;
            if (childAt == view && scrollX < view.getRight()) {
                viewFlow.c(0);
                return;
            }
        }
        if (viewFlow.f16128f != null) {
            View childAt2 = viewFlow.getChildAt(viewFlow.getChildCount() - 1);
            View view2 = viewFlow.f16128f;
            if (childAt2 != view2 || scrollX <= view2.getLeft() - viewFlow.getMeasuredWidth()) {
                return;
            }
            viewFlow.c(viewFlow.getItemCount() - 1);
        }
    }

    private void a(boolean z2) {
        boolean z7 = this.K == 2;
        if (z7 && !this.f16134t.isFinished()) {
            this.f16134t.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f16134t.getCurrX();
            int currY = this.f16134t.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
        }
        if (z7) {
            if (z2) {
                sg.bigo.ads.common.e.a.a(this, this.J);
            } else {
                this.J.run();
            }
        }
    }

    private boolean a(float f4) {
        float f8 = this.y - f4;
        this.y = f4;
        float fMax = Math.max(0.0f, Math.min(getScrollX() + f8, getScrollRange()));
        sg.bigo.ads.common.t.a.b("ViewFlow", "performDrag, getScrollRange()=" + getScrollRange() + ", scrollX=" + fMax);
        int i2 = (int) fMax;
        this.y = (fMax - ((float) i2)) + this.y;
        scrollTo(i2, getScrollY());
        return false;
    }
}
