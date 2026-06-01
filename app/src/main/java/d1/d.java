package d1;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a4.b f11033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OverScroller f11034d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11035f;
    public int g;
    public int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public VelocityTracker f11036i;

    public abstract int c();

    public abstract int d(CoordinatorLayout coordinatorLayout, View view, int i2, int i8, int i9);

    public final void e(CoordinatorLayout coordinatorLayout, View view, int i2) {
        d(coordinatorLayout, view, i2, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        View view2;
        int iFindPointerIndex;
        if (this.h < 0) {
            this.h = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.e) {
            int i2 = this.f11035f;
            if (i2 == -1 || (iFindPointerIndex = motionEvent.findPointerIndex(i2)) == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(iFindPointerIndex);
            if (Math.abs(y - this.g) > this.h) {
                this.g = y;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f11035f = -1;
            int x2 = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            WeakReference weakReference = ((AppBarLayout.BaseBehavior) this).f5238n;
            boolean z2 = (weakReference == null || !((view2 = (View) weakReference.get()) == null || !view2.isShown() || view2.canScrollVertically(-1))) && coordinatorLayout.isPointInChildBounds(view, x2, y2);
            this.e = z2;
            if (z2) {
                this.g = y2;
                this.f11035f = motionEvent.getPointerId(0);
                if (this.f11036i == null) {
                    this.f11036i = VelocityTracker.obtain();
                }
                OverScroller overScroller = this.f11034d;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f11034d.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f11036i;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fb A[ADDED_TO_REGION] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r21, android.view.View r22, android.view.MotionEvent r23) {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.d.onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }
}
