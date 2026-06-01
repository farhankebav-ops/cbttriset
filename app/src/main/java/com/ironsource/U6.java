package com.ironsource;

import android.content.Context;
import com.ironsource.Q6;
import com.ironsource.environment.ContextProvider;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class U6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7673a = "adunit_data";

    public void a(String str, Object obj) {
        R6.b().b(str, obj);
    }

    public void a(Map<String, Object> map) {
        R6.b().a(map);
    }

    public void a(String str, JSONArray jSONArray) {
        R6.b().a(str, jSONArray);
    }

    public void a(String str, JSONObject jSONObject) {
        R6.b().a(str, jSONObject);
    }

    public void a(Context context) {
        R6.b().c(context);
    }

    public void a(String str, Object obj, Q6.a aVar) {
        try {
            String strName = aVar.name();
            R6 r6B = R6.b();
            JSONObject jSONObjectOptJSONObject = r6B.b(ContextProvider.getInstance().getApplicationContext()).optJSONObject(f7673a);
            if (jSONObjectOptJSONObject == null) {
                r6B.b(f7673a, new JSONObject().put(strName, new JSONObject().put(str, obj)));
                return;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(strName);
            if (jSONObjectOptJSONObject2 == null) {
                r6B.b(f7673a, jSONObjectOptJSONObject.put(strName, new JSONObject().put(str, obj)));
            } else {
                r6B.b(f7673a, jSONObjectOptJSONObject.put(strName, jSONObjectOptJSONObject2.put(str, obj)));
            }
        } catch (JSONException e) {
            C2531r4.d().a(e);
        }
    }

    public void a(String str, Q6.a aVar) {
        JSONObject jSONObjectOptJSONObject;
        try {
            String strName = aVar.name();
            R6 r6B = R6.b();
            JSONObject jSONObjectOptJSONObject2 = r6B.b(ContextProvider.getInstance().getApplicationContext()).optJSONObject(f7673a);
            if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject(strName)) == null || jSONObjectOptJSONObject.remove(str) == null) {
                return;
            }
            r6B.b(f7673a, jSONObjectOptJSONObject2.put(strName, jSONObjectOptJSONObject));
        } catch (JSONException e) {
            C2531r4.d().a(e);
        }
    }
}
