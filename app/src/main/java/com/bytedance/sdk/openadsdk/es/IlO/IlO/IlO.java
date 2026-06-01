package com.bytedance.sdk.openadsdk.es.IlO.IlO;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.tV.rp;
import com.bytedance.sdk.openadsdk.utils.zLG;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends tV {
    public IlO(Context context, oeT oet, String str) {
        super(context, oet, str);
    }

    @Override // com.bytedance.sdk.openadsdk.es.IlO.IlO.tV, com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE
    public boolean IlO() {
        HashMap map;
        if (this.IlO == null) {
            return false;
        }
        oeT oet = this.MY;
        if (oet == null || oet.lQ() != 0) {
            map = null;
        } else {
            map = new HashMap();
            map.put("dpl_probability_jump", Boolean.valueOf(this.vCE >= 11));
        }
        return IlO(this.MY, this.IlO.EO(), EO(), this.EO, map);
    }

    @Override // com.bytedance.sdk.openadsdk.es.IlO.IlO.tV
    public boolean MY() {
        com.bytedance.sdk.openadsdk.core.tV.IlO(this.MY, this.EO, 1, null);
        if (this.MY.zTS() != null) {
            HashMap map = new HashMap();
            oeT oet = this.MY;
            if (oet != null && oet.lQ() == 0) {
                map.put("dpl_probability_jump", Boolean.valueOf(this.vCE >= 11));
            }
            if (IlO(this.MY.zTS().IlO(), EO(), this.EO, this.MY, map)) {
                return true;
            }
            if (!this.tV || this.Cc.get()) {
                this.tV = true;
                IlO(this.MY, map);
                com.bytedance.sdk.openadsdk.tV.EO.IlO(this.MY, this.EO, "open_fallback_url", map);
            }
        } else {
            com.bytedance.sdk.openadsdk.core.tV.IlO(this.MY, this.EO, -1, null);
        }
        return false;
    }

    public static boolean IlO(oeT oet, String str, Context context, String str2, Map<String, Object> map) {
        Intent intentIlO;
        if (oet != null && oet.aP() == 0) {
            return false;
        }
        try {
            if (TextUtils.isEmpty(str) || (intentIlO = zLG.IlO(context, str)) == null) {
                return false;
            }
            intentIlO.putExtra("START_ONLY_FOR_ANDROID", true);
            if (!(context instanceof Activity)) {
                intentIlO.addFlags(268435456);
            }
            context.startActivity(intentIlO);
            if (map == null) {
                map = new HashMap<>();
            }
            IlO(oet, map);
            com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, str2, "click_open", map);
            return true;
        } catch (Throwable unused) {
        }
        return false;
    }

    private static void IlO(oeT oet, Map<String, Object> map) {
        if (map == null) {
            return;
        }
        if (oet != null && oet.lQ() == 0) {
            map.put("auto_click", Boolean.valueOf(!oet.NV()));
        }
        map.put("can_query_install", 0);
    }

    public static boolean IlO(String str, Context context, String str2, oeT oet, Map<String, Object> map) {
        Intent intent = null;
        try {
        } catch (Throwable th) {
            th = th;
        }
        if (!TextUtils.isEmpty(str)) {
            Uri uri = Uri.parse(str);
            Intent intent2 = new Intent("android.intent.action.VIEW");
            try {
                intent2.setData(uri);
                if (!(context instanceof Activity)) {
                    intent2.addFlags(268435456);
                }
                if (map == null) {
                    map = new HashMap<>();
                }
                IlO(oet, map);
                map.put("url", str);
                com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, str2, "open_url_app", map);
                context.startActivity(intent2);
                rp.IlO().IlO(map).IlO(oet, str2);
                com.bytedance.sdk.openadsdk.tV.EO.IlO("dp_start_act_success", oet, str2, map);
                return true;
            } catch (Throwable th2) {
                th = th2;
                intent = intent2;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("exception", th.getMessage());
                    if (intent != null) {
                        jSONObject.put("intent", intent.toString());
                    }
                    jSONObject.put("can_query_install", 0);
                } catch (Exception unused) {
                }
                com.bytedance.sdk.openadsdk.core.tV.IlO(oet, str2, -4, jSONObject);
                return false;
            }
        }
        com.bytedance.sdk.openadsdk.core.tV.IlO(oet, str2, -2, null);
        return false;
    }
}
