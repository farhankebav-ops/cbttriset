package com.bytedance.sdk.component.adexpress.dynamic.EO;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.vCE.xF;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ea implements Bc<com.bytedance.sdk.component.adexpress.vCE.xF> {
    private int Bc;
    private String Cc;
    private JSONObject DmF;
    private com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc EO;
    private com.bytedance.sdk.component.adexpress.vCE.xF IlO;
    private Context MY;
    private int lEW;
    private com.bytedance.sdk.component.adexpress.dynamic.tV.Bc tV;
    private int vCE;

    public ea(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc cc, com.bytedance.sdk.component.adexpress.dynamic.tV.Bc bc, String str, int i2, int i8, int i9, JSONObject jSONObject) {
        this.MY = context;
        this.EO = cc;
        this.tV = bc;
        this.Cc = str;
        this.vCE = i2;
        this.Bc = i8;
        this.lEW = i9;
        this.DmF = jSONObject;
        Cc();
    }

    private void Cc() {
        final com.bytedance.sdk.component.adexpress.dynamic.vCE.IlO dynamicClickListener = this.EO.getDynamicClickListener();
        try {
            new JSONObject().put("convertActionType", 1);
        } catch (Throwable unused) {
        }
        if ("16".equals(this.Cc)) {
            Context context = this.MY;
            com.bytedance.sdk.component.adexpress.vCE.xF xFVar = new com.bytedance.sdk.component.adexpress.vCE.xF(context, com.bytedance.sdk.component.adexpress.EO.IlO.lEW(context), this.vCE, this.Bc, this.lEW, this.DmF);
            this.IlO = xFVar;
            if (xFVar.getShakeLayout() != null) {
                this.IlO.getShakeLayout().setOnClickListener((View.OnClickListener) dynamicClickListener);
            }
        } else {
            Context context2 = this.MY;
            this.IlO = new com.bytedance.sdk.component.adexpress.vCE.xF(context2, com.bytedance.sdk.component.adexpress.EO.IlO.Bc(context2), this.vCE, this.Bc, this.lEW, this.DmF);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.IlO.setGravity(17);
        layoutParams.gravity = 17;
        this.IlO.setLayoutParams(layoutParams);
        this.IlO.setTranslationY(com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.MY, this.tV.qz()));
        this.IlO.setShakeText(this.tV.fdM());
        this.IlO.setClipChildren(false);
        this.IlO.setOnShakeViewListener(new xF.IlO() { // from class: com.bytedance.sdk.component.adexpress.dynamic.EO.ea.1
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO.Bc
    public void IlO() {
        this.IlO.IlO();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO.Bc
    public void MY() {
        this.IlO.clearAnimation();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO.Bc
    /* JADX INFO: renamed from: tV, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.adexpress.vCE.xF EO() {
        return this.IlO;
    }
}
