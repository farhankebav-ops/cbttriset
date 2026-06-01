package com.google.android.material.appbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f5247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f5248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout.BaseBehavior f5249c;

    public b(CoordinatorLayout coordinatorLayout, AppBarLayout.BaseBehavior baseBehavior, AppBarLayout appBarLayout) {
        this.f5249c = baseBehavior;
        this.f5247a = appBarLayout;
        this.f5248b = coordinatorLayout;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
        AppBarLayout appBarLayout = this.f5247a;
        if (appBarLayout.getTotalScrollRange() == 0) {
            return;
        }
        CoordinatorLayout coordinatorLayout = this.f5248b;
        AppBarLayout.BaseBehavior baseBehavior = this.f5249c;
        View viewF = AppBarLayout.BaseBehavior.f(baseBehavior, coordinatorLayout);
        if (viewF == null) {
            return;
        }
        baseBehavior.getClass();
        int childCount = appBarLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (((d1.c) appBarLayout.getChildAt(i2).getLayoutParams()).f11030a != 0) {
                if (baseBehavior.c() != (-appBarLayout.getTotalScrollRange())) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    accessibilityNodeInfoCompat.setScrollable(true);
                }
                if (baseBehavior.c() != 0) {
                    if (!viewF.canScrollVertically(-1)) {
                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                        accessibilityNodeInfoCompat.setScrollable(true);
                        return;
                    } else {
                        if ((-appBarLayout.getDownNestedPreScrollRange()) != 0) {
                            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                            accessibilityNodeInfoCompat.setScrollable(true);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
        AppBarLayout appBarLayout = this.f5247a;
        if (i2 == 4096) {
            appBarLayout.setExpanded(false);
            return true;
        }
        if (i2 != 8192) {
            return super.performAccessibilityAction(view, i2, bundle);
        }
        AppBarLayout.BaseBehavior baseBehavior = this.f5249c;
        if (baseBehavior.c() != 0) {
            View viewF = AppBarLayout.BaseBehavior.f(baseBehavior, this.f5248b);
            if (!viewF.canScrollVertically(-1)) {
                appBarLayout.setExpanded(true);
                return true;
            }
            int i8 = -appBarLayout.getDownNestedPreScrollRange();
            if (i8 != 0) {
                baseBehavior.i(this.f5248b, this.f5247a, viewF, i8, new int[]{0, 0});
                return true;
            }
        }
        return false;
    }
}
