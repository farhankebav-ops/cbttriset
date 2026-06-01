package com.google.android.material.bottomsheet;

import a1.a;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcelable;
import android.support.v4.media.g;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.PathInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ViewDragHelper;
import com.cbt.exam.browser.R;
import com.google.mlkit.common.MlKitException;
import g1.b;
import g1.c;
import g1.d;
import g1.e;
import g1.h;
import g1.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import q1.n;
import w1.k;
import w1.o;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public final h A;
    public final ValueAnimator B;
    public final int C;
    public int D;
    public int E;
    public final float F;
    public int G;
    public final float H;
    public boolean I;
    public boolean J;
    public final boolean K;
    public final boolean L;
    public boolean M;
    public int N;
    public ViewDragHelper O;
    public boolean P;
    public int Q;
    public boolean R;
    public final float S;
    public int T;
    public int U;
    public int V;
    public WeakReference W;
    public WeakReference X;
    public final ArrayList Y;
    public VelocityTracker Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5271a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f5272a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5273b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f5274b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f5275c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f5276c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5277d;
    public HashMap d0;
    public int e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final SparseIntArray f5278e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5279f;
    public final d f0;
    public int g;
    public final int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final k f5280i;
    public final ColorStateList j;
    public final int k;
    public final int l;
    public int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f5281n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f5282o;
    public final boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f5283q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f5284r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f5285s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f5286t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f5287u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f5288v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f5289w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f5290x;
    public final o y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f5291z;

    public BottomSheetBehavior() {
        this.f5271a = 0;
        this.f5273b = true;
        this.k = -1;
        this.l = -1;
        this.A = new h(this);
        this.F = 0.5f;
        this.H = -1.0f;
        this.K = true;
        this.L = true;
        this.N = 4;
        this.S = 0.1f;
        this.Y = new ArrayList();
        this.f5274b0 = -1;
        this.f5278e0 = new SparseIntArray();
        this.f0 = new d(this);
    }

    public static View e(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (view.isNestedScrollingEnabled()) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View viewE = e(viewGroup.getChildAt(i2));
            if (viewE != null) {
                return viewE;
            }
        }
        return null;
    }

    public static int f(int i2, int i8, int i9, int i10) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, i8, i10);
        if (i9 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i9), BasicMeasure.EXACTLY);
        }
        if (size != 0) {
            i9 = Math.min(size, i9);
        }
        return View.MeasureSpec.makeMeasureSpec(i9, Integer.MIN_VALUE);
    }

    public final void a() {
        int iC = c();
        if (this.f5273b) {
            this.G = Math.max(this.V - iC, this.D);
        } else {
            this.G = this.V - iC;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float b() {
        /*
            r5 = this;
            w1.k r0 = r5.f5280i
            r1 = 0
            if (r0 == 0) goto L77
            java.lang.ref.WeakReference r0 = r5.W
            if (r0 == 0) goto L77
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L77
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 31
            if (r0 < r2) goto L77
            java.lang.ref.WeakReference r0 = r5.W
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            boolean r2 = r5.i()
            if (r2 == 0) goto L77
            android.view.WindowInsets r0 = r0.getRootWindowInsets()
            if (r0 == 0) goto L77
            w1.k r2 = r5.f5280i
            float r2 = r2.j()
            android.view.RoundedCorner r3 = com.google.android.gms.internal.ads.k0.s(r0)
            if (r3 == 0) goto L44
            int r3 = com.google.android.gms.internal.ads.k0.e(r3)
            float r3 = (float) r3
            int r4 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r4 <= 0) goto L44
            int r4 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r4 <= 0) goto L44
            float r3 = r3 / r2
            goto L45
        L44:
            r3 = r1
        L45:
            w1.k r2 = r5.f5280i
            float[] r4 = r2.C
            if (r4 == 0) goto L4f
            r2 = 0
            r2 = r4[r2]
            goto L5d
        L4f:
            w1.h r4 = r2.f17716b
            w1.o r4 = r4.f17705a
            w1.d r4 = r4.f17743f
            android.graphics.RectF r2 = r2.g()
            float r2 = r4.a(r2)
        L5d:
            android.view.RoundedCorner r0 = com.google.android.gms.internal.ads.k0.B(r0)
            if (r0 == 0) goto L72
            int r0 = com.google.android.gms.internal.ads.k0.e(r0)
            float r0 = (float) r0
            int r4 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r4 <= 0) goto L72
            int r4 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r4 <= 0) goto L72
            float r1 = r0 / r2
        L72:
            float r0 = java.lang.Math.max(r3, r1)
            return r0
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.b():float");
    }

    public final int c() {
        int i2;
        return this.f5279f ? Math.min(Math.max(this.g, this.V - ((this.U * 9) / 16)), this.T) + this.f5288v : (this.f5281n || this.f5282o || (i2 = this.m) <= 0) ? this.e + this.f5288v : Math.max(this.e, i2 + this.h);
    }

    public final void d(int i2) {
        if (((View) this.W.get()) != null) {
            ArrayList arrayList = this.Y;
            if (arrayList.isEmpty()) {
                return;
            }
            int i8 = this.G;
            if (i2 <= i8 && i8 != g()) {
                g();
            }
            if (arrayList.size() <= 0) {
                return;
            }
            arrayList.get(0).getClass();
            throw new ClassCastException();
        }
    }

    public final int g() {
        if (this.f5273b) {
            return this.D;
        }
        return Math.max(this.C, this.f5284r ? 0 : this.f5289w);
    }

    public final int h(int i2) {
        if (i2 == 3) {
            return g();
        }
        if (i2 == 4) {
            return this.G;
        }
        if (i2 == 5) {
            return this.V;
        }
        if (i2 == 6) {
            return this.E;
        }
        throw new IllegalArgumentException(a.g(i2, "Invalid state to get top offset: "));
    }

    public final boolean i() {
        WeakReference weakReference = this.W;
        if (weakReference != null && weakReference.get() != null) {
            int[] iArr = new int[2];
            ((View) this.W.get()).getLocationOnScreen(iArr);
            if (iArr[1] == 0) {
                return true;
            }
        }
        return false;
    }

    public final void j(int i2) {
        if (i2 == -1) {
            if (this.f5279f) {
                return;
            } else {
                this.f5279f = true;
            }
        } else {
            if (!this.f5279f && this.e == i2) {
                return;
            }
            this.f5279f = false;
            this.e = Math.max(0, i2);
        }
        r();
    }

    public final void k(int i2) {
        if (i2 == 1 || i2 == 2) {
            throw new IllegalArgumentException(a.r(new StringBuilder("STATE_"), i2 == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        if (!this.I && i2 == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i2);
            return;
        }
        int i8 = (i2 == 6 && this.f5273b && h(i2) <= this.D) ? 3 : i2;
        WeakReference weakReference = this.W;
        if (weakReference == null || weakReference.get() == null) {
            l(i2);
            return;
        }
        View view = (View) this.W.get();
        g1.a aVar = new g1.a(this, view, i8);
        ViewParent parent = view.getParent();
        if (parent != null && parent.isLayoutRequested() && view.isAttachedToWindow()) {
            view.post(aVar);
        } else {
            aVar.run();
        }
    }

    public final void l(int i2) {
        if (this.N == i2) {
            return;
        }
        this.N = i2;
        if (i2 != 4 && i2 != 3 && i2 != 6) {
            boolean z2 = this.I;
        }
        WeakReference weakReference = this.W;
        if (weakReference == null || ((View) weakReference.get()) == null) {
            return;
        }
        if (i2 == 3) {
            q(true);
        } else if (i2 == 6 || i2 == 5 || i2 == 4) {
            q(false);
        }
        p(i2, true);
        ArrayList arrayList = this.Y;
        if (arrayList.size() <= 0) {
            o();
        } else {
            arrayList.get(0).getClass();
            throw new ClassCastException();
        }
    }

    public final boolean m(View view, float f4) {
        if (this.J) {
            return true;
        }
        if (view.getTop() < this.G) {
            return false;
        }
        return Math.abs(((f4 * this.S) + ((float) view.getTop())) - ((float) this.G)) / ((float) c()) > 0.5f;
    }

    public final void n(View view, int i2, boolean z2) {
        int iH = h(i2);
        ViewDragHelper viewDragHelper = this.O;
        if (viewDragHelper == null || (!z2 ? viewDragHelper.smoothSlideViewTo(view, view.getLeft(), iH) : viewDragHelper.settleCapturedViewAt(view.getLeft(), iH))) {
            l(i2);
            return;
        }
        l(2);
        p(i2, true);
        this.A.a(i2);
    }

    public final void o() {
        View view;
        WeakReference weakReference = this.W;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(view, 524288);
        ViewCompat.removeAccessibilityAction(view, 262144);
        ViewCompat.removeAccessibilityAction(view, 1048576);
        SparseIntArray sparseIntArray = this.f5278e0;
        int i2 = sparseIntArray.get(0, -1);
        if (i2 != -1) {
            ViewCompat.removeAccessibilityAction(view, i2);
            sparseIntArray.delete(0);
        }
        if (!this.f5273b && this.N != 6) {
            sparseIntArray.put(0, ViewCompat.addAccessibilityAction(view, view.getResources().getString(R.string.bottomsheet_action_expand_halfway), new e(this, 6)));
        }
        if (this.I && this.N != 5) {
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new e(this, 5));
        }
        int i8 = this.N;
        if (i8 == 3) {
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, null, new e(this, this.f5273b ? 4 : 6));
            return;
        }
        if (i8 == 4) {
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, null, new e(this, this.f5273b ? 3 : 6));
        } else {
            if (i8 != 6) {
                return;
            }
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, null, new e(this, 4));
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, null, new e(this, 3));
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.W = null;
        this.O = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.W = null;
        this.O = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int i2;
        ViewDragHelper viewDragHelper;
        if (!view.isShown() || !this.K) {
            this.P = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f5272a0 = -1;
            this.f5274b0 = -1;
            VelocityTracker velocityTracker = this.Z;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.Z = null;
            }
        }
        if (this.Z == null) {
            this.Z = VelocityTracker.obtain();
        }
        this.Z.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x2 = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            this.f5274b0 = y;
            if (this.N != 2) {
                WeakReference weakReference = this.X;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.isPointInChildBounds(view2, x2, y)) {
                    this.f5272a0 = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f5276c0 = true;
                }
            }
            this.P = this.f5272a0 == -1 && !coordinatorLayout.isPointInChildBounds(view, x2, this.f5274b0);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f5276c0 = false;
            this.f5272a0 = -1;
            if (this.P) {
                this.P = false;
                return false;
            }
        }
        if (this.P || (viewDragHelper = this.O) == null || !viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
            WeakReference weakReference2 = this.X;
            View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
            if (actionMasked != 2 || view3 == null || this.P || this.N == 1 || coordinatorLayout.isPointInChildBounds(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.O == null || (i2 = this.f5274b0) == -1 || Math.abs(i2 - motionEvent.getY()) <= this.O.getTouchSlop()) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i2) {
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        if (this.W == null) {
            this.g = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            boolean z2 = (Build.VERSION.SDK_INT < 29 || this.f5281n || this.f5279f) ? false : true;
            if (this.f5282o || this.p || this.f5283q || this.f5285s || this.f5286t || this.f5287u || z2) {
                c cVar = new c(this, z2);
                int paddingStart = view.getPaddingStart();
                view.getPaddingTop();
                int paddingEnd = view.getPaddingEnd();
                int paddingBottom = view.getPaddingBottom();
                q1.o oVar = new q1.o();
                oVar.f13427a = paddingStart;
                oVar.f13428b = paddingEnd;
                oVar.f13429c = paddingBottom;
                ViewCompat.setOnApplyWindowInsetsListener(view, new g(19, cVar, oVar));
                if (view.isAttachedToWindow()) {
                    view.requestApplyInsets();
                } else {
                    view.addOnAttachStateChangeListener(new n());
                }
            }
            ViewCompat.setWindowInsetsAnimationCallback(view, new i(view));
            this.W = new WeakReference(view);
            new PathInterpolator(0.1f, 0.1f, 0.0f, 1.0f);
            Context context = view.getContext();
            a.a.S(context, R.attr.motionDurationMedium2, MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
            a.a.S(context, R.attr.motionDurationShort3, 150);
            a.a.S(context, R.attr.motionDurationShort2, 100);
            Resources resources = view.getResources();
            resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_x_distance);
            resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_y_distance);
            k kVar = this.f5280i;
            if (kVar != null) {
                view.setBackground(kVar);
                float elevation = this.H;
                if (elevation == -1.0f) {
                    elevation = view.getElevation();
                }
                this.f5280i.o(elevation);
            } else {
                ColorStateList colorStateList = this.j;
                if (colorStateList != null) {
                    ViewCompat.setBackgroundTintList(view, colorStateList);
                }
            }
            o();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
        }
        if (this.O == null) {
            this.O = ViewDragHelper.create(coordinatorLayout, this.f0);
        }
        int top = view.getTop();
        coordinatorLayout.onLayoutChild(view, i2);
        this.U = coordinatorLayout.getWidth();
        this.V = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.T = height;
        int iMin = this.V;
        int i8 = iMin - height;
        int i9 = this.f5289w;
        if (i8 < i9) {
            if (this.f5284r) {
                int i10 = this.l;
                if (i10 != -1) {
                    iMin = Math.min(iMin, i10);
                }
                this.T = iMin;
            } else {
                int iMin2 = iMin - i9;
                int i11 = this.l;
                if (i11 != -1) {
                    iMin2 = Math.min(iMin2, i11);
                }
                this.T = iMin2;
            }
        }
        this.D = Math.max(0, this.V - this.T);
        this.E = (int) ((1.0f - this.F) * this.V);
        a();
        int i12 = this.N;
        if (i12 == 3) {
            ViewCompat.offsetTopAndBottom(view, g());
        } else if (i12 == 6) {
            ViewCompat.offsetTopAndBottom(view, this.E);
        } else if (this.I && i12 == 5) {
            ViewCompat.offsetTopAndBottom(view, this.V);
        } else if (i12 == 4) {
            ViewCompat.offsetTopAndBottom(view, this.G);
        } else if (i12 == 1 || i12 == 2) {
            ViewCompat.offsetTopAndBottom(view, top - view.getTop());
        }
        p(this.N, false);
        this.X = new WeakReference(e(view));
        ArrayList arrayList = this.Y;
        if (arrayList.size() <= 0) {
            return true;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i2, int i8, int i9, int i10) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(f(i2, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i8, this.k, marginLayoutParams.width), f(i9, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i10, this.l, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, View view, View view2, float f4, float f8) {
        WeakReference weakReference = this.X;
        if (weakReference == null || view2 != weakReference.get()) {
            return false;
        }
        return !(this.N == 3 || this.M) || super.onNestedPreFling(coordinatorLayout, view, view2, f4, f8);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i8, int[] iArr, int i9) {
        if (i9 == 1) {
            return;
        }
        WeakReference weakReference = this.X;
        View view3 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != view3) {
            return;
        }
        int top = view.getTop();
        int i10 = top - i8;
        if (i8 > 0) {
            if (!this.R && !this.L && view2 == view3 && view2.canScrollVertically(1)) {
                this.M = true;
                return;
            }
            if (i10 < g()) {
                int iG = top - g();
                iArr[1] = iG;
                ViewCompat.offsetTopAndBottom(view, -iG);
                l(3);
            } else {
                if (!this.K) {
                    return;
                }
                iArr[1] = i8;
                ViewCompat.offsetTopAndBottom(view, -i8);
                l(1);
            }
        } else if (i8 < 0) {
            boolean zCanScrollVertically = view2.canScrollVertically(-1);
            if (!this.R && !this.L && view2 == view3 && zCanScrollVertically) {
                this.M = true;
                return;
            }
            if (!zCanScrollVertically) {
                int i11 = this.G;
                if (i10 > i11 && !this.I) {
                    int i12 = top - i11;
                    iArr[1] = i12;
                    ViewCompat.offsetTopAndBottom(view, -i12);
                    l(4);
                } else {
                    if (!this.K) {
                        return;
                    }
                    iArr[1] = i8;
                    ViewCompat.offsetTopAndBottom(view, -i8);
                    l(1);
                }
            }
        }
        d(view.getTop());
        this.Q = i8;
        this.R = true;
        this.M = false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        g1.g gVar = (g1.g) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, view, gVar.getSuperState());
        int i2 = this.f5271a;
        if (i2 != 0) {
            if (i2 == -1 || (i2 & 1) == 1) {
                this.e = gVar.f11568b;
            }
            if (i2 == -1 || (i2 & 2) == 2) {
                this.f5273b = gVar.f11569c;
            }
            if (i2 == -1 || (i2 & 4) == 4) {
                this.I = gVar.f11570d;
            }
            if (i2 == -1 || (i2 & 8) == 8) {
                this.J = gVar.e;
            }
        }
        int i8 = gVar.f11567a;
        if (i8 == 1 || i8 == 2) {
            this.N = 4;
        } else {
            this.N = i8;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, View view) {
        return new g1.g(super.onSaveInstanceState(coordinatorLayout, view), this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i2, int i8) {
        this.Q = 0;
        this.R = false;
        return (i2 & 2) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r3, android.view.View r4, android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.g()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.l(r0)
            return
        Lf:
            java.lang.ref.WeakReference r3 = r2.X
            if (r3 == 0) goto Lb5
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto Lb5
            boolean r3 = r2.R
            if (r3 != 0) goto L1f
            goto Lb5
        L1f:
            int r3 = r2.Q
            r5 = 6
            if (r3 <= 0) goto L34
            boolean r3 = r2.f5273b
            if (r3 == 0) goto L2a
            goto Laf
        L2a:
            int r3 = r4.getTop()
            int r6 = r2.E
            if (r3 <= r6) goto Laf
            goto Lae
        L34:
            boolean r3 = r2.I
            if (r3 == 0) goto L55
            android.view.VelocityTracker r3 = r2.Z
            if (r3 != 0) goto L3e
            r3 = 0
            goto L4d
        L3e:
            r6 = 1000(0x3e8, float:1.401E-42)
            float r1 = r2.f5275c
            r3.computeCurrentVelocity(r6, r1)
            android.view.VelocityTracker r3 = r2.Z
            int r6 = r2.f5272a0
            float r3 = r3.getYVelocity(r6)
        L4d:
            boolean r3 = r2.m(r4, r3)
            if (r3 == 0) goto L55
            r0 = 5
            goto Laf
        L55:
            int r3 = r2.Q
            r6 = 4
            if (r3 != 0) goto L93
            int r3 = r4.getTop()
            boolean r1 = r2.f5273b
            if (r1 == 0) goto L74
            int r5 = r2.D
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.G
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L97
            goto Laf
        L74:
            int r1 = r2.E
            if (r3 >= r1) goto L83
            int r6 = r2.G
            int r6 = r3 - r6
            int r6 = java.lang.Math.abs(r6)
            if (r3 >= r6) goto Lae
            goto Laf
        L83:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.G
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L97
            goto Lae
        L93:
            boolean r3 = r2.f5273b
            if (r3 == 0) goto L99
        L97:
            r0 = r6
            goto Laf
        L99:
            int r3 = r4.getTop()
            int r0 = r2.E
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.G
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L97
        Lae:
            r0 = r5
        Laf:
            r3 = 0
            r2.n(r4, r0, r3)
            r2.R = r3
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i2 = this.N;
        if (i2 == 1 && actionMasked == 0) {
            return true;
        }
        ViewDragHelper viewDragHelper = this.O;
        if (viewDragHelper != null && (this.K || i2 == 1)) {
            viewDragHelper.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            this.f5272a0 = -1;
            this.f5274b0 = -1;
            VelocityTracker velocityTracker = this.Z;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.Z = null;
            }
        }
        if (this.Z == null) {
            this.Z = VelocityTracker.obtain();
        }
        this.Z.addMovement(motionEvent);
        if (this.O != null && ((this.K || this.N == 1) && actionMasked == 2 && !this.P && Math.abs(this.f5274b0 - motionEvent.getY()) > this.O.getTouchSlop())) {
            this.O.captureChildView(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.P;
    }

    public final void p(int i2, boolean z2) {
        k kVar;
        if (i2 == 2) {
            return;
        }
        boolean z7 = this.N == 3 && (this.f5290x || i());
        if (this.f5291z == z7 || (kVar = this.f5280i) == null) {
            return;
        }
        this.f5291z = z7;
        ValueAnimator valueAnimator = this.B;
        if (!z2 || valueAnimator == null) {
            if (valueAnimator != null && valueAnimator.isRunning()) {
                valueAnimator.cancel();
            }
            kVar.q(this.f5291z ? b() : 1.0f);
            return;
        }
        if (valueAnimator.isRunning()) {
            valueAnimator.reverse();
        } else {
            valueAnimator.setFloatValues(kVar.f17716b.j, z7 ? b() : 1.0f);
            valueAnimator.start();
        }
    }

    public final void q(boolean z2) {
        WeakReference weakReference = this.W;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z2) {
                if (this.d0 != null) {
                    return;
                } else {
                    this.d0 = new HashMap(childCount);
                }
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if (childAt != this.W.get() && z2) {
                    this.d0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                }
            }
            if (z2) {
                return;
            }
            this.d0 = null;
        }
    }

    public final void r() {
        View view;
        if (this.W != null) {
            a();
            if (this.N != 4 || (view = (View) this.W.get()) == null) {
                return;
            }
            view.requestLayout();
        }
    }

    public BottomSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        int i2;
        super(context, attributeSet);
        int i8 = 0;
        this.f5271a = 0;
        this.f5273b = true;
        this.k = -1;
        this.l = -1;
        this.A = new h(this);
        this.F = 0.5f;
        this.H = -1.0f;
        this.K = true;
        this.L = true;
        this.N = 4;
        this.S = 0.1f;
        this.Y = new ArrayList();
        this.f5274b0 = -1;
        this.f5278e0 = new SparseIntArray();
        this.f0 = new d(this);
        this.h = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b1.a.f4128c);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            this.j = t1.c.a(context, typedArrayObtainStyledAttributes, 3);
        }
        if (typedArrayObtainStyledAttributes.hasValue(22)) {
            this.y = o.b(context, attributeSet, R.attr.bottomSheetStyle, R.style.Widget_Design_BottomSheet_Modal).a();
        }
        o oVar = this.y;
        if (oVar != null) {
            k kVar = new k(oVar);
            this.f5280i = kVar;
            kVar.l(context);
            ColorStateList colorStateList = this.j;
            if (colorStateList != null) {
                this.f5280i.p(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.f5280i.setTint(typedValue.data);
            }
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(b(), 1.0f);
        this.B = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.B.addUpdateListener(new b(this, i8));
        this.H = typedArrayObtainStyledAttributes.getDimension(2, -1.0f);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            this.k = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            this.l = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, -1);
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(10);
        if (typedValuePeekValue != null && (i2 = typedValuePeekValue.data) == -1) {
            j(i2);
        } else {
            j(typedArrayObtainStyledAttributes.getDimensionPixelSize(10, -1));
        }
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(9, false);
        if (this.I != z2) {
            this.I = z2;
            if (!z2 && this.N == 5) {
                k(4);
            }
            o();
        }
        this.f5281n = typedArrayObtainStyledAttributes.getBoolean(14, false);
        boolean z7 = typedArrayObtainStyledAttributes.getBoolean(7, true);
        if (this.f5273b != z7) {
            this.f5273b = z7;
            if (this.W != null) {
                a();
            }
            l((this.f5273b && this.N == 6) ? 3 : this.N);
            p(this.N, true);
            o();
        }
        this.J = typedArrayObtainStyledAttributes.getBoolean(13, false);
        this.K = typedArrayObtainStyledAttributes.getBoolean(4, true);
        this.L = typedArrayObtainStyledAttributes.getBoolean(5, true);
        this.f5271a = typedArrayObtainStyledAttributes.getInt(11, 0);
        float f4 = typedArrayObtainStyledAttributes.getFloat(8, 0.5f);
        if (f4 > 0.0f && f4 < 1.0f) {
            this.F = f4;
            if (this.W != null) {
                this.E = (int) ((1.0f - f4) * this.V);
            }
            TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(6);
            if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
                int i9 = typedValuePeekValue2.data;
                if (i9 >= 0) {
                    this.C = i9;
                    p(this.N, true);
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            } else {
                int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(6, 0);
                if (dimensionPixelOffset >= 0) {
                    this.C = dimensionPixelOffset;
                    p(this.N, true);
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            }
            this.f5277d = typedArrayObtainStyledAttributes.getInt(12, 500);
            this.f5282o = typedArrayObtainStyledAttributes.getBoolean(18, false);
            this.p = typedArrayObtainStyledAttributes.getBoolean(19, false);
            this.f5283q = typedArrayObtainStyledAttributes.getBoolean(20, false);
            this.f5284r = typedArrayObtainStyledAttributes.getBoolean(21, true);
            this.f5285s = typedArrayObtainStyledAttributes.getBoolean(15, false);
            this.f5286t = typedArrayObtainStyledAttributes.getBoolean(16, false);
            this.f5287u = typedArrayObtainStyledAttributes.getBoolean(17, false);
            this.f5290x = typedArrayObtainStyledAttributes.getBoolean(24, true);
            typedArrayObtainStyledAttributes.recycle();
            this.f5275c = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i8, int i9, int i10, int i11, int[] iArr) {
    }
}
