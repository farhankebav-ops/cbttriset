package com.ironsource;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface V {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements V {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final JSONObject f7702a;

        public a(JSONObject applicationConfig) {
            kotlin.jvm.internal.k.e(applicationConfig, "applicationConfig");
            this.f7702a = applicationConfig;
        }

        @Override // com.ironsource.V
        public JSONObject a() {
            JSONObject jSONObjectOptJSONObject = this.f7702a.optJSONObject("controllerConfig");
            return jSONObjectOptJSONObject == null ? new JSONObject() : jSONObjectOptJSONObject;
        }

        @Override // com.ironsource.V
        public int b() {
            int iOptInt = this.f7702a.optInt("debugMode", 0);
            if (this.f7702a.optBoolean(b.e, false)) {
                return 3;
            }
            return iOptInt;
        }

        @Override // com.ironsource.V
        public String c() {
            String strOptString = this.f7702a.optString("controllerUrl");
            return strOptString == null ? "" : strOptString;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f7703a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f7704b = "controllerUrl";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f7705c = "controllerConfig";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f7706d = "debugMode";
        public static final String e = "adptDebugMode";

        private b() {
        }
    }

    JSONObject a();

    int b();

    String c();
}
