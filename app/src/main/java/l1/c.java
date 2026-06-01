package l1;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.cbt.exam.browser.R;
import com.google.android.material.chip.Chip;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends ExploreByTouchHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Chip f12743a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Chip chip, Chip chip2) {
        super(chip2);
        this.f12743a = chip;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final int getVirtualViewAt(float f4, float f8) {
        Rect rect = Chip.f5320s;
        Chip chip = this.f12743a;
        return (chip.d() && chip.getCloseIconTouchBounds().contains(f4, f8)) ? 1 : 0;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final void getVisibleVirtualViews(List list) {
        e eVar;
        list.add(0);
        Rect rect = Chip.f5320s;
        Chip chip = this.f12743a;
        if (!chip.d() || (eVar = chip.f5323a) == null || !eVar.U || chip.f5326d == null) {
            return;
        }
        list.add(1);
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final boolean onPerformActionForVirtualView(int i2, int i8, Bundle bundle) {
        boolean z2 = false;
        if (i8 == 16) {
            Chip chip = this.f12743a;
            if (i2 == 0) {
                return chip.performClick();
            }
            if (i2 == 1) {
                chip.playSoundEffect(0);
                View.OnClickListener onClickListener = chip.f5326d;
                if (onClickListener != null) {
                    onClickListener.onClick(chip);
                    z2 = true;
                }
                if (chip.f5330o) {
                    chip.f5329n.sendEventForVirtualView(1, 1);
                }
            }
        }
        return z2;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final void onPopulateNodeForHost(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Chip chip = this.f12743a;
        e eVar = chip.f5323a;
        accessibilityNodeInfoCompat.setCheckable(eVar != null && eVar.f12744a0);
        accessibilityNodeInfoCompat.setClickable(chip.isClickable());
        accessibilityNodeInfoCompat.setClassName(chip.getAccessibilityClassName());
        accessibilityNodeInfoCompat.setText(chip.getText());
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final void onPopulateNodeForVirtualView(int i2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (i2 != 1) {
            accessibilityNodeInfoCompat.setContentDescription("");
            accessibilityNodeInfoCompat.setBoundsInParent(Chip.f5320s);
            return;
        }
        Chip chip = this.f12743a;
        CharSequence closeIconContentDescription = chip.getCloseIconContentDescription();
        if (closeIconContentDescription != null) {
            accessibilityNodeInfoCompat.setContentDescription(closeIconContentDescription);
        } else {
            CharSequence text = chip.getText();
            accessibilityNodeInfoCompat.setContentDescription(chip.getContext().getString(R.string.mtrl_chip_close_icon_content_description, TextUtils.isEmpty(text) ? "" : text).trim());
        }
        accessibilityNodeInfoCompat.setBoundsInParent(chip.getCloseIconTouchBoundsInt());
        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        accessibilityNodeInfoCompat.setEnabled(chip.isEnabled());
        accessibilityNodeInfoCompat.setClassName(Button.class.getName());
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final void onVirtualViewKeyboardFocusChanged(int i2, boolean z2) {
        Chip chip = this.f12743a;
        if (i2 == 1) {
            chip.f5328i = z2;
        }
        e eVar = chip.f5323a;
        boolean z7 = chip.f5328i;
        boolean zV = false;
        if (eVar.V != null) {
            zV = eVar.V(z7 ? new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled} : e.P0);
        }
        if (zV) {
            chip.refreshDrawableState();
        }
    }
}
