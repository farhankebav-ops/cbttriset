package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.support.v4.media.g;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.cbt.exam.browser.R;
import com.google.android.material.appbar.AppBarLayout;
import d1.e;
import d1.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import q1.l;
import r2.q;
import w1.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5224d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5225f;
    public WindowInsetsCompat g;
    public boolean h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5226i;
    public boolean j;
    public boolean k;
    public ColorStateList l;
    public int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public WeakReference f5227n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ValueAnimator f5228o;
    public ValueAnimator.AnimatorUpdateListener p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayList f5229q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final LinkedHashSet f5230r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f5231s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final TimeInterpolator f5232t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int[] f5233u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f5234v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Drawable f5235w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Integer f5236x;
    public final float y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Behavior f5237z;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class ScrollingViewBehavior extends e {
        public ScrollingViewBehavior() {
        }

        public static AppBarLayout d(List list) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) list.get(i2);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                ViewCompat.offsetTopAndBottom(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) behavior).j) + this.e) - c(view2));
            }
            if (!(view2 instanceof AppBarLayout)) {
                return false;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view2;
            if (!appBarLayout.k) {
                return false;
            }
            appBarLayout.e(appBarLayout.f(view));
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                ViewCompat.setAccessibilityDelegate(coordinatorLayout, null);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z2) {
            AppBarLayout appBarLayoutD = d(coordinatorLayout.getDependencies(view));
            if (appBarLayoutD != null) {
                Rect rect2 = new Rect(rect);
                rect2.offset(view.getLeft(), view.getTop());
                int width = coordinatorLayout.getWidth();
                int height = coordinatorLayout.getHeight();
                Rect rect3 = this.f11037c;
                rect3.set(0, 0, width, height);
                if (!rect3.contains(rect2)) {
                    appBarLayoutD.d(false, !z2, true);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b1.a.B);
            this.f11039f = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(b2.a.a(context, attributeSet, R.attr.appBarLayoutStyle, R.style.Widget_Design_AppBarLayout), attributeSet, R.attr.appBarLayoutStyle);
        this.f5222b = -1;
        this.f5223c = -1;
        this.f5224d = -1;
        this.f5225f = 0;
        this.f5229q = new ArrayList();
        this.f5230r = new LinkedHashSet();
        Context context2 = getContext();
        setOrientation(1);
        if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
        Context context3 = getContext();
        TypedArray typedArrayD = l.d(context3, attributeSet, h.f11046a, R.attr.appBarLayoutStyle, R.style.Widget_Design_AppBarLayout, new int[0]);
        try {
            if (typedArrayD.hasValue(0)) {
                setStateListAnimator(AnimatorInflater.loadStateListAnimator(context3, typedArrayD.getResourceId(0, 0)));
            }
            typedArrayD.recycle();
            TypedArray typedArrayD2 = l.d(context2, attributeSet, b1.a.f4126a, R.attr.appBarLayoutStyle, R.style.Widget_Design_AppBarLayout, new int[0]);
            this.l = t1.c.a(context2, typedArrayD2, 6);
            this.f5231s = a.a.S(context2, R.attr.motionDurationMedium2, getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
            this.f5232t = a.a.T(context2, R.attr.motionEasingStandardInterpolator, c1.a.f4168a);
            if (typedArrayD2.hasValue(4)) {
                d(typedArrayD2.getBoolean(4, false), false, false);
            }
            if (typedArrayD2.hasValue(3)) {
                h.a(this, typedArrayD2.getDimensionPixelSize(3, 0));
            }
            setBackground(typedArrayD2.getDrawable(0));
            if (Build.VERSION.SDK_INT >= 26) {
                if (typedArrayD2.hasValue(2)) {
                    setKeyboardNavigationCluster(typedArrayD2.getBoolean(2, false));
                }
                if (typedArrayD2.hasValue(1)) {
                    setTouchscreenBlocksFocus(typedArrayD2.getBoolean(1, false));
                }
            }
            this.y = getResources().getDimension(R.dimen.design_appbar_elevation);
            this.k = typedArrayD2.getBoolean(5, false);
            this.m = typedArrayD2.getResourceId(7, -1);
            setStatusBarForeground(typedArrayD2.getDrawable(8));
            typedArrayD2.recycle();
            ViewCompat.setOnApplyWindowInsetsListener(this, new a4.a(this, 8));
        } catch (Throwable th) {
            typedArrayD.recycle();
            throw th;
        }
    }

    public static d1.c b(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            d1.c cVar = new d1.c((LinearLayout.LayoutParams) layoutParams);
            cVar.f11030a = 1;
            return cVar;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            d1.c cVar2 = new d1.c((ViewGroup.MarginLayoutParams) layoutParams);
            cVar2.f11030a = 1;
            return cVar2;
        }
        d1.c cVar3 = new d1.c(layoutParams);
        cVar3.f11030a = 1;
        return cVar3;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final d1.c generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        d1.c cVar = new d1.c(context, attributeSet);
        cVar.f11030a = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b1.a.f4127b);
        cVar.f11030a = typedArrayObtainStyledAttributes.getInt(1, 0);
        cVar.f11031b = typedArrayObtainStyledAttributes.getInt(0, 0) != 1 ? null : new g(3);
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            cVar.f11032c = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(2, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
        return cVar;
    }

    public final void c() {
        Behavior behavior = this.f5237z;
        d dVarJ = (behavior == null || this.f5222b == -1 || this.f5225f != 0) ? null : behavior.j(AbsSavedState.EMPTY_STATE, this);
        this.f5222b = -1;
        this.f5223c = -1;
        this.f5224d = -1;
        if (dVarJ != null) {
            Behavior behavior2 = this.f5237z;
            if (behavior2.m != null) {
                return;
            }
            behavior2.m = dVarJ;
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof d1.c;
    }

    public final void d(boolean z2, boolean z7, boolean z8) {
        this.f5225f = (z2 ? 1 : 2) | (z7 ? 4 : 0) | (z8 ? 8 : 0);
        requestLayout();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f5235w == null || getTopInset() <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(0.0f, -this.f5221a);
        this.f5235w.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f5235w;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public final boolean e(boolean z2) {
        if (this.h || this.j == z2) {
            return false;
        }
        this.j = z2;
        refreshDrawableState();
        if (!(getBackground() instanceof k)) {
            return true;
        }
        if (this.l != null) {
            g(z2 ? 0.0f : 1.0f, z2 ? 1.0f : 0.0f);
            return true;
        }
        if (!this.k) {
            return true;
        }
        float f4 = this.y;
        g(z2 ? 0.0f : f4, z2 ? f4 : 0.0f);
        return true;
    }

    public final boolean f(View view) {
        int i2;
        if (this.f5227n == null && (i2 = this.m) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i2) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.m);
            }
            if (viewFindViewById != null) {
                this.f5227n = new WeakReference(viewFindViewById);
            }
        }
        WeakReference weakReference = this.f5227n;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view = view2;
        }
        if (view != null) {
            return view.canScrollVertically(-1) || view.getScrollY() > 0;
        }
        return false;
    }

    public final void g(float f4, float f8) {
        ValueAnimator valueAnimator = this.f5228o;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f4, f8);
        this.f5228o = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.f5231s);
        this.f5228o.setInterpolator(this.f5232t);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.p;
        if (animatorUpdateListener != null) {
            this.f5228o.addUpdateListener(animatorUpdateListener);
        }
        this.f5228o.start();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        d1.c cVar = new d1.c(-1, -2);
        cVar.f11030a = 1;
        return cVar;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        Behavior behavior = new Behavior();
        this.f5237z = behavior;
        return behavior;
    }

    public int getDownNestedPreScrollRange() {
        int iMin;
        int minimumHeight;
        int i2 = this.f5223c;
        if (i2 != -1) {
            return i2;
        }
        int i8 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                d1.c cVar = (d1.c) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i9 = cVar.f11030a;
                if ((i9 & 5) != 5) {
                    if (i8 > 0) {
                        break;
                    }
                } else {
                    int i10 = ((LinearLayout.LayoutParams) cVar).topMargin + ((LinearLayout.LayoutParams) cVar).bottomMargin;
                    if ((i9 & 8) != 0) {
                        minimumHeight = childAt.getMinimumHeight();
                    } else if ((i9 & 2) != 0) {
                        minimumHeight = measuredHeight - childAt.getMinimumHeight();
                    } else {
                        iMin = i10 + measuredHeight;
                        if (childCount == 0 && childAt.getFitsSystemWindows()) {
                            iMin = Math.min(iMin, measuredHeight - getTopInset());
                        }
                        i8 += iMin;
                    }
                    iMin = minimumHeight + i10;
                    if (childCount == 0) {
                        iMin = Math.min(iMin, measuredHeight - getTopInset());
                    }
                    i8 += iMin;
                }
            }
        }
        int iMax = Math.max(0, i8);
        this.f5223c = iMax;
        return iMax;
    }

    public int getDownNestedScrollRange() {
        int i2 = this.f5224d;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i8 = 0;
        int minimumHeight = 0;
        while (true) {
            if (i8 >= childCount) {
                break;
            }
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                d1.c cVar = (d1.c) childAt.getLayoutParams();
                int measuredHeight = ((LinearLayout.LayoutParams) cVar).topMargin + ((LinearLayout.LayoutParams) cVar).bottomMargin + childAt.getMeasuredHeight();
                int i9 = cVar.f11030a;
                if ((i9 & 1) == 0) {
                    break;
                }
                minimumHeight += measuredHeight;
                if ((i9 & 2) != 0) {
                    minimumHeight -= childAt.getMinimumHeight();
                    break;
                }
            }
            i8++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.f5224d = iMax;
        return iMax;
    }

    @IdRes
    public int getLiftOnScrollTargetViewId() {
        return this.m;
    }

    @Nullable
    public k getMaterialShapeBackground() {
        Drawable background = getBackground();
        if (background instanceof k) {
            return (k) background;
        }
        return null;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = getMinimumHeight();
        if (minimumHeight != 0) {
            int i2 = (minimumHeight * 2) + topInset;
            return i2 < getHeight() ? i2 : minimumHeight + topInset;
        }
        int childCount = getChildCount();
        int minimumHeight2 = childCount >= 1 ? getChildAt(childCount - 1).getMinimumHeight() : 0;
        if (minimumHeight2 == 0) {
            return getHeight() / 3;
        }
        int i8 = (minimumHeight2 * 2) + topInset;
        return i8 < getHeight() ? i8 : minimumHeight2 + topInset;
    }

    public int getPendingAction() {
        return this.f5225f;
    }

    @Nullable
    public Drawable getStatusBarForeground() {
        return this.f5235w;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    @VisibleForTesting
    public final int getTopInset() {
        WindowInsetsCompat windowInsetsCompat = this.g;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.getSystemWindowInsetTop();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i2 = this.f5222b;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i8 = 0;
        int minimumHeight = 0;
        while (true) {
            if (i8 >= childCount) {
                break;
            }
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                d1.c cVar = (d1.c) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i9 = cVar.f11030a;
                if ((i9 & 1) == 0) {
                    break;
                }
                int topInset = measuredHeight + ((LinearLayout.LayoutParams) cVar).topMargin + ((LinearLayout.LayoutParams) cVar).bottomMargin + minimumHeight;
                if (i8 == 0 && childAt.getFitsSystemWindows()) {
                    topInset -= getTopInset();
                }
                minimumHeight = topInset;
                if ((i9 & 2) != 0) {
                    minimumHeight -= childAt.getMinimumHeight();
                    break;
                }
            }
            i8++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.f5222b = iMax;
        return iMax;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof k) {
            q.u0(this, (k) background);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i2) {
        if (this.f5233u == null) {
            this.f5233u = new int[4];
        }
        int[] iArr = this.f5233u;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + iArr.length);
        boolean z2 = this.f5226i;
        iArr[0] = z2 ? R.attr.state_liftable : -2130969768;
        iArr[1] = (z2 && this.j) ? R.attr.state_lifted : -2130969769;
        iArr[2] = z2 ? R.attr.state_collapsible : -2130969764;
        iArr[3] = (z2 && this.j) ? R.attr.state_collapsed : -2130969763;
        return View.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference weakReference = this.f5227n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f5227n = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        super.onLayout(z2, i2, i8, i9, i10);
        boolean z7 = true;
        if (getFitsSystemWindows() && getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8 && !childAt.getFitsSystemWindows()) {
                int topInset = getTopInset();
                for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                    ViewCompat.offsetTopAndBottom(getChildAt(childCount), topInset);
                }
            }
        }
        c();
        this.e = false;
        int childCount2 = getChildCount();
        int i11 = 0;
        while (true) {
            if (i11 >= childCount2) {
                break;
            }
            if (((d1.c) getChildAt(i11).getLayoutParams()).f11032c != null) {
                this.e = true;
                break;
            }
            i11++;
        }
        Drawable drawable = this.f5235w;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.h) {
            return;
        }
        if (!this.k) {
            int childCount3 = getChildCount();
            int i12 = 0;
            while (true) {
                if (i12 >= childCount3) {
                    z7 = false;
                    break;
                }
                int i13 = ((d1.c) getChildAt(i12).getLayoutParams()).f11030a;
                if ((i13 & 1) == 1 && (i13 & 10) != 0) {
                    break;
                } else {
                    i12++;
                }
            }
        }
        if (this.f5226i != z7) {
            this.f5226i = z7;
            refreshDrawableState();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
        int mode = View.MeasureSpec.getMode(i8);
        if (mode != 1073741824 && getFitsSystemWindows() && getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8 && !childAt.getFitsSystemWindows()) {
                int measuredHeight = getMeasuredHeight();
                if (mode == Integer.MIN_VALUE) {
                    measuredHeight = MathUtils.clamp(getTopInset() + getMeasuredHeight(), 0, View.MeasureSpec.getSize(i8));
                } else if (mode == 0) {
                    measuredHeight += getTopInset();
                }
                setMeasuredDimension(getMeasuredWidth(), measuredHeight);
            }
        }
        c();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        final k kVar;
        ColorStateList colorStateList;
        Context context = getContext();
        final Integer numValueOf = null;
        if (drawable instanceof k) {
            kVar = (k) drawable;
        } else {
            ColorStateList colorStateListA = o1.c.a(drawable);
            if (colorStateListA == null) {
                kVar = null;
            } else {
                k kVar2 = new k();
                kVar2.p(colorStateListA);
                kVar = kVar2;
            }
        }
        if (kVar != null && (colorStateList = kVar.f17716b.f17708d) != null) {
            this.f5234v = colorStateList.getDefaultColor();
            final ColorStateList colorStateList2 = this.l;
            if (colorStateList2 != null) {
                Context context2 = getContext();
                TypedValue typedValueA = t1.b.a(context2, R.attr.colorSurface);
                if (typedValueA != null) {
                    int i2 = typedValueA.resourceId;
                    numValueOf = Integer.valueOf(i2 != 0 ? ContextCompat.getColor(context2, i2) : typedValueA.data);
                }
                this.p = new ValueAnimator.AnimatorUpdateListener() { // from class: d1.a
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Integer num;
                        AppBarLayout appBarLayout = this.f11024a;
                        LinkedHashSet linkedHashSet = appBarLayout.f5230r;
                        ArrayList arrayList = appBarLayout.f5229q;
                        int iC = m1.a.c(appBarLayout.f5234v, colorStateList2.getDefaultColor(), ((Float) valueAnimator.getAnimatedValue()).floatValue());
                        ColorStateList colorStateListValueOf = ColorStateList.valueOf(iC);
                        k kVar3 = kVar;
                        kVar3.p(colorStateListValueOf);
                        if (appBarLayout.f5235w != null && (num = appBarLayout.f5236x) != null && num.equals(numValueOf)) {
                            appBarLayout.f5235w.setTint(iC);
                        }
                        if (!arrayList.isEmpty()) {
                            int size = arrayList.size();
                            int i8 = 0;
                            while (i8 < size) {
                                Object obj = arrayList.get(i8);
                                i8++;
                                if (obj != null) {
                                    throw new ClassCastException();
                                }
                                if (kVar3.f17716b.f17708d != null) {
                                    throw null;
                                }
                            }
                        }
                        if (linkedHashSet.isEmpty()) {
                            return;
                        }
                        Iterator it = linkedHashSet.iterator();
                        if (it.hasNext()) {
                            it.next().getClass();
                            throw new ClassCastException();
                        }
                    }
                };
            } else {
                kVar.l(context);
                this.p = new ValueAnimator.AnimatorUpdateListener() { // from class: d1.b
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int i8 = AppBarLayout.A;
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        kVar.o(fFloatValue);
                        AppBarLayout appBarLayout = this.f11028a;
                        Drawable drawable2 = appBarLayout.f5235w;
                        if (drawable2 instanceof k) {
                            ((k) drawable2).o(fFloatValue);
                        }
                        Iterator it = appBarLayout.f5229q.iterator();
                        if (it.hasNext()) {
                            it.next().getClass();
                            throw new ClassCastException();
                        }
                        Iterator it2 = appBarLayout.f5230r.iterator();
                        if (it2.hasNext()) {
                            it2.next().getClass();
                            throw new ClassCastException();
                        }
                    }
                };
            }
            drawable = kVar;
        }
        super.setBackground(drawable);
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        super.setElevation(f4);
        Drawable background = getBackground();
        if (background instanceof k) {
            ((k) background).o(f4);
        }
    }

    public void setExpanded(boolean z2) {
        d(z2, isLaidOut(), true);
    }

    public void setLiftOnScroll(boolean z2) {
        this.k = z2;
    }

    public void setLiftOnScrollColor(@Nullable ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            setBackground(getBackground());
        }
    }

    public void setLiftOnScrollTargetView(@Nullable View view) {
        this.m = -1;
        if (view != null) {
            this.f5227n = new WeakReference(view);
            return;
        }
        WeakReference weakReference = this.f5227n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f5227n = null;
    }

    public void setLiftOnScrollTargetViewId(@IdRes int i2) {
        this.m = i2;
        WeakReference weakReference = this.f5227n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f5227n = null;
    }

    public void setLiftableOverrideEnabled(boolean z2) {
        this.h = z2;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i2) {
        if (i2 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i2);
    }

    public void setPendingAction(int i2) {
        this.f5225f = i2;
    }

    public void setStatusBarForeground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f5235w;
        if (drawable2 != drawable) {
            Integer numValueOf = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f5235w = drawableMutate;
            if (drawableMutate instanceof k) {
                numValueOf = Integer.valueOf(((k) drawableMutate).f17728v);
            } else {
                ColorStateList colorStateListA = o1.c.a(drawableMutate);
                if (colorStateListA != null) {
                    numValueOf = Integer.valueOf(colorStateListA.getDefaultColor());
                }
            }
            this.f5236x = numValueOf;
            Drawable drawable3 = this.f5235w;
            boolean z2 = false;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f5235w.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.f5235w, getLayoutDirection());
                this.f5235w.setVisible(getVisibility() == 0, false);
                this.f5235w.setCallback(this);
            }
            if (this.f5235w != null && getTopInset() > 0) {
                z2 = true;
            }
            setWillNotDraw(!z2);
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarForegroundColor(@ColorInt int i2) {
        setStatusBarForeground(new ColorDrawable(i2));
    }

    public void setStatusBarForegroundResource(@DrawableRes int i2) {
        setStatusBarForeground(AppCompatResources.getDrawable(getContext(), i2));
    }

    @Deprecated
    public void setTargetElevation(float f4) {
        h.a(this, f4);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z2 = i2 == 0;
        Drawable drawable = this.f5235w;
        if (drawable != null) {
            drawable.setVisible(z2, false);
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f5235w;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return b(layoutParams);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class BaseBehavior<T extends AppBarLayout> extends d1.d {
        public int j;
        public int k;
        public ValueAnimator l;
        public d m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public WeakReference f5238n;

        public BaseBehavior() {
            this.f11035f = -1;
            this.h = -1;
        }

        public static View f(BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if (((CoordinatorLayout.LayoutParams) childAt.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        public static View h(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if ((childAt instanceof NestedScrollingChild) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x005a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static void l(androidx.coordinatorlayout.widget.CoordinatorLayout r6, com.google.android.material.appbar.AppBarLayout r7, int r8, int r9, boolean r10) {
            /*
                int r0 = java.lang.Math.abs(r8)
                int r1 = r7.getChildCount()
                r2 = 0
                r3 = r2
            La:
                if (r3 >= r1) goto L20
                android.view.View r4 = r7.getChildAt(r3)
                int r5 = r4.getTop()
                if (r0 < r5) goto L1d
                int r5 = r4.getBottom()
                if (r0 > r5) goto L1d
                goto L21
            L1d:
                int r3 = r3 + 1
                goto La
            L20:
                r4 = 0
            L21:
                if (r4 == 0) goto L5a
                android.view.ViewGroup$LayoutParams r0 = r4.getLayoutParams()
                d1.c r0 = (d1.c) r0
                int r0 = r0.f11030a
                r1 = r0 & 1
                if (r1 == 0) goto L5a
                int r1 = r4.getMinimumHeight()
                r3 = 1
                if (r9 <= 0) goto L48
                r9 = r0 & 12
                if (r9 == 0) goto L48
                int r8 = -r8
                int r9 = r4.getBottom()
                int r9 = r9 - r1
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L5a
                goto L5b
            L48:
                r9 = r0 & 2
                if (r9 == 0) goto L5a
                int r8 = -r8
                int r9 = r4.getBottom()
                int r9 = r9 - r1
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L5a
                goto L5b
            L5a:
                r3 = r2
            L5b:
                boolean r8 = r7.k
                if (r8 == 0) goto L67
                android.view.View r8 = h(r6)
                boolean r3 = r7.f(r8)
            L67:
                boolean r8 = r7.e(r3)
                if (r10 != 0) goto L97
                if (r8 == 0) goto Lbe
                java.util.List r6 = r6.getDependents(r7)
                int r8 = r6.size()
            L77:
                if (r2 >= r8) goto Lbe
                java.lang.Object r9 = r6.get(r2)
                android.view.View r9 = (android.view.View) r9
                android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
                androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r9 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r9
                androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r9 = r9.getBehavior()
                boolean r10 = r9 instanceof com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior
                if (r10 == 0) goto L94
                com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior r9 = (com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior) r9
                int r6 = r9.f11039f
                if (r6 == 0) goto Lbe
                goto L97
            L94:
                int r2 = r2 + 1
                goto L77
            L97:
                android.graphics.drawable.Drawable r6 = r7.getBackground()
                if (r6 == 0) goto La4
                android.graphics.drawable.Drawable r6 = r7.getBackground()
                r6.jumpToCurrentState()
            La4:
                android.graphics.drawable.Drawable r6 = r7.getForeground()
                if (r6 == 0) goto Lb1
                android.graphics.drawable.Drawable r6 = r7.getForeground()
                r6.jumpToCurrentState()
            Lb1:
                android.animation.StateListAnimator r6 = r7.getStateListAnimator()
                if (r6 == 0) goto Lbe
                android.animation.StateListAnimator r6 = r7.getStateListAnimator()
                r6.jumpToCurrentState()
            Lbe:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.l(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int, int, boolean):void");
        }

        @Override // d1.d
        public final int c() {
            return a() + this.j;
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0144  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0157  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x015c  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x015e  */
        @Override // d1.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final int d(androidx.coordinatorlayout.widget.CoordinatorLayout r18, android.view.View r19, int r20, int r21, int r22) {
            /*
                Method dump skipped, instruction units count: 373
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.d(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int, int, int):int");
        }

        public final void g(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2) {
            int iAbs = Math.abs(c() - i2);
            float fAbs = Math.abs(0.0f);
            int iRound = fAbs > 0.0f ? Math.round((iAbs / fAbs) * 1000.0f) * 3 : (int) (((iAbs / appBarLayout.getHeight()) + 1.0f) * 150.0f);
            int iC = c();
            if (iC == i2) {
                ValueAnimator valueAnimator = this.l;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.l.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.l;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.l = valueAnimator3;
                valueAnimator3.setInterpolator(c1.a.e);
                this.l.addUpdateListener(new a(coordinatorLayout, this, appBarLayout));
            } else {
                valueAnimator2.cancel();
            }
            this.l.setDuration(Math.min(iRound, 600));
            this.l.setIntValues(iC, i2);
            this.l.start();
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void i(androidx.coordinatorlayout.widget.CoordinatorLayout r9, com.google.android.material.appbar.AppBarLayout r10, android.view.View r11, int r12, int[] r13) {
            /*
                r8 = this;
                if (r12 == 0) goto L2b
                if (r12 >= 0) goto L11
                int r0 = r10.getTotalScrollRange()
                int r0 = -r0
                int r1 = r10.getDownNestedPreScrollRange()
                int r1 = r1 + r0
            Le:
                r6 = r0
                r7 = r1
                goto L18
            L11:
                int r0 = r10.getUpNestedPreScrollRange()
                int r0 = -r0
                r1 = 0
                goto Le
            L18:
                if (r6 == r7) goto L2b
                int r0 = r8.c()
                int r5 = r0 - r12
                r2 = r8
                r3 = r9
                r4 = r10
                int r9 = r2.d(r3, r4, r5, r6, r7)
                r10 = 1
                r13[r10] = r9
                goto L2c
            L2b:
                r4 = r10
            L2c:
                boolean r9 = r4.k
                if (r9 == 0) goto L37
                boolean r9 = r4.f(r11)
                r4.e(r9)
            L37:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.i(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.view.View, int, int[]):void");
        }

        public final d j(Parcelable parcelable, AppBarLayout appBarLayout) {
            int iA = a();
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                int bottom = childAt.getBottom() + iA;
                if (childAt.getTop() + iA <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = AbsSavedState.EMPTY_STATE;
                    }
                    d dVar = new d(parcelable);
                    boolean z2 = iA == 0;
                    dVar.f5251b = z2;
                    dVar.f5250a = !z2 && (-iA) >= appBarLayout.getTotalScrollRange();
                    dVar.f5252c = i2;
                    dVar.e = bottom == appBarLayout.getTopInset() + childAt.getMinimumHeight();
                    dVar.f5253d = bottom / childAt.getHeight();
                    return dVar;
                }
            }
            return null;
        }

        public final void k(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int paddingTop = appBarLayout.getPaddingTop() + appBarLayout.getTopInset();
            int iC = c() - paddingTop;
            int childCount = appBarLayout.getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    i2 = -1;
                    break;
                }
                View childAt = appBarLayout.getChildAt(i2);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                d1.c cVar = (d1.c) childAt.getLayoutParams();
                if ((cVar.f11030a & 32) == 32) {
                    top -= ((LinearLayout.LayoutParams) cVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) cVar).bottomMargin;
                }
                int i8 = -iC;
                if (top <= i8 && bottom >= i8) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 >= 0) {
                View childAt2 = appBarLayout.getChildAt(i2);
                d1.c cVar2 = (d1.c) childAt2.getLayoutParams();
                int i9 = cVar2.f11030a;
                if ((i9 & 17) == 17) {
                    int topInset = -childAt2.getTop();
                    int minimumHeight = -childAt2.getBottom();
                    if (i2 == 0 && appBarLayout.getFitsSystemWindows() && childAt2.getFitsSystemWindows()) {
                        topInset -= appBarLayout.getTopInset();
                    }
                    if ((i9 & 2) == 2) {
                        minimumHeight += childAt2.getMinimumHeight();
                    } else if ((i9 & 5) == 5) {
                        int minimumHeight2 = childAt2.getMinimumHeight() + minimumHeight;
                        if (iC < minimumHeight2) {
                            topInset = minimumHeight2;
                        } else {
                            minimumHeight = minimumHeight2;
                        }
                    }
                    if ((i9 & 32) == 32) {
                        topInset += ((LinearLayout.LayoutParams) cVar2).topMargin;
                        minimumHeight -= ((LinearLayout.LayoutParams) cVar2).bottomMargin;
                    }
                    if (iC < (minimumHeight + topInset) / 2) {
                        topInset = minimumHeight;
                    }
                    g(coordinatorLayout, appBarLayout, MathUtils.clamp(topInset + paddingTop, -appBarLayout.getTotalScrollRange(), 0));
                }
            }
        }

        @Override // d1.f, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i2) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            super.onLayoutChild(coordinatorLayout, appBarLayout, i2);
            int pendingAction = appBarLayout.getPendingAction();
            d dVar = this.m;
            if (dVar == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z2 = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i8 = -appBarLayout.getUpNestedPreScrollRange();
                        if (z2) {
                            g(coordinatorLayout, appBarLayout, i8);
                        } else {
                            e(coordinatorLayout, appBarLayout, i8);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z2) {
                            g(coordinatorLayout, appBarLayout, 0);
                        } else {
                            e(coordinatorLayout, appBarLayout, 0);
                        }
                    }
                }
            } else if (dVar.f5250a) {
                e(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange());
            } else if (dVar.f5251b) {
                e(coordinatorLayout, appBarLayout, 0);
            } else {
                View childAt = appBarLayout.getChildAt(dVar.f5252c);
                int i9 = -childAt.getBottom();
                e(coordinatorLayout, appBarLayout, this.m.e ? appBarLayout.getTopInset() + childAt.getMinimumHeight() + i9 : Math.round(childAt.getHeight() * this.m.f5253d) + i9);
            }
            appBarLayout.f5225f = 0;
            this.m = null;
            int iClamp = MathUtils.clamp(a(), -appBarLayout.getTotalScrollRange(), 0);
            d1.g gVar = this.f11040a;
            if (gVar == null) {
                this.f11041b = iClamp;
            } else if (gVar.f11044c != iClamp) {
                gVar.f11044c = iClamp;
                gVar.b();
            }
            l(coordinatorLayout, appBarLayout, a(), 0, true);
            appBarLayout.f5221a = a();
            if (!appBarLayout.willNotDraw()) {
                appBarLayout.postInvalidateOnAnimation();
            }
            if (!ViewCompat.hasAccessibilityDelegate(coordinatorLayout)) {
                ViewCompat.setAccessibilityDelegate(coordinatorLayout, new b(coordinatorLayout, this, appBarLayout));
            }
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i2, int i8, int i9, int i10) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams())).height != -2) {
                return super.onMeasureChild(coordinatorLayout, appBarLayout, i2, i8, i9, i10);
            }
            coordinatorLayout.onMeasureChild(appBarLayout, i2, i8, View.MeasureSpec.makeMeasureSpec(0, 0), i10);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i8, int[] iArr, int i9) {
            i(coordinatorLayout, (AppBarLayout) view, view2, i8, iArr);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i8, int i9, int i10, int i11, int[] iArr) {
            CoordinatorLayout coordinatorLayout2;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i10 < 0) {
                int i12 = -appBarLayout.getDownNestedScrollRange();
                coordinatorLayout2 = coordinatorLayout;
                iArr[1] = d(coordinatorLayout2, appBarLayout, c() - i10, i12, 0);
            } else {
                coordinatorLayout2 = coordinatorLayout;
            }
            if (i10 != 0 || ViewCompat.hasAccessibilityDelegate(coordinatorLayout2)) {
                return;
            }
            ViewCompat.setAccessibilityDelegate(coordinatorLayout2, new b(coordinatorLayout2, this, appBarLayout));
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (!(parcelable instanceof d)) {
                super.onRestoreInstanceState(coordinatorLayout, appBarLayout, parcelable);
                this.m = null;
            } else {
                d dVar = (d) parcelable;
                this.m = dVar;
                super.onRestoreInstanceState(coordinatorLayout, appBarLayout, dVar.getSuperState());
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, appBarLayout);
            d dVarJ = j(parcelableOnSaveInstanceState, appBarLayout);
            return dVarJ == null ? parcelableOnSaveInstanceState : dVarJ;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i2, int i8) {
            ValueAnimator valueAnimator;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            boolean z2 = (i2 & 2) != 0 && (appBarLayout.k || appBarLayout.j || (appBarLayout.getTotalScrollRange() != 0 && coordinatorLayout.getHeight() - view2.getHeight() <= appBarLayout.getHeight()));
            if (z2 && (valueAnimator = this.l) != null) {
                valueAnimator.cancel();
            }
            this.f5238n = null;
            this.k = i8;
            return z2;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i2) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (this.k == 0 || i2 == 1) {
                k(coordinatorLayout, appBarLayout);
                if (appBarLayout.k) {
                    appBarLayout.e(appBarLayout.f(view2));
                }
            }
            this.f5238n = new WeakReference(view2);
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f11035f = -1;
            this.h = -1;
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateDefaultLayoutParams() {
        d1.c cVar = new d1.c(-1, -2);
        cVar.f11030a = 1;
        return cVar;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return b(layoutParams);
    }
}
