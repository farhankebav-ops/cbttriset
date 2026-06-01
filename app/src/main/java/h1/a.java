package h1;

import androidx.dynamicanimation.animation.FloatPropertyCompat;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends FloatPropertyCompat {
    @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
    public final float getValue(Object obj) {
        return ((MaterialButton) obj).getDisplayedWidthIncrease();
    }

    @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
    public final void setValue(Object obj, float f4) {
        ((MaterialButton) obj).setDisplayedWidthIncrease(f4);
    }
}
