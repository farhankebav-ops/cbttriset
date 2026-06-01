package com.bytedance.sdk.component.adexpress.vCE;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE extends vAh {
    private AXM IlO;

    public vCE(Context context, int i2, int i8, int i9, JSONObject jSONObject) {
        super(context);
        IlO(context, i2, i8, i9, jSONObject);
    }

    private void IlO(Context context, int i2, int i8, int i9, JSONObject jSONObject) {
        AXM axm = new AXM(context, com.bytedance.sdk.component.adexpress.EO.IlO.EO(context), i2, i8, i9, jSONObject);
        this.IlO = axm;
        addView(axm);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.IlO.setLayoutParams(layoutParams);
    }

    public AXM getShakeView() {
        return this.IlO;
    }

    public void setShakeText(String str) {
        if (this.IlO == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.IlO.setShakeText("");
        } else {
            this.IlO.setShakeText(str);
        }
    }
}
