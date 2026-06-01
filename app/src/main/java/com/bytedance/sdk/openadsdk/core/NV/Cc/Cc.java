package com.bytedance.sdk.openadsdk.core.NV.Cc;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.es;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.zLG;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc {
    private final String IlO = "UGenV3OpenLinks";
    private final String MY = "landingStyle";
    private final String EO = "url";
    private final String tV = "fallbackUrl";

    public void IlO(Context context, boolean z2, oeT oet, String str, Map<String, String> map, com.bytedance.sdk.openadsdk.core.widget.Cc cc) {
        if (map == null || map.isEmpty()) {
            return;
        }
        try {
            if (IlO(Integer.parseInt(map.get("landingStyle")), map.get("url"), map.get("fallbackUrl"))) {
                es.IlO(context, z2, IlO(map), oet, str, zLG.IlO(str), null, cc);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("UGenV3OpenLinks", th.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean IlO(int r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            r0 = 0
            r1 = 1
            if (r4 == r1) goto L1f
            r2 = 2
            if (r4 == r2) goto Lb
            r6 = 3
            if (r4 == r6) goto L1f
            goto L26
        Lb:
            boolean r4 = android.text.TextUtils.isEmpty(r5)
            if (r4 == 0) goto L18
            boolean r4 = android.text.TextUtils.isEmpty(r6)
            if (r4 == 0) goto L18
            return r0
        L18:
            boolean r4 = com.bytedance.sdk.component.utils.xF.IlO(r6)
            if (r4 != 0) goto L26
            return r0
        L1f:
            boolean r4 = com.bytedance.sdk.component.utils.xF.IlO(r5)
            if (r4 != 0) goto L26
            return r0
        L26:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.NV.Cc.Cc.IlO(int, java.lang.String, java.lang.String):boolean");
    }

    private JSONObject IlO(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }
}
