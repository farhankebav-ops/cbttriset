package com.bytedance.sdk.openadsdk.core.NV.MY;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pP;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends com.bytedance.adsdk.ugeno.DmF.vCE.MY {
    public IlO(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.DmF.vCE.MY
    public void Bc(String str) {
        super.Bc(str);
        if (TextUtils.isEmpty(str) || TextUtils.equals("null", str)) {
            return;
        }
        try {
            String str2 = String.format(pP.IlO(this.MY, "tt_comment_num"), Integer.valueOf(Integer.parseInt(str)));
            ((com.bytedance.adsdk.ugeno.DmF.vCE.IlO) this.Cc).setText("(" + str2 + ")");
        } catch (Exception unused) {
        }
    }
}
