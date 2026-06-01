package com.bytedance.sdk.openadsdk.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class TTFullScreenExpressVideoActivity extends TTFullScreenVideoActivity {
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public boolean AXM() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    @Override // com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.core.rp.tV.MY
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean IlO(long r10, boolean r12) {
        /*
            r9 = this;
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r0 = r9.MY
            com.bytedance.sdk.openadsdk.component.reward.view.lEW r0 = r0.tl
            if (r0 == 0) goto L19
            com.bytedance.sdk.openadsdk.component.reward.view.MY r0 = r0.IlO()
            if (r0 == 0) goto L19
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r0 = r9.MY
            com.bytedance.sdk.openadsdk.component.reward.view.lEW r0 = r0.tl
            com.bytedance.sdk.openadsdk.component.reward.view.MY r0 = r0.IlO()
            com.bytedance.sdk.openadsdk.tV.Bc r0 = r0.getAdShowTime()
            goto L1e
        L19:
            com.bytedance.sdk.openadsdk.tV.Bc r0 = new com.bytedance.sdk.openadsdk.tV.Bc
            r0.<init>()
        L1e:
            com.bytedance.sdk.openadsdk.component.reward.MY.MY r1 = r9.EO
            if (r1 == 0) goto L38
            boolean r2 = r1 instanceof com.bytedance.sdk.openadsdk.component.reward.MY.DmF
            if (r2 == 0) goto L38
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r2 = r9.MY
            boolean r3 = r2.Dxv
            if (r3 != 0) goto L38
            com.bytedance.sdk.openadsdk.component.reward.IlO.cl r2 = r2.vAh
            com.bytedance.sdk.openadsdk.component.reward.MY.DmF r1 = (com.bytedance.sdk.openadsdk.component.reward.MY.DmF) r1
            android.widget.FrameLayout r1 = r1.oc()
            r2.IlO(r1, r0)
            goto L45
        L38:
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r1 = r9.MY
            com.bytedance.sdk.openadsdk.component.reward.IlO.cl r2 = r1.vAh
            com.bytedance.sdk.openadsdk.component.reward.view.lEW r1 = r1.tl
            android.widget.FrameLayout r1 = r1.MY()
            r2.IlO(r1, r0)
        L45:
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r0 = r9.MY
            com.bytedance.sdk.openadsdk.component.reward.view.lEW r0 = r0.tl
            if (r0 == 0) goto L80
            int r0 = r0.DmF()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r1 = "dynamic_show_type"
            r7.put(r1, r0)
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r0 = r9.MY
            com.bytedance.sdk.openadsdk.component.reward.view.lEW r0 = r0.tl
            r1 = 0
            org.json.JSONObject r0 = r0.IlO(r1)
            if (r0 == 0) goto L80
            java.util.Iterator r1 = r0.keys()
        L6c:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L80
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r0.get(r2)     // Catch: org.json.JSONException -> L6c
            r7.put(r2, r3)     // Catch: org.json.JSONException -> L6c
            goto L6c
        L80:
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r0 = r9.MY
            com.bytedance.sdk.openadsdk.component.reward.IlO.cl r0 = r0.vAh
            com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity$1 r1 = new com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity$1
            r1.<init>()
            r0.IlO(r1)
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r0 = r9.MY
            com.bytedance.sdk.openadsdk.component.reward.IlO.cl r3 = r0.vAh
            com.bytedance.sdk.openadsdk.component.reward.MY.MY r8 = r9.EO
            r4 = r10
            r6 = r12
            boolean r10 = r3.IlO(r4, r6, r7, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity.IlO(long, boolean):boolean");
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        oeT();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void Bc() {
    }
}
