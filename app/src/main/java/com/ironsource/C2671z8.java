package com.ironsource;

import android.util.Base64;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.z8, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2671z8 implements J7 {
    @Override // com.ironsource.J7
    public String a(Map<String, Object> map) {
        try {
            return "data=" + Base64.encodeToString(new JSONObject().put(G5.Q, G5.R).put("data", new JSONObject(map)).toString().getBytes(), 2);
        } catch (JSONException e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return "";
        }
    }
}
