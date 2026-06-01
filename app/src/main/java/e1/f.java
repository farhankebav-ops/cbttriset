package e1;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.material.behavior.SwipeDismissBehavior;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class f implements AccessibilityViewCommand {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SwipeDismissBehavior f11218a;

    public f(SwipeDismissBehavior swipeDismissBehavior) {
        this.f11218a = swipeDismissBehavior;
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public final boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        SwipeDismissBehavior swipeDismissBehavior = this.f11218a;
        if (!swipeDismissBehavior.a(view)) {
            return false;
        }
        boolean z2 = view.getLayoutDirection() == 1;
        int i2 = swipeDismissBehavior.f5269d;
        ViewCompat.offsetLeftAndRight(view, (!(i2 == 0 && z2) && (i2 != 1 || z2)) ? view.getWidth() : -view.getWidth());
        view.setAlpha(0.0f);
        return true;
    }
}
