package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE extends com.bytedance.sdk.openadsdk.core.Cc.tV {
    private float IlO;
    private int MY;

    public vCE(Context context) {
        super(context);
        this.IlO = 2.25f;
        this.MY = 12;
        IlO();
    }

    private void IlO() {
        setBackground(tV.IlO());
        setImageResource(pP.tV(getContext(), "tt_close_btn"));
        int iMY = BS.MY(getContext(), this.IlO);
        setPadding(iMY, iMY, iMY, iMY);
        setScaleType(ImageView.ScaleType.FIT_XY);
    }

    public static com.bytedance.sdk.openadsdk.core.Cc.tV MY(Context context) {
        return new vCE(context, 28, 5.0f);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Cc.tV, android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams != null) {
            int iMY = BS.MY(getContext(), this.MY);
            layoutParams.width = iMY;
            layoutParams.height = iMY;
        }
        super.setLayoutParams(layoutParams);
    }

    public vCE(Context context, int i2, float f4) {
        super(context);
        this.IlO = f4;
        this.MY = i2;
        IlO();
    }

    public static com.bytedance.sdk.openadsdk.core.Cc.tV IlO(Context context) {
        return new vCE(context);
    }
}
