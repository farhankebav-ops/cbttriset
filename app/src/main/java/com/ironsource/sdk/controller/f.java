package com.ironsource.sdk.controller;

import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface f {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final C0197a f9961c = new C0197a(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9962a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final JSONObject f9963b;

        /* JADX INFO: renamed from: com.ironsource.sdk.controller.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class C0197a {
            public /* synthetic */ C0197a(kotlin.jvm.internal.f fVar) {
                this();
            }

            public final a a(String jsonStr) throws JSONException {
                kotlin.jvm.internal.k.e(jsonStr, "jsonStr");
                JSONObject jSONObject = new JSONObject(jsonStr);
                String id = jSONObject.getString(b.f9965b);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
                kotlin.jvm.internal.k.d(id, "id");
                return new a(id, jSONObjectOptJSONObject);
            }

            private C0197a() {
            }
        }

        public a(String msgId, JSONObject jSONObject) {
            kotlin.jvm.internal.k.e(msgId, "msgId");
            this.f9962a = msgId;
            this.f9963b = jSONObject;
        }

        public final String a() {
            return this.f9962a;
        }

        public final JSONObject b() {
            return this.f9963b;
        }

        public final String c() {
            return this.f9962a;
        }

        public final JSONObject d() {
            return this.f9963b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.k.a(this.f9962a, aVar.f9962a) && kotlin.jvm.internal.k.a(this.f9963b, aVar.f9963b);
        }

        public int hashCode() {
            int iHashCode = this.f9962a.hashCode() * 31;
            JSONObject jSONObject = this.f9963b;
            return iHashCode + (jSONObject == null ? 0 : jSONObject.hashCode());
        }

        public String toString() {
            return "CallbackToNative(msgId=" + this.f9962a + ", params=" + this.f9963b + ")";
        }

        public final a a(String msgId, JSONObject jSONObject) {
            kotlin.jvm.internal.k.e(msgId, "msgId");
            return new a(msgId, jSONObject);
        }

        public static /* synthetic */ a a(a aVar, String str, JSONObject jSONObject, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = aVar.f9962a;
            }
            if ((i2 & 2) != 0) {
                jSONObject = aVar.f9963b;
            }
            return aVar.a(str, jSONObject);
        }

        public static final a a(String str) throws JSONException {
            return f9961c.a(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f9964a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f9965b = "msgId";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f9966c = "adId";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f9967d = "params";
        public static final String e = "success";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f9968f = "reason";
        public static final String g = "command";

        private b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f9970b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final JSONObject f9971c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f9972d;

        public c(String adId, String command, JSONObject params) {
            kotlin.jvm.internal.k.e(adId, "adId");
            kotlin.jvm.internal.k.e(command, "command");
            kotlin.jvm.internal.k.e(params, "params");
            this.f9969a = adId;
            this.f9970b = command;
            this.f9971c = params;
            String string = UUID.randomUUID().toString();
            kotlin.jvm.internal.k.d(string, "randomUUID().toString()");
            this.f9972d = string;
        }

        public final String a() {
            return this.f9969a;
        }

        public final String b() {
            return this.f9970b;
        }

        public final JSONObject c() {
            return this.f9971c;
        }

        public final String d() {
            return this.f9969a;
        }

        public final String e() {
            return this.f9970b;
        }

        public boolean equals(Object obj) {
            c cVar = obj instanceof c ? (c) obj : null;
            if (cVar == null) {
                return false;
            }
            if (this == cVar) {
                return true;
            }
            return kotlin.jvm.internal.k.a(this.f9972d, cVar.f9972d) && kotlin.jvm.internal.k.a(this.f9969a, cVar.f9969a) && kotlin.jvm.internal.k.a(this.f9970b, cVar.f9970b) && kotlin.jvm.internal.k.a(this.f9971c.toString(), cVar.f9971c.toString());
        }

        public final String f() {
            return this.f9972d;
        }

        public final JSONObject g() {
            return this.f9971c;
        }

        public final String h() {
            String string = new JSONObject().put(b.f9965b, this.f9972d).put(b.f9966c, this.f9969a).put("params", this.f9971c).toString();
            kotlin.jvm.internal.k.d(string, "JSONObject()\n          .…ms)\n          .toString()");
            return string;
        }

        public int hashCode() {
            return super.hashCode();
        }

        public String toString() {
            String str = this.f9969a;
            String str2 = this.f9970b;
            JSONObject jSONObject = this.f9971c;
            StringBuilder sbZ = a1.a.z("MessageToController(adId=", str, ", command=", str2, ", params=");
            sbZ.append(jSONObject);
            sbZ.append(")");
            return sbZ.toString();
        }

        public final c a(String adId, String command, JSONObject params) {
            kotlin.jvm.internal.k.e(adId, "adId");
            kotlin.jvm.internal.k.e(command, "command");
            kotlin.jvm.internal.k.e(params, "params");
            return new c(adId, command, params);
        }

        public static /* synthetic */ c a(c cVar, String str, String str2, JSONObject jSONObject, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = cVar.f9969a;
            }
            if ((i2 & 2) != 0) {
                str2 = cVar.f9970b;
            }
            if ((i2 & 4) != 0) {
                jSONObject = cVar.f9971c;
            }
            return cVar.a(str, str2, jSONObject);
        }

        public final void a(String str) {
            kotlin.jvm.internal.k.e(str, "<set-?>");
            this.f9972d = str;
        }
    }
}
