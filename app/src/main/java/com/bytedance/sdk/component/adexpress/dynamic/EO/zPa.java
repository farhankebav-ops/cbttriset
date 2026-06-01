package com.bytedance.sdk.component.adexpress.dynamic.EO;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.vCE.oeT;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class zPa implements Bc {
    private com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc EO;
    private oeT IlO;
    private Context MY;
    private com.bytedance.sdk.component.adexpress.dynamic.tV.Bc tV;

    public zPa(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc cc, com.bytedance.sdk.component.adexpress.dynamic.tV.Bc bc) {
        this.MY = context;
        this.EO = cc;
        this.tV = bc;
        tV();
    }

    private void tV() {
        this.IlO = new oeT(this.MY);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.MY, 120.0f));
        layoutParams.gravity = 17;
        this.IlO.setLayoutParams(layoutParams);
        this.IlO.setClipChildren(false);
        this.IlO.setGuideText(this.tV.fdM());
        com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc cc = this.EO;
        if (cc != null) {
            this.IlO.setOnClickListener((View.OnClickListener) cc.getDynamicClickListener());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO.Bc
    public ViewGroup EO() {
        return this.IlO;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO.Bc
    public void IlO() {
        oeT oet = this.IlO;
        if (oet != null) {
            oet.IlO();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO.Bc
    public void MY() {
        oeT oet = this.IlO;
        if (oet != null) {
            oet.MY();
        }
    }
}
