package com.bytedance.sdk.component.adexpress.dynamic.EO;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.dY;
import com.bytedance.sdk.component.utils.pP;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EV implements Bc<ViewGroup> {
    private final com.bytedance.sdk.component.adexpress.vCE.NV IlO;
    private final FrameLayout MY;

    public EV(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc cc, com.bytedance.sdk.component.adexpress.dynamic.tV.Bc bc, String str, String str2) {
        com.bytedance.sdk.component.adexpress.vCE.NV nv = new com.bytedance.sdk.component.adexpress.vCE.NV(context);
        this.IlO = nv;
        nv.setImageLottieTosPath(str);
        FrameLayout frameLayout = new FrameLayout(context);
        this.MY = frameLayout;
        frameLayout.addView(nv, new FrameLayout.LayoutParams(-2, -2));
        double dPFe = bc.pFe();
        dPFe = dPFe == 0.0d ? 1.0d : dPFe;
        double dHg = bc.Hg();
        double d8 = dHg != 0.0d ? dHg : 1.0d;
        if ("22".equals(str2)) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(context, 250.0f));
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(context, 120.0f);
            frameLayout.setLayoutParams(layoutParams);
            return;
        }
        if (!"20".equals(str2)) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) (((double) cc.getDynamicWidth()) * 0.32d * dPFe), (int) (((double) cc.getDynamicWidth()) * 0.32d * d8));
            layoutParams2.gravity = 17;
            frameLayout.setLayoutParams(layoutParams2);
        } else {
            IlO(context, frameLayout, bc);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 81;
            layoutParams3.bottomMargin = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(context, bc.uvo() > 0 ? bc.uvo() : com.bytedance.sdk.component.adexpress.tV.MY() ? 0 : 120);
            frameLayout.setLayoutParams(layoutParams3);
            frameLayout.setClipChildren(false);
        }
    }

    private void IlO(Context context, FrameLayout frameLayout, com.bytedance.sdk.component.adexpress.dynamic.tV.Bc bc) {
        LinearLayout linearLayout = new LinearLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(0, -dY.IlO(context, 5.0f), 0, 0);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText(context.getString(pP.MY(context, "tt_splash_brush_mask_title")));
        textView.setTextColor(-1);
        textView.setTextSize(2, 20.0f);
        TextView textView2 = new TextView(context);
        textView2.setId(2097610738);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, dY.IlO(context, 5.0f), 0, 0);
        textView2.setLayoutParams(layoutParams2);
        textView2.setText(context.getString(pP.MY(context, "tt_splash_brush_mask_hint")));
        if (bc != null && !TextUtils.isEmpty(bc.fdM())) {
            textView2.setText(bc.fdM());
        }
        textView2.setTextColor(-1);
        textView2.setTextSize(2, 14.0f);
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        frameLayout.addView(linearLayout);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO.Bc
    public ViewGroup EO() {
        return this.MY;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO.Bc
    public void MY() {
        this.IlO.vCE();
        ViewParent parent = this.MY.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.MY);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO.Bc
    public void IlO() {
        this.IlO.lEW();
    }
}
