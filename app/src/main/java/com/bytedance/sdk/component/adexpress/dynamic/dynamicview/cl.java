package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class cl extends vCE {
    private TextView AXM;
    private TextView IlO;
    private TextView MY;
    private TextView oeT;
    private LinearLayout vAh;
    private TextView xF;

    public cl(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        super(context, dynamicRootView, lew);
        this.IlO = new TextView(this.EV);
        this.MY = new TextView(this.EV);
        this.xF = new TextView(this.EV);
        this.vAh = new LinearLayout(this.EV);
        this.AXM = new TextView(this.EV);
        this.oeT = new TextView(this.EV);
        this.IlO.setTag(9);
        this.MY.setTag(10);
        this.xF.setTag(12);
        this.vAh.addView(this.xF);
        this.vAh.addView(this.oeT);
        this.vAh.addView(this.MY);
        this.vAh.addView(this.AXM);
        this.vAh.addView(this.IlO);
        addView(this.vAh, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.YA
    public boolean DmF() {
        this.xF.setText("Function");
        this.MY.setText("Permission list");
        this.AXM.setText(" | ");
        this.oeT.setText(" | ");
        this.IlO.setText("Privacy policy");
        com.bytedance.sdk.component.adexpress.dynamic.tV.Bc bc = this.rp;
        if (bc != null) {
            this.xF.setTextColor(bc.Bc());
            this.xF.setTextSize(this.rp.Cc());
            this.MY.setTextColor(this.rp.Bc());
            this.MY.setTextSize(this.rp.Cc());
            this.AXM.setTextColor(this.rp.Bc());
            this.oeT.setTextColor(this.rp.Bc());
            this.IlO.setTextColor(this.rp.Bc());
            this.IlO.setTextSize(this.rp.Cc());
            return false;
        }
        this.xF.setTextColor(-1);
        this.xF.setTextSize(12.0f);
        this.MY.setTextColor(-1);
        this.MY.setTextSize(12.0f);
        this.AXM.setTextColor(-1);
        this.oeT.setTextColor(-1);
        this.IlO.setTextColor(-1);
        this.IlO.setTextSize(12.0f);
        return false;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.Bc, this.lEW);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc
    public boolean tV() {
        this.IlO.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.IlO.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.MY.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.MY.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.xF.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.xF.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        return true;
    }
}
