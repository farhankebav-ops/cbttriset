package com.bytedance.sdk.openadsdk.EO;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EV extends View {
    private final int IlO;

    public EV(Context context) {
        this(context, Color.parseColor("#25000000"));
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
        setMeasuredDimension(getMeasuredWidth(), this.IlO);
    }

    public EV(Context context, int i2) {
        super(context);
        setBackgroundColor(i2);
        this.IlO = BS.MY(getContext(), 0.66f);
    }
}
