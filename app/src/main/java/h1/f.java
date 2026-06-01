package h1;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class f extends AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MaterialButtonToggleGroup f11681a;

    public f(MaterialButtonToggleGroup materialButtonToggleGroup) {
        this.f11681a = materialButtonToggleGroup;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        int i2;
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        int i8 = MaterialButtonToggleGroup.f5309q;
        if (view instanceof MaterialButton) {
            int i9 = 0;
            int i10 = 0;
            while (true) {
                MaterialButtonToggleGroup materialButtonToggleGroup = this.f11681a;
                if (i9 >= materialButtonToggleGroup.getChildCount()) {
                    break;
                }
                if (materialButtonToggleGroup.getChildAt(i9) == view) {
                    i2 = i10;
                    break;
                }
                if ((materialButtonToggleGroup.getChildAt(i9) instanceof MaterialButton) && materialButtonToggleGroup.getChildAt(i9).getVisibility() != 8) {
                    i10++;
                }
                i9++;
            }
        } else {
            i2 = -1;
        }
        accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, i2, 1, false, ((MaterialButton) view).l));
    }
}
