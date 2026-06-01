package com.bytedance.sdk.component.adexpress.vCE;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class AXM extends xF {
    private TextView IlO;

    public AXM(@NonNull Context context, View view, int i2, int i8, int i9, JSONObject jSONObject) {
        super(context, view, i2, i8, i9, jSONObject);
    }

    @Override // com.bytedance.sdk.component.adexpress.vCE.xF
    public void IlO(Context context, View view) {
        addView(view);
        this.IlO = (TextView) findViewById(2097610747);
    }

    @Override // com.bytedance.sdk.component.adexpress.vCE.xF
    public void setShakeText(String str) {
        if (this.IlO == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.IlO.setText(str);
            return;
        }
        try {
            this.IlO.setText(com.bytedance.sdk.component.utils.pP.MY(this.IlO.getContext(), "tt_splash_default_click_shake"));
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
