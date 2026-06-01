package com.bytedance.sdk.component.adexpress.dynamic.EO;

import android.content.Context;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class es implements Bc<com.bytedance.sdk.component.adexpress.vCE.EV> {
    private final com.bytedance.sdk.component.adexpress.vCE.EV IlO;

    public es(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc cc, com.bytedance.sdk.component.adexpress.dynamic.tV.Bc bc) {
        com.bytedance.sdk.component.adexpress.vCE.EV ev = new com.bytedance.sdk.component.adexpress.vCE.EV(context);
        this.IlO = ev;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(context, bc.uvo() > 0 ? bc.uvo() : com.bytedance.sdk.component.adexpress.tV.MY() ? 0 : 120);
        ev.setLayoutParams(layoutParams);
        ev.setClipChildren(false);
        ev.setText(bc.fdM());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO.Bc
    public void IlO() {
        com.bytedance.sdk.component.adexpress.vCE.EV ev = this.IlO;
        if (ev != null) {
            ev.IlO();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO.Bc
    public void MY() {
        com.bytedance.sdk.component.adexpress.vCE.EV ev = this.IlO;
        if (ev != null) {
            ev.MY();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO.Bc
    /* JADX INFO: renamed from: tV, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.adexpress.vCE.EV EO() {
        return this.IlO;
    }
}
