package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import com.cbt.exam.browser.R;
import com.vungle.ads.internal.protos.Sdk;
import e1.a;
import e1.b;
import e1.c;
import e1.d;
import java.util.Iterator;
import java.util.LinkedHashSet;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class HideViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f5260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AccessibilityManager f5261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f5262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f5263d;
    public final LinkedHashSet e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5264f;
    public int g;
    public TimeInterpolator h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TimeInterpolator f5265i;
    public int j;
    public int k;
    public ViewPropertyAnimator l;

    public HideViewOnScrollBehavior() {
        this.f5263d = true;
        this.e = new LinkedHashSet();
        this.j = 0;
        this.k = 2;
    }

    public final void a(int i2) {
        q qVar = this.f5260a;
        if (qVar == null || qVar.d0() != i2) {
            if (i2 == 0) {
                this.f5260a = new d(2);
            } else if (i2 == 1) {
                this.f5260a = new d(0);
            } else {
                if (i2 != 2) {
                    throw new IllegalArgumentException(a1.a.h(i2, "Invalid view edge position value: ", ". Must be 0, 1 or 2."));
                }
                this.f5260a = new d(1);
            }
        }
    }

    public final void b(View view) {
        if (this.k == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.l;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.k = 2;
        Iterator it = this.e.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        this.f5260a.getClass();
        this.l = this.f5260a.e0(view, 0).setInterpolator(this.h).setDuration(this.f5264f).setListener(new c(this, 1));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i2) {
        if (this.f5261b == null) {
            this.f5261b = (AccessibilityManager) ContextCompat.getSystemService(view.getContext(), AccessibilityManager.class);
        }
        AccessibilityManager accessibilityManager = this.f5261b;
        if (accessibilityManager != null && this.f5262c == null) {
            a aVar = new a(this, view, 1);
            this.f5262c = aVar;
            accessibilityManager.addTouchExplorationStateChangeListener(aVar);
            view.addOnAttachStateChangeListener(new b(this, 1));
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i8 = ((CoordinatorLayout.LayoutParams) view.getLayoutParams()).gravity;
        if (i8 == 80 || i8 == 81) {
            a(1);
        } else {
            int absoluteGravity = Gravity.getAbsoluteGravity(i8, i2);
            a((absoluteGravity == 3 || absoluteGravity == 19) ? 2 : 0);
        }
        this.j = this.f5260a.c0(view, marginLayoutParams);
        this.f5264f = a.a.S(view.getContext(), R.attr.motionDurationLong2, Sdk.SDKError.Reason.AD_LOAD_FAIL_PLACEMENT_ID_MISMATCH_VALUE);
        this.g = a.a.S(view.getContext(), R.attr.motionDurationMedium4, 175);
        this.h = a.a.T(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, c1.a.f4171d);
        this.f5265i = a.a.T(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, c1.a.f4170c);
        return super.onLayoutChild(coordinatorLayout, view, i2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i8, int i9, int i10, int i11, int[] iArr) {
        AccessibilityManager accessibilityManager;
        if (i8 <= 0) {
            if (i8 < 0) {
                b(view);
                return;
            }
            return;
        }
        if (this.k == 1) {
            return;
        }
        if (this.f5263d && (accessibilityManager = this.f5261b) != null && accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.l;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.k = 1;
        Iterator it = this.e.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        this.l = this.f5260a.e0(view, this.j).setInterpolator(this.f5265i).setDuration(this.g).setListener(new c(this, 1));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i2, int i8) {
        return i2 == 2;
    }

    public HideViewOnScrollBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5263d = true;
        this.e = new LinkedHashSet();
        this.j = 0;
        this.k = 2;
    }
}
