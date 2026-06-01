package com.bytedance.sdk.component.IlO;

import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class lEW {
    private rp IlO;

    private lEW(rp rpVar) {
        this.IlO = rpVar;
    }

    public static lEW IlO(rp rpVar) {
        return new lEW(rpVar);
    }

    public <T> T IlO(String str, Type type) throws JSONException {
        IlO(str);
        return (type.equals(JSONObject.class) || ((type instanceof Class) && JSONObject.class.isAssignableFrom((Class) type))) ? (T) new JSONObject(str) : (T) this.IlO.IlO(str, type);
    }

    public <T> String IlO(T t3) {
        String string;
        if (t3 == null) {
            return "{}";
        }
        if (!(t3 instanceof JSONObject) && !(t3 instanceof JSONArray)) {
            string = this.IlO.IlO(t3);
        } else {
            string = t3.toString();
        }
        IlO(string);
        return string;
    }

    private static void IlO(String str) {
        if (str.startsWith("{") && str.endsWith("}")) {
            return;
        }
        DmF.IlO(new IllegalArgumentException("Param is not allowed to be List or JSONArray, rawString:\n ".concat(str)));
    }
}
