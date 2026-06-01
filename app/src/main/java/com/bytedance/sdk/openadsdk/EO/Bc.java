package com.bytedance.sdk.openadsdk.EO;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc extends LinearLayout {
    private final NV EO;
    private final FilterWord IlO;
    private lEW MY;

    public Bc(Context context, FilterWord filterWord, NV nv) {
        super(context);
        setOrientation(1);
        this.IlO = filterWord;
        this.EO = nv;
        IlO();
    }

    private void EO() {
        String name = this.IlO.getName();
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = BS.MY(getContext(), 12.0f);
        layoutParams.gravity = 17;
        lew.setGravity(17);
        lew.setText(name);
        lew.setTextColor(Color.argb(85, 22, 24, 35));
        lew.setTextSize(this.EO.DmF() ? 14 : 10);
        addView(lew, layoutParams);
    }

    private void IlO() {
        EO();
        MY();
    }

    private void MY() {
        this.MY = new lEW(getContext(), this.EO);
        new LinearLayout.LayoutParams(-1, -2);
        this.MY.IlO(this.IlO.getOptions());
        addView(this.MY);
    }
}
