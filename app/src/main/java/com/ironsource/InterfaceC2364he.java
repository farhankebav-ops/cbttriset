package com.ironsource;

import android.app.Activity;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.he, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface InterfaceC2364he {
    void a(Activity activity);

    void a(String str, String str2, int i2);

    void a(String str, String str2, String str3, Map<String, String> map, Lc lc);

    void a(String str, String str2, String str3, Map<String, String> map, Qc qc);

    void a(JSONObject jSONObject);

    boolean a(String str);

    void b(JSONObject jSONObject);

    void c(JSONObject jSONObject);

    void onPause(Activity activity);

    void onResume(Activity activity);
}
