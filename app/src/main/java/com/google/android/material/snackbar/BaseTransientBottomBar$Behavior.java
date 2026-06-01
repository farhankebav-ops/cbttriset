package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import w3.a;
import y1.b;
import y1.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class BaseTransientBottomBar$Behavior extends SwipeDismissBehavior<View> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f5439i;

    public BaseTransientBottomBar$Behavior() {
        b bVar = new b();
        this.f5270f = Math.min(Math.max(0.0f, 0.1f), 1.0f);
        this.g = Math.min(Math.max(0.0f, 0.6f), 1.0f);
        this.f5269d = 0;
        this.f5439i = bVar;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior
    public final boolean a(View view) {
        this.f5439i.getClass();
        return view instanceof c;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        this.f5439i.getClass();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                if (a.f17771c == null) {
                    a.f17771c = new a();
                }
                synchronized (a.f17771c.f17773b) {
                }
            }
        } else if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            if (a.f17771c == null) {
                a.f17771c = new a();
            }
            a.f17771c.a();
        }
        return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
    }
}
