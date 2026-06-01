package com.bytedance.sdk.component.adexpress.dynamic.EO;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.vCE.OOq;
import com.bytedance.sdk.component.utils.pP;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class xF implements Bc<OOq> {
    private String Cc;
    private com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc EO;
    private OOq IlO;
    private Context MY;
    private com.bytedance.sdk.component.adexpress.dynamic.tV.Bc tV;
    private com.bytedance.sdk.component.adexpress.dynamic.tV.NV vCE;

    public xF(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc cc, com.bytedance.sdk.component.adexpress.dynamic.tV.Bc bc, String str, com.bytedance.sdk.component.adexpress.dynamic.tV.NV nv) {
        this.MY = context;
        this.EO = cc;
        this.tV = bc;
        this.Cc = str;
        this.vCE = nv;
        Cc();
    }

    private void Cc() {
        int iUvo = this.tV.uvo();
        final com.bytedance.sdk.component.adexpress.dynamic.vCE.IlO dynamicClickListener = this.EO.getDynamicClickListener();
        try {
            new JSONObject().put("convertActionType", 2);
        } catch (Throwable unused) {
        }
        if ("18".equals(this.Cc)) {
            Context context = this.MY;
            OOq oOq = new OOq(context, com.bytedance.sdk.component.adexpress.EO.IlO.DmF(context), this.vCE);
            this.IlO = oOq;
            if (oOq.getWriggleLayout() != null) {
                this.IlO.getWriggleLayout().setOnClickListener((View.OnClickListener) dynamicClickListener);
            }
            if (this.IlO.getTopTextView() != null) {
                if (TextUtils.isEmpty(this.tV.qvT())) {
                    this.IlO.getTopTextView().setText(pP.MY(this.MY, "tt_splash_wriggle_top_text_style_17"));
                } else {
                    this.IlO.getTopTextView().setText(this.tV.qvT());
                }
            }
        } else {
            Context context2 = this.MY;
            this.IlO = new OOq(context2, com.bytedance.sdk.component.adexpress.EO.IlO.DmF(context2), this.vCE);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        this.IlO.setTranslationY(-((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.MY, iUvo)));
        this.IlO.setLayoutParams(layoutParams);
        this.IlO.setShakeText(this.tV.fdM());
        this.IlO.setClipChildren(false);
        final View wriggleProgressIv = this.IlO.getWriggleProgressIv();
        this.IlO.setOnShakeViewListener(new OOq.IlO() { // from class: com.bytedance.sdk.component.adexpress.dynamic.EO.xF.1
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
    public OOq EO() {
        return this.IlO;
    }
}
