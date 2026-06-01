package com.bytedance.sdk.openadsdk.tV;

import java.text.SimpleDateFormat;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE extends IlO {
    public static final SimpleDateFormat EO = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    public vCE(String str, JSONObject jSONObject) {
        super(str, jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.tV.IlO
    public JSONObject EO() {
        return this.MY;
    }
}
