package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ViewDragHelper;
import e1.e;
import e1.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewDragHelper f5266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5269d = 2;
    public final float e = 0.5f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f5270f = 0.0f;
    public float g = 0.5f;
    public final e h = new e(this);

    public boolean a(View view) {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean zIsPointInChildBounds = this.f5267b;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zIsPointInChildBounds = coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f5267b = zIsPointInChildBounds;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f5267b = false;
        }
        if (zIsPointInChildBounds) {
            if (this.f5266a == null) {
                this.f5266a = ViewDragHelper.create(coordinatorLayout, this.h);
            }
            if (!this.f5268c && this.f5266a.shouldInterceptTouchEvent(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i2) {
        boolean zOnLayoutChild = super.onLayoutChild(coordinatorLayout, view, i2);
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
            ViewCompat.removeAccessibilityAction(view, 1048576);
            if (a(view)) {
                ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new f(this));
            }
        }
        return zOnLayoutChild;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.f5266a == null) {
            return false;
        }
        if (this.f5268c && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.f5266a.processTouchEvent(motionEvent);
        return true;
    }
}
