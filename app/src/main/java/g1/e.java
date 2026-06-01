package g1;

import android.view.View;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class e implements AccessibilityViewCommand {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f11565b;

    public e(BottomSheetBehavior bottomSheetBehavior, int i2) {
        this.f11565b = bottomSheetBehavior;
        this.f11564a = i2;
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public final boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        this.f11565b.k(this.f11564a);
        return true;
    }
}
