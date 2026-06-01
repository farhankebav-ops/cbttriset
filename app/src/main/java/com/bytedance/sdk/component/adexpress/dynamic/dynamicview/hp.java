package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class hp extends vCE {
    public hp(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        super(context, dynamicRootView, lew);
        TextView textView = new TextView(context);
        this.ea = textView;
        textView.setTag(Integer.valueOf(getClickArea()));
        addView(this.ea, getWidgetLayoutParams());
    }

    private boolean IlO() {
        if (com.bytedance.sdk.component.adexpress.tV.MY()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.rp.MY) && this.rp.MY.contains("adx:")) || com.bytedance.sdk.component.adexpress.dynamic.Cc.EV.MY();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0080  */
    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.YA
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean DmF() {
        /*
            r4 = this;
            super.DmF()
            android.view.View r0 = r4.ea
            com.bytedance.sdk.component.adexpress.dynamic.tV.Bc r1 = r4.rp
            int r1 = r1.lEW()
            r0.setTextAlignment(r1)
            android.view.View r0 = r4.ea
            android.widget.TextView r0 = (android.widget.TextView) r0
            com.bytedance.sdk.component.adexpress.dynamic.tV.Bc r1 = r4.rp
            int r1 = r1.Bc()
            r0.setTextColor(r1)
            android.view.View r0 = r4.ea
            android.widget.TextView r0 = (android.widget.TextView) r0
            com.bytedance.sdk.component.adexpress.dynamic.tV.Bc r1 = r4.rp
            float r1 = r1.Cc()
            r0.setTextSize(r1)
            boolean r0 = com.bytedance.sdk.component.adexpress.tV.MY()
            if (r0 == 0) goto L8a
            android.view.View r0 = r4.ea
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            r0.setIncludeFontPadding(r1)
            android.view.View r0 = r4.ea
            android.widget.TextView r0 = (android.widget.TextView) r0
            android.content.Context r2 = com.bytedance.sdk.component.adexpress.tV.IlO()
            int r3 = r4.lEW
            float r3 = (float) r3
            int r2 = com.bytedance.sdk.component.adexpress.tV.Bc.MY(r2, r3)
            com.bytedance.sdk.component.adexpress.dynamic.tV.Bc r3 = r4.rp
            int r3 = r3.MY()
            int r2 = r2 - r3
            com.bytedance.sdk.component.adexpress.dynamic.tV.Bc r3 = r4.rp
            int r3 = r3.IlO()
            int r2 = r2 - r3
            float r2 = (float) r2
            r3 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 - r3
            com.bytedance.sdk.component.adexpress.dynamic.tV.Bc r3 = r4.rp
            float r3 = r3.Cc()
            float r2 = java.lang.Math.min(r2, r3)
            r0.setTextSize(r2)
            com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRootView r0 = r4.bWL
            if (r0 == 0) goto L80
            com.bytedance.sdk.component.adexpress.MY.hp r0 = r0.getRenderRequest()
            if (r0 == 0) goto L80
            java.lang.String r0 = r0.OOq()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L80
            android.view.View r2 = r4.ea
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setText(r0)
            goto L82
        L80:
            r1 = 8
        L82:
            android.view.View r0 = r4.ea
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setVisibility(r1)
            goto Lc3
        L8a:
            boolean r0 = r4.IlO()
            if (r0 == 0) goto Lb2
            boolean r0 = com.bytedance.sdk.component.adexpress.dynamic.Cc.EV.MY()
            if (r0 == 0) goto La2
            android.view.View r0 = r4.ea
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = com.bytedance.sdk.component.adexpress.dynamic.Cc.EV.IlO()
            r0.setText(r1)
            goto Lc3
        La2:
            android.view.View r0 = r4.ea
            android.widget.TextView r0 = (android.widget.TextView) r0
            com.bytedance.sdk.component.adexpress.dynamic.tV.Bc r1 = r4.rp
            java.lang.String r1 = r1.MY
            java.lang.String r1 = com.bytedance.sdk.component.adexpress.dynamic.Cc.EV.IlO(r1)
            r0.setText(r1)
            goto Lc3
        Lb2:
            android.view.View r0 = r4.ea
            android.widget.TextView r0 = (android.widget.TextView) r0
            android.content.Context r1 = r4.getContext()
            java.lang.String r2 = "tt_logo_cn"
            int r1 = com.bytedance.sdk.component.utils.pP.MY(r1, r2)
            r0.setText(r1)
        Lc3:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.hp.DmF():boolean");
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc
    public void vCE() {
        com.bytedance.sdk.component.adexpress.MY.hp renderRequest = this.bWL.getRenderRequest();
        if (renderRequest == null || !TextUtils.isEmpty(renderRequest.tl())) {
            super.vCE();
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.Bc, this.lEW);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
    }
}
