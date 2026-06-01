package e1;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;
import z1.n;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11211b;

    public /* synthetic */ b(Object obj, int i2) {
        this.f11210a = i2;
        this.f11211b = obj;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        switch (this.f11210a) {
            case 0:
            case 1:
                break;
            default:
                n nVar = (n) this.f11211b;
                AccessibilityManager accessibilityManager = nVar.f17930t;
                if (nVar.f17931u != null && accessibilityManager != null && nVar.isAttachedToWindow()) {
                    accessibilityManager.addTouchExplorationStateChangeListener(nVar.f17931u);
                    break;
                }
                break;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        AccessibilityManager accessibilityManager;
        AccessibilityManager accessibilityManager2;
        AccessibilityManager accessibilityManager3;
        switch (this.f11210a) {
            case 0:
                HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior = (HideBottomViewOnScrollBehavior) this.f11211b;
                a aVar = hideBottomViewOnScrollBehavior.h;
                if (aVar != null && (accessibilityManager = hideBottomViewOnScrollBehavior.g) != null) {
                    accessibilityManager.removeTouchExplorationStateChangeListener(aVar);
                    hideBottomViewOnScrollBehavior.h = null;
                    break;
                }
                break;
            case 1:
                HideViewOnScrollBehavior hideViewOnScrollBehavior = (HideViewOnScrollBehavior) this.f11211b;
                a aVar2 = hideViewOnScrollBehavior.f5262c;
                if (aVar2 != null && (accessibilityManager2 = hideViewOnScrollBehavior.f5261b) != null) {
                    accessibilityManager2.removeTouchExplorationStateChangeListener(aVar2);
                    hideViewOnScrollBehavior.f5262c = null;
                    break;
                }
                break;
            default:
                n nVar = (n) this.f11211b;
                AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = nVar.f17931u;
                if (touchExplorationStateChangeListener != null && (accessibilityManager3 = nVar.f17930t) != null) {
                    accessibilityManager3.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
                    break;
                }
                break;
        }
    }

    private final void a(View view) {
    }

    private final void b(View view) {
    }
}
