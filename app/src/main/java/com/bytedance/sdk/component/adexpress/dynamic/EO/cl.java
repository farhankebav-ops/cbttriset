package com.bytedance.sdk.component.adexpress.dynamic.EO;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.vCE.vAh;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class cl<E extends vAh> implements Bc<E> {
    protected int Cc;
    protected com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc EO;
    protected vAh IlO;
    protected Context MY;
    protected com.bytedance.sdk.component.adexpress.dynamic.tV.Bc tV;

    public cl(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc cc, com.bytedance.sdk.component.adexpress.dynamic.tV.Bc bc, int i2) {
        this.Cc = i2;
        this.MY = context;
        this.EO = cc;
        this.tV = bc;
        tV();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO.Bc
    /* JADX INFO: renamed from: Cc, reason: merged with bridge method [inline-methods] */
    public E EO() {
        return (E) this.IlO;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO.Bc
    public void IlO() {
        this.IlO.IlO();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO.Bc
    public void MY() {
        this.IlO.MY();
    }

    public void tV() {
        this.IlO = new vAh(this.MY, this.tV.gQ());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.MY, 200.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.MY, 100 - this.Cc);
        this.IlO.setLayoutParams(layoutParams);
        try {
            this.IlO.setGuideText(this.tV.fdM());
        } catch (Throwable unused) {
        }
    }

    public cl(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc cc, com.bytedance.sdk.component.adexpress.dynamic.tV.Bc bc) {
        this(context, cc, bc, 0);
    }
}
