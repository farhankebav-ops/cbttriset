package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.core.widget.PopupWindowCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class AppCompatPopupWindow extends PopupWindow {
    private static final boolean COMPAT_OVERLAP_ANCHOR = false;
    private boolean mOverlapAnchor;

    public AppCompatPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2);
        init(context, attributeSet, i2, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i2, int i8) {
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.PopupWindow, i2, i8);
        if (tintTypedArrayObtainStyledAttributes.hasValue(R.styleable.PopupWindow_overlapAnchor)) {
            setSupportOverlapAnchor(tintTypedArrayObtainStyledAttributes.getBoolean(R.styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(tintTypedArrayObtainStyledAttributes.getDrawable(R.styleable.PopupWindow_android_popupBackground));
        tintTypedArrayObtainStyledAttributes.recycle();
    }

    private void setSupportOverlapAnchor(boolean z2) {
        if (COMPAT_OVERLAP_ANCHOR) {
            this.mOverlapAnchor = z2;
        } else {
            PopupWindowCompat.setOverlapAnchor(this, z2);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i8) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i8 -= view.getHeight();
        }
        super.showAsDropDown(view, i2, i8);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i2, int i8, int i9, int i10) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i8 -= view.getHeight();
        }
        super.update(view, i2, i8, i9, i10);
    }

    public AppCompatPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i8) {
        super(context, attributeSet, i2, i8);
        init(context, attributeSet, i2, i8);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i8, int i9) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i8 -= view.getHeight();
        }
        super.showAsDropDown(view, i2, i8, i9);
    }
}
