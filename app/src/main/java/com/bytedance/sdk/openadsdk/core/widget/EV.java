package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EV extends com.bytedance.sdk.openadsdk.core.Cc.EO {
    public float IlO;

    public EV(Context context) {
        this(context, null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Cc.EO, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i8) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i8);
        int size2 = View.MeasureSpec.getSize(i8);
        int i9 = getLayoutParams().width;
        int i10 = getLayoutParams().height;
        float f4 = this.IlO;
        if (f4 > 0.0f) {
            if (i9 == -2) {
                size = (int) (size2 * f4);
                mode = 1073741824;
            } else if (i10 == -2) {
                size2 = (int) (size / f4);
                mode2 = 1073741824;
            }
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, mode), View.MeasureSpec.makeMeasureSpec(size2, mode2));
    }

    public void setRatio(float f4) {
        this.IlO = f4;
    }

    public EV(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EV(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.IlO = 0.0f;
    }
}
