package com.google.android.material.sidesheet;

import a1.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ViewDragHelper;
import com.cbt.exam.browser.R;
import com.google.mlkit.common.MlKitException;
import g1.h;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import r2.q;
import w1.k;
import w1.n;
import w1.o;
import x1.b;
import x1.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class SideSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f5425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f5426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ColorStateList f5427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o f5428d;
    public final h e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f5429f;
    public final boolean g;
    public int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewDragHelper f5430i;
    public boolean j;
    public final float k;
    public int l;
    public int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f5431n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f5432o;
    public WeakReference p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public WeakReference f5433q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f5434r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public VelocityTracker f5435s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f5436t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final LinkedHashSet f5437u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b f5438v;

    public SideSheetBehavior() {
        this.e = new h(this);
        this.g = true;
        this.h = 5;
        this.k = 0.1f;
        this.f5434r = -1;
        this.f5437u = new LinkedHashSet();
        this.f5438v = new b(this);
    }

    public final void a(int i2) {
        View view;
        if (this.h == i2) {
            return;
        }
        this.h = i2;
        WeakReference weakReference = this.p;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        int i8 = this.h == 5 ? 4 : 0;
        if (view.getVisibility() != i8) {
            view.setVisibility(i8);
        }
        Iterator it = this.f5437u.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        d();
    }

    public final boolean b() {
        if (this.f5430i != null) {
            return this.g || this.h == 1;
        }
        return false;
    }

    public final void c(View view, int i2, boolean z2) {
        int iU;
        if (i2 == 3) {
            iU = this.f5425a.U();
        } else {
            if (i2 != 5) {
                throw new IllegalArgumentException(a.g(i2, "Invalid state to get outer edge offset: "));
            }
            iU = this.f5425a.V();
        }
        ViewDragHelper viewDragHelper = this.f5430i;
        if (viewDragHelper == null || (!z2 ? viewDragHelper.smoothSlideViewTo(view, iU, view.getTop()) : viewDragHelper.settleCapturedViewAt(iU, view.getTop()))) {
            a(i2);
        } else {
            a(2);
            this.e.a(i2);
        }
    }

    public final void d() {
        View view;
        WeakReference weakReference = this.p;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(view, 262144);
        ViewCompat.removeAccessibilityAction(view, 1048576);
        int i2 = 5;
        if (this.h != 5) {
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new f3.a(this, i2, 2));
        }
        int i8 = 3;
        if (this.h != 3) {
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, null, new f3.a(this, i8, 2));
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.p = null;
        this.f5430i = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.p = null;
        this.f5430i = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        VelocityTracker velocityTracker;
        if ((!view.isShown() && ViewCompat.getAccessibilityPaneTitle(view) == null) || !this.g) {
            this.j = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && (velocityTracker = this.f5435s) != null) {
            velocityTracker.recycle();
            this.f5435s = null;
        }
        if (this.f5435s == null) {
            this.f5435s = VelocityTracker.obtain();
        }
        this.f5435s.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.f5436t = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.j) {
            this.j = false;
            return false;
        }
        return (this.j || (viewDragHelper = this.f5430i) == null || !viewDragHelper.shouldInterceptTouchEvent(motionEvent)) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i2) {
        View view2;
        View view3;
        int i8;
        View viewFindViewById;
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        int iZ = 0;
        if (this.p == null) {
            this.p = new WeakReference(view);
            new PathInterpolator(0.1f, 0.1f, 0.0f, 1.0f);
            Context context = view.getContext();
            a.a.S(context, R.attr.motionDurationMedium2, MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
            a.a.S(context, R.attr.motionDurationShort3, 150);
            a.a.S(context, R.attr.motionDurationShort2, 100);
            Resources resources = view.getResources();
            resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_shrink);
            resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_grow);
            resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_y_distance);
            k kVar = this.f5426b;
            if (kVar != null) {
                view.setBackground(kVar);
                float elevation = this.f5429f;
                if (elevation == -1.0f) {
                    elevation = view.getElevation();
                }
                this.f5426b.o(elevation);
            } else {
                ColorStateList colorStateList = this.f5427c;
                if (colorStateList != null) {
                    ViewCompat.setBackgroundTintList(view, colorStateList);
                }
            }
            int i9 = this.h == 5 ? 4 : 0;
            if (view.getVisibility() != i9) {
                view.setVisibility(i9);
            }
            d();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
            if (ViewCompat.getAccessibilityPaneTitle(view) == null) {
                ViewCompat.setAccessibilityPaneTitle(view, view.getResources().getString(R.string.side_sheet_accessibility_pane_title));
            }
        }
        int i10 = Gravity.getAbsoluteGravity(((CoordinatorLayout.LayoutParams) view.getLayoutParams()).gravity, i2) == 3 ? 1 : 0;
        q qVar = this.f5425a;
        if (qVar == null || qVar.b0() != i10) {
            CoordinatorLayout.LayoutParams layoutParams = null;
            o oVar = this.f5428d;
            if (i10 == 0) {
                this.f5425a = new x1.a(this, 1);
                if (oVar != null) {
                    WeakReference weakReference = this.p;
                    if (weakReference != null && (view3 = (View) weakReference.get()) != null && (view3.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                        layoutParams = (CoordinatorLayout.LayoutParams) view3.getLayoutParams();
                    }
                    if (layoutParams == null || ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin <= 0) {
                        n nVarF = oVar.f();
                        nVarF.f17737f = new w1.a(0.0f);
                        nVarF.g = new w1.a(0.0f);
                        o oVarA = nVarF.a();
                        k kVar2 = this.f5426b;
                        if (kVar2 != null) {
                            kVar2.setShapeAppearanceModel(oVarA);
                        }
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalArgumentException(a.h(i10, "Invalid sheet edge position value: ", ". Must be 0 or 1."));
                }
                this.f5425a = new x1.a(this, 0);
                if (oVar != null) {
                    WeakReference weakReference2 = this.p;
                    if (weakReference2 != null && (view2 = (View) weakReference2.get()) != null && (view2.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                        layoutParams = (CoordinatorLayout.LayoutParams) view2.getLayoutParams();
                    }
                    if (layoutParams == null || ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin <= 0) {
                        n nVarF2 = oVar.f();
                        nVarF2.e = new w1.a(0.0f);
                        nVarF2.h = new w1.a(0.0f);
                        o oVarA2 = nVarF2.a();
                        k kVar3 = this.f5426b;
                        if (kVar3 != null) {
                            kVar3.setShapeAppearanceModel(oVarA2);
                        }
                    }
                }
            }
        }
        if (this.f5430i == null) {
            this.f5430i = ViewDragHelper.create(coordinatorLayout, this.f5438v);
        }
        int iZ2 = this.f5425a.Z(view);
        coordinatorLayout.onLayoutChild(view, i2);
        this.m = coordinatorLayout.getWidth();
        this.f5431n = this.f5425a.a0(coordinatorLayout);
        this.l = view.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        this.f5432o = marginLayoutParams != null ? this.f5425a.t(marginLayoutParams) : 0;
        int i11 = this.h;
        if (i11 == 1 || i11 == 2) {
            iZ = iZ2 - this.f5425a.Z(view);
        } else if (i11 != 3) {
            if (i11 != 5) {
                throw new IllegalStateException("Unexpected value: " + this.h);
            }
            iZ = this.f5425a.V();
        }
        ViewCompat.offsetLeftAndRight(view, iZ);
        if (this.f5433q == null && (i8 = this.f5434r) != -1 && (viewFindViewById = coordinatorLayout.findViewById(i8)) != null) {
            this.f5433q = new WeakReference(viewFindViewById);
        }
        Iterator it = this.f5437u.iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i2, int i8, int i9, int i10) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i2, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i8, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i9, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i10, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        c cVar = (c) parcelable;
        if (cVar.getSuperState() != null) {
            super.onRestoreInstanceState(coordinatorLayout, view, cVar.getSuperState());
        }
        int i2 = cVar.f17788a;
        if (i2 == 1 || i2 == 2) {
            i2 = 5;
        }
        this.h = i2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, View view) {
        return new c(super.onSaveInstanceState(coordinatorLayout, view), this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.h == 1 && actionMasked == 0) {
            return true;
        }
        if (b()) {
            this.f5430i.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0 && (velocityTracker = this.f5435s) != null) {
            velocityTracker.recycle();
            this.f5435s = null;
        }
        if (this.f5435s == null) {
            this.f5435s = VelocityTracker.obtain();
        }
        this.f5435s.addMovement(motionEvent);
        if (b() && actionMasked == 2 && !this.j && b() && Math.abs(this.f5436t - motionEvent.getX()) > this.f5430i.getTouchSlop()) {
            this.f5430i.captureChildView(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.j;
    }

    public SideSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new h(this);
        this.g = true;
        this.h = 5;
        this.k = 0.1f;
        this.f5434r = -1;
        this.f5437u = new LinkedHashSet();
        this.f5438v = new b(this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b1.a.D);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            this.f5427c = t1.c.a(context, typedArrayObtainStyledAttributes, 3);
        }
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            this.f5428d = o.b(context, attributeSet, 0, R.style.Widget_Material3_SideSheet).a();
        }
        if (typedArrayObtainStyledAttributes.hasValue(5)) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(5, -1);
            this.f5434r = resourceId;
            WeakReference weakReference = this.f5433q;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.f5433q = null;
            WeakReference weakReference2 = this.p;
            if (weakReference2 != null) {
                View view = (View) weakReference2.get();
                if (resourceId != -1 && view.isLaidOut()) {
                    view.requestLayout();
                }
            }
        }
        o oVar = this.f5428d;
        if (oVar != null) {
            k kVar = new k(oVar);
            this.f5426b = kVar;
            kVar.l(context);
            ColorStateList colorStateList = this.f5427c;
            if (colorStateList != null) {
                this.f5426b.p(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.f5426b.setTint(typedValue.data);
            }
        }
        this.f5429f = typedArrayObtainStyledAttributes.getDimension(2, -1.0f);
        this.g = typedArrayObtainStyledAttributes.getBoolean(4, true);
        typedArrayObtainStyledAttributes.recycle();
        ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
