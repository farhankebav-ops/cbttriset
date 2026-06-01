package com.bytedance.sdk.openadsdk.core.NV.MY.EO;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends com.bytedance.adsdk.ugeno.DmF.MY.IlO {
    private final com.bytedance.adsdk.ugeno.DmF.MY.IlO IlO;
    private final com.bytedance.adsdk.ugeno.DmF.MY.IlO MY;

    public IlO(Context context) {
        super(context);
        com.bytedance.adsdk.ugeno.DmF.MY.IlO ilO = new com.bytedance.adsdk.ugeno.DmF.MY.IlO(context);
        this.IlO = ilO;
        addView(ilO, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.adsdk.ugeno.DmF.MY.IlO ilO2 = new com.bytedance.adsdk.ugeno.DmF.MY.IlO(context);
        this.MY = ilO2;
        ilO2.setBackgroundColor(0);
        addView(ilO2, new FrameLayout.LayoutParams(-1, -1));
    }

    public com.bytedance.adsdk.ugeno.DmF.MY.IlO getVideoView() {
        return this.IlO;
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.MY.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.MY.setOnTouchListener(onTouchListener);
    }
}
