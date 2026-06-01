package e1;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f11208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout.Behavior f11209c;

    public /* synthetic */ a(CoordinatorLayout.Behavior behavior, View view, int i2) {
        this.f11207a = i2;
        this.f11209c = behavior;
        this.f11208b = view;
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z2) {
        switch (this.f11207a) {
            case 0:
                HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior = (HideBottomViewOnScrollBehavior) this.f11209c;
                if (z2 && hideBottomViewOnScrollBehavior.j == 1) {
                    hideBottomViewOnScrollBehavior.a(this.f11208b);
                    break;
                }
                break;
            default:
                HideViewOnScrollBehavior hideViewOnScrollBehavior = (HideViewOnScrollBehavior) this.f11209c;
                if (hideViewOnScrollBehavior.f5263d && z2 && hideViewOnScrollBehavior.k == 1) {
                    hideViewOnScrollBehavior.b(this.f11208b);
                    break;
                }
                break;
        }
    }
}
