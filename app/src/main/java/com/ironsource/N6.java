package com.ironsource;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class N6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7273b = "userId";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7274c = "appKey";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static N6 f7275d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f7276a = new JSONObject();

    private N6() {
    }

    public static synchronized N6 a() {
        try {
            if (f7275d == null) {
                f7275d = new N6();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7275d;
    }

    public synchronized JSONObject b() throws JSONException {
        if (Mb.U().g().f()) {
            return new JSONObject(this.f7276a.toString());
        }
        return this.f7276a;
    }

    public synchronized void a(Map<String, Object> map) {
        if (map != null) {
            for (String str : map.keySet()) {
                a(str, map.get(str));
            }
        }
    }

    public synchronized void a(String str, Object obj) {
        try {
            this.f7276a.put(str, obj);
        } catch (Exception e) {
            C2531r4.d().a(e);
        }
    }

    public synchronized String a(String str) {
        return this.f7276a.optString(str);
    }
}
