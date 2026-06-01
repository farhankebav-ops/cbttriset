package d1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class f extends CoordinatorLayout.Behavior {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f11040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11041b;

    public f() {
        this.f11041b = 0;
    }

    public final int a() {
        g gVar = this.f11040a;
        if (gVar != null) {
            return gVar.f11044c;
        }
        return 0;
    }

    public void b(CoordinatorLayout coordinatorLayout, View view, int i2) {
        coordinatorLayout.onLayoutChild(view, i2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i2) {
        b(coordinatorLayout, view, i2);
        if (this.f11040a == null) {
            g gVar = new g();
            gVar.f11045d = view;
            this.f11040a = gVar;
        }
        g gVar2 = this.f11040a;
        View view2 = (View) gVar2.f11045d;
        gVar2.f11042a = view2.getTop();
        gVar2.f11043b = view2.getLeft();
        this.f11040a.b();
        int i8 = this.f11041b;
        if (i8 == 0) {
            return true;
        }
        g gVar3 = this.f11040a;
        if (gVar3.f11044c != i8) {
            gVar3.f11044c = i8;
            gVar3.b();
        }
        this.f11041b = 0;
        return true;
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11041b = 0;
    }
}
