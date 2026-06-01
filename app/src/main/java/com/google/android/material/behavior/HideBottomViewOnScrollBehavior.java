package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import com.cbt.exam.browser.R;
import com.vungle.ads.internal.protos.Sdk;
import e1.a;
import e1.b;
import e1.c;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f5254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TimeInterpolator f5257d;
    public TimeInterpolator e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5258f;
    public AccessibilityManager g;
    public a h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f5259i;
    public int j;
    public ViewPropertyAnimator k;

    public HideBottomViewOnScrollBehavior() {
        this.f5254a = new LinkedHashSet();
        this.f5258f = 0;
        this.f5259i = true;
        this.j = 2;
    }

    public final void a(View view) {
        if (this.j == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.k;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.j = 2;
        Iterator it = this.f5254a.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        this.k = view.animate().translationY(0).setInterpolator(this.f5257d).setDuration(this.f5255b).setListener(new c(this, 0));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i2) {
        this.f5258f = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.f5255b = a.a.S(view.getContext(), R.attr.motionDurationLong2, Sdk.SDKError.Reason.AD_LOAD_FAIL_PLACEMENT_ID_MISMATCH_VALUE);
        this.f5256c = a.a.S(view.getContext(), R.attr.motionDurationMedium4, 175);
        this.f5257d = a.a.T(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, c1.a.f4171d);
        this.e = a.a.T(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, c1.a.f4170c);
        if (this.g == null) {
            this.g = (AccessibilityManager) ContextCompat.getSystemService(view.getContext(), AccessibilityManager.class);
        }
        AccessibilityManager accessibilityManager = this.g;
        if (accessibilityManager != null && this.h == null) {
            a aVar = new a(this, view, 0);
            this.h = aVar;
            accessibilityManager.addTouchExplorationStateChangeListener(aVar);
            view.addOnAttachStateChangeListener(new b(this, 0));
        }
        return super.onLayoutChild(coordinatorLayout, view, i2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i8, int i9, int i10, int i11, int[] iArr) {
        AccessibilityManager accessibilityManager;
        if (i8 <= 0) {
            if (i8 < 0) {
                a(view);
                return;
            }
            return;
        }
        if (this.j == 1) {
            return;
        }
        if (this.f5259i && (accessibilityManager = this.g) != null && accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.k;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.j = 1;
        Iterator it = this.f5254a.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        this.k = view.animate().translationY(this.f5258f).setInterpolator(this.e).setDuration(this.f5256c).setListener(new c(this, 0));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i2, int i8) {
        return i2 == 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5254a = new LinkedHashSet();
        this.f5258f = 0;
        this.f5259i = true;
        this.j = 2;
    }
}
