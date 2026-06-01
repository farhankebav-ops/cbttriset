package e1;

import android.view.View;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.behavior.SwipeDismissBehavior;
import j4.o1;
import j4.t1;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f11221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f11222d;

    public /* synthetic */ g(int i2, Object obj, Object obj2, boolean z2) {
        this.f11219a = i2;
        this.f11222d = obj;
        this.f11221c = obj2;
        this.f11220b = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f11219a) {
            case 0:
                SwipeDismissBehavior swipeDismissBehavior = (SwipeDismissBehavior) this.f11222d;
                ViewDragHelper viewDragHelper = swipeDismissBehavior.f5266a;
                if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                    ((View) this.f11221c).postOnAnimation(this);
                } else if (this.f11220b) {
                    swipeDismissBehavior.getClass();
                }
                break;
            default:
                ((t1) this.f11222d).f12468t.c((o1) this.f11221c, this.f11220b);
                break;
        }
    }
}
