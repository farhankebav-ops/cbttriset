package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EV {
    private com.bytedance.sdk.openadsdk.core.Cc.lEW Cc;
    private com.bytedance.sdk.openadsdk.core.widget.lEW EO;
    protected View IlO = Cc();
    protected Context MY;
    private com.bytedance.sdk.openadsdk.core.widget.zPa tV;

    public EV(Context context) {
        this.MY = context;
    }

    private View Cc() {
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(this.MY);
        cc.setGravity(1);
        cc.setOrientation(1);
        com.bytedance.sdk.openadsdk.core.widget.zPa zpa = new com.bytedance.sdk.openadsdk.core.widget.zPa(this.MY);
        this.tV = zpa;
        zpa.setId(520093745);
        int iMY = BS.MY(this.MY, 64.0f);
        cc.addView(this.tV, new LinearLayout.LayoutParams(iMY, iMY));
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(this.MY);
        this.Cc = lew;
        lew.setId(520093746);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BS.MY(this.MY, 219.0f), -2);
        layoutParams.topMargin = BS.MY(this.MY, 16.0f);
        this.Cc.setLayoutParams(layoutParams);
        this.Cc.setEllipsize(TextUtils.TruncateAt.END);
        this.Cc.setGravity(17);
        this.Cc.setMaxWidth(BS.MY(this.MY, 150.0f));
        this.Cc.setMaxLines(2);
        this.Cc.setTextColor(-1);
        this.Cc.setTextSize(1, 16.0f);
        cc.addView(this.Cc);
        this.EO = new com.bytedance.sdk.openadsdk.core.widget.lEW(this.MY);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(BS.MY(this.MY, 219.0f), BS.MY(this.MY, 6.0f));
        layoutParams2.topMargin = BS.MY(this.MY, 32.0f);
        cc.addView(this.EO, layoutParams2);
        return cc;
    }

    public com.bytedance.sdk.openadsdk.core.Cc.lEW EO() {
        return this.Cc;
    }

    public View IlO() {
        return this.IlO;
    }

    public com.bytedance.sdk.openadsdk.core.widget.zPa MY() {
        return this.tV;
    }

    public void tV() {
        this.IlO = null;
        this.MY = null;
    }

    public void IlO(int i2) {
        this.EO.setProgress(i2);
    }
}
